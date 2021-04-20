package a.a.a.a.v.f;
/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a  reason: collision with root package name */
    public static final f<d> f1357a = new a();

    /* loaded from: classes.dex */
    public static class a extends f<d> {
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // a.a.a.a.v.f.f
        public d a() {
            return new e("https://rpe.xdplt.com/evt/");
        }
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [T, java.lang.Object] */
    public static d a() {
        d dVar;
        f<d> fVar = f1357a;
        synchronized (fVar) {
            if (fVar.f1364a == null) {
                fVar.f1364a = fVar.a();
            }
            dVar = fVar.f1364a;
        }
        return dVar;
    }
}
