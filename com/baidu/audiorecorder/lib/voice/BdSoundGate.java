package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes.dex */
public class BdSoundGate {
    private static BdSoundGate DD;
    private int DA = -1;
    private int DC;

    private native void close(int i);

    private native int getChanger(int i, float f, float f2, float f3);

    private native int throughMono(int i, short[] sArr, short[] sArr2);

    static {
        System.loadLibrary("sound_gate");
    }

    public static BdSoundGate li() {
        if (DD == null) {
            DD = new BdSoundGate();
        }
        return DD;
    }

    private BdSoundGate() {
    }

    public void p(int i, int i2) {
        li().a(i, 0.0f, f.aR(i2), 0.0f);
    }

    public void a(int i, float f, float f2, float f3) {
        this.DC = i;
        this.DA = getChanger(i, f, f2, f3);
    }

    public int getBlockSize() {
        return this.DC;
    }

    public void release() {
        if (this.DA > 0) {
            close(this.DA);
            this.DA = -1;
        }
    }

    public void a(short[] sArr, short[] sArr2) {
        throughMono(this.DA, sArr, sArr2);
    }
}
