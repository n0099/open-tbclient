package com.baidu.tbadk.core.dialog;

import android.view.View;
import android.widget.EditText;
import com.baidu.tbadk.core.util.bg;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
class b implements bg.a {
    final /* synthetic */ a aal;
    private final /* synthetic */ AtomicBoolean aam;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, AtomicBoolean atomicBoolean) {
        this.aal = aVar;
        this.aam = atomicBoolean;
    }

    @Override // com.baidu.tbadk.core.util.bg.a
    public boolean w(View view) {
        if (view instanceof EditText) {
            this.aam.set(true);
            return true;
        }
        return false;
    }
}
