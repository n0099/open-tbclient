package com.baidu.tbadk.core.view;

import android.view.View;
import com.baidu.tbadk.core.util.bp;
/* loaded from: classes.dex */
class aa implements bp {
    final /* synthetic */ z IA;
    private final /* synthetic */ String IB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(z zVar, String str) {
        this.IA = zVar;
        this.IB = str;
    }

    @Override // com.baidu.tbadk.core.util.bp
    public boolean k(View view) {
        Object tag = view.getTag();
        if (tag != null && this.IB.equals(tag)) {
            view.invalidate();
            return false;
        }
        return false;
    }
}
