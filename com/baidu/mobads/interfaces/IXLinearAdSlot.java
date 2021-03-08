package com.baidu.mobads.interfaces;

import android.app.Activity;
import android.widget.RelativeLayout;
import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
/* loaded from: classes4.dex */
public interface IXLinearAdSlot extends IXAdProd {
    void addEventListener(String str, IOAdEventListener iOAdEventListener);

    void dispatchEvent(IOAdEvent iOAdEvent);

    void dispose();

    @Override // com.baidu.mobads.interfaces.IXAdProd
    Activity getActivity();

    Object getParameter(String str);

    void notifyVisitorAction(IXAdConstants4PDK.VisitorAction visitorAction);

    void removeEventListener(String str, IOAdEventListener iOAdEventListener);

    void setActivityState(IXAdConstants4PDK.ActivityState activityState);

    void setContentVideoAssetCurrentTimePosition(double d);

    void setMaxAdNum(int i);

    void setMaxDuration(int i);

    void setParameter(String str, Object obj);

    void setSupportTipView(boolean z);

    void setVideoDisplayBase(RelativeLayout relativeLayout);

    void setVideoState(IXAdConstants4PDK.VideoState videoState);
}
