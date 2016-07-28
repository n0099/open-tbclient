package com.baidu.tbadk.core.view;

import android.view.View;
import com.baidu.tbadk.core.util.bn;
/* loaded from: classes.dex */
class aj implements bn.a {
    final /* synthetic */ ai aeQ;
    private final /* synthetic */ String aeR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ai aiVar, String str) {
        this.aeQ = aiVar;
        this.aeR = str;
    }

    @Override // com.baidu.tbadk.core.util.bn.a
    public boolean z(View view) {
        Object tag = view.getTag();
        if (tag != null && this.aeR.equals(tag)) {
            view.invalidate();
            return false;
        }
        return false;
    }
}
