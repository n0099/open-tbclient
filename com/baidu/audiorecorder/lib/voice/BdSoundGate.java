package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes3.dex */
public class BdSoundGate {
    private static BdSoundGate PR;
    private int PP = -1;
    private int PQ;

    private native void close(int i);

    private native int getChanger(int i, float f, float f2, float f3);

    private native int throughMono(int i, short[] sArr, short[] sArr2);

    static {
        System.loadLibrary("sound_gate");
    }

    public static BdSoundGate oz() {
        if (PR == null) {
            PR = new BdSoundGate();
        }
        return PR;
    }

    private BdSoundGate() {
    }

    public void init(int i, int i2) {
        oz().a(i, 0.0f, d.aY(i2), 0.0f);
    }

    public void a(int i, float f, float f2, float f3) {
        this.PQ = i;
        this.PP = getChanger(i, f, f2, f3);
    }

    public int getBlockSize() {
        return this.PQ;
    }

    public void release() {
        if (this.PP > 0) {
            close(this.PP);
            this.PP = -1;
        }
    }

    public void a(short[] sArr, short[] sArr2) {
        throughMono(this.PP, sArr, sArr2);
    }
}
