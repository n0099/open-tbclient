package a.a.a.a.v.f.g;

import a.a.a.a.v.f.e;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public abstract class d {
    public final a.a.a.a.v.f.d BV = a.a.a.a.v.f.d.hw();
    public final String b;
    public final String c;

    /* loaded from: classes4.dex */
    public class a extends HashMap<String, Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f1014a;

        public a(String str) {
            this.f1014a = str;
            put("st", this.f1014a);
            put(UbcStatConstant.KEY_CONTENT_EXT_SID, d.this.b);
            put("ldr_i", Integer.valueOf(a.a.a.a.v.b.a(d.this.b)));
            put("type", d.this.c);
        }
    }

    /* loaded from: classes4.dex */
    public static class b extends d {
        public b(String str) {
            super(str, "p");
        }
    }

    /* loaded from: classes4.dex */
    public static class c extends d {
        public c(String str) {
            super(str, "s");
        }
    }

    public d(String str, String str2) {
        this.b = str;
        this.c = str2;
    }

    public final void a(String str) {
        ((e) this.BV).b.obtainMessage(0, new e.a("ad_ldr", new JSONObject(new a(str)))).sendToTarget();
    }

    public void a() {
        String str = "key_sid_c_pre_" + this.b;
        a.a.a.a.v.b.f1006a.edit().putInt(str, a.a.a.a.v.b.a(this.b) + 1).apply();
        a("ldr_ld_start");
    }
}
