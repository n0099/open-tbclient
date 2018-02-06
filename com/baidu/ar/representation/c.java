package com.baidu.ar.representation;
/* loaded from: classes3.dex */
public class c {
    private static c d = new c();
    public float a;
    public float b;
    public float c;

    public c() {
        this.a = 0.0f;
        this.b = 0.0f;
        this.c = 0.0f;
    }

    public c(float f, float f2, float f3) {
        this.a = f;
        this.b = f2;
        this.c = f3;
    }

    public float a(c cVar) {
        return (float) Math.sqrt(((this.a - cVar.a) * (this.a - cVar.a)) + ((this.b - cVar.b) * (this.b - cVar.b)) + ((this.c - cVar.c) * (this.c - cVar.c)));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: a */
    public c clone() {
        return new c(this.a, this.b, this.c);
    }

    public void a(float f, float f2, float f3) {
        this.a = f;
        this.b = f2;
        this.c = f3;
    }

    public String b() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append((int) this.a);
        stringBuffer.append(", ");
        stringBuffer.append((int) this.b);
        stringBuffer.append(", ");
        stringBuffer.append((int) this.c);
        return stringBuffer.toString();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.a);
        stringBuffer.append(", ");
        stringBuffer.append(this.b);
        stringBuffer.append(", ");
        stringBuffer.append(this.c);
        return stringBuffer.toString();
    }
}
