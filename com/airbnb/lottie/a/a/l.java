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
    private final com.airbnb.lottie.f jR;
    private final PolystarShape.Type lN;
    private final com.airbnb.lottie.a.b.a<?, Float> lO;
    private final com.airbnb.lottie.a.b.a<?, Float> lP;
    @Nullable
    private final com.airbnb.lottie.a.b.a<?, Float> lQ;
    private final com.airbnb.lottie.a.b.a<?, Float> lR;
    @Nullable
    private final com.airbnb.lottie.a.b.a<?, Float> lS;
    private final com.airbnb.lottie.a.b.a<?, Float> lT;
    private final Path lh = new Path();
    @Nullable
    private q lq;
    private final com.airbnb.lottie.a.b.a<?, PointF> lw;
    private boolean ly;
    private final String name;

    public l(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, PolystarShape polystarShape) {
        this.jR = fVar;
        this.name = polystarShape.getName();
        this.lN = polystarShape.cS();
        this.lO = polystarShape.cT().ci();
        this.lw = polystarShape.cu().ci();
        this.lP = polystarShape.cw().ci();
        this.lR = polystarShape.cV().ci();
        this.lT = polystarShape.cX().ci();
        if (this.lN == PolystarShape.Type.Star) {
            this.lQ = polystarShape.cU().ci();
            this.lS = polystarShape.cW().ci();
        } else {
            this.lQ = null;
            this.lS = null;
        }
        aVar.a(this.lO);
        aVar.a(this.lw);
        aVar.a(this.lP);
        aVar.a(this.lR);
        aVar.a(this.lT);
        if (this.lN == PolystarShape.Type.Star) {
            aVar.a(this.lQ);
            aVar.a(this.lS);
        }
        this.lO.b(this);
        this.lw.b(this);
        this.lP.b(this);
        this.lR.b(this);
        this.lT.b(this);
        if (this.lN == PolystarShape.Type.Star) {
            this.lR.b(this);
            this.lT.b(this);
        }
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0006a
    public void bF() {
        invalidate();
    }

    private void invalidate() {
        this.ly = false;
        this.jR.invalidateSelf();
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                b bVar = list.get(i2);
                if ((bVar instanceof q) && ((q) bVar).bO() == ShapeTrimPath.Type.Simultaneously) {
                    this.lq = (q) bVar;
                    this.lq.a(this);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.k
    public Path getPath() {
        if (this.ly) {
            return this.lh;
        }
        this.lh.reset();
        switch (this.lN) {
            case Star:
                bM();
                break;
            case Polygon:
                bN();
                break;
        }
        this.lh.close();
        com.airbnb.lottie.c.f.a(this.lh, this.lq);
        this.ly = true;
        return this.lh;
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    private void bM() {
        float f;
        double d;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float floatValue = this.lO.getValue().floatValue();
        double radians = Math.toRadians((this.lP == null ? 0.0d : this.lP.getValue().floatValue()) - 90.0d);
        float f8 = (float) (6.283185307179586d / floatValue);
        float f9 = f8 / 2.0f;
        float f10 = floatValue - ((int) floatValue);
        double d2 = f10 != 0.0f ? radians + ((1.0f - f10) * f9) : radians;
        float floatValue2 = this.lR.getValue().floatValue();
        float floatValue3 = this.lQ.getValue().floatValue();
        if (this.lS == null) {
            f = 0.0f;
        } else {
            f = this.lS.getValue().floatValue() / 100.0f;
        }
        float f11 = 0.0f;
        if (this.lT != null) {
            f11 = this.lT.getValue().floatValue() / 100.0f;
        }
        if (f10 != 0.0f) {
            float f12 = ((floatValue2 - floatValue3) * f10) + floatValue3;
            float cos = (float) (f12 * Math.cos(d2));
            float sin = (float) (f12 * Math.sin(d2));
            this.lh.moveTo(cos, sin);
            d = d2 + ((f8 * f10) / 2.0f);
            f2 = f12;
            f3 = sin;
            f4 = cos;
        } else {
            float cos2 = (float) (floatValue2 * Math.cos(d2));
            float sin2 = (float) (floatValue2 * Math.sin(d2));
            this.lh.moveTo(cos2, sin2);
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
                    this.lh.lineTo(cos3, sin3);
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
                        this.lh.cubicTo(f14 - f6, f13 - f22, f7 + cos3, f5 + sin3, cos3, sin3);
                    }
                    f5 = f24;
                    f6 = f21;
                    f7 = f23;
                    this.lh.cubicTo(f14 - f6, f13 - f22, f7 + cos3, f5 + sin3, cos3, sin3);
                }
                d = d3 + f16;
                i++;
                z = !z;
                f13 = sin3;
                f14 = cos3;
            } else {
                PointF value = this.lw.getValue();
                this.lh.offset(value.x, value.y);
                this.lh.close();
                return;
            }
        }
    }

    private void bN() {
        int floor = (int) Math.floor(this.lO.getValue().floatValue());
        double radians = Math.toRadians((this.lP == null ? 0.0d : this.lP.getValue().floatValue()) - 90.0d);
        float f = (float) (6.283185307179586d / floor);
        float floatValue = this.lT.getValue().floatValue() / 100.0f;
        float floatValue2 = this.lR.getValue().floatValue();
        float cos = (float) (floatValue2 * Math.cos(radians));
        float sin = (float) (floatValue2 * Math.sin(radians));
        this.lh.moveTo(cos, sin);
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
                    this.lh.cubicTo(f2 - (cos2 * ((floatValue2 * floatValue) * 0.25f)), f3 - (((floatValue2 * floatValue) * 0.25f) * sin2), cos + (((float) Math.cos(atan22)) * floatValue2 * floatValue * 0.25f), (((float) Math.sin(atan22)) * floatValue2 * floatValue * 0.25f) + sin, cos, sin);
                } else {
                    this.lh.lineTo(cos, sin);
                }
                d = d2 + f;
                i = i2 + 1;
            } else {
                PointF value = this.lw.getValue();
                this.lh.offset(value.x, value.y);
                this.lh.close();
                return;
            }
        }
    }
}
