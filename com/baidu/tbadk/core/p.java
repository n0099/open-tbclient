package com.baidu.tbadk.core;

import android.content.Context;
import com.baidu.tbadk.core.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements Runnable {
    private final /* synthetic */ AccountData Mb;
    private final /* synthetic */ Context val$context;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(AccountData accountData, Context context) {
        this.Mb = accountData;
        this.val$context = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        TbadkCoreApplication.setCurrentAccountInUI(this.Mb, this.val$context);
    }
}
