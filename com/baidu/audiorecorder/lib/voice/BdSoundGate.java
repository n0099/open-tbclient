package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes.dex */
public class BdSoundGate {
    private static BdSoundGate Er;
    private int Ep = -1;
    private int Eq;

    private native void close(int i);

    private native int getChanger(int i, float f, float f2, float f3);

    private native int throughMono(int i, short[] sArr, short[] sArr2);

    static {
        System.loadLibrary("sound_gate");
    }

    public static BdSoundGate lq() {
        if (Er == null) {
            Er = new BdSoundGate();
        }
        return Er;
    }

    private BdSoundGate() {
    }

    public void o(int i, int i2) {
        lq().a(i, 0.0f, f.aR(i2), 0.0f);
    }

    public void a(int i, float f, float f2, float f3) {
        this.Eq = i;
        this.Ep = getChanger(i, f, f2, f3);
    }

    public int getBlockSize() {
        return this.Eq;
    }

    public void release() {
        if (this.Ep > 0) {
            close(this.Ep);
            this.Ep = -1;
        }
    }

    public void a(short[] sArr, short[] sArr2) {
        throughMono(this.Ep, sArr, sArr2);
    }
}
