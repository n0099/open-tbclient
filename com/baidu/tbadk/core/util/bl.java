package com.baidu.tbadk.core.util;

import android.app.Activity;
import android.content.DialogInterface;
import com.baidu.tbadk.TbadkApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bl implements DialogInterface.OnClickListener {
    private final /* synthetic */ Activity Fu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(Activity activity) {
        this.Fu = activity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        TbadkApplication.m251getInst().notifyAppEnterBackground();
        this.Fu.finish();
    }
}
