package com.baidu.tbadk.core.util;

import android.app.Activity;
import android.content.DialogInterface;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bm implements DialogInterface.OnClickListener {
    private final /* synthetic */ Activity JD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(Activity activity) {
        this.JD = activity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        TbadkCoreApplication.m255getInst().notifyAppEnterBackground();
        this.JD.finish();
    }
}
