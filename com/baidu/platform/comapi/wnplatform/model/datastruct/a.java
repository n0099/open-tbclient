package com.baidu.platform.comapi.wnplatform.model.datastruct;
/* loaded from: classes2.dex */
public class a implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    public double f10323a;

    /* renamed from: b  reason: collision with root package name */
    public double f10324b;

    /* renamed from: c  reason: collision with root package name */
    public double f10325c;

    /* renamed from: d  reason: collision with root package name */
    public double f10326d;

    /* renamed from: e  reason: collision with root package name */
    public double f10327e;

    /* renamed from: f  reason: collision with root package name */
    public double f10328f;

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: a */
    public a clone() {
        a aVar = new a();
        synchronized (this) {
            aVar.f10323a = this.f10323a;
            aVar.f10324b = this.f10324b;
            aVar.f10325c = this.f10325c;
            aVar.f10326d = this.f10326d;
            aVar.f10327e = this.f10327e;
            aVar.f10328f = this.f10328f;
        }
        return aVar;
    }

    public String toString() {
        return String.format("SensorData {accx:%1$f accy:%2$f accz:%3$f heading:%4$f pitch:%5$f roll:%6$f}", Double.valueOf(this.f10323a), Double.valueOf(this.f10324b), Double.valueOf(this.f10325c), Double.valueOf(this.f10326d), Double.valueOf(this.f10327e), Double.valueOf(this.f10328f));
    }
}
