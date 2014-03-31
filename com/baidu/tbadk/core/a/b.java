package com.baidu.tbadk.core.a;

import android.app.Activity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class b implements u {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
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
        k kVar;
        k kVar2;
        kVar = this.a.d;
        if (kVar != null) {
            kVar2 = this.a.d;
            kVar2.a();
        }
    }

    @Override // com.baidu.tbadk.core.a.u
    public final void a(String str, String str2) {
        boolean z;
        Activity activity;
        z = this.a.e;
        if (!z) {
            activity = this.a.b;
            TbadkApplication.a((AccountData) null, activity);
        } else {
            a aVar = this.a;
            a.b("logout_by_share");
        }
        c cVar = new c(this, str);
        cVar.setPriority(3);
        cVar.execute(new Void[0]);
    }
}
