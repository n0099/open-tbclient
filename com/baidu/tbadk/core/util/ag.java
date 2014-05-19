package com.baidu.tbadk.core.util;

import android.view.View;
/* loaded from: classes.dex */
class ag implements br {
    final /* synthetic */ af a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(af afVar, String str) {
        this.a = afVar;
        this.b = str;
    }

    @Override // com.baidu.tbadk.core.util.br
    public boolean a(View view) {
        if (this.b.equals(view.getTag())) {
            view.invalidate();
            return false;
        }
        return false;
    }
}
