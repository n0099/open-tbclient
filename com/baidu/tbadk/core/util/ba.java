package com.baidu.tbadk.core.util;

import android.app.Activity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ba implements a.b {
    private final /* synthetic */ Activity abw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(Activity activity) {
        this.abw = activity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        TbadkCoreApplication.m411getInst().notifyAppEnterBackground();
        this.abw.finish();
    }
}
