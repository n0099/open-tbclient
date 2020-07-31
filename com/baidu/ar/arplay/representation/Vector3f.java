package com.baidu.ar.arplay.representation;
/* loaded from: classes11.dex */
public class Vector3f extends Renderable {
    private static final long serialVersionUID = -4565578579900616220L;
    protected float[] points;

    public Vector3f() {
        this.points = new float[3];
    }

    public Vector3f(float f) {
        this.points = new float[3];
        this.points[0] = f;
        this.points[1] = f;
        this.points[2] = f;
    }

    public Vector3f(float f, float f2, float f3) {
        this.points = new float[3];
        this.points[0] = f;
        this.points[1] = f2;
        this.points[2] = f3;
    }

    public Vector3f(Vector3f vector3f) {
        this.points = new float[3];
        this.points[0] = vector3f.points[0];
        this.points[1] = vector3f.points[1];
        this.points[2] = vector3f.points[2];
    }

    public Vector3f(Vector4f vector4f) {
        this.points = new float[3];
        if (vector4f.w() != 0.0f) {
            this.points[0] = vector4f.x() / vector4f.w();
            this.points[1] = vector4f.y() / vector4f.w();
            this.points[2] = vector4f.z() / vector4f.w();
            return;
        }
        this.points[0] = vector4f.x();
        this.points[1] = vector4f.y();
        this.points[2] = vector4f.z();
    }

    public void add(float f) {
        float[] fArr = this.points;
        fArr[0] = fArr[0] + f;
        float[] fArr2 = this.points;
        fArr2[1] = fArr2[1] + f;
        float[] fArr3 = this.points;
        fArr3[2] = fArr3[2] + f;
    }

    public void add(Vector3f vector3f) {
        float[] fArr = this.points;
        fArr[0] = fArr[0] + vector3f.points[0];
        float[] fArr2 = this.points;
        fArr2[1] = fArr2[1] + vector3f.points[1];
        float[] fArr3 = this.points;
        fArr3[2] = fArr3[2] + vector3f.points[2];
    }

    public void clone(Vector3f vector3f) {
        System.arraycopy(vector3f.points, 0, this.points, 0, 3);
    }

    public void clone(float[] fArr) {
        System.arraycopy(fArr, 0, this.points, 0, 3);
    }

    public Vector3f crossProduct(Vector3f vector3f) {
        Vector3f vector3f2 = new Vector3f();
        crossProduct(vector3f, vector3f2);
        return vector3f2;
    }

    public void crossProduct(Vector3f vector3f, Vector3f vector3f2) {
        vector3f2.setX((this.points[1] * vector3f.points[2]) - (this.points[2] * vector3f.points[1]));
        vector3f2.setY((this.points[2] * vector3f.points[0]) - (this.points[0] * vector3f.points[2]));
        vector3f2.setZ((this.points[0] * vector3f.points[1]) - (this.points[1] * vector3f.points[0]));
    }

    public float dotProduct(Vector3f vector3f) {
        return (this.points[0] * vector3f.points[0]) + (this.points[1] * vector3f.points[1]) + (this.points[2] * vector3f.points[2]);
    }

    public float getLength() {
        return (float) Math.sqrt((this.points[0] * this.points[0]) + (this.points[1] * this.points[1]) + (this.points[2] * this.points[2]));
    }

    public float getX() {
        return this.points[0];
    }

    public float getY() {
        return this.points[1];
    }

    public float getZ() {
        return this.points[2];
    }

    public void multiplyByScalar(float f) {
        float[] fArr = this.points;
        fArr[0] = fArr[0] * f;
        float[] fArr2 = this.points;
        fArr2[1] = fArr2[1] * f;
        float[] fArr3 = this.points;
        fArr3[2] = fArr3[2] * f;
    }

    public void normalize() {
        double sqrt = Math.sqrt((this.points[0] * this.points[0]) + (this.points[1] * this.points[1]) + (this.points[2] * this.points[2]));
        this.points[0] = (float) (this.points[0] / sqrt);
        this.points[1] = (float) (this.points[1] / sqrt);
        this.points[2] = (float) (this.points[2] / sqrt);
    }

    public void setX(float f) {
        this.points[0] = f;
    }

    public void setXYZ(float f, float f2, float f3) {
        this.points[0] = f;
        this.points[1] = f2;
        this.points[2] = f3;
    }

    public void setY(float f) {
        this.points[1] = f;
    }

    public void setZ(float f) {
        this.points[2] = f;
    }

    public void subtract(Vector3f vector3f) {
        float[] fArr = this.points;
        fArr[0] = fArr[0] - vector3f.points[0];
        float[] fArr2 = this.points;
        fArr2[1] = fArr2[1] - vector3f.points[1];
        float[] fArr3 = this.points;
        fArr3[2] = fArr3[2] - vector3f.points[2];
    }

    public float[] toArray() {
        return this.points;
    }

    public String toString() {
        return "X:" + this.points[0] + " Y:" + this.points[1] + " Z:" + this.points[2];
    }

    public float x() {
        return this.points[0];
    }

    public void x(float f) {
        this.points[0] = f;
    }

    public float y() {
        return this.points[1];
    }

    public void y(float f) {
        this.points[1] = f;
    }

    public float z() {
        return this.points[2];
    }

    public void z(float f) {
        this.points[2] = f;
    }
}
