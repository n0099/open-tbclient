package com.baidu.tbadk.core.dialog;

import android.view.View;
import android.widget.EditText;
import com.baidu.tbadk.core.util.br;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
class b implements br {
    final /* synthetic */ a a;
    private final /* synthetic */ AtomicBoolean b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, AtomicBoolean atomicBoolean) {
        this.a = aVar;
        this.b = atomicBoolean;
    }

    @Override // com.baidu.tbadk.core.util.br
    public boolean a(View view) {
        if (view instanceof EditText) {
            this.b.set(true);
            return true;
        }
        return false;
    }
}
