package com.baidu.tbadk.core.dialog;

import android.view.View;
import android.widget.EditText;
import com.baidu.tbadk.core.util.bh;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
class b implements bh.a {
    final /* synthetic */ a ZW;
    private final /* synthetic */ AtomicBoolean ZX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, AtomicBoolean atomicBoolean) {
        this.ZW = aVar;
        this.ZX = atomicBoolean;
    }

    @Override // com.baidu.tbadk.core.util.bh.a
    public boolean w(View view) {
        if (view instanceof EditText) {
            this.ZX.set(true);
            return true;
        }
        return false;
    }
}
