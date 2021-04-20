package com.baidu.mobads.container.adrequest;

import com.baidu.mobads.sdk.api.IAdInterListener;
/* loaded from: classes2.dex */
public enum AdTaskType {
    AD_CLICK(IAdInterListener.AdCommandType.AD_CLICK),
    AD_IMPRESSION(IAdInterListener.AdCommandType.AD_IMPRESSION),
    HANDLE_EVENT(IAdInterListener.AdCommandType.HANDLE_EVENT),
    UNSPECIFIED("");
    
    public final String mAdTaskType;

    AdTaskType(String str) {
        this.mAdTaskType = str;
    }

    public static AdTaskType getAdTaskType(String str) {
        AdTaskType[] values;
        for (AdTaskType adTaskType : values()) {
            if (adTaskType.mAdTaskType.equals(str)) {
                return adTaskType;
            }
        }
        return UNSPECIFIED;
    }
}
