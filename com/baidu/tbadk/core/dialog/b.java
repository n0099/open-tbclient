package com.baidu.tbadk.core.dialog;

import android.view.View;
import android.widget.EditText;
import com.baidu.tbadk.core.util.bf;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
class b implements bf.a {
    final /* synthetic */ a Va;
    private final /* synthetic */ AtomicBoolean Vb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, AtomicBoolean atomicBoolean) {
        this.Va = aVar;
        this.Vb = atomicBoolean;
    }

    @Override // com.baidu.tbadk.core.util.bf.a
    public boolean y(View view) {
        if (view instanceof EditText) {
            this.Vb.set(true);
            return true;
        }
        return false;
    }
}
