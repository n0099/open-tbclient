package com.baidu.tbadk.core;

import android.content.Context;
import com.baidu.tbadk.core.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements Runnable {
    private final /* synthetic */ AccountData Uq;
    private final /* synthetic */ Context val$context;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(AccountData accountData, Context context) {
        this.Uq = accountData;
        this.val$context = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        TbadkCoreApplication.setCurrentAccountInUI(this.Uq, this.val$context);
    }
}
