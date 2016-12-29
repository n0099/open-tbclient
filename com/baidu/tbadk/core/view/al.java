package com.baidu.tbadk.core.view;

import android.view.View;
import com.baidu.tbadk.core.util.bh;
/* loaded from: classes.dex */
class al implements bh.a {
    final /* synthetic */ ak ahu;
    private final /* synthetic */ String ahv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ak akVar, String str) {
        this.ahu = akVar;
        this.ahv = str;
    }

    @Override // com.baidu.tbadk.core.util.bh.a
    public boolean A(View view) {
        Object tag = view.getTag();
        if (tag != null && this.ahv.equals(tag)) {
            view.invalidate();
            return false;
        }
        return false;
    }
}
