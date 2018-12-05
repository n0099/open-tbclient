package com.baidu.searchbox.ng.ai.apps.ioc.interfaces;

import android.app.Activity;
import android.content.Context;
import com.baidu.searchbox.ng.ai.apps.pay.callback.AliPayCallback;
import com.baidu.searchbox.ng.ai.apps.pay.callback.BaiduPayCallback;
import com.baidu.searchbox.ng.ai.apps.pay.callback.PolymerPayCallback;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.RequestPolymerPaymentAction;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public interface IAiAppPaymentIoc {
    void aliPay(Context context, String str, AliPayCallback aliPayCallback);

    void baiduPay(Context context, String str, BaiduPayCallback baiduPayCallback);

    void doPolymerPayBySwan(Context context, JSONObject jSONObject, RequestPolymerPaymentAction.OnWalletPayBack onWalletPayBack);

    boolean isWxAppInstalledAndSupported(Context context);

    boolean polymerPay(Context context, String str, Activity activity, String[] strArr, PolymerPayCallback polymerPayCallback);

    boolean removeWalletUI();
}
