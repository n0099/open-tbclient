package a.a.a.a.v.f.g;

import a.a.a.a.v.f.e;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a  reason: collision with root package name */
    public final a.a.a.a.v.f.d f1378a = a.a.a.a.v.f.d.a();

    /* renamed from: b  reason: collision with root package name */
    public final String f1379b;

    /* renamed from: c  reason: collision with root package name */
    public final String f1380c;

    /* loaded from: classes.dex */
    public class a extends HashMap<String, Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f1381a;

        public a(String str) {
            this.f1381a = str;
            put("st", this.f1381a);
            put("sid", d.this.f1379b);
            put("ldr_i", Integer.valueOf(a.a.a.a.v.b.a(d.this.f1379b)));
            put("type", d.this.f1380c);
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
    public static class C0005d extends d {
        public C0005d(String str) {
            super(str, "s");
        }
    }

    public d(String str, String str2) {
        this.f1379b = str;
        this.f1380c = str2;
    }

    public final void a(String str) {
        ((e) this.f1378a).f1358b.obtainMessage(0, new e.a("ad_ldr", new JSONObject(new a(str)))).sendToTarget();
    }

    public void a() {
        int a2 = a.a.a.a.v.b.a(this.f1379b);
        a.a.a.a.v.b.f1345a.edit().putInt("key_sid_c_pre_" + this.f1379b, a2 + 1).apply();
        a("ldr_ld_start");
    }
}
