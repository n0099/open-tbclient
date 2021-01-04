package com.baidu.location.a;

import android.content.Context;
import android.util.Log;
import com.baidu.lbsapi.auth.LBSAuthManager;
import com.baidu.lbsapi.auth.LBSAuthManagerListener;
import org.json.JSONObject;
/* loaded from: classes15.dex */
public class a implements LBSAuthManagerListener {

    /* renamed from: b  reason: collision with root package name */
    private static Object f2577b = new Object();
    private static a c = null;
    private int d = 0;
    private Context e = null;
    private long f = 0;
    private String g = null;

    /* renamed from: a  reason: collision with root package name */
    public int f2578a = 0;

    public static a a() {
        a aVar;
        synchronized (f2577b) {
            if (c == null) {
                c = new a();
            }
            aVar = c;
        }
        return aVar;
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
        this.e = context;
        LBSAuthManager.getInstance(this.e).authenticate(false, "lbs_locsdk", null, this);
        this.f = System.currentTimeMillis();
    }

    public boolean b() {
        boolean z = true;
        if (this.d != 0 && this.d != 602 && this.d != 601 && this.d != -10 && this.d != -11) {
            z = false;
        }
        if (this.e != null) {
            long currentTimeMillis = System.currentTimeMillis() - this.f;
            if (z) {
                if (currentTimeMillis > 86400000) {
                    LBSAuthManager.getInstance(this.e).authenticate(false, "lbs_locsdk", null, this);
                    this.f = System.currentTimeMillis();
                }
            } else if (currentTimeMillis < 0 || currentTimeMillis > 10000) {
                LBSAuthManager.getInstance(this.e).authenticate(false, "lbs_locsdk", null, this);
                this.f = System.currentTimeMillis();
            }
        }
        return z;
    }

    @Override // com.baidu.lbsapi.auth.LBSAuthManagerListener
    public void onAuthResult(int i, String str) {
        this.d = i;
        if (this.d == 0) {
            Log.i(com.baidu.location.e.a.f2709a, "LocationAuthManager Authentication AUTHENTICATE_SUCC");
        } else {
            Log.i(com.baidu.location.e.a.f2709a, "LocationAuthManager Authentication Error errorcode = " + i + " , msg = " + str);
        }
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject != null && jSONObject.has("token") && jSONObject.getString("token") != null) {
                    this.g = jSONObject.getString("token");
                }
                if (jSONObject == null || !jSONObject.has("ak_permission") || jSONObject.getInt("ak_permission") == 0) {
                    return;
                }
                this.f2578a = jSONObject.getInt("ak_permission");
                Log.i(com.baidu.location.e.a.f2709a, "LocationAuthManager ak_permission = " + this.f2578a);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
