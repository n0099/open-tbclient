package com.baidu.tbadk.core.dialog;

import android.view.View;
import android.widget.EditText;
import com.baidu.tbadk.core.util.bg;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
class b implements bg.a {
    final /* synthetic */ a ZX;
    private final /* synthetic */ AtomicBoolean ZY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, AtomicBoolean atomicBoolean) {
        this.ZX = aVar;
        this.ZY = atomicBoolean;
    }

    @Override // com.baidu.tbadk.core.util.bg.a
    public boolean w(View view) {
        if (view instanceof EditText) {
            this.ZY.set(true);
            return true;
        }
        return false;
    }
}
