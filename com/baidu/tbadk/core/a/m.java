package com.baidu.tbadk.core.a;

import android.app.Activity;
import com.baidu.loginshare.ILoginShareListener;
import com.baidu.loginshare.LoginShareEvent;
import com.baidu.loginshare.Token;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.bc;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class m implements ILoginShareListener {
    final /* synthetic */ l a;

    private m(l lVar) {
        this.a = lVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ m(l lVar, byte b) {
        this(lVar);
    }

    @Override // com.baidu.loginshare.ILoginShareListener
    public final void onLoginShareEvent(Token token) {
        if (token != null) {
            LoginShareEvent loginShareEvent = token.mEvent;
            String str = token.mUsername;
            String str2 = token.mBduss;
            String str3 = token.mPtoken;
            if (loginShareEvent == LoginShareEvent.VALID) {
                if (str2 != null && str3 != null) {
                    com.baidu.adp.lib.util.f.e(getClass().getName(), "onLoginShareEvent", "login");
                    l lVar = this.a;
                    TbadkApplication.j().d(String.valueOf(r3 ? "1" : "2") + ":" + str2 + ":" + str3 + ":" + str);
                    return;
                }
                return;
            }
            com.baidu.adp.lib.util.f.e(getClass().getName(), "onLoginShareEvent", "logout");
            l lVar2 = this.a;
            TbadkApplication.j().d(String.valueOf(r3 ? "1" : "2") + ":" + null + ":" + null + ":" + str);
            AccountData N = TbadkApplication.N();
            n a = a.a(N.getBDUSS());
            if (N != null && !bc.c(N.getAccount()) && N.getAccount().equals(str) && a != null && !bc.c(a.a) && a.a.equals(str2)) {
                a.a().a((Activity) null, true);
                a.a();
                a.b("detect_bduss_logout");
            }
        }
    }
}
