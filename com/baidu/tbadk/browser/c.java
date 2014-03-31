package com.baidu.tbadk.browser;

import android.app.AlertDialog;
import android.content.Context;
import com.baidu.tbadk.core.util.bj;
import com.baidu.tbadk.core.util.bk;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c implements bj {
    @Override // com.baidu.tbadk.core.util.bj
    public final void a(Context context, String str, boolean z, bk bkVar) {
        if (z) {
            new AlertDialog.Builder(context).setTitle(com.baidu.tbadk.l.del_post_tip).setMessage(String.format(context.getString(com.baidu.tbadk.l.url_notify), str)).setPositiveButton(com.baidu.tbadk.l.alert_yes_button, new d(this, context, str)).setNegativeButton(com.baidu.tbadk.l.alert_no_button, new e(this, bkVar)).create().show();
            return;
        }
        a.a(context, str);
    }
}
