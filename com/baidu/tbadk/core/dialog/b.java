package com.baidu.tbadk.core.dialog;

import android.view.View;
import android.widget.EditText;
import com.baidu.tbadk.core.util.bn;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
class b implements bn.a {
    final /* synthetic */ a Sk;
    private final /* synthetic */ AtomicBoolean Sl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, AtomicBoolean atomicBoolean) {
        this.Sk = aVar;
        this.Sl = atomicBoolean;
    }

    @Override // com.baidu.tbadk.core.util.bn.a
    public boolean z(View view) {
        if (view instanceof EditText) {
            this.Sl.set(true);
            return true;
        }
        return false;
    }
}
