package com.baidu.tbadk.core.util;

import android.app.Activity;
import android.content.DialogInterface;
import com.baidu.tbadk.TbadkApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bl implements DialogInterface.OnClickListener {
    private final /* synthetic */ Activity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(Activity activity) {
        this.a = activity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        TbadkApplication.j().r();
        com.baidu.tbadk.core.log.a.b();
        TbadkApplication.j().w();
        this.a.finish();
    }
}
