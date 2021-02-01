package com.baidu.lbsapi;

import android.app.Application;
import android.content.Context;
import com.baidu.lbsapi.auth.LBSAuthManager;
import com.baidu.pano.platform.c.b;
/* loaded from: classes4.dex */
public class BMapManager {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f2475a = true;

    /* renamed from: b  reason: collision with root package name */
    private Context f2476b;

    static {
        System.loadLibrary("app_BaiduPanoramaAppLib");
    }

    public BMapManager(Context context) {
        if (!(context instanceof Application)) {
            throw new IllegalArgumentException("BMapManager is a Globle project, context should be a Application Context");
        }
        this.f2476b = context;
    }

    public boolean init(MKGeneralListener mKGeneralListener) {
        LBSAuthManager.getInstance(this.f2476b).authenticate(true, "lbs_panosdk", null, new a(this, mKGeneralListener));
        b.a().a(this.f2476b);
        return true;
    }

    public static boolean isIllegalPanoSDKUser() {
        return f2475a;
    }
}
