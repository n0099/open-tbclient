package com.baidu.tbadk.core.relogin;

import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.shell.callback.SapiCallBack;
import com.baidu.sapi2.shell.response.SapiResponse;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.account.f;
import com.baidu.tbadk.core.account.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements SapiCallBack<SapiResponse> {
    final /* synthetic */ ReloginManager Gj;
    private final /* synthetic */ g Gk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ReloginManager reloginManager, g gVar) {
        this.Gj = reloginManager;
        this.Gk = gVar;
    }

    @Override // com.baidu.sapi2.shell.callback.SapiCallBack
    public void onSuccess(SapiResponse sapiResponse) {
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            f.a(session.username, session.bduss, session.ptoken, this.Gk);
            return;
        }
        this.Gj.d(TbadkCoreApplication.getCurrentAccountObj());
    }

    @Override // com.baidu.sapi2.shell.callback.SapiCallBack
    public void onNetworkFailed() {
    }

    @Override // com.baidu.sapi2.shell.callback.SapiCallBack
    public void onSystemError(int i) {
        this.Gj.d(TbadkCoreApplication.getCurrentAccountObj());
    }
}
