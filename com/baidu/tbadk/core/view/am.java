package com.baidu.tbadk.core.view;

import android.view.View;
import com.baidu.tbadk.core.util.bf;
/* loaded from: classes.dex */
class am implements bf.a {
    final /* synthetic */ al agH;
    private final /* synthetic */ String agI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(al alVar, String str) {
        this.agH = alVar;
        this.agI = str;
    }

    @Override // com.baidu.tbadk.core.util.bf.a
    public boolean y(View view) {
        Object tag = view.getTag();
        if (tag != null && this.agI.equals(tag)) {
            view.invalidate();
            return false;
        }
        return false;
    }
}
