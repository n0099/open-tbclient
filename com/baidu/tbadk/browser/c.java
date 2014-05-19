package com.baidu.tbadk.browser;

import android.content.Context;
import com.baidu.tbadk.core.util.bl;
import com.baidu.tbadk.core.util.bm;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements bl {
    @Override // com.baidu.tbadk.core.util.bl
    public void a(Context context, String str, boolean z, bm bmVar) {
        if (z) {
            com.baidu.tbadk.coreExtra.c.a.a(context, new d(this, context, str), new e(this, bmVar), str);
        } else {
            a.a(context, str);
        }
    }
}
