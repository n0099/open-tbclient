package com.baidu.tbadk.core.view.viewpager;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.PagerAdapter;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public abstract class AbsFragmentStatePagerAdapter extends PagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final FragmentManager f13274a;

    /* renamed from: b  reason: collision with root package name */
    public FragmentTransaction f13275b = null;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<Fragment.SavedState> f13276c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<Fragment> f13277d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    public Fragment f13278e = null;

    public AbsFragmentStatePagerAdapter(FragmentManager fragmentManager) {
        this.f13274a = fragmentManager;
    }

    public final ArrayList<Fragment> b() {
        return this.f13277d;
    }

    public void c(boolean z, Fragment fragment) {
        if (fragment == null) {
            return;
        }
        FragmentTransaction beginTransaction = this.f13274a.beginTransaction();
        if (z) {
            beginTransaction.show(fragment);
        } else {
            beginTransaction.hide(fragment);
        }
        beginTransaction.commitAllowingStateLoss();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (this.f13275b == null) {
            this.f13275b = this.f13274a.beginTransaction();
        }
        while (this.f13276c.size() <= i2) {
            this.f13276c.add(null);
        }
        this.f13276c.set(i2, this.f13274a.saveFragmentInstanceState(fragment));
        this.f13277d.set(i2, null);
        this.f13275b.remove(fragment);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void finishUpdate(ViewGroup viewGroup) {
        FragmentTransaction fragmentTransaction = this.f13275b;
        if (fragmentTransaction != null) {
            fragmentTransaction.commitAllowingStateLoss();
            this.f13275b = null;
            this.f13274a.executePendingTransactions();
        }
    }

    public abstract Fragment getItem(int i2);

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        Fragment.SavedState savedState;
        Fragment fragment;
        if (this.f13277d.size() <= i2 || (fragment = this.f13277d.get(i2)) == null) {
            if (this.f13275b == null) {
                this.f13275b = this.f13274a.beginTransaction();
            }
            Fragment item = getItem(i2);
            if (item == null) {
                return null;
            }
            if (this.f13276c.size() > i2 && (savedState = this.f13276c.get(i2)) != null && !item.isAdded()) {
                item.setInitialSavedState(savedState);
            }
            while (this.f13277d.size() <= i2) {
                this.f13277d.add(null);
            }
            item.setMenuVisibility(false);
            item.setUserVisibleHint(false);
            this.f13277d.set(i2, item);
            this.f13275b.add(viewGroup.getId(), item);
            return item;
        }
        return fragment;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return ((Fragment) obj).getView() == view;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
        if (parcelable != null) {
            Bundle bundle = (Bundle) parcelable;
            bundle.setClassLoader(classLoader);
            Parcelable[] parcelableArray = bundle.getParcelableArray("states");
            this.f13276c.clear();
            this.f13277d.clear();
            if (parcelableArray != null) {
                for (Parcelable parcelable2 : parcelableArray) {
                    this.f13276c.add((Fragment.SavedState) parcelable2);
                }
            }
            for (String str : bundle.keySet()) {
                if (str.startsWith("f")) {
                    int parseInt = Integer.parseInt(str.substring(1));
                    Fragment fragment = this.f13274a.getFragments() != null ? this.f13274a.getFragment(bundle, str) : null;
                    if (fragment != null) {
                        while (this.f13277d.size() <= parseInt) {
                            this.f13277d.add(null);
                        }
                        fragment.setMenuVisibility(false);
                        this.f13277d.set(parseInt, fragment);
                    } else {
                        Log.e(FragmentPagerAdapter.TAG, "Badfragment key " + str);
                    }
                }
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Parcelable saveState() {
        Bundle bundle;
        if (this.f13276c.size() > 0) {
            bundle = new Bundle();
            Fragment.SavedState[] savedStateArr = new Fragment.SavedState[this.f13276c.size()];
            this.f13276c.toArray(savedStateArr);
            bundle.putParcelableArray("states", savedStateArr);
        } else {
            bundle = null;
        }
        for (int i2 = 0; i2 < this.f13277d.size(); i2++) {
            Fragment fragment = this.f13277d.get(i2);
            if (fragment != null) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                this.f13274a.putFragment(bundle, "f" + i2, fragment);
            }
        }
        return bundle;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i2, Object obj) {
        Fragment fragment = (Fragment) obj;
        Fragment fragment2 = this.f13278e;
        if (fragment != fragment2) {
            if (fragment2 != null) {
                fragment2.setMenuVisibility(false);
                this.f13278e.setUserVisibleHint(false);
            }
            if (fragment != null) {
                fragment.setMenuVisibility(true);
                fragment.setUserVisibleHint(true);
            }
            this.f13278e = fragment;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void startUpdate(ViewGroup viewGroup) {
    }
}
