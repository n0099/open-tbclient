package com.baidu.lbsapi;

import android.app.Application;
import android.content.Context;
import com.baidu.lbsapi.auth.LBSAuthManager;
import com.baidu.pano.platform.c.b;
/* loaded from: classes3.dex */
public class BMapManager {
    private static boolean a = true;
    private Context b;

    static {
        try {
            System.loadLibrary("app_BaiduPanoramaAppLib");
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (SecurityException e2) {
            e2.printStackTrace();
        } catch (Exception e3) {
            e3.printStackTrace();
        } catch (UnsatisfiedLinkError e4) {
            e4.printStackTrace();
        }
    }

    public BMapManager(Context context) {
        if (!(context instanceof Application)) {
            throw new IllegalArgumentException("BMapManager is a Globle project, context should be a Application Context");
        }
        this.b = context;
    }

    public boolean init(MKGeneralListener mKGeneralListener) {
        LBSAuthManager.getInstance(this.b).authenticate(true, "lbs_panosdk", null, new a(this, mKGeneralListener));
        b.a().a(this.b);
        return true;
    }

    public static boolean isIllegalPanoSDKUser() {
        return a;
    }
}
