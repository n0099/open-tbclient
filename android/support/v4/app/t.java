package android.support.v4.app;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
/* loaded from: classes.dex */
class t implements AdapterView.OnItemClickListener {
    final /* synthetic */ ListFragment a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(ListFragment listFragment) {
        this.a = listFragment;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.a.a((ListView) adapterView, view, i, j);
    }
}
