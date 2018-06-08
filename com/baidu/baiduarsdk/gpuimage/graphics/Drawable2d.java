package com.baidu.baiduarsdk.gpuimage.graphics;

import java.nio.FloatBuffer;
/* loaded from: classes3.dex */
public class Drawable2d {
    private FloatBuffer q;
    private FloatBuffer r;
    private int s;
    private int t;
    private int u;
    private int v;
    private Prefab w;
    private static final float[] e = {0.0f, 0.57735026f, -0.5f, -0.28867513f, 0.5f, -0.28867513f};
    private static final float[] f = {0.5f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
    private static final FloatBuffer g = a.a(e);
    private static final FloatBuffer h = a.a(f);
    private static final float[] i = {-0.5f, -0.5f, 0.5f, -0.5f, -0.5f, 0.5f, 0.5f, 0.5f};
    private static final float[] j = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
    private static final FloatBuffer k = a.a(i);
    private static final FloatBuffer l = a.a(j);
    private static final float[] m = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
    private static final float[] n = {1.0f, -1.0f, -1.0f, -1.0f, 1.0f, 1.0f, -1.0f, 1.0f};
    private static final float[] o = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
    private static final float[] p = {0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    public static final FloatBuffer a = a.a(m);
    public static final FloatBuffer b = a.a(n);
    public static final FloatBuffer c = a.a(o);
    public static final FloatBuffer d = a.a(p);

    /* loaded from: classes3.dex */
    public enum Prefab {
        TRIANGLE,
        RECTANGLE,
        FULL_RECTANGLE,
        FULL_RECTANGLE_MIRRORED
    }

    public Drawable2d(Prefab prefab) {
        switch (prefab) {
            case TRIANGLE:
                this.q = g;
                this.r = h;
                this.t = 2;
                this.u = this.t * 4;
                this.s = e.length / this.t;
                break;
            case RECTANGLE:
                this.q = k;
                this.r = l;
                this.t = 2;
                this.u = this.t * 4;
                this.s = i.length / this.t;
                break;
            case FULL_RECTANGLE:
                this.q = a;
                this.r = c;
                this.t = 2;
                this.u = this.t * 4;
                this.s = m.length / this.t;
                break;
            case FULL_RECTANGLE_MIRRORED:
                this.q = b;
                this.r = c;
                this.t = 2;
                this.u = this.t * 4;
                this.s = m.length / this.t;
                break;
            default:
                throw new RuntimeException("Unknown shape " + prefab);
        }
        this.v = 8;
        this.w = prefab;
    }

    public FloatBuffer a() {
        return this.q;
    }

    public FloatBuffer b() {
        return this.r;
    }

    public String toString() {
        return this.w != null ? "[Drawable2d: " + this.w + "]" : "[Drawable2d: ...]";
    }
}
