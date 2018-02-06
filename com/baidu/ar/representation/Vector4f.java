package com.baidu.ar.representation;

import java.io.Serializable;
/* loaded from: classes3.dex */
public class Vector4f extends Renderable implements Serializable {
    private static final long serialVersionUID = 1;
    protected float[] points = {0.0f, 0.0f, 0.0f, 0.0f};

    public Vector4f() {
        this.points[0] = 0.0f;
        this.points[1] = 0.0f;
        this.points[2] = 0.0f;
        this.points[3] = 0.0f;
    }

    public void a(float f) {
        this.points[0] = f;
    }

    public void a(float f, float f2, float f3, float f4) {
        this.points[0] = f;
        this.points[1] = f2;
        this.points[2] = f3;
        this.points[3] = f4;
    }

    public void a(Vector4f vector4f) {
        this.points[0] = vector4f.points[0];
        this.points[1] = vector4f.points[1];
        this.points[2] = vector4f.points[2];
        this.points[3] = vector4f.points[3];
    }

    public float b(Vector4f vector4f) {
        return (this.points[0] * vector4f.points[0]) + (this.points[1] * vector4f.points[1]) + (this.points[2] * vector4f.points[2]) + (this.points[3] * vector4f.points[3]);
    }

    public void b(float f) {
        this.points[1] = f;
    }

    public void c(float f) {
        this.points[2] = f;
    }

    public float[] c() {
        return this.points;
    }

    public float d() {
        return this.points[0];
    }

    public void d(float f) {
        this.points[3] = f;
    }

    public float e() {
        return this.points[1];
    }

    public void e(float f) {
        this.points[3] = f;
    }

    public float f() {
        return this.points[2];
    }

    public float g() {
        return this.points[3];
    }

    public float h() {
        return this.points[3];
    }

    public String toString() {
        return "X:" + this.points[0] + " Y:" + this.points[1] + " Z:" + this.points[2] + " W:" + this.points[3];
    }
}
