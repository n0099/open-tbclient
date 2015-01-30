package com.baidu.tbadk.core.dialog;

import android.view.View;
import android.widget.EditText;
import com.baidu.tbadk.core.util.bw;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
class b implements bw {
    private final /* synthetic */ AtomicBoolean FA;
    final /* synthetic */ a Fz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, AtomicBoolean atomicBoolean) {
        this.Fz = aVar;
        this.FA = atomicBoolean;
    }

    @Override // com.baidu.tbadk.core.util.bw
    public boolean k(View view) {
        if (view instanceof EditText) {
            this.FA.set(true);
            return true;
        }
        return false;
    }
}
