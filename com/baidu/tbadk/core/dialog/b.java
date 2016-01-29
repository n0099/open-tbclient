package com.baidu.tbadk.core.dialog;

import android.view.View;
import android.widget.EditText;
import com.baidu.tbadk.core.util.bi;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
class b implements bi.a {
    final /* synthetic */ a Yo;
    private final /* synthetic */ AtomicBoolean Yp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, AtomicBoolean atomicBoolean) {
        this.Yo = aVar;
        this.Yp = atomicBoolean;
    }

    @Override // com.baidu.tbadk.core.util.bi.a
    public boolean A(View view) {
        if (view instanceof EditText) {
            this.Yp.set(true);
            return true;
        }
        return false;
    }
}
