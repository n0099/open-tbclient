package com.baidu.tbadk.core.view;

import android.view.View;
import com.baidu.tbadk.core.util.bu;
/* loaded from: classes.dex */
class ak implements bu {
    final /* synthetic */ aj Zo;
    private final /* synthetic */ String Zp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(aj ajVar, String str) {
        this.Zo = ajVar;
        this.Zp = str;
    }

    @Override // com.baidu.tbadk.core.util.bu
    public boolean k(View view) {
        Object tag = view.getTag();
        if (tag != null && this.Zp.equals(tag)) {
            view.invalidate();
            return false;
        }
        return false;
    }
}
