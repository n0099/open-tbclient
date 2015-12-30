package com.baidu.tbadk.core.view;

import android.view.View;
import com.baidu.tbadk.core.util.bj;
/* loaded from: classes.dex */
class aa implements bj.a {
    final /* synthetic */ z agQ;
    private final /* synthetic */ String agR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(z zVar, String str) {
        this.agQ = zVar;
        this.agR = str;
    }

    @Override // com.baidu.tbadk.core.util.bj.a
    public boolean n(View view) {
        Object tag = view.getTag();
        if (tag != null && this.agR.equals(tag)) {
            view.invalidate();
            return false;
        }
        return false;
    }
}
