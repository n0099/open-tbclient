package com.baidu.tbadk.core.dialog;

import android.view.View;
import android.widget.EditText;
import com.baidu.tbadk.core.util.bl;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
class b implements bl.a {
    final /* synthetic */ a WH;
    private final /* synthetic */ AtomicBoolean WI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, AtomicBoolean atomicBoolean) {
        this.WH = aVar;
        this.WI = atomicBoolean;
    }

    @Override // com.baidu.tbadk.core.util.bl.a
    public boolean A(View view) {
        if (view instanceof EditText) {
            this.WI.set(true);
            return true;
        }
        return false;
    }
}
