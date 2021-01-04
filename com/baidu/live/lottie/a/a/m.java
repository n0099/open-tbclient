package com.baidu.live.lottie.a.a;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.baidu.live.lottie.a.b.a;
import com.baidu.live.lottie.model.content.PolystarShape;
import com.baidu.live.lottie.model.content.ShapeTrimPath;
import java.util.List;
/* loaded from: classes10.dex */
public class m implements j, l, a.InterfaceC0194a {
    private boolean DM;
    @Nullable
    private r btF;
    private final com.baidu.live.lottie.a.b.a<?, PointF> btI;
    private final PolystarShape.Type btP;
    private final com.baidu.live.lottie.a.b.a<?, Float> btQ;
    private final com.baidu.live.lottie.a.b.a<?, Float> btR;
    @Nullable
    private final com.baidu.live.lottie.a.b.a<?, Float> btS;
    private final com.baidu.live.lottie.a.b.a<?, Float> btT;
    @Nullable
    private final com.baidu.live.lottie.a.b.a<?, Float> btU;
    private final com.baidu.live.lottie.a.b.a<?, Float> btV;
    private final com.baidu.live.lottie.h lottieDrawable;
    private final String name;
    private final Path path = new Path();

    public m(com.baidu.live.lottie.h hVar, com.baidu.live.lottie.model.layer.a aVar, PolystarShape polystarShape) {
        this.lottieDrawable = hVar;
        this.name = polystarShape.getName();
        this.btP = polystarShape.Ql();
        this.btQ = polystarShape.Qm().PP();
        this.btI = polystarShape.PS().PP();
        this.btR = polystarShape.PU().PP();
        this.btT = polystarShape.Qo().PP();
        this.btV = polystarShape.Qq().PP();
        if (this.btP == PolystarShape.Type.Star) {
            this.btS = polystarShape.Qn().PP();
            this.btU = polystarShape.Qp().PP();
        } else {
            this.btS = null;
            this.btU = null;
        }
        aVar.a(this.btQ);
        aVar.a(this.btI);
        aVar.a(this.btR);
        aVar.a(this.btT);
        aVar.a(this.btV);
        if (this.btP == PolystarShape.Type.Star) {
            aVar.a(this.btS);
            aVar.a(this.btU);
        }
        this.btQ.b(this);
        this.btI.b(this);
        this.btR.b(this);
        this.btT.b(this);
        this.btV.b(this);
        if (this.btP == PolystarShape.Type.Star) {
            this.btS.b(this);
            this.btU.b(this);
        }
    }

    @Override // com.baidu.live.lottie.a.b.a.InterfaceC0194a
    public void is() {
        invalidate();
    }

    private void invalidate() {
        this.DM = false;
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.baidu.live.lottie.a.a.b
    public void c(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                b bVar = list.get(i2);
                if ((bVar instanceof r) && ((r) bVar).PF() == ShapeTrimPath.Type.Simultaneously) {
                    this.btF = (r) bVar;
                    this.btF.a(this);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.baidu.live.lottie.a.a.l
    public Path iv() {
        if (this.DM) {
            return this.path;
        }
        this.path.reset();
        switch (this.btP) {
            case Star:
                iA();
                break;
            case Polygon:
                iB();
                break;
        }
        this.path.close();
        com.baidu.live.lottie.d.f.a(this.path, this.btF);
        this.DM = true;
        return this.path;
    }

    @Override // com.baidu.live.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    private void iA() {
        float f;
        float cos;
        float sin;
        double d;
        float f2;
        float f3;
        float f4;
        float floatValue = this.btQ.getValue().floatValue();
        double radians = Math.toRadians((this.btR == null ? 0.0d : this.btR.getValue().floatValue()) - 90.0d);
        float f5 = (float) (6.283185307179586d / floatValue);
        float f6 = f5 / 2.0f;
        float f7 = floatValue - ((int) floatValue);
        double d2 = f7 != 0.0f ? radians + ((1.0f - f7) * f6) : radians;
        float floatValue2 = this.btT.getValue().floatValue();
        float floatValue3 = this.btS.getValue().floatValue();
        if (this.btU == null) {
            f = 0.0f;
        } else {
            f = this.btU.getValue().floatValue() / 100.0f;
        }
        float f8 = 0.0f;
        if (this.btV != null) {
            f8 = this.btV.getValue().floatValue() / 100.0f;
        }
        if (f7 != 0.0f) {
            float f9 = floatValue3 + ((floatValue2 - floatValue3) * f7);
            cos = (float) (f9 * Math.cos(d2));
            sin = (float) (f9 * Math.sin(d2));
            this.path.moveTo(cos, sin);
            d = d2 + ((f5 * f7) / 2.0f);
            f2 = f9;
        } else {
            cos = (float) (floatValue2 * Math.cos(d2));
            sin = (float) (floatValue2 * Math.sin(d2));
            this.path.moveTo(cos, sin);
            d = d2 + f6;
            f2 = 0.0f;
        }
        double ceil = Math.ceil(floatValue) * 2.0d;
        int i = 0;
        boolean z = false;
        float f10 = sin;
        float f11 = cos;
        while (true) {
            double d3 = d;
            if (i < ceil) {
                float f12 = z ? floatValue2 : floatValue3;
                float f13 = (f2 == 0.0f || ((double) i) != ceil - 2.0d) ? f6 : (f5 * f7) / 2.0f;
                if (f2 != 0.0f && i == ceil - 1.0d) {
                    f12 = f2;
                }
                float cos2 = (float) (f12 * Math.cos(d3));
                float sin2 = (float) (f12 * Math.sin(d3));
                if (f == 0.0f && f8 == 0.0f) {
                    this.path.lineTo(cos2, sin2);
                } else {
                    float atan2 = (float) (Math.atan2(f10, f11) - 1.5707963267948966d);
                    float cos3 = (float) Math.cos(atan2);
                    float sin3 = (float) Math.sin(atan2);
                    float atan22 = (float) (Math.atan2(sin2, cos2) - 1.5707963267948966d);
                    float cos4 = (float) Math.cos(atan22);
                    float sin4 = (float) Math.sin(atan22);
                    float f14 = z ? f : f8;
                    float f15 = z ? f8 : f;
                    float f16 = z ? floatValue3 : floatValue2;
                    float f17 = z ? floatValue2 : floatValue3;
                    float f18 = f16 * f14 * 0.47829f * cos3;
                    float f19 = f16 * f14 * 0.47829f * sin3;
                    float f20 = f17 * f15 * 0.47829f * cos4;
                    float f21 = f17 * f15 * 0.47829f * sin4;
                    if (f7 != 0.0f) {
                        if (i == 0) {
                            f18 *= f7;
                            f19 *= f7;
                            f3 = f21;
                            f4 = f20;
                        } else if (i == ceil - 1.0d) {
                            f3 = f21 * f7;
                            f4 = f20 * f7;
                        }
                        this.path.cubicTo(f11 - f18, f10 - f19, f4 + cos2, f3 + sin2, cos2, sin2);
                    }
                    f3 = f21;
                    f4 = f20;
                    this.path.cubicTo(f11 - f18, f10 - f19, f4 + cos2, f3 + sin2, cos2, sin2);
                }
                d = d3 + f13;
                i++;
                z = !z;
                f10 = sin2;
                f11 = cos2;
            } else {
                PointF value = this.btI.getValue();
                this.path.offset(value.x, value.y);
                this.path.close();
                return;
            }
        }
    }

    private void iB() {
        int floor = (int) Math.floor(this.btQ.getValue().floatValue());
        double radians = Math.toRadians((this.btR == null ? 0.0d : this.btR.getValue().floatValue()) - 90.0d);
        float f = (float) (6.283185307179586d / floor);
        float floatValue = this.btV.getValue().floatValue() / 100.0f;
        float floatValue2 = this.btT.getValue().floatValue();
        float cos = (float) (floatValue2 * Math.cos(radians));
        float sin = (float) (floatValue2 * Math.sin(radians));
        this.path.moveTo(cos, sin);
        double d = radians + f;
        double ceil = Math.ceil(floor);
        int i = 0;
        while (true) {
            int i2 = i;
            float f2 = sin;
            float f3 = cos;
            if (i2 < ceil) {
                cos = (float) (floatValue2 * Math.cos(d));
                sin = (float) (floatValue2 * Math.sin(d));
                if (floatValue != 0.0f) {
                    float atan2 = (float) (Math.atan2(f2, f3) - 1.5707963267948966d);
                    float cos2 = (float) Math.cos(atan2);
                    float sin2 = (float) Math.sin(atan2);
                    float atan22 = (float) (Math.atan2(sin, cos) - 1.5707963267948966d);
                    this.path.cubicTo(f3 - (cos2 * ((floatValue2 * floatValue) * 0.25f)), f2 - (((floatValue2 * floatValue) * 0.25f) * sin2), cos + (((float) Math.cos(atan22)) * floatValue2 * floatValue * 0.25f), (((float) Math.sin(atan22)) * floatValue2 * floatValue * 0.25f) + sin, cos, sin);
                } else {
                    this.path.lineTo(cos, sin);
                }
                d += f;
                i = i2 + 1;
            } else {
                PointF value = this.btI.getValue();
                this.path.offset(value.x, value.y);
                this.path.close();
                return;
            }
        }
    }

    @Override // com.baidu.live.lottie.model.f
    public void a(com.baidu.live.lottie.model.e eVar, int i, List<com.baidu.live.lottie.model.e> list, com.baidu.live.lottie.model.e eVar2) {
        com.baidu.live.lottie.d.e.a(eVar, i, list, eVar2, this);
    }

    @Override // com.baidu.live.lottie.model.f
    public <T> void a(T t, @Nullable com.baidu.live.lottie.e.c<T> cVar) {
        if (t == com.baidu.live.lottie.l.CQ) {
            this.btQ.a(cVar);
        } else if (t == com.baidu.live.lottie.l.CV) {
            this.btR.a(cVar);
        } else if (t == com.baidu.live.lottie.l.CI) {
            this.btI.a(cVar);
        } else if (t == com.baidu.live.lottie.l.CW && this.btS != null) {
            this.btS.a(cVar);
        } else if (t == com.baidu.live.lottie.l.CX) {
            this.btT.a(cVar);
        } else if (t == com.baidu.live.lottie.l.CY && this.btU != null) {
            this.btU.a(cVar);
        } else if (t == com.baidu.live.lottie.l.CZ) {
            this.btV.a(cVar);
        }
    }
}
