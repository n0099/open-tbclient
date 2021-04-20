package com.baidu.mobads.container.util;

import com.baidu.mobads.container.adrequest.IXAdInstanceInfo;
import com.baidu.mobads.sdk.api.IOAdEvent;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class XAdRemoteEvent implements IOAdEvent {
    public static final String AD_CLICK_THRU = "AdClickThru";
    public static final String AD_USER_CLICK = "AdUserClick";
    public static final String COMPLETE = "complete";
    public static final String EVENT_INFO = "instanceInfo";
    public static final String EVENT_MESSAGE = "message";
    public final int mCode;
    public final HashMap<String, Object> mData;
    public Object mTarget;
    public final String mType;

    public XAdRemoteEvent(String str) {
        this(str, 0, new HashMap());
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public int getCode() {
        return this.mCode;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getMessage() {
        try {
            return (String) this.mData.get("message");
        } catch (Exception unused) {
            return "";
        }
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Object getTarget() {
        return this.mTarget;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getType() {
        return this.mType;
    }

    public void setData(IXAdInstanceInfo iXAdInstanceInfo) {
        if (iXAdInstanceInfo != null) {
            this.mData.put(EVENT_INFO, iXAdInstanceInfo.getUniqueId());
        }
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public void setTarget(Object obj) {
        this.mTarget = obj;
    }

    public XAdRemoteEvent(String str, String str2) {
        this(str, 0, str2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public HashMap<String, Object> getData() {
        return this.mData;
    }

    public XAdRemoteEvent(String str, HashMap<String, Object> hashMap) {
        this(str, 0, hashMap);
    }

    public XAdRemoteEvent(String str, int i) {
        this(str, i, new HashMap());
    }

    public XAdRemoteEvent(String str, int i, HashMap<String, Object> hashMap) {
        this.mType = str;
        this.mCode = i;
        this.mData = hashMap;
    }

    public XAdRemoteEvent(String str, int i, String str2) {
        this(str, i, new HashMap());
        this.mData.put("message", str2);
    }
}
