package com.baidu.sapi2;

import com.baidu.sapi2.callback.QrLoginCallback;
import com.baidu.sapi2.result.QrLoginResult;
import com.baidu.sapi2.shell.result.WebAuthResult;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class f extends QrLoginCallback {
    final /* synthetic */ QrLoginCallback a;
    final /* synthetic */ List b;
    final /* synthetic */ PassportSDK c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(PassportSDK passportSDK, QrLoginCallback qrLoginCallback, List list) {
        this.c = passportSDK;
        this.a = qrLoginCallback;
        this.b = list;
    }

    @Override // com.baidu.sapi2.callback.QrLoginCallback
    public void onFinish(QrLoginResult qrLoginResult) {
        this.a.onFinish(qrLoginResult);
        if (this.b.size() == 1) {
            ((WebAuthResult) this.b.get(0)).finishActivity();
            this.a.onLocalLogin((WebAuthResult) this.b.get(0));
        }
    }

    @Override // com.baidu.sapi2.callback.QrLoginCallback
    public void onLocalLogin(WebAuthResult webAuthResult) {
    }
}
