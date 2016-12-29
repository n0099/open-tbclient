package com.baidu.tbadk.core.util;

import android.app.Activity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bf implements a.b {
    private final /* synthetic */ Activity Mi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(Activity activity) {
        this.Mi = activity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        TbadkCoreApplication.m9getInst().notifyAppEnterBackground();
        this.Mi.finish();
    }
}
