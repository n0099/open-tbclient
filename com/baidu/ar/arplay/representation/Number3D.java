package com.baidu.ar.arplay.representation;

import android.util.Log;
/* loaded from: classes6.dex */
public class Number3D {
    public static final int M00 = 0;
    public static final int M01 = 4;
    public static final int M02 = 8;
    public static final int M03 = 12;
    public static final int M10 = 1;
    public static final int M11 = 5;
    public static final int M12 = 9;
    public static final int M13 = 13;
    public static final int M20 = 2;
    public static final int M21 = 6;
    public static final int M22 = 10;
    public static final int M23 = 14;
    public static final int M30 = 3;
    public static final int M31 = 7;
    public static final int M32 = 11;
    public static final int M33 = 15;
    private static Number3D _temp = new Number3D();
    public float x;
    public float y;
    public float z;

    /* loaded from: classes6.dex */
    public enum Axis {
        X,
        Y,
        Z
    }

    public Number3D() {
        this.x = 0.0f;
        this.y = 0.0f;
        this.z = 0.0f;
    }

    public Number3D(double d, double d2, double d3) {
        this.x = (float) d;
        this.y = (float) d2;
        this.z = (float) d3;
    }

    public Number3D(float f, float f2, float f3) {
        this.x = f;
        this.y = f2;
        this.z = f3;
    }

    public Number3D(Number3D number3D) {
        this.x = number3D.x;
        this.y = number3D.y;
        this.z = number3D.z;
    }

    public Number3D(String[] strArr) {
        if (strArr.length != 3) {
            Log.e(Number3D.class.getSimpleName(), "Number3D should be initialized with 3 values");
        }
        try {
            this.x = Float.parseFloat(strArr[0]);
            this.y = Float.parseFloat(strArr[1]);
            this.z = Float.parseFloat(strArr[2]);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public static Number3D add(Number3D number3D, Number3D number3D2) {
        return new Number3D(number3D.x + number3D2.x, number3D.y + number3D2.y, number3D.z + number3D2.z);
    }

    public static Number3D cross(Number3D number3D, Number3D number3D2) {
        return new Number3D((number3D2.y * number3D.z) - (number3D2.z * number3D.y), (number3D2.z * number3D.x) - (number3D2.x * number3D.z), (number3D2.x * number3D.y) - (number3D2.y * number3D.x));
    }

    public static float dot(Number3D number3D, Number3D number3D2) {
        return (number3D.x * number3D2.x) + (number3D.y * number3D2.y) + (number3D.z * number3D2.z);
    }

    public static Number3D getAxisVector(Axis axis) {
        Number3D number3D = new Number3D();
        switch (axis) {
            case X:
                number3D.setAll(1.0f, 0.0f, 0.0f);
                break;
            case Y:
                number3D.setAll(0.0f, 1.0f, 0.0f);
                break;
            case Z:
                number3D.setAll(0.0f, 0.0f, 1.0f);
                break;
        }
        return number3D;
    }

    public static Number3D getUpVector() {
        return new Number3D(0.0f, 1.0f, 0.0f);
    }

    public static Number3D lerp(Number3D number3D, Number3D number3D2, float f) {
        Number3D number3D3 = new Number3D();
        number3D3.x = number3D.x + ((number3D2.x - number3D.x) * f);
        number3D3.y = number3D.y + ((number3D2.y - number3D.y) * f);
        number3D3.z = number3D.z + ((number3D2.z - number3D.z) * f);
        return number3D3;
    }

    public static Number3D multiply(Number3D number3D, float f) {
        return new Number3D(number3D.x * f, number3D.y * f, number3D.z * f);
    }

    public static Number3D multiply(Number3D number3D, Number3D number3D2) {
        return new Number3D(number3D.x * number3D2.x, number3D.y * number3D2.y, number3D.z * number3D2.z);
    }

    public static Number3D subtract(Number3D number3D, Number3D number3D2) {
        return new Number3D(number3D.x - number3D2.x, number3D.y - number3D2.y, number3D.z - number3D2.z);
    }

    public Number3D add(float f, float f2, float f3) {
        this.x += f;
        this.y += f2;
        this.z += f3;
        return this;
    }

    public Number3D add(Number3D number3D) {
        this.x += number3D.x;
        this.y += number3D.y;
        this.z += number3D.z;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: clone */
    public Number3D m14clone() {
        return new Number3D(this.x, this.y, this.z);
    }

    public Number3D cross(Number3D number3D) {
        _temp.setAllFrom(this);
        this.x = (number3D.y * _temp.z) - (number3D.z * _temp.y);
        this.y = (number3D.z * _temp.x) - (number3D.x * _temp.z);
        this.z = (number3D.x * _temp.y) - (number3D.y * _temp.x);
        return this;
    }

    public float distanceTo(Number3D number3D) {
        return (float) Math.sqrt(((this.x - number3D.x) * (this.x - number3D.x)) + ((this.y - number3D.y) * (this.y - number3D.y)) + ((this.z - number3D.z) * (this.z - number3D.z)));
    }

    public float dot(Number3D number3D) {
        return (this.x * number3D.x) + (this.y * number3D.y) + (this.z * number3D.z);
    }

    public boolean equals(Object obj) {
        Number3D number3D = obj instanceof Number3D ? (Number3D) obj : null;
        return number3D != null && number3D.x == this.x && number3D.y == this.y && number3D.z == this.z;
    }

    public String formatIntToString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append((int) this.x);
        stringBuffer.append(", ");
        stringBuffer.append((int) this.y);
        stringBuffer.append(", ");
        stringBuffer.append((int) this.z);
        return stringBuffer.toString();
    }

    public Quaternion getRotationTo(Number3D number3D) {
        Quaternion quaternion = new Quaternion();
        normalize();
        number3D.normalize();
        float dot = dot(this, number3D);
        if (dot >= 1.0f) {
            quaternion.loadIdentityQuat();
        }
        if (dot < -0.999999f) {
            Number3D cross = cross(getAxisVector(Axis.X), this);
            if (cross.length() == 0.0f) {
                cross = cross(getAxisVector(Axis.Y), this);
            }
            cross.normalize();
            quaternion.setAxisAngle(new Vector3f(cross.x, cross.y, cross.z), (float) Math.toDegrees(3.141592653589793d));
        } else {
            double sqrt = Math.sqrt((dot + 1.0f) * 2.0f);
            double d = 1.0d / sqrt;
            Number3D cross2 = cross(this, number3D);
            quaternion.points[0] = (float) (cross2.x * d);
            quaternion.points[1] = (float) (cross2.y * d);
            quaternion.points[2] = (float) (d * cross2.z);
            quaternion.points[3] = (float) (sqrt * 0.5d);
            quaternion.normalize();
        }
        return quaternion;
    }

    public Number3D inverse() {
        return new Number3D(-this.x, -this.y, -this.z);
    }

    public float length() {
        return (float) Math.sqrt((this.x * this.x) + (this.y * this.y) + (this.z * this.z));
    }

    public void lerpSelf(Number3D number3D, Number3D number3D2, float f) {
        this.x = number3D.x + ((number3D2.x - number3D.x) * f);
        this.y = number3D.y + ((number3D2.y - number3D.y) * f);
        this.z = number3D.z + ((number3D2.z - number3D.z) * f);
    }

    public Number3D multiply(float f) {
        this.x *= f;
        this.y *= f;
        this.z *= f;
        return this;
    }

    public void multiply(Number3D number3D) {
        this.x *= number3D.x;
        this.y *= number3D.y;
        this.z *= number3D.z;
    }

    public void multiply(float[] fArr) {
        float f = this.x;
        float f2 = this.y;
        float f3 = this.z;
        this.x = (fArr[0] * f) + (fArr[4] * f2) + (fArr[8] * f3) + fArr[12];
        this.y = (fArr[1] * f) + (fArr[5] * f2) + (fArr[9] * f3) + fArr[13];
        this.z = (f * fArr[2]) + (f2 * fArr[6]) + (fArr[10] * f3) + fArr[14];
    }

    public float normalize() {
        double sqrt = Math.sqrt((this.x * this.x) + (this.y * this.y) + (this.z * this.z));
        if (sqrt != 0.0d && sqrt != 1.0d) {
            sqrt = 1.0d / sqrt;
            this.x = (float) (this.x * sqrt);
            this.y = (float) (this.y * sqrt);
            this.z = (float) (this.z * sqrt);
        }
        return (float) sqrt;
    }

    public void project(float[] fArr) {
        if (fArr == null || fArr.length <= 15) {
            return;
        }
        float f = (this.x * fArr[3]) + (this.y * fArr[7]) + (this.z * fArr[11]) + fArr[15];
        setAll(((((this.x * fArr[0]) + (this.y * fArr[4])) + (this.z * fArr[8])) + fArr[12]) / f, ((((this.x * fArr[1]) + (this.y * fArr[5])) + (this.z * fArr[9])) + fArr[13]) / f, ((((this.x * fArr[2]) + (this.y * fArr[6])) + (this.z * fArr[10])) + fArr[14]) / f);
    }

    public void rotateX(float f) {
        double cos = Math.cos(f);
        double sin = Math.sin(f);
        _temp.setAll(this.x, this.y, this.z);
        this.y = (float) ((_temp.y * cos) - (_temp.z * sin));
        this.z = (float) ((cos * _temp.z) + (sin * _temp.y));
    }

    public void rotateY(float f) {
        double cos = Math.cos(f);
        double sin = Math.sin(f);
        _temp.setAll(this.x, this.y, this.z);
        this.x = (float) ((_temp.x * cos) + (_temp.z * sin));
        this.z = (float) ((cos * _temp.z) + ((-sin) * _temp.x));
    }

    public void rotateZ(float f) {
        double cos = Math.cos(f);
        double sin = Math.sin(f);
        _temp.setAll(this.x, this.y, this.z);
        this.x = (float) ((_temp.x * cos) - (_temp.y * sin));
        this.y = (float) ((cos * _temp.y) + (sin * _temp.x));
    }

    public void setAll(double d, double d2, double d3) {
        this.x = (float) d;
        this.y = (float) d2;
        this.z = (float) d3;
    }

    public void setAll(float f, float f2, float f3) {
        this.x = f;
        this.y = f2;
        this.z = f3;
    }

    public void setAllFrom(Number3D number3D) {
        this.x = number3D.x;
        this.y = number3D.y;
        this.z = number3D.z;
    }

    public Number3D subtract(Number3D number3D) {
        this.x -= number3D.x;
        this.y -= number3D.y;
        this.z -= number3D.z;
        return this;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.x);
        stringBuffer.append(", ");
        stringBuffer.append(this.y);
        stringBuffer.append(", ");
        stringBuffer.append(this.z);
        return stringBuffer.toString();
    }
}
