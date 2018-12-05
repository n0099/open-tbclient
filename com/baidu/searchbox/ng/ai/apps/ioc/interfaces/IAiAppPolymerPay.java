package com.baidu.searchbox.ng.ai.apps.ioc.interfaces;

import android.content.Context;
import com.baidu.searchbox.ng.ai.apps.pay.callback.AliPayCallback;
import com.baidu.searchbox.ng.ai.apps.pay.callback.BaiduPayCallback;
import com.baidu.searchbox.ng.ai.apps.pay.callback.PolymerPayCallback;
import com.baidu.searchbox.ng.ai.apps.pay.callback.WeChatPayCallback;
import java.util.Map;
/* loaded from: classes2.dex */
public interface IAiAppPolymerPay {
    void doAliPay(Context context, String str, AliPayCallback aliPayCallback);

    void doBaiFuBaoPay(Context context, String str, BaiduPayCallback baiduPayCallback);

    void doBaiduWalletPolymerPay(Context context, String str, PolymerPayCallback polymerPayCallback);

    void doWeChatPay(Context context, Map<String, String> map, WeChatPayCallback weChatPayCallback);
}
