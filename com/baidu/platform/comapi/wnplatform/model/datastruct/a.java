package com.baidu.platform.comapi.wnplatform.model.datastruct;
/* loaded from: classes2.dex */
public class a implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    public double f10249a;

    /* renamed from: b  reason: collision with root package name */
    public double f10250b;

    /* renamed from: c  reason: collision with root package name */
    public double f10251c;

    /* renamed from: d  reason: collision with root package name */
    public double f10252d;

    /* renamed from: e  reason: collision with root package name */
    public double f10253e;

    /* renamed from: f  reason: collision with root package name */
    public double f10254f;

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: a */
    public a clone() {
        a aVar = new a();
        synchronized (this) {
            aVar.f10249a = this.f10249a;
            aVar.f10250b = this.f10250b;
            aVar.f10251c = this.f10251c;
            aVar.f10252d = this.f10252d;
            aVar.f10253e = this.f10253e;
            aVar.f10254f = this.f10254f;
        }
        return aVar;
    }

    public String toString() {
        return String.format("SensorData {accx:%1$f accy:%2$f accz:%3$f heading:%4$f pitch:%5$f roll:%6$f}", Double.valueOf(this.f10249a), Double.valueOf(this.f10250b), Double.valueOf(this.f10251c), Double.valueOf(this.f10252d), Double.valueOf(this.f10253e), Double.valueOf(this.f10254f));
    }
}
