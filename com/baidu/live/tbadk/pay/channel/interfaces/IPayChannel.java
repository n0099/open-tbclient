package com.baidu.live.tbadk.pay.channel.interfaces;

import android.content.Context;
import java.util.HashMap;
/* loaded from: classes7.dex */
public interface IPayChannel {
    PayChannelType getType();

    void onPayResult(String str, String str2, String str3, Context context, boolean z);

    void pay(HashMap<String, String> hashMap, IPayCallback iPayCallback);

    void release();
}
