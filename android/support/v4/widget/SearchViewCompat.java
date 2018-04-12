package android.support.v4.widget;

import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.support.v4.widget.SearchViewCompatHoneycomb;
import android.view.View;
/* loaded from: classes2.dex */
public final class SearchViewCompat {
    private static final SearchViewCompatImpl IMPL;

    /* loaded from: classes2.dex */
    public interface OnCloseListener {
        boolean onClose();
    }

    /* loaded from: classes2.dex */
    public interface OnQueryTextListener {
        boolean onQueryTextChange(String str);

        boolean onQueryTextSubmit(String str);
    }

    /* loaded from: classes2.dex */
    interface SearchViewCompatImpl {
        CharSequence getQuery(View view2);

        boolean isIconified(View view2);

        boolean isQueryRefinementEnabled(View view2);

        boolean isSubmitButtonEnabled(View view2);

        Object newOnCloseListener(OnCloseListener onCloseListener);

        Object newOnQueryTextListener(OnQueryTextListener onQueryTextListener);

        View newSearchView(Context context);

        void setIconified(View view2, boolean z);

        void setImeOptions(View view2, int i);

        void setInputType(View view2, int i);

        void setMaxWidth(View view2, int i);

        void setOnCloseListener(View view2, OnCloseListener onCloseListener);

        void setOnQueryTextListener(View view2, OnQueryTextListener onQueryTextListener);

        void setQuery(View view2, CharSequence charSequence, boolean z);

        void setQueryHint(View view2, CharSequence charSequence);

        void setQueryRefinementEnabled(View view2, boolean z);

        void setSearchableInfo(View view2, ComponentName componentName);

        void setSubmitButtonEnabled(View view2, boolean z);
    }

    /* loaded from: classes2.dex */
    static class SearchViewCompatStubImpl implements SearchViewCompatImpl {
        SearchViewCompatStubImpl() {
        }

        @Override // android.support.v4.widget.SearchViewCompat.SearchViewCompatImpl
        public View newSearchView(Context context) {
            return null;
        }

        @Override // android.support.v4.widget.SearchViewCompat.SearchViewCompatImpl
        public void setSearchableInfo(View view2, ComponentName componentName) {
        }

        @Override // android.support.v4.widget.SearchViewCompat.SearchViewCompatImpl
        public void setImeOptions(View view2, int i) {
        }

        @Override // android.support.v4.widget.SearchViewCompat.SearchViewCompatImpl
        public void setInputType(View view2, int i) {
        }

        @Override // android.support.v4.widget.SearchViewCompat.SearchViewCompatImpl
        public Object newOnQueryTextListener(OnQueryTextListener onQueryTextListener) {
            return null;
        }

        @Override // android.support.v4.widget.SearchViewCompat.SearchViewCompatImpl
        public void setOnQueryTextListener(View view2, OnQueryTextListener onQueryTextListener) {
        }

        @Override // android.support.v4.widget.SearchViewCompat.SearchViewCompatImpl
        public Object newOnCloseListener(OnCloseListener onCloseListener) {
            return null;
        }

        @Override // android.support.v4.widget.SearchViewCompat.SearchViewCompatImpl
        public void setOnCloseListener(View view2, OnCloseListener onCloseListener) {
        }

        @Override // android.support.v4.widget.SearchViewCompat.SearchViewCompatImpl
        public CharSequence getQuery(View view2) {
            return null;
        }

        @Override // android.support.v4.widget.SearchViewCompat.SearchViewCompatImpl
        public void setQuery(View view2, CharSequence charSequence, boolean z) {
        }

        @Override // android.support.v4.widget.SearchViewCompat.SearchViewCompatImpl
        public void setQueryHint(View view2, CharSequence charSequence) {
        }

        @Override // android.support.v4.widget.SearchViewCompat.SearchViewCompatImpl
        public void setIconified(View view2, boolean z) {
        }

        @Override // android.support.v4.widget.SearchViewCompat.SearchViewCompatImpl
        public boolean isIconified(View view2) {
            return true;
        }

        @Override // android.support.v4.widget.SearchViewCompat.SearchViewCompatImpl
        public void setSubmitButtonEnabled(View view2, boolean z) {
        }

        @Override // android.support.v4.widget.SearchViewCompat.SearchViewCompatImpl
        public boolean isSubmitButtonEnabled(View view2) {
            return false;
        }

        @Override // android.support.v4.widget.SearchViewCompat.SearchViewCompatImpl
        public void setQueryRefinementEnabled(View view2, boolean z) {
        }

        @Override // android.support.v4.widget.SearchViewCompat.SearchViewCompatImpl
        public boolean isQueryRefinementEnabled(View view2) {
            return false;
        }

        @Override // android.support.v4.widget.SearchViewCompat.SearchViewCompatImpl
        public void setMaxWidth(View view2, int i) {
        }
    }

    /* loaded from: classes2.dex */
    static class SearchViewCompatHoneycombImpl extends SearchViewCompatStubImpl {
        SearchViewCompatHoneycombImpl() {
        }

        @Override // android.support.v4.widget.SearchViewCompat.SearchViewCompatStubImpl, android.support.v4.widget.SearchViewCompat.SearchViewCompatImpl
        public View newSearchView(Context context) {
            return SearchViewCompatHoneycomb.newSearchView(context);
        }

        @Override // android.support.v4.widget.SearchViewCompat.SearchViewCompatStubImpl, android.support.v4.widget.SearchViewCompat.SearchViewCompatImpl
        public void setSearchableInfo(View view2, ComponentName componentName) {
            checkIfLegalArg(view2);
            SearchViewCompatHoneycomb.setSearchableInfo(view2, componentName);
        }

        @Override // android.support.v4.widget.SearchViewCompat.SearchViewCompatStubImpl, android.support.v4.widget.SearchViewCompat.SearchViewCompatImpl
        public Object newOnQueryTextListener(final OnQueryTextListener onQueryTextListener) {
            return SearchViewCompatHoneycomb.newOnQueryTextListener(new SearchViewCompatHoneycomb.OnQueryTextListenerCompatBridge() { // from class: android.support.v4.widget.SearchViewCompat.SearchViewCompatHoneycombImpl.1
                @Override // android.support.v4.widget.SearchViewCompatHoneycomb.OnQueryTextListenerCompatBridge
                public boolean onQueryTextSubmit(String str) {
                    return onQueryTextListener.onQueryTextSubmit(str);
                }

                @Override // android.support.v4.widget.SearchViewCompatHoneycomb.OnQueryTextListenerCompatBridge
                public boolean onQueryTextChange(String str) {
                    return onQueryTextListener.onQueryTextChange(str);
                }
            });
        }

        @Override // android.support.v4.widget.SearchViewCompat.SearchViewCompatStubImpl, android.support.v4.widget.SearchViewCompat.SearchViewCompatImpl
        public void setOnQueryTextListener(View view2, OnQueryTextListener onQueryTextListener) {
            checkIfLegalArg(view2);
            SearchViewCompatHoneycomb.setOnQueryTextListener(view2, newOnQueryTextListener(onQueryTextListener));
        }

        @Override // android.support.v4.widget.SearchViewCompat.SearchViewCompatStubImpl, android.support.v4.widget.SearchViewCompat.SearchViewCompatImpl
        public Object newOnCloseListener(final OnCloseListener onCloseListener) {
            return SearchViewCompatHoneycomb.newOnCloseListener(new SearchViewCompatHoneycomb.OnCloseListenerCompatBridge() { // from class: android.support.v4.widget.SearchViewCompat.SearchViewCompatHoneycombImpl.2
                @Override // android.support.v4.widget.SearchViewCompatHoneycomb.OnCloseListenerCompatBridge
                public boolean onClose() {
                    return onCloseListener.onClose();
                }
            });
        }

        @Override // android.support.v4.widget.SearchViewCompat.SearchViewCompatStubImpl, android.support.v4.widget.SearchViewCompat.SearchViewCompatImpl
        public void setOnCloseListener(View view2, OnCloseListener onCloseListener) {
            checkIfLegalArg(view2);
            SearchViewCompatHoneycomb.setOnCloseListener(view2, newOnCloseListener(onCloseListener));
        }

        @Override // android.support.v4.widget.SearchViewCompat.SearchViewCompatStubImpl, android.support.v4.widget.SearchViewCompat.SearchViewCompatImpl
        public CharSequence getQuery(View view2) {
            checkIfLegalArg(view2);
            return SearchViewCompatHoneycomb.getQuery(view2);
        }

        @Override // android.support.v4.widget.SearchViewCompat.SearchViewCompatStubImpl, android.support.v4.widget.SearchViewCompat.SearchViewCompatImpl
        public void setQuery(View view2, CharSequence charSequence, boolean z) {
            checkIfLegalArg(view2);
            SearchViewCompatHoneycomb.setQuery(view2, charSequence, z);
        }

        @Override // android.support.v4.widget.SearchViewCompat.SearchViewCompatStubImpl, android.support.v4.widget.SearchViewCompat.SearchViewCompatImpl
        public void setQueryHint(View view2, CharSequence charSequence) {
            checkIfLegalArg(view2);
            SearchViewCompatHoneycomb.setQueryHint(view2, charSequence);
        }

        @Override // android.support.v4.widget.SearchViewCompat.SearchViewCompatStubImpl, android.support.v4.widget.SearchViewCompat.SearchViewCompatImpl
        public void setIconified(View view2, boolean z) {
            checkIfLegalArg(view2);
            SearchViewCompatHoneycomb.setIconified(view2, z);
        }

        @Override // android.support.v4.widget.SearchViewCompat.SearchViewCompatStubImpl, android.support.v4.widget.SearchViewCompat.SearchViewCompatImpl
        public boolean isIconified(View view2) {
            checkIfLegalArg(view2);
            return SearchViewCompatHoneycomb.isIconified(view2);
        }

        @Override // android.support.v4.widget.SearchViewCompat.SearchViewCompatStubImpl, android.support.v4.widget.SearchViewCompat.SearchViewCompatImpl
        public void setSubmitButtonEnabled(View view2, boolean z) {
            checkIfLegalArg(view2);
            SearchViewCompatHoneycomb.setSubmitButtonEnabled(view2, z);
        }

        @Override // android.support.v4.widget.SearchViewCompat.SearchViewCompatStubImpl, android.support.v4.widget.SearchViewCompat.SearchViewCompatImpl
        public boolean isSubmitButtonEnabled(View view2) {
            checkIfLegalArg(view2);
            return SearchViewCompatHoneycomb.isSubmitButtonEnabled(view2);
        }

        @Override // android.support.v4.widget.SearchViewCompat.SearchViewCompatStubImpl, android.support.v4.widget.SearchViewCompat.SearchViewCompatImpl
        public void setQueryRefinementEnabled(View view2, boolean z) {
            checkIfLegalArg(view2);
            SearchViewCompatHoneycomb.setQueryRefinementEnabled(view2, z);
        }

        @Override // android.support.v4.widget.SearchViewCompat.SearchViewCompatStubImpl, android.support.v4.widget.SearchViewCompat.SearchViewCompatImpl
        public boolean isQueryRefinementEnabled(View view2) {
            checkIfLegalArg(view2);
            return SearchViewCompatHoneycomb.isQueryRefinementEnabled(view2);
        }

        @Override // android.support.v4.widget.SearchViewCompat.SearchViewCompatStubImpl, android.support.v4.widget.SearchViewCompat.SearchViewCompatImpl
        public void setMaxWidth(View view2, int i) {
            checkIfLegalArg(view2);
            SearchViewCompatHoneycomb.setMaxWidth(view2, i);
        }

        protected void checkIfLegalArg(View view2) {
            SearchViewCompatHoneycomb.checkIfLegalArg(view2);
        }
    }

    /* loaded from: classes2.dex */
    static class SearchViewCompatIcsImpl extends SearchViewCompatHoneycombImpl {
        SearchViewCompatIcsImpl() {
        }

        @Override // android.support.v4.widget.SearchViewCompat.SearchViewCompatHoneycombImpl, android.support.v4.widget.SearchViewCompat.SearchViewCompatStubImpl, android.support.v4.widget.SearchViewCompat.SearchViewCompatImpl
        public View newSearchView(Context context) {
            return SearchViewCompatIcs.newSearchView(context);
        }

        @Override // android.support.v4.widget.SearchViewCompat.SearchViewCompatStubImpl, android.support.v4.widget.SearchViewCompat.SearchViewCompatImpl
        public void setImeOptions(View view2, int i) {
            checkIfLegalArg(view2);
            SearchViewCompatIcs.setImeOptions(view2, i);
        }

        @Override // android.support.v4.widget.SearchViewCompat.SearchViewCompatStubImpl, android.support.v4.widget.SearchViewCompat.SearchViewCompatImpl
        public void setInputType(View view2, int i) {
            checkIfLegalArg(view2);
            SearchViewCompatIcs.setInputType(view2, i);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 14) {
            IMPL = new SearchViewCompatIcsImpl();
        } else if (Build.VERSION.SDK_INT >= 11) {
            IMPL = new SearchViewCompatHoneycombImpl();
        } else {
            IMPL = new SearchViewCompatStubImpl();
        }
    }

    private SearchViewCompat(Context context) {
    }

    public static View newSearchView(Context context) {
        return IMPL.newSearchView(context);
    }

    public static void setSearchableInfo(View view2, ComponentName componentName) {
        IMPL.setSearchableInfo(view2, componentName);
    }

    public static void setImeOptions(View view2, int i) {
        IMPL.setImeOptions(view2, i);
    }

    public static void setInputType(View view2, int i) {
        IMPL.setInputType(view2, i);
    }

    public static void setOnQueryTextListener(View view2, OnQueryTextListener onQueryTextListener) {
        IMPL.setOnQueryTextListener(view2, onQueryTextListener);
    }

    @Deprecated
    /* loaded from: classes2.dex */
    public static abstract class OnQueryTextListenerCompat implements OnQueryTextListener {
        @Override // android.support.v4.widget.SearchViewCompat.OnQueryTextListener
        public boolean onQueryTextSubmit(String str) {
            return false;
        }

        @Override // android.support.v4.widget.SearchViewCompat.OnQueryTextListener
        public boolean onQueryTextChange(String str) {
            return false;
        }
    }

    public static void setOnCloseListener(View view2, OnCloseListener onCloseListener) {
        IMPL.setOnCloseListener(view2, onCloseListener);
    }

    @Deprecated
    /* loaded from: classes2.dex */
    public static abstract class OnCloseListenerCompat implements OnCloseListener {
        @Override // android.support.v4.widget.SearchViewCompat.OnCloseListener
        public boolean onClose() {
            return false;
        }
    }

    public static CharSequence getQuery(View view2) {
        return IMPL.getQuery(view2);
    }

    public static void setQuery(View view2, CharSequence charSequence, boolean z) {
        IMPL.setQuery(view2, charSequence, z);
    }

    public static void setQueryHint(View view2, CharSequence charSequence) {
        IMPL.setQueryHint(view2, charSequence);
    }

    public static void setIconified(View view2, boolean z) {
        IMPL.setIconified(view2, z);
    }

    public static boolean isIconified(View view2) {
        return IMPL.isIconified(view2);
    }

    public static void setSubmitButtonEnabled(View view2, boolean z) {
        IMPL.setSubmitButtonEnabled(view2, z);
    }

    public static boolean isSubmitButtonEnabled(View view2) {
        return IMPL.isSubmitButtonEnabled(view2);
    }

    public static void setQueryRefinementEnabled(View view2, boolean z) {
        IMPL.setQueryRefinementEnabled(view2, z);
    }

    public static boolean isQueryRefinementEnabled(View view2) {
        return IMPL.isQueryRefinementEnabled(view2);
    }

    public static void setMaxWidth(View view2, int i) {
        IMPL.setMaxWidth(view2, i);
    }
}
