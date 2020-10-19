package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes24.dex */
public class BdSoundGate {
    private static BdSoundGate aaV;
    private int aaU = -1;
    private int blockSize;

    private native void close(int i);

    private native int getChanger(int i, float f, float f2, float f3);

    private native int through(int i, short[] sArr, short[] sArr2);

    private native int throughMono(int i, short[] sArr, short[] sArr2);

    static {
        System.loadLibrary("sound_gate");
    }

    public static BdSoundGate sm() {
        if (aaV == null) {
            aaV = new BdSoundGate();
        }
        return aaV;
    }

    private BdSoundGate() {
    }

    public void init(int i, int i2) {
        sm().a(i, 0.0f, d.bh(i2), 0.0f);
    }

    public void a(int i, float f, float f2, float f3) {
        this.blockSize = i;
        this.aaU = getChanger(i, f, f2, f3);
    }

    public int getBlockSize() {
        return this.blockSize;
    }

    public void release() {
        if (this.aaU > 0) {
            close(this.aaU);
            this.aaU = -1;
        }
    }

    public void a(short[] sArr, short[] sArr2) {
        throughMono(this.aaU, sArr, sArr2);
    }
}
