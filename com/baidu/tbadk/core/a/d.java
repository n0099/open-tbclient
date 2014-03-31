package com.baidu.tbadk.core.a;

import android.app.Activity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class d implements r {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.a = aVar;
    }

    @Override // com.baidu.tbadk.core.a.r
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
        new e(this, accountData).execute(new Void[0]);
    }

    @Override // com.baidu.tbadk.core.a.r
    public final void a() {
        boolean z;
        Activity activity;
        int i;
        z = this.a.h;
        if (!z) {
            a aVar = this.a;
            activity = this.a.b;
            i = this.a.c;
            aVar.a(activity, i);
        }
    }
}
