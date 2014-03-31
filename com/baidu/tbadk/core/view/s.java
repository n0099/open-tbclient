package com.baidu.tbadk.core.view;

import android.view.View;
import com.baidu.tbadk.core.util.bp;
/* loaded from: classes.dex */
final class s implements bp {
    final /* synthetic */ r a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar, String str) {
        this.a = rVar;
        this.b = str;
    }

    @Override // com.baidu.tbadk.core.util.bp
    public final boolean a(View view) {
        Object tag = view.getTag();
        if (tag != null && this.b.equals(tag)) {
            view.invalidate();
            return false;
        }
        return false;
    }
}
