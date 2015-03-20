package com.baidu.tbadk.core.util;

import android.app.Activity;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bp implements com.baidu.tbadk.core.dialog.d {
    private final /* synthetic */ Activity VF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bp(Activity activity) {
        this.VF = activity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        TbadkCoreApplication.m411getInst().notifyAppEnterBackground();
        this.VF.finish();
    }
}
