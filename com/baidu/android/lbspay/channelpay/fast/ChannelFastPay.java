package com.baidu.android.lbspay.channelpay.fast;

import com.baidu.android.lbspay.channelpay.ChannelBaseWapPay;
import com.baidu.android.lbspay.channelpay.PayDataBean;
import com.baidu.android.lbspay.network.GetPayContent;
/* loaded from: classes2.dex */
public class ChannelFastPay extends ChannelBaseWapPay {
    @Override // com.baidu.android.lbspay.channelpay.IChannelPay
    public int getChannelId() {
        return 107;
    }

    @Override // com.baidu.android.lbspay.channelpay.ChannelBaseWapPay
    public String getUrl(GetPayContent getPayContent) {
        PayDataBean payData = getPayData(getPayContent);
        return payData != null ? payData.payurl : "";
    }
}
