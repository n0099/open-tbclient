package a.a.a.a.u;

import a.a.a.a.s.e;
import android.util.Pair;
import java.util.HashMap;
import java.util.Random;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class c implements a {

    /* renamed from: c  reason: collision with root package name */
    public static a f1353c = new e();

    /* renamed from: d  reason: collision with root package name */
    public static final Random f1354d = new Random();

    /* renamed from: a  reason: collision with root package name */
    public final e.a f1355a;

    /* renamed from: b  reason: collision with root package name */
    public final HashMap<Object, p> f1356b = new HashMap<>();

    public c(e.a aVar) {
        this.f1355a = aVar;
    }

    @Override // a.a.a.a.u.a
    public final void a(Object obj) {
        synchronized (this.f1356b) {
            this.f1356b.remove(obj);
        }
    }

    @Override // a.a.a.a.u.a
    public void a(Object obj, String str) {
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: java.util.HashMap<java.lang.Object, a.a.a.a.u.p> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // a.a.a.a.u.a
    public final p b(Object obj) {
        synchronized (this.f1356b) {
            p pVar = this.f1356b.get(obj);
            if (pVar != null) {
                return pVar;
            }
            Pair<p, JSONObject> c2 = c(obj);
            if (c2 != null && c2.first != null) {
                this.f1356b.put(obj, c2.first);
                return (p) c2.first;
            }
            return null;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.util.HashMap<java.lang.Object, a.a.a.a.u.p> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // a.a.a.a.u.a
    public final void b(Object obj, String str) {
        Pair<p, JSONObject> c2;
        if (f1354d.nextFloat() < this.f1355a.f1337f && (c2 = c(obj)) != null) {
            Object obj2 = c2.second;
            if (obj2 != null) {
                JSONObject jSONObject = (JSONObject) obj2;
            }
            Object obj3 = c2.first;
            if (obj3 != null) {
                p pVar = (p) obj3;
                synchronized (this.f1356b) {
                    this.f1356b.put(obj, c2.first);
                }
            }
        }
    }

    public abstract Pair<p, JSONObject> c(Object obj);
}
