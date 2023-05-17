package com.baidu.sapi2.callback;

import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.result.QrLoginStatusCheckResult;
/* loaded from: classes3.dex */
public abstract class QrLoginStatusCheckCallback implements SapiCallback<QrLoginStatusCheckResult>, NoProguard {
    public abstract void onScanQrCodeDone(QrLoginStatusCheckResult qrLoginStatusCheckResult);
}
