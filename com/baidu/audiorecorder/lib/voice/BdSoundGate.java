package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes2.dex */
public class BdSoundGate {
    private static BdSoundGate IG;
    private int IE = -1;
    private int IF;

    private native void close(int i);

    private native int getChanger(int i, float f, float f2, float f3);

    private native int throughMono(int i, short[] sArr, short[] sArr2);

    static {
        System.loadLibrary("sound_gate");
    }

    public static BdSoundGate ly() {
        if (IG == null) {
            IG = new BdSoundGate();
        }
        return IG;
    }

    private BdSoundGate() {
    }

    public void init(int i, int i2) {
        ly().a(i, 0.0f, d.aQ(i2), 0.0f);
    }

    public void a(int i, float f, float f2, float f3) {
        this.IF = i;
        this.IE = getChanger(i, f, f2, f3);
    }

    public int getBlockSize() {
        return this.IF;
    }

    public void release() {
        if (this.IE > 0) {
            close(this.IE);
            this.IE = -1;
        }
    }

    public void a(short[] sArr, short[] sArr2) {
        throughMono(this.IE, sArr, sArr2);
    }
}
