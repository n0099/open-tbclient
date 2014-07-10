package com.baidu.tbadk.core.util;

import android.view.View;
/* loaded from: classes.dex */
class al implements bz {
    final /* synthetic */ ak a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ak akVar, String str) {
        this.a = akVar;
        this.b = str;
    }

    @Override // com.baidu.tbadk.core.util.bz
    public boolean a(View view) {
        if (this.b.equals(view.getTag())) {
            view.invalidate();
            return false;
        }
        return false;
    }
}
