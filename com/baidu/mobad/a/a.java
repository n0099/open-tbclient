package com.baidu.mobad.a;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.support.v4.app.NotificationCompat;
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
/* loaded from: classes5.dex */
public class a implements IXAdContext {
    private IXAdConstants4PDK.VisitorAction agt;
    private Location agu;
    private Activity agv;
    private double h;
    private int i;
    private int j;
    private Context k;
    private String l;
    private RelativeLayout o;
    private HashMap<String, Object> c = new HashMap<>();
    private IXAdConstants4PDK.ScreenSizeMode agq = IXAdConstants4PDK.ScreenSizeMode.FULL_SCREEN;
    private IXAdConstants4PDK.VideoState agr = IXAdConstants4PDK.VideoState.IDLE;
    private IXAdConstants4PDK.ActivityState ags = IXAdConstants4PDK.ActivityState.CREATE;
    int a = 0;
    int b = 0;
    private final IOAdEventDispatcher agw = new com.baidu.mobads.openad.c.c();
    private final f agx = new f();
    protected IXAdLogger agp = XAdSDKFoundationFacade.getInstance().getAdLogger();

    public a(Context context, String str, Location location) {
        this.k = context;
        this.l = str;
        this.agu = location;
    }

    @Override // com.baidu.mobads.interfaces.IXAdContext
    public void setVideoDisplayBase(RelativeLayout relativeLayout) {
        this.o = relativeLayout;
        setActivity((Activity) this.o.getContext());
        new Handler(getActivity().getMainLooper()).post(new b(this));
    }

    @Override // com.baidu.mobads.interfaces.IXAdContext
    public void setActivity(Activity activity) {
        if (activity != null && this.agv == null) {
            this.agv = activity;
            if (this.k == null) {
                this.k = this.agv.getApplicationContext();
            }
        }
    }

    @Override // com.baidu.mobads.interfaces.IXAdContext
    public Activity getActivity() {
        return this.agv;
    }

    @Override // com.baidu.mobads.interfaces.IXAdContext
    public void setActivityState(IXAdConstants4PDK.ActivityState activityState) {
        this.ags = activityState;
        this.agp.i("XAdContext", activityState.getValue());
        IXLinearAdSlot ur = this.agx.ur();
        if (ur != null) {
            if (activityState == IXAdConstants4PDK.ActivityState.PAUSE) {
                ur.pause();
            }
            if (activityState == IXAdConstants4PDK.ActivityState.RESUME) {
                ur.resume();
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
        this.agq = screenSizeMode;
        IXLinearAdSlot ur = this.agx.ur();
        if (this.agq == IXAdConstants4PDK.ScreenSizeMode.FULL_SCREEN && ur != null && ur.getSlotState() == IXAdConstants4PDK.SlotState.PLAYING && (currentAdInstance = ur.getCurrentAdInstance()) != null) {
            int playheadTime = (int) ur.getCurrentXAdContainer().getPlayheadTime();
            IXAdURIUitls uRIUitls = XAdSDKFoundationFacade.getInstance().getURIUitls();
            ArrayList arrayList = new ArrayList();
            List<String> fullScreenTrackers = currentAdInstance.getFullScreenTrackers();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < fullScreenTrackers.size()) {
                    arrayList.add(uRIUitls.addParameter(fullScreenTrackers.get(i2), NotificationCompat.CATEGORY_PROGRESS, "" + playheadTime));
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
        this.agr = videoState;
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
        IXLinearAdSlot ur = this.agx.ur();
        if (this.i > 0 && this.j > 0) {
            HashMap<String, String> parameter = ur.getParameter();
            parameter.put(IXAdInternalConstants.PARAMETER_KEY_OF_AD_REQUESTING_TIMEOUT, "" + this.i);
            parameter.put(IXAdInternalConstants.PARAMETER_KEY_OF_AD_CREATIVE_LOADING_TIMEOUT, "" + this.j);
            parameter.put("BASE_WIDTH", "" + this.a);
            parameter.put("BASE_HEIGHT", "" + this.b);
            ur.setParameter(parameter);
        }
        ur.request();
    }

    /* renamed from: com.baidu.mobad.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0071a implements IOAdEventListener {
        private final Context a;
        private final IOAdEventDispatcher agA;
        private final IXAdProd agz;

        public C0071a(Context context, IXAdProd iXAdProd, IOAdEventDispatcher iOAdEventDispatcher) {
            this.a = context;
            this.agz = iXAdProd;
            this.agA = iOAdEventDispatcher;
        }

        @Override // com.baidu.mobads.openad.interfaces.event.IOAdEventListener
        public void run(IOAdEvent iOAdEvent) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().i("AdSlotEventListener", iOAdEvent.getType());
            XAdSDKFoundationFacade.getInstance().getCommonUtils().a((Runnable) new c(this, iOAdEvent));
        }
    }

    @Override // com.baidu.mobads.interfaces.IXAdContext
    public IXLinearAdSlot newPrerollAdSlot(String str, int i, int i2) {
        if (!this.agx.cM(str).booleanValue()) {
            com.baidu.mobads.production.h.b bVar = new com.baidu.mobads.production.h.b(this.agv, str);
            bVar.setActivity(this.agv);
            bVar.setAdSlotBase(this.o);
            bVar.setId(str);
            C0071a c0071a = new C0071a(this.k, bVar, this.agw);
            bVar.removeAllListeners();
            bVar.addEventListener(com.baidu.mobads.openad.c.b.COMPLETE, c0071a);
            bVar.addEventListener(IXAdEvent.AD_STARTED, c0071a);
            bVar.addEventListener(IXAdEvent.AD_STOPPED, c0071a);
            bVar.addEventListener(IXAdEvent.AD_ERROR, c0071a);
            bVar.addEventListener("AdUserClick", c0071a);
            this.agx.a(bVar);
        }
        return this.agx.ur();
    }

    @Override // com.baidu.mobads.interfaces.IXAdContext
    public IXAdProd getSlotById(String str) {
        return this.agx.cN(str);
    }

    @Override // com.baidu.mobads.interfaces.IXAdContext
    public void addEventListener(String str, IOAdEventListener iOAdEventListener) {
        this.agw.addEventListener(str, iOAdEventListener);
    }

    @Override // com.baidu.mobads.interfaces.IXAdContext
    public void removeEventListener(String str, IOAdEventListener iOAdEventListener) {
        this.agw.removeEventListener(str, iOAdEventListener);
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
        this.agt = visitorAction;
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
