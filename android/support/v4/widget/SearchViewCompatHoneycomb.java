package android.support.v4.widget;

import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.view.View;
import android.widget.SearchView;
/* loaded from: classes2.dex */
class SearchViewCompatHoneycomb {

    /* loaded from: classes2.dex */
    interface OnCloseListenerCompatBridge {
        boolean onClose();
    }

    /* loaded from: classes2.dex */
    interface OnQueryTextListenerCompatBridge {
        boolean onQueryTextChange(String str);

        boolean onQueryTextSubmit(String str);
    }

    SearchViewCompatHoneycomb() {
    }

    public static void checkIfLegalArg(View view2) {
        if (view2 == null) {
            throw new IllegalArgumentException("searchView must be non-null");
        }
        if (!(view2 instanceof SearchView)) {
            throw new IllegalArgumentException("searchView must be an instance ofandroid.widget.SearchView");
        }
    }

    public static View newSearchView(Context context) {
        return new SearchView(context);
    }

    public static void setSearchableInfo(View view2, ComponentName componentName) {
        SearchView searchView = (SearchView) view2;
        searchView.setSearchableInfo(((SearchManager) searchView.getContext().getSystemService("search")).getSearchableInfo(componentName));
    }

    public static Object newOnQueryTextListener(final OnQueryTextListenerCompatBridge onQueryTextListenerCompatBridge) {
        return new SearchView.OnQueryTextListener() { // from class: android.support.v4.widget.SearchViewCompatHoneycomb.1
            @Override // android.widget.SearchView.OnQueryTextListener
            public boolean onQueryTextSubmit(String str) {
                return OnQueryTextListenerCompatBridge.this.onQueryTextSubmit(str);
            }

            @Override // android.widget.SearchView.OnQueryTextListener
            public boolean onQueryTextChange(String str) {
                return OnQueryTextListenerCompatBridge.this.onQueryTextChange(str);
            }
        };
    }

    public static void setOnQueryTextListener(View view2, Object obj) {
        ((SearchView) view2).setOnQueryTextListener((SearchView.OnQueryTextListener) obj);
    }

    public static Object newOnCloseListener(final OnCloseListenerCompatBridge onCloseListenerCompatBridge) {
        return new SearchView.OnCloseListener() { // from class: android.support.v4.widget.SearchViewCompatHoneycomb.2
            @Override // android.widget.SearchView.OnCloseListener
            public boolean onClose() {
                return OnCloseListenerCompatBridge.this.onClose();
            }
        };
    }

    public static void setOnCloseListener(View view2, Object obj) {
        ((SearchView) view2).setOnCloseListener((SearchView.OnCloseListener) obj);
    }

    public static CharSequence getQuery(View view2) {
        return ((SearchView) view2).getQuery();
    }

    public static void setQuery(View view2, CharSequence charSequence, boolean z) {
        ((SearchView) view2).setQuery(charSequence, z);
    }

    public static void setQueryHint(View view2, CharSequence charSequence) {
        ((SearchView) view2).setQueryHint(charSequence);
    }

    public static void setIconified(View view2, boolean z) {
        ((SearchView) view2).setIconified(z);
    }

    public static boolean isIconified(View view2) {
        return ((SearchView) view2).isIconified();
    }

    public static void setSubmitButtonEnabled(View view2, boolean z) {
        ((SearchView) view2).setSubmitButtonEnabled(z);
    }

    public static boolean isSubmitButtonEnabled(View view2) {
        return ((SearchView) view2).isSubmitButtonEnabled();
    }

    public static void setQueryRefinementEnabled(View view2, boolean z) {
        ((SearchView) view2).setQueryRefinementEnabled(z);
    }

    public static boolean isQueryRefinementEnabled(View view2) {
        return ((SearchView) view2).isQueryRefinementEnabled();
    }

    public static void setMaxWidth(View view2, int i) {
        ((SearchView) view2).setMaxWidth(i);
    }
}
