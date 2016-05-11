package com.baidu.tbadk.core.dialog;

import android.view.View;
import android.widget.EditText;
import com.baidu.tbadk.core.util.bl;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
class b implements bl.a {
    final /* synthetic */ a RS;
    private final /* synthetic */ AtomicBoolean RT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, AtomicBoolean atomicBoolean) {
        this.RS = aVar;
        this.RT = atomicBoolean;
    }

    @Override // com.baidu.tbadk.core.util.bl.a
    public boolean A(View view) {
        if (view instanceof EditText) {
            this.RT.set(true);
            return true;
        }
        return false;
    }
}
