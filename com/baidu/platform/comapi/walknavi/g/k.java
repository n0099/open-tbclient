package com.baidu.platform.comapi.walknavi.g;

import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class k implements Runnable {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(a aVar) {
        this.a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.a(true, R.string.abc_action_bar_home_subtitle_description_format);
    }
}
