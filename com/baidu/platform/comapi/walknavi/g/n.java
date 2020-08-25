package com.baidu.platform.comapi.walknavi.g;

import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes20.dex */
public class n implements Runnable {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(a aVar) {
        this.a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.a(true, R.string.abc_action_menu_overflow_description);
    }
}
