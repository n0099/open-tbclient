package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes.dex */
public class BdSoundGate {
    private static BdSoundGate Cc;
    private int Ca = -1;
    private int Cb;

    private native void close(int i);

    private native int getChanger(int i, float f, float f2, float f3);

    private native int throughMono(int i, short[] sArr, short[] sArr2);

    static {
        System.loadLibrary("sound_gate");
    }

    public static BdSoundGate ks() {
        if (Cc == null) {
            Cc = new BdSoundGate();
        }
        return Cc;
    }

    private BdSoundGate() {
    }

    public void m(int i, int i2) {
        ks().a(i, 0.0f, f.aE(i2), 0.0f);
    }

    public void a(int i, float f, float f2, float f3) {
        this.Cb = i;
        this.Ca = getChanger(i, f, f2, f3);
    }

    public int getBlockSize() {
        return this.Cb;
    }

    public void release() {
        if (this.Ca > 0) {
            close(this.Ca);
            this.Ca = -1;
        }
    }

    public void a(short[] sArr, short[] sArr2) {
        throughMono(this.Ca, sArr, sArr2);
    }
}
