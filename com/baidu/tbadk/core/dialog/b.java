package com.baidu.tbadk.core.dialog;

import android.view.View;
import android.widget.EditText;
import com.baidu.tbadk.core.util.bu;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
class b implements bu {
    final /* synthetic */ a Rm;
    private final /* synthetic */ AtomicBoolean Rn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, AtomicBoolean atomicBoolean) {
        this.Rm = aVar;
        this.Rn = atomicBoolean;
    }

    @Override // com.baidu.tbadk.core.util.bu
    public boolean k(View view) {
        if (view instanceof EditText) {
            this.Rn.set(true);
            return true;
        }
        return false;
    }
}
