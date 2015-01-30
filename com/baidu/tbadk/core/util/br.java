package com.baidu.tbadk.core.util;

import android.app.Activity;
import android.content.DialogInterface;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class br implements DialogInterface.OnClickListener {
    private final /* synthetic */ Activity JW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public br(Activity activity) {
        this.JW = activity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        TbadkCoreApplication.m255getInst().notifyAppEnterBackground();
        this.JW.finish();
    }
}
