package com.baidu.location.a;

import android.content.Context;
import android.util.Log;
import com.baidu.lbsapi.auth.LBSAuthManager;
import com.baidu.lbsapi.auth.LBSAuthManagerListener;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a implements LBSAuthManagerListener {

    /* renamed from: a  reason: collision with root package name */
    public static Object f6525a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public static a f6526b;

    /* renamed from: c  reason: collision with root package name */
    public int f6527c = 0;

    /* renamed from: d  reason: collision with root package name */
    public Context f6528d = null;

    /* renamed from: e  reason: collision with root package name */
    public long f6529e = 0;

    /* renamed from: f  reason: collision with root package name */
    public String f6530f = null;

    public static a a() {
        a aVar;
        synchronized (f6525a) {
            if (f6526b == null) {
                f6526b = new a();
            }
            aVar = f6526b;
        }
        return aVar;
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
        this.f6528d = context;
        LBSAuthManager.getInstance(context).authenticate(false, "lbs_locsdk", null, this);
        this.f6529e = System.currentTimeMillis();
    }

    public boolean b() {
        int i2 = this.f6527c;
        boolean z = i2 == 0 || i2 == 602 || i2 == 601 || i2 == -10 || i2 == -11;
        if (this.f6528d != null) {
            long currentTimeMillis = System.currentTimeMillis() - this.f6529e;
            if (!z ? currentTimeMillis < 0 || currentTimeMillis > 10000 : currentTimeMillis > 86400000) {
                LBSAuthManager.getInstance(this.f6528d).authenticate(false, "lbs_locsdk", null, this);
                this.f6529e = System.currentTimeMillis();
            }
        }
        return z;
    }

    @Override // com.baidu.lbsapi.auth.LBSAuthManagerListener
    public void onAuthResult(int i2, String str) {
        this.f6527c = i2;
        if (i2 == 0) {
            Log.i(com.baidu.location.e.a.f6767a, "LocationAuthManager Authentication AUTHENTICATE_SUCC");
        } else {
            String str2 = com.baidu.location.e.a.f6767a;
            Log.i(str2, "LocationAuthManager Authentication Error errorcode = " + i2 + " , msg = " + str);
        }
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.getString("token") != null) {
                    this.f6530f = jSONObject.getString("token");
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
