package android.support.v4.app;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.TabHost;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class FragmentTabHost extends TabHost implements TabHost.OnTabChangeListener {
    private final ArrayList<ad> a;
    private Context b;
    private t c;
    private int d;
    private TabHost.OnTabChangeListener e;
    private ad f;
    private boolean g;

    /* loaded from: classes.dex */
    class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new ac();
        String a;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.a = parcel.readString();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.a);
        }

        public String toString() {
            return "FragmentTabHost.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " curTab=" + this.a + "}";
        }
    }

    @Override // android.widget.TabHost
    @Deprecated
    public void setup() {
        throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
    }

    @Override // android.widget.TabHost
    public void setOnTabChangedListener(TabHost.OnTabChangeListener onTabChangeListener) {
        this.e = onTabChangeListener;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        String str;
        Fragment fragment;
        Fragment fragment2;
        String str2;
        Fragment fragment3;
        super.onAttachedToWindow();
        String currentTabTag = getCurrentTabTag();
        ae aeVar = null;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.a.size()) {
                break;
            }
            ad adVar = this.a.get(i2);
            t tVar = this.c;
            str = adVar.a;
            adVar.d = tVar.a(str);
            fragment = adVar.d;
            if (fragment != null) {
                fragment2 = adVar.d;
                if (!fragment2.o()) {
                    str2 = adVar.a;
                    if (str2.equals(currentTabTag)) {
                        this.f = adVar;
                    } else {
                        if (aeVar == null) {
                            aeVar = this.c.a();
                        }
                        fragment3 = adVar.d;
                        aeVar.d(fragment3);
                    }
                }
            }
            i = i2 + 1;
        }
        this.g = true;
        ae a = a(currentTabTag, aeVar);
        if (a != null) {
            a.a();
            this.c.b();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.g = false;
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.a = getCurrentTabTag();
        return savedState;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setCurrentTabByTag(savedState.a);
    }

    @Override // android.widget.TabHost.OnTabChangeListener
    public void onTabChanged(String str) {
        ae a;
        if (this.g && (a = a(str, null)) != null) {
            a.a();
        }
        if (this.e != null) {
            this.e.onTabChanged(str);
        }
    }

    private ae a(String str, ae aeVar) {
        Fragment fragment;
        Fragment fragment2;
        Class cls;
        Bundle bundle;
        Fragment fragment3;
        String str2;
        Fragment fragment4;
        Fragment fragment5;
        String str3;
        ad adVar = null;
        int i = 0;
        while (i < this.a.size()) {
            ad adVar2 = this.a.get(i);
            str3 = adVar2.a;
            if (!str3.equals(str)) {
                adVar2 = adVar;
            }
            i++;
            adVar = adVar2;
        }
        if (adVar == null) {
            throw new IllegalStateException("No tab known for tag " + str);
        }
        if (this.f != adVar) {
            if (aeVar == null) {
                aeVar = this.c.a();
            }
            if (this.f != null) {
                fragment4 = this.f.d;
                if (fragment4 != null) {
                    fragment5 = this.f.d;
                    aeVar.d(fragment5);
                }
            }
            if (adVar != null) {
                fragment = adVar.d;
                if (fragment != null) {
                    fragment2 = adVar.d;
                    aeVar.e(fragment2);
                } else {
                    Context context = this.b;
                    cls = adVar.b;
                    String name = cls.getName();
                    bundle = adVar.c;
                    adVar.d = Fragment.a(context, name, bundle);
                    int i2 = this.d;
                    fragment3 = adVar.d;
                    str2 = adVar.a;
                    aeVar.a(i2, fragment3, str2);
                }
            }
            this.f = adVar;
        }
        return aeVar;
    }
}
