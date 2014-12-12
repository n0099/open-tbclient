package com.baidu.tbadk.core.view;

import android.view.View;
import com.baidu.tbadk.core.util.br;
/* loaded from: classes.dex */
class an implements br {
    final /* synthetic */ am NE;
    private final /* synthetic */ String val$imageUrl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(am amVar, String str) {
        this.NE = amVar;
        this.val$imageUrl = str;
    }

    @Override // com.baidu.tbadk.core.util.br
    public boolean k(View view) {
        Object tag = view.getTag();
        if (tag != null && this.val$imageUrl.equals(tag)) {
            view.invalidate();
            return false;
        }
        return false;
    }
}
