package com.baidu.mobads.interfaces;

import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import org.json.JSONObject;
/* loaded from: classes20.dex */
public interface IXAdProdInfo {
    String getAdPlacementId();

    String getAdRequestURL();

    int getApt();

    JSONObject getAttribute();

    int getInstanceCount();

    @Deprecated
    String getProdType();

    int getRequestAdHeight();

    int getRequestAdWidth();

    IXAdConstants4PDK.SlotType getType();

    boolean isAutoPlay();

    boolean isMsspTagAvailable();
}
