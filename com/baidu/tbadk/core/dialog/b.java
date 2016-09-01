package com.baidu.tbadk.core.dialog;

import android.view.View;
import android.widget.EditText;
import com.baidu.tbadk.core.util.bn;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
class b implements bn.a {
    final /* synthetic */ a VI;
    private final /* synthetic */ AtomicBoolean VJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, AtomicBoolean atomicBoolean) {
        this.VI = aVar;
        this.VJ = atomicBoolean;
    }

    @Override // com.baidu.tbadk.core.util.bn.a
    public boolean A(View view) {
        if (view instanceof EditText) {
            this.VJ.set(true);
            return true;
        }
        return false;
    }
}
