package com.baidu.tbadk.core.dialog;

import android.view.View;
import android.widget.EditText;
import com.baidu.tbadk.core.util.bn;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
class b implements bn.a {
    final /* synthetic */ a SS;
    private final /* synthetic */ AtomicBoolean ST;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, AtomicBoolean atomicBoolean) {
        this.SS = aVar;
        this.ST = atomicBoolean;
    }

    @Override // com.baidu.tbadk.core.util.bn.a
    public boolean z(View view) {
        if (view instanceof EditText) {
            this.ST.set(true);
            return true;
        }
        return false;
    }
}
