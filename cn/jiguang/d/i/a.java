package cn.jiguang.d.i;

import android.content.Context;
import cn.jiguang.d.d.aa;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class a<T> {
    protected long a;
    protected String b;
    protected long c;
    protected String d = "";

    public final void a(long j) {
        this.a = 3600L;
    }

    public final void a(Context context, boolean z) {
        if (context != null && a()) {
            if (z || a(context)) {
                b(context);
                d(context);
            }
        }
    }

    public final void a(String str) {
        this.b = str;
    }

    protected boolean a() {
        return true;
    }

    protected abstract boolean a(Context context);

    public final void b(long j) {
        this.c = j;
    }

    protected abstract void b(Context context);

    public final void b(String str) {
        this.d = str;
    }

    protected abstract ArrayList<cn.jiguang.d.d.a> c(Context context);

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(Context context, String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aa.a(context, aa.a(context, jSONObject, str));
    }

    public abstract void d(Context context);
}
