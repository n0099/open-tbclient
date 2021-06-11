package com.baidu.android.lbspay.channelpay.baidu;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.alibaba.fastjson.asm.Label;
import com.baidu.android.lbspay.CashierDataNew;
import com.baidu.android.lbspay.activity.LBSTransCashierActivity;
import com.baidu.android.lbspay.channelpay.AbstractChannelPay;
import com.baidu.android.lbspay.channelpay.PayDataBean;
import com.baidu.android.lbspay.network.GetPayContent;
import com.baidu.android.pay.PayCallBack;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.wallet.api.BaiduPayDelegate;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.base.datamodel.AccountManager;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.paysdk.datamodel.PrecashierCreateOrderResponse;
import com.baidu.wallet.statistics.api.StatisticManager;
import java.lang.ref.WeakReference;
import java.util.HashMap;
/* loaded from: classes.dex */
public class ChannelBaiduPay extends AbstractChannelPay {
    public CashierDataNew mOrderInfo;
    public WeakReference<Activity> mWeakReference;

    public String gatValue(String str, String str2) {
        String str3 = str2 + "={";
        return str.substring(str.indexOf(str3) + str3.length(), str.indexOf("}"));
    }

    @Override // com.baidu.android.lbspay.channelpay.IChannelPay
    public int getChannelId() {
        return 126;
    }

    public String getNotify(String str) {
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

    public void handlepayResult(int i2, String str) {
        CashierDataNew cashierDataNew;
        if (i2 == 0) {
            paySuccess(getNotify(str));
        } else if (i2 != 1) {
            payCancel();
            WeakReference<Activity> weakReference = this.mWeakReference;
            Activity activity = weakReference == null ? null : weakReference.get();
            if (activity == null || (cashierDataNew = this.mOrderInfo) == null || !cashierDataNew.isShowAllPayType()) {
                return;
            }
            Intent intent = new Intent(activity, LBSTransCashierActivity.class);
            intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            intent.putExtra(CashierDataNew.DELIVERY_CASHIER_DATA, this.mOrderInfo);
            activity.startActivity(intent);
        } else {
            paying();
        }
    }

    @Override // com.baidu.android.lbspay.channelpay.AbstractChannelPay, com.baidu.android.lbspay.channelpay.IChannelPay
    public void pay(Activity activity, GetPayContent getPayContent) {
        String str;
        this.mWeakReference = new WeakReference<>(activity);
        if (getPayContent != null) {
            this.mOrderInfo = getPayContent.extraOrderInfo;
        }
        super.pay(activity, getPayContent);
        boolean z = true;
        if (getPayContent != null && getPayContent.checkResponseValidity()) {
            HashMap hashMap = new HashMap();
            PayDataBean payData = getPayData(getPayContent);
            if (payData != null) {
                String str2 = payData.params;
                if (payData.isBaifubaoAuthPay()) {
                    hashMap.put("pay_from", BaiduPay.PAY_FROM_AUTHORIZE);
                }
                str = str2;
            } else {
                str = "";
            }
            if (!TextUtils.isEmpty(str)) {
                PrecashierCreateOrderResponse precashierCreateOrderResponse = getPayContent.sdk_info;
                if (precashierCreateOrderResponse != null) {
                    if (!TextUtils.isEmpty(precashierCreateOrderResponse.ret) && getPayContent.sdk_info.ret.equals(String.valueOf(5003))) {
                        AccountManager.getInstance(activity).logout();
                        WalletLoginHelper.getInstance().logout(false);
                        WalletLoginHelper.getInstance().handlerWalletError(5003);
                        if (!TextUtils.isEmpty(getPayContent.sdk_info.msg)) {
                            GlobalUtils.toast(activity, getPayContent.sdk_info.msg);
                        }
                    } else {
                        StatisticManager.onEventWithValue(StatServiceEvent.LBS_PREPAY_RESULET, "1");
                        BaiduPayDelegate.getInstance().doPrecashierPay(activity, str, new PayCallBack() { // from class: com.baidu.android.lbspay.channelpay.baidu.ChannelBaiduPay.1
                            @Override // com.baidu.android.pay.PayCallBack
                            public boolean isHideLoadingDialog() {
                                return false;
                            }

                            @Override // com.baidu.android.pay.PayCallBack
                            public void onPayResult(int i2, String str3) {
                                ChannelBaiduPay.this.handlepayResult(i2, str3);
                            }
                        }, hashMap, getPayContent.sdk_info, null);
                    }
                } else {
                    StatisticManager.onEventWithValue(StatServiceEvent.LBS_PREPAY_RESULET, "0");
                    BaiduPayDelegate.getInstance().doPay(activity, str, new PayCallBack() { // from class: com.baidu.android.lbspay.channelpay.baidu.ChannelBaiduPay.2
                        @Override // com.baidu.android.pay.PayCallBack
                        public boolean isHideLoadingDialog() {
                            return false;
                        }

                        @Override // com.baidu.android.pay.PayCallBack
                        public void onPayResult(int i2, String str3) {
                            ChannelBaiduPay.this.handlepayResult(i2, str3);
                        }
                    }, hashMap);
                }
                z = false;
            }
        }
        if (z && this.mNotifyOnError) {
            payCancel();
        }
    }
}
