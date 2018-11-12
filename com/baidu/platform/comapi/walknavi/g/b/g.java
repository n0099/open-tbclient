package com.baidu.platform.comapi.walknavi.g.b;

import android.view.View;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class g implements View.OnClickListener {
    final /* synthetic */ c a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(c cVar) {
        this.a = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.platform.comapi.walknavi.g.a aVar;
        com.baidu.platform.comapi.walknavi.g.a aVar2;
        aVar = this.a.j;
        if (aVar != null) {
            System.out.println("mBarQuit onClick showQuitDialog");
            aVar2 = this.a.j;
            aVar2.a(false, R.string.abc_action_bar_home_description_format);
        }
    }
}
