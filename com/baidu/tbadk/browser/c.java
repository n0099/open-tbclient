package com.baidu.tbadk.browser;

import android.content.Context;
import com.baidu.tbadk.core.util.bk;
import com.baidu.tbadk.core.util.bl;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements bk {
    @Override // com.baidu.tbadk.core.util.bk
    public void a(Context context, String str, String str2, boolean z, bl blVar) {
        if (z) {
            com.baidu.tbadk.coreExtra.util.a.a(context, new d(this, context, str, str2), new e(this, blVar), str2);
        } else {
            a.f(context, str, str2);
        }
    }
}
