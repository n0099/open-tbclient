package com.baidu.tbadk.core.view;

import android.view.View;
import com.baidu.tbadk.core.util.bj;
/* loaded from: classes.dex */
class w implements bj.a {
    final /* synthetic */ v afS;
    private final /* synthetic */ String afT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v vVar, String str) {
        this.afS = vVar;
        this.afT = str;
    }

    @Override // com.baidu.tbadk.core.util.bj.a
    public boolean n(View view) {
        Object tag = view.getTag();
        if (tag != null && this.afT.equals(tag)) {
            view.invalidate();
            return false;
        }
        return false;
    }
}
