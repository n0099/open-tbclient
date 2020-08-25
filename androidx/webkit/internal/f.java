package androidx.webkit.internal;
/* loaded from: classes4.dex */
public class f implements e {
    org.a.a.c zU;

    public f(org.a.a.c cVar) {
        this.zU = cVar;
    }

    @Override // androidx.webkit.internal.e
    public org.a.a.d hM() {
        return (org.a.a.d) org.a.a.a.a.a(org.a.a.d.class, this.zU.eiZ());
    }

    @Override // androidx.webkit.internal.e
    public String[] hN() {
        return this.zU.getSupportedFeatures();
    }
}
