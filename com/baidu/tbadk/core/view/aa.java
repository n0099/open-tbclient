package com.baidu.tbadk.core.view;

import android.view.View;
import com.baidu.tbadk.core.util.bq;
/* loaded from: classes.dex */
class aa implements bq {
    final /* synthetic */ z IB;
    private final /* synthetic */ String IC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(z zVar, String str) {
        this.IB = zVar;
        this.IC = str;
    }

    @Override // com.baidu.tbadk.core.util.bq
    public boolean k(View view) {
        Object tag = view.getTag();
        if (tag != null && this.IC.equals(tag)) {
            view.invalidate();
            return false;
        }
        return false;
    }
}
