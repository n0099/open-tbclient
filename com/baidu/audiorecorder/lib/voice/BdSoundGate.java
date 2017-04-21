package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes.dex */
public class BdSoundGate {
    private static BdSoundGate Ku;
    private int Ks = -1;
    private int Kt;

    private native void close(int i);

    private native int getChanger(int i, float f, float f2, float f3);

    private native int throughMono(int i, short[] sArr, short[] sArr2);

    static {
        System.loadLibrary("sound_gate");
    }

    public static BdSoundGate mh() {
        if (Ku == null) {
            Ku = new BdSoundGate();
        }
        return Ku;
    }

    private BdSoundGate() {
    }

    public void init(int i, int i2) {
        mh().a(i, 0.0f, f.aQ(i2), 0.0f);
    }

    public void a(int i, float f, float f2, float f3) {
        this.Kt = i;
        this.Ks = getChanger(i, f, f2, f3);
    }

    public int getBlockSize() {
        return this.Kt;
    }

    public void release() {
        if (this.Ks > 0) {
            close(this.Ks);
            this.Ks = -1;
        }
    }

    public void a(short[] sArr, short[] sArr2) {
        throughMono(this.Ks, sArr, sArr2);
    }
}
