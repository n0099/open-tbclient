package com.baidu.platform.comapi.wnplatform.model.datastruct;
/* loaded from: classes2.dex */
public class a implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    public double f9882a;

    /* renamed from: b  reason: collision with root package name */
    public double f9883b;

    /* renamed from: c  reason: collision with root package name */
    public double f9884c;

    /* renamed from: d  reason: collision with root package name */
    public double f9885d;

    /* renamed from: e  reason: collision with root package name */
    public double f9886e;

    /* renamed from: f  reason: collision with root package name */
    public double f9887f;

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: a */
    public a clone() {
        a aVar = new a();
        synchronized (this) {
            aVar.f9882a = this.f9882a;
            aVar.f9883b = this.f9883b;
            aVar.f9884c = this.f9884c;
            aVar.f9885d = this.f9885d;
            aVar.f9886e = this.f9886e;
            aVar.f9887f = this.f9887f;
        }
        return aVar;
    }

    public String toString() {
        return String.format("SensorData {accx:%1$f accy:%2$f accz:%3$f heading:%4$f pitch:%5$f roll:%6$f}", Double.valueOf(this.f9882a), Double.valueOf(this.f9883b), Double.valueOf(this.f9884c), Double.valueOf(this.f9885d), Double.valueOf(this.f9886e), Double.valueOf(this.f9887f));
    }
}
