package com.baidu.tbadk.core.view;

import android.view.View;
import com.baidu.tbadk.core.util.bm;
/* loaded from: classes.dex */
class ai implements bm.a {
    final /* synthetic */ ah aht;
    private final /* synthetic */ String ahu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ah ahVar, String str) {
        this.aht = ahVar;
        this.ahu = str;
    }

    @Override // com.baidu.tbadk.core.util.bm.a
    public boolean A(View view) {
        Object tag = view.getTag();
        if (tag != null && this.ahu.equals(tag)) {
            view.invalidate();
            return false;
        }
        return false;
    }
}
