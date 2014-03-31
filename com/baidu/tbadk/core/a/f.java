package com.baidu.tbadk.core.a;

import android.app.Activity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class f implements r {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar) {
        this.a = aVar;
    }

    @Override // com.baidu.tbadk.core.a.r
    public final void a(AccountData accountData) {
        boolean z;
        Activity activity;
        k kVar;
        k kVar2;
        z = this.a.e;
        if (z) {
            a aVar = this.a;
            a.b("login_after_shareout_by_up");
        }
        activity = this.a.b;
        TbadkApplication.a(accountData, activity);
        new g(this, accountData).execute(new Void[0]);
        kVar = this.a.d;
        if (kVar != null) {
            kVar2 = this.a.d;
            kVar2.a();
        }
    }

    @Override // com.baidu.tbadk.core.a.r
    public final void a() {
        this.a.b();
    }
}
