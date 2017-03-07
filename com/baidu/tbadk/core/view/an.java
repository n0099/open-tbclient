package com.baidu.tbadk.core.view;

import android.view.View;
import com.baidu.tbadk.core.util.bg;
/* loaded from: classes.dex */
class an implements bg.a {
    final /* synthetic */ am ama;
    private final /* synthetic */ String amb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(am amVar, String str) {
        this.ama = amVar;
        this.amb = str;
    }

    @Override // com.baidu.tbadk.core.util.bg.a
    public boolean w(View view) {
        Object tag = view.getTag();
        if (tag != null && this.amb.equals(tag)) {
            view.invalidate();
            return false;
        }
        return false;
    }
}
