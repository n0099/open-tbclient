package com.baidu.tbadk.core.dialog;

import android.view.View;
import android.widget.EditText;
import com.baidu.tbadk.core.util.bh;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
class b implements bh.a {
    final /* synthetic */ a VK;
    private final /* synthetic */ AtomicBoolean VL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, AtomicBoolean atomicBoolean) {
        this.VK = aVar;
        this.VL = atomicBoolean;
    }

    @Override // com.baidu.tbadk.core.util.bh.a
    public boolean A(View view) {
        if (view instanceof EditText) {
            this.VL.set(true);
            return true;
        }
        return false;
    }
}
