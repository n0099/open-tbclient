package com.baidu.tbadk.core.dialog;

import android.view.View;
import android.widget.EditText;
import com.baidu.tbadk.core.util.bp;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
class b implements bp {
    final /* synthetic */ a Bj;
    private final /* synthetic */ AtomicBoolean Bk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, AtomicBoolean atomicBoolean) {
        this.Bj = aVar;
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
