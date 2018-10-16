package com.baidu.location.a;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.ng.ai.apps.trace.ErrDef;
import java.util.Hashtable;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class h implements com.baidu.d.a.a {
    private static Object a = new Object();
    private static h adJ = null;
    private int c = 0;
    private Context d = null;
    private long e = 0;
    private String f = null;

    public static String b(Context context) {
        try {
            return com.baidu.d.a.h.bn(context).b(context);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String c(Context context) {
        try {
            return com.baidu.d.a.h.bn(context).a();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static h tp() {
        h hVar;
        synchronized (a) {
            if (adJ == null) {
                adJ = new h();
            }
            hVar = adJ;
        }
        return hVar;
    }

    public void a(Context context) {
        this.d = context;
        com.baidu.d.a.h.bn(this.d).a(false, "lbs_locsdk", (Hashtable<String, String>) null, (com.baidu.d.a.a) this);
        this.e = System.currentTimeMillis();
    }

    public boolean b() {
        boolean z = true;
        if (this.c != 0 && this.c != 602 && this.c != 601 && this.c != -10 && this.c != -11) {
            z = false;
        }
        if (this.d != null) {
            long currentTimeMillis = System.currentTimeMillis() - this.e;
            if (z) {
                if (currentTimeMillis > 86400000) {
                    com.baidu.d.a.h.bn(this.d).a(false, "lbs_locsdk", (Hashtable<String, String>) null, (com.baidu.d.a.a) this);
                    this.e = System.currentTimeMillis();
                }
            } else if (currentTimeMillis < 0 || currentTimeMillis > ErrDef.Feature.WEIGHT) {
                com.baidu.d.a.h.bn(this.d).a(false, "lbs_locsdk", (Hashtable<String, String>) null, (com.baidu.d.a.a) this);
                this.e = System.currentTimeMillis();
            }
        }
        return z;
    }

    @Override // com.baidu.d.a.a
    public void g(int i, String str) {
        this.c = i;
        if (this.c == 0) {
            Log.i(com.baidu.location.d.a.a, "LocationAuthManager Authentication AUTHENTICATE_SUCC");
        } else {
            Log.i(com.baidu.location.d.a.a, "LocationAuthManager Authentication Error errorcode = " + i + " , msg = " + str);
        }
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject == null || jSONObject.getString("token") == null) {
                    return;
                }
                this.f = jSONObject.getString("token");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
