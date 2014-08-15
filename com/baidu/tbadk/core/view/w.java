package com.baidu.tbadk.core.view;

import android.view.View;
import com.baidu.tbadk.core.util.bq;
/* loaded from: classes.dex */
class w implements bq {
    final /* synthetic */ v a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v vVar, String str) {
        this.a = vVar;
        this.b = str;
    }

    @Override // com.baidu.tbadk.core.util.bq
    public boolean a(View view) {
        Object tag = view.getTag();
        if (tag != null && this.b.equals(tag)) {
            view.invalidate();
            return false;
        }
        return false;
    }
}
