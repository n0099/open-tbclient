package com.baidu.mobads.production.g;

import android.content.Context;
import android.net.http.Headers;
import android.os.Handler;
import android.text.TextUtils;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import com.baidu.mobads.RsplashType;
import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.interfaces.IXAdContainer;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.IXAdResponseInfo;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.openad.b.f;
import com.baidu.mobads.production.v;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.baidu.mobads.utils.h;
import com.baidu.mobads.utils.n;
import com.baidu.mobads.vo.XAdInstanceInfo;
import java.io.File;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Observer;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.protocol.HTTP;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a extends com.baidu.mobads.production.b {
    private static boolean D = false;
    private static int E = 0;
    private String A;
    private String B;
    private int C;
    private Observer F;
    protected final IXAdLogger w;
    private e x;
    private Context y;
    private boolean z;

    public a(Context context, RelativeLayout relativeLayout, String str, boolean z, int i, int i2, int i3) {
        this(context, relativeLayout, str, z, i, i2);
        this.C = i3;
    }

    public a(Context context, RelativeLayout relativeLayout, String str, boolean z, int i, int i2) {
        super(context);
        String supportedActionType4RequestingNone;
        this.z = false;
        this.w = XAdSDKFoundationFacade.getInstance().getAdLogger();
        this.F = new c(this);
        setId(str);
        setActivity(context);
        setAdSlotBase(relativeLayout);
        this.o = IXAdConstants4PDK.SlotType.SLOT_TYPE_SPLASH;
        this.y = context;
        this.x = new e(getApplicationContext(), this.o);
        this.x.a(z);
        h adConstants = XAdSDKFoundationFacade.getInstance().getAdConstants();
        if (z) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(adConstants.getSupportedActionType4RequestingNone());
            arrayList.add(adConstants.getSupportedActionType4RequestingLandingPage());
            arrayList.add(adConstants.a());
            XAdSDKFoundationFacade.getInstance().getPackageUtils();
            if (n.b(context)) {
                arrayList.add(adConstants.getSupportedActionType4RequestingDownload());
            }
            supportedActionType4RequestingNone = XAdSDKFoundationFacade.getInstance().getCommonUtils().a((List<String>) arrayList);
        } else {
            supportedActionType4RequestingNone = adConstants.getSupportedActionType4RequestingNone();
        }
        this.x.b(supportedActionType4RequestingNone);
        this.x.d(i);
        this.x.e(i2);
        this.x.d(str);
        e(str);
    }

    @Override // com.baidu.mobads.production.b
    protected void h() {
        this.m = 4200;
    }

    @Override // com.baidu.mobads.interfaces.IXAdProd
    public void request() {
        com.baidu.mobads.a.a.m = System.currentTimeMillis();
        m();
        a(this.x);
        try {
            new WebView(getActivity()).loadDataWithBaseURL(null, "", "text/html", HTTP.UTF_8, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.mobads.production.b
    protected void a(com.baidu.mobads.openad.d.c cVar, v vVar, int i) {
        com.baidu.mobads.vo.b bVar = (com.baidu.mobads.vo.b) this.k.d();
        JSONObject attribute = bVar.getAttribute();
        JSONObject jSONObject = attribute == null ? new JSONObject() : attribute;
        try {
            jSONObject.put("needRequestVR", D);
            jSONObject.put("bitmapDisplayMode", E);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        bVar.a(jSONObject);
        vVar.a(cVar, i);
    }

    @Override // com.baidu.mobads.production.b
    protected void c(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
        com.baidu.mobads.a.a.r = System.currentTimeMillis();
        try {
            HashMap<String, String> hashMap2 = new HashMap<>();
            hashMap2.put("m_new_rsplash", String.valueOf(com.baidu.mobads.a.a.l));
            hashMap2.put("m_start_request", String.valueOf(com.baidu.mobads.a.a.m));
            hashMap2.put("m_end_request", String.valueOf(com.baidu.mobads.a.a.n));
            hashMap2.put("m_start_dex", String.valueOf(com.baidu.mobads.a.a.o));
            hashMap2.put("m_end_dex", String.valueOf(com.baidu.mobads.a.a.p));
            hashMap2.put("m_start_load", String.valueOf(com.baidu.mobads.a.a.q));
            hashMap2.put("m_end_load", String.valueOf(com.baidu.mobads.a.a.r));
            hashMap2.put("isRequestAndLoadAdTimeout", String.valueOf(this.z));
            IXAdResponseInfo adResponseInfo = getAdResponseInfo();
            IXAdInstanceInfo iXAdInstanceInfo = null;
            if (adResponseInfo != null) {
                iXAdInstanceInfo = adResponseInfo.getPrimaryAdInstanceInfo();
            }
            JSONObject attribute = this.x.d().getAttribute();
            JSONObject jSONObject = attribute == null ? new JSONObject() : attribute;
            try {
                jSONObject.put("splashTipStyle", this.C);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            ((com.baidu.mobads.vo.b) this.x.d()).a(jSONObject);
            com.baidu.mobads.c.a.a().a(this.y, "386", iXAdInstanceInfo, this.x.d(), hashMap2);
        } catch (Exception e2) {
            this.w.e(e2);
        }
        if (!this.z) {
            HashMap hashMap3 = new HashMap();
            if (iXAdContainer.getAdContainerContext() != null && iXAdContainer.getAdContainerContext().getAdInstanceInfo() != null) {
                hashMap3.put(com.baidu.mobads.d.aAw, Integer.valueOf(iXAdContainer.getAdContainerContext().getAdInstanceInfo().getPattern()));
                hashMap3.put(com.baidu.mobads.d.aAx, Float.valueOf(iXAdContainer.getAdContainerContext().getAdInstanceInfo().getBtnPosition()));
            }
            dispatchEvent(new com.baidu.mobads.f.a(IXAdEvent.AD_LOADED, hashMap3));
            start();
            Handler handler = new Handler(this.y.getMainLooper());
            try {
                if (hashMap == null) {
                    a(handler);
                } else {
                    IXAdInstanceInfo iXAdInstanceInfo2 = (IXAdInstanceInfo) hashMap.get("AdInstance");
                    IXAdInstanceInfo.CreativeType creativeType = iXAdInstanceInfo2.getCreativeType();
                    if (creativeType != IXAdInstanceInfo.CreativeType.VIDEO && creativeType != IXAdInstanceInfo.CreativeType.RM) {
                        a(handler);
                    } else {
                        com.baidu.mobads.c.a.a().a(this.y, "383", iXAdInstanceInfo2, this.x.d(), "processAdLoaded");
                    }
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    private void a(Handler handler) {
        handler.postDelayed(new b(this), 5000L);
    }

    @Override // com.baidu.mobads.production.b
    public void b() {
        this.z = true;
        try {
            IXAdResponseInfo adResponseInfo = getAdResponseInfo();
            com.baidu.mobads.c.a.a().a(this.y, "382", adResponseInfo != null ? adResponseInfo.getPrimaryAdInstanceInfo() : null, this.x.d(), (HashMap<String, String>) null);
        } catch (Exception e) {
            this.w.e(e);
        }
    }

    @Override // com.baidu.mobads.production.b
    protected void d(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
        if (hashMap != null) {
            IXAdInstanceInfo iXAdInstanceInfo = (IXAdInstanceInfo) hashMap.get("AdInstance");
            IXAdInstanceInfo.CreativeType creativeType = iXAdInstanceInfo.getCreativeType();
            if (creativeType == IXAdInstanceInfo.CreativeType.VIDEO || creativeType == IXAdInstanceInfo.CreativeType.RM) {
                com.baidu.mobads.c.a.a().a(this.y, "383", iXAdInstanceInfo, this.x.d(), "processAdStart");
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.mobads.interfaces.IXAdProd
    /* renamed from: q */
    public com.baidu.mobads.vo.d getAdRequestInfo() {
        return this.x;
    }

    @Override // com.baidu.mobads.production.b
    public void g() {
        com.baidu.mobads.a.a.q = System.currentTimeMillis();
        if (this.h != null) {
            this.h.load();
        } else {
            this.w.e("container is null");
        }
    }

    @Override // com.baidu.mobads.production.b
    public void c(IXAdResponseInfo iXAdResponseInfo) {
    }

    @Override // com.baidu.mobads.production.b
    public void a(boolean z, IXAdInstanceInfo iXAdInstanceInfo) {
        if (e(iXAdInstanceInfo)) {
            com.baidu.mobads.c.a.a().a(this.y, "383", iXAdInstanceInfo, this.x.d(), "file_exist_" + z);
            if (!z) {
                a("开屏因为请求到未在wifi下缓存的视频广告跳过");
            }
        }
    }

    @Override // com.baidu.mobads.production.b
    public boolean a(IXAdInstanceInfo iXAdInstanceInfo) {
        return e(iXAdInstanceInfo);
    }

    @Override // com.baidu.mobads.production.b
    protected void e(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
        super.e(iXAdContainer, hashMap);
        if (hashMap != null) {
            try {
                String str = (String) hashMap.get("video_close_reason");
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.mobads.c.a.a().a(this.y, "383", (IXAdInstanceInfo) null, this.x.d(), "closead", str);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.mobads.production.b
    public String b(IXAdInstanceInfo iXAdInstanceInfo) {
        int videoDuration;
        HashMap hashMap = new HashMap();
        if (d(iXAdInstanceInfo)) {
            hashMap.put(com.baidu.mobads.a.a.s, RsplashType.HTML);
            dispatchEvent(new com.baidu.mobads.f.a("AdTypeReady", hashMap));
        }
        if (c(iXAdInstanceInfo)) {
            hashMap.put(com.baidu.mobads.a.a.s, RsplashType.IMAGE);
            dispatchEvent(new com.baidu.mobads.f.a("AdTypeReady", hashMap));
            return iXAdInstanceInfo.getMainPictureUrl();
        }
        if (iXAdInstanceInfo.getCreativeType() == IXAdInstanceInfo.CreativeType.VIDEO && (videoDuration = iXAdInstanceInfo.getVideoDuration()) != 0) {
            hashMap.put(com.baidu.mobads.a.a.s, RsplashType.VIDEO);
            hashMap.put(com.baidu.mobads.a.a.t, Integer.valueOf(videoDuration * 1000));
            dispatchEvent(new com.baidu.mobads.f.a("AdTypeReady", hashMap));
        }
        return super.b(iXAdInstanceInfo);
    }

    @Override // com.baidu.mobads.production.b
    public boolean f(IXAdInstanceInfo iXAdInstanceInfo) {
        return c(iXAdInstanceInfo) || e();
    }

    @Override // com.baidu.mobads.production.b
    public boolean d() {
        return true;
    }

    @Override // com.baidu.mobads.production.b
    protected void a() {
        if (e()) {
            this.A = XAdSDKFoundationFacade.getInstance().getIoUtils().getStoreagePath(this.y);
            this.B = XAdSDKFoundationFacade.getInstance().getCommonUtils().md5("http://mobads.baidu.com/ads/img/3d_bg.jpg");
            File file = new File(this.A + this.B);
            try {
                URL url = new URL("http://mobads.baidu.com/ads/img/3d_bg.jpg");
                if (a(file, url)) {
                    ((XAdInstanceInfo) this.d).setSplash3DLocalUrl(null);
                    f fVar = new f(this.y, url, this.A, this.B, false);
                    fVar.addObserver(this.F);
                    fVar.start();
                } else {
                    f(this.A + this.B);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str) {
        ((XAdInstanceInfo) this.d).setSplash3DLocalUrl(str);
        if (e() && TextUtils.isEmpty(((XAdInstanceInfo) this.d).getLocalCreativeURL())) {
            this.w.e("zip pic no download");
        } else {
            b("splash back pic ready");
        }
    }

    private boolean a(File file, URL url) {
        if (file.exists()) {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod(HttpHead.METHOD_NAME);
                int parseInt = Integer.parseInt(httpURLConnection.getHeaderField(Headers.CONTENT_LEN));
                httpURLConnection.disconnect();
                if (parseInt > 0 && file.length() == parseInt) {
                    httpURLConnection.disconnect();
                    return false;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    public static boolean r() {
        return D;
    }

    public static void b(boolean z) {
        D = z;
    }

    public static void b(int i) {
        E = i;
    }
}
