package android.support.v4.widget;

import android.support.v4.view.aq;
import android.view.View;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements Runnable {
    final View a;
    final /* synthetic */ SlidingPaneLayout b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(SlidingPaneLayout slidingPaneLayout, View view) {
        this.b = slidingPaneLayout;
        this.a = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        ArrayList arrayList;
        if (this.a.getParent() == this.b) {
            aq.a(this.a, 0, null);
            this.b.d(this.a);
        }
        arrayList = this.b.t;
        arrayList.remove(this);
    }
}
