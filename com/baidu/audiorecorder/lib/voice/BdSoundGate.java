package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes3.dex */
public class BdSoundGate {
    private static BdSoundGate PT;
    private int PQ = -1;
    private int PR;

    private native void close(int i);

    private native int getChanger(int i, float f, float f2, float f3);

    private native int throughMono(int i, short[] sArr, short[] sArr2);

    static {
        System.loadLibrary("sound_gate");
    }

    public static BdSoundGate ox() {
        if (PT == null) {
            PT = new BdSoundGate();
        }
        return PT;
    }

    private BdSoundGate() {
    }

    public void init(int i, int i2) {
        ox().a(i, 0.0f, d.aX(i2), 0.0f);
    }

    public void a(int i, float f, float f2, float f3) {
        this.PR = i;
        this.PQ = getChanger(i, f, f2, f3);
    }

    public int getBlockSize() {
        return this.PR;
    }

    public void release() {
        if (this.PQ > 0) {
            close(this.PQ);
            this.PQ = -1;
        }
    }

    public void a(short[] sArr, short[] sArr2) {
        throughMono(this.PQ, sArr, sArr2);
    }
}
