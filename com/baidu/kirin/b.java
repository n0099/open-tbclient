package com.baidu.kirin;

import android.content.Context;
/* loaded from: classes.dex */
final class b implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ int b;
    final /* synthetic */ PostChoiceListener c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context, int i, PostChoiceListener postChoiceListener) {
        this.a = context;
        this.b = i;
        this.c = postChoiceListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        StatUpdateAgent.b(this.a, this.b, this.c);
    }
}
