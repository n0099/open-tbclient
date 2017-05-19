package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes2.dex */
public class BdSoundGate {
    private static BdSoundGate JM;
    private int JK = -1;
    private int JL;

    private native void close(int i);

    private native int getChanger(int i, float f, float f2, float f3);

    private native int throughMono(int i, short[] sArr, short[] sArr2);

    static {
        System.loadLibrary("sound_gate");
    }

    public static BdSoundGate lO() {
        if (JM == null) {
            JM = new BdSoundGate();
        }
        return JM;
    }

    private BdSoundGate() {
    }

    public void init(int i, int i2) {
        lO().a(i, 0.0f, f.aN(i2), 0.0f);
    }

    public void a(int i, float f, float f2, float f3) {
        this.JL = i;
        this.JK = getChanger(i, f, f2, f3);
    }

    public int getBlockSize() {
        return this.JL;
    }

    public void release() {
        if (this.JK > 0) {
            close(this.JK);
            this.JK = -1;
        }
    }

    public void a(short[] sArr, short[] sArr2) {
        throughMono(this.JK, sArr, sArr2);
    }
}
