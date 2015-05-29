package com.baidu.tbadk.core;

import android.content.Context;
import com.baidu.tbadk.core.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements Runnable {
    private final /* synthetic */ AccountData Pa;
    private final /* synthetic */ Context val$context;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(AccountData accountData, Context context) {
        this.Pa = accountData;
        this.val$context = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        TbadkCoreApplication.setCurrentAccountInUI(this.Pa, this.val$context);
    }
}
