package com.baidu.sapi2;

import com.baidu.sapi2.share.m;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.enums.AccountType;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class e extends m.a {
    final /* synthetic */ PassportSDK a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(PassportSDK passportSDK) {
        this.a = passportSDK;
    }

    @Override // com.baidu.sapi2.share.m.a
    public void onFailed(int i, String str) {
        WebAuthListener webAuthListener;
        WebAuthListener webAuthListener2;
        super.onFailed(i, str);
        WebAuthResult webAuthResult = new WebAuthResult();
        webAuthResult.setResultCode(i);
        webAuthResult.setResultMsg(str);
        webAuthListener = this.a.d;
        if (webAuthListener != null) {
            webAuthListener2 = this.a.d;
            webAuthListener2.onFailure(webAuthResult);
        }
        PassportSDK.getInstance().release();
    }

    @Override // com.baidu.sapi2.share.m.a
    public void onSuccess() {
        WebAuthListener webAuthListener;
        WebAuthListener webAuthListener2;
        WebAuthResult webAuthResult = new WebAuthResult();
        webAuthResult.accountType = AccountType.NORMAL;
        webAuthResult.setResultCode(0);
        webAuthListener = this.a.d;
        if (webAuthListener != null) {
            webAuthListener2 = this.a.d;
            webAuthListener2.onSuccess(webAuthResult);
        }
        PassportSDK.getInstance().release();
    }
}
