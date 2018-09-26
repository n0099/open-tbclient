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
    private final com.airbnb.lottie.f mp;
    private final Path nJ = new Path();
    @Nullable
    private q nS;
    private final com.airbnb.lottie.a.b.a<?, PointF> nX;
    private boolean nZ;
    private final String name;
    private final PolystarShape.Type oo;
    private final com.airbnb.lottie.a.b.a<?, Float> oq;
    private final com.airbnb.lottie.a.b.a<?, Float> or;
    @Nullable
    private final com.airbnb.lottie.a.b.a<?, Float> ot;
    private final com.airbnb.lottie.a.b.a<?, Float> ou;
    @Nullable
    private final com.airbnb.lottie.a.b.a<?, Float> ov;
    private final com.airbnb.lottie.a.b.a<?, Float> ow;

    public l(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, PolystarShape polystarShape) {
        this.mp = fVar;
        this.name = polystarShape.getName();
        this.oo = polystarShape.dZ();
        this.oq = polystarShape.ea().dp();
        this.nX = polystarShape.dB().dp();
        this.or = polystarShape.dD().dp();
        this.ou = polystarShape.ec().dp();
        this.ow = polystarShape.ee().dp();
        if (this.oo == PolystarShape.Type.Star) {
            this.ot = polystarShape.eb().dp();
            this.ov = polystarShape.ed().dp();
        } else {
            this.ot = null;
            this.ov = null;
        }
        aVar.a(this.oq);
        aVar.a(this.nX);
        aVar.a(this.or);
        aVar.a(this.ou);
        aVar.a(this.ow);
        if (this.oo == PolystarShape.Type.Star) {
            aVar.a(this.ot);
            aVar.a(this.ov);
        }
        this.oq.b(this);
        this.nX.b(this);
        this.or.b(this);
        this.ou.b(this);
        this.ow.b(this);
        if (this.oo == PolystarShape.Type.Star) {
            this.ou.b(this);
            this.ow.b(this);
        }
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0006a
    public void cM() {
        invalidate();
    }

    private void invalidate() {
        this.nZ = false;
        this.mp.invalidateSelf();
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                b bVar = list.get(i2);
                if ((bVar instanceof q) && ((q) bVar).cV() == ShapeTrimPath.Type.Simultaneously) {
                    this.nS = (q) bVar;
                    this.nS.a(this);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.k
    public Path getPath() {
        if (this.nZ) {
            return this.nJ;
        }
        this.nJ.reset();
        switch (this.oo) {
            case Star:
                cT();
                break;
            case Polygon:
                cU();
                break;
        }
        this.nJ.close();
        com.airbnb.lottie.c.f.a(this.nJ, this.nS);
        this.nZ = true;
        return this.nJ;
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    private void cT() {
        float f;
        double d;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float floatValue = this.oq.getValue().floatValue();
        double radians = Math.toRadians((this.or == null ? 0.0d : this.or.getValue().floatValue()) - 90.0d);
        float f8 = (float) (6.283185307179586d / floatValue);
        float f9 = f8 / 2.0f;
        float f10 = floatValue - ((int) floatValue);
        double d2 = f10 != 0.0f ? radians + ((1.0f - f10) * f9) : radians;
        float floatValue2 = this.ou.getValue().floatValue();
        float floatValue3 = this.ot.getValue().floatValue();
        if (this.ov == null) {
            f = 0.0f;
        } else {
            f = this.ov.getValue().floatValue() / 100.0f;
        }
        float f11 = 0.0f;
        if (this.ow != null) {
            f11 = this.ow.getValue().floatValue() / 100.0f;
        }
        if (f10 != 0.0f) {
            float f12 = ((floatValue2 - floatValue3) * f10) + floatValue3;
            float cos = (float) (f12 * Math.cos(d2));
            float sin = (float) (f12 * Math.sin(d2));
            this.nJ.moveTo(cos, sin);
            d = d2 + ((f8 * f10) / 2.0f);
            f2 = f12;
            f3 = sin;
            f4 = cos;
        } else {
            float cos2 = (float) (floatValue2 * Math.cos(d2));
            float sin2 = (float) (floatValue2 * Math.sin(d2));
            this.nJ.moveTo(cos2, sin2);
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
                    this.nJ.lineTo(cos3, sin3);
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
                        this.nJ.cubicTo(f14 - f6, f13 - f22, f7 + cos3, f5 + sin3, cos3, sin3);
                    }
                    f5 = f24;
                    f6 = f21;
                    f7 = f23;
                    this.nJ.cubicTo(f14 - f6, f13 - f22, f7 + cos3, f5 + sin3, cos3, sin3);
                }
                d = d3 + f16;
                i++;
                z = !z;
                f13 = sin3;
                f14 = cos3;
            } else {
                PointF value = this.nX.getValue();
                this.nJ.offset(value.x, value.y);
                this.nJ.close();
                return;
            }
        }
    }

    private void cU() {
        int floor = (int) Math.floor(this.oq.getValue().floatValue());
        double radians = Math.toRadians((this.or == null ? 0.0d : this.or.getValue().floatValue()) - 90.0d);
        float f = (float) (6.283185307179586d / floor);
        float floatValue = this.ow.getValue().floatValue() / 100.0f;
        float floatValue2 = this.ou.getValue().floatValue();
        float cos = (float) (floatValue2 * Math.cos(radians));
        float sin = (float) (floatValue2 * Math.sin(radians));
        this.nJ.moveTo(cos, sin);
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
                    this.nJ.cubicTo(f2 - (cos2 * ((floatValue2 * floatValue) * 0.25f)), f3 - (((floatValue2 * floatValue) * 0.25f) * sin2), cos + (((float) Math.cos(atan22)) * floatValue2 * floatValue * 0.25f), (((float) Math.sin(atan22)) * floatValue2 * floatValue * 0.25f) + sin, cos, sin);
                } else {
                    this.nJ.lineTo(cos, sin);
                }
                d = d2 + f;
                i = i2 + 1;
            } else {
                PointF value = this.nX.getValue();
                this.nJ.offset(value.x, value.y);
                this.nJ.close();
                return;
            }
        }
    }
}
