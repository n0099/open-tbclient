package com.baidu.platform.comapi.wnplatform.d.a;
/* loaded from: classes4.dex */
public class a implements Cloneable {
    public double a = -1.0d;
    public double b = -1.0d;
    public float c;
    public float d;
    public float e;
    public int f;
    public double g;
    public int h;

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: a */
    public a clone() {
        a aVar = new a();
        synchronized (this) {
            aVar.e = this.e;
            aVar.d = this.d;
            aVar.a = this.a;
            aVar.b = this.b;
            aVar.f = this.f;
            aVar.c = this.c;
            aVar.g = this.g;
            aVar.h = this.h;
        }
        return aVar;
    }

    public String toString() {
        return String.format("WLocData {longitude:%1$f latitude:%2$f direction:%3$f speed:%4$f}", Double.valueOf(this.b), Double.valueOf(this.a), Float.valueOf(this.d), Float.valueOf(this.c));
    }
}
