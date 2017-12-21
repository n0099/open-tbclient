package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes2.dex */
public class BdSoundGate {
    private static BdSoundGate IF;
    private int IC = -1;
    private int IE;

    private native void close(int i);

    private native int getChanger(int i, float f, float f2, float f3);

    private native int throughMono(int i, short[] sArr, short[] sArr2);

    static {
        System.loadLibrary("sound_gate");
    }

    public static BdSoundGate ly() {
        if (IF == null) {
            IF = new BdSoundGate();
        }
        return IF;
    }

    private BdSoundGate() {
    }

    public void init(int i, int i2) {
        ly().a(i, 0.0f, d.aP(i2), 0.0f);
    }

    public void a(int i, float f, float f2, float f3) {
        this.IE = i;
        this.IC = getChanger(i, f, f2, f3);
    }

    public int getBlockSize() {
        return this.IE;
    }

    public void release() {
        if (this.IC > 0) {
            close(this.IC);
            this.IC = -1;
        }
    }

    public void a(short[] sArr, short[] sArr2) {
        throughMono(this.IC, sArr, sArr2);
    }
}
