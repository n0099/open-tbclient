package com.baidu.platform.comapi.wnplatform.model.datastruct;
/* loaded from: classes3.dex */
public class a implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    public double f4668a;

    /* renamed from: b  reason: collision with root package name */
    public double f4669b;
    public double c;
    public double d;
    public double e;
    public double f;

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: a */
    public a clone() {
        a aVar = new a();
        synchronized (this) {
            aVar.f4668a = this.f4668a;
            aVar.f4669b = this.f4669b;
            aVar.c = this.c;
            aVar.d = this.d;
            aVar.e = this.e;
            aVar.f = this.f;
        }
        return aVar;
    }

    public String toString() {
        return String.format("SensorData {accx:%1$f accy:%2$f accz:%3$f heading:%4$f pitch:%5$f roll:%6$f}", Double.valueOf(this.f4668a), Double.valueOf(this.f4669b), Double.valueOf(this.c), Double.valueOf(this.d), Double.valueOf(this.e), Double.valueOf(this.f));
    }
}
