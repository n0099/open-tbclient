package com.baidu.tbadk.core.view;

import android.view.View;
import com.baidu.tbadk.core.util.bk;
/* loaded from: classes.dex */
class aj implements bk.a {
    final /* synthetic */ ai ahT;
    private final /* synthetic */ String ahU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ai aiVar, String str) {
        this.ahT = aiVar;
        this.ahU = str;
    }

    @Override // com.baidu.tbadk.core.util.bk.a
    public boolean A(View view) {
        Object tag = view.getTag();
        if (tag != null && this.ahU.equals(tag)) {
            view.invalidate();
            return false;
        }
        return false;
    }
}
