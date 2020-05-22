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
    private IXAdConstants4PDK.VisitorAction brP;
    private Location brQ;
    private Activity brR;
    private RelativeLayout brS;
    private double h;
    private int i;
    private int j;
    private Context k;
    private String l;
    private HashMap<String, Object> c = new HashMap<>();
    private IXAdConstants4PDK.ScreenSizeMode brM = IXAdConstants4PDK.ScreenSizeMode.FULL_SCREEN;
    private IXAdConstants4PDK.VideoState brN = IXAdConstants4PDK.VideoState.IDLE;
    private IXAdConstants4PDK.ActivityState brO = IXAdConstants4PDK.ActivityState.CREATE;
    int a = 0;
    int b = 0;
    private final IOAdEventDispatcher brT = new com.baidu.mobads.openad.c.c();
    private final f brU = new f();
    protected IXAdLogger brL = XAdSDKFoundationFacade.getInstance().getAdLogger();

    public a(Context context, String str, Location location) {
        this.k = context;
        this.l = str;
        this.brQ = location;
    }

    @Override // com.baidu.mobads.interfaces.IXAdContext
    public void setVideoDisplayBase(RelativeLayout relativeLayout) {
        this.brS = relativeLayout;
        setActivity((Activity) this.brS.getContext());
        new Handler(getActivity().getMainLooper()).post(new b(this));
    }

    @Override // com.baidu.mobads.interfaces.IXAdContext
    public void setActivity(Activity activity) {
        if (activity != null && this.brR == null) {
            this.brR = activity;
            if (this.k == null) {
                this.k = this.brR.getApplicationContext();
            }
        }
    }

    @Override // com.baidu.mobads.interfaces.IXAdContext
    public Activity getActivity() {
        return this.brR;
    }

    @Override // com.baidu.mobads.interfaces.IXAdContext
    public void setActivityState(IXAdConstants4PDK.ActivityState activityState) {
        this.brO = activityState;
        this.brL.i("XAdContext", activityState.getValue());
        IXLinearAdSlot Me = this.brU.Me();
        if (Me != null) {
            if (activityState == IXAdConstants4PDK.ActivityState.PAUSE) {
                Me.pause();
            }
            if (activityState == IXAdConstants4PDK.ActivityState.RESUME) {
                Me.resume();
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
        this.brM = screenSizeMode;
        IXLinearAdSlot Me = this.brU.Me();
        if (this.brM == IXAdConstants4PDK.ScreenSizeMode.FULL_SCREEN && Me != null && Me.getSlotState() == IXAdConstants4PDK.SlotState.PLAYING && (currentAdInstance = Me.getCurrentAdInstance()) != null) {
            int playheadTime = (int) Me.getCurrentXAdContainer().getPlayheadTime();
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
        this.brN = videoState;
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
        IXLinearAdSlot Me = this.brU.Me();
        if (this.i > 0 && this.j > 0) {
            HashMap<String, String> parameter = Me.getParameter();
            parameter.put(IXAdInternalConstants.PARAMETER_KEY_OF_AD_REQUESTING_TIMEOUT, "" + this.i);
            parameter.put(IXAdInternalConstants.PARAMETER_KEY_OF_AD_CREATIVE_LOADING_TIMEOUT, "" + this.j);
            parameter.put("BASE_WIDTH", "" + this.a);
            parameter.put("BASE_HEIGHT", "" + this.b);
            Me.setParameter(parameter);
        }
        Me.request();
    }

    /* renamed from: com.baidu.mobad.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0206a implements IOAdEventListener {
        private final Context a;
        private final IXAdProd brW;
        private final IOAdEventDispatcher brX;

        public C0206a(Context context, IXAdProd iXAdProd, IOAdEventDispatcher iOAdEventDispatcher) {
            this.a = context;
            this.brW = iXAdProd;
            this.brX = iOAdEventDispatcher;
        }

        @Override // com.baidu.mobads.openad.interfaces.event.IOAdEventListener
        public void run(IOAdEvent iOAdEvent) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().i("AdSlotEventListener", iOAdEvent.getType());
            XAdSDKFoundationFacade.getInstance().getCommonUtils().a((Runnable) new c(this, iOAdEvent));
        }
    }

    @Override // com.baidu.mobads.interfaces.IXAdContext
    public IXLinearAdSlot newPrerollAdSlot(String str, int i, int i2) {
        if (!this.brU.gl(str).booleanValue()) {
            com.baidu.mobads.production.h.b bVar = new com.baidu.mobads.production.h.b(this.brR, str);
            bVar.setActivity(this.brR);
            bVar.setAdSlotBase(this.brS);
            bVar.setId(str);
            C0206a c0206a = new C0206a(this.k, bVar, this.brT);
            bVar.removeAllListeners();
            bVar.addEventListener(com.baidu.mobads.openad.c.b.COMPLETE, c0206a);
            bVar.addEventListener(IXAdEvent.AD_STARTED, c0206a);
            bVar.addEventListener(IXAdEvent.AD_STOPPED, c0206a);
            bVar.addEventListener(IXAdEvent.AD_ERROR, c0206a);
            bVar.addEventListener("AdUserClick", c0206a);
            this.brU.a(bVar);
        }
        return this.brU.Me();
    }

    @Override // com.baidu.mobads.interfaces.IXAdContext
    public IXAdProd getSlotById(String str) {
        return this.brU.gm(str);
    }

    @Override // com.baidu.mobads.interfaces.IXAdContext
    public void addEventListener(String str, IOAdEventListener iOAdEventListener) {
        this.brT.addEventListener(str, iOAdEventListener);
    }

    @Override // com.baidu.mobads.interfaces.IXAdContext
    public void removeEventListener(String str, IOAdEventListener iOAdEventListener) {
        this.brT.removeEventListener(str, iOAdEventListener);
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
        this.brP = visitorAction;
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
