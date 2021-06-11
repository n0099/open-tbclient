package com.baidu.android.lbspay.channelpay.alipay;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import com.baidu.android.lbspay.LBSPayResult;
import com.baidu.android.lbspay.channelpay.IChannelPay;
import com.baidu.wallet.core.NoProguard;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.EventAlias;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class LBSPayAli implements NoProguard {
    public static final String ALI_AUTH_PAY = "authorize_pay";
    public static final String ALI_AUTH_SIGN = "authorize_sign";
    public static final String ALI_DEFAULT = "authorize_default";
    public static final String AUTHPAY_CANCEL_HOST = "BdwPolymerCancelPayNotifyHost";
    public static final String AUTHPAY_SUCCESS_HOST = "BdwPolymerSuccessPayNotifyHost";
    public IChannelPay mChannelPay;
    public String mServiceType;

    /* loaded from: classes.dex */
    public interface INoSupportAliAuthorizePay {
        void onNoSupportAliAuthorizePay();
    }

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static LBSPayAli f2661a = new LBSPayAli();
    }

    public static LBSPayAli getInstance() {
        return a.f2661a;
    }

    private void handleError() {
        if (ALI_AUTH_PAY.equals(this.mServiceType)) {
            IChannelPay iChannelPay = this.mChannelPay;
            if (iChannelPay != null) {
                iChannelPay.payCancel();
            } else {
                LBSPayResult.payResult(null, 2, "");
            }
        } else if (ALI_AUTH_SIGN.equals(this.mServiceType)) {
            LBSPayResult.payResult(null, 2, "");
        }
        setServiceType(ALI_DEFAULT);
    }

    private void setServiceType(String str) {
        this.mServiceType = str;
    }

    public boolean aliAuthorizePay(Activity activity, String str, IChannelPay iChannelPay) {
        boolean startAliActicity = startAliActicity(activity, ALI_AUTH_PAY, str);
        if (startAliActicity) {
            this.mChannelPay = iChannelPay;
        }
        return startAliActicity;
    }

    public boolean aliAuthorizeSign(Activity activity, String str) {
        return startAliActicity(activity, ALI_AUTH_SIGN, str);
    }

    public void clearChannelPay() {
        this.mChannelPay = null;
    }

    public boolean finishAuthPay(Intent intent) {
        if (intent == null) {
            handleError();
            return false;
        }
        Uri data = intent.getData();
        if (data == null) {
            handleError();
            return false;
        }
        String host = data.getHost();
        if (host == null) {
            handleError();
            return false;
        }
        if (ALI_AUTH_PAY.equals(this.mServiceType)) {
            if (this.mChannelPay != null) {
                if (AUTHPAY_SUCCESS_HOST.equals(host)) {
                    if ("T".equals(data.getQueryParameter("is_success")) && "TRADE_SUCCESS".equals(data.getQueryParameter("trade_status"))) {
                        this.mChannelPay.paySuccess(data.getQuery());
                    } else {
                        this.mChannelPay.payError(Result.RESULT_FAILED, EventAlias.PayEventAlias.PAY_FAIL);
                    }
                } else if (AUTHPAY_CANCEL_HOST.equals(host)) {
                    this.mChannelPay.payCancel();
                } else {
                    this.mChannelPay.payCancel();
                }
            } else {
                handleError();
                return false;
            }
        } else if (ALI_AUTH_SIGN.equals(this.mServiceType)) {
            if (AUTHPAY_SUCCESS_HOST.equals(host)) {
                if ("T".equals(data.getQueryParameter("is_success"))) {
                    LBSPayResult.payResult(null, 0, data.getQuery());
                } else {
                    LBSPayResult.payResult(null, 2, data.getQuery());
                }
            } else if (AUTHPAY_CANCEL_HOST.equals(host)) {
                LBSPayResult.payResult(null, 2, "");
            } else {
                LBSPayResult.payResult(null, 2, "");
            }
        }
        setServiceType(ALI_DEFAULT);
        return true;
    }

    public boolean isAppInstalled(Activity activity, String str) {
        List<PackageInfo> installedPackages = activity.getPackageManager().getInstalledPackages(0);
        ArrayList arrayList = new ArrayList();
        if (installedPackages != null) {
            for (int i2 = 0; i2 < installedPackages.size(); i2++) {
                arrayList.add(installedPackages.get(i2).packageName);
            }
        }
        return arrayList.contains(str);
    }

    public boolean startAliActicity(Activity activity, String str, String str2) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str2));
        if (intent.resolveActivity(activity.getPackageManager()) == null) {
            return false;
        }
        setServiceType(str);
        activity.startActivity(intent);
        return true;
    }

    public LBSPayAli() {
        this.mChannelPay = null;
        this.mServiceType = ALI_DEFAULT;
    }
}
