package com.baidu.tbadk.core.view;

import android.view.View;
import com.baidu.tbadk.core.util.bd;
/* loaded from: classes.dex */
class v implements bd.a {
    final /* synthetic */ u aeV;
    private final /* synthetic */ String aeW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar, String str) {
        this.aeV = uVar;
        this.aeW = str;
    }

    @Override // com.baidu.tbadk.core.util.bd.a
    public boolean n(View view) {
        Object tag = view.getTag();
        if (tag != null && this.aeW.equals(tag)) {
            view.invalidate();
            return false;
        }
        return false;
    }
}
