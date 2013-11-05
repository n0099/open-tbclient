package android.support.v4.widget;

import android.support.v4.view.aq;
import android.view.View;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final View f358a;
    final /* synthetic */ SlidingPaneLayout b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(SlidingPaneLayout slidingPaneLayout, View view) {
        this.b = slidingPaneLayout;
        this.f358a = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        ArrayList arrayList;
        if (this.f358a.getParent() == this.b) {
            aq.a(this.f358a, 0, null);
            this.b.d(this.f358a);
        }
        arrayList = this.b.t;
        arrayList.remove(this);
    }
}
