package com.baidu.mobads.production;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.baidu.mobads.RsplashType;
import com.baidu.mobads.interfaces.IXAdContainer;
import com.baidu.mobads.interfaces.IXAdContainerContext;
import com.baidu.mobads.interfaces.IXAdContainerEventListener;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.IXAdResource;
import com.baidu.mobads.interfaces.IXNonLinearAdSlot;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.baidu.mobads.vo.XAdInstanceInfo;
import com.baidu.platform.comapi.UIMsg;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Timer;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class q implements IXAdContainerEventListener {

    /* renamed from: a  reason: collision with root package name */
    private Context f2427a;
    private final b b;
    private int g = 0;
    private int h = 2;
    private int i = 15;
    private int j = 0;
    private int k = 2;
    private int l = 15;
    private AtomicBoolean c = new AtomicBoolean(false);
    private AtomicBoolean d = new AtomicBoolean(false);
    private AtomicBoolean e = new AtomicBoolean(false);
    private AtomicBoolean f = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int d(q qVar) {
        int i = qVar.g;
        qVar.g = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int h(q qVar) {
        int i = qVar.j;
        qVar.j = i + 1;
        return i;
    }

    public q(Context context, b bVar) {
        this.f2427a = context;
        this.b = bVar;
    }

    private void a(Context context, String str, String str2) {
        try {
            this.g = 0;
            Timer timer = new Timer();
            timer.schedule(new r(this, XAdSDKFoundationFacade.getInstance().getPackageUtils(), context, str2, timer, str), 0L, 1000L);
        } catch (Exception e) {
        }
    }

    private void a(Context context, String str) {
        try {
            this.j = 0;
            Timer timer = new Timer();
            timer.schedule(new s(this, XAdSDKFoundationFacade.getInstance().getPackageUtils(), context, str, timer), 0L, 1000L);
        } catch (Exception e) {
        }
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerEventListener
    public void onAdClicked(IXAdContainer iXAdContainer, IXAdInstanceInfo iXAdInstanceInfo, Boolean bool, HashMap<String, Object> hashMap) {
        Boolean bool2;
        boolean z;
        JSONObject jSONObject;
        com.baidu.mobads.utils.e commonUtils = XAdSDKFoundationFacade.getInstance().getCommonUtils();
        com.baidu.mobads.utils.p pVar = (com.baidu.mobads.utils.p) XAdSDKFoundationFacade.getInstance().getSystemUtils();
        com.baidu.mobads.utils.h adConstants = XAdSDKFoundationFacade.getInstance().getAdConstants();
        com.baidu.mobads.utils.n packageUtils = XAdSDKFoundationFacade.getInstance().getPackageUtils();
        IXNonLinearAdSlot iXNonLinearAdSlot = this.b;
        IXAdResource adResource = iXAdContainer.getAdContainerContext().getAdResource();
        boolean z2 = false;
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
            try {
                jSONObject = new JSONObject(clickThroughUrl);
            } catch (Exception e) {
                try {
                    JSONObject jSONObject2 = new JSONObject(iXAdInstanceInfo.getAppOpenStrs());
                    com.baidu.mobads.openad.d.a aVar = new com.baidu.mobads.openad.d.a();
                    com.baidu.mobads.openad.d.c cVar = new com.baidu.mobads.openad.d.c(clickThroughUrl, "");
                    cVar.e = 1;
                    aVar.a(cVar, (Boolean) true);
                    jSONObject = jSONObject2;
                } catch (Exception e2) {
                    return;
                }
            }
            String optString = jSONObject.optString("page", "");
            if (packageUtils.sendAPOInfo(iXNonLinearAdSlot.getApplicationContext(), optString, iXAdInstanceInfo.getAppPackageName(), 366, jSONObject.optInt("fb_act", 0), jSONObject.optInt("version", 0))) {
                if (bool.booleanValue()) {
                    new com.baidu.mobads.command.b.a(iXNonLinearAdSlot, iXAdInstanceInfo, adResource, optString).a();
                }
            } else {
                int optInt = jSONObject.optInt("fb_act", 0);
                IXAdInstanceInfo xAdInstanceInfo = new XAdInstanceInfo(new JSONObject());
                if (optInt == adConstants.getActTypeLandingPage()) {
                    xAdInstanceInfo.setActionType(adConstants.getActTypeLandingPage());
                    xAdInstanceInfo.setClickThroughUrl(jSONObject.optString("fallback", ""));
                    xAdInstanceInfo.setTitle(iXAdInstanceInfo.getTitle());
                    xAdInstanceInfo.setInapp(true);
                    onAdClicked(iXAdContainer, xAdInstanceInfo, bool, hashMap);
                } else if (optInt == adConstants.getActTypeDownload()) {
                    xAdInstanceInfo.setActionType(adConstants.getActTypeDownload());
                    xAdInstanceInfo.setClickThroughUrl(jSONObject.optString("fallback", ""));
                    xAdInstanceInfo.setTitle(iXAdInstanceInfo.getTitle());
                    xAdInstanceInfo.setQueryKey(iXAdInstanceInfo.getQueryKey());
                    xAdInstanceInfo.setInapp(true);
                    xAdInstanceInfo.setAPOOpen(true);
                    xAdInstanceInfo.setPage(optString);
                    xAdInstanceInfo.setAppPackageName(iXAdInstanceInfo.getAppPackageName());
                    onAdClicked(iXAdContainer, xAdInstanceInfo, bool, hashMap);
                }
            }
            a(iXNonLinearAdSlot.getApplicationContext(), optString, iXAdInstanceInfo.getAppPackageName());
            bool2 = true;
        } else if (actionType == adConstants.getActTypeDownload()) {
            if (!a(hashMap, iXNonLinearAdSlot, adResource, iXAdInstanceInfo)) {
                if (!bool.booleanValue()) {
                    bool2 = false;
                } else {
                    commonUtils.sendDownloadAdLog(iXNonLinearAdSlot.getApplicationContext(), UIMsg.MsgDefine.MSG_MSG_CENTER, "click", iXNonLinearAdSlot.getProdInfo().getProdType(), iXAdInstanceInfo.getAppPackageName(), commonUtils.getAppId(iXNonLinearAdSlot.getApplicationContext()), iXNonLinearAdSlot.getProdInfo().getAdPlacementId(), pVar.getPhoneOSBrand(), Build.MODEL, Build.VERSION.RELEASE, Build.VERSION.SDK_INT);
                    new com.baidu.mobads.command.a.a(iXNonLinearAdSlot, iXAdInstanceInfo, adResource).a();
                    bool2 = false;
                }
            }
            bool2 = z2;
        } else if (actionType == adConstants.getActTypeLandingPage() || actionType == adConstants.getActTypeOpenMap()) {
            if (this.b.getProdInfo().getProdType() == adConstants.getProductionTypeSplash()) {
                bool2 = false;
            } else {
                bool2 = true;
            }
            if (bool.booleanValue()) {
                if (iXAdInstanceInfo.isInapp()) {
                    if (!a(hashMap, iXNonLinearAdSlot, adResource, iXAdInstanceInfo)) {
                        com.baidu.mobads.command.c.a aVar2 = new com.baidu.mobads.command.c.a(iXNonLinearAdSlot, iXAdInstanceInfo, adResource, clickThroughUrl);
                        if (hashMap != null && hashMap.containsKey("lpShoubaiStyle")) {
                            aVar2.f = (String) hashMap.get("lpShoubaiStyle");
                        }
                        aVar2.a();
                    }
                } else {
                    commonUtils.browserOutside(iXAdContainer.getAdContainerContext().getApplicationContext(), clickThroughUrl);
                }
            }
        } else if (actionType == adConstants.getActTypeMakeCall() || actionType == adConstants.getActTypeSendSMS() || actionType == adConstants.getActTypeSendMail()) {
            z2 = true;
            if (bool.booleanValue()) {
                new com.baidu.mobads.command.b.a(iXNonLinearAdSlot, iXAdInstanceInfo, adResource, clickThroughUrl).a();
            }
            if (actionType == adConstants.getActTypeMakeCall()) {
                PackageManager packageManager = iXNonLinearAdSlot.getApplicationContext().getPackageManager();
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(clickThroughUrl));
                List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 64);
                if (queryIntentActivities != null && queryIntentActivities.size() > 0) {
                    int i3 = 0;
                    String str = null;
                    while (true) {
                        int i4 = i3;
                        if (i4 >= queryIntentActivities.size()) {
                            z = true;
                            break;
                        } else if (i4 >= 1 && !str.equals(queryIntentActivities.get(i4).activityInfo.processName)) {
                            z = false;
                            break;
                        } else {
                            str = queryIntentActivities.get(i4).activityInfo.processName;
                            i3 = i4 + 1;
                        }
                    }
                    if (z) {
                        a(iXNonLinearAdSlot.getApplicationContext(), str);
                    }
                }
                bool2 = true;
            }
            bool2 = z2;
        } else if (actionType == adConstants.getActTypeNothing2Do()) {
            bool2 = false;
        } else {
            if (actionType == adConstants.getActTypeRichMedia()) {
            }
            bool2 = z2;
        }
        if (bool2.booleanValue()) {
            this.b.dispatchEvent(new com.baidu.mobads.f.a(IXAdEvent.AD_CLICK_THRU));
        }
        this.b.dispatchEvent(new com.baidu.mobads.f.a("AdUserClick"));
    }

    public boolean a(HashMap<String, Object> hashMap, IXNonLinearAdSlot iXNonLinearAdSlot, IXAdResource iXAdResource, IXAdInstanceInfo iXAdInstanceInfo) {
        if (hashMap != null && hashMap.containsKey("lpShoubaiStyle") && hashMap.get("lpShoubaiStyle").equals("video_and_web")) {
            com.baidu.mobads.command.c.a aVar = new com.baidu.mobads.command.c.a(iXNonLinearAdSlot, iXAdInstanceInfo, iXAdResource, iXAdInstanceInfo.getWebUrl());
            aVar.f = (String) hashMap.get("lpShoubaiStyle");
            aVar.a();
            return true;
        }
        return false;
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerEventListener
    public void onAdLoaded(IXAdContainer iXAdContainer, IXAdInstanceInfo iXAdInstanceInfo, Boolean bool, HashMap<String, Object> hashMap) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.b.a(iXAdContainer, hashMap);
        } else {
            new Handler(this.f2427a.getMainLooper()).post(new t(this, iXAdContainer, hashMap));
        }
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerEventListener
    public void onAdStarted(IXAdContainer iXAdContainer, IXAdInstanceInfo iXAdInstanceInfo, Boolean bool, HashMap<String, Object> hashMap) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.b.b(iXAdContainer, hashMap);
        } else {
            new Handler(this.f2427a.getMainLooper()).post(new u(this, iXAdContainer, hashMap));
        }
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerEventListener
    public void onAdImpression(IXAdContainer iXAdContainer, IXAdInstanceInfo iXAdInstanceInfo, Boolean bool, HashMap<String, Object> hashMap) {
        a(iXAdInstanceInfo.getImpressionUrls());
        this.b.dispatchEvent(new com.baidu.mobads.f.a(IXAdEvent.AD_IMPRESSION));
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
            this.b.a(adContainerContext.getAdResponseInfo(), adContainerContext.getAdInstanceInfo());
            return;
        }
        this.b.e(iXAdContainer, hashMap);
        this.b.dispatchEvent(new com.baidu.mobads.f.a(IXAdEvent.AD_STOPPED));
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerEventListener
    public void onAdError(IXAdContainer iXAdContainer, IXAdInstanceInfo iXAdInstanceInfo, Boolean bool, HashMap<String, Object> hashMap) {
        if (!this.e.get()) {
            if (hashMap != null) {
                com.baidu.mobads.utils.h adConstants = XAdSDKFoundationFacade.getInstance().getAdConstants();
                com.baidu.mobads.c.a.a().a(hashMap.get(adConstants.getInfoKeyErrorCode()) + "," + hashMap.get(adConstants.getInfoKeyErrorMessage()) + "," + hashMap.get(adConstants.getInfoKeyErrorModule()));
            }
            this.e.set(true);
            this.b.dispatchEvent(new com.baidu.mobads.f.a(IXAdEvent.AD_ERROR, hashMap));
        }
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerEventListener
    public void onAdPlaying(IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        this.b.dispatchEvent(new com.baidu.mobads.f.a(IXAdEvent.AD_PLAYING));
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerEventListener
    public void onAdPaused(IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        this.b.dispatchEvent(new com.baidu.mobads.f.a(IXAdEvent.AD_PAUSED));
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
        this.b.dispatchEvent(new com.baidu.mobads.f.a(IXAdEvent.AD_USER_CLOSE));
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
        if (str.equals("onrsplashadtypeready") && this.b.getCurrentAdInstance().getVideoDuration() == 0 && hashMap != null) {
            hashMap.put(com.baidu.mobads.a.a.s, RsplashType.VIDEO);
            this.b.dispatchEvent(new com.baidu.mobads.f.a("AdTypeReady", hashMap));
        }
    }

    private void a(Set<String> set) {
        com.baidu.mobads.openad.d.a aVar = new com.baidu.mobads.openad.d.a();
        for (String str : set) {
            com.baidu.mobads.openad.d.c cVar = new com.baidu.mobads.openad.d.c(str, "");
            cVar.e = 1;
            aVar.a(cVar, (Boolean) true);
        }
    }
}
