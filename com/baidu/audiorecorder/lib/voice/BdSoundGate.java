package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes.dex */
public class BdSoundGate {
    private static BdSoundGate Ks;
    private int Kq = -1;
    private int Kr;

    private native void close(int i);

    private native int getChanger(int i, float f, float f2, float f3);

    private native int throughMono(int i, short[] sArr, short[] sArr2);

    static {
        System.loadLibrary("sound_gate");
    }

    public static BdSoundGate mg() {
        if (Ks == null) {
            Ks = new BdSoundGate();
        }
        return Ks;
    }

    private BdSoundGate() {
    }

    public void init(int i, int i2) {
        mg().a(i, 0.0f, f.aQ(i2), 0.0f);
    }

    public void a(int i, float f, float f2, float f3) {
        this.Kr = i;
        this.Kq = getChanger(i, f, f2, f3);
    }

    public int getBlockSize() {
        return this.Kr;
    }

    public void release() {
        if (this.Kq > 0) {
            close(this.Kq);
            this.Kq = -1;
        }
    }

    public void a(short[] sArr, short[] sArr2) {
        throughMono(this.Kq, sArr, sArr2);
    }
}
