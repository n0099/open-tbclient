package com.baidu.tbadk.core.view;

import android.view.View;
import com.baidu.tbadk.core.util.bl;
/* loaded from: classes.dex */
class aj implements bl.a {
    final /* synthetic */ ai adE;
    private final /* synthetic */ String adF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ai aiVar, String str) {
        this.adE = aiVar;
        this.adF = str;
    }

    @Override // com.baidu.tbadk.core.util.bl.a
    public boolean A(View view) {
        Object tag = view.getTag();
        if (tag != null && this.adF.equals(tag)) {
            view.invalidate();
            return false;
        }
        return false;
    }
}
