package com.baidu.live.tbadk.core.data;

import com.baidu.live.tbadk.BaseActivity;
/* loaded from: classes3.dex */
public class PayChannelData {
    private BaseActivity baseActivity;
    private String channel;
    private String from;
    private String iconId;
    private String liveId;
    private int payType;
    private String price;
    private boolean showToast;

    public PayChannelData() {
        this.payType = 2;
        this.showToast = true;
    }

    public PayChannelData(BaseActivity baseActivity, String str, String str2, String str3, String str4, String str5, int i) {
        this.payType = 2;
        this.showToast = true;
        this.baseActivity = baseActivity;
        this.channel = str;
        this.iconId = str2;
        this.price = str3;
        this.from = str4;
        this.liveId = str5;
        this.payType = i;
    }

    public void setShowToast(boolean z) {
        this.showToast = z;
    }

    public boolean getShowToast() {
        return this.showToast;
    }

    public BaseActivity getBaseActivity() {
        return this.baseActivity;
    }

    public String getChannel() {
        return this.channel;
    }

    public String getIconId() {
        return this.iconId;
    }

    public String getPrice() {
        return this.price;
    }

    public String getFrom() {
        return this.from;
    }

    public String getLiveId() {
        return this.liveId;
    }

    public int getPayType() {
        return this.payType;
    }
}
