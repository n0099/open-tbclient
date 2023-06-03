package com.baidu.ar.arplay.representation;
/* loaded from: classes.dex */
public class Quaternion extends Vector4f {
    public static final long serialVersionUID = -7148812599404359073L;
    public Quaternion bufferQuaternion;
    public boolean dirty = false;
    public Matrixf4x4 matrix = new Matrixf4x4();

    public Quaternion() {
        loadIdentityQuat();
    }

    private void convertQuatToMatrix() {
        float[] fArr = this.points;
        float f = fArr[0];
        float f2 = fArr[1];
        float f3 = fArr[2];
        float f4 = fArr[3];
        float f5 = f2 * f2 * 2.0f;
        float f6 = f3 * f3 * 2.0f;
        this.matrix.setX0((1.0f - f5) - f6);
        float f7 = f * f2 * 2.0f;
        float f8 = f4 * f3 * 2.0f;
        this.matrix.setX1(f7 + f8);
        float f9 = f * f3 * 2.0f;
        float f10 = f4 * f2 * 2.0f;
        this.matrix.setX2(f9 - f10);
        this.matrix.setX3(0.0f);
        this.matrix.setY0(f7 - f8);
        float f11 = 1.0f - ((f * f) * 2.0f);
        this.matrix.setY1(f11 - f6);
        float f12 = f2 * f3 * 2.0f;
        float f13 = f4 * f * 2.0f;
        this.matrix.setY2(f12 + f13);
        this.matrix.setY3(0.0f);
        this.matrix.setZ0(f9 + f10);
        this.matrix.setZ1(f12 - f13);
        this.matrix.setZ2(f11 - f5);
        this.matrix.setZ3(0.0f);
        this.matrix.setW0(0.0f);
        this.matrix.setW1(0.0f);
        this.matrix.setW2(0.0f);
        this.matrix.setW3(1.0f);
    }

    private void generateQuaternionFromMatrix() {
        float f;
        float f2;
        float f3;
        float f4;
        float[] matrix = this.matrix.getMatrix();
        int[] iArr = this.matrix.size() == 16 ? this.matrix.isColumnMajor() ? Matrixf4x4.MAT_IND_COL_IN16_WITH3X3 : Matrixf4x4.MAT_IND_ROW_IN16_WITH3X3 : this.matrix.isColumnMajor() ? Matrixf4x4.MAT_IND_COL_IN9_WITH3X3 : Matrixf4x4.MAT_IND_ROW_IN9_WITH3X3;
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = iArr[2];
        int i4 = iArr[3];
        int i5 = iArr[4];
        int i6 = iArr[5];
        int i7 = iArr[6];
        int i8 = iArr[7];
        int i9 = iArr[8];
        if (this.matrix.size() >= 9) {
            float f5 = matrix[i] + matrix[i5] + matrix[i9];
            if (f5 > 0.0f) {
                float sqrt = ((float) Math.sqrt(f5 + 1.0d)) * 2.0f;
                f = 0.25f * sqrt;
                f2 = (matrix[i8] - matrix[i6]) / sqrt;
                f3 = (matrix[i3] - matrix[i7]) / sqrt;
                f4 = (matrix[i4] - matrix[i2]) / sqrt;
            } else if (matrix[i] > matrix[i5] && matrix[i] > matrix[i9]) {
                float sqrt2 = ((float) Math.sqrt(((matrix[i] + 1.0d) - matrix[i5]) - matrix[i9])) * 2.0f;
                f = (matrix[i8] - matrix[i6]) / sqrt2;
                f2 = 0.25f * sqrt2;
                f4 = (matrix[i3] + matrix[i7]) / sqrt2;
                f3 = (matrix[i2] + matrix[i4]) / sqrt2;
            } else if (matrix[i5] > matrix[i9]) {
                float sqrt3 = ((float) Math.sqrt(((matrix[i5] + 1.0d) - matrix[i]) - matrix[i9])) * 2.0f;
                f = (matrix[i3] - matrix[i7]) / sqrt3;
                f2 = (matrix[i2] + matrix[i4]) / sqrt3;
                f3 = sqrt3 * 0.25f;
                f4 = (matrix[i6] + matrix[i8]) / sqrt3;
            } else {
                float sqrt4 = ((float) Math.sqrt(((matrix[i9] + 1.0d) - matrix[i]) - matrix[i5])) * 2.0f;
                f = (matrix[i4] - matrix[i2]) / sqrt4;
                f2 = (matrix[i3] + matrix[i7]) / sqrt4;
                f3 = (matrix[i6] + matrix[i8]) / sqrt4;
                f4 = sqrt4 * 0.25f;
            }
            setX(f2);
            setY(f3);
            setZ(f4);
            setW(f);
        }
    }

    public void addQuat(Quaternion quaternion) {
        this.dirty = true;
        addQuat(quaternion, this);
    }

    public void addQuat(Quaternion quaternion, Quaternion quaternion2) {
        quaternion2.setX(getX() + quaternion.getX());
        quaternion2.setY(getY() + quaternion.getY());
        quaternion2.setZ(getZ() + quaternion.getZ());
        quaternion2.setW(getW() + quaternion.getW());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: clone */
    public Quaternion m45clone() {
        Quaternion quaternion = new Quaternion();
        quaternion.copyVec4(this);
        return quaternion;
    }

    public void copyFromVec3(Vector3f vector3f, float f) {
        copyFromV3f(vector3f, f);
    }

    public Matrixf4x4 getMatrix4x4() {
        if (this.dirty) {
            convertQuatToMatrix();
            this.dirty = false;
        }
        return this.matrix;
    }

    public final void loadIdentityQuat() {
        this.dirty = true;
        setX(0.0f);
        setY(0.0f);
        setZ(0.0f);
        setW(1.0f);
    }

    public void multiplyByQuat(Quaternion quaternion) {
        if (this.bufferQuaternion == null) {
            this.bufferQuaternion = new Quaternion();
        }
        this.dirty = true;
        this.bufferQuaternion.copyVec4(this);
        multiplyByQuat(quaternion, this.bufferQuaternion);
        copyVec4(this.bufferQuaternion);
    }

    public void multiplyByQuat(Quaternion quaternion, Quaternion quaternion2) {
        Vector4f vector4f = new Vector4f();
        if (quaternion != quaternion2) {
            float[] fArr = quaternion2.points;
            float[] fArr2 = this.points;
            float f = fArr2[3];
            float[] fArr3 = quaternion.points;
            fArr[3] = (((f * fArr3[3]) - (fArr2[0] * fArr3[0])) - (fArr2[1] * fArr3[1])) - (fArr2[2] * fArr3[2]);
            fArr[0] = (((fArr2[3] * fArr3[0]) + (fArr2[0] * fArr3[3])) + (fArr2[1] * fArr3[2])) - (fArr2[2] * fArr3[1]);
            fArr[1] = (((fArr2[3] * fArr3[1]) + (fArr2[1] * fArr3[3])) + (fArr2[2] * fArr3[0])) - (fArr2[0] * fArr3[2]);
            fArr[2] = (((fArr2[3] * fArr3[2]) + (fArr2[2] * fArr3[3])) + (fArr2[0] * fArr3[1])) - (fArr2[1] * fArr3[0]);
            return;
        }
        float[] fArr4 = vector4f.points;
        float[] fArr5 = quaternion.points;
        fArr4[0] = fArr5[0];
        fArr4[1] = fArr5[1];
        fArr4[2] = fArr5[2];
        fArr4[3] = fArr5[3];
        float[] fArr6 = quaternion2.points;
        float[] fArr7 = this.points;
        fArr6[3] = (((fArr7[3] * fArr4[3]) - (fArr7[0] * fArr4[0])) - (fArr7[1] * fArr4[1])) - (fArr7[2] * fArr4[2]);
        fArr6[0] = (((fArr7[3] * fArr4[0]) + (fArr7[0] * fArr4[3])) + (fArr7[1] * fArr4[2])) - (fArr7[2] * fArr4[1]);
        fArr6[1] = (((fArr7[3] * fArr4[1]) + (fArr7[1] * fArr4[3])) + (fArr7[2] * fArr4[0])) - (fArr7[0] * fArr4[2]);
        fArr6[2] = (((fArr7[3] * fArr4[2]) + (fArr7[2] * fArr4[3])) + (fArr7[0] * fArr4[1])) - (fArr7[1] * fArr4[0]);
    }

    public void normalise() {
        this.dirty = true;
        float[] fArr = this.points;
        float sqrt = (float) Math.sqrt((fArr[3] * fArr[3]) + (fArr[0] * fArr[0]) + (fArr[1] * fArr[1]) + (fArr[2] * fArr[2]));
        float[] fArr2 = this.points;
        fArr2[3] = fArr2[3] / sqrt;
        fArr2[0] = fArr2[0] / sqrt;
        fArr2[1] = fArr2[1] / sqrt;
        fArr2[2] = fArr2[2] / sqrt;
    }

    @Override // com.baidu.ar.arplay.representation.Vector4f
    public void normalize() {
        normalise();
    }

    public void set(Quaternion quaternion) {
        this.dirty = true;
        copyVec4(quaternion);
    }

    public void setAxisAngle(Vector3f vector3f, float f) {
        double d = f / 2.0f;
        float sin = (float) Math.sin(Math.toRadians(d));
        setX(vector3f.getX() * sin);
        setY(vector3f.getY() * sin);
        setZ(vector3f.getZ() * sin);
        setW((float) Math.cos(Math.toRadians(d)));
        this.dirty = true;
    }

    public void setAxisAngleRad(Vector3f vector3f, double d) {
        setAxisAngle(vector3f, (float) Math.toDegrees(d));
    }

    public void setColumnMajor(float[] fArr) {
        this.matrix.setMatrix(fArr);
        this.matrix.setColumnMajor(true);
        generateQuaternionFromMatrix();
    }

    public void setEulerAngle(float f, float f2, float f3) {
        double radians = Math.toRadians(f3);
        double radians2 = Math.toRadians(f2);
        double radians3 = Math.toRadians(f);
        double d = radians / 2.0d;
        double cos = Math.cos(d);
        double sin = Math.sin(d);
        double d2 = radians2 / 2.0d;
        double cos2 = Math.cos(d2);
        double sin2 = Math.sin(d2);
        double d3 = radians3 / 2.0d;
        double cos3 = Math.cos(d3);
        double sin3 = Math.sin(d3);
        double d4 = cos * cos2;
        double d5 = sin * sin2;
        setW((float) ((d4 * cos3) - (d5 * sin3)));
        setX((float) ((d4 * sin3) + (d5 * cos3)));
        double d6 = sin * cos2;
        double d7 = cos * sin2;
        setY((float) ((d6 * cos3) + (d7 * sin3)));
        setZ((float) ((d7 * cos3) - (d6 * sin3)));
        this.dirty = true;
    }

    public void setRowMajor(float[] fArr) {
        this.matrix.setMatrix(fArr);
        this.matrix.setColumnMajor(false);
        generateQuaternionFromMatrix();
    }

    public void slerp(Quaternion quaternion, Quaternion quaternion2, float f) {
        Quaternion quaternion3;
        float dotProduct = dotProduct(quaternion);
        if (dotProduct < 0.0f) {
            quaternion3 = new Quaternion();
            dotProduct = -dotProduct;
            float[] fArr = quaternion3.points;
            float[] fArr2 = quaternion.points;
            fArr[0] = -fArr2[0];
            fArr[1] = -fArr2[1];
            fArr[2] = -fArr2[2];
            fArr[3] = -fArr2[3];
        } else {
            quaternion3 = quaternion;
        }
        if (Math.abs(dotProduct) >= 1.0d) {
            float[] fArr3 = quaternion2.points;
            float[] fArr4 = this.points;
            fArr3[0] = fArr4[0];
            fArr3[1] = fArr4[1];
            fArr3[2] = fArr4[2];
            fArr3[3] = fArr4[3];
            return;
        }
        double sqrt = Math.sqrt(1.0d - (dotProduct * dotProduct));
        double acos = Math.acos(dotProduct);
        double sin = Math.sin((1.0f - f) * acos) / sqrt;
        double sin2 = Math.sin(f * acos) / sqrt;
        float[] fArr5 = quaternion2.points;
        float[] fArr6 = this.points;
        float[] fArr7 = quaternion3.points;
        fArr5[3] = (float) ((fArr6[3] * sin) + (fArr7[3] * sin2));
        fArr5[0] = (float) ((fArr6[0] * sin) + (fArr7[0] * sin2));
        fArr5[1] = (float) ((fArr6[1] * sin) + (fArr7[1] * sin2));
        fArr5[2] = (float) ((fArr6[2] * sin) + (fArr7[2] * sin2));
    }

    public void subQuat(Quaternion quaternion) {
        this.dirty = true;
        subQuat(quaternion, this);
    }

    public void subQuat(Quaternion quaternion, Quaternion quaternion2) {
        quaternion2.setX(getX() - quaternion.getX());
        quaternion2.setY(getY() - quaternion.getY());
        quaternion2.setZ(getZ() - quaternion.getZ());
        quaternion2.setW(getW() - quaternion.getW());
    }

    public void toAxisAngle(Vector4f vector4f) {
        float f;
        float f2;
        float f3;
        if (getW() > 1.0f) {
            normalise();
        }
        float degrees = ((float) Math.toDegrees(Math.acos(getW()))) * 2.0f;
        float sqrt = (float) Math.sqrt(1.0f - (getW() * getW()));
        if (sqrt < 0.001d) {
            float[] fArr = this.points;
            f2 = fArr[0];
            f3 = fArr[1];
            f = fArr[2];
        } else {
            float[] fArr2 = this.points;
            float f4 = fArr2[0] / sqrt;
            float f5 = fArr2[1] / sqrt;
            f = fArr2[2] / sqrt;
            f2 = f4;
            f3 = f5;
        }
        float[] fArr3 = vector4f.points;
        fArr3[0] = f2;
        fArr3[1] = f3;
        fArr3[2] = f;
        fArr3[3] = degrees;
    }

    public double[] toEulerAngles() {
        float w = this.points[1] * 2.0f * getW();
        float[] fArr = this.points;
        float[] fArr2 = this.points;
        float w2 = this.points[0] * 2.0f * getW();
        float[] fArr3 = this.points;
        return new double[]{Math.atan2(w - ((fArr[0] * 2.0f) * fArr[2]), (1.0f - ((fArr[1] * fArr[1]) * 2.0f)) - ((fArr[2] * fArr[2]) * 2.0f)), Math.asin((fArr2[0] * 2.0f * fArr2[1]) + (fArr2[2] * 2.0f * getW())), Math.atan2(w2 - ((fArr3[1] * 2.0f) * fArr3[2]), (1.0f - ((fArr3[0] * fArr3[0]) * 2.0f)) - ((fArr3[2] * fArr3[2]) * 2.0f))};
    }

    @Override // com.baidu.ar.arplay.representation.Vector4f
    public String toString() {
        return "{X: " + getX() + ", Y:" + getY() + ", Z:" + getZ() + ", W:" + getW() + "}";
    }
}
