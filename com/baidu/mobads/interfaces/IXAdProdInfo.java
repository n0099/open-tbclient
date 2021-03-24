package com.baidu.mobads.interfaces;

import android.view.View;
import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public interface IXAdProdInfo {
    String getAdPlacementId();

    String getAdRequestURL();

    int getApt();

    JSONObject getAttribute();

    View getClickView();

    int getInstanceCount();

    @Deprecated
    String getProdType();

    int getRequestAdHeight();

    int getRequestAdWidth();

    IXAdConstants4PDK.SlotType getType();

    boolean isAutoPlay();

    boolean isMsspTagAvailable();

    void setClickView(View view);
}
