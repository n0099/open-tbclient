package com.baidu.tbadk.core.view;

import android.view.View;
import com.baidu.tbadk.core.util.br;
/* loaded from: classes.dex */
class x implements br {
    final /* synthetic */ w a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(w wVar, String str) {
        this.a = wVar;
        this.b = str;
    }

    @Override // com.baidu.tbadk.core.util.br
    public boolean a(View view) {
        Object tag = view.getTag();
        if (tag != null && this.b.equals(tag)) {
            view.invalidate();
            return false;
        }
        return false;
    }
}
