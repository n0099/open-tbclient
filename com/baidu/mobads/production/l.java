package com.baidu.mobads.production;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Timer;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public class l implements IXAdContainerEventListener {

    /* renamed from: a  reason: collision with root package name */
    private Context f3464a;

    /* renamed from: b  reason: collision with root package name */
    private final a f3465b;
    private IXAdContainer g;
    private IXAdInstanceInfo h;
    private com.baidu.mobads.utils.h i;
    private t j;
    private IXAdResource k;
    private int l = 0;
    private int m = 2;
    private int n = 15;
    private int o = 0;
    private int p = 2;
    private int q = 15;
    private AtomicBoolean c = new AtomicBoolean(false);
    private AtomicBoolean d = new AtomicBoolean(false);
    private AtomicBoolean e = new AtomicBoolean(false);
    private AtomicBoolean f = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int d(l lVar) {
        int i = lVar.o;
        lVar.o = i + 1;
        return i;
    }

    public l(Context context, a aVar) {
        this.f3464a = context;
        this.f3465b = aVar;
    }

    private void a(Context context, String str) {
        try {
            this.o = 0;
            Timer timer = new Timer();
            timer.schedule(new m(this, XAdSDKFoundationFacade.getInstance().getPackageUtils(), context, str, timer), 0L, 1000L);
        } catch (Exception e) {
        }
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerEventListener
    public void onAdClicked(IXAdContainer iXAdContainer, IXAdInstanceInfo iXAdInstanceInfo, Boolean bool, HashMap<String, Object> hashMap) {
        boolean z;
        boolean z2;
        this.i = XAdSDKFoundationFacade.getInstance().getCommonUtils();
        this.j = (t) XAdSDKFoundationFacade.getInstance().getSystemUtils();
        com.baidu.mobads.utils.l adConstants = XAdSDKFoundationFacade.getInstance().getAdConstants();
        IXNonLinearAdSlot iXNonLinearAdSlot = this.f3465b;
        this.g = iXAdContainer;
        this.h = iXAdInstanceInfo;
        this.k = iXAdContainer.getAdContainerContext().getAdResource();
        String clickThroughUrl = iXAdInstanceInfo.getClickThroughUrl();
        int actionType = iXAdInstanceInfo.getActionType();
        ArrayList arrayList = new ArrayList();
        List<String> thirdClickTrackingUrls = iXAdInstanceInfo.getThirdClickTrackingUrls();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= thirdClickTrackingUrls.size()) {
                break;
            }
            arrayList.add(thirdClickTrackingUrls.get(i2).replaceAll("\\$\\{PROGRESS\\}", String.valueOf((int) iXAdContainer.getPlayheadTime())));
            i = i2 + 1;
        }
        Set<String> hashSet = new HashSet<>();
        hashSet.addAll(arrayList);
        a(hashSet);
        if (actionType == adConstants.getActTypeOpenExternalApp()) {
            z = true;
            q.a().i("XAdContainerEventListener", "APO in proxy: " + iXAdInstanceInfo.getAppName());
        } else if (actionType == adConstants.getActTypeDownload()) {
            if (!a(hashMap, iXNonLinearAdSlot, this.k, iXAdInstanceInfo)) {
                z = false;
                q.a().i("XAdContainerEventListener", "download apk in proxy: " + iXAdInstanceInfo.getAppName());
            }
            z = false;
        } else if (actionType == adConstants.getActTypeLandingPage() || actionType == adConstants.getActTypeOpenMap()) {
            if (this.f3465b.getProdInfo().getProdType() == adConstants.getProductionTypeSplash()) {
                z = false;
            } else {
                z = true;
            }
            if (bool.booleanValue()) {
                if (iXAdInstanceInfo.isInapp()) {
                    if (!a(hashMap, iXNonLinearAdSlot, this.k, iXAdInstanceInfo)) {
                        com.baidu.mobads.command.b.c cVar = new com.baidu.mobads.command.b.c(iXNonLinearAdSlot, iXAdInstanceInfo, this.k, clickThroughUrl);
                        if (hashMap != null && hashMap.containsKey("lpShoubaiStyle")) {
                            cVar.f = (String) hashMap.get("lpShoubaiStyle");
                        }
                        cVar.a();
                    }
                } else {
                    this.i.browserOutside(iXAdContainer.getAdContainerContext().getApplicationContext(), clickThroughUrl);
                }
            }
        } else if (actionType == adConstants.getActTypeMakeCall() || actionType == adConstants.getActTypeSendSMS() || actionType == adConstants.getActTypeSendMail()) {
            if (bool.booleanValue()) {
                new com.baidu.mobads.command.a.a(iXNonLinearAdSlot, iXAdInstanceInfo, this.k, clickThroughUrl).a();
            }
            if (actionType != adConstants.getActTypeMakeCall()) {
                z = true;
            } else {
                PackageManager packageManager = iXNonLinearAdSlot.getApplicationContext().getPackageManager();
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(clickThroughUrl));
                List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 64);
                if (queryIntentActivities != null && queryIntentActivities.size() > 0) {
                    String str = null;
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 >= queryIntentActivities.size()) {
                            z2 = true;
                            break;
                        } else if (i4 >= 1 && str != null && !str.equals(queryIntentActivities.get(i4).activityInfo.processName)) {
                            z2 = false;
                            break;
                        } else {
                            str = queryIntentActivities.get(i4).activityInfo.processName;
                            i3 = i4 + 1;
                        }
                    }
                    if (z2) {
                        a(iXNonLinearAdSlot.getApplicationContext(), str);
                    }
                }
                z = true;
            }
        } else if (actionType == adConstants.getActTypeNothing2Do()) {
            z = false;
        } else {
            if (actionType == adConstants.getActTypeRichMedia()) {
            }
            z = false;
        }
        if (z) {
            this.f3465b.dispatchEvent(new com.baidu.mobads.e.a(IXAdEvent.AD_CLICK_THRU));
        }
        com.baidu.mobads.e.a aVar = new com.baidu.mobads.e.a("AdUserClick");
        aVar.a(iXAdInstanceInfo);
        aVar.getData().put("actionType", Integer.valueOf(iXAdInstanceInfo.getActionType()));
        this.f3465b.dispatchEvent(aVar);
    }

    public boolean a(HashMap<String, Object> hashMap, IXNonLinearAdSlot iXNonLinearAdSlot, IXAdResource iXAdResource, IXAdInstanceInfo iXAdInstanceInfo) {
        if (hashMap != null && hashMap.containsKey("lpShoubaiStyle") && hashMap.get("lpShoubaiStyle").equals("video_and_web")) {
            com.baidu.mobads.command.b.c cVar = new com.baidu.mobads.command.b.c(iXNonLinearAdSlot, iXAdInstanceInfo, iXAdResource, iXAdInstanceInfo.getWebUrl());
            cVar.f = (String) hashMap.get("lpShoubaiStyle");
            cVar.g = (String) hashMap.get("lpMurlStyle");
            cVar.a();
            return true;
        }
        return false;
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerEventListener
    public void onAdLoaded(IXAdContainer iXAdContainer, IXAdInstanceInfo iXAdInstanceInfo, Boolean bool, HashMap<String, Object> hashMap) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.f3465b.c(iXAdContainer, hashMap);
        } else {
            new Handler(this.f3464a.getMainLooper()).post(new n(this, iXAdContainer, hashMap));
        }
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerEventListener
    public void onAdStarted(IXAdContainer iXAdContainer, IXAdInstanceInfo iXAdInstanceInfo, Boolean bool, HashMap<String, Object> hashMap) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.f3465b.d(iXAdContainer, hashMap);
        } else {
            new Handler(this.f3464a.getMainLooper()).post(new o(this, iXAdContainer, hashMap));
        }
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerEventListener
    public void onAdImpression(IXAdContainer iXAdContainer, IXAdInstanceInfo iXAdInstanceInfo, Boolean bool, HashMap<String, Object> hashMap) {
        a(iXAdInstanceInfo.getImpressionUrls());
        com.baidu.mobads.e.a aVar = new com.baidu.mobads.e.a(IXAdEvent.AD_IMPRESSION);
        aVar.a(iXAdInstanceInfo);
        this.f3465b.dispatchEvent(aVar);
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
            this.f3465b.a(adContainerContext.getAdResponseInfo(), adContainerContext.getAdInstanceInfo());
            return;
        }
        this.f3465b.e(iXAdContainer, hashMap);
        this.f3465b.dispatchEvent(new com.baidu.mobads.e.a(IXAdEvent.AD_STOPPED, hashMap));
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerEventListener
    public void onAdError(IXAdContainer iXAdContainer, IXAdInstanceInfo iXAdInstanceInfo, Boolean bool, HashMap<String, Object> hashMap) {
        if (!this.e.get()) {
            this.e.set(true);
            this.f3465b.dispatchEvent(new com.baidu.mobads.e.a(IXAdEvent.AD_ERROR, hashMap));
        }
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerEventListener
    public void onAdPlaying(IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        this.f3465b.dispatchEvent(new com.baidu.mobads.e.a(IXAdEvent.AD_PLAYING));
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerEventListener
    public void onAdPaused(IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        this.f3465b.dispatchEvent(new com.baidu.mobads.e.a(IXAdEvent.AD_PAUSED));
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerEventListener
    public void onAdLinearChange(IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        if (this.e.get()) {
        }
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerEventListener
    public void onAdExpandedChange(IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        if (this.e.get()) {
        }
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerEventListener
    public void onAdUserClosed(IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        this.f3465b.dispatchEvent(new com.baidu.mobads.e.a(IXAdEvent.AD_USER_CLOSE));
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerEventListener
    public void onAdDurationChange(IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        if (this.e.get()) {
        }
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerEventListener
    public void onAdRemainingTimeChange(IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        if (this.e.get()) {
        }
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerEventListener
    public void onAdVolumeChange(IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        if (this.e.get()) {
        }
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerEventListener
    public void onAdSizeChange(IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        if (this.e.get()) {
        }
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerEventListener
    public void onAdSkippableStateChange(IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        if (this.e.get()) {
        }
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerEventListener
    public void onAdSkipped(IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        if (this.e.get()) {
        }
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerEventListener
    public void onAdInteraction(IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        if (this.e.get()) {
        }
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerEventListener
    public void onAdUserAcceptInvitation(IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        if (this.e.get()) {
        }
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerEventListener
    public void onAdUserMinimize(IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        if (this.e.get()) {
        }
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerEventListener
    public void onAdVideoStart(IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        if (this.e.get()) {
        }
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerEventListener
    public void onAdVideoFirstQuartile(IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        if (this.e.get()) {
        }
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerEventListener
    public void onAdVideoMidpoint(IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        if (this.e.get()) {
        }
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerEventListener
    public void onAdVideoThirdQuartile(IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        if (this.e.get()) {
        }
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerEventListener
    public void onAdVideoComplete(IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        if (this.e.get()) {
        }
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerEventListener
    public void onAdCustomEvent(String str, IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        if (str.equals("onrvideocachesucc")) {
            this.f3465b.dispatchEvent(new com.baidu.mobads.e.a("AdRvdieoCacheSucc", hashMap));
        } else if (str.equals("onrvideocachefailed")) {
            this.f3465b.dispatchEvent(new com.baidu.mobads.e.a("AdRvdieoCacheFailed", hashMap));
        } else if (str.equals("playCompletion")) {
            this.f3465b.dispatchEvent(new com.baidu.mobads.e.a("PlayCompletion", hashMap));
        } else if (str.equals("AdRvdieoPlayError")) {
            this.f3465b.dispatchEvent(new com.baidu.mobads.e.a("AdRvdieoPlayError", hashMap));
        } else if (str.equals("AdVideoSkip")) {
            this.f3465b.dispatchEvent(new com.baidu.mobads.e.a("AdVideoSkip", hashMap));
        } else if (str.equals("AdStatusChange")) {
            this.f3465b.dispatchEvent(new com.baidu.mobads.e.a("AdStatusChange", hashMap));
        }
    }

    private void a(Set<String> set) {
        com.baidu.mobads.openad.b.a aVar = new com.baidu.mobads.openad.b.a();
        for (String str : set) {
            com.baidu.mobads.openad.b.b bVar = new com.baidu.mobads.openad.b.b(str, "");
            bVar.e = 1;
            aVar.a(bVar, (Boolean) true);
        }
    }
}
