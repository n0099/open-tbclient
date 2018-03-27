package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes2.dex */
public class BdSoundGate {
    private static BdSoundGate axu;
    private int axs = -1;
    private int axt;

    private native void close(int i);

    private native int getChanger(int i, float f, float f2, float f3);

    private native int throughMono(int i, short[] sArr, short[] sArr2);

    static {
        System.loadLibrary("sound_gate");
    }

    public static BdSoundGate tb() {
        if (axu == null) {
            axu = new BdSoundGate();
        }
        return axu;
    }

    private BdSoundGate() {
    }

    public void init(int i, int i2) {
        tb().b(i, 0.0f, d.dS(i2), 0.0f);
    }

    public void b(int i, float f, float f2, float f3) {
        this.axt = i;
        this.axs = getChanger(i, f, f2, f3);
    }

    public int getBlockSize() {
        return this.axt;
    }

    public void release() {
        if (this.axs > 0) {
            close(this.axs);
            this.axs = -1;
        }
    }

    public void a(short[] sArr, short[] sArr2) {
        throughMono(this.axs, sArr, sArr2);
    }
}
