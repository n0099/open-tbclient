package com.airbnb.lottie.a.a;

import android.graphics.Path;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.model.content.PolystarShape;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.List;
/* loaded from: classes2.dex */
public class l implements k, a.InterfaceC0006a {
    private final com.airbnb.lottie.f jY;
    @Nullable
    private q lA;
    private final com.airbnb.lottie.a.b.a<?, PointF> lF;
    private boolean lH;
    private final PolystarShape.Type lV;
    private final com.airbnb.lottie.a.b.a<?, Float> lW;
    private final com.airbnb.lottie.a.b.a<?, Float> lX;
    @Nullable
    private final com.airbnb.lottie.a.b.a<?, Float> lY;
    private final com.airbnb.lottie.a.b.a<?, Float> lZ;
    private final Path lo = new Path();
    @Nullable
    private final com.airbnb.lottie.a.b.a<?, Float> ma;
    private final com.airbnb.lottie.a.b.a<?, Float> mb;
    private final String name;

    public l(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, PolystarShape polystarShape) {
        this.jY = fVar;
        this.name = polystarShape.getName();
        this.lV = polystarShape.cU();
        this.lW = polystarShape.cV().ck();
        this.lF = polystarShape.cw().ck();
        this.lX = polystarShape.cy().ck();
        this.lZ = polystarShape.cX().ck();
        this.mb = polystarShape.cZ().ck();
        if (this.lV == PolystarShape.Type.Star) {
            this.lY = polystarShape.cW().ck();
            this.ma = polystarShape.cY().ck();
        } else {
            this.lY = null;
            this.ma = null;
        }
        aVar.a(this.lW);
        aVar.a(this.lF);
        aVar.a(this.lX);
        aVar.a(this.lZ);
        aVar.a(this.mb);
        if (this.lV == PolystarShape.Type.Star) {
            aVar.a(this.lY);
            aVar.a(this.ma);
        }
        this.lW.b(this);
        this.lF.b(this);
        this.lX.b(this);
        this.lZ.b(this);
        this.mb.b(this);
        if (this.lV == PolystarShape.Type.Star) {
            this.lZ.b(this);
            this.mb.b(this);
        }
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0006a
    public void bH() {
        invalidate();
    }

    private void invalidate() {
        this.lH = false;
        this.jY.invalidateSelf();
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                b bVar = list.get(i2);
                if ((bVar instanceof q) && ((q) bVar).bQ() == ShapeTrimPath.Type.Simultaneously) {
                    this.lA = (q) bVar;
                    this.lA.a(this);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.k
    public Path getPath() {
        if (this.lH) {
            return this.lo;
        }
        this.lo.reset();
        switch (this.lV) {
            case Star:
                bO();
                break;
            case Polygon:
                bP();
                break;
        }
        this.lo.close();
        com.airbnb.lottie.c.f.a(this.lo, this.lA);
        this.lH = true;
        return this.lo;
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    private void bO() {
        float f;
        double d;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float floatValue = this.lW.getValue().floatValue();
        double radians = Math.toRadians((this.lX == null ? 0.0d : this.lX.getValue().floatValue()) - 90.0d);
        float f8 = (float) (6.283185307179586d / floatValue);
        float f9 = f8 / 2.0f;
        float f10 = floatValue - ((int) floatValue);
        double d2 = f10 != 0.0f ? radians + ((1.0f - f10) * f9) : radians;
        float floatValue2 = this.lZ.getValue().floatValue();
        float floatValue3 = this.lY.getValue().floatValue();
        if (this.ma == null) {
            f = 0.0f;
        } else {
            f = this.ma.getValue().floatValue() / 100.0f;
        }
        float f11 = 0.0f;
        if (this.mb != null) {
            f11 = this.mb.getValue().floatValue() / 100.0f;
        }
        if (f10 != 0.0f) {
            float f12 = ((floatValue2 - floatValue3) * f10) + floatValue3;
            float cos = (float) (f12 * Math.cos(d2));
            float sin = (float) (f12 * Math.sin(d2));
            this.lo.moveTo(cos, sin);
            d = d2 + ((f8 * f10) / 2.0f);
            f2 = f12;
            f3 = sin;
            f4 = cos;
        } else {
            float cos2 = (float) (floatValue2 * Math.cos(d2));
            float sin2 = (float) (floatValue2 * Math.sin(d2));
            this.lo.moveTo(cos2, sin2);
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
                    this.lo.lineTo(cos3, sin3);
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
                        this.lo.cubicTo(f14 - f6, f13 - f22, f7 + cos3, f5 + sin3, cos3, sin3);
                    }
                    f5 = f24;
                    f6 = f21;
                    f7 = f23;
                    this.lo.cubicTo(f14 - f6, f13 - f22, f7 + cos3, f5 + sin3, cos3, sin3);
                }
                d = d3 + f16;
                i++;
                z = !z;
                f13 = sin3;
                f14 = cos3;
            } else {
                PointF value = this.lF.getValue();
                this.lo.offset(value.x, value.y);
                this.lo.close();
                return;
            }
        }
    }

    private void bP() {
        int floor = (int) Math.floor(this.lW.getValue().floatValue());
        double radians = Math.toRadians((this.lX == null ? 0.0d : this.lX.getValue().floatValue()) - 90.0d);
        float f = (float) (6.283185307179586d / floor);
        float floatValue = this.mb.getValue().floatValue() / 100.0f;
        float floatValue2 = this.lZ.getValue().floatValue();
        float cos = (float) (floatValue2 * Math.cos(radians));
        float sin = (float) (floatValue2 * Math.sin(radians));
        this.lo.moveTo(cos, sin);
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
                    this.lo.cubicTo(f2 - (cos2 * ((floatValue2 * floatValue) * 0.25f)), f3 - (((floatValue2 * floatValue) * 0.25f) * sin2), cos + (((float) Math.cos(atan22)) * floatValue2 * floatValue * 0.25f), (((float) Math.sin(atan22)) * floatValue2 * floatValue * 0.25f) + sin, cos, sin);
                } else {
                    this.lo.lineTo(cos, sin);
                }
                d = d2 + f;
                i = i2 + 1;
            } else {
                PointF value = this.lF.getValue();
                this.lo.offset(value.x, value.y);
                this.lo.close();
                return;
            }
        }
    }
}
