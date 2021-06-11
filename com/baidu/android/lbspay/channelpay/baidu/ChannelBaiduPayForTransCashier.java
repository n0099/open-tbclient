package com.baidu.android.lbspay.channelpay.baidu;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.lbspay.CashierDataNew;
import com.baidu.android.lbspay.LBSPayResult;
import com.baidu.android.pay.PayCallBack;
import com.baidu.wallet.api.BaiduPayDelegate;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.paysdk.datamodel.PrecashierCreateOrderResponse;
import com.baidu.wallet.statistics.api.StatisticManager;
import java.util.HashMap;
/* loaded from: classes.dex */
public class ChannelBaiduPayForTransCashier {

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static ChannelBaiduPayForTransCashier f2666a = new ChannelBaiduPayForTransCashier();
    }

    public static ChannelBaiduPayForTransCashier getInstance() {
        return a.f2666a;
    }

    private String getNotify(String str) {
        String[] split;
        String str2 = "";
        if (!TextUtils.isEmpty(str)) {
            try {
                for (String str3 : str.split(";")) {
                    if (str3.startsWith("notify")) {
                        str2 = gatValue(str3, "notify");
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlepayResult(Context context, int i2, String str) {
        if (i2 == 0) {
            paySuccess(context, str);
        } else if (i2 == 1) {
            paying(context);
        } else if (i2 != 2) {
        } else {
            payCancel(context);
        }
    }

    private void paySuccess(Context context, String str) {
        LBSPayResult.payResult(context, 0, getNotify(str));
        StatisticManager.onEventWithValue(StatServiceEvent.LBS_BAIDU_PAY, "success");
    }

    public String gatValue(String str, String str2) {
        String str3 = str2 + "={";
        return str.substring(str.indexOf(str3) + str3.length(), str.indexOf("}"));
    }

    public void pay(final Context context, String str, PrecashierCreateOrderResponse precashierCreateOrderResponse, CashierDataNew cashierDataNew) {
        if (TextUtils.isEmpty(str) || precashierCreateOrderResponse == null) {
            return;
        }
        String str2 = StatServiceEvent.LBS_TRANSPARENT_POLYMERPAY;
        StatisticManager.onEventWithValue(str2, cashierDataNew.getCustomId() + "|" + cashierDataNew.getOrderNo());
        StringBuilder sb = new StringBuilder();
        sb.append(WalletLoginHelper.getInstance().getLoginType());
        sb.append("");
        sb.toString();
        WalletLoginHelper.getInstance().getLoginToken();
        BaiduPayDelegate.getInstance().doPrecashierPay(context, str, new PayCallBack() { // from class: com.baidu.android.lbspay.channelpay.baidu.ChannelBaiduPayForTransCashier.1
            @Override // com.baidu.android.pay.PayCallBack
            public boolean isHideLoadingDialog() {
                return false;
            }

            @Override // com.baidu.android.pay.PayCallBack
            public void onPayResult(int i2, String str3) {
                ChannelBaiduPayForTransCashier.this.handlepayResult(context, i2, str3);
            }
        }, new HashMap(), precashierCreateOrderResponse, null);
    }

    public void payCancel(Context context) {
        if (context != null) {
            LBSPayResult.payResult(context, 2, "");
            StatisticManager.onEventWithValue(StatServiceEvent.LBS_BAIDU_PAY, "canncel");
        }
    }

    public void paying(Context context) {
        LBSPayResult.payResult(context, 1, "");
        StatisticManager.onEventWithValue(StatServiceEvent.LBS_BAIDU_PAY, "paying");
    }

    public ChannelBaiduPayForTransCashier() {
    }
}
