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
import com.baidu.mobads.utils.q;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public abstract class a extends com.baidu.mobads.openad.a.c implements IXNonLinearAdSlot {

    /* renamed from: b  reason: collision with root package name */
    public static IXAdContainerFactory f3435b;
    private static final String[] z = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.WRITE_EXTERNAL_STORAGE"};
    private IXAdResponseInfo B;
    private String C;
    protected RelativeLayout e;
    protected Context f;
    public IXAdContainer h;
    protected String i;
    protected p j;
    protected com.baidu.mobads.vo.d k;
    protected IXAdConstants4PDK.SlotType o;
    protected long w;
    protected long x;
    protected long y;
    protected Boolean c = false;
    private AtomicBoolean A = new AtomicBoolean(true);
    public IXAdInstanceInfo d = null;
    protected int g = 0;
    protected IXAdConstants4PDK.SlotState l = IXAdConstants4PDK.SlotState.IDEL;
    protected int m = 5000;
    protected int n = 0;
    protected boolean p = false;
    protected HashMap<String, String> q = new HashMap<>();
    protected AtomicBoolean r = new AtomicBoolean();
    private Handler D = new Handler(Looper.getMainLooper());
    private Runnable E = null;
    protected String s = "";
    protected IXAdFeedsRequestParameters t = null;
    protected HashMap<String, String> u = null;
    private IOAdEventListener F = new b(this);
    protected final IXAdLogger v = XAdSDKFoundationFacade.getInstance().getAdLogger();

    protected abstract void a(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap);

    protected abstract void a(com.baidu.mobads.openad.b.b bVar, p pVar, int i);

    protected abstract void b(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap);

    public abstract void b(IXAdResponseInfo iXAdResponseInfo);

    public abstract void c();

    protected abstract void d();

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

    boolean a(String str, IXAdInstanceInfo iXAdInstanceInfo) {
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
            return false;
        } catch (Exception e) {
            q.a().e(e);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(IOAdEvent iOAdEvent, String str) {
        String str2 = (String) iOAdEvent.getData().get("message");
        l();
        try {
            setAdResponseInfo(new com.baidu.mobads.vo.c(str2));
            if (this.B != null && this.B.getAdInstanceList().size() > 0) {
                this.d = this.B.getPrimaryAdInstanceInfo();
                this.s = this.d.getOriginJsonObject().optString(DownloadDataConstants.Columns.COLUMN_MIME_TYPE);
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
        } catch (Exception e) {
            XAdSDKFoundationFacade.getInstance().getErrorCode().printErrorMessage("", "response json parsing error", "");
            c("response json parsing error");
        }
    }

    protected void e() {
    }

    public a(Context context) {
    }

    @Override // com.baidu.mobads.interfaces.IXAdProd
    public IXAdConstants4PDK.SlotState getSlotState() {
        return this.l;
    }

    @Override // com.baidu.mobads.interfaces.IXAdProd
    public void setActivity(Context context) {
        this.f = context;
        g();
        this.r.set(false);
        d();
        com.baidu.mobads.b.a.a().a(getApplicationContext());
        XAdSDKFoundationFacade.getInstance().initializeApplicationContext(getApplicationContext());
        this.E = new c(this);
        com.baidu.mobads.g.q.a(this.f).a();
    }

    public void f() {
    }

    @Override // com.baidu.mobads.interfaces.IXAdProd
    public void setAdSlotBase(RelativeLayout relativeLayout) {
        this.e = relativeLayout;
    }

    @Override // com.baidu.mobads.interfaces.IXAdProd
    public void setId(String str) {
        this.C = str;
    }

    protected void g() {
    }

    @Override // com.baidu.mobads.interfaces.IXAdProd
    public String getId() {
        return this.C;
    }

    @Override // com.baidu.mobads.interfaces.IXAdProd
    public IXAdConstants4PDK.SlotType getType() {
        return this.o;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(XAdErrorCode xAdErrorCode, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("msg", xAdErrorCode);
        dispatchEvent(new com.baidu.mobads.e.a(IXAdEvent.AD_ERROR, hashMap));
        XAdSDKFoundationFacade.getInstance().getErrorCode().printErrorMessage(xAdErrorCode, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Context context) {
        if (BaiduXAdSDKContext.mApkLoader == null) {
            synchronized (com.baidu.mobads.g.g.class) {
                if (BaiduXAdSDKContext.mApkLoader == null) {
                    BaiduXAdSDKContext.mApkLoader = new com.baidu.mobads.g.g(context.getApplicationContext());
                }
            }
        }
        if (f3435b != null) {
            b();
        } else if (BaiduXAdSDKContext.mApkLoader != null) {
            this.v.d("XAbstractAdProdTemplate", "BaiduXAdSDKContext.mApkLoader != null,load apk");
            BaiduXAdSDKContext.mApkLoader.a(new d(this));
        } else {
            this.v.d("XAbstractAdProdTemplate", "BaiduXAdSDKContext.mApkLoader == null,not load apk");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        BaiduXAdSDKContext.isRemoteLoadSuccess = true;
        b("XAdMouldeLoader load success");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str) {
        this.c = true;
        this.A.set(false);
        b(str);
    }

    protected synchronized void b(String str) {
        this.v.d("XAbstractAdProdTemplate", "doubleCheck:" + str + ", bfp=" + this.c + ", apk=" + BaiduXAdSDKContext.isRemoteLoadSuccess);
        if (!this.A.get()) {
            if (BaiduXAdSDKContext.isRemoteLoadSuccess.booleanValue()) {
                XAdSDKFoundationFacade.getInstance().initializeAdContainerFactory(getAdContainerFactory());
            }
            if (BaiduXAdSDKContext.isRemoteLoadSuccess.booleanValue() && this.c.booleanValue()) {
                try {
                    IXAdResponseInfo adResponseInfo = getAdResponseInfo();
                    if (adResponseInfo != null) {
                        a(adResponseInfo);
                    } else {
                        dispatchEvent(new com.baidu.mobads.e.a(IXAdEvent.AD_ERROR));
                        this.v.d("XAbstractAdProdTemplate", "doubleCheck IXAdResponseInfo is null, but isBFP4APPRequestSuccess is true");
                    }
                    this.A.set(true);
                } catch (Exception e) {
                    this.v.d("XAbstractAdProdTemplate", e);
                    dispatchEvent(new com.baidu.mobads.e.a(IXAdEvent.AD_ERROR));
                    this.A.set(true);
                }
            }
        }
    }

    public boolean h() {
        return false;
    }

    public String a(IXAdInstanceInfo iXAdInstanceInfo) {
        if (iXAdInstanceInfo == null) {
            return "";
        }
        if (iXAdInstanceInfo.getCreativeType() == IXAdInstanceInfo.CreativeType.VIDEO) {
            return iXAdInstanceInfo.getVideoUrl();
        }
        if (iXAdInstanceInfo.getCreativeType() != IXAdInstanceInfo.CreativeType.RM) {
            return "";
        }
        return iXAdInstanceInfo.getMainPictureUrl();
    }

    public boolean b(IXAdInstanceInfo iXAdInstanceInfo) {
        return iXAdInstanceInfo.getCreativeType() == IXAdInstanceInfo.CreativeType.STATIC_IMAGE || iXAdInstanceInfo.getCreativeType() == IXAdInstanceInfo.CreativeType.GIF;
    }

    public boolean c(IXAdInstanceInfo iXAdInstanceInfo) {
        return iXAdInstanceInfo.getCreativeType() == IXAdInstanceInfo.CreativeType.HTML;
    }

    public boolean d(IXAdInstanceInfo iXAdInstanceInfo) {
        return iXAdInstanceInfo.getCreativeType() == IXAdInstanceInfo.CreativeType.VIDEO;
    }

    public void e(IXAdInstanceInfo iXAdInstanceInfo) {
        if (iXAdInstanceInfo != null && !q() && h(iXAdInstanceInfo)) {
            i(iXAdInstanceInfo);
        }
    }

    private boolean a(IXAdInstanceInfo iXAdInstanceInfo, String str) {
        return XAdSDKFoundationFacade.getInstance().getSystemUtils().isWifiConnected(getApplicationContext()).booleanValue() || h(iXAdInstanceInfo) || b(iXAdInstanceInfo);
    }

    private boolean g(IXAdInstanceInfo iXAdInstanceInfo) {
        if (iXAdInstanceInfo != null) {
            try {
                if (iXAdInstanceInfo.getCreativeType() == IXAdInstanceInfo.CreativeType.VIDEO && this.p) {
                    return XAdSDKFoundationFacade.getInstance().getSystemUtils().isWifiConnected(getApplicationContext()).booleanValue();
                }
            } catch (Throwable th) {
                this.v.d("XAbstractAdProdTemplate", th.getMessage());
            }
        }
        return true;
    }

    private boolean h(IXAdInstanceInfo iXAdInstanceInfo) {
        return iXAdInstanceInfo != null && this.o != null && IXAdConstants4PDK.SlotType.SLOT_TYPE_FEEDS.getValue().equals(this.o.getValue()) && iXAdInstanceInfo.getCreativeType() == IXAdInstanceInfo.CreativeType.VIDEO;
    }

    private void a(ArrayList<IXAdInstanceInfo> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<IXAdInstanceInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                IXAdInstanceInfo next = it.next();
                if (q() && h(next)) {
                    i(next);
                }
            }
        }
    }

    private void b(IXAdInstanceInfo iXAdInstanceInfo, String str) {
        if (d(iXAdInstanceInfo)) {
            com.baidu.mobads.b.a.a().a(this.f, "383", iXAdInstanceInfo, this.k.d(), "file_dl_failed_not_wifi", str);
        }
    }

    public boolean f(IXAdInstanceInfo iXAdInstanceInfo) {
        return false;
    }

    private void i(IXAdInstanceInfo iXAdInstanceInfo) {
        this.v.d("XAbstractAdProdTemplate", "cacheCreativeAsset");
        String a2 = a(iXAdInstanceInfo);
        if (!TextUtils.isEmpty(a2)) {
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
    }

    private boolean a(com.baidu.mobads.c.a aVar, IXAdInstanceInfo.CreativeType creativeType, String str) {
        try {
            if (creativeType == IXAdInstanceInfo.CreativeType.VIDEO && this.o != null && IXAdConstants4PDK.SlotType.SLOT_TYPE_FEEDS.getValue().equals(this.o.getValue()) && aVar != null) {
                if (aVar.a(str)) {
                    return true;
                }
            }
        } catch (Throwable th) {
            this.v.d("XAbstractAdProdTemplate", th);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(IXAdInstanceInfo iXAdInstanceInfo, String str, String str2, String str3) {
        try {
            if (g(iXAdInstanceInfo)) {
                XAdSDKFoundationFacade.getInstance().getAdCreativeCacheManager().a(getApplicationContext(), str, str2, str3, new f(this, Looper.getMainLooper(), iXAdInstanceInfo));
            }
        } catch (Throwable th) {
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

    private void b(Message message, IXAdInstanceInfo iXAdInstanceInfo) {
        if (d(iXAdInstanceInfo)) {
            com.baidu.mobads.b.a.a().a(this.f, "383", iXAdInstanceInfo, this.k.d(), "file_dl_" + (message.getData().getBoolean("caching_result") ? "success" : "failed"), a(iXAdInstanceInfo), "" + message.getData().getLong("caching_time_consume", 0L));
        }
    }

    public void a(boolean z2, IXAdInstanceInfo iXAdInstanceInfo) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(com.baidu.mobads.vo.d dVar) {
        this.v.d("XAbstractAdProdTemplate", "doRequest()");
        a(this.f);
        b(dVar);
        return true;
    }

    protected void b(com.baidu.mobads.vo.d dVar) {
        this.k = dVar;
        k();
        this.c = false;
        String b2 = this.i == null ? dVar.b() : this.i;
        this.j = new p();
        com.baidu.mobads.b.a.f3292b = b2;
        com.baidu.mobads.openad.b.b bVar = new com.baidu.mobads.openad.b.b(b2, "");
        bVar.e = 1;
        this.j.addEventListener("URLLoader.Load.Complete", this.F);
        this.j.addEventListener("URLLoader.Load.Error", this.F);
        a(bVar, this.j, this.m);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
        a(iXAdContainer, hashMap);
        if (!IXAdConstants4PDK.SlotType.SLOT_TYPE_SPLASH.getValue().equals(this.o.getValue())) {
            dispatchEvent(new com.baidu.mobads.e.a(IXAdEvent.AD_LOADED));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
        this.l = IXAdConstants4PDK.SlotState.PLAYING;
        b(iXAdContainer, hashMap);
        dispatchEvent(new com.baidu.mobads.e.a(IXAdEvent.AD_STARTED));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
    }

    protected void c(IXAdResponseInfo iXAdResponseInfo) {
        b(iXAdResponseInfo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(String str) {
        HashMap hashMap = new HashMap(1);
        hashMap.put("error_message", str);
        dispatchEvent(new com.baidu.mobads.e.a(IXAdEvent.AD_ERROR, hashMap));
    }

    protected void a(String str, String str2) {
        HashMap hashMap = new HashMap(1);
        hashMap.put("error_message", str);
        hashMap.put("error_code", str2);
        dispatchEvent(new com.baidu.mobads.e.a(IXAdEvent.AD_ERROR, hashMap));
    }

    protected void a(IXAdResponseInfo iXAdResponseInfo) {
        this.v.d("XAbstractAdProdTemplate", "handleAllReady");
        this.g++;
        this.d = iXAdResponseInfo.getPrimaryAdInstanceInfo();
        Context applicationContext = getApplicationContext();
        k kVar = new k(applicationContext, getActivity(), this.k.d(), this.e, new l(applicationContext, this), iXAdResponseInfo, null);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            a(kVar);
        } else {
            new Handler(Looper.getMainLooper()).post(new g(this, kVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(IXAdResponseInfo iXAdResponseInfo, IXAdInstanceInfo iXAdInstanceInfo) {
        this.d = iXAdInstanceInfo;
    }

    @Override // com.baidu.mobads.interfaces.IXAdProd
    public Context getApplicationContext() {
        Activity activity = getActivity();
        return activity == null ? this.f : activity.getApplicationContext();
    }

    @Override // com.baidu.mobads.interfaces.IXAdProd
    public Activity getActivity() {
        if (this.f instanceof Activity) {
            return (Activity) this.f;
        }
        if (this.e == null || !(this.e.getContext() instanceof Activity)) {
            return null;
        }
        return (Activity) this.e.getContext();
    }

    @Override // com.baidu.mobads.interfaces.IXAdProd
    public IXAdContainer getCurrentXAdContainer() {
        return this.h;
    }

    @Override // com.baidu.mobads.interfaces.IXAdProd
    public IXAdContainerFactory getAdContainerFactory() {
        return f3435b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(IXAdContainerContext iXAdContainerContext) {
        try {
            this.v.d("XAbstractAdProdTemplate", "processAllReadyOnUIThread()");
            this.x = System.currentTimeMillis();
            this.h = b(iXAdContainerContext);
            this.y = System.currentTimeMillis();
            if (this.h == null) {
                this.v.d("XAbstractAdProdTemplate", "processAllReadyOnUIThread(), mAdContainer is null");
                dispatchEvent(new com.baidu.mobads.e.a(IXAdEvent.AD_ERROR));
                return;
            }
            this.v.d("XAbstractAdProdTemplate", "processAllReadyOnUIThread(), mAdContainer be created");
            this.q.put("start", "" + this.w);
            this.q.put("container_before_created", "" + this.x);
            this.q.put("container_after_created", "" + this.y);
            this.h.setParameters(this.q);
            com.baidu.mobads.constants.a.c = this.h.getRemoteVersion();
            this.v.d("XAbstractAdProdTemplate", "processAllReadyOnUIThread(), mAdContainer be created, hasCalledLoadAtAppSide=" + this.r.get());
            if (this.r.get()) {
                this.h.load();
            }
            if (IXAdConstants4PDK.SlotType.SLOT_TYPE_SPLASH.getValue().equals(this.o.getValue())) {
                if (this.d == null) {
                    this.d = this.B.getPrimaryAdInstanceInfo();
                }
                HashMap hashMap = new HashMap();
                if (this.d != null) {
                    if (b(this.d)) {
                        hashMap.put(com.baidu.mobads.constants.a.s, "IMAGE");
                    } else if (c(this.d)) {
                        hashMap.put(com.baidu.mobads.constants.a.s, "H5");
                    } else if (d(this.d)) {
                        hashMap.put(com.baidu.mobads.constants.a.s, "VIDEO");
                        int videoDuration = this.d.getVideoDuration();
                        if (videoDuration != 0) {
                            hashMap.put(com.baidu.mobads.constants.a.t, Integer.valueOf(videoDuration * 1000));
                        }
                    }
                }
                dispatchEvent(new com.baidu.mobads.e.a(IXAdEvent.AD_LOADED, hashMap));
            }
            c();
        } catch (Exception e) {
            this.v.e(XAdSDKFoundationFacade.getInstance().getErrorCode().genCompleteErrorMessage(XAdErrorCode.PERMISSION_PROBLEM, e.getMessage()));
            dispatchEvent(new com.baidu.mobads.e.a(IXAdEvent.AD_ERROR));
        }
    }

    private IXAdContainer b(IXAdContainerContext iXAdContainerContext) {
        IXAdContainer iXAdContainer = null;
        this.v.d("XAbstractAdProdTemplate", "createAdContainer");
        if (f3435b != null) {
            if (this.u != null && this.u.containsKey("Display_Down_Info")) {
                iXAdContainer = f3435b.createXAdContainer(iXAdContainerContext, this.u);
            } else {
                iXAdContainer = f3435b.createXAdContainer(iXAdContainerContext, null);
            }
            if (iXAdContainer != null) {
                this.v.d("XAbstractAdProdTemplate", "createAdContainer() apk.version=" + f3435b.getRemoteVersion());
            }
        }
        return iXAdContainer;
    }

    @Override // com.baidu.mobads.interfaces.IXAdProd
    public IXAdProdInfo getProdInfo() {
        return this.k.d();
    }

    @Override // com.baidu.mobads.interfaces.IXAdProd
    public void setParameter(HashMap<String, String> hashMap) {
        this.q = hashMap;
    }

    @Override // com.baidu.mobads.interfaces.IXAdProd
    public HashMap<String, String> getParameter() {
        return this.q;
    }

    @Override // com.baidu.mobads.interfaces.IXAdProd
    public int getDuration() {
        return -1;
    }

    @Override // com.baidu.mobads.interfaces.IXAdProd
    public int getPlayheadTime() {
        return -1;
    }

    @Override // com.baidu.mobads.interfaces.IXAdProd
    public IXAdInstanceInfo getCurrentAdInstance() {
        return this.d;
    }

    @Override // com.baidu.mobads.interfaces.IXAdProd
    public ViewGroup getProdBase() {
        return this.e;
    }

    @Override // com.baidu.mobads.interfaces.IXAdProd
    public void load() {
        if (this.h != null) {
            this.h.load();
        } else {
            this.r.set(true);
        }
    }

    @Override // com.baidu.mobads.interfaces.IXAdProd
    public void resize() {
        if (this.h != null && getApplicationContext() != null) {
            new Handler(getApplicationContext().getMainLooper()).post(new h(this));
        }
    }

    @Override // com.baidu.mobads.interfaces.IXAdProd
    public void pause() {
        i();
    }

    protected void i() {
        if (this.h != null && getApplicationContext() != null) {
            this.l = IXAdConstants4PDK.SlotState.PAUSED;
            new Handler(getApplicationContext().getMainLooper()).post(new i(this));
        }
    }

    @Override // com.baidu.mobads.interfaces.IXAdProd
    public void start() {
        if (this.h != null) {
            this.h.start();
        }
    }

    @Override // com.baidu.mobads.interfaces.IXAdProd
    public void resume() {
        j();
    }

    protected void j() {
        if (this.h != null && getApplicationContext() != null) {
            this.l = IXAdConstants4PDK.SlotState.PLAYING;
            new Handler(getApplicationContext().getMainLooper()).post(new j(this));
        }
    }

    @Override // com.baidu.mobads.interfaces.IXAdProd
    public void stop() {
        XAdSDKFoundationFacade.getInstance().getAdLogger().d("XAbstractAdProdTemplate", "stop");
        if (this.h != null) {
            this.h.stop();
            this.h = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k() {
        if (this.j != null) {
            this.j.removeAllListeners();
            this.j.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l() {
        if (this.E != null) {
            this.D.removeCallbacks(this.E);
        }
        this.E = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m() {
        if (this.E != null) {
            this.D.postDelayed(this.E, this.m);
        }
    }

    public void n() {
        if (this.h != null) {
            this.h.onAttachedToWindow();
        }
    }

    @SuppressLint({"MissingSuperCall"})
    public void o() {
        if (this.h != null) {
            this.h.onDetachedFromWindow();
        }
    }

    public void b(int i) {
        if (this.h != null) {
            this.h.onWindowVisibilityChanged(i);
        }
    }

    public void a(boolean z2) {
        if (this.h != null) {
            this.h.onWindowFocusChanged(z2);
        }
    }

    public boolean a(int i, KeyEvent keyEvent) {
        if (this.h != null) {
            return this.h.processKeyEvent(i, keyEvent).booleanValue();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(String str) {
        if (TextUtils.isEmpty(str)) {
            this.v.e("代码位id(adPlaceId)不可以为空");
        }
    }

    public void p() {
        if (this.h != null) {
            this.h.destroy();
        }
        BaiduXAdSDKContext.exit();
    }

    @Override // com.baidu.mobads.interfaces.IXAdProd
    public IXAdResponseInfo getAdResponseInfo() {
        return this.B;
    }

    @Override // com.baidu.mobads.interfaces.IXAdProd
    public void setAdResponseInfo(IXAdResponseInfo iXAdResponseInfo) {
        this.B = iXAdResponseInfo;
    }

    @Override // com.baidu.mobads.interfaces.IXAdProd
    public Boolean isAdServerRequestingSuccess() {
        return this.c;
    }

    public void a(RequestParameters requestParameters) {
        this.t = requestParameters;
    }

    @Override // com.baidu.mobads.interfaces.IXAdProd
    public IXAdFeedsRequestParameters getRequestParameters() {
        if (this.t == null) {
            this.t = new RequestParameters.Builder().build();
        }
        return this.t;
    }

    public boolean q() {
        return false;
    }

    public void b(boolean z2) {
        this.p = z2;
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
        } catch (Throwable th) {
        }
        return hashMap;
    }
}
