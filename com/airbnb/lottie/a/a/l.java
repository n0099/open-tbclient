package com.airbnb.lottie.a.a;

import android.graphics.Path;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.model.content.PolystarShape;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.List;
/* loaded from: classes2.dex */
public class l implements k, a.InterfaceC0007a {
    private final com.airbnb.lottie.f dh;
    @Nullable
    private q eB;
    private final com.airbnb.lottie.a.b.a<?, PointF> eG;
    private boolean eI;
    private final PolystarShape.Type eW;
    private final com.airbnb.lottie.a.b.a<?, Float> eX;
    private final com.airbnb.lottie.a.b.a<?, Float> eY;
    @Nullable
    private final com.airbnb.lottie.a.b.a<?, Float> eZ;
    private final com.airbnb.lottie.a.b.a<?, Float> fa;
    @Nullable
    private final com.airbnb.lottie.a.b.a<?, Float> fb;
    private final com.airbnb.lottie.a.b.a<?, Float> fd;
    private final String name;
    private final Path path = new Path();

    public l(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, PolystarShape polystarShape) {
        this.dh = fVar;
        this.name = polystarShape.getName();
        this.eW = polystarShape.cJ();
        this.eX = polystarShape.cK().bY();
        this.eG = polystarShape.ck().bY();
        this.eY = polystarShape.cm().bY();
        this.fa = polystarShape.cM().bY();
        this.fd = polystarShape.cO().bY();
        if (this.eW == PolystarShape.Type.Star) {
            this.eZ = polystarShape.cL().bY();
            this.fb = polystarShape.cN().bY();
        } else {
            this.eZ = null;
            this.fb = null;
        }
        aVar.a(this.eX);
        aVar.a(this.eG);
        aVar.a(this.eY);
        aVar.a(this.fa);
        aVar.a(this.fd);
        if (this.eW == PolystarShape.Type.Star) {
            aVar.a(this.eZ);
            aVar.a(this.fb);
        }
        this.eX.b(this);
        this.eG.b(this);
        this.eY.b(this);
        this.fa.b(this);
        this.fd.b(this);
        if (this.eW == PolystarShape.Type.Star) {
            this.fa.b(this);
            this.fd.b(this);
        }
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0007a
    public void bt() {
        invalidate();
    }

    private void invalidate() {
        this.eI = false;
        this.dh.invalidateSelf();
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                b bVar = list.get(i2);
                if ((bVar instanceof q) && ((q) bVar).bD() == ShapeTrimPath.Type.Simultaneously) {
                    this.eB = (q) bVar;
                    this.eB.a(this);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.k
    public Path bw() {
        if (this.eI) {
            return this.path;
        }
        this.path.reset();
        switch (this.eW) {
            case Star:
                bB();
                break;
            case Polygon:
                bC();
                break;
        }
        this.path.close();
        com.airbnb.lottie.c.f.a(this.path, this.eB);
        this.eI = true;
        return this.path;
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    private void bB() {
        float f;
        double d;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float floatValue = this.eX.getValue().floatValue();
        double radians = Math.toRadians((this.eY == null ? 0.0d : this.eY.getValue().floatValue()) - 90.0d);
        float f8 = (float) (6.283185307179586d / floatValue);
        float f9 = f8 / 2.0f;
        float f10 = floatValue - ((int) floatValue);
        double d2 = f10 != 0.0f ? radians + ((1.0f - f10) * f9) : radians;
        float floatValue2 = this.fa.getValue().floatValue();
        float floatValue3 = this.eZ.getValue().floatValue();
        if (this.fb == null) {
            f = 0.0f;
        } else {
            f = this.fb.getValue().floatValue() / 100.0f;
        }
        float f11 = 0.0f;
        if (this.fd != null) {
            f11 = this.fd.getValue().floatValue() / 100.0f;
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
                PointF value = this.eG.getValue();
                this.path.offset(value.x, value.y);
                this.path.close();
                return;
            }
        }
    }

    private void bC() {
        int floor = (int) Math.floor(this.eX.getValue().floatValue());
        double radians = Math.toRadians((this.eY == null ? 0.0d : this.eY.getValue().floatValue()) - 90.0d);
        float f = (float) (6.283185307179586d / floor);
        float floatValue = this.fd.getValue().floatValue() / 100.0f;
        float floatValue2 = this.fa.getValue().floatValue();
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
                PointF value = this.eG.getValue();
                this.path.offset(value.x, value.y);
                this.path.close();
                return;
            }
        }
    }
}
