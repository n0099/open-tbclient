package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes2.dex */
public class BdSoundGate {
    private static BdSoundGate IE;
    private int IB = -1;
    private int IC;

    private native void close(int i);

    private native int getChanger(int i, float f, float f2, float f3);

    private native int throughMono(int i, short[] sArr, short[] sArr2);

    static {
        System.loadLibrary("sound_gate");
    }

    public static BdSoundGate ly() {
        if (IE == null) {
            IE = new BdSoundGate();
        }
        return IE;
    }

    private BdSoundGate() {
    }

    public void init(int i, int i2) {
        ly().a(i, 0.0f, d.aP(i2), 0.0f);
    }

    public void a(int i, float f, float f2, float f3) {
        this.IC = i;
        this.IB = getChanger(i, f, f2, f3);
    }

    public int getBlockSize() {
        return this.IC;
    }

    public void release() {
        if (this.IB > 0) {
            close(this.IB);
            this.IB = -1;
        }
    }

    public void a(short[] sArr, short[] sArr2) {
        throughMono(this.IB, sArr, sArr2);
    }
}
