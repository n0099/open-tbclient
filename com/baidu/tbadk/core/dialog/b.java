package com.baidu.tbadk.core.dialog;

import android.view.View;
import android.widget.EditText;
import com.baidu.tbadk.core.util.bu;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
class b implements bu {
    final /* synthetic */ a Ro;
    private final /* synthetic */ AtomicBoolean Rp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, AtomicBoolean atomicBoolean) {
        this.Ro = aVar;
        this.Rp = atomicBoolean;
    }

    @Override // com.baidu.tbadk.core.util.bu
    public boolean k(View view) {
        if (view instanceof EditText) {
            this.Rp.set(true);
            return true;
        }
        return false;
    }
}
