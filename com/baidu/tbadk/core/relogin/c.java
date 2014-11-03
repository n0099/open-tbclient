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
    final /* synthetic */ ReloginManager BY;
    private final /* synthetic */ g BZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ReloginManager reloginManager, g gVar) {
        this.BY = reloginManager;
        this.BZ = gVar;
    }

    @Override // com.baidu.sapi2.shell.callback.SapiCallBack
    public void onSuccess(SapiResponse sapiResponse) {
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            f.a(session.username, session.bduss, session.ptoken, this.BZ);
            return;
        }
        this.BY.d(TbadkApplication.getCurrentAccountObj());
    }

    @Override // com.baidu.sapi2.shell.callback.SapiCallBack
    public void onNetworkFailed() {
    }

    @Override // com.baidu.sapi2.shell.callback.SapiCallBack
    public void onSystemError(int i) {
        this.BY.d(TbadkApplication.getCurrentAccountObj());
    }
}
