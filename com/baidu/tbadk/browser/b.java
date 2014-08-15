package com.baidu.tbadk.browser;

import android.util.Log;
import android.view.View;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
class b implements View.OnClickListener {
    final /* synthetic */ GameWebViewActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(GameWebViewActivity gameWebViewActivity) {
        this.a = gameWebViewActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        boolean z2;
        this.a.mNavigationBar.setVisibility(0);
        NavigationBar navigationBar = this.a.mNavigationBar;
        GameWebViewActivity gameWebViewActivity = this.a;
        NavigationBar navigationBar2 = this.a.mNavigationBar;
        z = this.a.c;
        navigationBar.startAnimation(new c(gameWebViewActivity, navigationBar2, !z));
        StringBuilder sb = new StringBuilder("startAnimation");
        z2 = this.a.c;
        Log.d("mNavigationBar", sb.append(z2 ? false : true).toString());
    }
}
