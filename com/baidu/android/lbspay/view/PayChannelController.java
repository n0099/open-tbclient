package com.baidu.android.lbspay.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.alipay.sdk.util.e;
import com.baidu.android.lbspay.CashierDataNew;
import com.baidu.android.lbspay.GetPayOrderListener;
import com.baidu.android.lbspay.LBSPayResult;
import com.baidu.android.lbspay.beans.GetPayBean;
import com.baidu.android.lbspay.beans.LbsPayBeanFactory;
import com.baidu.android.lbspay.channelpay.AbstractChannelPay;
import com.baidu.android.lbspay.channelpay.ChannelPayUtil;
import com.baidu.android.lbspay.channelpay.IChannelPay;
import com.baidu.android.lbspay.channelpay.alipay.ChannelAliPay;
import com.baidu.android.lbspay.channelpay.alipay.LBSPayAli;
import com.baidu.android.lbspay.channelpay.fast.ChannelFastPay;
import com.baidu.android.lbspay.network.GetPayContent;
import com.baidu.android.lbspay.statistics.LbsStatistics;
import com.baidu.android.lbspay.utils.PayMode;
import com.baidu.apollon.beans.IBeanResponseCallback;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.NetworkUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.tbadk.core.atomData.WalletPayResultActivityConfig;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.core.NoProguard;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import com.baidu.wallet.statistics.api.StatisticManager;
import com.baidu.wallet.util.StatHelper;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class PayChannelController implements IBeanResponseCallback, NoProguard {
    public static final String ALIPAY_PAYCHANNEL = "BAIDU-ALIPAY-WISE";
    public static final String BAIFUBAO_PAYCHANNEL = "BAIDU-BAIFUBAO-WISE";
    public static final String BAIFUBAO_PAYCHANNEL_CODE = "BAIFUBAO-WISE";
    public static final String BANKCARD_PAYCHANNEL = "BAIDU-BANK-CARD-PAY";
    public static final String BEAN_TAG = "ChannelListViewController";
    public static final String WXPAY_PAYCHANNEL = "BAIDU-SUPER-WECHAT-WISE";
    public GetPayOrderListener getPayOrderListener;
    public Activity mAct;
    public Activity mAlipayActivity;
    public CashierDataNew mCashierData;
    public int mChannelId;
    public IChannelPay mChannelPay;
    public GetPayBean mGetPayBean;
    public Handler mHandler;

    /* loaded from: classes2.dex */
    public interface DoShowAllChannelClick {
        void doClick();
    }

    /* loaded from: classes2.dex */
    public interface GetPayModeListener {
        void getSelectPayMode(PayMode payMode);
    }

    /* loaded from: classes2.dex */
    public interface SelectChannelListener {
        void onSelectChannel(String str);
    }

    public PayChannelController(Activity activity) {
        this.mAlipayActivity = null;
        this.mAct = activity;
        this.mHandler = new Handler(activity.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleFailure(int i, int i2, String str) {
        if (i == 2) {
            LBSPayAli.getInstance().clearChannelPay();
            this.mChannelPay = null;
            if (!TextUtils.isEmpty(str)) {
                GlobalUtils.toast(this.mAct, str);
            }
            GetPayOrderListener getPayOrderListener = this.getPayOrderListener;
            if (getPayOrderListener != null) {
                getPayOrderListener.complete();
            }
            LBSPayResult.payResult(this.mAct, 2, "");
        }
        CashierDataNew cashierDataNew = this.mCashierData;
        if (cashierDataNew != null) {
            cashierDataNew.getUid();
            this.mCashierData.getOrderNo();
            NetworkUtils.getNetName(this.mAct);
            this.mCashierData.getCustomId();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlerResponse(int i, Object obj, String str) {
        if (obj != null && i == 2) {
            GetPayContent getPayContent = obj instanceof GetPayContent ? (GetPayContent) obj : null;
            GetPayOrderListener getPayOrderListener = this.getPayOrderListener;
            if (getPayOrderListener != null) {
                getPayOrderListener.complete();
            }
            if (getPayContent != null) {
                int i2 = getPayContent.authorize_err_no;
                if (i2 == 100000) {
                    LBSPayResult.payResult(this.mAct, 0, getPayContent.authorize_return_data);
                } else if (i2 > 100000 && i2 <= 110000) {
                    doPay(getPayContent);
                } else {
                    doPay(getPayContent);
                }
            }
        }
    }

    public void doDirectCallThirdPay(GetPayOrderListener getPayOrderListener, CashierDataNew cashierDataNew, String str) {
        if (TextUtils.isEmpty(str) || cashierDataNew == null) {
            return;
        }
        this.mCashierData = cashierDataNew;
        this.getPayOrderListener = getPayOrderListener;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("payChannel")) {
                String valueOf = String.valueOf(jSONObject.get("payChannel"));
                if (ALIPAY_PAYCHANNEL.equals(valueOf)) {
                    this.mChannelId = 105;
                    this.mChannelPay = ChannelPayUtil.getChannelPay(105);
                } else if (WXPAY_PAYCHANNEL.equals(valueOf)) {
                    this.mChannelId = 158;
                    this.mChannelPay = ChannelPayUtil.getChannelPay(158);
                } else if (BAIFUBAO_PAYCHANNEL.equals(valueOf)) {
                    this.mChannelId = 126;
                    this.mChannelPay = ChannelPayUtil.getChannelPay(126);
                } else if (BANKCARD_PAYCHANNEL.equals(valueOf)) {
                    this.mChannelId = 178;
                    this.mChannelPay = ChannelPayUtil.getChannelPay(178);
                } else {
                    LBSPayResult.payResult(this.mAct, 2, "");
                    return;
                }
                ((AbstractChannelPay) this.mChannelPay).setNotifyOnError(true);
                StatHelper.cacheChannelId(this.mChannelId + "");
                String orderNo = this.mCashierData.getOrderNo();
                List<String> collectData = StatHelper.collectData(orderNo, this.mChannelId + "");
                HashMap hashMap = new HashMap();
                hashMap.put(BaiduPay.AMOUNT, StatHelper.getPayAmount());
                StatisticManager.onEventWithValues(PayStatServiceEvent.LBS_PAY_CHANNEL, collectData, hashMap);
                GetPayBean getPayBean = (GetPayBean) LbsPayBeanFactory.getInstance().getBean((Context) this.mAct, 2, BEAN_TAG);
                this.mGetPayBean = getPayBean;
                getPayBean.setmCashierData(this.mCashierData);
                this.mGetPayBean.setmReqData(str);
                this.mGetPayBean.setResponseCallback(this);
                this.mGetPayBean.execBean();
                StatisticManager.onEventWithValue(LbsStatistics.LBS_DO_PAY_CLICK, ChannelPayUtil.getChannelTag(this.mChannelId));
                return;
            }
            if (this.getPayOrderListener != null) {
                this.getPayOrderListener.complete();
            }
            GlobalUtils.toast(this.mAct, ResUtils.getString(this.mAct, "ebpay_resolve_error"));
            LBSPayResult.payResult(this.mAct, 2, "");
        } catch (Exception unused) {
            LBSPayResult.payResult(this.mAct, 2, "");
        }
    }

    public void doPay(GetPayContent getPayContent) {
        Activity activity;
        IChannelPay iChannelPay = this.mChannelPay;
        if (iChannelPay != null) {
            if ((iChannelPay instanceof ChannelAliPay) && (activity = this.mAlipayActivity) != null) {
                iChannelPay.pay(this.mAct, activity, getPayContent);
                return;
            }
            IChannelPay iChannelPay2 = this.mChannelPay;
            if ((iChannelPay2 instanceof ChannelFastPay) && TextUtils.isEmpty(((ChannelFastPay) iChannelPay2).getUrl(getPayContent))) {
                this.mChannelPay.payCancel();
                return;
            } else {
                this.mChannelPay.pay(this.mAct, getPayContent);
                return;
            }
        }
        LBSPayResult.payResult(this.mAct, 2, "");
        GlobalUtils.toast(this.mAct, "暂不支持这种支付方式");
    }

    public void getUnionPayResult(Bundle bundle) {
        if (bundle != null) {
            String string = bundle.getString(WalletPayResultActivityConfig.PAY_RESULT);
            LogUtil.logd("result =" + string);
            if (TextUtils.isEmpty(string)) {
                return;
            }
            if (string.equalsIgnoreCase("success")) {
                IChannelPay iChannelPay = this.mChannelPay;
                if (iChannelPay != null) {
                    iChannelPay.paySuccess("");
                }
            } else if (string.equalsIgnoreCase(QueryResponse.Options.CANCEL)) {
                IChannelPay iChannelPay2 = this.mChannelPay;
                if (iChannelPay2 != null) {
                    iChannelPay2.payCancel();
                }
            } else {
                string.equalsIgnoreCase(e.f1969a);
            }
        }
    }

    @Override // com.baidu.apollon.beans.IBeanResponseCallback
    public void onBeanExecFailure(final int i, final int i2, final String str) {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.baidu.android.lbspay.view.PayChannelController.2
                @Override // java.lang.Runnable
                public void run() {
                    PayChannelController.this.handleFailure(i, i2, str);
                }
            });
        }
    }

    @Override // com.baidu.apollon.beans.IBeanResponseCallback
    public void onBeanExecSuccess(final int i, final Object obj, final String str) {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.baidu.android.lbspay.view.PayChannelController.1
                @Override // java.lang.Runnable
                public void run() {
                    PayChannelController.this.handlerResponse(i, obj, str);
                }
            });
        }
    }

    public PayChannelController(Activity activity, Activity activity2) {
        this.mAlipayActivity = null;
        this.mAct = activity;
        this.mAlipayActivity = activity2;
        this.mHandler = new Handler(activity.getMainLooper());
    }
}
