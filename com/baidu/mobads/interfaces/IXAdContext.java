package com.baidu.mobads.interfaces;

import android.app.Activity;
import android.widget.RelativeLayout;
import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
/* loaded from: classes5.dex */
public interface IXAdContext {
    void addEventListener(String str, IOAdEventListener iOAdEventListener);

    void dispatchEvent(IOAdEvent iOAdEvent);

    void dispose();

    Activity getActivity();

    Object getParameter(String str);

    IXAdProd getSlotById(String str);

    IXAdManager getXAdManager();

    IXLinearAdSlot newPrerollAdSlot(String str, int i, int i2);

    void notifyVisitorAction(IXAdConstants4PDK.VisitorAction visitorAction);

    void removeEventListener(String str, IOAdEventListener iOAdEventListener);

    void setActivity(Activity activity);

    void setActivityState(IXAdConstants4PDK.ActivityState activityState);

    void setAdCreativeLoadingTimeout(int i);

    void setAdServerRequestingTimeout(int i);

    void setContentVideoPlayheadTime(double d);

    void setContentVideoScreenMode(IXAdConstants4PDK.ScreenSizeMode screenSizeMode);

    void setContentVideoState(IXAdConstants4PDK.VideoState videoState);

    void setParameter(String str, Object obj);

    void setVideoDisplayBase(RelativeLayout relativeLayout);

    void setVideoDisplayBaseHeight(int i);

    void setVideoDisplayBaseWidth(int i);

    void submitRequest();
}
