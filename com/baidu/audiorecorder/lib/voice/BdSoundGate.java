package com.baidu.audiorecorder.lib.voice;

import d.b.f.a.a.d;
/* loaded from: classes2.dex */
public class BdSoundGate {

    /* renamed from: c  reason: collision with root package name */
    public static BdSoundGate f4231c;

    /* renamed from: a  reason: collision with root package name */
    public int f4232a = -1;

    /* renamed from: b  reason: collision with root package name */
    public int f4233b;

    static {
        System.loadLibrary("sound_gate");
    }

    public static BdSoundGate b() {
        if (f4231c == null) {
            f4231c = new BdSoundGate();
        }
        return f4231c;
    }

    private native void close(int i);

    private native int getChanger(int i, float f2, float f3, float f4);

    private native int through(int i, short[] sArr, short[] sArr2);

    private native int throughMono(int i, short[] sArr, short[] sArr2);

    public int a() {
        return this.f4233b;
    }

    public void c(int i, float f2, float f3, float f4) {
        this.f4233b = i;
        this.f4232a = getChanger(i, f2, f3, f4);
    }

    public void d(int i, int i2) {
        b().c(i, 0.0f, d.a(i2), 0.0f);
    }

    public void e() {
        int i = this.f4232a;
        if (i > 0) {
            close(i);
            this.f4232a = -1;
        }
    }

    public void f(short[] sArr, short[] sArr2) {
        throughMono(this.f4232a, sArr, sArr2);
    }
}
