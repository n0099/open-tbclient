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
    public final FragmentManager f13310a;

    /* renamed from: b  reason: collision with root package name */
    public FragmentTransaction f13311b = null;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<Fragment.SavedState> f13312c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<Fragment> f13313d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    public Fragment f13314e = null;

    public AbsFragmentStatePagerAdapter(FragmentManager fragmentManager) {
        this.f13310a = fragmentManager;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (this.f13311b == null) {
            this.f13311b = this.f13310a.beginTransaction();
        }
        while (this.f13312c.size() <= i) {
            this.f13312c.add(null);
        }
        this.f13312c.set(i, this.f13310a.saveFragmentInstanceState(fragment));
        this.f13313d.set(i, null);
        this.f13311b.remove(fragment);
    }

    public final ArrayList<Fragment> e() {
        return this.f13313d;
    }

    public void f(boolean z, Fragment fragment) {
        if (fragment == null) {
            return;
        }
        FragmentTransaction beginTransaction = this.f13310a.beginTransaction();
        if (z) {
            beginTransaction.show(fragment);
        } else {
            beginTransaction.hide(fragment);
        }
        beginTransaction.commitAllowingStateLoss();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void finishUpdate(ViewGroup viewGroup) {
        FragmentTransaction fragmentTransaction = this.f13311b;
        if (fragmentTransaction != null) {
            fragmentTransaction.commitAllowingStateLoss();
            this.f13311b = null;
            this.f13310a.executePendingTransactions();
        }
    }

    public abstract Fragment getItem(int i);

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        Fragment.SavedState savedState;
        Fragment fragment;
        if (this.f13313d.size() <= i || (fragment = this.f13313d.get(i)) == null) {
            if (this.f13311b == null) {
                this.f13311b = this.f13310a.beginTransaction();
            }
            Fragment item = getItem(i);
            if (item == null) {
                return null;
            }
            if (this.f13312c.size() > i && (savedState = this.f13312c.get(i)) != null && !item.isAdded()) {
                item.setInitialSavedState(savedState);
            }
            while (this.f13313d.size() <= i) {
                this.f13313d.add(null);
            }
            item.setMenuVisibility(false);
            item.setUserVisibleHint(false);
            this.f13313d.set(i, item);
            this.f13311b.add(viewGroup.getId(), item);
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
            this.f13312c.clear();
            this.f13313d.clear();
            if (parcelableArray != null) {
                for (Parcelable parcelable2 : parcelableArray) {
                    this.f13312c.add((Fragment.SavedState) parcelable2);
                }
            }
            for (String str : bundle.keySet()) {
                if (str.startsWith("f")) {
                    int parseInt = Integer.parseInt(str.substring(1));
                    Fragment fragment = this.f13310a.getFragments() != null ? this.f13310a.getFragment(bundle, str) : null;
                    if (fragment != null) {
                        while (this.f13313d.size() <= parseInt) {
                            this.f13313d.add(null);
                        }
                        fragment.setMenuVisibility(false);
                        this.f13313d.set(parseInt, fragment);
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
        if (this.f13312c.size() > 0) {
            bundle = new Bundle();
            Fragment.SavedState[] savedStateArr = new Fragment.SavedState[this.f13312c.size()];
            this.f13312c.toArray(savedStateArr);
            bundle.putParcelableArray("states", savedStateArr);
        } else {
            bundle = null;
        }
        for (int i = 0; i < this.f13313d.size(); i++) {
            Fragment fragment = this.f13313d.get(i);
            if (fragment != null) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                this.f13310a.putFragment(bundle, "f" + i, fragment);
            }
        }
        return bundle;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        Fragment fragment2 = this.f13314e;
        if (fragment != fragment2) {
            if (fragment2 != null) {
                fragment2.setMenuVisibility(false);
                this.f13314e.setUserVisibleHint(false);
            }
            if (fragment != null) {
                fragment.setMenuVisibility(true);
                fragment.setUserVisibleHint(true);
            }
            this.f13314e = fragment;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void startUpdate(ViewGroup viewGroup) {
    }
}
