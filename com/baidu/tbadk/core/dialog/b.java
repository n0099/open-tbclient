package com.baidu.tbadk.core.dialog;

import android.view.View;
import android.widget.EditText;
import com.baidu.tbadk.core.util.bc;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
class b implements bc.a {
    final /* synthetic */ a WG;
    private final /* synthetic */ AtomicBoolean WH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, AtomicBoolean atomicBoolean) {
        this.WG = aVar;
        this.WH = atomicBoolean;
    }

    @Override // com.baidu.tbadk.core.util.bc.a
    public boolean n(View view) {
        if (view instanceof EditText) {
            this.WH.set(true);
            return true;
        }
        return false;
    }
}
