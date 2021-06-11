package com.alipay.sdk.app;

import com.baidu.pass.ecommerce.view.SpeechRecognitionDialog;
import com.baidu.sapi2.openbduss.PASSMethodCallTransfer;
/* loaded from: classes.dex */
public enum k {
    SUCCEEDED(SpeechRecognitionDialog.REQUEST_SETTING_CODE, "处理成功"),
    FAILED(4000, "系统繁忙，请稍后再试"),
    CANCELED(6001, "用户取消"),
    NETWORK_ERROR(6002, "网络连接异常"),
    PARAMS_ERROR(4001, PASSMethodCallTransfer.DynamicCallbak.ERROR_MSG_PARAMS_ERROR),
    DOUBLE_REQUEST(5000, "重复请求"),
    PAY_WAITTING(8000, "支付结果确认中");
    

    /* renamed from: h  reason: collision with root package name */
    public int f1813h;

    /* renamed from: i  reason: collision with root package name */
    public String f1814i;

    k(int i2, String str) {
        this.f1813h = i2;
        this.f1814i = str;
    }

    public void a(int i2) {
        this.f1813h = i2;
    }

    public String b() {
        return this.f1814i;
    }

    public static k b(int i2) {
        if (i2 != 4001) {
            if (i2 != 5000) {
                if (i2 != 8000) {
                    if (i2 != 9000) {
                        if (i2 != 6001) {
                            if (i2 != 6002) {
                                return FAILED;
                            }
                            return NETWORK_ERROR;
                        }
                        return CANCELED;
                    }
                    return SUCCEEDED;
                }
                return PAY_WAITTING;
            }
            return DOUBLE_REQUEST;
        }
        return PARAMS_ERROR;
    }

    public int a() {
        return this.f1813h;
    }

    public void a(String str) {
        this.f1814i = str;
    }
}
