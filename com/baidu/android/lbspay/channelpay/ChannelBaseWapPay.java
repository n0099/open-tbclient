package com.baidu.android.lbspay.channelpay;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.android.lbspay.activity.WapPayActivity;
import com.baidu.android.lbspay.network.GetPayContent;
/* loaded from: classes.dex */
public abstract class ChannelBaseWapPay extends AbstractChannelPay {
    public abstract String getUrl(GetPayContent getPayContent);

    @Override // com.baidu.android.lbspay.channelpay.AbstractChannelPay, com.baidu.android.lbspay.channelpay.IChannelPay
    public void pay(Activity activity, GetPayContent getPayContent) {
        super.pay(activity, getPayContent);
        String url = getUrl(getPayContent);
        if (TextUtils.isEmpty(url)) {
            return;
        }
        Intent intent = new Intent(activity, WapPayActivity.class);
        intent.putExtra(WapPayActivity.URL, url);
        activity.startActivityForResult(intent, 99);
    }
}
