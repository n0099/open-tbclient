package com.baidu.tbadk.core.view;

import android.view.View;
import com.baidu.tbadk.core.util.bn;
/* loaded from: classes.dex */
class aj implements bn.a {
    final /* synthetic */ ai aec;
    private final /* synthetic */ String aed;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ai aiVar, String str) {
        this.aec = aiVar;
        this.aed = str;
    }

    @Override // com.baidu.tbadk.core.util.bn.a
    public boolean z(View view) {
        Object tag = view.getTag();
        if (tag != null && this.aed.equals(tag)) {
            view.invalidate();
            return false;
        }
        return false;
    }
}
