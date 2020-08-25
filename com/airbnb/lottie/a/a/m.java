package com.airbnb.lottie.a.a;

import android.graphics.Path;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.model.content.PolystarShape;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.List;
/* loaded from: classes18.dex */
public class m implements j, l, a.InterfaceC0010a {
    @Nullable
    private r CC;
    private final com.airbnb.lottie.a.b.a<?, PointF> CG;
    private boolean CI;
    private final PolystarShape.Type Db;
    private final com.airbnb.lottie.a.b.a<?, Float> Dc;
    private final com.airbnb.lottie.a.b.a<?, Float> Dd;
    @Nullable
    private final com.airbnb.lottie.a.b.a<?, Float> De;
    private final com.airbnb.lottie.a.b.a<?, Float> Df;
    @Nullable
    private final com.airbnb.lottie.a.b.a<?, Float> Dg;
    private final com.airbnb.lottie.a.b.a<?, Float> Dh;
    private final com.airbnb.lottie.g lottieDrawable;
    private final String name;
    private final Path path = new Path();

    public m(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar, PolystarShape polystarShape) {
        this.lottieDrawable = gVar;
        this.name = polystarShape.getName();
        this.Db = polystarShape.kb();
        this.Dc = polystarShape.kc().jB();
        this.CG = polystarShape.jE().jB();
        this.Dd = polystarShape.jG().jB();
        this.Df = polystarShape.ke().jB();
        this.Dh = polystarShape.kg().jB();
        if (this.Db == PolystarShape.Type.Star) {
            this.De = polystarShape.kd().jB();
            this.Dg = polystarShape.kf().jB();
        } else {
            this.De = null;
            this.Dg = null;
        }
        aVar.a(this.Dc);
        aVar.a(this.CG);
        aVar.a(this.Dd);
        aVar.a(this.Df);
        aVar.a(this.Dh);
        if (this.Db == PolystarShape.Type.Star) {
            aVar.a(this.De);
            aVar.a(this.Dg);
        }
        this.Dc.b(this);
        this.CG.b(this);
        this.Dd.b(this);
        this.Df.b(this);
        this.Dh.b(this);
        if (this.Db == PolystarShape.Type.Star) {
            this.De.b(this);
            this.Dg.b(this);
        }
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0010a
    public void iR() {
        invalidate();
    }

    private void invalidate() {
        this.CI = false;
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                b bVar = list.get(i2);
                if ((bVar instanceof r) && ((r) bVar).jb() == ShapeTrimPath.Type.Simultaneously) {
                    this.CC = (r) bVar;
                    this.CC.a(this);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.l
    public Path iU() {
        if (this.CI) {
            return this.path;
        }
        this.path.reset();
        switch (this.Db) {
            case Star:
                iZ();
                break;
            case Polygon:
                ja();
                break;
        }
        this.path.close();
        com.airbnb.lottie.d.f.a(this.path, this.CC);
        this.CI = true;
        return this.path;
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    private void iZ() {
        float f;
        double d;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float floatValue = this.Dc.getValue().floatValue();
        double radians = Math.toRadians((this.Dd == null ? 0.0d : this.Dd.getValue().floatValue()) - 90.0d);
        float f8 = (float) (6.283185307179586d / floatValue);
        float f9 = f8 / 2.0f;
        float f10 = floatValue - ((int) floatValue);
        double d2 = f10 != 0.0f ? radians + ((1.0f - f10) * f9) : radians;
        float floatValue2 = this.Df.getValue().floatValue();
        float floatValue3 = this.De.getValue().floatValue();
        if (this.Dg == null) {
            f = 0.0f;
        } else {
            f = this.Dg.getValue().floatValue() / 100.0f;
        }
        float f11 = 0.0f;
        if (this.Dh != null) {
            f11 = this.Dh.getValue().floatValue() / 100.0f;
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
                PointF value = this.CG.getValue();
                this.path.offset(value.x, value.y);
                this.path.close();
                return;
            }
        }
    }

    private void ja() {
        int floor = (int) Math.floor(this.Dc.getValue().floatValue());
        double radians = Math.toRadians((this.Dd == null ? 0.0d : this.Dd.getValue().floatValue()) - 90.0d);
        float f = (float) (6.283185307179586d / floor);
        float floatValue = this.Dh.getValue().floatValue() / 100.0f;
        float floatValue2 = this.Df.getValue().floatValue();
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
                PointF value = this.CG.getValue();
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
        if (t == com.airbnb.lottie.k.BS) {
            this.Dc.a(cVar);
        } else if (t == com.airbnb.lottie.k.BT) {
            this.Dd.a(cVar);
        } else if (t == com.airbnb.lottie.k.BL) {
            this.CG.a(cVar);
        } else if (t == com.airbnb.lottie.k.BU && this.De != null) {
            this.De.a(cVar);
        } else if (t == com.airbnb.lottie.k.BV) {
            this.Df.a(cVar);
        } else if (t == com.airbnb.lottie.k.BW && this.Dg != null) {
            this.Dg.a(cVar);
        } else if (t == com.airbnb.lottie.k.BX) {
            this.Dh.a(cVar);
        }
    }
}
