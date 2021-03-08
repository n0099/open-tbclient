package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes7.dex */
public class BdSoundGate {
    private static BdSoundGate adX;
    private int adW = -1;
    private int blockSize;

    private native void close(int i);

    private native int getChanger(int i, float f, float f2, float f3);

    private native int through(int i, short[] sArr, short[] sArr2);

    private native int throughMono(int i, short[] sArr, short[] sArr2);

    static {
        System.loadLibrary("sound_gate");
    }

    public static BdSoundGate rN() {
        if (adX == null) {
            adX = new BdSoundGate();
        }
        return adX;
    }

    private BdSoundGate() {
    }

    public void init(int i, int i2) {
        rN().a(i, 0.0f, d.bm(i2), 0.0f);
    }

    public void a(int i, float f, float f2, float f3) {
        this.blockSize = i;
        this.adW = getChanger(i, f, f2, f3);
    }

    public int getBlockSize() {
        return this.blockSize;
    }

    public void release() {
        if (this.adW > 0) {
            close(this.adW);
            this.adW = -1;
        }
    }

    public void a(short[] sArr, short[] sArr2) {
        throughMono(this.adW, sArr, sArr2);
    }
}
