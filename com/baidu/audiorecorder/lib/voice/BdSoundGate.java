package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes.dex */
public class BdSoundGate {
    private static BdSoundGate Ki;
    private int Kh = -1;
    private int uc;

    private native void close(int i);

    private native int getChanger(int i, float f, float f2, float f3);

    private native int throughMono(int i, short[] sArr, short[] sArr2);

    static {
        System.loadLibrary("sound_gate");
    }

    public static BdSoundGate nQ() {
        if (Ki == null) {
            Ki = new BdSoundGate();
        }
        return Ki;
    }

    private BdSoundGate() {
    }

    public void k(int i, int i2) {
        nQ().a(i, 0.0f, f.aH(i2), 0.0f);
    }

    public void a(int i, float f, float f2, float f3) {
        this.uc = i;
        this.Kh = getChanger(i, f, f2, f3);
    }

    public int getBlockSize() {
        return this.uc;
    }

    public void release() {
        if (this.Kh > 0) {
            close(this.Kh);
            this.Kh = -1;
        }
    }

    public void a(short[] sArr, short[] sArr2) {
        throughMono(this.Kh, sArr, sArr2);
    }
}
