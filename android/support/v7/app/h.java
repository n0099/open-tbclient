package android.support.v7.app;

import android.support.v7.app.ActionBar;
import android.view.View;
import android.widget.AdapterView;
/* loaded from: classes2.dex */
class h implements AdapterView.OnItemSelectedListener {
    private final ActionBar.OnNavigationListener DK;

    public h(ActionBar.OnNavigationListener onNavigationListener) {
        this.DK = onNavigationListener;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.DK != null) {
            this.DK.onNavigationItemSelected(i, j);
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
