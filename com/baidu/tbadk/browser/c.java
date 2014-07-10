package com.baidu.tbadk.browser;

import android.content.Context;
import com.baidu.tbadk.core.util.bt;
import com.baidu.tbadk.core.util.bu;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements bt {
    @Override // com.baidu.tbadk.core.util.bt
    public void a(Context context, String str, boolean z, bu buVar) {
        if (z) {
            com.baidu.tbadk.coreExtra.c.a.a(context, new d(this, context, str), new e(this, buVar), str);
        } else {
            a.a(context, str);
        }
    }
}
