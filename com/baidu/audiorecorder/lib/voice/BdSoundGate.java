package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes18.dex */
public class BdSoundGate {
    private static BdSoundGate ZF;
    private int ZE = -1;
    private int blockSize;

    private native void close(int i);

    private native int getChanger(int i, float f, float f2, float f3);

    private native int through(int i, short[] sArr, short[] sArr2);

    private native int throughMono(int i, short[] sArr, short[] sArr2);

    static {
        System.loadLibrary("sound_gate");
    }

    public static BdSoundGate qI() {
        if (ZF == null) {
            ZF = new BdSoundGate();
        }
        return ZF;
    }

    private BdSoundGate() {
    }

    public void init(int i, int i2) {
        qI().a(i, 0.0f, d.ba(i2), 0.0f);
    }

    public void a(int i, float f, float f2, float f3) {
        this.blockSize = i;
        this.ZE = getChanger(i, f, f2, f3);
    }

    public int getBlockSize() {
        return this.blockSize;
    }

    public void release() {
        if (this.ZE > 0) {
            close(this.ZE);
            this.ZE = -1;
        }
    }

    public void a(short[] sArr, short[] sArr2) {
        throughMono(this.ZE, sArr, sArr2);
    }
}
