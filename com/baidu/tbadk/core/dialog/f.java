package com.baidu.tbadk.core.dialog;

import android.view.View;
import android.widget.EditText;
import com.baidu.tbadk.core.util.bq;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
class f implements bq {
    private final /* synthetic */ AtomicBoolean Bk;
    final /* synthetic */ e Bu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar, AtomicBoolean atomicBoolean) {
        this.Bu = eVar;
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
