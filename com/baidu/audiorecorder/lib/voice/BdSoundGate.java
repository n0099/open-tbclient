package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes3.dex */
public class BdSoundGate {
    private static BdSoundGate JF;
    private int JD = -1;
    private int JE;

    private native void close(int i);

    private native int getChanger(int i, float f, float f2, float f3);

    private native int throughMono(int i, short[] sArr, short[] sArr2);

    static {
        System.loadLibrary("sound_gate");
    }

    public static BdSoundGate lH() {
        if (JF == null) {
            JF = new BdSoundGate();
        }
        return JF;
    }

    private BdSoundGate() {
    }

    public void init(int i, int i2) {
        lH().b(i, 0.0f, d.aV(i2), 0.0f);
    }

    public void b(int i, float f, float f2, float f3) {
        this.JE = i;
        this.JD = getChanger(i, f, f2, f3);
    }

    public int getBlockSize() {
        return this.JE;
    }

    public void release() {
        if (this.JD > 0) {
            close(this.JD);
            this.JD = -1;
        }
    }

    public void a(short[] sArr, short[] sArr2) {
        throughMono(this.JD, sArr, sArr2);
    }
}
