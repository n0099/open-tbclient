package com.baidu.sapi2.callback;

import com.baidu.sapi2.result.QrLoginResult;
import com.baidu.sapi2.shell.result.WebAuthResult;
/* loaded from: classes2.dex */
public abstract class QrLoginCallback {
    public abstract void onFinish(QrLoginResult qrLoginResult);

    public abstract void onLocalLogin(WebAuthResult webAuthResult);
}
