package com.baidu.android.lbspay.channelpay.wxpay;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.android.lbspay.channelpay.AbstractChannelPay;
import com.baidu.android.lbspay.channelpay.PayDataBean;
import com.baidu.android.lbspay.network.GetPayContent;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.ResUtils;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.modelpay.PayResp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
/* loaded from: classes.dex */
public class ChannelWXPay extends AbstractChannelPay {
    public static final int WX_PAY_CANCLE = -2;
    public static final int WX_PAY_FAILED = -1;
    public static final int WX_PAY_SUCCESS = 0;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static ChannelWXPay f2647a = new ChannelWXPay();
    }

    private PayReq genPayReq(PayDataBean payDataBean) {
        PayReq payReq = new PayReq();
        payReq.appId = payDataBean.appid;
        payReq.partnerId = payDataBean.partnerid;
        payReq.prepayId = payDataBean.prepayid;
        payReq.packageValue = payDataBean.packagealias;
        payReq.nonceStr = payDataBean.noncestr;
        payReq.timeStamp = payDataBean.timestamp;
        payReq.sign = payDataBean.sign;
        return payReq;
    }

    public static ChannelWXPay getInstance() {
        return a.f2647a;
    }

    @Override // com.baidu.android.lbspay.channelpay.IChannelPay
    public int getChannelId() {
        return 158;
    }

    public void handlerPayResult(Context context, BaseResp baseResp) {
        if (baseResp == null) {
            GlobalUtils.toast(context, "微信返回失败");
            payCancel();
            return;
        }
        int i = baseResp.errCode;
        String str = "";
        if (i == 0) {
            paySuccess("");
        } else if (i == -1) {
            try {
                str = String.valueOf(i);
            } catch (Exception unused) {
            }
            payError(str, baseResp.errStr);
        } else if (i == -2) {
            payCancel();
        }
    }

    public void handlerPayResultBundle(Context context, Bundle bundle) {
        if (bundle != null) {
            handlerPayResult(context, new PayResp(bundle));
        }
    }

    @Override // com.baidu.android.lbspay.channelpay.AbstractChannelPay, com.baidu.android.lbspay.channelpay.IChannelPay
    public void pay(Activity activity, GetPayContent getPayContent) {
        super.pay(activity, getPayContent);
        PayDataBean payData = getPayData(getPayContent);
        PayReq genPayReq = payData != null ? genPayReq(payData) : null;
        if (genPayReq != null && !TextUtils.isEmpty(genPayReq.appId)) {
            IWXAPI createWXAPI = WXAPIFactory.createWXAPI(activity, null);
            if (createWXAPI == null) {
                payError("-1", ResUtils.getString(activity, "lbspay_wx_start_failed"));
                return;
            }
            createWXAPI.registerApp(genPayReq.appId);
            if (createWXAPI.isWXAppInstalled()) {
                if (createWXAPI.sendReq(genPayReq)) {
                    return;
                }
                payError("-1", ResUtils.getString(activity, "lbspay_wx_start_failed"));
                return;
            }
            payError("-1", ResUtils.getString(activity, "lbspay_wx_not_installed"));
            return;
        }
        payError("-1", ResUtils.getString(activity, "lbspay_wx_getpay_failed"));
    }

    public ChannelWXPay() {
    }
}
