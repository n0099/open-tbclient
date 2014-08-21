package com.baidu.tbadk.browser;

import android.content.Context;
import com.baidu.tbadk.core.util.bj;
import com.baidu.tbadk.core.util.bk;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements bj {
    @Override // com.baidu.tbadk.core.util.bj
    public void a(Context context, String str, boolean z, bk bkVar) {
        if (z) {
            com.baidu.tbadk.coreExtra.c.a.a(context, new d(this, context, str), new e(this, bkVar), str);
        } else {
            a.a(context, str);
        }
    }
}
