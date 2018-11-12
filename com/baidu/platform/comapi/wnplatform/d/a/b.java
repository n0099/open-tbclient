package com.baidu.platform.comapi.wnplatform.d.a;
/* loaded from: classes4.dex */
public class b implements Cloneable {
    public double a;
    public double b;
    public double c;
    public double d;
    public double e;
    public double f;

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: a */
    public b clone() {
        b bVar = new b();
        synchronized (this) {
            bVar.a = this.a;
            bVar.b = this.b;
            bVar.c = this.c;
            bVar.d = this.d;
            bVar.e = this.e;
            bVar.f = this.f;
        }
        return bVar;
    }

    public String toString() {
        return String.format("SensorData {accx:%1$f accy:%2$f accz:%3$f heading:%4$f pitch:%5$f roll:%6$f}", Double.valueOf(this.a), Double.valueOf(this.b), Double.valueOf(this.c), Double.valueOf(this.d), Double.valueOf(this.e), Double.valueOf(this.f));
    }
}
