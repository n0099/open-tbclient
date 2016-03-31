package com.baidu.tbadk.core.view;

import android.view.View;
import com.baidu.tbadk.core.util.bl;
/* loaded from: classes.dex */
class ah implements bl.a {
    final /* synthetic */ ag ahK;
    private final /* synthetic */ String ahL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(ag agVar, String str) {
        this.ahK = agVar;
        this.ahL = str;
    }

    @Override // com.baidu.tbadk.core.util.bl.a
    public boolean A(View view) {
        Object tag = view.getTag();
        if (tag != null && this.ahL.equals(tag)) {
            view.invalidate();
            return false;
        }
        return false;
    }
}
