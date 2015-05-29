package com.baidu.tbadk.core.view;

import android.view.View;
import com.baidu.tbadk.core.util.bs;
/* loaded from: classes.dex */
class ap implements bs {
    final /* synthetic */ ao aap;
    private final /* synthetic */ String aaq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(ao aoVar, String str) {
        this.aap = aoVar;
        this.aaq = str;
    }

    @Override // com.baidu.tbadk.core.util.bs
    public boolean m(View view) {
        Object tag = view.getTag();
        if (tag != null && this.aaq.equals(tag)) {
            view.invalidate();
            return false;
        }
        return false;
    }
}
