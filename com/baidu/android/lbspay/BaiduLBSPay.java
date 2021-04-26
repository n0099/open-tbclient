package com.baidu.android.lbspay;

import android.app.Activity;
import android.content.Context;
import com.baidu.wallet.api.BaiduWalletDelegate;
import java.util.Map;
/* loaded from: classes.dex */
public class BaiduLBSPay {

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static BaiduLBSPay f2562a = new BaiduLBSPay();
    }

    public static BaiduLBSPay getInstance() {
        return a.f2562a;
    }

    public void doCallFrontCashierPay(Activity activity, GetPayOrderListener getPayOrderListener, LBSPayBack lBSPayBack, Map<String, String> map, String str) {
        if (BaiduWalletDelegate.getInstance().getAppContext() == null) {
            return;
        }
        LBSPayInner.getInstance().doCallFrontCashierPay(activity, getPayOrderListener, lBSPayBack, map, str);
    }

    public void doPolymerAuthorizeSign(Activity activity, LBSPayBack lBSPayBack, Map<String, String> map) {
        if (BaiduWalletDelegate.getInstance().getAppContext() == null) {
            return;
        }
        LBSPayInner.getInstance().doPolymerAuthorizeSign(activity, lBSPayBack, map);
    }

    public void doPolymerPay(Context context, LBSPayBack lBSPayBack, Map<String, String> map) {
        if (BaiduWalletDelegate.getInstance().getAppContext() == null) {
            return;
        }
        LBSPayInner.getInstance().doPolymerPay(context, lBSPayBack, map);
    }

    public String getReqData(Context context) {
        return BaiduWalletDelegate.getInstance().getAppContext() == null ? "" : LBSPayInner.getInstance().getReqData(context);
    }

    public BaiduLBSPay() {
    }
}
