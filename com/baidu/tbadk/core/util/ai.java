package com.baidu.tbadk.core.util;

import android.view.View;
/* loaded from: classes.dex */
class ai implements bt {
    final /* synthetic */ ah a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ah ahVar, String str) {
        this.a = ahVar;
        this.b = str;
    }

    @Override // com.baidu.tbadk.core.util.bt
    public boolean a(View view) {
        if (this.b.equals(view.getTag())) {
            view.invalidate();
            return false;
        }
        return false;
    }
}
