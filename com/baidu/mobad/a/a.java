package com.baidu.mobad.a;

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
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventDispatcher;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes10.dex */
public class a implements IXAdContext {
    private Activity aOA;
    private IXAdConstants4PDK.VisitorAction aOy;
    private Location aOz;
    private double h;
    private int i;
    private int j;
    private Context k;
    private String l;
    private RelativeLayout o;
    private HashMap<String, Object> c = new HashMap<>();
    private IXAdConstants4PDK.ScreenSizeMode aOv = IXAdConstants4PDK.ScreenSizeMode.FULL_SCREEN;
    private IXAdConstants4PDK.VideoState aOw = IXAdConstants4PDK.VideoState.IDLE;
    private IXAdConstants4PDK.ActivityState aOx = IXAdConstants4PDK.ActivityState.CREATE;
    int a = 0;
    int b = 0;
    private final IOAdEventDispatcher aOB = new com.baidu.mobads.openad.c.c();
    private final f aOC = new f();
    protected IXAdLogger aOu = XAdSDKFoundationFacade.getInstance().getAdLogger();

    public a(Context context, String str, Location location) {
        this.k = context;
        this.l = str;
        this.aOz = location;
    }

    @Override // com.baidu.mobads.interfaces.IXAdContext
    public void setVideoDisplayBase(RelativeLayout relativeLayout) {
        this.o = relativeLayout;
        setActivity((Activity) this.o.getContext());
        new Handler(getActivity().getMainLooper()).post(new b(this));
    }

    @Override // com.baidu.mobads.interfaces.IXAdContext
    public void setActivity(Activity activity) {
        if (activity != null && this.aOA == null) {
            this.aOA = activity;
            if (this.k == null) {
                this.k = this.aOA.getApplicationContext();
            }
        }
    }

    @Override // com.baidu.mobads.interfaces.IXAdContext
    public Activity getActivity() {
        return this.aOA;
    }

    @Override // com.baidu.mobads.interfaces.IXAdContext
    public void setActivityState(IXAdConstants4PDK.ActivityState activityState) {
        this.aOx = activityState;
        this.aOu.i("XAdContext", activityState.getValue());
        IXLinearAdSlot El = this.aOC.El();
        if (El != null) {
            if (activityState == IXAdConstants4PDK.ActivityState.PAUSE) {
                El.pause();
            }
            if (activityState == IXAdConstants4PDK.ActivityState.RESUME) {
                El.resume();
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
        this.aOv = screenSizeMode;
        IXLinearAdSlot El = this.aOC.El();
        if (this.aOv == IXAdConstants4PDK.ScreenSizeMode.FULL_SCREEN && El != null && El.getSlotState() == IXAdConstants4PDK.SlotState.PLAYING && (currentAdInstance = El.getCurrentAdInstance()) != null) {
            int playheadTime = (int) El.getCurrentXAdContainer().getPlayheadTime();
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
        com.baidu.mobads.openad.d.a aVar = new com.baidu.mobads.openad.d.a();
        for (String str : set) {
            com.baidu.mobads.openad.d.c cVar = new com.baidu.mobads.openad.d.c(str, "");
            cVar.e = 1;
            aVar.a(cVar, (Boolean) true);
        }
    }

    @Override // com.baidu.mobads.interfaces.IXAdContext
    public void setContentVideoState(IXAdConstants4PDK.VideoState videoState) {
        this.aOw = videoState;
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
        IXLinearAdSlot El = this.aOC.El();
        if (this.i > 0 && this.j > 0) {
            HashMap<String, String> parameter = El.getParameter();
            parameter.put(IXAdInternalConstants.PARAMETER_KEY_OF_AD_REQUESTING_TIMEOUT, "" + this.i);
            parameter.put(IXAdInternalConstants.PARAMETER_KEY_OF_AD_CREATIVE_LOADING_TIMEOUT, "" + this.j);
            parameter.put("BASE_WIDTH", "" + this.a);
            parameter.put("BASE_HEIGHT", "" + this.b);
            El.setParameter(parameter);
        }
        El.request();
    }

    /* renamed from: com.baidu.mobad.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0129a implements IOAdEventListener {
        private final Context a;
        private final IXAdProd aOE;
        private final IOAdEventDispatcher aOF;

        public C0129a(Context context, IXAdProd iXAdProd, IOAdEventDispatcher iOAdEventDispatcher) {
            this.a = context;
            this.aOE = iXAdProd;
            this.aOF = iOAdEventDispatcher;
        }

        @Override // com.baidu.mobads.openad.interfaces.event.IOAdEventListener
        public void run(IOAdEvent iOAdEvent) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().i("AdSlotEventListener", iOAdEvent.getType());
            XAdSDKFoundationFacade.getInstance().getCommonUtils().a((Runnable) new c(this, iOAdEvent));
        }
    }

    @Override // com.baidu.mobads.interfaces.IXAdContext
    public IXLinearAdSlot newPrerollAdSlot(String str, int i, int i2) {
        if (!this.aOC.eF(str).booleanValue()) {
            com.baidu.mobads.production.h.b bVar = new com.baidu.mobads.production.h.b(this.aOA, str);
            bVar.setActivity(this.aOA);
            bVar.setAdSlotBase(this.o);
            bVar.setId(str);
            C0129a c0129a = new C0129a(this.k, bVar, this.aOB);
            bVar.removeAllListeners();
            bVar.addEventListener(com.baidu.mobads.openad.c.b.COMPLETE, c0129a);
            bVar.addEventListener(IXAdEvent.AD_STARTED, c0129a);
            bVar.addEventListener(IXAdEvent.AD_STOPPED, c0129a);
            bVar.addEventListener(IXAdEvent.AD_ERROR, c0129a);
            bVar.addEventListener("AdUserClick", c0129a);
            this.aOC.a(bVar);
        }
        return this.aOC.El();
    }

    @Override // com.baidu.mobads.interfaces.IXAdContext
    public IXAdProd getSlotById(String str) {
        return this.aOC.eG(str);
    }

    @Override // com.baidu.mobads.interfaces.IXAdContext
    public void addEventListener(String str, IOAdEventListener iOAdEventListener) {
        this.aOB.addEventListener(str, iOAdEventListener);
    }

    @Override // com.baidu.mobads.interfaces.IXAdContext
    public void removeEventListener(String str, IOAdEventListener iOAdEventListener) {
        this.aOB.removeEventListener(str, iOAdEventListener);
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
        this.aOy = visitorAction;
    }

    @Override // com.baidu.mobads.interfaces.IXAdContext
    public void dispose() {
    }

    @Override // com.baidu.mobads.interfaces.IXAdContext
    public void setVideoDisplayBaseWidth(int i) {
        this.a = i;
    }

    @Override // com.baidu.mobads.interfaces.IXAdContext
    public void setVideoDisplayBaseHeight(int i) {
        this.b = i;
    }
}
