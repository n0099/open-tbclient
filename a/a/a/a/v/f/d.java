package a.a.a.a.v.f;
/* loaded from: classes4.dex */
public abstract class d {
    public static final f<d> BR = new a();

    /* loaded from: classes4.dex */
    public static class a extends f<d> {
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // a.a.a.a.v.f.f
        public d a() {
            return new e("https://rpe.xdplt.com/evt/");
        }
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [T, java.lang.Object] */
    public static d hw() {
        d dVar;
        f<d> fVar = BR;
        synchronized (fVar) {
            if (fVar.f1011a == null) {
                fVar.f1011a = fVar.a();
            }
            dVar = fVar.f1011a;
        }
        return dVar;
    }
}
