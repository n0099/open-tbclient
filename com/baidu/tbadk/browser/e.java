package com.baidu.tbadk.browser;

import android.content.Context;
import com.baidu.tbadk.core.util.bj;
import com.baidu.tbadk.core.util.bk;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements bj {
    @Override // com.baidu.tbadk.core.util.bj
    public void a(Context context, String str, boolean z, bk bkVar) {
        if (z) {
            com.baidu.tbadk.coreExtra.c.a.a(context, new f(this, context, str), new g(this, bkVar), str);
        } else {
            a.a(context, str);
        }
    }
}
