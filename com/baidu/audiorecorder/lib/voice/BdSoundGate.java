package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes.dex */
public class BdSoundGate {
    private static BdSoundGate Kk;
    private int Kj = -1;
    private int uc;

    private native void close(int i);

    private native int getChanger(int i, float f, float f2, float f3);

    private native int throughMono(int i, short[] sArr, short[] sArr2);

    static {
        System.loadLibrary("sound_gate");
    }

    public static BdSoundGate nQ() {
        if (Kk == null) {
            Kk = new BdSoundGate();
        }
        return Kk;
    }

    private BdSoundGate() {
    }

    public void k(int i, int i2) {
        nQ().a(i, 0.0f, f.aH(i2), 0.0f);
    }

    public void a(int i, float f, float f2, float f3) {
        this.uc = i;
        this.Kj = getChanger(i, f, f2, f3);
    }

    public int getBlockSize() {
        return this.uc;
    }

    public void release() {
        if (this.Kj > 0) {
            close(this.Kj);
            this.Kj = -1;
        }
    }

    public void a(short[] sArr, short[] sArr2) {
        throughMono(this.Kj, sArr, sArr2);
    }
}
