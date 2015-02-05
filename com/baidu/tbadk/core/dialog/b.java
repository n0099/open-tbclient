package com.baidu.tbadk.core.dialog;

import android.view.View;
import android.widget.EditText;
import com.baidu.tbadk.core.util.bw;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
class b implements bw {
    final /* synthetic */ a Fw;
    private final /* synthetic */ AtomicBoolean Fx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, AtomicBoolean atomicBoolean) {
        this.Fw = aVar;
        this.Fx = atomicBoolean;
    }

    @Override // com.baidu.tbadk.core.util.bw
    public boolean k(View view) {
        if (view instanceof EditText) {
            this.Fx.set(true);
            return true;
        }
        return false;
    }
}
