package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes.dex */
public class BdSoundGate {
    private static BdSoundGate KR;
    private int KP = -1;
    private int KQ;

    private native void close(int i);

    private native int getChanger(int i, float f, float f2, float f3);

    private native int throughMono(int i, short[] sArr, short[] sArr2);

    static {
        System.loadLibrary("sound_gate");
    }

    public static BdSoundGate mc() {
        if (KR == null) {
            KR = new BdSoundGate();
        }
        return KR;
    }

    private BdSoundGate() {
    }

    public void init(int i, int i2) {
        mc().a(i, 0.0f, f.aR(i2), 0.0f);
    }

    public void a(int i, float f, float f2, float f3) {
        this.KQ = i;
        this.KP = getChanger(i, f, f2, f3);
    }

    public int getBlockSize() {
        return this.KQ;
    }

    public void release() {
        if (this.KP > 0) {
            close(this.KP);
            this.KP = -1;
        }
    }

    public void a(short[] sArr, short[] sArr2) {
        throughMono(this.KP, sArr, sArr2);
    }
}
