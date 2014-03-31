package com.baidu.tbadk.core.util;

import android.view.View;
/* loaded from: classes.dex */
final class ae implements bp {
    final /* synthetic */ ad a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ad adVar, String str) {
        this.a = adVar;
        this.b = str;
    }

    @Override // com.baidu.tbadk.core.util.bp
    public final boolean a(View view) {
        if (this.b.equals(view.getTag())) {
            view.invalidate();
            return false;
        }
        return false;
    }
}
