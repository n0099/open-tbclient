package com.baidu.adp.lib.voice;
/* loaded from: classes.dex */
public class BdSoundGate {
    private static BdSoundGate c;
    private int a = -1;
    private int b;

    private native void close(int i);

    private native int getChanger(int i, float f, float f2, float f3);

    private native int throughMono(int i, short[] sArr, short[] sArr2);

    static {
        System.loadLibrary("sound_gate");
    }

    public static BdSoundGate a() {
        if (c == null) {
            c = new BdSoundGate();
        }
        return c;
    }

    private BdSoundGate() {
    }

    public static void a(int i, int i2) {
        float f;
        switch (i2) {
            case 1:
                f = 6.6f;
                break;
            case 2:
                f = -7.7f;
                break;
            case 3:
                f = 5.5f;
                break;
            default:
                f = 0.0f;
                break;
        }
        BdSoundGate a = a();
        a.b = 1600;
        a.a = a.getChanger(1600, 0.0f, f, 0.0f);
    }

    public final int b() {
        return this.b;
    }

    public final void c() {
        if (this.a > 0) {
            close(this.a);
            this.a = -1;
        }
    }

    public final void a(short[] sArr, short[] sArr2) {
        throughMono(this.a, sArr, sArr2);
    }
}
