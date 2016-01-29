package com.baidu.tbadk.core.view;

import android.view.View;
import com.baidu.tbadk.core.util.bi;
/* loaded from: classes.dex */
class aa implements bi.a {
    final /* synthetic */ z ahF;
    private final /* synthetic */ String ahG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(z zVar, String str) {
        this.ahF = zVar;
        this.ahG = str;
    }

    @Override // com.baidu.tbadk.core.util.bi.a
    public boolean A(View view) {
        Object tag = view.getTag();
        if (tag != null && this.ahG.equals(tag)) {
            view.invalidate();
            return false;
        }
        return false;
    }
}
