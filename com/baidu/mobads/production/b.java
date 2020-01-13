package com.baidu.mobads.production;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.interfaces.IXAdContainer;
import com.baidu.mobads.interfaces.IXAdContainerContext;
import com.baidu.mobads.interfaces.IXAdContainerFactory;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.IXAdProdInfo;
import com.baidu.mobads.interfaces.IXAdResponseInfo;
import com.baidu.mobads.interfaces.IXNonLinearAdSlot;
import com.baidu.mobads.interfaces.download.activate.IXActivateListener;
import com.baidu.mobads.interfaces.download.activate.IXAppInfo;
import com.baidu.mobads.interfaces.error.XAdErrorCode;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.baidu.mobads.vo.XAdInstanceInfo;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes8.dex */
public abstract class b extends com.baidu.mobads.openad.c.c implements IXNonLinearAdSlot {
    public static IXAdContainerFactory a;
    private static final String[] w = {"android.permission.READ_PHONE_STATE", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.WRITE_EXTERNAL_STORAGE"};
    protected RelativeLayout e;
    protected Context f;
    public IXAdContainer h;
    protected String i;
    protected v j;
    protected com.baidu.mobads.vo.d k;
    protected IXAdConstants4PDK.SlotType o;
    protected long t;
    protected long u;
    protected long v;
    private IXAdResponseInfo x;
    private String y;
    protected Boolean b = false;
    public IXAdInstanceInfo d = null;
    protected int g = 0;
    protected IXAdConstants4PDK.SlotState l = IXAdConstants4PDK.SlotState.IDEL;
    protected int m = 5000;
    protected int n = 0;
    protected HashMap<String, String> p = new HashMap<>();
    protected AtomicBoolean q = new AtomicBoolean();
    private Handler z = new Handler(Looper.getMainLooper());
    private Runnable A = null;
    protected String r = "";
    private IOAdEventListener B = new c(this);
    protected final IXAdLogger s = XAdSDKFoundationFacade.getInstance().getAdLogger();

    protected abstract void a(com.baidu.mobads.openad.d.c cVar, v vVar, int i);

    protected abstract void c(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap);

    public abstract void c(IXAdResponseInfo iXAdResponseInfo);

    protected abstract void d(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap);

    public abstract void g();

    protected abstract void h();

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        com.baidu.mobads.a.a.n = System.currentTimeMillis();
        a(this.x);
        if (!d()) {
            b("XAdMouldeLoader ad-server requesting success");
            return;
        }
        IXAdInstanceInfo primaryAdInstanceInfo = this.x.getPrimaryAdInstanceInfo();
        String b = b(primaryAdInstanceInfo);
        if (TextUtils.isEmpty(b)) {
            b("XAdMouldeLoader ad-server requesting success");
            return;
        }
        boolean a2 = a(b, primaryAdInstanceInfo);
        a(a2, primaryAdInstanceInfo);
        if (a2) {
            if (e() && TextUtils.isEmpty(((XAdInstanceInfo) this.d).getSplash3DLocalUrl())) {
                this.s.i("XAbstractAdProdTemplate", "背景图片没有缓存完成");
            } else {
                b("download the splash picture successfully");
            }
        } else if (a(primaryAdInstanceInfo)) {
            d(this.x);
        } else {
            if (!f(primaryAdInstanceInfo)) {
                b("XAdMouldeLoader ad-server requesting success");
            }
            d(this.x);
        }
    }

    boolean a(String str, IXAdInstanceInfo iXAdInstanceInfo) {
        boolean z = false;
        if (!TextUtils.isEmpty(str)) {
            try {
                String b = com.baidu.mobads.utils.i.b(getApplicationContext(), str);
                if (new File(b).exists()) {
                    XAdSDKFoundationFacade.getInstance().getAdCreativeCacheManager().c(b);
                    if (e()) {
                        String a2 = com.baidu.mobads.utils.i.a(getApplicationContext(), iXAdInstanceInfo.getMainPictureUrl());
                        File file = new File(a2);
                        if (file != null && file.exists()) {
                            XAdSDKFoundationFacade.getInstance().getAdCreativeCacheManager().c(a2);
                            c(iXAdInstanceInfo, com.baidu.mobads.utils.i.a(getApplicationContext(), iXAdInstanceInfo.getMainPictureUrl()));
                            z = true;
                        }
                    } else {
                        iXAdInstanceInfo.setLocalCreativeURL(b);
                        z = true;
                    }
                }
            } catch (Exception e) {
                com.baidu.mobads.utils.m.a().e(e);
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a() {
    }

    public b(Context context) {
        new Thread(new g(this, context)).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class a implements IXActivateListener {
        private Context a;

        public a(Context context) {
            this.a = context.getApplicationContext();
        }

        @Override // com.baidu.mobads.interfaces.download.activate.IXActivateListener
        public void onAppActivation(IXAppInfo iXAppInfo) {
            com.baidu.mobads.c.a.a().b(this.a, iXAppInfo);
        }

        @Override // com.baidu.mobads.interfaces.download.activate.IXActivateListener
        public void onAppInstalled(IXAppInfo iXAppInfo) {
            com.baidu.mobads.c.a.a().a(this.a, iXAppInfo);
        }
    }

    private void b(Context context) {
        new Handler(Looper.getMainLooper()).postDelayed(new h(this, context), 2000L);
    }

    @Override // com.baidu.mobads.interfaces.IXAdProd
    public IXAdConstants4PDK.SlotState getSlotState() {
        return this.l;
    }

    @Override // com.baidu.mobads.interfaces.IXAdProd
    public void setActivity(Context context) {
        this.f = context;
        c();
        this.q.set(false);
        h();
        com.baidu.mobads.c.a.a().a(getApplicationContext());
        XAdSDKFoundationFacade.getInstance().initializeApplicationContext(getApplicationContext());
        this.A = new j(this);
        com.baidu.mobads.g.q.a(this.f).a();
    }

    public void b() {
    }

    @Override // com.baidu.mobads.interfaces.IXAdProd
    public void setAdSlotBase(RelativeLayout relativeLayout) {
        this.e = relativeLayout;
    }

    @Override // com.baidu.mobads.interfaces.IXAdProd
    public void setId(String str) {
        this.y = str;
    }

    protected void c() {
    }

    @Override // com.baidu.mobads.interfaces.IXAdProd
    public String getId() {
        return this.y;
    }

    @Override // com.baidu.mobads.interfaces.IXAdProd
    public IXAdConstants4PDK.SlotType getType() {
        return this.o;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(XAdErrorCode xAdErrorCode, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("msg", xAdErrorCode);
        dispatchEvent(new com.baidu.mobads.f.a(IXAdEvent.AD_ERROR, hashMap));
        XAdSDKFoundationFacade.getInstance().getErrorCode().printErrorMessage(xAdErrorCode, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("error_message", str);
        dispatchEvent(new com.baidu.mobads.f.a(IXAdEvent.AD_ERROR, hashMap));
        XAdSDKFoundationFacade.getInstance().getErrorCode().printErrorMessage("", str, "");
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
        if (a != null) {
            r();
        } else {
            BaiduXAdSDKContext.mApkLoader.a(new k(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        BaiduXAdSDKContext.isRemoteLoadSuccess = true;
        c("XAdMouldeLoader load success");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(String str) {
        this.b = true;
        c(str);
    }

    protected void c(String str) {
        this.s.i("XAbstractAdProdTemplate", "doubleCheck:" + str + ", bfp=" + this.b + ", apk=" + BaiduXAdSDKContext.isRemoteLoadSuccess);
        if (BaiduXAdSDKContext.isRemoteLoadSuccess.booleanValue()) {
            XAdSDKFoundationFacade.getInstance().initializeAdContainerFactory(getAdContainerFactory());
        }
        if (BaiduXAdSDKContext.isRemoteLoadSuccess.booleanValue() && this.b.booleanValue()) {
            IXAdResponseInfo adResponseInfo = getAdResponseInfo();
            if (adResponseInfo != null) {
                try {
                    b(adResponseInfo);
                    return;
                } catch (Exception e) {
                    this.s.i("XAbstractAdProdTemplate", e);
                    return;
                }
            }
            this.s.i("XAbstractAdProdTemplate", "doubleCheck IXAdResponseInfo is null, but isBFP4APPRequestSuccess is true");
        }
    }

    public boolean d() {
        return false;
    }

    public boolean a(IXAdInstanceInfo iXAdInstanceInfo) {
        return false;
    }

    public String b(IXAdInstanceInfo iXAdInstanceInfo) {
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

    public boolean c(IXAdInstanceInfo iXAdInstanceInfo) {
        return iXAdInstanceInfo.getCreativeType() == IXAdInstanceInfo.CreativeType.STATIC_IMAGE || iXAdInstanceInfo.getCreativeType() == IXAdInstanceInfo.CreativeType.GIF;
    }

    public boolean d(IXAdInstanceInfo iXAdInstanceInfo) {
        return iXAdInstanceInfo.getCreativeType() == IXAdInstanceInfo.CreativeType.HTML;
    }

    public boolean e() {
        if (TextUtils.isEmpty(this.r)) {
            return false;
        }
        return this.r.endsWith("3d");
    }

    public boolean e(IXAdInstanceInfo iXAdInstanceInfo) {
        return (iXAdInstanceInfo.getCreativeType() == IXAdInstanceInfo.CreativeType.RM && this.r.endsWith("vr")) || iXAdInstanceInfo.getCreativeType() == IXAdInstanceInfo.CreativeType.VIDEO;
    }

    private boolean a(IXAdInstanceInfo iXAdInstanceInfo, String str) {
        return XAdSDKFoundationFacade.getInstance().getSystemUtils().isWifiConnected(getApplicationContext()).booleanValue() || c(iXAdInstanceInfo) || e();
    }

    private void b(IXAdInstanceInfo iXAdInstanceInfo, String str) {
        if (e(iXAdInstanceInfo)) {
            com.baidu.mobads.c.a.a().a(this.f, "383", iXAdInstanceInfo, this.k.d(), "file_dl_failed_not_wifi", str);
        }
    }

    public boolean f(IXAdInstanceInfo iXAdInstanceInfo) {
        return false;
    }

    private void d(IXAdResponseInfo iXAdResponseInfo) {
        this.s.i("XAbstractAdProdTemplate", "cacheCreativeAsset");
        IXAdInstanceInfo primaryAdInstanceInfo = iXAdResponseInfo.getPrimaryAdInstanceInfo();
        String b = b(primaryAdInstanceInfo);
        if (!TextUtils.isEmpty(b)) {
            if (!a(primaryAdInstanceInfo, b)) {
                b(primaryAdInstanceInfo, b);
                return;
            }
            primaryAdInstanceInfo.setLocalCreativeURL(null);
            String a2 = com.baidu.mobads.utils.i.a(getApplicationContext());
            String b2 = com.baidu.mobads.utils.i.b(b);
            com.baidu.mobads.utils.i adCreativeCacheManager = XAdSDKFoundationFacade.getInstance().getAdCreativeCacheManager();
            adCreativeCacheManager.a(a2);
            adCreativeCacheManager.a(getApplicationContext(), b, a2, b2, new l(this, Looper.getMainLooper(), primaryAdInstanceInfo));
        }
    }

    private void c(IXAdInstanceInfo iXAdInstanceInfo, String str) {
        File[] listFiles = new File(str).listFiles();
        String[] strArr = {"jpg", "png", "jpeg"};
        if (listFiles != null && listFiles.length > 0) {
            for (int i = 0; i < listFiles.length; i++) {
                File[] listFiles2 = listFiles[i].listFiles();
                if (listFiles2 != null && listFiles2.length > 0) {
                    for (int i2 = 0; i2 < listFiles2.length; i2++) {
                        if (listFiles2[i2].getName().endsWith(".mp4")) {
                            iXAdInstanceInfo.setLocalCreativeURL(listFiles[i].getAbsolutePath());
                            return;
                        }
                        for (String str2 : strArr) {
                            if (listFiles2[i2].getName().toLowerCase().endsWith(str2)) {
                                iXAdInstanceInfo.setLocalCreativeURL(listFiles[i].getAbsolutePath());
                                return;
                            }
                        }
                    }
                    continue;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Message message, IXAdInstanceInfo iXAdInstanceInfo) {
        if (message.getData().getBoolean("caching_result")) {
            String string = message.getData().getString("local_creative_url");
            iXAdInstanceInfo.setLocalCreativeURL(string);
            if (iXAdInstanceInfo.getCreativeType() == IXAdInstanceInfo.CreativeType.RM) {
                if (e()) {
                    Log.e("XAbstractAdProdTemplate", "processDlResult: " + string);
                    try {
                        com.baidu.mobads.utils.v.a(string, com.baidu.mobads.utils.i.a(getApplicationContext(), iXAdInstanceInfo.getMainPictureUrl()));
                        c(iXAdInstanceInfo, com.baidu.mobads.utils.i.a(getApplicationContext(), iXAdInstanceInfo.getMainPictureUrl()));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (this.r.endsWith("vr")) {
                    a(XAdSDKFoundationFacade.getInstance().getCommonUtils().md5(iXAdInstanceInfo.getMainPictureUrl()), Uri.parse(string));
                }
            }
            if (f(iXAdInstanceInfo)) {
                if (e() && TextUtils.isEmpty(((XAdInstanceInfo) this.d).getSplash3DLocalUrl())) {
                    this.s.i("XAbstractAdProdTemplate", "背景图片没有缓存完成");
                } else {
                    b("download the splash picture successfully");
                }
            }
        } else {
            iXAdInstanceInfo.setLocalCreativeURL(null);
            if (f(iXAdInstanceInfo)) {
                b("download the splash picture successfully");
            }
        }
        b(message, iXAdInstanceInfo);
    }

    private void b(Message message, IXAdInstanceInfo iXAdInstanceInfo) {
        if (e(iXAdInstanceInfo)) {
            com.baidu.mobads.c.a.a().a(this.f, "383", iXAdInstanceInfo, this.k.d(), "file_dl_" + (message.getData().getBoolean("caching_result") ? "success" : "failed"), b(iXAdInstanceInfo), "" + message.getData().getLong("caching_time_consume", 0L));
        }
    }

    private void a(String str, Uri uri) {
        new Thread(new m(this, str, uri)).start();
    }

    public void a(boolean z, IXAdInstanceInfo iXAdInstanceInfo) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(com.baidu.mobads.vo.d dVar) {
        this.s.i("XAbstractAdProdTemplate", "doRequest()");
        new Thread(new n(this, dVar)).start();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(com.baidu.mobads.vo.d dVar) {
        this.k = dVar;
        k();
        this.b = false;
        String b = this.i == null ? dVar.b() : this.i;
        this.j = new v();
        com.baidu.mobads.c.a.b = b;
        com.baidu.mobads.openad.d.c cVar = new com.baidu.mobads.openad.d.c(b, "");
        cVar.e = 1;
        this.j.addEventListener("URLLoader.Load.Complete", this.B);
        this.j.addEventListener("URLLoader.Load.Error", this.B);
        a(cVar, this.j, this.m);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
        l();
        c(iXAdContainer, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
        this.l = IXAdConstants4PDK.SlotState.PLAYING;
        d(iXAdContainer, hashMap);
        dispatchEvent(new com.baidu.mobads.f.a(IXAdEvent.AD_STARTED));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
    }

    protected void a(IXAdResponseInfo iXAdResponseInfo) {
        c(iXAdResponseInfo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(String str) {
        com.baidu.mobads.c.a.a().a(str);
        HashMap hashMap = new HashMap(1);
        hashMap.put("error_message", str);
        dispatchEvent(new com.baidu.mobads.f.a(IXAdEvent.AD_ERROR, hashMap));
    }

    protected void b(IXAdResponseInfo iXAdResponseInfo) {
        this.s.i("XAbstractAdProdTemplate", "handleAllReady");
        this.g++;
        this.d = iXAdResponseInfo.getPrimaryAdInstanceInfo();
        Context applicationContext = getApplicationContext();
        p pVar = new p(applicationContext, getActivity(), this.k.d(), this.e, new q(applicationContext, this), iXAdResponseInfo, null);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            a(pVar);
        } else {
            new Handler(Looper.getMainLooper()).post(new o(this, pVar));
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
        return a;
    }

    public static IXAdContainerFactory f() {
        return a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(IXAdContainerContext iXAdContainerContext) {
        try {
            this.s.i("XAbstractAdProdTemplate", "processAllReadyOnUIThread()");
            this.u = System.currentTimeMillis();
            this.h = b(iXAdContainerContext);
            this.v = System.currentTimeMillis();
            if (this.h == null) {
                this.s.e("XAbstractAdProdTemplate", "processAllReadyOnUIThread(), mAdContainer is null");
                dispatchEvent(new com.baidu.mobads.f.a(IXAdEvent.AD_STOPPED));
                return;
            }
            this.s.i("XAbstractAdProdTemplate", "processAllReadyOnUIThread(), mAdContainer be created");
            this.p.put("start", "" + this.t);
            this.p.put("container_before_created", "" + this.u);
            this.p.put("container_after_created", "" + this.v);
            this.h.setParameters(this.p);
            com.baidu.mobads.a.a.c = this.h.getRemoteVersion();
            this.s.i("XAbstractAdProdTemplate", "processAllReadyOnUIThread(), mAdContainer be created, hasCalledLoadAtAppSide=" + this.q.get());
            if (this.q.get()) {
                this.h.load();
            }
            g();
            b(this.f);
        } catch (Exception e) {
            e.printStackTrace();
            this.s.e(XAdSDKFoundationFacade.getInstance().getErrorCode().genCompleteErrorMessage(XAdErrorCode.PERMISSION_PROBLEM, e.getMessage()));
            com.baidu.mobads.c.a.a().a("process all ready on UI Thread exception: " + e.toString());
        }
    }

    private IXAdContainer b(IXAdContainerContext iXAdContainerContext) {
        IXAdContainer iXAdContainer = null;
        this.s.i("XAbstractAdProdTemplate", "createAdContainer");
        if (a != null && (iXAdContainer = a.createXAdContainer(iXAdContainerContext, null)) != null) {
            this.s.i("XAbstractAdProdTemplate", "createAdContainer() apk.version=" + a.getRemoteVersion());
        }
        return iXAdContainer;
    }

    @Override // com.baidu.mobads.interfaces.IXAdProd
    public IXAdProdInfo getProdInfo() {
        return this.k.d();
    }

    @Override // com.baidu.mobads.interfaces.IXAdProd
    public void setParameter(HashMap<String, String> hashMap) {
        this.p = hashMap;
    }

    @Override // com.baidu.mobads.interfaces.IXAdProd
    public HashMap<String, String> getParameter() {
        return this.p;
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
            this.q.set(true);
        }
    }

    @Override // com.baidu.mobads.interfaces.IXAdProd
    public void resize() {
        if (this.h != null && getApplicationContext() != null) {
            new Handler(getApplicationContext().getMainLooper()).post(new d(this));
        }
    }

    @Override // com.baidu.mobads.interfaces.IXAdProd
    public void pause() {
        i();
    }

    protected void i() {
        if (this.h != null && getApplicationContext() != null) {
            this.l = IXAdConstants4PDK.SlotState.PAUSED;
            new Handler(getApplicationContext().getMainLooper()).post(new e(this));
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
            new Handler(getApplicationContext().getMainLooper()).post(new f(this));
        }
    }

    @Override // com.baidu.mobads.interfaces.IXAdProd
    public void stop() {
        XAdSDKFoundationFacade.getInstance().getAdLogger().i("XAbstractAdProdTemplate", "stop");
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
        if (this.A != null) {
            this.z.removeCallbacks(this.A);
        }
        this.A = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m() {
        if (this.A != null) {
            this.z.postDelayed(this.A, this.m);
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

    public void a(int i) {
        if (this.h != null) {
            this.h.onWindowVisibilityChanged(i);
        }
    }

    public void a(boolean z) {
        if (this.h != null) {
            this.h.onWindowFocusChanged(z);
        }
    }

    public boolean a(int i, KeyEvent keyEvent) {
        if (this.h != null) {
            return this.h.processKeyEvent(i, keyEvent).booleanValue();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(String str) {
        if (TextUtils.isEmpty(str)) {
            this.s.e("代码位id(adPlaceId)不可以为空");
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
        return this.x;
    }

    @Override // com.baidu.mobads.interfaces.IXAdProd
    public void setAdResponseInfo(IXAdResponseInfo iXAdResponseInfo) {
        this.x = iXAdResponseInfo;
    }

    @Override // com.baidu.mobads.interfaces.IXAdProd
    public Boolean isAdServerRequestingSuccess() {
        return this.b;
    }
}
