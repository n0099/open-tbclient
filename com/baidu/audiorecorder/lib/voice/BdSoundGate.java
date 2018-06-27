package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes3.dex */
public class BdSoundGate {
    private static BdSoundGate PV;
    private int PT = -1;
    private int PU;

    private native void close(int i);

    private native int getChanger(int i, float f, float f2, float f3);

    private native int throughMono(int i, short[] sArr, short[] sArr2);

    static {
        System.loadLibrary("sound_gate");
    }

    public static BdSoundGate ox() {
        if (PV == null) {
            PV = new BdSoundGate();
        }
        return PV;
    }

    private BdSoundGate() {
    }

    public void init(int i, int i2) {
        ox().a(i, 0.0f, d.aX(i2), 0.0f);
    }

    public void a(int i, float f, float f2, float f3) {
        this.PU = i;
        this.PT = getChanger(i, f, f2, f3);
    }

    public int getBlockSize() {
        return this.PU;
    }

    public void release() {
        if (this.PT > 0) {
            close(this.PT);
            this.PT = -1;
        }
    }

    public void a(short[] sArr, short[] sArr2) {
        throughMono(this.PT, sArr, sArr2);
    }
}
