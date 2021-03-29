package com.baidu.mobads.production;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.mobad.feeds.RequestParameters;
import com.baidu.mobads.g.q;
import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.interfaces.IXAdContainer;
import com.baidu.mobads.interfaces.IXAdContainerContext;
import com.baidu.mobads.interfaces.IXAdContainerFactory;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.IXAdProdInfo;
import com.baidu.mobads.interfaces.IXAdResponseInfo;
import com.baidu.mobads.interfaces.IXNonLinearAdSlot;
import com.baidu.mobads.interfaces.error.XAdErrorCode;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.interfaces.feeds.IXAdFeedsRequestParameters;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class a extends com.baidu.mobads.openad.a.c implements IXNonLinearAdSlot {

    /* renamed from: b  reason: collision with root package name */
    public static IXAdContainerFactory f8435b;
    public static final String[] z = {"android.permission.ACCESS_COARSE_LOCATION", StorageUtils.EXTERNAL_STORAGE_PERMISSION};
    public IXAdResponseInfo B;
    public String C;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f8438e;

    /* renamed from: f  reason: collision with root package name */
    public Context f8439f;

    /* renamed from: h  reason: collision with root package name */
    public IXAdContainer f8441h;
    public String i;
    public p j;
    public com.baidu.mobads.vo.d k;
    public IXAdConstants4PDK.SlotType o;
    public long w;
    public long x;
    public long y;

    /* renamed from: c  reason: collision with root package name */
    public Boolean f8436c = Boolean.FALSE;
    public AtomicBoolean A = new AtomicBoolean(true);

    /* renamed from: d  reason: collision with root package name */
    public IXAdInstanceInfo f8437d = null;

    /* renamed from: g  reason: collision with root package name */
    public int f8440g = 0;
    public IXAdConstants4PDK.SlotState l = IXAdConstants4PDK.SlotState.IDEL;
    public int m = 5000;
    public int n = 0;
    public boolean p = false;
    public HashMap<String, String> q = new HashMap<>();
    public AtomicBoolean r = new AtomicBoolean();
    public Handler D = new Handler(Looper.getMainLooper());
    public Runnable E = null;
    public String s = "";
    public IXAdFeedsRequestParameters t = null;
    public HashMap<String, String> u = null;
    public IOAdEventListener F = new b(this);
    public final IXAdLogger v = XAdSDKFoundationFacade.getInstance().getAdLogger();

    public a(Context context) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        BaiduXAdSDKContext.isRemoteLoadSuccess = Boolean.TRUE;
        b("XAdMouldeLoader load success");
    }

    private boolean g(IXAdInstanceInfo iXAdInstanceInfo) {
        if (iXAdInstanceInfo != null) {
            try {
                if (iXAdInstanceInfo.getCreativeType() == IXAdInstanceInfo.CreativeType.VIDEO && this.p) {
                    return XAdSDKFoundationFacade.getInstance().getSystemUtils().isWifiConnected(getApplicationContext()).booleanValue();
                }
                return true;
            } catch (Throwable th) {
                this.v.d("XAbstractAdProdTemplate", th.getMessage());
                return true;
            }
        }
        return true;
    }

    private boolean h(IXAdInstanceInfo iXAdInstanceInfo) {
        return iXAdInstanceInfo != null && this.o != null && IXAdConstants4PDK.SlotType.SLOT_TYPE_FEEDS.getValue().equals(this.o.getValue()) && iXAdInstanceInfo.getCreativeType() == IXAdInstanceInfo.CreativeType.VIDEO;
    }

    private void i(IXAdInstanceInfo iXAdInstanceInfo) {
        this.v.d("XAbstractAdProdTemplate", "cacheCreativeAsset");
        String a2 = a(iXAdInstanceInfo);
        if (TextUtils.isEmpty(a2)) {
            return;
        }
        if (!a(iXAdInstanceInfo, a2)) {
            b(iXAdInstanceInfo, a2);
            return;
        }
        iXAdInstanceInfo.setLocalCreativeURL(null);
        String a3 = com.baidu.mobads.utils.m.a(getApplicationContext());
        String b2 = com.baidu.mobads.utils.m.b(a2);
        com.baidu.mobads.c.a a4 = com.baidu.mobads.c.a.a();
        String mainPictureUrl = iXAdInstanceInfo.getMainPictureUrl();
        if (a4 != null && a(a4, iXAdInstanceInfo.getCreativeType(), mainPictureUrl)) {
            a4.a(iXAdInstanceInfo.getMainPictureUrl(), new e(this, iXAdInstanceInfo, a2, a3, b2));
        } else {
            a(iXAdInstanceInfo, a2, a3, b2);
        }
    }

    public abstract void a(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap);

    public abstract void a(com.baidu.mobads.openad.b.b bVar, p pVar, int i);

    public void a(boolean z2, IXAdInstanceInfo iXAdInstanceInfo) {
    }

    public abstract void b(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap);

    public abstract void b(IXAdResponseInfo iXAdResponseInfo);

    public abstract void c();

    public boolean c(IXAdInstanceInfo iXAdInstanceInfo) {
        return iXAdInstanceInfo.getCreativeType() == IXAdInstanceInfo.CreativeType.HTML;
    }

    public abstract void d();

    public boolean d(IXAdInstanceInfo iXAdInstanceInfo) {
        return iXAdInstanceInfo.getCreativeType() == IXAdInstanceInfo.CreativeType.VIDEO;
    }

    public void e() {
    }

    public void e(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
    }

    public void e(IXAdInstanceInfo iXAdInstanceInfo) {
        if (iXAdInstanceInfo == null || q() || !h(iXAdInstanceInfo)) {
            return;
        }
        i(iXAdInstanceInfo);
    }

    public void f() {
    }

    public boolean f(IXAdInstanceInfo iXAdInstanceInfo) {
        return false;
    }

    public void g() {
    }

    @Override // com.baidu.mobads.interfaces.IXAdProd
    public Activity getActivity() {
        Context context = this.f8439f;
        if (context instanceof Activity) {
            return (Activity) context;
        }
        RelativeLayout relativeLayout = this.f8438e;
        if (relativeLayout == null || !(relativeLayout.getContext() instanceof Activity)) {
            return null;
        }
        return (Activity) this.f8438e.getContext();
    }

    @Override // com.baidu.mobads.interfaces.IXAdProd
    public IXAdContainerFactory getAdContainerFactory() {
        return f8435b;
    }

    @Override // com.baidu.mobads.interfaces.IXAdProd
    public IXAdResponseInfo getAdResponseInfo() {
        return this.B;
    }

    @Override // com.baidu.mobads.interfaces.IXAdProd
    public Context getApplicationContext() {
        Activity activity = getActivity();
        return activity == null ? this.f8439f : activity.getApplicationContext();
    }

    @Override // com.baidu.mobads.interfaces.IXAdProd
    public IXAdInstanceInfo getCurrentAdInstance() {
        return this.f8437d;
    }

    @Override // com.baidu.mobads.interfaces.IXAdProd
    public IXAdContainer getCurrentXAdContainer() {
        return this.f8441h;
    }

    @Override // com.baidu.mobads.interfaces.IXAdProd
    public int getDuration() {
        return -1;
    }

    @Override // com.baidu.mobads.interfaces.IXAdProd
    public String getId() {
        return this.C;
    }

    @Override // com.baidu.mobads.interfaces.IXAdProd
    public HashMap<String, String> getParameter() {
        return this.q;
    }

    @Override // com.baidu.mobads.interfaces.IXAdProd
    public int getPlayheadTime() {
        return -1;
    }

    @Override // com.baidu.mobads.interfaces.IXAdProd
    public ViewGroup getProdBase() {
        return this.f8438e;
    }

    @Override // com.baidu.mobads.interfaces.IXAdProd
    public IXAdProdInfo getProdInfo() {
        return this.k.d();
    }

    @Override // com.baidu.mobads.interfaces.IXAdProd
    public IXAdFeedsRequestParameters getRequestParameters() {
        if (this.t == null) {
            this.t = new RequestParameters.Builder().build();
        }
        return this.t;
    }

    @Override // com.baidu.mobads.interfaces.IXAdProd
    public IXAdConstants4PDK.SlotState getSlotState() {
        return this.l;
    }

    @Override // com.baidu.mobads.interfaces.IXAdProd
    public IXAdConstants4PDK.SlotType getType() {
        return this.o;
    }

    public boolean h() {
        return false;
    }

    @Override // com.baidu.mobads.interfaces.IXAdProd
    public Boolean isAdServerRequestingSuccess() {
        return this.f8436c;
    }

    public void j() {
        if (this.f8441h == null || getApplicationContext() == null) {
            return;
        }
        this.l = IXAdConstants4PDK.SlotState.PLAYING;
        new Handler(getApplicationContext().getMainLooper()).post(new j(this));
    }

    public void k() {
        p pVar = this.j;
        if (pVar != null) {
            pVar.removeAllListeners();
            this.j.a();
        }
    }

    public void l() {
        Runnable runnable = this.E;
        if (runnable != null) {
            this.D.removeCallbacks(runnable);
        }
        this.E = null;
    }

    @Override // com.baidu.mobads.interfaces.IXAdProd
    public void load() {
        IXAdContainer iXAdContainer = this.f8441h;
        if (iXAdContainer != null) {
            iXAdContainer.load();
        } else {
            this.r.set(true);
        }
    }

    public void m() {
        Runnable runnable = this.E;
        if (runnable != null) {
            this.D.postDelayed(runnable, this.m);
        }
    }

    public void n() {
        IXAdContainer iXAdContainer = this.f8441h;
        if (iXAdContainer != null) {
            iXAdContainer.onAttachedToWindow();
        }
    }

    @SuppressLint({"MissingSuperCall"})
    public void o() {
        IXAdContainer iXAdContainer = this.f8441h;
        if (iXAdContainer != null) {
            iXAdContainer.onDetachedFromWindow();
        }
    }

    public void p() {
        IXAdContainer iXAdContainer = this.f8441h;
        if (iXAdContainer != null) {
            iXAdContainer.destroy();
        }
        BaiduXAdSDKContext.exit();
    }

    @Override // com.baidu.mobads.interfaces.IXAdProd
    public void pause() {
        i();
    }

    public boolean q() {
        return false;
    }

    public HashMap r() {
        HashMap hashMap = new HashMap();
        try {
            IXAdInstanceInfo primaryAdInstanceInfo = this.B.getPrimaryAdInstanceInfo();
            if (primaryAdInstanceInfo != null && primaryAdInstanceInfo.getOriginJsonObject() != null) {
                JSONObject originJsonObject = primaryAdInstanceInfo.getOriginJsonObject();
                if (originJsonObject.has("custom_ext_data")) {
                    hashMap.put("custom_ext_data", originJsonObject.optString("custom_ext_data"));
                }
                if (originJsonObject.optInt("pattern") == 1 || originJsonObject.optInt("pattern") == 2) {
                    hashMap.put("pattern", Integer.valueOf(originJsonObject.optInt("pattern")));
                }
                if (originJsonObject.has("btn_pos")) {
                    hashMap.put("btn_pos", Double.valueOf(originJsonObject.optDouble("btn_pos")));
                }
            }
        } catch (Throwable unused) {
        }
        return hashMap;
    }

    @Override // com.baidu.mobads.interfaces.IXAdProd
    public void resize() {
        if (this.f8441h == null || getApplicationContext() == null) {
            return;
        }
        new Handler(getApplicationContext().getMainLooper()).post(new h(this));
    }

    @Override // com.baidu.mobads.interfaces.IXAdProd
    public void resume() {
        j();
    }

    @Override // com.baidu.mobads.interfaces.IXAdProd
    public void setActivity(Context context) {
        this.f8439f = context;
        g();
        this.r.set(false);
        d();
        com.baidu.mobads.b.a.a().a(getApplicationContext());
        XAdSDKFoundationFacade.getInstance().initializeApplicationContext(getApplicationContext());
        this.E = new c(this);
        q.a(this.f8439f).a();
    }

    @Override // com.baidu.mobads.interfaces.IXAdProd
    public void setAdResponseInfo(IXAdResponseInfo iXAdResponseInfo) {
        this.B = iXAdResponseInfo;
    }

    @Override // com.baidu.mobads.interfaces.IXAdProd
    public void setAdSlotBase(RelativeLayout relativeLayout) {
        this.f8438e = relativeLayout;
    }

    @Override // com.baidu.mobads.interfaces.IXAdProd
    public void setId(String str) {
        this.C = str;
    }

    @Override // com.baidu.mobads.interfaces.IXAdProd
    public void setParameter(HashMap<String, String> hashMap) {
        this.q = hashMap;
    }

    @Override // com.baidu.mobads.interfaces.IXAdProd
    public void start() {
        IXAdContainer iXAdContainer = this.f8441h;
        if (iXAdContainer != null) {
            iXAdContainer.start();
        }
    }

    @Override // com.baidu.mobads.interfaces.IXAdProd
    public void stop() {
        XAdSDKFoundationFacade.getInstance().getAdLogger().d("XAbstractAdProdTemplate", IntentConfig.STOP);
        IXAdContainer iXAdContainer = this.f8441h;
        if (iXAdContainer != null) {
            iXAdContainer.stop();
            this.f8441h = null;
        }
    }

    public void c(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
        a(iXAdContainer, hashMap);
        if (IXAdConstants4PDK.SlotType.SLOT_TYPE_SPLASH.getValue().equals(this.o.getValue())) {
            return;
        }
        dispatchEvent(new com.baidu.mobads.e.a(IXAdEvent.AD_LOADED));
    }

    public void d(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
        this.l = IXAdConstants4PDK.SlotState.PLAYING;
        b(iXAdContainer, hashMap);
        dispatchEvent(new com.baidu.mobads.e.a(IXAdEvent.AD_STARTED));
    }

    public synchronized void b(String str) {
        AtomicBoolean atomicBoolean;
        IXAdLogger iXAdLogger = this.v;
        iXAdLogger.d("XAbstractAdProdTemplate", "doubleCheck:" + str + ", bfp=" + this.f8436c + ", apk=" + BaiduXAdSDKContext.isRemoteLoadSuccess);
        if (this.A.get()) {
            return;
        }
        if (BaiduXAdSDKContext.isRemoteLoadSuccess.booleanValue()) {
            XAdSDKFoundationFacade.getInstance().initializeAdContainerFactory(getAdContainerFactory());
        }
        if (BaiduXAdSDKContext.isRemoteLoadSuccess.booleanValue() && this.f8436c.booleanValue()) {
            try {
                IXAdResponseInfo adResponseInfo = getAdResponseInfo();
                if (adResponseInfo != null) {
                    a(adResponseInfo);
                } else {
                    dispatchEvent(new com.baidu.mobads.e.a(IXAdEvent.AD_ERROR));
                    this.v.d("XAbstractAdProdTemplate", "doubleCheck IXAdResponseInfo is null, but isBFP4APPRequestSuccess is true");
                }
                atomicBoolean = this.A;
            } catch (Exception e2) {
                this.v.d("XAbstractAdProdTemplate", e2);
                dispatchEvent(new com.baidu.mobads.e.a(IXAdEvent.AD_ERROR));
                atomicBoolean = this.A;
            }
            atomicBoolean.set(true);
        }
    }

    public void a(HashMap<String, String> hashMap) {
        this.u = hashMap;
    }

    private void a() {
        com.baidu.mobads.constants.a.n = System.currentTimeMillis();
        c(this.B);
        a(this.B.getAdInstanceList());
        if (!h()) {
            a("XAdMouldeLoader ad-server requesting success");
            return;
        }
        IXAdInstanceInfo primaryAdInstanceInfo = this.B.getPrimaryAdInstanceInfo();
        String a2 = a(primaryAdInstanceInfo);
        if (TextUtils.isEmpty(a2)) {
            a("XAdMouldeLoader ad-server requesting success");
            return;
        }
        boolean a3 = a(a2, primaryAdInstanceInfo);
        a(a3, primaryAdInstanceInfo);
        if (a3) {
            a("download the splash picture successfully");
            return;
        }
        if (!f(primaryAdInstanceInfo)) {
            a("XAdMouldeLoader ad-server requesting success");
        }
        i(primaryAdInstanceInfo);
    }

    public void d(String str) {
        if (TextUtils.isEmpty(str)) {
            this.v.e("代码位id(adPlaceId)不可以为空");
        }
    }

    public void c(IXAdResponseInfo iXAdResponseInfo) {
        b(iXAdResponseInfo);
    }

    public void c(String str) {
        HashMap hashMap = new HashMap(1);
        hashMap.put("error_message", str);
        dispatchEvent(new com.baidu.mobads.e.a(IXAdEvent.AD_ERROR, hashMap));
    }

    public void i() {
        if (this.f8441h == null || getApplicationContext() == null) {
            return;
        }
        this.l = IXAdConstants4PDK.SlotState.PAUSED;
        new Handler(getApplicationContext().getMainLooper()).post(new i(this));
    }

    public boolean b(IXAdInstanceInfo iXAdInstanceInfo) {
        return iXAdInstanceInfo.getCreativeType() == IXAdInstanceInfo.CreativeType.STATIC_IMAGE || iXAdInstanceInfo.getCreativeType() == IXAdInstanceInfo.CreativeType.GIF;
    }

    private void b(IXAdInstanceInfo iXAdInstanceInfo, String str) {
        if (d(iXAdInstanceInfo)) {
            com.baidu.mobads.b.a.a().a(this.f8439f, "383", iXAdInstanceInfo, this.k.d(), "file_dl_failed_not_wifi", str);
        }
    }

    public boolean a(String str, IXAdInstanceInfo iXAdInstanceInfo) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            String a2 = com.baidu.mobads.utils.m.a(getApplicationContext(), str);
            if (new File(a2).exists()) {
                XAdSDKFoundationFacade.getInstance().getAdCreativeCacheManager().c(a2);
                iXAdInstanceInfo.setLocalCreativeURL(a2);
                return true;
            }
        } catch (Exception e2) {
            com.baidu.mobads.utils.q.a().e(e2);
        }
        return false;
    }

    private void b(Message message, IXAdInstanceInfo iXAdInstanceInfo) {
        if (d(iXAdInstanceInfo)) {
            String str = "" + message.getData().getLong("caching_time_consume", 0L);
            String a2 = a(iXAdInstanceInfo);
            String str2 = message.getData().getBoolean("caching_result") ? "success" : com.alipay.sdk.util.e.f1969a;
            com.baidu.mobads.b.a.a().a(this.f8439f, "383", iXAdInstanceInfo, this.k.d(), "file_dl_" + str2, a2, str);
        }
    }

    public void a(IOAdEvent iOAdEvent, String str) {
        String str2 = (String) iOAdEvent.getData().get("message");
        l();
        try {
            setAdResponseInfo(new com.baidu.mobads.vo.c(str2));
            if (this.B != null && this.B.getAdInstanceList().size() > 0) {
                IXAdInstanceInfo primaryAdInstanceInfo = this.B.getPrimaryAdInstanceInfo();
                this.f8437d = primaryAdInstanceInfo;
                this.s = primaryAdInstanceInfo.getOriginJsonObject().optString(DownloadDataConstants.Columns.COLUMN_MIME_TYPE);
                a();
                e();
                return;
            }
            String errorCode = this.B != null ? this.B.getErrorCode() : "";
            String errorMessage = this.B != null ? this.B.getErrorMessage() : "";
            if (errorCode.equals("0") && TextUtils.isEmpty(errorMessage)) {
                errorMessage = "无广告返回";
            }
            XAdSDKFoundationFacade.getInstance().getErrorCode().printErrorMessage(errorCode, errorMessage, "");
            a("response ad list empty: " + errorMessage, errorCode);
        } catch (Exception unused) {
            XAdSDKFoundationFacade.getInstance().getErrorCode().printErrorMessage("", "response json parsing error", "");
            c("response json parsing error");
        }
    }

    public void b(com.baidu.mobads.vo.d dVar) {
        this.k = dVar;
        k();
        this.f8436c = Boolean.FALSE;
        String str = this.i;
        if (str == null) {
            str = dVar.b();
        }
        this.j = new p();
        com.baidu.mobads.b.a.f8164b = str;
        com.baidu.mobads.openad.b.b bVar = new com.baidu.mobads.openad.b.b(str, "");
        bVar.f8414e = 1;
        this.j.addEventListener("URLLoader.Load.Complete", this.F);
        this.j.addEventListener("URLLoader.Load.Error", this.F);
        a(bVar, this.j, this.m);
    }

    private IXAdContainer b(IXAdContainerContext iXAdContainerContext) {
        IXAdContainer createXAdContainer;
        this.v.d("XAbstractAdProdTemplate", "createAdContainer");
        IXAdContainer iXAdContainer = null;
        if (f8435b != null) {
            HashMap<String, String> hashMap = this.u;
            if (hashMap != null && hashMap.containsKey("Display_Down_Info")) {
                createXAdContainer = f8435b.createXAdContainer(iXAdContainerContext, this.u);
            } else {
                createXAdContainer = f8435b.createXAdContainer(iXAdContainerContext, null);
            }
            iXAdContainer = createXAdContainer;
            if (iXAdContainer != null) {
                IXAdLogger iXAdLogger = this.v;
                iXAdLogger.d("XAbstractAdProdTemplate", "createAdContainer() apk.version=" + f8435b.getRemoteVersion());
            }
        }
        return iXAdContainer;
    }

    public void a(XAdErrorCode xAdErrorCode, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("msg", xAdErrorCode);
        dispatchEvent(new com.baidu.mobads.e.a(IXAdEvent.AD_ERROR, hashMap));
        XAdSDKFoundationFacade.getInstance().getErrorCode().printErrorMessage(xAdErrorCode, str);
    }

    public void b(int i) {
        IXAdContainer iXAdContainer = this.f8441h;
        if (iXAdContainer != null) {
            iXAdContainer.onWindowVisibilityChanged(i);
        }
    }

    public void a(Context context) {
        if (BaiduXAdSDKContext.mApkLoader == null) {
            synchronized (com.baidu.mobads.g.g.class) {
                if (BaiduXAdSDKContext.mApkLoader == null) {
                    BaiduXAdSDKContext.mApkLoader = new com.baidu.mobads.g.g(context.getApplicationContext());
                }
            }
        }
        if (f8435b != null) {
            b();
        } else if (BaiduXAdSDKContext.mApkLoader != null) {
            this.v.d("XAbstractAdProdTemplate", "BaiduXAdSDKContext.mApkLoader != null,load apk");
            BaiduXAdSDKContext.mApkLoader.a(new d(this));
        } else {
            this.v.d("XAbstractAdProdTemplate", "BaiduXAdSDKContext.mApkLoader == null,not load apk");
        }
    }

    public void b(boolean z2) {
        this.p = z2;
    }

    public void a(String str) {
        this.f8436c = Boolean.TRUE;
        this.A.set(false);
        b(str);
    }

    public String a(IXAdInstanceInfo iXAdInstanceInfo) {
        if (iXAdInstanceInfo == null) {
            return "";
        }
        if (iXAdInstanceInfo.getCreativeType() == IXAdInstanceInfo.CreativeType.VIDEO) {
            return iXAdInstanceInfo.getVideoUrl();
        }
        return iXAdInstanceInfo.getCreativeType() == IXAdInstanceInfo.CreativeType.RM ? iXAdInstanceInfo.getMainPictureUrl() : "";
    }

    private boolean a(IXAdInstanceInfo iXAdInstanceInfo, String str) {
        return XAdSDKFoundationFacade.getInstance().getSystemUtils().isWifiConnected(getApplicationContext()).booleanValue() || h(iXAdInstanceInfo) || b(iXAdInstanceInfo);
    }

    private void a(ArrayList<IXAdInstanceInfo> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        Iterator<IXAdInstanceInfo> it = arrayList.iterator();
        while (it.hasNext()) {
            IXAdInstanceInfo next = it.next();
            if (q() && h(next)) {
                i(next);
            }
        }
    }

    private boolean a(com.baidu.mobads.c.a aVar, IXAdInstanceInfo.CreativeType creativeType, String str) {
        try {
            if (creativeType != IXAdInstanceInfo.CreativeType.VIDEO || this.o == null || !IXAdConstants4PDK.SlotType.SLOT_TYPE_FEEDS.getValue().equals(this.o.getValue()) || aVar == null) {
                return false;
            }
            return aVar.a(str);
        } catch (Throwable th) {
            this.v.d("XAbstractAdProdTemplate", th);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(IXAdInstanceInfo iXAdInstanceInfo, String str, String str2, String str3) {
        try {
            if (g(iXAdInstanceInfo)) {
                XAdSDKFoundationFacade.getInstance().getAdCreativeCacheManager().a(getApplicationContext(), str, str2, str3, new f(this, Looper.getMainLooper(), iXAdInstanceInfo));
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Message message, IXAdInstanceInfo iXAdInstanceInfo) {
        if (message.getData().getBoolean("caching_result")) {
            iXAdInstanceInfo.setLocalCreativeURL(message.getData().getString("local_creative_url"));
            if (f(iXAdInstanceInfo)) {
                a("download the splash picture successfully");
            }
            if (h(iXAdInstanceInfo)) {
                dispatchEvent(new com.baidu.mobads.e.a("vdieoCacheSucc"));
            }
        } else {
            if (h(iXAdInstanceInfo)) {
                dispatchEvent(new com.baidu.mobads.e.a("vdieoCacheFailed"));
            }
            iXAdInstanceInfo.setLocalCreativeURL(null);
            if (f(iXAdInstanceInfo)) {
                a("download the splash picture successfully");
            }
        }
        b(message, iXAdInstanceInfo);
    }

    public boolean a(com.baidu.mobads.vo.d dVar) {
        this.v.d("XAbstractAdProdTemplate", "doRequest()");
        a(this.f8439f);
        b(dVar);
        return true;
    }

    public void a(String str, String str2) {
        HashMap hashMap = new HashMap(1);
        hashMap.put("error_message", str);
        hashMap.put("error_code", str2);
        dispatchEvent(new com.baidu.mobads.e.a(IXAdEvent.AD_ERROR, hashMap));
    }

    public void a(IXAdResponseInfo iXAdResponseInfo) {
        this.v.d("XAbstractAdProdTemplate", "handleAllReady");
        this.f8440g++;
        this.f8437d = iXAdResponseInfo.getPrimaryAdInstanceInfo();
        Context applicationContext = getApplicationContext();
        k kVar = new k(applicationContext, getActivity(), this.k.d(), this.f8438e, new l(applicationContext, this), iXAdResponseInfo, null);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            a(kVar);
        } else {
            new Handler(Looper.getMainLooper()).post(new g(this, kVar));
        }
    }

    public void a(IXAdResponseInfo iXAdResponseInfo, IXAdInstanceInfo iXAdInstanceInfo) {
        this.f8437d = iXAdInstanceInfo;
    }

    public void a(IXAdContainerContext iXAdContainerContext) {
        try {
            this.v.d("XAbstractAdProdTemplate", "processAllReadyOnUIThread()");
            this.x = System.currentTimeMillis();
            this.f8441h = b(iXAdContainerContext);
            this.y = System.currentTimeMillis();
            if (this.f8441h == null) {
                this.v.d("XAbstractAdProdTemplate", "processAllReadyOnUIThread(), mAdContainer is null");
                dispatchEvent(new com.baidu.mobads.e.a(IXAdEvent.AD_ERROR));
                return;
            }
            this.v.d("XAbstractAdProdTemplate", "processAllReadyOnUIThread(), mAdContainer be created");
            HashMap<String, String> hashMap = this.q;
            hashMap.put(IntentConfig.START, "" + this.w);
            HashMap<String, String> hashMap2 = this.q;
            hashMap2.put("container_before_created", "" + this.x);
            HashMap<String, String> hashMap3 = this.q;
            hashMap3.put("container_after_created", "" + this.y);
            this.f8441h.setParameters(this.q);
            com.baidu.mobads.constants.a.f8206c = this.f8441h.getRemoteVersion();
            IXAdLogger iXAdLogger = this.v;
            iXAdLogger.d("XAbstractAdProdTemplate", "processAllReadyOnUIThread(), mAdContainer be created, hasCalledLoadAtAppSide=" + this.r.get());
            if (this.r.get()) {
                this.f8441h.load();
            }
            if (IXAdConstants4PDK.SlotType.SLOT_TYPE_SPLASH.getValue().equals(this.o.getValue())) {
                if (this.f8437d == null) {
                    this.f8437d = this.B.getPrimaryAdInstanceInfo();
                }
                HashMap hashMap4 = new HashMap();
                if (this.f8437d != null) {
                    if (b(this.f8437d)) {
                        hashMap4.put(com.baidu.mobads.constants.a.s, "IMAGE");
                    } else if (c(this.f8437d)) {
                        hashMap4.put(com.baidu.mobads.constants.a.s, "H5");
                    } else if (d(this.f8437d)) {
                        hashMap4.put(com.baidu.mobads.constants.a.s, "VIDEO");
                        int videoDuration = this.f8437d.getVideoDuration();
                        if (videoDuration != 0) {
                            hashMap4.put(com.baidu.mobads.constants.a.t, Integer.valueOf(videoDuration * 1000));
                        }
                    }
                }
                dispatchEvent(new com.baidu.mobads.e.a(IXAdEvent.AD_LOADED, hashMap4));
            }
            c();
        } catch (Exception e2) {
            this.v.e(XAdSDKFoundationFacade.getInstance().getErrorCode().genCompleteErrorMessage(XAdErrorCode.PERMISSION_PROBLEM, e2.getMessage()));
            dispatchEvent(new com.baidu.mobads.e.a(IXAdEvent.AD_ERROR));
        }
    }

    public void a(boolean z2) {
        IXAdContainer iXAdContainer = this.f8441h;
        if (iXAdContainer != null) {
            iXAdContainer.onWindowFocusChanged(z2);
        }
    }

    public boolean a(int i, KeyEvent keyEvent) {
        IXAdContainer iXAdContainer = this.f8441h;
        if (iXAdContainer != null) {
            return iXAdContainer.processKeyEvent(i, keyEvent).booleanValue();
        }
        return false;
    }

    public void a(RequestParameters requestParameters) {
        this.t = requestParameters;
    }
}
