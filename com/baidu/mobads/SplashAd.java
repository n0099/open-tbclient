package com.baidu.mobads;

import android.content.Context;
import android.text.TextUtils;
import android.view.SurfaceView;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.mobads.component.XAdView;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
/* loaded from: classes3.dex */
public class SplashAd {
    private static boolean d;

    /* renamed from: a  reason: collision with root package name */
    private com.baidu.mobads.production.g.a f3321a;

    /* renamed from: b  reason: collision with root package name */
    private int f3322b;
    private volatile String c;
    private SplashAdListener e;
    private IOAdEventListener f;
    public static String RSPLASH_PATTERN = "pattern";
    public static String RSPLASH_BTN_POS = "btn_pos";

    public SplashAd(Context context, ViewGroup viewGroup, SplashAdListener splashAdListener, String str) {
        this(context, viewGroup, splashAdListener, str, true);
    }

    public SplashAd(Context context, ViewGroup viewGroup, SplashAdListener splashAdListener, String str, boolean z) {
        this.f3322b = 4;
        this.c = OneKeyLoginSdkCall.l;
        this.e = new q(this);
        this.f = new r(this);
        try {
            com.baidu.mobads.a.a.l = System.currentTimeMillis();
            com.baidu.mobads.a.a.m = 0L;
            com.baidu.mobads.a.a.n = 0L;
            com.baidu.mobads.a.a.o = 0L;
            com.baidu.mobads.a.a.p = 0L;
            com.baidu.mobads.a.a.q = 0L;
            com.baidu.mobads.a.a.r = 0L;
            if (!AppActivity.isAnti()) {
                a(viewGroup, context);
            }
            if (splashAdListener != null) {
                this.e = splashAdListener;
            }
            if (TextUtils.isEmpty(str)) {
                this.e.onAdFailed("请您输入正确的广告位ID");
                return;
            }
            XAdView xAdView = new XAdView(context);
            xAdView.setListener(new t(this, context, xAdView, str, z));
            xAdView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            viewGroup.addView(xAdView);
        } catch (Exception e) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d(e);
            com.baidu.mobads.c.a.a().a("splash ad create failed: " + e.toString());
        }
    }

    public static void setAppSid(Context context, String str) {
        XAdSDKFoundationFacade.getInstance().getCommonUtils().setAppId(str);
    }

    @Deprecated
    public static void setAppSec(Context context, String str) {
    }

    public static void needRequestVRAd(boolean z) {
        d = z;
        com.baidu.mobads.production.g.a.b(d);
    }

    public static void setBitmapDisplayMode(int i) {
        com.baidu.mobads.production.g.a.b(i);
    }

    public void destroy() {
        if (this.f3321a != null) {
            this.f3321a.p();
        }
    }

    public static void setMaxVideoCacheCapacityMb(int i) {
        if (i >= 15 && i <= 100) {
            com.baidu.mobads.utils.i.a(i);
            return;
        }
        com.baidu.mobads.utils.i.a(30);
        XAdSDKFoundationFacade.getInstance().getErrorCode().printErrorMessage("", "开屏设置视频最大缓存值有效范围在15~100M,默认30M", "");
    }

    private void a(ViewGroup viewGroup, Context context) {
        try {
            viewGroup.addView(new SurfaceView(context), new RelativeLayout.LayoutParams(0, 0));
        } catch (Exception e) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d(e);
        }
    }
}
