package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes6.dex */
public class BdSoundGate {
    private static BdSoundGate VA;
    private int Vy = -1;
    private int Vz;

    private native void close(int i);

    private native int getChanger(int i, float f, float f2, float f3);

    private native int through(int i, short[] sArr, short[] sArr2);

    private native int throughMono(int i, short[] sArr, short[] sArr2);

    static {
        System.loadLibrary("sound_gate");
    }

    public static BdSoundGate qN() {
        if (VA == null) {
            VA = new BdSoundGate();
        }
        return VA;
    }

    private BdSoundGate() {
    }

    public void init(int i, int i2) {
        qN().a(i, 0.0f, d.bq(i2), 0.0f);
    }

    public void a(int i, float f, float f2, float f3) {
        this.Vz = i;
        this.Vy = getChanger(i, f, f2, f3);
    }

    public int getBlockSize() {
        return this.Vz;
    }

    public void release() {
        if (this.Vy > 0) {
            close(this.Vy);
            this.Vy = -1;
        }
    }

    public void a(short[] sArr, short[] sArr2) {
        throughMono(this.Vy, sArr, sArr2);
    }
}
