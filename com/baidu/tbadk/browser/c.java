package com.baidu.tbadk.browser;

import android.content.Context;
import com.baidu.tbadk.core.util.bn;
import com.baidu.tbadk.core.util.bo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements bn {
    @Override // com.baidu.tbadk.core.util.bn
    public void a(Context context, String str, boolean z, bo boVar) {
        if (z) {
            com.baidu.tbadk.coreExtra.c.a.a(context, new d(this, context, str), new e(this, boVar), str);
        } else {
            a.a(context, str);
        }
    }
}
