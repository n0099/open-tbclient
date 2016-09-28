package com.baidu.tbadk.core.dialog;

import android.view.View;
import android.widget.EditText;
import com.baidu.tbadk.core.util.bm;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
class b implements bm.a {
    final /* synthetic */ a VS;
    private final /* synthetic */ AtomicBoolean VT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, AtomicBoolean atomicBoolean) {
        this.VS = aVar;
        this.VT = atomicBoolean;
    }

    @Override // com.baidu.tbadk.core.util.bm.a
    public boolean A(View view) {
        if (view instanceof EditText) {
            this.VT.set(true);
            return true;
        }
        return false;
    }
}
