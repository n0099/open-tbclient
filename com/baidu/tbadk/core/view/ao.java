package com.baidu.tbadk.core.view;

import android.view.View;
import com.baidu.tbadk.core.util.bw;
/* loaded from: classes.dex */
class ao implements bw {
    final /* synthetic */ an Oe;
    private final /* synthetic */ String Of;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(an anVar, String str) {
        this.Oe = anVar;
        this.Of = str;
    }

    @Override // com.baidu.tbadk.core.util.bw
    public boolean k(View view) {
        Object tag = view.getTag();
        if (tag != null && this.Of.equals(tag)) {
            view.invalidate();
            return false;
        }
        return false;
    }
}
