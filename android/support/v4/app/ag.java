package android.support.v4.app;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
/* loaded from: classes.dex */
class ag implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ListFragment f52a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(ListFragment listFragment) {
        this.f52a = listFragment;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.f52a.a((ListView) adapterView, view, i, j);
    }
}
