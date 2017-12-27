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

    public static void checkIfLegalArg(View view) {
        if (view == null) {
            throw new IllegalArgumentException("searchView must be non-null");
        }
        if (!(view instanceof SearchView)) {
            throw new IllegalArgumentException("searchView must be an instance ofandroid.widget.SearchView");
        }
    }

    public static View newSearchView(Context context) {
        return new SearchView(context);
    }

    public static void setSearchableInfo(View view, ComponentName componentName) {
        SearchView searchView = (SearchView) view;
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

    public static void setOnQueryTextListener(View view, Object obj) {
        ((SearchView) view).setOnQueryTextListener((SearchView.OnQueryTextListener) obj);
    }

    public static Object newOnCloseListener(final OnCloseListenerCompatBridge onCloseListenerCompatBridge) {
        return new SearchView.OnCloseListener() { // from class: android.support.v4.widget.SearchViewCompatHoneycomb.2
            @Override // android.widget.SearchView.OnCloseListener
            public boolean onClose() {
                return OnCloseListenerCompatBridge.this.onClose();
            }
        };
    }

    public static void setOnCloseListener(View view, Object obj) {
        ((SearchView) view).setOnCloseListener((SearchView.OnCloseListener) obj);
    }

    public static CharSequence getQuery(View view) {
        return ((SearchView) view).getQuery();
    }

    public static void setQuery(View view, CharSequence charSequence, boolean z) {
        ((SearchView) view).setQuery(charSequence, z);
    }

    public static void setQueryHint(View view, CharSequence charSequence) {
        ((SearchView) view).setQueryHint(charSequence);
    }

    public static void setIconified(View view, boolean z) {
        ((SearchView) view).setIconified(z);
    }

    public static boolean isIconified(View view) {
        return ((SearchView) view).isIconified();
    }

    public static void setSubmitButtonEnabled(View view, boolean z) {
        ((SearchView) view).setSubmitButtonEnabled(z);
    }

    public static boolean isSubmitButtonEnabled(View view) {
        return ((SearchView) view).isSubmitButtonEnabled();
    }

    public static void setQueryRefinementEnabled(View view, boolean z) {
        ((SearchView) view).setQueryRefinementEnabled(z);
    }

    public static boolean isQueryRefinementEnabled(View view) {
        return ((SearchView) view).isQueryRefinementEnabled();
    }

    public static void setMaxWidth(View view, int i) {
        ((SearchView) view).setMaxWidth(i);
    }
}
