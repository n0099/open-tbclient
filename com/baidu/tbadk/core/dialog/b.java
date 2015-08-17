package com.baidu.tbadk.core.dialog;

import android.view.View;
import android.widget.EditText;
import com.baidu.tbadk.core.util.bb;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
class b implements bb.a {
    final /* synthetic */ a WF;
    private final /* synthetic */ AtomicBoolean WG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, AtomicBoolean atomicBoolean) {
        this.WF = aVar;
        this.WG = atomicBoolean;
    }

    @Override // com.baidu.tbadk.core.util.bb.a
    public boolean n(View view) {
        if (view instanceof EditText) {
            this.WG.set(true);
            return true;
        }
        return false;
    }
}
