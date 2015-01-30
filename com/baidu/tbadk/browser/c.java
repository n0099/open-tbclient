package com.baidu.tbadk.browser;

import android.content.Context;
import com.baidu.tbadk.core.util.bp;
import com.baidu.tbadk.core.util.bq;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements bp {
    @Override // com.baidu.tbadk.core.util.bp
    public void a(Context context, String str, String str2, boolean z, bq bqVar) {
        if (z) {
            com.baidu.tbadk.coreExtra.util.a.a(context, new d(this, context, str, str2), new e(this, bqVar), str2);
        } else {
            a.f(context, str, str2);
        }
    }
}
