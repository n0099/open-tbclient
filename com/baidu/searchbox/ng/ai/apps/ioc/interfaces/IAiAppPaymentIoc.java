package com.baidu.searchbox.ng.ai.apps.ioc.interfaces;

import android.app.Activity;
import android.content.Context;
import com.baidu.searchbox.ng.ai.apps.pay.callback.AliPayCallback;
import com.baidu.searchbox.ng.ai.apps.pay.callback.PayCallback;
import com.baidu.searchbox.ng.ai.apps.pay.callback.PolymerPayCallback;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.RequestPolymerPaymentAction;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public interface IAiAppPaymentIoc {
    void doAliPay(Context context, String str, AliPayCallback aliPayCallback);

    void doPay(Context context, String str, PayCallback payCallback);

    void doPolymerPay(Context context, Activity activity, String str, String[] strArr, PolymerPayCallback polymerPayCallback);

    void doPolymerPayBySwan(Context context, JSONObject jSONObject, RequestPolymerPaymentAction.OnWalletPayBack onWalletPayBack);

    boolean removeWalletUI();
}
