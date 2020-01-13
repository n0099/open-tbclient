package com.baidu.sapi2.callback;

import com.baidu.sapi2.result.QrLoginStatusCheckResult;
/* loaded from: classes5.dex */
public abstract class QrLoginStatusCheckCallback implements SapiCallback<QrLoginStatusCheckResult> {
    public abstract void onScanQrCodeDone(QrLoginStatusCheckResult qrLoginStatusCheckResult);
}
