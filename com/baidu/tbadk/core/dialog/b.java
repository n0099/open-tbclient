package com.baidu.tbadk.core.dialog;

import android.view.View;
import android.widget.EditText;
import com.baidu.tbadk.core.util.bj;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
class b implements bj.a {
    final /* synthetic */ a Xy;
    private final /* synthetic */ AtomicBoolean Xz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, AtomicBoolean atomicBoolean) {
        this.Xy = aVar;
        this.Xz = atomicBoolean;
    }

    @Override // com.baidu.tbadk.core.util.bj.a
    public boolean n(View view) {
        if (view instanceof EditText) {
            this.Xz.set(true);
            return true;
        }
        return false;
    }
}
