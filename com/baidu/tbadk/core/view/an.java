package com.baidu.tbadk.core.view;

import android.view.View;
import com.baidu.tbadk.core.util.bg;
/* loaded from: classes.dex */
class an implements bg.a {
    final /* synthetic */ am amo;
    private final /* synthetic */ String amp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(am amVar, String str) {
        this.amo = amVar;
        this.amp = str;
    }

    @Override // com.baidu.tbadk.core.util.bg.a
    public boolean w(View view) {
        Object tag = view.getTag();
        if (tag != null && this.amp.equals(tag)) {
            view.invalidate();
            return false;
        }
        return false;
    }
}
