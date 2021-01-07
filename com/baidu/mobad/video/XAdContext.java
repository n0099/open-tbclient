package com.baidu.mobad.video;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.widget.RelativeLayout;
import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.interfaces.IXAdContext;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.IXAdInternalConstants;
import com.baidu.mobads.interfaces.IXAdManager;
import com.baidu.mobads.interfaces.IXAdProd;
import com.baidu.mobads.interfaces.IXLinearAdSlot;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.interfaces.utils.IXAdURIUitls;
import com.baidu.mobads.openad.c.b;
import com.baidu.mobads.openad.c.c;
import com.baidu.mobads.openad.d.a;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventDispatcher;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes3.dex */
public class XAdContext implements IXAdContext {
    public static final String PARAMETER_KEY_OF_BASE_HEIGHT = "BASE_HEIGHT";
    public static final String PARAMETER_KEY_OF_BASE_WIDTH = "BASE_WIDTH";
    public static final String TAG = "XAdContext";
    private IXAdConstants4PDK.VisitorAction g;
    private double h;
    private int i;
    private int j;
    private Context k;
    private String l;
    private Location m;
    private Activity n;
    private RelativeLayout o;
    private HashMap<String, Object> c = new HashMap<>();
    private IXAdConstants4PDK.ScreenSizeMode d = IXAdConstants4PDK.ScreenSizeMode.FULL_SCREEN;
    private IXAdConstants4PDK.VideoState e = IXAdConstants4PDK.VideoState.IDLE;
    private IXAdConstants4PDK.ActivityState f = IXAdConstants4PDK.ActivityState.CREATE;

    /* renamed from: a  reason: collision with root package name */
    int f3277a = 0;

    /* renamed from: b  reason: collision with root package name */
    int f3278b = 0;
    private final IOAdEventDispatcher p = new c();
    private final XAdSlotManager q = new XAdSlotManager();
    protected IXAdLogger mAdLogger = XAdSDKFoundationFacade.getInstance().getAdLogger();

    public XAdContext(Context context, String str, Location location) {
        this.k = context;
        this.l = str;
        this.m = location;
    }

    @Override // com.baidu.mobads.interfaces.IXAdContext
    public void setVideoDisplayBase(RelativeLayout relativeLayout) {
        this.o = relativeLayout;
        setActivity((Activity) this.o.getContext());
        new Handler(getActivity().getMainLooper()).post(new Runnable() { // from class: com.baidu.mobad.video.XAdContext.1
            @Override // java.lang.Runnable
            public void run() {
                IXLinearAdSlot retrievePrerollAdSlot = XAdContext.this.q.retrievePrerollAdSlot();
                if (retrievePrerollAdSlot != null && retrievePrerollAdSlot.getSlotState() == IXAdConstants4PDK.SlotState.PLAYING) {
                    retrievePrerollAdSlot.resize();
                }
            }
        });
    }

    @Override // com.baidu.mobads.interfaces.IXAdContext
    public void setActivity(Activity activity) {
        if (activity != null && this.n == null) {
            this.n = activity;
            if (this.k == null) {
                this.k = this.n.getApplicationContext();
            }
        }
    }

    @Override // com.baidu.mobads.interfaces.IXAdContext
    public Activity getActivity() {
        return this.n;
    }

    @Override // com.baidu.mobads.interfaces.IXAdContext
    public void setActivityState(IXAdConstants4PDK.ActivityState activityState) {
        this.f = activityState;
        this.mAdLogger.i(TAG, activityState.getValue());
        IXLinearAdSlot retrievePrerollAdSlot = this.q.retrievePrerollAdSlot();
        if (retrievePrerollAdSlot != null) {
            if (activityState == IXAdConstants4PDK.ActivityState.PAUSE) {
                retrievePrerollAdSlot.pause();
            }
            if (activityState == IXAdConstants4PDK.ActivityState.RESUME) {
                retrievePrerollAdSlot.resume();
            }
        }
    }

    @Override // com.baidu.mobads.interfaces.IXAdContext
    public void setParameter(String str, Object obj) {
        this.c.put(str, obj);
    }

    @Override // com.baidu.mobads.interfaces.IXAdContext
    public Object getParameter(String str) {
        return this.c.get(str);
    }

    @Override // com.baidu.mobads.interfaces.IXAdContext
    public void setContentVideoScreenMode(IXAdConstants4PDK.ScreenSizeMode screenSizeMode) {
        IXAdInstanceInfo currentAdInstance;
        this.d = screenSizeMode;
        IXLinearAdSlot retrievePrerollAdSlot = this.q.retrievePrerollAdSlot();
        if (this.d == IXAdConstants4PDK.ScreenSizeMode.FULL_SCREEN && retrievePrerollAdSlot != null && retrievePrerollAdSlot.getSlotState() == IXAdConstants4PDK.SlotState.PLAYING && (currentAdInstance = retrievePrerollAdSlot.getCurrentAdInstance()) != null) {
            int playheadTime = (int) retrievePrerollAdSlot.getCurrentXAdContainer().getPlayheadTime();
            IXAdURIUitls uRIUitls = XAdSDKFoundationFacade.getInstance().getURIUitls();
            ArrayList arrayList = new ArrayList();
            List<String> fullScreenTrackers = currentAdInstance.getFullScreenTrackers();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < fullScreenTrackers.size()) {
                    arrayList.add(uRIUitls.addParameter(fullScreenTrackers.get(i2), "progress", "" + playheadTime));
                    i = i2 + 1;
                } else {
                    currentAdInstance.setFullScreenTrackers(arrayList);
                    HashSet hashSet = new HashSet();
                    hashSet.addAll(currentAdInstance.getFullScreenTrackers());
                    a(hashSet);
                    return;
                }
            }
        }
    }

    private void a(Set<String> set) {
        a aVar = new a();
        for (String str : set) {
            com.baidu.mobads.openad.d.c cVar = new com.baidu.mobads.openad.d.c(str, "");
            cVar.e = 1;
            aVar.a(cVar, (Boolean) true);
        }
    }

    @Override // com.baidu.mobads.interfaces.IXAdContext
    public void setContentVideoState(IXAdConstants4PDK.VideoState videoState) {
        this.e = videoState;
    }

    @Override // com.baidu.mobads.interfaces.IXAdContext
    public void setContentVideoPlayheadTime(double d) {
        this.h = d;
    }

    @Override // com.baidu.mobads.interfaces.IXAdContext
    public void setAdServerRequestingTimeout(int i) {
        this.i = i;
    }

    @Override // com.baidu.mobads.interfaces.IXAdContext
    public void setAdCreativeLoadingTimeout(int i) {
        this.j = i;
    }

    @Override // com.baidu.mobads.interfaces.IXAdContext
    public void submitRequest() {
        IXLinearAdSlot retrievePrerollAdSlot = this.q.retrievePrerollAdSlot();
        if (this.i > 0 && this.j > 0) {
            HashMap<String, String> parameter = retrievePrerollAdSlot.getParameter();
            parameter.put(IXAdInternalConstants.PARAMETER_KEY_OF_AD_REQUESTING_TIMEOUT, "" + this.i);
            parameter.put(IXAdInternalConstants.PARAMETER_KEY_OF_AD_CREATIVE_LOADING_TIMEOUT, "" + this.j);
            parameter.put(PARAMETER_KEY_OF_BASE_WIDTH, "" + this.f3277a);
            parameter.put(PARAMETER_KEY_OF_BASE_HEIGHT, "" + this.f3278b);
            retrievePrerollAdSlot.setParameter(parameter);
        }
        retrievePrerollAdSlot.request();
    }

    /* loaded from: classes3.dex */
    public static class AdSlotEventListener implements IOAdEventListener {
        public static final String TAG = "AdSlotEventListener";

        /* renamed from: a  reason: collision with root package name */
        private final Context f3280a;

        /* renamed from: b  reason: collision with root package name */
        private final IXAdProd f3281b;
        private final IOAdEventDispatcher c;

        public AdSlotEventListener(Context context, IXAdProd iXAdProd, IOAdEventDispatcher iOAdEventDispatcher) {
            this.f3280a = context;
            this.f3281b = iXAdProd;
            this.c = iOAdEventDispatcher;
        }

        @Override // com.baidu.mobads.openad.interfaces.event.IOAdEventListener
        public void run(final IOAdEvent iOAdEvent) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().i(TAG, iOAdEvent.getType());
            XAdSDKFoundationFacade.getInstance().getCommonUtils().a(new Runnable() { // from class: com.baidu.mobad.video.XAdContext.AdSlotEventListener.1
                @Override // java.lang.Runnable
                public void run() {
                    if (iOAdEvent.getType().equals(b.COMPLETE)) {
                        AdSlotEventListener.this.c.dispatchEvent(new XAdEvent4PDK(IXAdConstants4PDK.EVENT_REQUEST_COMPLETE, AdSlotEventListener.this.f3281b));
                    }
                    if (iOAdEvent.getType().equals(IXAdEvent.AD_STARTED)) {
                        if (AdSlotEventListener.this.f3281b.getProdBase() != null) {
                            AdSlotEventListener.this.f3281b.getProdBase().setVisibility(0);
                        }
                        AdSlotEventListener.this.c.dispatchEvent(new XAdEvent4PDK(IXAdConstants4PDK.EVENT_SLOT_STARTED, AdSlotEventListener.this.f3281b));
                    }
                    if (iOAdEvent.getType().equals("AdUserClick")) {
                        AdSlotEventListener.this.c.dispatchEvent(new XAdEvent4PDK(IXAdConstants4PDK.EVENT_SLOT_CLICKED, AdSlotEventListener.this.f3281b));
                    }
                    if (iOAdEvent.getType().equals(IXAdEvent.AD_STOPPED)) {
                        if (AdSlotEventListener.this.f3281b.getProdBase() != null) {
                            AdSlotEventListener.this.f3281b.getProdBase().setVisibility(4);
                        }
                        AdSlotEventListener.this.c.dispatchEvent(new XAdEvent4PDK(IXAdConstants4PDK.EVENT_SLOT_ENDED, AdSlotEventListener.this.f3281b));
                    }
                    if (iOAdEvent.getType().equals(IXAdEvent.AD_ERROR)) {
                        if (AdSlotEventListener.this.f3281b.getProdBase() != null) {
                            AdSlotEventListener.this.f3281b.getProdBase().setVisibility(4);
                        }
                        AdSlotEventListener.this.c.dispatchEvent(new XAdEvent4PDK(IXAdConstants4PDK.EVENT_ERROR, AdSlotEventListener.this.f3281b));
                    }
                }
            });
        }
    }

    @Override // com.baidu.mobads.interfaces.IXAdContext
    public IXLinearAdSlot newPrerollAdSlot(String str, int i, int i2) {
        if (!this.q.containsAdSlot(str).booleanValue()) {
            com.baidu.mobads.production.h.b bVar = new com.baidu.mobads.production.h.b(this.n, str);
            bVar.setActivity(this.n);
            bVar.setAdSlotBase(this.o);
            bVar.setId(str);
            AdSlotEventListener adSlotEventListener = new AdSlotEventListener(this.k, bVar, this.p);
            bVar.removeAllListeners();
            bVar.addEventListener(b.COMPLETE, adSlotEventListener);
            bVar.addEventListener(IXAdEvent.AD_STARTED, adSlotEventListener);
            bVar.addEventListener(IXAdEvent.AD_STOPPED, adSlotEventListener);
            bVar.addEventListener(IXAdEvent.AD_ERROR, adSlotEventListener);
            bVar.addEventListener("AdUserClick", adSlotEventListener);
            this.q.addAdSlot(bVar);
        }
        return this.q.retrievePrerollAdSlot();
    }

    @Override // com.baidu.mobads.interfaces.IXAdContext
    public IXAdProd getSlotById(String str) {
        return this.q.retrieveAdSlotById(str);
    }

    @Override // com.baidu.mobads.interfaces.IXAdContext
    public void addEventListener(String str, IOAdEventListener iOAdEventListener) {
        this.p.addEventListener(str, iOAdEventListener);
    }

    @Override // com.baidu.mobads.interfaces.IXAdContext
    public void removeEventListener(String str, IOAdEventListener iOAdEventListener) {
        this.p.removeEventListener(str, iOAdEventListener);
    }

    @Override // com.baidu.mobads.interfaces.IXAdContext
    public void dispatchEvent(IOAdEvent iOAdEvent) {
    }

    @Override // com.baidu.mobads.interfaces.IXAdContext
    public IXAdManager getXAdManager() {
        return null;
    }

    @Override // com.baidu.mobads.interfaces.IXAdContext
    public void notifyVisitorAction(IXAdConstants4PDK.VisitorAction visitorAction) {
        this.g = visitorAction;
    }

    @Override // com.baidu.mobads.interfaces.IXAdContext
    public void dispose() {
    }

    @Override // com.baidu.mobads.interfaces.IXAdContext
    public void setVideoDisplayBaseWidth(int i) {
        this.f3277a = i;
    }

    @Override // com.baidu.mobads.interfaces.IXAdContext
    public void setVideoDisplayBaseHeight(int i) {
        this.f3278b = i;
    }

    public void setSupportTipView(boolean z) {
        this.q.retrievePrerollAdSlot().setSupportTipView(z);
    }
}
