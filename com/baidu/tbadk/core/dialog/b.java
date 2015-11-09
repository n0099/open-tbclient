package com.baidu.tbadk.core.dialog;

import android.view.View;
import android.widget.EditText;
import com.baidu.tbadk.core.util.bd;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
class b implements bd.a {
    final /* synthetic */ a WL;
    private final /* synthetic */ AtomicBoolean WM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, AtomicBoolean atomicBoolean) {
        this.WL = aVar;
        this.WM = atomicBoolean;
    }

    @Override // com.baidu.tbadk.core.util.bd.a
    public boolean n(View view) {
        if (view instanceof EditText) {
            this.WM.set(true);
            return true;
        }
        return false;
    }
}
