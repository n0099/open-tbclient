package com.baidu.platform.comapi.wnplatform.model.datastruct;
/* loaded from: classes2.dex */
public class a implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    public double f10324a;

    /* renamed from: b  reason: collision with root package name */
    public double f10325b;

    /* renamed from: c  reason: collision with root package name */
    public double f10326c;

    /* renamed from: d  reason: collision with root package name */
    public double f10327d;

    /* renamed from: e  reason: collision with root package name */
    public double f10328e;

    /* renamed from: f  reason: collision with root package name */
    public double f10329f;

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: a */
    public a clone() {
        a aVar = new a();
        synchronized (this) {
            aVar.f10324a = this.f10324a;
            aVar.f10325b = this.f10325b;
            aVar.f10326c = this.f10326c;
            aVar.f10327d = this.f10327d;
            aVar.f10328e = this.f10328e;
            aVar.f10329f = this.f10329f;
        }
        return aVar;
    }

    public String toString() {
        return String.format("SensorData {accx:%1$f accy:%2$f accz:%3$f heading:%4$f pitch:%5$f roll:%6$f}", Double.valueOf(this.f10324a), Double.valueOf(this.f10325b), Double.valueOf(this.f10326c), Double.valueOf(this.f10327d), Double.valueOf(this.f10328e), Double.valueOf(this.f10329f));
    }
}
