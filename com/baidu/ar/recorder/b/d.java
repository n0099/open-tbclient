package com.baidu.ar.recorder.b;

import android.graphics.Rect;
/* loaded from: classes3.dex */
public class d implements Cloneable {
    private int a = 720;
    private int b = 1280;
    private int c = 720;
    private int d = 1280;
    private Rect e = new Rect(0, 0, this.c, this.d);
    private int f = 2;
    private int g = 0;
    private boolean h = false;
    private float i = 1.0f;
    private float j = 1.0f;
    private int k = 0;

    public int a() {
        return this.c;
    }

    public void a(int i) {
        this.c = i;
    }

    public void a(Rect rect) {
        this.e = rect;
    }

    public int b() {
        return this.d;
    }

    public void b(int i) {
        this.d = i;
    }

    public int c() {
        return this.g;
    }

    public void c(int i) {
        this.g = i;
    }

    public Object clone() {
        d dVar;
        try {
            dVar = (d) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            dVar = null;
        }
        dVar.a(new Rect(this.e));
        return dVar;
    }

    public float d() {
        return this.i;
    }

    public float e() {
        return this.j;
    }

    public int f() {
        return this.k;
    }
}
