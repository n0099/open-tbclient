package com.baidu.location.a;

import android.content.Context;
import android.util.Log;
import com.baidu.lbsapi.auth.LBSAuthManager;
import com.baidu.lbsapi.auth.LBSAuthManagerListener;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class j implements LBSAuthManagerListener {
    private static Object a = new Object();
    private static j b = null;
    private int c = 0;
    private Context d = null;
    private long e = 0;
    private String f = null;

    public static j a() {
        j jVar;
        synchronized (a) {
            if (b == null) {
                b = new j();
            }
            jVar = b;
        }
        return jVar;
    }

    public static String b(Context context) {
        try {
            return LBSAuthManager.getInstance(context).getPublicKey(context);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String c(Context context) {
        try {
            return LBSAuthManager.getInstance(context).getMCode();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void a(Context context) {
        this.d = context;
        LBSAuthManager.getInstance(this.d).authenticate(false, "lbs_locsdk", null, this);
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
                    LBSAuthManager.getInstance(this.d).authenticate(false, "lbs_locsdk", null, this);
                    this.e = System.currentTimeMillis();
                }
            } else if (currentTimeMillis < 0 || currentTimeMillis > 10000) {
                LBSAuthManager.getInstance(this.d).authenticate(false, "lbs_locsdk", null, this);
                this.e = System.currentTimeMillis();
            }
        }
        return z;
    }

    @Override // com.baidu.lbsapi.auth.LBSAuthManagerListener
    public void onAuthResult(int i, String str) {
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
