package com.baidu.ar.arplay.representation;
/* loaded from: classes3.dex */
public class Quaternion extends Vector4f {
    private static final long serialVersionUID = -7148812599404359073L;
    Quaternion bufferQuaternion;
    private boolean dirty = false;
    private Matrixf4x4 matrix = new Matrixf4x4();

    public Quaternion() {
        loadIdentityQuat();
    }

    private void convertQuatToMatrix() {
        float f = this.points[0];
        float f2 = this.points[1];
        float f3 = this.points[2];
        float f4 = this.points[3];
        this.matrix.setX0((1.0f - ((f2 * f2) * 2.0f)) - ((f3 * f3) * 2.0f));
        this.matrix.setX1((f * f2 * 2.0f) + (f4 * f3 * 2.0f));
        this.matrix.setX2(((f * f3) * 2.0f) - ((f4 * f2) * 2.0f));
        this.matrix.setX3(0.0f);
        this.matrix.setY0(((f * f2) * 2.0f) - ((f4 * f3) * 2.0f));
        this.matrix.setY1((1.0f - ((f * f) * 2.0f)) - ((f3 * f3) * 2.0f));
        this.matrix.setY2((f2 * f3 * 2.0f) + (f4 * f * 2.0f));
        this.matrix.setY3(0.0f);
        this.matrix.setZ0((f * f3 * 2.0f) + (f4 * f2 * 2.0f));
        this.matrix.setZ1(((f3 * f2) * 2.0f) - ((f4 * f) * 2.0f));
        this.matrix.setZ2((1.0f - ((f * f) * 2.0f)) - ((f2 * f2) * 2.0f));
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
                float sqrt = 2.0f * ((float) Math.sqrt(f5 + 1.0d));
                f = 0.25f * sqrt;
                f2 = (matrix[i8] - matrix[i6]) / sqrt;
                f3 = (matrix[i3] - matrix[i7]) / sqrt;
                f4 = (matrix[i4] - matrix[i2]) / sqrt;
            } else {
                if ((matrix[i] > matrix[i5]) && (matrix[i] > matrix[i9])) {
                    float sqrt2 = 2.0f * ((float) Math.sqrt(((1.0d + matrix[i]) - matrix[i5]) - matrix[i9]));
                    f = (matrix[i8] - matrix[i6]) / sqrt2;
                    f2 = 0.25f * sqrt2;
                    f3 = (matrix[i2] + matrix[i4]) / sqrt2;
                    f4 = (matrix[i7] + matrix[i3]) / sqrt2;
                } else if (matrix[i5] > matrix[i9]) {
                    float sqrt3 = 2.0f * ((float) Math.sqrt(((1.0d + matrix[i5]) - matrix[i]) - matrix[i9]));
                    f = (matrix[i3] - matrix[i7]) / sqrt3;
                    f2 = (matrix[i2] + matrix[i4]) / sqrt3;
                    f3 = 0.25f * sqrt3;
                    f4 = (matrix[i8] + matrix[i6]) / sqrt3;
                } else {
                    float sqrt4 = 2.0f * ((float) Math.sqrt(((1.0d + matrix[i9]) - matrix[i]) - matrix[i5]));
                    f = (matrix[i4] - matrix[i2]) / sqrt4;
                    f2 = (matrix[i3] + matrix[i7]) / sqrt4;
                    f3 = (matrix[i6] + matrix[i8]) / sqrt4;
                    f4 = sqrt4 * 0.25f;
                }
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
    public Quaternion m17clone() {
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

    public void loadIdentityQuat() {
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
            quaternion2.points[3] = (((this.points[3] * quaternion.points[3]) - (this.points[0] * quaternion.points[0])) - (this.points[1] * quaternion.points[1])) - (this.points[2] * quaternion.points[2]);
            quaternion2.points[0] = (((this.points[3] * quaternion.points[0]) + (this.points[0] * quaternion.points[3])) + (this.points[1] * quaternion.points[2])) - (this.points[2] * quaternion.points[1]);
            quaternion2.points[1] = (((this.points[3] * quaternion.points[1]) + (this.points[1] * quaternion.points[3])) + (this.points[2] * quaternion.points[0])) - (this.points[0] * quaternion.points[2]);
            quaternion2.points[2] = (((this.points[3] * quaternion.points[2]) + (this.points[2] * quaternion.points[3])) + (this.points[0] * quaternion.points[1])) - (this.points[1] * quaternion.points[0]);
            return;
        }
        vector4f.points[0] = quaternion.points[0];
        vector4f.points[1] = quaternion.points[1];
        vector4f.points[2] = quaternion.points[2];
        vector4f.points[3] = quaternion.points[3];
        quaternion2.points[3] = (((this.points[3] * vector4f.points[3]) - (this.points[0] * vector4f.points[0])) - (this.points[1] * vector4f.points[1])) - (this.points[2] * vector4f.points[2]);
        quaternion2.points[0] = (((this.points[3] * vector4f.points[0]) + (this.points[0] * vector4f.points[3])) + (this.points[1] * vector4f.points[2])) - (this.points[2] * vector4f.points[1]);
        quaternion2.points[1] = (((this.points[3] * vector4f.points[1]) + (this.points[1] * vector4f.points[3])) + (this.points[2] * vector4f.points[0])) - (this.points[0] * vector4f.points[2]);
        quaternion2.points[2] = (((this.points[3] * vector4f.points[2]) + (this.points[2] * vector4f.points[3])) + (this.points[0] * vector4f.points[1])) - (vector4f.points[0] * this.points[1]);
    }

    public void normalise() {
        this.dirty = true;
        float sqrt = (float) Math.sqrt((this.points[3] * this.points[3]) + (this.points[0] * this.points[0]) + (this.points[1] * this.points[1]) + (this.points[2] * this.points[2]));
        this.points[3] = this.points[3] / sqrt;
        this.points[0] = this.points[0] / sqrt;
        this.points[1] = this.points[1] / sqrt;
        this.points[2] = this.points[2] / sqrt;
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
        double sin = Math.sin(Math.toRadians(f / 2.0f));
        setX(vector3f.getX() * ((float) sin));
        setY(vector3f.getY() * ((float) sin));
        setZ(((float) sin) * vector3f.getZ());
        setW((float) Math.cos(Math.toRadians(f / 2.0f)));
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
        double cos = Math.cos(radians / 2.0d);
        double sin = Math.sin(radians / 2.0d);
        double cos2 = Math.cos(radians2 / 2.0d);
        double sin2 = Math.sin(radians2 / 2.0d);
        double cos3 = Math.cos(radians3 / 2.0d);
        double sin3 = Math.sin(radians3 / 2.0d);
        double d = cos * cos2;
        double d2 = sin * sin2;
        setW((float) ((d * cos3) - (d2 * sin3)));
        setX((float) ((d * sin3) + (d2 * cos3)));
        setY((float) ((sin * cos2 * cos3) + (cos * sin2 * sin3)));
        setZ((float) (((sin2 * cos) * cos3) - ((sin * cos2) * sin3)));
        this.dirty = true;
    }

    public void setRowMajor(float[] fArr) {
        this.matrix.setMatrix(fArr);
        this.matrix.setColumnMajor(false);
        generateQuaternionFromMatrix();
    }

    public void slerp(Quaternion quaternion, Quaternion quaternion2, float f) {
        float dotProduct = dotProduct(quaternion);
        if (dotProduct < 0.0f) {
            Quaternion quaternion3 = new Quaternion();
            dotProduct = -dotProduct;
            quaternion3.points[0] = -quaternion.points[0];
            quaternion3.points[1] = -quaternion.points[1];
            quaternion3.points[2] = -quaternion.points[2];
            quaternion3.points[3] = -quaternion.points[3];
            quaternion = quaternion3;
        }
        if (Math.abs(dotProduct) >= 1.0d) {
            quaternion2.points[0] = this.points[0];
            quaternion2.points[1] = this.points[1];
            quaternion2.points[2] = this.points[2];
            quaternion2.points[3] = this.points[3];
            return;
        }
        double sqrt = Math.sqrt(1.0d - (dotProduct * dotProduct));
        double acos = Math.acos(dotProduct);
        double sin = Math.sin((1.0f - f) * acos) / sqrt;
        double sin2 = Math.sin(acos * f) / sqrt;
        quaternion2.points[3] = (float) ((this.points[3] * sin) + (quaternion.points[3] * sin2));
        quaternion2.points[0] = (float) ((this.points[0] * sin) + (quaternion.points[0] * sin2));
        quaternion2.points[1] = (float) ((this.points[1] * sin) + (quaternion.points[1] * sin2));
        quaternion2.points[2] = (float) ((sin2 * quaternion.points[2]) + (sin * this.points[2]));
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
        float degrees = 2.0f * ((float) Math.toDegrees(Math.acos(getW())));
        float sqrt = (float) Math.sqrt(1.0f - (getW() * getW()));
        if (sqrt < 0.001d) {
            f = this.points[0];
            f2 = this.points[1];
            f3 = this.points[2];
        } else {
            f = this.points[0] / sqrt;
            f2 = this.points[1] / sqrt;
            f3 = this.points[2] / sqrt;
        }
        vector4f.points[0] = f;
        vector4f.points[1] = f2;
        vector4f.points[2] = f3;
        vector4f.points[3] = degrees;
    }

    public double[] toEulerAngles() {
        return new double[]{Math.atan2(((this.points[1] * 2.0f) * getW()) - ((this.points[0] * 2.0f) * this.points[2]), (1.0f - ((this.points[1] * this.points[1]) * 2.0f)) - ((this.points[2] * this.points[2]) * 2.0f)), Math.asin((this.points[0] * 2.0f * this.points[1]) + (this.points[2] * 2.0f * getW())), Math.atan2(((this.points[0] * 2.0f) * getW()) - ((this.points[1] * 2.0f) * this.points[2]), (1.0f - ((this.points[0] * this.points[0]) * 2.0f)) - ((this.points[2] * this.points[2]) * 2.0f))};
    }

    @Override // com.baidu.ar.arplay.representation.Vector4f
    public String toString() {
        return "{X: " + getX() + ", Y:" + getY() + ", Z:" + getZ() + ", W:" + getW() + "}";
    }
}
