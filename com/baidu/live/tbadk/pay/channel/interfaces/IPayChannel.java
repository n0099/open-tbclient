package com.baidu.live.tbadk.pay.channel.interfaces;

import android.content.Context;
/* loaded from: classes6.dex */
public interface IPayChannel {
    void onPayResult(String str, String str2, Context context, boolean z);

    void pay(Object obj, IPayCallback iPayCallback);

    void release();
}
