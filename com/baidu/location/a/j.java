package com.baidu.location.a;

import android.content.Context;
import android.util.Log;
import com.baidu.lbsapi.auth.LBSAuthManager;
import com.baidu.lbsapi.auth.LBSAuthManagerListener;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class j implements LBSAuthManagerListener {

    /* renamed from: a  reason: collision with root package name */
    public static Object f6527a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public static j f6528b;

    /* renamed from: c  reason: collision with root package name */
    public int f6529c = 0;

    /* renamed from: d  reason: collision with root package name */
    public Context f6530d = null;

    /* renamed from: e  reason: collision with root package name */
    public long f6531e = 0;

    /* renamed from: f  reason: collision with root package name */
    public String f6532f = null;

    public static j a() {
        j jVar;
        synchronized (f6527a) {
            if (f6528b == null) {
                f6528b = new j();
            }
            jVar = f6528b;
        }
        return jVar;
    }

    public static String b(Context context) {
        try {
            return LBSAuthManager.getInstance(context).getPublicKey(context);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String c(Context context) {
        try {
            return LBSAuthManager.getInstance(context).getMCode();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public void a(Context context) {
        this.f6530d = context;
        LBSAuthManager.getInstance(context).authenticate(false, "lbs_locsdk", null, this);
        this.f6531e = System.currentTimeMillis();
    }

    public boolean b() {
        int i = this.f6529c;
        boolean z = i == 0 || i == 602 || i == 601 || i == -10 || i == -11;
        if (this.f6530d != null) {
            long currentTimeMillis = System.currentTimeMillis() - this.f6531e;
            if (!z ? currentTimeMillis < 0 || currentTimeMillis > 10000 : currentTimeMillis > 86400000) {
                LBSAuthManager.getInstance(this.f6530d).authenticate(false, "lbs_locsdk", null, this);
                this.f6531e = System.currentTimeMillis();
            }
        }
        return z;
    }

    @Override // com.baidu.lbsapi.auth.LBSAuthManagerListener
    public void onAuthResult(int i, String str) {
        this.f6529c = i;
        if (i == 0) {
            Log.i(com.baidu.location.d.a.f6669a, "LocationAuthManager Authentication AUTHENTICATE_SUCC");
        } else {
            String str2 = com.baidu.location.d.a.f6669a;
            Log.i(str2, "LocationAuthManager Authentication Error errorcode = " + i + " , msg = " + str);
        }
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.getString("token") != null) {
                    this.f6532f = jSONObject.getString("token");
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
