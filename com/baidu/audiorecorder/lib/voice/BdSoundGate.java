package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes6.dex */
public class BdSoundGate {
    private static BdSoundGate TF;
    private int TC = -1;
    private int TD;

    private native void close(int i);

    private native int getChanger(int i, float f, float f2, float f3);

    private native int through(int i, short[] sArr, short[] sArr2);

    private native int throughMono(int i, short[] sArr, short[] sArr2);

    static {
        System.loadLibrary("sound_gate");
    }

    public static BdSoundGate qe() {
        if (TF == null) {
            TF = new BdSoundGate();
        }
        return TF;
    }

    private BdSoundGate() {
    }

    public void init(int i, int i2) {
        qe().a(i, 0.0f, d.bj(i2), 0.0f);
    }

    public void a(int i, float f, float f2, float f3) {
        this.TD = i;
        this.TC = getChanger(i, f, f2, f3);
    }

    public int qf() {
        return this.TD;
    }

    public void release() {
        if (this.TC > 0) {
            close(this.TC);
            this.TC = -1;
        }
    }

    public void a(short[] sArr, short[] sArr2) {
        throughMono(this.TC, sArr, sArr2);
    }
}
