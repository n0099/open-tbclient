package com.baidu.tbadk.core.util;

import android.app.Activity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bl implements a.b {
    private final /* synthetic */ Activity JW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(Activity activity) {
        this.JW = activity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        TbadkCoreApplication.m10getInst().notifyAppEnterBackground();
        this.JW.finish();
    }
}
