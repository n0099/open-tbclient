package com.baidu.lbsapi;

import android.app.Application;
import android.content.Context;
import com.baidu.lbsapi.auth.LBSAuthManager;
import com.baidu.pano.platform.c.b;
/* loaded from: classes2.dex */
public class BMapManager {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f6530a = true;

    /* renamed from: b  reason: collision with root package name */
    public Context f6531b;

    static {
        System.loadLibrary("app_BaiduPanoramaAppLib");
    }

    public BMapManager(Context context) {
        if (context instanceof Application) {
            this.f6531b = context;
            return;
        }
        throw new IllegalArgumentException("BMapManager is a Globle project, context should be a Application Context");
    }

    public static boolean isIllegalPanoSDKUser() {
        return f6530a;
    }

    public boolean init(MKGeneralListener mKGeneralListener) {
        LBSAuthManager.getInstance(this.f6531b).authenticate(true, "lbs_panosdk", null, new a(this, mKGeneralListener));
        b.a().a(this.f6531b);
        return true;
    }
}
