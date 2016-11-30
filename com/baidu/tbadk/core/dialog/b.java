package com.baidu.tbadk.core.dialog;

import android.view.View;
import android.widget.EditText;
import com.baidu.tbadk.core.util.bk;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
class b implements bk.a {
    final /* synthetic */ a Wq;
    private final /* synthetic */ AtomicBoolean Wr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, AtomicBoolean atomicBoolean) {
        this.Wq = aVar;
        this.Wr = atomicBoolean;
    }

    @Override // com.baidu.tbadk.core.util.bk.a
    public boolean A(View view) {
        if (view instanceof EditText) {
            this.Wr.set(true);
            return true;
        }
        return false;
    }
}
