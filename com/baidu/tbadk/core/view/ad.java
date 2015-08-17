package com.baidu.tbadk.core.view;

import android.view.View;
import com.baidu.tbadk.core.util.bb;
/* loaded from: classes.dex */
class ad implements bb.a {
    final /* synthetic */ ac afs;
    private final /* synthetic */ String aft;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ac acVar, String str) {
        this.afs = acVar;
        this.aft = str;
    }

    @Override // com.baidu.tbadk.core.util.bb.a
    public boolean n(View view) {
        Object tag = view.getTag();
        if (tag != null && this.aft.equals(tag)) {
            view.invalidate();
            return false;
        }
        return false;
    }
}
