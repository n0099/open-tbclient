package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes9.dex */
public class BdSoundGate {
    private static BdSoundGate Fi;
    private int Fh = -1;
    private int blockSize;

    private native void close(int i);

    private native int getChanger(int i, float f, float f2, float f3);

    private native int through(int i, short[] sArr, short[] sArr2);

    private native int throughMono(int i, short[] sArr, short[] sArr2);

    static {
        System.loadLibrary("sound_gate");
    }

    public static BdSoundGate lr() {
        if (Fi == null) {
            Fi = new BdSoundGate();
        }
        return Fi;
    }

    private BdSoundGate() {
    }

    public void init(int i, int i2) {
        lr().a(i, 0.0f, d.aB(i2), 0.0f);
    }

    public void a(int i, float f, float f2, float f3) {
        this.blockSize = i;
        this.Fh = getChanger(i, f, f2, f3);
    }

    public int getBlockSize() {
        return this.blockSize;
    }

    public void release() {
        if (this.Fh > 0) {
            close(this.Fh);
            this.Fh = -1;
        }
    }

    public void a(short[] sArr, short[] sArr2) {
        throughMono(this.Fh, sArr, sArr2);
    }
}
