package com.baidu.tbadk.core.relogin;

import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.shell.callback.SapiCallBack;
import com.baidu.sapi2.shell.response.SapiResponse;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.account.f;
import com.baidu.tbadk.core.account.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements SapiCallBack<SapiResponse> {
    final /* synthetic */ ReloginManager BX;
    private final /* synthetic */ g BY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ReloginManager reloginManager, g gVar) {
        this.BX = reloginManager;
        this.BY = gVar;
    }

    @Override // com.baidu.sapi2.shell.callback.SapiCallBack
    public void onSuccess(SapiResponse sapiResponse) {
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            f.a(session.username, session.bduss, session.ptoken, this.BY);
            return;
        }
        this.BX.d(TbadkApplication.getCurrentAccountObj());
    }

    @Override // com.baidu.sapi2.shell.callback.SapiCallBack
    public void onNetworkFailed() {
    }

    @Override // com.baidu.sapi2.shell.callback.SapiCallBack
    public void onSystemError(int i) {
        this.BX.d(TbadkApplication.getCurrentAccountObj());
    }
}
