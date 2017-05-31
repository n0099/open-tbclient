package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes2.dex */
public class BdSoundGate {
    private static BdSoundGate JA;
    private int Jy = -1;
    private int Jz;

    private native void close(int i);

    private native int getChanger(int i, float f, float f2, float f3);

    private native int throughMono(int i, short[] sArr, short[] sArr2);

    static {
        System.loadLibrary("sound_gate");
    }

    public static BdSoundGate lG() {
        if (JA == null) {
            JA = new BdSoundGate();
        }
        return JA;
    }

    private BdSoundGate() {
    }

    public void init(int i, int i2) {
        lG().a(i, 0.0f, f.aO(i2), 0.0f);
    }

    public void a(int i, float f, float f2, float f3) {
        this.Jz = i;
        this.Jy = getChanger(i, f, f2, f3);
    }

    public int getBlockSize() {
        return this.Jz;
    }

    public void release() {
        if (this.Jy > 0) {
            close(this.Jy);
            this.Jy = -1;
        }
    }

    public void a(short[] sArr, short[] sArr2) {
        throughMono(this.Jy, sArr, sArr2);
    }
}
