package com.baidu.tbadk.core;

import android.content.Context;
import com.baidu.tbadk.core.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements Runnable {
    private final /* synthetic */ AccountData Tx;
    private final /* synthetic */ Context val$context;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(AccountData accountData, Context context) {
        this.Tx = accountData;
        this.val$context = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        TbadkCoreApplication.setCurrentAccountInUI(this.Tx, this.val$context);
    }
}
