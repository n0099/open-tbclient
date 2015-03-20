package com.baidu.tbadk.core.view;

import android.view.View;
import com.baidu.tbadk.core.util.bu;
/* loaded from: classes.dex */
class ak implements bu {
    final /* synthetic */ aj Zm;
    private final /* synthetic */ String Zn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(aj ajVar, String str) {
        this.Zm = ajVar;
        this.Zn = str;
    }

    @Override // com.baidu.tbadk.core.util.bu
    public boolean k(View view) {
        Object tag = view.getTag();
        if (tag != null && this.Zn.equals(tag)) {
            view.invalidate();
            return false;
        }
        return false;
    }
}
