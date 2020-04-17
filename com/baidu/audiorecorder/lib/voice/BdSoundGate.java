package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes11.dex */
public class BdSoundGate {
    private static BdSoundGate YN;
    private int YM = -1;
    private int blockSize;

    private native void close(int i);

    private native int getChanger(int i, float f, float f2, float f3);

    private native int through(int i, short[] sArr, short[] sArr2);

    private native int throughMono(int i, short[] sArr, short[] sArr2);

    static {
        System.loadLibrary("sound_gate");
    }

    public static BdSoundGate qi() {
        if (YN == null) {
            YN = new BdSoundGate();
        }
        return YN;
    }

    private BdSoundGate() {
    }

    public void init(int i, int i2) {
        qi().a(i, 0.0f, d.aQ(i2), 0.0f);
    }

    public void a(int i, float f, float f2, float f3) {
        this.blockSize = i;
        this.YM = getChanger(i, f, f2, f3);
    }

    public int getBlockSize() {
        return this.blockSize;
    }

    public void release() {
        if (this.YM > 0) {
            close(this.YM);
            this.YM = -1;
        }
    }

    public void a(short[] sArr, short[] sArr2) {
        throughMono(this.YM, sArr, sArr2);
    }
}
