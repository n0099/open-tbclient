package com.baidu.tbadk.core.view;

import android.view.View;
import com.baidu.tbadk.core.util.bn;
/* loaded from: classes.dex */
class ak implements bn.a {
    final /* synthetic */ aj ahL;
    private final /* synthetic */ String ahM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(aj ajVar, String str) {
        this.ahL = ajVar;
        this.ahM = str;
    }

    @Override // com.baidu.tbadk.core.util.bn.a
    public boolean A(View view) {
        Object tag = view.getTag();
        if (tag != null && this.ahM.equals(tag)) {
            view.invalidate();
            return false;
        }
        return false;
    }
}
