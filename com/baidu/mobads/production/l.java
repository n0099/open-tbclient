package com.baidu.mobads.production;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.baidu.mobads.component.FeedPortraitVideoView;
import com.baidu.mobads.interfaces.IXAdContainer;
import com.baidu.mobads.interfaces.IXAdContainerContext;
import com.baidu.mobads.interfaces.IXAdContainerEventListener;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.IXAdResource;
import com.baidu.mobads.interfaces.IXNonLinearAdSlot;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.baidu.mobads.utils.q;
import com.baidu.mobads.utils.t;
import com.baidu.walletfacesdk.LightInvokerImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Timer;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public class l implements IXAdContainerEventListener {

    /* renamed from: a  reason: collision with root package name */
    public Context f8485a;

    /* renamed from: b  reason: collision with root package name */
    public final a f8486b;

    /* renamed from: g  reason: collision with root package name */
    public IXAdContainer f8491g;

    /* renamed from: h  reason: collision with root package name */
    public IXAdInstanceInfo f8492h;
    public com.baidu.mobads.utils.h i;
    public t j;
    public IXAdResource k;
    public int l = 0;
    public int m = 2;
    public int n = 15;
    public int o = 0;
    public int p = 2;
    public int q = 15;

    /* renamed from: c  reason: collision with root package name */
    public AtomicBoolean f8487c = new AtomicBoolean(false);

    /* renamed from: d  reason: collision with root package name */
    public AtomicBoolean f8488d = new AtomicBoolean(false);

    /* renamed from: e  reason: collision with root package name */
    public AtomicBoolean f8489e = new AtomicBoolean(false);

    /* renamed from: f  reason: collision with root package name */
    public AtomicBoolean f8490f = new AtomicBoolean(false);

    public l(Context context, a aVar) {
        this.f8485a = context;
        this.f8486b = aVar;
    }

    public static /* synthetic */ int d(l lVar) {
        int i = lVar.o;
        lVar.o = i + 1;
        return i;
    }

    /* JADX WARN: Removed duplicated region for block: B:69:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:77:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.mobads.interfaces.IXAdContainerEventListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onAdClicked(IXAdContainer iXAdContainer, IXAdInstanceInfo iXAdInstanceInfo, Boolean bool, HashMap<String, Object> hashMap) {
        com.baidu.mobads.e.a aVar = new com.baidu.mobads.e.a("AdUserClick");
        aVar.a(iXAdInstanceInfo);
        aVar.getData().put(LightInvokerImpl.VOICE_ACTIONTYPE, Integer.valueOf(iXAdInstanceInfo.getActionType()));
        this.f8486b.dispatchEvent(aVar);
        this.i = XAdSDKFoundationFacade.getInstance().getCommonUtils();
        this.j = (t) XAdSDKFoundationFacade.getInstance().getSystemUtils();
        com.baidu.mobads.utils.l adConstants = XAdSDKFoundationFacade.getInstance().getAdConstants();
        IXNonLinearAdSlot iXNonLinearAdSlot = this.f8486b;
        this.f8491g = iXAdContainer;
        this.f8492h = iXAdInstanceInfo;
        this.k = iXAdContainer.getAdContainerContext().getAdResource();
        String clickThroughUrl = iXAdInstanceInfo.getClickThroughUrl();
        int actionType = iXAdInstanceInfo.getActionType();
        ArrayList arrayList = new ArrayList();
        List<String> thirdClickTrackingUrls = iXAdInstanceInfo.getThirdClickTrackingUrls();
        for (int i = 0; i < thirdClickTrackingUrls.size(); i++) {
            arrayList.add(thirdClickTrackingUrls.get(i).replaceAll("\\$\\{PROGRESS\\}", String.valueOf((int) iXAdContainer.getPlayheadTime())));
        }
        Set<String> hashSet = new HashSet<>();
        hashSet.addAll(arrayList);
        a(hashSet);
        if (actionType == adConstants.getActTypeOpenExternalApp()) {
            q a2 = q.a();
            a2.i("XAdContainerEventListener", "APO in proxy: " + iXAdInstanceInfo.getAppName());
        } else {
            if (actionType == adConstants.getActTypeDownload()) {
                if (!a(hashMap, iXNonLinearAdSlot, this.k, iXAdInstanceInfo)) {
                    q a3 = q.a();
                    a3.i("XAdContainerEventListener", "download apk in proxy: " + iXAdInstanceInfo.getAppName());
                }
            } else if (actionType != adConstants.getActTypeLandingPage() && actionType != adConstants.getActTypeOpenMap()) {
                if (actionType != adConstants.getActTypeMakeCall() && actionType != adConstants.getActTypeSendSMS() && actionType != adConstants.getActTypeSendMail()) {
                    if (actionType != adConstants.getActTypeNothing2Do()) {
                        adConstants.getActTypeRichMedia();
                    }
                } else {
                    if (bool.booleanValue()) {
                        new com.baidu.mobads.command.a.a(iXNonLinearAdSlot, iXAdInstanceInfo, this.k, clickThroughUrl).a();
                    }
                    if (actionType == adConstants.getActTypeMakeCall()) {
                        PackageManager packageManager = iXNonLinearAdSlot.getApplicationContext().getPackageManager();
                        Intent intent = new Intent("android.intent.action.VIEW");
                        intent.setData(Uri.parse(clickThroughUrl));
                        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 64);
                        if (queryIntentActivities != null && queryIntentActivities.size() > 0) {
                            String str = null;
                            int i2 = 0;
                            while (true) {
                                if (i2 >= queryIntentActivities.size()) {
                                    r6 = true;
                                    break;
                                } else if (i2 >= 1 && str != null && !str.equals(queryIntentActivities.get(i2).activityInfo.processName)) {
                                    break;
                                } else {
                                    str = queryIntentActivities.get(i2).activityInfo.processName;
                                    i2++;
                                }
                            }
                            if (r6) {
                                a(iXNonLinearAdSlot.getApplicationContext(), str);
                            }
                        }
                    }
                }
            } else {
                r6 = this.f8486b.getProdInfo().getProdType() != adConstants.getProductionTypeSplash();
                if (bool.booleanValue()) {
                    if (iXAdInstanceInfo.isInapp()) {
                        if (!a(hashMap, iXNonLinearAdSlot, this.k, iXAdInstanceInfo)) {
                            com.baidu.mobads.command.b.c cVar = new com.baidu.mobads.command.b.c(iXNonLinearAdSlot, iXAdInstanceInfo, this.k, clickThroughUrl);
                            if (hashMap != null && hashMap.containsKey("lpShoubaiStyle")) {
                                cVar.f8198f = (String) hashMap.get("lpShoubaiStyle");
                            }
                            cVar.a();
                        }
                    } else {
                        this.i.browserOutside(iXAdContainer.getAdContainerContext().getApplicationContext(), clickThroughUrl);
                    }
                }
            }
            if (r6) {
                return;
            }
            this.f8486b.dispatchEvent(new com.baidu.mobads.e.a(IXAdEvent.AD_CLICK_THRU));
            return;
        }
        r6 = true;
        if (r6) {
        }
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerEventListener
    public void onAdCustomEvent(String str, IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        if (str.equals("onrvideocachesucc")) {
            this.f8486b.dispatchEvent(new com.baidu.mobads.e.a("AdRvdieoCacheSucc", hashMap));
        } else if (str.equals("onrvideocachefailed")) {
            this.f8486b.dispatchEvent(new com.baidu.mobads.e.a("AdRvdieoCacheFailed", hashMap));
        } else if (str.equals(FeedPortraitVideoView.PLAY_END)) {
            this.f8486b.dispatchEvent(new com.baidu.mobads.e.a("PlayCompletion", hashMap));
        } else if (str.equals("AdRvdieoPlayError")) {
            this.f8486b.dispatchEvent(new com.baidu.mobads.e.a("AdRvdieoPlayError", hashMap));
        } else if (str.equals("AdVideoSkip")) {
            this.f8486b.dispatchEvent(new com.baidu.mobads.e.a("AdVideoSkip", hashMap));
        } else if (str.equals("AdStatusChange")) {
            this.f8486b.dispatchEvent(new com.baidu.mobads.e.a("AdStatusChange", hashMap));
        }
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerEventListener
    public void onAdDurationChange(IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        if (this.f8489e.get()) {
        }
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerEventListener
    public void onAdError(IXAdContainer iXAdContainer, IXAdInstanceInfo iXAdInstanceInfo, Boolean bool, HashMap<String, Object> hashMap) {
        if (this.f8489e.get()) {
            return;
        }
        this.f8489e.set(true);
        this.f8486b.dispatchEvent(new com.baidu.mobads.e.a(IXAdEvent.AD_ERROR, hashMap));
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerEventListener
    public void onAdExpandedChange(IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        if (this.f8489e.get()) {
        }
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerEventListener
    public void onAdImpression(IXAdContainer iXAdContainer, IXAdInstanceInfo iXAdInstanceInfo, Boolean bool, HashMap<String, Object> hashMap) {
        a(iXAdInstanceInfo.getImpressionUrls());
        com.baidu.mobads.e.a aVar = new com.baidu.mobads.e.a(IXAdEvent.AD_IMPRESSION);
        aVar.a(iXAdInstanceInfo);
        this.f8486b.dispatchEvent(aVar);
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerEventListener
    public void onAdInteraction(IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        if (this.f8489e.get()) {
        }
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerEventListener
    public void onAdLinearChange(IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        if (this.f8489e.get()) {
        }
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerEventListener
    public void onAdLoaded(IXAdContainer iXAdContainer, IXAdInstanceInfo iXAdInstanceInfo, Boolean bool, HashMap<String, Object> hashMap) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.f8486b.c(iXAdContainer, hashMap);
        } else {
            new Handler(this.f8485a.getMainLooper()).post(new n(this, iXAdContainer, hashMap));
        }
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerEventListener
    public void onAdPaused(IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        this.f8486b.dispatchEvent(new com.baidu.mobads.e.a(IXAdEvent.AD_PAUSED));
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerEventListener
    public void onAdPlaying(IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        this.f8486b.dispatchEvent(new com.baidu.mobads.e.a(IXAdEvent.AD_PLAYING));
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerEventListener
    public void onAdRemainingTimeChange(IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        if (this.f8489e.get()) {
        }
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerEventListener
    public void onAdSizeChange(IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        if (this.f8489e.get()) {
        }
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerEventListener
    public void onAdSkippableStateChange(IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        if (this.f8489e.get()) {
        }
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerEventListener
    public void onAdSkipped(IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        if (this.f8489e.get()) {
        }
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerEventListener
    public void onAdStarted(IXAdContainer iXAdContainer, IXAdInstanceInfo iXAdInstanceInfo, Boolean bool, HashMap<String, Object> hashMap) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.f8486b.d(iXAdContainer, hashMap);
        } else {
            new Handler(this.f8485a.getMainLooper()).post(new o(this, iXAdContainer, hashMap));
        }
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerEventListener
    public void onAdStoped(IXAdContainer iXAdContainer, IXAdInstanceInfo iXAdInstanceInfo, Boolean bool, Boolean bool2, HashMap<String, Object> hashMap) {
        if (iXAdInstanceInfo != null) {
            HashSet hashSet = new HashSet();
            hashSet.addAll(iXAdInstanceInfo.getCloseTrackers());
            a(hashSet);
        }
        if (bool2.booleanValue()) {
            IXAdContainerContext adContainerContext = iXAdContainer.getAdContainerContext();
            this.f8486b.a(adContainerContext.getAdResponseInfo(), adContainerContext.getAdInstanceInfo());
            return;
        }
        this.f8486b.e(iXAdContainer, hashMap);
        this.f8486b.dispatchEvent(new com.baidu.mobads.e.a(IXAdEvent.AD_STOPPED, hashMap));
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerEventListener
    public void onAdUserAcceptInvitation(IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        if (this.f8489e.get()) {
        }
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerEventListener
    public void onAdUserClosed(IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        this.f8486b.dispatchEvent(new com.baidu.mobads.e.a(IXAdEvent.AD_USER_CLOSE));
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerEventListener
    public void onAdUserMinimize(IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        if (this.f8489e.get()) {
        }
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerEventListener
    public void onAdVideoComplete(IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        if (this.f8489e.get()) {
        }
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerEventListener
    public void onAdVideoFirstQuartile(IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        if (this.f8489e.get()) {
        }
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerEventListener
    public void onAdVideoMidpoint(IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        if (this.f8489e.get()) {
        }
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerEventListener
    public void onAdVideoStart(IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        if (this.f8489e.get()) {
        }
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerEventListener
    public void onAdVideoThirdQuartile(IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        if (this.f8489e.get()) {
        }
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerEventListener
    public void onAdVolumeChange(IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        if (this.f8489e.get()) {
        }
    }

    private void a(Context context, String str) {
        try {
            this.o = 0;
            Timer timer = new Timer();
            timer.schedule(new m(this, XAdSDKFoundationFacade.getInstance().getPackageUtils(), context, str, timer), 0L, 1000L);
        } catch (Exception unused) {
        }
    }

    public boolean a(HashMap<String, Object> hashMap, IXNonLinearAdSlot iXNonLinearAdSlot, IXAdResource iXAdResource, IXAdInstanceInfo iXAdInstanceInfo) {
        if (hashMap != null && hashMap.containsKey("lpShoubaiStyle") && hashMap.get("lpShoubaiStyle").equals("video_and_web")) {
            com.baidu.mobads.command.b.c cVar = new com.baidu.mobads.command.b.c(iXNonLinearAdSlot, iXAdInstanceInfo, iXAdResource, iXAdInstanceInfo.getWebUrl());
            cVar.f8198f = (String) hashMap.get("lpShoubaiStyle");
            cVar.f8199g = (String) hashMap.get("lpMurlStyle");
            cVar.a();
            return true;
        }
        return false;
    }

    private void a(Set<String> set) {
        com.baidu.mobads.openad.b.a aVar = new com.baidu.mobads.openad.b.a();
        for (String str : set) {
            com.baidu.mobads.openad.b.b bVar = new com.baidu.mobads.openad.b.b(str, "");
            bVar.f8413e = 1;
            aVar.a(bVar, Boolean.TRUE);
        }
    }
}
