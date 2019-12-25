package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes8.dex */
public class BdSoundGate {
    private static BdSoundGate Fd;
    private int Fc = -1;
    private int blockSize;

    private native void close(int i);

    private native int getChanger(int i, float f, float f2, float f3);

    private native int through(int i, short[] sArr, short[] sArr2);

    private native int throughMono(int i, short[] sArr, short[] sArr2);

    static {
        System.loadLibrary("sound_gate");
    }

    public static BdSoundGate lq() {
        if (Fd == null) {
            Fd = new BdSoundGate();
        }
        return Fd;
    }

    private BdSoundGate() {
    }

    public void init(int i, int i2) {
        lq().a(i, 0.0f, d.aB(i2), 0.0f);
    }

    public void a(int i, float f, float f2, float f3) {
        this.blockSize = i;
        this.Fc = getChanger(i, f, f2, f3);
    }

    public int getBlockSize() {
        return this.blockSize;
    }

    public void release() {
        if (this.Fc > 0) {
            close(this.Fc);
            this.Fc = -1;
        }
    }

    public void a(short[] sArr, short[] sArr2) {
        throughMono(this.Fc, sArr, sArr2);
    }
}
