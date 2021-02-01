package com.baidu.live.lottie.a.a;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.baidu.live.lottie.a.b.a;
import com.baidu.live.lottie.model.content.PolystarShape;
import com.baidu.live.lottie.model.content.ShapeTrimPath;
import java.util.List;
/* loaded from: classes10.dex */
public class m implements j, l, a.InterfaceC0186a {
    private boolean DJ;
    private final PolystarShape.Type bsD;
    private final com.baidu.live.lottie.a.b.a<?, Float> bsE;
    private final com.baidu.live.lottie.a.b.a<?, Float> bsF;
    @Nullable
    private final com.baidu.live.lottie.a.b.a<?, Float> bsG;
    private final com.baidu.live.lottie.a.b.a<?, Float> bsH;
    @Nullable
    private final com.baidu.live.lottie.a.b.a<?, Float> bsI;
    private final com.baidu.live.lottie.a.b.a<?, Float> bsJ;
    @Nullable
    private r bst;
    private final com.baidu.live.lottie.a.b.a<?, PointF> bsw;
    private final com.baidu.live.lottie.h lottieDrawable;
    private final String name;
    private final Path path = new Path();

    public m(com.baidu.live.lottie.h hVar, com.baidu.live.lottie.model.layer.a aVar, PolystarShape polystarShape) {
        this.lottieDrawable = hVar;
        this.name = polystarShape.getName();
        this.bsD = polystarShape.NO();
        this.bsE = polystarShape.NP().Ns();
        this.bsw = polystarShape.Nv().Ns();
        this.bsF = polystarShape.Nx().Ns();
        this.bsH = polystarShape.NR().Ns();
        this.bsJ = polystarShape.NT().Ns();
        if (this.bsD == PolystarShape.Type.Star) {
            this.bsG = polystarShape.NQ().Ns();
            this.bsI = polystarShape.NS().Ns();
        } else {
            this.bsG = null;
            this.bsI = null;
        }
        aVar.a(this.bsE);
        aVar.a(this.bsw);
        aVar.a(this.bsF);
        aVar.a(this.bsH);
        aVar.a(this.bsJ);
        if (this.bsD == PolystarShape.Type.Star) {
            aVar.a(this.bsG);
            aVar.a(this.bsI);
        }
        this.bsE.b(this);
        this.bsw.b(this);
        this.bsF.b(this);
        this.bsH.b(this);
        this.bsJ.b(this);
        if (this.bsD == PolystarShape.Type.Star) {
            this.bsG.b(this);
            this.bsI.b(this);
        }
    }

    @Override // com.baidu.live.lottie.a.b.a.InterfaceC0186a
    public void ir() {
        invalidate();
    }

    private void invalidate() {
        this.DJ = false;
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.baidu.live.lottie.a.a.b
    public void c(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                b bVar = list.get(i2);
                if ((bVar instanceof r) && ((r) bVar).Ni() == ShapeTrimPath.Type.Simultaneously) {
                    this.bst = (r) bVar;
                    this.bst.a(this);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.baidu.live.lottie.a.a.l
    public Path iu() {
        if (this.DJ) {
            return this.path;
        }
        this.path.reset();
        switch (this.bsD) {
            case Star:
                iz();
                break;
            case Polygon:
                iA();
                break;
        }
        this.path.close();
        com.baidu.live.lottie.d.f.a(this.path, this.bst);
        this.DJ = true;
        return this.path;
    }

    @Override // com.baidu.live.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    private void iz() {
        float f;
        float cos;
        float sin;
        double d;
        float f2;
        float f3;
        float f4;
        float floatValue = this.bsE.getValue().floatValue();
        double radians = Math.toRadians((this.bsF == null ? 0.0d : this.bsF.getValue().floatValue()) - 90.0d);
        float f5 = (float) (6.283185307179586d / floatValue);
        float f6 = f5 / 2.0f;
        float f7 = floatValue - ((int) floatValue);
        double d2 = f7 != 0.0f ? radians + ((1.0f - f7) * f6) : radians;
        float floatValue2 = this.bsH.getValue().floatValue();
        float floatValue3 = this.bsG.getValue().floatValue();
        if (this.bsI == null) {
            f = 0.0f;
        } else {
            f = this.bsI.getValue().floatValue() / 100.0f;
        }
        float f8 = 0.0f;
        if (this.bsJ != null) {
            f8 = this.bsJ.getValue().floatValue() / 100.0f;
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
                PointF value = this.bsw.getValue();
                this.path.offset(value.x, value.y);
                this.path.close();
                return;
            }
        }
    }

    private void iA() {
        int floor = (int) Math.floor(this.bsE.getValue().floatValue());
        double radians = Math.toRadians((this.bsF == null ? 0.0d : this.bsF.getValue().floatValue()) - 90.0d);
        float f = (float) (6.283185307179586d / floor);
        float floatValue = this.bsJ.getValue().floatValue() / 100.0f;
        float floatValue2 = this.bsH.getValue().floatValue();
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
                PointF value = this.bsw.getValue();
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
        if (t == com.baidu.live.lottie.l.CO) {
            this.bsE.a(cVar);
        } else if (t == com.baidu.live.lottie.l.CP) {
            this.bsF.a(cVar);
        } else if (t == com.baidu.live.lottie.l.CG) {
            this.bsw.a(cVar);
        } else if (t == com.baidu.live.lottie.l.CQ && this.bsG != null) {
            this.bsG.a(cVar);
        } else if (t == com.baidu.live.lottie.l.CV) {
            this.bsH.a(cVar);
        } else if (t == com.baidu.live.lottie.l.CW && this.bsI != null) {
            this.bsI.a(cVar);
        } else if (t == com.baidu.live.lottie.l.CX) {
            this.bsJ.a(cVar);
        }
    }
}
