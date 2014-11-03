package com.baidu.tbadk.browser;

import android.content.Context;
import com.baidu.tbadk.core.util.bj;
import com.baidu.tbadk.core.util.bk;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements bj {
    @Override // com.baidu.tbadk.core.util.bj
    public void a(Context context, String str, String str2, boolean z, bk bkVar) {
        if (z) {
            com.baidu.tbadk.coreExtra.util.a.a(context, new d(this, context, str, str2), new e(this, bkVar), str2);
        } else {
            a.a(context, str, str2);
        }
    }
}
