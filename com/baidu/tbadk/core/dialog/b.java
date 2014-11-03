package com.baidu.tbadk.core.dialog;

import android.view.View;
import android.widget.EditText;
import com.baidu.tbadk.core.util.bq;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
class b implements bq {
    final /* synthetic */ a Bj;
    private final /* synthetic */ AtomicBoolean Bk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, AtomicBoolean atomicBoolean) {
        this.Bj = aVar;
        this.Bk = atomicBoolean;
    }

    @Override // com.baidu.tbadk.core.util.bq
    public boolean k(View view) {
        if (view instanceof EditText) {
            this.Bk.set(true);
            return true;
        }
        return false;
    }
}
