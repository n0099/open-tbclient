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
import java.util.HashMap;
/* loaded from: classes2.dex */
public class SplashAd {
    public static final String KEY_LIMIT_REGION_CLICK = "region_click";

    /* renamed from: a  reason: collision with root package name */
    public com.baidu.mobads.production.f.a f8151a;

    /* renamed from: b  reason: collision with root package name */
    public int f8152b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f8153c;

    /* renamed from: d  reason: collision with root package name */
    public volatile String f8154d;

    /* renamed from: e  reason: collision with root package name */
    public Context f8155e;

    /* renamed from: f  reason: collision with root package name */
    public XAdView f8156f;

    /* renamed from: g  reason: collision with root package name */
    public String f8157g;

    /* renamed from: h  reason: collision with root package name */
    public RequestParameters f8158h;
    public ViewGroup i;
    public HashMap<String, String> j;
    public SplashAdListener k;
    public IOAdEventListener l;
    public int mTimeout;

    public SplashAd(Context context, ViewGroup viewGroup, SplashAdListener splashAdListener, String str) {
        this(context, viewGroup, splashAdListener, str, true);
    }

    @Deprecated
    public static void setAppSec(Context context, String str) {
    }

    public static void setAppSid(Context context, String str) {
        XAdSDKFoundationFacade.getInstance().getCommonUtils().setAppId(str);
    }

    public static void setMaxVideoCacheCapacityMb(int i) {
        if (i >= 15 && i <= 100) {
            com.baidu.mobads.utils.m.a(i);
            return;
        }
        com.baidu.mobads.utils.m.a(30);
        XAdSDKFoundationFacade.getInstance().getErrorCode().printErrorMessage("", "开屏设置视频最大缓存值有效范围在15~100M,默认30M", "");
    }

    public void destroy() {
        com.baidu.mobads.production.f.a aVar = this.f8151a;
        if (aVar != null) {
            aVar.p();
        }
        this.k = null;
    }

    public HashMap getExtData() {
        HashMap hashMap = new HashMap();
        HashMap r = this.f8151a.r();
        return r != null ? r : hashMap;
    }

    public final void load() {
        this.f8156f = new XAdView(this.f8155e);
        this.f8156f.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        com.baidu.mobads.production.f.a aVar = this.f8151a;
        if (aVar != null) {
            aVar.removeAllListeners();
            this.f8151a = null;
        }
        float screenDensity = XAdSDKFoundationFacade.getInstance().getCommonUtils().getScreenDensity(this.f8155e);
        Rect screenRect = XAdSDKFoundationFacade.getInstance().getCommonUtils().getScreenRect(this.f8155e);
        int width = screenRect.width();
        int height = screenRect.height();
        RequestParameters requestParameters = this.f8158h;
        if (requestParameters != null && requestParameters.isCustomSize()) {
            if (this.f8158h.getWidth() > 0) {
                width = (int) (this.f8158h.getWidth() * screenDensity);
            }
            if (this.f8158h.getHeight() > 0) {
                height = (int) (this.f8158h.getHeight() * screenDensity);
            }
        }
        int i = height;
        int i2 = width;
        if (i2 >= 200.0f * screenDensity && i >= screenDensity * 150.0f) {
            com.baidu.mobads.production.f.a aVar2 = new com.baidu.mobads.production.f.a(this.f8155e, this.f8156f, this.f8157g, true, i2, i, this.f8152b, this.mTimeout);
            this.f8151a = aVar2;
            aVar2.a(this.j);
            com.baidu.mobads.production.f.a aVar3 = this.f8151a;
            aVar3.A = true;
            RequestParameters requestParameters2 = this.f8158h;
            if (requestParameters2 != null) {
                aVar3.a(requestParameters2);
            }
            this.f8151a.addEventListener("AdUserClick", this.l);
            this.f8151a.addEventListener(IXAdEvent.AD_LOADED, this.l);
            this.f8151a.addEventListener(IXAdEvent.AD_STARTED, this.l);
            this.f8151a.addEventListener(IXAdEvent.AD_STOPPED, this.l);
            this.f8151a.addEventListener(IXAdEvent.AD_ERROR, this.l);
            this.f8153c = true;
            this.f8151a.request();
            return;
        }
        XAdSDKFoundationFacade.getInstance().getAdLogger().e(XAdSDKFoundationFacade.getInstance().getErrorCode().genCompleteErrorMessage(XAdErrorCode.SHOW_STANDARD_UNFIT, "开屏显示区域太小,宽度至少200dp,高度至少150dp"));
        this.k.onAdDismissed();
    }

    public final void show() {
        XAdView xAdView;
        if (this.i != null && (xAdView = this.f8156f) != null && this.f8151a != null) {
            if (xAdView.getParent() != null) {
                this.f8151a.removeAllListeners();
                a("展现失败，请重新load");
                return;
            }
            this.f8156f.setListener(new w(this));
            this.i.addView(this.f8156f);
            return;
        }
        com.baidu.mobads.production.f.a aVar = this.f8151a;
        if (aVar != null) {
            aVar.removeAllListeners();
        }
        a("展现失败，请检查splashAd参数是否正确");
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

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        SplashAdListener splashAdListener = this.k;
        if (splashAdListener != null) {
            splashAdListener.onAdFailed(str);
        }
    }

    public SplashAd(Context context, ViewGroup viewGroup, SplashAdListener splashAdListener, String str, boolean z, RequestParameters requestParameters, int i) {
        this(context, viewGroup, splashAdListener, str, z, requestParameters, i, true, true);
    }

    public SplashAd(Context context, ViewGroup viewGroup, SplashAdListener splashAdListener, String str, boolean z, RequestParameters requestParameters, int i, boolean z2, boolean z3) {
        this.f8152b = 4;
        this.f8153c = false;
        this.f8154d = "init";
        this.j = new HashMap<>();
        this.k = new s(this);
        this.l = new t(this);
        try {
            j.a().a(context.getApplicationContext());
            j.a().a(1001);
            this.f8155e = context;
            this.f8157g = str;
            this.f8158h = requestParameters;
            this.mTimeout = i;
            this.i = viewGroup;
            this.j.put("Display_Down_Info", String.valueOf(z3));
            if (this.f8158h != null) {
                this.j.put("limitRegionClick", this.f8158h.getExtras().get(KEY_LIMIT_REGION_CLICK));
            }
            com.baidu.mobads.constants.a.l = System.currentTimeMillis();
            com.baidu.mobads.constants.a.m = 0L;
            com.baidu.mobads.constants.a.n = 0L;
            com.baidu.mobads.constants.a.o = 0L;
            com.baidu.mobads.constants.a.p = 0L;
            com.baidu.mobads.constants.a.q = 0L;
            com.baidu.mobads.constants.a.r = 0L;
            if (splashAdListener != null) {
                this.k = splashAdListener;
            }
            if (TextUtils.isEmpty(str)) {
                this.k.onAdFailed("请您输入正确的广告位ID");
            } else if (z2) {
                if (!AppActivity.isAnti()) {
                    a(viewGroup, context);
                }
                XAdView xAdView = new XAdView(context);
                xAdView.setListener(new v(this, context, xAdView, str, z, i, requestParameters));
                xAdView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                viewGroup.addView(xAdView);
            }
        } catch (Exception e2) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d(e2);
        }
    }

    private void a(ViewGroup viewGroup, Context context) {
        try {
            viewGroup.addView(new SurfaceView(context), new RelativeLayout.LayoutParams(0, 0));
        } catch (Exception e2) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d(e2);
        }
    }
}
