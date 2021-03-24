package a.a.a.a.v.f.g;

import a.a.a.a.v.f.e;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a  reason: collision with root package name */
    public final a.a.a.a.v.f.d f1392a = a.a.a.a.v.f.d.a();

    /* renamed from: b  reason: collision with root package name */
    public final String f1393b;

    /* renamed from: c  reason: collision with root package name */
    public final String f1394c;

    /* loaded from: classes.dex */
    public class a extends HashMap<String, Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f1395a;

        public a(String str) {
            this.f1395a = str;
            put("st", this.f1395a);
            put("sid", d.this.f1393b);
            put("ldr_i", Integer.valueOf(a.a.a.a.v.b.a(d.this.f1393b)));
            put("type", d.this.f1394c);
        }
    }

    /* loaded from: classes.dex */
    public static class b extends d {
        public b(String str) {
            super(str, "n");
        }
    }

    /* loaded from: classes.dex */
    public static class c extends d {
        public c(String str) {
            super(str, "p");
        }
    }

    /* renamed from: a.a.a.a.v.f.g.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0006d extends d {
        public C0006d(String str) {
            super(str, "s");
        }
    }

    public d(String str, String str2) {
        this.f1393b = str;
        this.f1394c = str2;
    }

    public final void a(String str) {
        ((e) this.f1392a).f1372b.obtainMessage(0, new e.a("ad_ldr", new JSONObject(new a(str)))).sendToTarget();
    }

    public void a() {
        int a2 = a.a.a.a.v.b.a(this.f1393b);
        a.a.a.a.v.b.f1359a.edit().putInt("key_sid_c_pre_" + this.f1393b, a2 + 1).apply();
        a("ldr_ld_start");
    }
}
