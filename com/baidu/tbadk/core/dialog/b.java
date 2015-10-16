package com.baidu.tbadk.core.dialog;

import android.view.View;
import android.widget.EditText;
import com.baidu.tbadk.core.util.bd;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
class b implements bd.a {
    final /* synthetic */ a WI;
    private final /* synthetic */ AtomicBoolean WJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, AtomicBoolean atomicBoolean) {
        this.WI = aVar;
        this.WJ = atomicBoolean;
    }

    @Override // com.baidu.tbadk.core.util.bd.a
    public boolean n(View view) {
        if (view instanceof EditText) {
            this.WJ.set(true);
            return true;
        }
        return false;
    }
}
