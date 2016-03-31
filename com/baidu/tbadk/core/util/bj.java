package com.baidu.tbadk.core.util;

import android.app.Activity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bj implements a.b {
    private final /* synthetic */ Activity Pg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(Activity activity) {
        this.Pg = activity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        TbadkCoreApplication.m411getInst().notifyAppEnterBackground();
        this.Pg.finish();
    }
}
