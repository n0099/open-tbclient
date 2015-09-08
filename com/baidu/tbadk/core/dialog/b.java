package com.baidu.tbadk.core.dialog;

import android.view.View;
import android.widget.EditText;
import com.baidu.tbadk.core.util.bb;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
class b implements bb.a {
    final /* synthetic */ a WO;
    private final /* synthetic */ AtomicBoolean WP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, AtomicBoolean atomicBoolean) {
        this.WO = aVar;
        this.WP = atomicBoolean;
    }

    @Override // com.baidu.tbadk.core.util.bb.a
    public boolean n(View view) {
        if (view instanceof EditText) {
            this.WP.set(true);
            return true;
        }
        return false;
    }
}
