package com.baidu.tbadk.core;

import android.content.Context;
import com.baidu.tbadk.core.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements Runnable {
    private final /* synthetic */ AccountData OB;
    private final /* synthetic */ Context val$context;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(AccountData accountData, Context context) {
        this.OB = accountData;
        this.val$context = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        TbadkCoreApplication.setCurrentAccountInUI(this.OB, this.val$context);
    }
}
