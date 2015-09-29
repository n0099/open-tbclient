package com.baidu.tbadk.core.view;

import android.view.View;
import com.baidu.tbadk.core.util.bc;
/* loaded from: classes.dex */
class v implements bc.a {
    final /* synthetic */ u aeP;
    private final /* synthetic */ String aeQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar, String str) {
        this.aeP = uVar;
        this.aeQ = str;
    }

    @Override // com.baidu.tbadk.core.util.bc.a
    public boolean n(View view) {
        Object tag = view.getTag();
        if (tag != null && this.aeQ.equals(tag)) {
            view.invalidate();
            return false;
        }
        return false;
    }
}
