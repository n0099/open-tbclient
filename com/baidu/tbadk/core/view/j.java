package com.baidu.tbadk.core.view;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class j implements View.OnClickListener {
    final /* synthetic */ NavigationBar a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(NavigationBar navigationBar) {
        this.a = navigationBar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean z;
        Activity activity;
        Activity activity2;
        z = this.a.b;
        if (z) {
            int id = view.getId();
            if (id == com.baidu.tbadk.j.navigationBarGoBack) {
                activity2 = this.a.g;
                activity2.finish();
            } else if (id == com.baidu.tbadk.j.navigationBarHome) {
                com.baidu.adp.framework.c a = com.baidu.adp.framework.c.a();
                activity = this.a.g;
                a.a(new CustomResponsedMessage(2001004, activity));
            }
        }
    }
}
