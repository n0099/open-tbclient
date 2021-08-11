package com.baidu.mobads.container.adrequest;

import android.app.Activity;
import android.content.Context;
import android.widget.RelativeLayout;
import com.baidu.mobads.container.util.XAdRemoteEventDispatcher;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public interface XAdContainerContext {
    Activity getActivity();

    int getAdHeight();

    IXAdInstanceInfo getAdInstanceInfo();

    String getAdPlacementId();

    String getAdProd();

    RelativeLayout getAdProdBase();

    JSONObject getAdReqParam();

    IXAdResponseInfo getAdResponseInfo();

    int getAdWidth();

    Context getAppContext();

    String getAppSec();

    String getAppsid();

    XAdRemoteEventDispatcher getEventDispatcher();

    void setActivity(Activity activity);
}
