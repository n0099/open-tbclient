package android.support.v4.widget;

import android.content.Context;
import android.view.View;
import android.widget.SearchView;
/* loaded from: classes2.dex */
class SearchViewCompatIcs {
    SearchViewCompatIcs() {
    }

    /* loaded from: classes2.dex */
    public static class MySearchView extends SearchView {
        public MySearchView(Context context) {
            super(context);
        }

        @Override // android.widget.SearchView, android.view.CollapsibleActionView
        public void onActionViewCollapsed() {
            setQuery("", false);
            super.onActionViewCollapsed();
        }
    }

    public static View newSearchView(Context context) {
        return new MySearchView(context);
    }

    public static void setImeOptions(View view2, int i) {
        ((SearchView) view2).setImeOptions(i);
    }

    public static void setInputType(View view2, int i) {
        ((SearchView) view2).setInputType(i);
    }
}
