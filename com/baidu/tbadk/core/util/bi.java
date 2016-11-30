package com.baidu.tbadk.core.util;

import android.app.Activity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bi implements a.b {
    private final /* synthetic */ Activity Mk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(Activity activity) {
        this.Mk = activity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        TbadkCoreApplication.m9getInst().notifyAppEnterBackground();
        this.Mk.finish();
    }
}
