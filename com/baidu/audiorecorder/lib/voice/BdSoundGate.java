package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes.dex */
public class BdSoundGate {
    private static BdSoundGate Es;
    private int Eq = -1;
    private int Er;

    private native void close(int i);

    private native int getChanger(int i, float f, float f2, float f3);

    private native int throughMono(int i, short[] sArr, short[] sArr2);

    static {
        System.loadLibrary("sound_gate");
    }

    public static BdSoundGate lq() {
        if (Es == null) {
            Es = new BdSoundGate();
        }
        return Es;
    }

    private BdSoundGate() {
    }

    public void o(int i, int i2) {
        lq().a(i, 0.0f, f.aS(i2), 0.0f);
    }

    public void a(int i, float f, float f2, float f3) {
        this.Er = i;
        this.Eq = getChanger(i, f, f2, f3);
    }

    public int getBlockSize() {
        return this.Er;
    }

    public void release() {
        if (this.Eq > 0) {
            close(this.Eq);
            this.Eq = -1;
        }
    }

    public void a(short[] sArr, short[] sArr2) {
        throughMono(this.Eq, sArr, sArr2);
    }
}
