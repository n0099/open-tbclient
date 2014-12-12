package com.baidu.tbadk.core.dialog;

import android.view.View;
import android.widget.EditText;
import com.baidu.tbadk.core.util.br;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
class b implements br {
    final /* synthetic */ a Fu;
    private final /* synthetic */ AtomicBoolean Fv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, AtomicBoolean atomicBoolean) {
        this.Fu = aVar;
        this.Fv = atomicBoolean;
    }

    @Override // com.baidu.tbadk.core.util.br
    public boolean k(View view) {
        if (view instanceof EditText) {
            this.Fv.set(true);
            return true;
        }
        return false;
    }
}
