package com.baidu.platform.comapi.wnplatform.model.datastruct;
/* loaded from: classes4.dex */
public class a implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    public double f4440a;

    /* renamed from: b  reason: collision with root package name */
    public double f4441b;
    public double c;
    public double d;
    public double e;
    public double f;

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: a */
    public a clone() {
        a aVar = new a();
        synchronized (this) {
            aVar.f4440a = this.f4440a;
            aVar.f4441b = this.f4441b;
            aVar.c = this.c;
            aVar.d = this.d;
            aVar.e = this.e;
            aVar.f = this.f;
        }
        return aVar;
    }

    public String toString() {
        return String.format("SensorData {accx:%1$f accy:%2$f accz:%3$f heading:%4$f pitch:%5$f roll:%6$f}", Double.valueOf(this.f4440a), Double.valueOf(this.f4441b), Double.valueOf(this.c), Double.valueOf(this.d), Double.valueOf(this.e), Double.valueOf(this.f));
    }
}
