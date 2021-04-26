package a.a.a.a.x.f;
/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a  reason: collision with root package name */
    public static final f<d> f1373a = new a();

    /* loaded from: classes.dex */
    public static class a extends f<d> {
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // a.a.a.a.x.f.f
        public d a() {
            return new e("https://rpe.xdplt.com/evt/");
        }
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [T, java.lang.Object] */
    public static d a() {
        d dVar;
        f<d> fVar = f1373a;
        synchronized (fVar) {
            if (fVar.f1380a == null) {
                fVar.f1380a = fVar.a();
            }
            dVar = fVar.f1380a;
        }
        return dVar;
    }

    public abstract void a(String str, String str2, Object obj);
}
