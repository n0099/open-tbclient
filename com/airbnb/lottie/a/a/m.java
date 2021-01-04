package com.airbnb.lottie.a.a;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.model.content.PolystarShape;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.List;
/* loaded from: classes3.dex */
public class m implements j, l, a.InterfaceC0007a {
    private final com.airbnb.lottie.f BJ;
    @Nullable
    private r DE;
    private final com.airbnb.lottie.a.b.a<?, PointF> DJ;
    private boolean DM;
    private final PolystarShape.Type Eb;
    private final com.airbnb.lottie.a.b.a<?, Float> Ec;
    private final com.airbnb.lottie.a.b.a<?, Float> Ed;
    @Nullable
    private final com.airbnb.lottie.a.b.a<?, Float> Ee;
    private final com.airbnb.lottie.a.b.a<?, Float> Ef;
    @Nullable
    private final com.airbnb.lottie.a.b.a<?, Float> Eg;
    private final com.airbnb.lottie.a.b.a<?, Float> Eh;
    private final String name;
    private final Path path = new Path();

    public m(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, PolystarShape polystarShape) {
        this.BJ = fVar;
        this.name = polystarShape.getName();
        this.Eb = polystarShape.jC();
        this.Ec = polystarShape.jD().jc();
        this.DJ = polystarShape.jf().jc();
        this.Ed = polystarShape.jh().jc();
        this.Ef = polystarShape.jF().jc();
        this.Eh = polystarShape.jH().jc();
        if (this.Eb == PolystarShape.Type.Star) {
            this.Ee = polystarShape.jE().jc();
            this.Eg = polystarShape.jG().jc();
        } else {
            this.Ee = null;
            this.Eg = null;
        }
        aVar.a(this.Ec);
        aVar.a(this.DJ);
        aVar.a(this.Ed);
        aVar.a(this.Ef);
        aVar.a(this.Eh);
        if (this.Eb == PolystarShape.Type.Star) {
            aVar.a(this.Ee);
            aVar.a(this.Eg);
        }
        this.Ec.b(this);
        this.DJ.b(this);
        this.Ed.b(this);
        this.Ef.b(this);
        this.Eh.b(this);
        if (this.Eb == PolystarShape.Type.Star) {
            this.Ee.b(this);
            this.Eg.b(this);
        }
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0007a
    public void is() {
        invalidate();
    }

    private void invalidate() {
        this.DM = false;
        this.BJ.invalidateSelf();
    }

    @Override // com.airbnb.lottie.a.a.b
    public void c(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                b bVar = list.get(i2);
                if ((bVar instanceof r) && ((r) bVar).iC() == ShapeTrimPath.Type.Simultaneously) {
                    this.DE = (r) bVar;
                    this.DE.a(this);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.l
    public Path iv() {
        if (this.DM) {
            return this.path;
        }
        this.path.reset();
        switch (this.Eb) {
            case Star:
                iA();
                break;
            case Polygon:
                iB();
                break;
        }
        this.path.close();
        com.airbnb.lottie.d.f.a(this.path, this.DE);
        this.DM = true;
        return this.path;
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    private void iA() {
        float f;
        float sin;
        double d;
        float f2;
        float f3;
        float f4;
        float f5;
        float floatValue = this.Ec.getValue().floatValue();
        double radians = Math.toRadians((this.Ed == null ? 0.0d : this.Ed.getValue().floatValue()) - 90.0d);
        float f6 = (float) (6.283185307179586d / floatValue);
        float f7 = f6 / 2.0f;
        float f8 = floatValue - ((int) floatValue);
        double d2 = f8 != 0.0f ? radians + ((1.0f - f8) * f7) : radians;
        float floatValue2 = this.Ef.getValue().floatValue();
        float floatValue3 = this.Ee.getValue().floatValue();
        if (this.Eg == null) {
            f = 0.0f;
        } else {
            f = this.Eg.getValue().floatValue() / 100.0f;
        }
        float f9 = 0.0f;
        if (this.Eh != null) {
            f9 = this.Eh.getValue().floatValue() / 100.0f;
        }
        if (f8 != 0.0f) {
            float f10 = ((floatValue2 - floatValue3) * f8) + floatValue3;
            float cos = (float) (f10 * Math.cos(d2));
            sin = (float) (f10 * Math.sin(d2));
            this.path.moveTo(cos, sin);
            d = d2 + ((f6 * f8) / 2.0f);
            f2 = f10;
            f3 = cos;
        } else {
            float cos2 = (float) (floatValue2 * Math.cos(d2));
            sin = (float) (floatValue2 * Math.sin(d2));
            this.path.moveTo(cos2, sin);
            d = d2 + f7;
            f2 = 0.0f;
            f3 = cos2;
        }
        double ceil = Math.ceil(floatValue) * 2.0d;
        int i = 0;
        boolean z = false;
        float f11 = sin;
        float f12 = f3;
        while (true) {
            double d3 = d;
            if (i < ceil) {
                float f13 = z ? floatValue2 : floatValue3;
                float f14 = (f2 == 0.0f || ((double) i) != ceil - 2.0d) ? f7 : (f6 * f8) / 2.0f;
                if (f2 != 0.0f && i == ceil - 1.0d) {
                    f13 = f2;
                }
                float cos3 = (float) (f13 * Math.cos(d3));
                float sin2 = (float) (f13 * Math.sin(d3));
                if (f == 0.0f && f9 == 0.0f) {
                    this.path.lineTo(cos3, sin2);
                } else {
                    float atan2 = (float) (Math.atan2(f11, f12) - 1.5707963267948966d);
                    float cos4 = (float) Math.cos(atan2);
                    float sin3 = (float) Math.sin(atan2);
                    float atan22 = (float) (Math.atan2(sin2, cos3) - 1.5707963267948966d);
                    float cos5 = (float) Math.cos(atan22);
                    float sin4 = (float) Math.sin(atan22);
                    float f15 = z ? f : f9;
                    float f16 = z ? f9 : f;
                    float f17 = z ? floatValue3 : floatValue2;
                    float f18 = z ? floatValue2 : floatValue3;
                    float f19 = f17 * f15 * 0.47829f * cos4;
                    float f20 = f17 * f15 * 0.47829f * sin3;
                    float f21 = f18 * f16 * 0.47829f * cos5;
                    float f22 = f18 * f16 * 0.47829f * sin4;
                    if (f8 != 0.0f) {
                        if (i == 0) {
                            f19 *= f8;
                            f20 *= f8;
                            f4 = f22;
                            f5 = f21;
                        } else if (i == ceil - 1.0d) {
                            f4 = f22 * f8;
                            f5 = f21 * f8;
                        }
                        this.path.cubicTo(f12 - f19, f11 - f20, f5 + cos3, f4 + sin2, cos3, sin2);
                    }
                    f4 = f22;
                    f5 = f21;
                    this.path.cubicTo(f12 - f19, f11 - f20, f5 + cos3, f4 + sin2, cos3, sin2);
                }
                d = d3 + f14;
                i++;
                z = !z;
                f11 = sin2;
                f12 = cos3;
            } else {
                PointF value = this.DJ.getValue();
                this.path.offset(value.x, value.y);
                this.path.close();
                return;
            }
        }
    }

    private void iB() {
        int floor = (int) Math.floor(this.Ec.getValue().floatValue());
        double radians = Math.toRadians((this.Ed == null ? 0.0d : this.Ed.getValue().floatValue()) - 90.0d);
        float f = (float) (6.283185307179586d / floor);
        float floatValue = this.Eh.getValue().floatValue() / 100.0f;
        float floatValue2 = this.Ef.getValue().floatValue();
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
                PointF value = this.DJ.getValue();
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
        if (t == com.airbnb.lottie.j.CQ) {
            this.Ec.a(cVar);
        } else if (t == com.airbnb.lottie.j.CV) {
            this.Ed.a(cVar);
        } else if (t == com.airbnb.lottie.j.CI) {
            this.DJ.a(cVar);
        } else if (t == com.airbnb.lottie.j.CW && this.Ee != null) {
            this.Ee.a(cVar);
        } else if (t == com.airbnb.lottie.j.CX) {
            this.Ef.a(cVar);
        } else if (t == com.airbnb.lottie.j.CY && this.Eg != null) {
            this.Eg.a(cVar);
        } else if (t == com.airbnb.lottie.j.CZ) {
            this.Eh.a(cVar);
        }
    }
}
