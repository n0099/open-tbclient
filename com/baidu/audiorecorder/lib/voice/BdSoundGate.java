package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes3.dex */
public class BdSoundGate {
    private static BdSoundGate SL;
    private int SJ = -1;
    private int SK;

    private native void close(int i);

    private native int getChanger(int i, float f, float f2, float f3);

    private native int through(int i, short[] sArr, short[] sArr2);

    private native int throughMono(int i, short[] sArr, short[] sArr2);

    static {
        System.loadLibrary("sound_gate");
    }

    public static BdSoundGate pI() {
        if (SL == null) {
            SL = new BdSoundGate();
        }
        return SL;
    }

    private BdSoundGate() {
    }

    public void init(int i, int i2) {
        pI().a(i, 0.0f, d.bx(i2), 0.0f);
    }

    public void a(int i, float f, float f2, float f3) {
        this.SK = i;
        this.SJ = getChanger(i, f, f2, f3);
    }

    public int getBlockSize() {
        return this.SK;
    }

    public void release() {
        if (this.SJ > 0) {
            close(this.SJ);
            this.SJ = -1;
        }
    }

    public void a(short[] sArr, short[] sArr2) {
        throughMono(this.SJ, sArr, sArr2);
    }
}
