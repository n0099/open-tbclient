package com.baidu.tbadk.core.util;

import android.app.Activity;
import android.content.DialogInterface;
import com.baidu.tbadk.TbadkApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bk implements DialogInterface.OnClickListener {
    private final /* synthetic */ Activity Ft;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(Activity activity) {
        this.Ft = activity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        TbadkApplication.m251getInst().notifyAppEnterBackground();
        this.Ft.finish();
    }
}
