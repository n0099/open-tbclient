package com.baidu.tbadk.core.dialog;

import android.view.View;
import android.widget.EditText;
import com.baidu.tbadk.core.util.bg;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
class b implements bg.a {
    final /* synthetic */ a aaB;
    private final /* synthetic */ AtomicBoolean aaC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, AtomicBoolean atomicBoolean) {
        this.aaB = aVar;
        this.aaC = atomicBoolean;
    }

    @Override // com.baidu.tbadk.core.util.bg.a
    public boolean w(View view) {
        if (view instanceof EditText) {
            this.aaC.set(true);
            return true;
        }
        return false;
    }
}
