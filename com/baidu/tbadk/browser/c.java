package com.baidu.tbadk.browser;

import android.content.Context;
import com.baidu.tbadk.core.util.bi;
import com.baidu.tbadk.core.util.bj;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements bi {
    @Override // com.baidu.tbadk.core.util.bi
    public void a(Context context, String str, String str2, boolean z, bj bjVar) {
        if (z) {
            com.baidu.tbadk.coreExtra.util.a.a(context, new d(this, context, str, str2), new e(this, bjVar), str2);
        } else {
            a.a(context, str, str2);
        }
    }
}
