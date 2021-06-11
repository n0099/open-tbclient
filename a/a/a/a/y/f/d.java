package a.a.a.a.y.f;

import java.util.Map;
/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a  reason: collision with root package name */
    public static final f<d> f1381a = new a();

    /* loaded from: classes.dex */
    public class a extends f<d> {
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // a.a.a.a.y.f.f
        public d a() {
            return new e("https://rpe.xdplt.com/evt/");
        }
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [T, java.lang.Object] */
    public static d a() {
        d dVar;
        f<d> fVar = f1381a;
        synchronized (fVar) {
            if (fVar.f1393a == null) {
                fVar.f1393a = fVar.a();
            }
            dVar = fVar.f1393a;
        }
        return dVar;
    }

    public abstract void a(String str, String str2, Object obj);

    public abstract void a(String str, Map<String, Object> map);
}
