package com.baidu.tbadk.core.a;

import android.app.Activity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.bc;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class h implements u {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar) {
        this.a = aVar;
    }

    @Override // com.baidu.tbadk.core.a.u
    public final void a(String str) {
        k kVar;
        k unused;
        kVar = this.a.d;
        if (kVar != null) {
            unused = this.a.d;
        }
    }

    @Override // com.baidu.tbadk.core.a.u
    public final void a(AccountData accountData) {
        Activity activity;
        Activity activity2;
        k kVar;
        k kVar2;
        activity = this.a.b;
        TbadkApplication.a(accountData, activity);
        activity2 = this.a.b;
        if (activity2 != null) {
            TbadkApplication.j();
            TbadkApplication.M();
            com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2006001, "stop"));
            com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2006001, "start"));
            kVar = this.a.d;
            if (kVar != null) {
                kVar2 = this.a.d;
                kVar2.a();
            }
        }
        new i(this, accountData).execute(new Void[0]);
    }

    @Override // com.baidu.tbadk.core.a.u
    public final void a(String str, String str2) {
        int i;
        ArrayList arrayList;
        r rVar;
        AccountData a = a.a(this.a, str);
        if (a == null || bc.c(a.getPassword())) {
            i = this.a.g;
            arrayList = this.a.f;
            if (i >= arrayList.size()) {
                a.k(this.a);
                return;
            } else {
                this.a.b();
                return;
            }
        }
        String account = a.getAccount();
        String password = a.getPassword();
        rVar = this.a.j;
        q.a(account, password, rVar);
    }
}
