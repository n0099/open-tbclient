package android.support.v4.widget;

import android.content.Context;
import android.view.View;
import android.widget.SearchView;
/* loaded from: classes.dex */
class SearchViewCompatIcs {
    SearchViewCompatIcs() {
    }

    /* loaded from: classes.dex */
    public class MySearchView extends SearchView {
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

    public static void setImeOptions(View view, int i) {
        ((SearchView) view).setImeOptions(i);
    }

    public static void setInputType(View view, int i) {
        ((SearchView) view).setInputType(i);
    }
}
