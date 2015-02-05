package com.baidu.tbadk.core.dialog;

import android.view.View;
import android.widget.EditText;
import com.baidu.tbadk.core.util.bw;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
class f implements bw {
    final /* synthetic */ e FH;
    private final /* synthetic */ AtomicBoolean Fx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar, AtomicBoolean atomicBoolean) {
        this.FH = eVar;
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
