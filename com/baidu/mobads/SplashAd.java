package com.baidu.mobads;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.SurfaceView;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.mobad.feeds.RequestParameters;
import com.baidu.mobads.component.XAdView;
import com.baidu.mobads.interfaces.error.XAdErrorCode;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class SplashAd {

    /* renamed from: a  reason: collision with root package name */
    private com.baidu.mobads.production.f.a f2354a;
    private int b;
    private volatile String c;
    private Context d;
    private XAdView e;
    private String f;
    private RequestParameters g;
    private ViewGroup h;
    private HashMap<String, String> i;
    private SplashAdListener j;
    private IOAdEventListener k;
    public int mTimeout;

    public SplashAd(Context context, ViewGroup viewGroup, SplashAdListener splashAdListener, String str) {
        this(context, viewGroup, splashAdListener, str, true);
    }

    public SplashAd(Context context, ViewGroup viewGroup, SplashAdListener splashAdListener, String str, int i) {
        this(context, viewGroup, splashAdListener, str, true, null, i);
    }

    public SplashAd(Context context, ViewGroup viewGroup, SplashAdListener splashAdListener, String str, boolean z, int i) {
        this(context, viewGroup, splashAdListener, str, z, null, i);
    }

    public SplashAd(Context context, ViewGroup viewGroup, SplashAdListener splashAdListener, String str, boolean z) {
        this(context, viewGroup, splashAdListener, str, z, (RequestParameters) null);
    }

    public SplashAd(Context context, ViewGroup viewGroup, SplashAdListener splashAdListener, String str, boolean z, RequestParameters requestParameters) {
        this(context, viewGroup, splashAdListener, str, z, requestParameters, 4200);
    }

    public SplashAd(Context context, ViewGroup viewGroup, SplashAdListener splashAdListener, String str, boolean z, RequestParameters requestParameters, int i) {
        this(context, viewGroup, splashAdListener, str, z, requestParameters, i, true, true);
    }

    public SplashAd(Context context, ViewGroup viewGroup, SplashAdListener splashAdListener, String str, boolean z, RequestParameters requestParameters, int i, boolean z2, boolean z3) {
        this.b = 4;
        this.c = OneKeyLoginSdkCall.l;
        this.i = new HashMap<>();
        this.j = new s(this);
        this.k = new t(this);
        try {
            j.a().a(context.getApplicationContext());
            j.a().a(1001);
            this.d = context;
            this.f = str;
            this.g = requestParameters;
            this.mTimeout = i;
            this.h = viewGroup;
            this.i.put("Display_Down_Info", String.valueOf(z3));
            com.baidu.mobads.constants.a.l = System.currentTimeMillis();
            com.baidu.mobads.constants.a.m = 0L;
            com.baidu.mobads.constants.a.n = 0L;
            com.baidu.mobads.constants.a.o = 0L;
            com.baidu.mobads.constants.a.p = 0L;
            com.baidu.mobads.constants.a.q = 0L;
            com.baidu.mobads.constants.a.r = 0L;
            if (splashAdListener != null) {
                this.j = splashAdListener;
            }
            if (TextUtils.isEmpty(str)) {
                this.j.onAdFailed("请您输入正确的广告位ID");
            } else if (z2) {
                if (!AppActivity.isAnti()) {
                    a(viewGroup, context);
                }
                XAdView xAdView = new XAdView(context);
                xAdView.setListener(new v(this, context, xAdView, str, z, i, requestParameters));
                xAdView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                viewGroup.addView(xAdView);
            }
        } catch (Exception e) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d(e);
        }
    }

    public final void load() {
        int i;
        this.e = new XAdView(this.d);
        this.e.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        if (this.f2354a != null) {
            this.f2354a.removeAllListeners();
            this.f2354a = null;
        }
        float screenDensity = XAdSDKFoundationFacade.getInstance().getCommonUtils().getScreenDensity(this.d);
        Rect screenRect = XAdSDKFoundationFacade.getInstance().getCommonUtils().getScreenRect(this.d);
        int width = screenRect.width();
        int height = screenRect.height();
        if (this.g != null && this.g.isCustomSize()) {
            if (this.g.getWidth() > 0) {
                width = (int) (this.g.getWidth() * screenDensity);
            }
            if (this.g.getHeight() > 0) {
                height = (int) (this.g.getHeight() * screenDensity);
                i = width;
                if (i >= 200.0f * screenDensity || height < screenDensity * 150.0f) {
                    XAdSDKFoundationFacade.getInstance().getAdLogger().e(XAdSDKFoundationFacade.getInstance().getErrorCode().genCompleteErrorMessage(XAdErrorCode.SHOW_STANDARD_UNFIT, "开屏显示区域太小,宽度至少200dp,高度至少150dp"));
                    this.j.onAdDismissed();
                }
                this.f2354a = new com.baidu.mobads.production.f.a(this.d, this.e, this.f, true, i, height, this.b, this.mTimeout);
                this.f2354a.a(this.i);
                this.f2354a.A = true;
                if (this.g != null) {
                    this.f2354a.a(this.g);
                }
                this.f2354a.addEventListener("AdUserClick", this.k);
                this.f2354a.addEventListener(IXAdEvent.AD_LOADED, this.k);
                this.f2354a.addEventListener(IXAdEvent.AD_STARTED, this.k);
                this.f2354a.addEventListener(IXAdEvent.AD_STOPPED, this.k);
                this.f2354a.addEventListener(IXAdEvent.AD_ERROR, this.k);
                this.f2354a.request();
                return;
            }
        }
        i = width;
        if (i >= 200.0f * screenDensity) {
        }
        XAdSDKFoundationFacade.getInstance().getAdLogger().e(XAdSDKFoundationFacade.getInstance().getErrorCode().genCompleteErrorMessage(XAdErrorCode.SHOW_STANDARD_UNFIT, "开屏显示区域太小,宽度至少200dp,高度至少150dp"));
        this.j.onAdDismissed();
    }

    public final void show() {
        if (this.h != null && this.e != null && this.f2354a != null) {
            if (this.e.getParent() != null) {
                this.f2354a.removeAllListeners();
                a("展现失败，请重新load");
                return;
            }
            this.e.setListener(new w(this));
            this.h.addView(this.e);
            return;
        }
        if (this.f2354a != null) {
            this.f2354a.removeAllListeners();
        }
        a("展现失败，请检查splashAd参数是否正确");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (this.j != null) {
            this.j.onAdFailed(str);
        }
    }

    public static void setAppSid(Context context, String str) {
        XAdSDKFoundationFacade.getInstance().getCommonUtils().setAppId(str);
    }

    @Deprecated
    public static void setAppSec(Context context, String str) {
    }

    public void destroy() {
        if (this.f2354a != null) {
            this.f2354a.p();
        }
        this.j = null;
    }

    public static void setMaxVideoCacheCapacityMb(int i) {
        if (i >= 15 && i <= 100) {
            com.baidu.mobads.utils.m.a(i);
            return;
        }
        com.baidu.mobads.utils.m.a(30);
        XAdSDKFoundationFacade.getInstance().getErrorCode().printErrorMessage("", "开屏设置视频最大缓存值有效范围在15~100M,默认30M", "");
    }

    public HashMap getExtData() {
        HashMap hashMap = new HashMap();
        HashMap r = this.f2354a.r();
        return r != null ? r : hashMap;
    }

    private void a(ViewGroup viewGroup, Context context) {
        try {
            viewGroup.addView(new SurfaceView(context), new RelativeLayout.LayoutParams(0, 0));
        } catch (Exception e) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d(e);
        }
    }
}
