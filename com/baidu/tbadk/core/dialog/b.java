package com.baidu.tbadk.core.dialog;

import android.view.View;
import android.widget.EditText;
import com.baidu.tbadk.core.util.bs;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
class b implements bs {
    final /* synthetic */ a RN;
    private final /* synthetic */ AtomicBoolean RO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, AtomicBoolean atomicBoolean) {
        this.RN = aVar;
        this.RO = atomicBoolean;
    }

    @Override // com.baidu.tbadk.core.util.bs
    public boolean m(View view) {
        if (view instanceof EditText) {
            this.RO.set(true);
            return true;
        }
        return false;
    }
}
