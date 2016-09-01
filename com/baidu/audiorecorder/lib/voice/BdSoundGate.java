package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes.dex */
public class BdSoundGate {
    private static BdSoundGate Ep;
    private int En = -1;
    private int Eo;

    private native void close(int i);

    private native int getChanger(int i, float f, float f2, float f3);

    private native int throughMono(int i, short[] sArr, short[] sArr2);

    static {
        System.loadLibrary("sound_gate");
    }

    public static BdSoundGate ln() {
        if (Ep == null) {
            Ep = new BdSoundGate();
        }
        return Ep;
    }

    private BdSoundGate() {
    }

    public void o(int i, int i2) {
        ln().a(i, 0.0f, f.aR(i2), 0.0f);
    }

    public void a(int i, float f, float f2, float f3) {
        this.Eo = i;
        this.En = getChanger(i, f, f2, f3);
    }

    public int getBlockSize() {
        return this.Eo;
    }

    public void release() {
        if (this.En > 0) {
            close(this.En);
            this.En = -1;
        }
    }

    public void a(short[] sArr, short[] sArr2) {
        throughMono(this.En, sArr, sArr2);
    }
}
