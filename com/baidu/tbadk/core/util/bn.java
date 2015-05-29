package com.baidu.tbadk.core.util;

import android.app.Activity;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bn implements com.baidu.tbadk.core.dialog.d {
    private final /* synthetic */ Activity Wo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(Activity activity) {
        this.Wo = activity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        TbadkCoreApplication.m411getInst().notifyAppEnterBackground();
        this.Wo.finish();
    }
}
