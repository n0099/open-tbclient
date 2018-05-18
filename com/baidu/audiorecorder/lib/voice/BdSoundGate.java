package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes3.dex */
public class BdSoundGate {
    private static BdSoundGate JB;
    private int JA;
    private int Jz = -1;

    private native void close(int i);

    private native int getChanger(int i, float f, float f2, float f3);

    private native int throughMono(int i, short[] sArr, short[] sArr2);

    static {
        System.loadLibrary("sound_gate");
    }

    public static BdSoundGate lG() {
        if (JB == null) {
            JB = new BdSoundGate();
        }
        return JB;
    }

    private BdSoundGate() {
    }

    public void init(int i, int i2) {
        lG().b(i, 0.0f, d.aV(i2), 0.0f);
    }

    public void b(int i, float f, float f2, float f3) {
        this.JA = i;
        this.Jz = getChanger(i, f, f2, f3);
    }

    public int getBlockSize() {
        return this.JA;
    }

    public void release() {
        if (this.Jz > 0) {
            close(this.Jz);
            this.Jz = -1;
        }
    }

    public void a(short[] sArr, short[] sArr2) {
        throughMono(this.Jz, sArr, sArr2);
    }
}
