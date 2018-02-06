package com.baidu.ar.representation;
/* loaded from: classes3.dex */
public class Quaternion extends Vector4f {
    private static final long serialVersionUID = -7148812599404359073L;
    Quaternion bufferQuaternion;
    private boolean dirty = false;
    private b matrix = new b();

    public Quaternion() {
        b();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: a */
    public Quaternion clone() {
        Quaternion quaternion = new Quaternion();
        quaternion.a((Vector4f) this);
        return quaternion;
    }

    public void a(Quaternion quaternion) {
        this.dirty = true;
        a((Vector4f) quaternion);
    }

    public void a(Quaternion quaternion, Quaternion quaternion2) {
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

    public void a(Quaternion quaternion, Quaternion quaternion2, float f) {
        float b = b(quaternion);
        if (b < 0.0f) {
            Quaternion quaternion3 = new Quaternion();
            b = -b;
            quaternion3.points[0] = -quaternion.points[0];
            quaternion3.points[1] = -quaternion.points[1];
            quaternion3.points[2] = -quaternion.points[2];
            quaternion3.points[3] = -quaternion.points[3];
            quaternion = quaternion3;
        }
        if (Math.abs(b) >= 1.0d) {
            quaternion2.points[0] = this.points[0];
            quaternion2.points[1] = this.points[1];
            quaternion2.points[2] = this.points[2];
            quaternion2.points[3] = this.points[3];
            return;
        }
        double sqrt = Math.sqrt(1.0d - (b * b));
        double acos = Math.acos(b);
        double sin = Math.sin((1.0f - f) * acos) / sqrt;
        double sin2 = Math.sin(acos * f) / sqrt;
        quaternion2.points[3] = (float) ((this.points[3] * sin) + (quaternion.points[3] * sin2));
        quaternion2.points[0] = (float) ((this.points[0] * sin) + (quaternion.points[0] * sin2));
        quaternion2.points[1] = (float) ((this.points[1] * sin) + (quaternion.points[1] * sin2));
        quaternion2.points[2] = (float) ((sin2 * quaternion.points[2]) + (sin * this.points[2]));
    }

    public void b() {
        this.dirty = true;
        a(0.0f);
        b(0.0f);
        c(0.0f);
        d(1.0f);
    }

    @Override // com.baidu.ar.representation.Vector4f
    public String toString() {
        return "{X: " + d() + ", Y:" + e() + ", Z:" + f() + ", W:" + g() + "}";
    }
}
