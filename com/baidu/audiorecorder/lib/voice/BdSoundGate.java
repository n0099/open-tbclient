package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes6.dex */
public class BdSoundGate {
    private static BdSoundGate Tn;
    private int Tl = -1;
    private int Tm;

    private native void close(int i);

    private native int getChanger(int i, float f, float f2, float f3);

    private native int through(int i, short[] sArr, short[] sArr2);

    private native int throughMono(int i, short[] sArr, short[] sArr2);

    static {
        System.loadLibrary("sound_gate");
    }

    public static BdSoundGate pI() {
        if (Tn == null) {
            Tn = new BdSoundGate();
        }
        return Tn;
    }

    private BdSoundGate() {
    }

    public void init(int i, int i2) {
        pI().a(i, 0.0f, d.bj(i2), 0.0f);
    }

    public void a(int i, float f, float f2, float f3) {
        this.Tm = i;
        this.Tl = getChanger(i, f, f2, f3);
    }

    public int getBlockSize() {
        return this.Tm;
    }

    public void release() {
        if (this.Tl > 0) {
            close(this.Tl);
            this.Tl = -1;
        }
    }

    public void a(short[] sArr, short[] sArr2) {
        throughMono(this.Tl, sArr, sArr2);
    }
}
