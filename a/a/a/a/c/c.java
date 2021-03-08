package a.a.a.a.c;

import a.a.a.a.a.e;
import android.util.Pair;
import java.util.HashMap;
import java.util.Random;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public abstract class c implements a {
    public static a BL = new e();
    public static final Random zH = new Random();
    public final e.a BM;
    public final HashMap<Object, p> b = new HashMap<>();

    public c(e.a aVar) {
        this.BM = aVar;
    }

    @Override // a.a.a.a.c.a
    public final void a(Object obj) {
        synchronized (this.b) {
            this.b.remove(obj);
        }
    }

    @Override // a.a.a.a.c.a
    public void a(Object obj, String str) {
        if (i(obj) == null) {
            a.a.a.a.v.d.a("Cannot get RippedAd from adObj:%s", obj.toString());
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v7, resolved type: java.util.HashMap<java.lang.Object, a.a.a.a.c.p> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // a.a.a.a.c.a
    public final void b(Object obj, String str) {
        Pair<p, JSONObject> j;
        if (zH.nextFloat() < this.BM.f && (j = j(obj)) != null) {
            Object obj2 = j.second;
            if (obj2 != null) {
                JSONObject jSONObject = (JSONObject) obj2;
            }
            Object obj3 = j.first;
            if (obj3 != null) {
                p pVar = (p) obj3;
                synchronized (this.b) {
                    this.b.put(obj, j.first);
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: java.util.HashMap<java.lang.Object, a.a.a.a.c.p> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // a.a.a.a.c.a
    public final p i(Object obj) {
        p pVar;
        synchronized (this.b) {
            pVar = this.b.get(obj);
            if (pVar == null) {
                Pair<p, JSONObject> j = j(obj);
                if (j == null || j.first == null) {
                    pVar = null;
                } else {
                    this.b.put(obj, j.first);
                    pVar = (p) j.first;
                }
            }
        }
        return pVar;
    }

    public abstract Pair<p, JSONObject> j(Object obj);
}
