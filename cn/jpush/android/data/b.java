package cn.jpush.android.data;

import android.content.Context;
import android.support.v4.view.PointerIconCompat;
import android.text.TextUtils;
import cn.jpush.android.a.i;
import com.baidu.tbadk.TbConfig;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class b implements Serializable {
    public int A;
    public String B;
    public String I;
    public int b;
    public String c;
    public String d;
    public boolean f;
    public int g;
    public boolean i;
    public String j;
    public String k;
    public String m;
    public String n;
    public String o;
    public String p;
    public int q;
    public boolean r;
    public int t;
    public String u;
    public String v;
    public int w;
    public String x;
    public String y;
    public String z;
    public byte e = 0;
    public int h = 0;
    public int l = -1;
    public List<String> s = null;
    public boolean C = false;
    public boolean D = false;
    public boolean E = false;
    private boolean a = false;
    public boolean F = false;
    public int G = -1;
    public ArrayList<String> H = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(ArrayList<String> arrayList, Context context, String str, String str2, boolean z) {
        if (!i.a(str) || context == null || arrayList.size() <= 0 || TextUtils.isEmpty(str2)) {
            return true;
        }
        Iterator<String> it = arrayList.iterator();
        boolean z2 = true;
        while (it.hasNext()) {
            String next = it.next();
            String str3 = (next == null || next.startsWith("http://")) ? next : str + next;
            byte[] a = cn.jpush.android.b.a.a(str3, 5, TbConfig.NOTIFY_SOUND_INTERVAL, 4);
            if (a != null) {
                try {
                    if (next.startsWith("http://")) {
                        next = cn.jpush.android.d.c.a(next);
                    }
                    cn.jpush.android.d.c.a(!z ? cn.jpush.android.d.c.a(context, str2) + next : cn.jpush.android.d.c.b(context, str2) + next, a);
                } catch (Exception e) {
                    cn.jpush.android.d.f.c("Entity", "Write storage error,  create img file fail.", e);
                    z2 = false;
                }
            } else {
                cn.jpush.android.a.e.a(str2, PointerIconCompat.TYPE_GRAB, cn.jpush.android.d.a.a(context, str3), context);
                z2 = false;
            }
        }
        return z2;
    }

    public abstract void a(Context context);

    public final void a(boolean z) {
        this.a = true;
    }

    public final boolean a() {
        return this.a;
    }

    public final boolean a(Context context, JSONObject jSONObject) {
        this.r = jSONObject.optInt("full_screen", 0) > 0;
        this.t = jSONObject.optInt("n_flag", 0);
        this.u = jSONObject.optString("n_title", "");
        this.v = jSONObject.optString("n_content", "");
        this.w = jSONObject.optInt("n_style", 0);
        this.x = jSONObject.optString("n_big_text", "");
        this.y = jSONObject.optString("n_big_pic_path", "");
        this.z = jSONObject.optString("n_inbox", "");
        this.n = jSONObject.optString("n_extras", "");
        this.A = jSONObject.optInt("n_priority", 0);
        this.B = jSONObject.optString("n_category", "");
        this.l = jSONObject.optInt("n_alert_type", -1);
        if (TextUtils.isEmpty(this.u)) {
            if (!this.i) {
                cn.jpush.android.a.e.a(this.c, 996, null, context);
                return false;
            }
            this.u = cn.jpush.android.a.d;
        }
        JSONObject a = i.a(context, this.c, jSONObject, "ad_content");
        if (a == null) {
            return this.i && this.f;
        }
        if (this.i && this.f) {
            this.a = true;
        }
        return a(a);
    }

    protected abstract boolean a(JSONObject jSONObject);
}
