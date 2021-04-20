package a.a.a.a.u;

import a.a.a.a.s.e;
import android.util.Pair;
import java.util.HashMap;
import java.util.Random;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class b implements a {

    /* renamed from: c  reason: collision with root package name */
    public static a f1339c = new d();

    /* renamed from: d  reason: collision with root package name */
    public static final Random f1340d = new Random();

    /* renamed from: a  reason: collision with root package name */
    public final e.a f1341a;

    /* renamed from: b  reason: collision with root package name */
    public final HashMap<Object, o> f1342b = new HashMap<>();

    public b(e.a aVar) {
        this.f1341a = aVar;
    }

    @Override // a.a.a.a.u.a
    public final void a(Object obj) {
        synchronized (this.f1342b) {
            this.f1342b.remove(obj);
        }
    }

    @Override // a.a.a.a.u.a
    public void a(Object obj, String str) {
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: java.util.HashMap<java.lang.Object, a.a.a.a.u.o> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // a.a.a.a.u.a
    public final o b(Object obj) {
        synchronized (this.f1342b) {
            o oVar = this.f1342b.get(obj);
            if (oVar != null) {
                return oVar;
            }
            Pair<o, JSONObject> c2 = c(obj);
            if (c2 != null && c2.first != null) {
                this.f1342b.put(obj, c2.first);
                return (o) c2.first;
            }
            return null;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.util.HashMap<java.lang.Object, a.a.a.a.u.o> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // a.a.a.a.u.a
    public final void b(Object obj, String str) {
        Pair<o, JSONObject> c2;
        if (f1340d.nextFloat() < this.f1341a.f1323f && (c2 = c(obj)) != null) {
            Object obj2 = c2.second;
            if (obj2 != null) {
                JSONObject jSONObject = (JSONObject) obj2;
            }
            Object obj3 = c2.first;
            if (obj3 != null) {
                o oVar = (o) obj3;
                synchronized (this.f1342b) {
                    this.f1342b.put(obj, c2.first);
                }
            }
        }
    }

    public abstract Pair<o, JSONObject> c(Object obj);
}
