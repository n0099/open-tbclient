package com.baidu.tbadk.core.a;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.ak;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class v extends BdAsyncTask<String, Integer, AccountData> {
    private volatile ak a = null;
    private final String b;
    private final String c;
    private final String d;
    private final u e;
    private final boolean f;
    private final boolean g;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ AccountData a(String... strArr) {
        return a();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(AccountData accountData) {
        AccountData accountData2 = accountData;
        super.a((v) accountData2);
        if (accountData2 != null) {
            this.e.a(accountData2);
            return;
        }
        String f = this.a != null ? this.a.f() : null;
        if (f == null) {
            f = TbadkApplication.j().b().getResources().getString(com.baidu.tbadk.l.data_load_error);
        }
        this.e.a(this.b, f);
    }

    public v(String str, String str2, String str3, u uVar, boolean z, boolean z2) {
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.f = z;
        this.g = z2;
        this.e = uVar == null ? new w(this) : uVar;
        setPriority(3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void c() {
        this.e.a(this.b);
    }

    private AccountData a() {
        AccountData accountData;
        n a;
        long nanoTime = System.nanoTime();
        this.a = new ak(String.valueOf(com.baidu.tbadk.core.data.n.a) + "c/s/login");
        this.a.a("bdusstoken", String.valueOf(this.c) + "|" + this.d);
        this.a.a("channel_id", TbadkApplication.j().S());
        this.a.a("channel_uid", TbadkApplication.j().R());
        this.a.a().a().b = false;
        String i = this.a.i();
        com.baidu.adp.lib.util.f.e("simon", "ReLoginModel", i);
        if (this.a.a().b().b()) {
            com.baidu.tbadk.core.data.h hVar = new com.baidu.tbadk.core.data.h();
            hVar.a(i);
            AccountData accountData2 = new AccountData();
            accountData2.setAccount(hVar.a().getUserName());
            accountData2.setPassword("");
            accountData2.setID(hVar.a().getUserId());
            String bduss = hVar.a().getBDUSS();
            if (this.g && (a = x.a(a.a(bduss))) != null) {
                bduss = String.valueOf(a.a) + "|" + a.b;
            }
            accountData2.setBDUSS(bduss);
            accountData2.setPortrait(hVar.a().getPortrait());
            accountData2.setIsActive(1);
            if (hVar.b() != null) {
                accountData2.setTbs(hVar.b().getTbs());
                accountData = accountData2;
            } else {
                accountData = accountData2;
            }
        } else {
            com.baidu.adp.lib.util.f.e(getClass().getName(), "doInBackground", "reLogin fail");
            accountData = null;
        }
        if (this.f) {
            long nanoTime2 = 2000 - ((System.nanoTime() - nanoTime) / 1000000);
            if (nanoTime2 > 0 && nanoTime2 < 2000) {
                try {
                    Thread.sleep(nanoTime2);
                } catch (InterruptedException e) {
                }
            }
        }
        return accountData;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        super.cancel(true);
        if (this.a != null) {
            this.a.g();
        }
    }
}
