package com.baidu.sapi2.utils;

import android.app.Activity;
import android.view.View;
/* loaded from: classes6.dex */
public class p {
    private View a;
    int b;
    private a c;

    /* loaded from: classes6.dex */
    public interface a {
        void keyBoardHide(int i);

        void keyBoardShow(int i);
    }

    public p(Activity activity) {
        this.a = activity.getWindow().getDecorView();
        this.a.getViewTreeObserver().addOnGlobalLayoutListener(new o(this));
    }

    private void a(a aVar) {
        this.c = aVar;
    }

    public static void a(Activity activity, a aVar) {
        new p(activity).a(aVar);
    }
}
