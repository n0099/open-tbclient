package com.baidu.searchbox.live.interfaces.pay;

import android.app.Activity;
import android.content.Context;
import java.util.HashMap;
/* loaded from: classes11.dex */
public interface IPayChannel {
    PayChannelType getType();

    String getUaForFrontPay();

    void onPayResult(String str, String str2, String str3, Context context, boolean z);

    void pay(Activity activity, HashMap<String, String> hashMap, IPayCallback iPayCallback);

    void release();
}
