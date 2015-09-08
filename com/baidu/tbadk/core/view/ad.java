package com.baidu.tbadk.core.view;

import android.view.View;
import com.baidu.tbadk.core.util.bb;
/* loaded from: classes.dex */
class ad implements bb.a {
    final /* synthetic */ ac afC;
    private final /* synthetic */ String afD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ac acVar, String str) {
        this.afC = acVar;
        this.afD = str;
    }

    @Override // com.baidu.tbadk.core.util.bb.a
    public boolean n(View view) {
        Object tag = view.getTag();
        if (tag != null && this.afD.equals(tag)) {
            view.invalidate();
            return false;
        }
        return false;
    }
}
