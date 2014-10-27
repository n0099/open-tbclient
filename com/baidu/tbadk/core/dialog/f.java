package com.baidu.tbadk.core.dialog;

import android.view.View;
import android.widget.EditText;
import com.baidu.tbadk.core.util.bp;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
class f implements bp {
    private final /* synthetic */ AtomicBoolean Bk;
    final /* synthetic */ e Bt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar, AtomicBoolean atomicBoolean) {
        this.Bt = eVar;
        this.Bk = atomicBoolean;
    }

    @Override // com.baidu.tbadk.core.util.bp
    public boolean k(View view) {
        if (view instanceof EditText) {
            this.Bk.set(true);
            return true;
        }
        return false;
    }
}
