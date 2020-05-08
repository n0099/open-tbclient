package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes11.dex */
public class BdSoundGate {
    private static BdSoundGate YQ;
    private int YP = -1;
    private int blockSize;

    private native void close(int i);

    private native int getChanger(int i, float f, float f2, float f3);

    private native int through(int i, short[] sArr, short[] sArr2);

    private native int throughMono(int i, short[] sArr, short[] sArr2);

    static {
        System.loadLibrary("sound_gate");
    }

    public static BdSoundGate qi() {
        if (YQ == null) {
            YQ = new BdSoundGate();
        }
        return YQ;
    }

    private BdSoundGate() {
    }

    public void init(int i, int i2) {
        qi().a(i, 0.0f, d.aQ(i2), 0.0f);
    }

    public void a(int i, float f, float f2, float f3) {
        this.blockSize = i;
        this.YP = getChanger(i, f, f2, f3);
    }

    public int getBlockSize() {
        return this.blockSize;
    }

    public void release() {
        if (this.YP > 0) {
            close(this.YP);
            this.YP = -1;
        }
    }

    public void a(short[] sArr, short[] sArr2) {
        throughMono(this.YP, sArr, sArr2);
    }
}
