package com.airbnb.lottie.a.a;

import android.graphics.Path;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.model.content.PolystarShape;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.List;
/* loaded from: classes6.dex */
public class m implements j, l, a.InterfaceC0010a {
    @Nullable
    private r BV;
    private final com.airbnb.lottie.a.b.a<?, PointF> BZ;
    private boolean Cb;
    private final PolystarShape.Type Cp;
    private final com.airbnb.lottie.a.b.a<?, Float> Cq;
    private final com.airbnb.lottie.a.b.a<?, Float> Cr;
    @Nullable
    private final com.airbnb.lottie.a.b.a<?, Float> Cs;
    private final com.airbnb.lottie.a.b.a<?, Float> Ct;
    @Nullable
    private final com.airbnb.lottie.a.b.a<?, Float> Cu;
    private final com.airbnb.lottie.a.b.a<?, Float> Cv;
    private final com.airbnb.lottie.g lottieDrawable;
    private final String name;
    private final Path path = new Path();

    public m(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar, PolystarShape polystarShape) {
        this.lottieDrawable = gVar;
        this.name = polystarShape.getName();
        this.Cp = polystarShape.iC();
        this.Cq = polystarShape.iD().ia();
        this.BZ = polystarShape.ie().ia();
        this.Cr = polystarShape.ig().ia();
        this.Ct = polystarShape.iF().ia();
        this.Cv = polystarShape.iH().ia();
        if (this.Cp == PolystarShape.Type.Star) {
            this.Cs = polystarShape.iE().ia();
            this.Cu = polystarShape.iG().ia();
        } else {
            this.Cs = null;
            this.Cu = null;
        }
        aVar.a(this.Cq);
        aVar.a(this.BZ);
        aVar.a(this.Cr);
        aVar.a(this.Ct);
        aVar.a(this.Cv);
        if (this.Cp == PolystarShape.Type.Star) {
            aVar.a(this.Cs);
            aVar.a(this.Cu);
        }
        this.Cq.b(this);
        this.BZ.b(this);
        this.Cr.b(this);
        this.Ct.b(this);
        this.Cv.b(this);
        if (this.Cp == PolystarShape.Type.Star) {
            this.Cs.b(this);
            this.Cu.b(this);
        }
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0010a
    public void hq() {
        invalidate();
    }

    private void invalidate() {
        this.Cb = false;
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                b bVar = list.get(i2);
                if ((bVar instanceof r) && ((r) bVar).hA() == ShapeTrimPath.Type.Simultaneously) {
                    this.BV = (r) bVar;
                    this.BV.a(this);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.l
    public Path ht() {
        if (this.Cb) {
            return this.path;
        }
        this.path.reset();
        switch (this.Cp) {
            case Star:
                hy();
                break;
            case Polygon:
                hz();
                break;
        }
        this.path.close();
        com.airbnb.lottie.d.f.a(this.path, this.BV);
        this.Cb = true;
        return this.path;
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    private void hy() {
        float f;
        double d;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float floatValue = this.Cq.getValue().floatValue();
        double radians = Math.toRadians((this.Cr == null ? 0.0d : this.Cr.getValue().floatValue()) - 90.0d);
        float f8 = (float) (6.283185307179586d / floatValue);
        float f9 = f8 / 2.0f;
        float f10 = floatValue - ((int) floatValue);
        double d2 = f10 != 0.0f ? radians + ((1.0f - f10) * f9) : radians;
        float floatValue2 = this.Ct.getValue().floatValue();
        float floatValue3 = this.Cs.getValue().floatValue();
        if (this.Cu == null) {
            f = 0.0f;
        } else {
            f = this.Cu.getValue().floatValue() / 100.0f;
        }
        float f11 = 0.0f;
        if (this.Cv != null) {
            f11 = this.Cv.getValue().floatValue() / 100.0f;
        }
        if (f10 != 0.0f) {
            float f12 = ((floatValue2 - floatValue3) * f10) + floatValue3;
            float cos = (float) (f12 * Math.cos(d2));
            float sin = (float) (f12 * Math.sin(d2));
            this.path.moveTo(cos, sin);
            d = d2 + ((f8 * f10) / 2.0f);
            f2 = f12;
            f3 = sin;
            f4 = cos;
        } else {
            float cos2 = (float) (floatValue2 * Math.cos(d2));
            float sin2 = (float) (floatValue2 * Math.sin(d2));
            this.path.moveTo(cos2, sin2);
            d = d2 + f9;
            f2 = 0.0f;
            f3 = sin2;
            f4 = cos2;
        }
        double ceil = Math.ceil(floatValue) * 2.0d;
        int i = 0;
        boolean z = false;
        float f13 = f3;
        float f14 = f4;
        while (true) {
            double d3 = d;
            if (i < ceil) {
                float f15 = z ? floatValue2 : floatValue3;
                float f16 = (f2 == 0.0f || ((double) i) != ceil - 2.0d) ? f9 : (f8 * f10) / 2.0f;
                if (f2 != 0.0f && i == ceil - 1.0d) {
                    f15 = f2;
                }
                float cos3 = (float) (f15 * Math.cos(d3));
                float sin3 = (float) (f15 * Math.sin(d3));
                if (f == 0.0f && f11 == 0.0f) {
                    this.path.lineTo(cos3, sin3);
                } else {
                    float atan2 = (float) (Math.atan2(f13, f14) - 1.5707963267948966d);
                    float cos4 = (float) Math.cos(atan2);
                    float sin4 = (float) Math.sin(atan2);
                    float atan22 = (float) (Math.atan2(sin3, cos3) - 1.5707963267948966d);
                    float cos5 = (float) Math.cos(atan22);
                    float sin5 = (float) Math.sin(atan22);
                    float f17 = z ? f : f11;
                    float f18 = z ? f11 : f;
                    float f19 = z ? floatValue3 : floatValue2;
                    float f20 = z ? floatValue2 : floatValue3;
                    float f21 = cos4 * f19 * f17 * 0.47829f;
                    float f22 = f19 * f17 * 0.47829f * sin4;
                    float f23 = f20 * f18 * 0.47829f * cos5;
                    float f24 = f20 * f18 * 0.47829f * sin5;
                    if (f10 != 0.0f) {
                        if (i == 0) {
                            f22 *= f10;
                            f5 = f24;
                            f6 = f21 * f10;
                            f7 = f23;
                        } else if (i == ceil - 1.0d) {
                            float f25 = f23 * f10;
                            f5 = f24 * f10;
                            f6 = f21;
                            f7 = f25;
                        }
                        this.path.cubicTo(f14 - f6, f13 - f22, f7 + cos3, f5 + sin3, cos3, sin3);
                    }
                    f5 = f24;
                    f6 = f21;
                    f7 = f23;
                    this.path.cubicTo(f14 - f6, f13 - f22, f7 + cos3, f5 + sin3, cos3, sin3);
                }
                d = d3 + f16;
                i++;
                z = !z;
                f13 = sin3;
                f14 = cos3;
            } else {
                PointF value = this.BZ.getValue();
                this.path.offset(value.x, value.y);
                this.path.close();
                return;
            }
        }
    }

    private void hz() {
        int floor = (int) Math.floor(this.Cq.getValue().floatValue());
        double radians = Math.toRadians((this.Cr == null ? 0.0d : this.Cr.getValue().floatValue()) - 90.0d);
        float f = (float) (6.283185307179586d / floor);
        float floatValue = this.Cv.getValue().floatValue() / 100.0f;
        float floatValue2 = this.Ct.getValue().floatValue();
        float cos = (float) (floatValue2 * Math.cos(radians));
        float sin = (float) (floatValue2 * Math.sin(radians));
        this.path.moveTo(cos, sin);
        double d = radians + f;
        double ceil = Math.ceil(floor);
        int i = 0;
        while (true) {
            int i2 = i;
            float f2 = cos;
            double d2 = d;
            float f3 = sin;
            if (i2 < ceil) {
                cos = (float) (floatValue2 * Math.cos(d2));
                sin = (float) (floatValue2 * Math.sin(d2));
                if (floatValue != 0.0f) {
                    float atan2 = (float) (Math.atan2(f3, f2) - 1.5707963267948966d);
                    float cos2 = (float) Math.cos(atan2);
                    float sin2 = (float) Math.sin(atan2);
                    float atan22 = (float) (Math.atan2(sin, cos) - 1.5707963267948966d);
                    this.path.cubicTo(f2 - (cos2 * ((floatValue2 * floatValue) * 0.25f)), f3 - (((floatValue2 * floatValue) * 0.25f) * sin2), cos + (((float) Math.cos(atan22)) * floatValue2 * floatValue * 0.25f), (((float) Math.sin(atan22)) * floatValue2 * floatValue * 0.25f) + sin, cos, sin);
                } else {
                    this.path.lineTo(cos, sin);
                }
                d = d2 + f;
                i = i2 + 1;
            } else {
                PointF value = this.BZ.getValue();
                this.path.offset(value.x, value.y);
                this.path.close();
                return;
            }
        }
    }

    @Override // com.airbnb.lottie.model.f
    public void a(com.airbnb.lottie.model.e eVar, int i, List<com.airbnb.lottie.model.e> list, com.airbnb.lottie.model.e eVar2) {
        com.airbnb.lottie.d.e.a(eVar, i, list, eVar2, this);
    }

    @Override // com.airbnb.lottie.model.f
    public <T> void a(T t, @Nullable com.airbnb.lottie.e.c<T> cVar) {
        if (t == com.airbnb.lottie.k.Bm) {
            this.Cq.a(cVar);
        } else if (t == com.airbnb.lottie.k.Bn) {
            this.Cr.a(cVar);
        } else if (t == com.airbnb.lottie.k.Bf) {
            this.BZ.a(cVar);
        } else if (t == com.airbnb.lottie.k.Bo && this.Cs != null) {
            this.Cs.a(cVar);
        } else if (t == com.airbnb.lottie.k.Bp) {
            this.Ct.a(cVar);
        } else if (t == com.airbnb.lottie.k.Bq && this.Cu != null) {
            this.Cu.a(cVar);
        } else if (t == com.airbnb.lottie.k.Br) {
            this.Cv.a(cVar);
        }
    }
}
