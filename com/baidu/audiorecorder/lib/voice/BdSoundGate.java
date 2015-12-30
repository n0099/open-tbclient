package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes.dex */
public class BdSoundGate {
    private static BdSoundGate KO;
    private int KM = -1;
    private int KN;

    private native void close(int i);

    private native int getChanger(int i, float f, float f2, float f3);

    private native int throughMono(int i, short[] sArr, short[] sArr2);

    static {
        System.loadLibrary("sound_gate");
    }

    public static BdSoundGate nT() {
        if (KO == null) {
            KO = new BdSoundGate();
        }
        return KO;
    }

    private BdSoundGate() {
    }

    public void l(int i, int i2) {
        nT().a(i, 0.0f, f.aB(i2), 0.0f);
    }

    public void a(int i, float f, float f2, float f3) {
        this.KN = i;
        this.KM = getChanger(i, f, f2, f3);
    }

    public int getBlockSize() {
        return this.KN;
    }

    public void release() {
        if (this.KM > 0) {
            close(this.KM);
            this.KM = -1;
        }
    }

    public void a(short[] sArr, short[] sArr2) {
        throughMono(this.KM, sArr, sArr2);
    }
}
