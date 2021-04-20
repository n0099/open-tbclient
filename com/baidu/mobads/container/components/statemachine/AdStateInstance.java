package com.baidu.mobads.container.components.statemachine;

import android.text.TextUtils;
import com.baidu.mobads.container.adrequest.IXAdInstanceInfo;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public class AdStateInstance {
    public IXAdInstanceInfo mAdInstanceInfo;
    public long mLastUpdateTime;
    public String mProdType;
    public long mRequestTimeMillis;
    public AtomicBoolean isReady4Send = new AtomicBoolean(false);
    public AtomicBoolean isHasSend = new AtomicBoolean(false);
    public HashMap<String, String> mExtraInfo = new HashMap<>();
    public StringBuilder mEventList = new StringBuilder();

    public AdStateInstance(long j, String str, IXAdInstanceInfo iXAdInstanceInfo) {
        this.mRequestTimeMillis = j;
        this.mProdType = str;
        this.mAdInstanceInfo = iXAdInstanceInfo;
    }

    public void addEvent(AdStateCode adStateCode) {
        if (adStateCode == null || adStateCode.getCode() <= 0) {
            return;
        }
        this.mEventList.append(adStateCode.getCode());
        this.mLastUpdateTime = System.currentTimeMillis();
        markReady4Send(false);
    }

    public void addExtra(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mExtraInfo.put(str, str2);
        this.mLastUpdateTime = System.currentTimeMillis();
        markReady4Send(AdStateEvent.EVENT_AD_TIMEOUT.equals(str));
    }

    public String getAllState() {
        return this.mEventList.toString();
    }

    public HashMap<String, String> getExtraInfo() {
        return this.mExtraInfo;
    }

    public void markReady4Send(boolean z) {
        if (this.isReady4Send.get() != z) {
            this.isReady4Send.set(z);
        }
        if (z) {
            return;
        }
        setHasSend(false);
    }

    public void setHasSend(boolean z) {
        if (this.isHasSend.get() != z) {
            this.isHasSend.set(z);
        }
    }
}
