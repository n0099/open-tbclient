package com.baidu.live.lottie.a.a;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.baidu.live.lottie.a.b.a;
import com.baidu.live.lottie.model.content.PolystarShape;
import com.baidu.live.lottie.model.content.ShapeTrimPath;
import java.util.List;
/* loaded from: classes9.dex */
public class m implements j, l, a.InterfaceC0185a {
    private boolean DJ;
    @Nullable
    private r boS;
    private final com.baidu.live.lottie.a.b.a<?, PointF> boV;
    private final PolystarShape.Type bpc;
    private final com.baidu.live.lottie.a.b.a<?, Float> bpd;
    private final com.baidu.live.lottie.a.b.a<?, Float> bpe;
    @Nullable
    private final com.baidu.live.lottie.a.b.a<?, Float> bpf;
    private final com.baidu.live.lottie.a.b.a<?, Float> bpg;
    @Nullable
    private final com.baidu.live.lottie.a.b.a<?, Float> bph;
    private final com.baidu.live.lottie.a.b.a<?, Float> bpi;
    private final com.baidu.live.lottie.h lottieDrawable;
    private final String name;
    private final Path path = new Path();

    public m(com.baidu.live.lottie.h hVar, com.baidu.live.lottie.model.layer.a aVar, PolystarShape polystarShape) {
        this.lottieDrawable = hVar;
        this.name = polystarShape.getName();
        this.bpc = polystarShape.Mq();
        this.bpd = polystarShape.Mr().LU();
        this.boV = polystarShape.LX().LU();
        this.bpe = polystarShape.LZ().LU();
        this.bpg = polystarShape.Mt().LU();
        this.bpi = polystarShape.Mv().LU();
        if (this.bpc == PolystarShape.Type.Star) {
            this.bpf = polystarShape.Ms().LU();
            this.bph = polystarShape.Mu().LU();
        } else {
            this.bpf = null;
            this.bph = null;
        }
        aVar.a(this.bpd);
        aVar.a(this.boV);
        aVar.a(this.bpe);
        aVar.a(this.bpg);
        aVar.a(this.bpi);
        if (this.bpc == PolystarShape.Type.Star) {
            aVar.a(this.bpf);
            aVar.a(this.bph);
        }
        this.bpd.b(this);
        this.boV.b(this);
        this.bpe.b(this);
        this.bpg.b(this);
        this.bpi.b(this);
        if (this.bpc == PolystarShape.Type.Star) {
            this.bpf.b(this);
            this.bph.b(this);
        }
    }

    @Override // com.baidu.live.lottie.a.b.a.InterfaceC0185a
    public void is() {
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
                if ((bVar instanceof r) && ((r) bVar).LK() == ShapeTrimPath.Type.Simultaneously) {
                    this.boS = (r) bVar;
                    this.boS.a(this);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.baidu.live.lottie.a.a.l
    public Path iv() {
        if (this.DJ) {
            return this.path;
        }
        this.path.reset();
        switch (this.bpc) {
            case Star:
                iA();
                break;
            case Polygon:
                iB();
                break;
        }
        this.path.close();
        com.baidu.live.lottie.d.f.a(this.path, this.boS);
        this.DJ = true;
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
        float floatValue = this.bpd.getValue().floatValue();
        double radians = Math.toRadians((this.bpe == null ? 0.0d : this.bpe.getValue().floatValue()) - 90.0d);
        float f5 = (float) (6.283185307179586d / floatValue);
        float f6 = f5 / 2.0f;
        float f7 = floatValue - ((int) floatValue);
        double d2 = f7 != 0.0f ? radians + ((1.0f - f7) * f6) : radians;
        float floatValue2 = this.bpg.getValue().floatValue();
        float floatValue3 = this.bpf.getValue().floatValue();
        if (this.bph == null) {
            f = 0.0f;
        } else {
            f = this.bph.getValue().floatValue() / 100.0f;
        }
        float f8 = 0.0f;
        if (this.bpi != null) {
            f8 = this.bpi.getValue().floatValue() / 100.0f;
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
                PointF value = this.boV.getValue();
                this.path.offset(value.x, value.y);
                this.path.close();
                return;
            }
        }
    }

    private void iB() {
        int floor = (int) Math.floor(this.bpd.getValue().floatValue());
        double radians = Math.toRadians((this.bpe == null ? 0.0d : this.bpe.getValue().floatValue()) - 90.0d);
        float f = (float) (6.283185307179586d / floor);
        float floatValue = this.bpi.getValue().floatValue() / 100.0f;
        float floatValue2 = this.bpg.getValue().floatValue();
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
                PointF value = this.boV.getValue();
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
            this.bpd.a(cVar);
        } else if (t == com.baidu.live.lottie.l.CP) {
            this.bpe.a(cVar);
        } else if (t == com.baidu.live.lottie.l.CG) {
            this.boV.a(cVar);
        } else if (t == com.baidu.live.lottie.l.CQ && this.bpf != null) {
            this.bpf.a(cVar);
        } else if (t == com.baidu.live.lottie.l.CV) {
            this.bpg.a(cVar);
        } else if (t == com.baidu.live.lottie.l.CW && this.bph != null) {
            this.bph.a(cVar);
        } else if (t == com.baidu.live.lottie.l.CX) {
            this.bpi.a(cVar);
        }
    }
}
