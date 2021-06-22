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
    public final FragmentManager f12662a;

    /* renamed from: b  reason: collision with root package name */
    public FragmentTransaction f12663b = null;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<Fragment.SavedState> f12664c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<Fragment> f12665d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    public Fragment f12666e = null;

    public AbsFragmentStatePagerAdapter(FragmentManager fragmentManager) {
        this.f12662a = fragmentManager;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (this.f12663b == null) {
            this.f12663b = this.f12662a.beginTransaction();
        }
        while (this.f12664c.size() <= i2) {
            this.f12664c.add(null);
        }
        this.f12664c.set(i2, this.f12662a.saveFragmentInstanceState(fragment));
        this.f12665d.set(i2, null);
        this.f12663b.remove(fragment);
    }

    public final ArrayList<Fragment> e() {
        return this.f12665d;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void finishUpdate(ViewGroup viewGroup) {
        FragmentTransaction fragmentTransaction = this.f12663b;
        if (fragmentTransaction != null) {
            fragmentTransaction.commitAllowingStateLoss();
            this.f12663b = null;
            this.f12662a.executePendingTransactions();
        }
    }

    public abstract Fragment getItem(int i2);

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        Fragment.SavedState savedState;
        Fragment fragment;
        if (this.f12665d.size() <= i2 || (fragment = this.f12665d.get(i2)) == null) {
            if (this.f12663b == null) {
                this.f12663b = this.f12662a.beginTransaction();
            }
            Fragment item = getItem(i2);
            if (item == null) {
                return null;
            }
            if (this.f12664c.size() > i2 && (savedState = this.f12664c.get(i2)) != null && !item.isAdded()) {
                item.setInitialSavedState(savedState);
            }
            while (this.f12665d.size() <= i2) {
                this.f12665d.add(null);
            }
            item.setMenuVisibility(false);
            item.setUserVisibleHint(false);
            this.f12665d.set(i2, item);
            this.f12663b.add(viewGroup.getId(), item);
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
            this.f12664c.clear();
            this.f12665d.clear();
            if (parcelableArray != null) {
                for (Parcelable parcelable2 : parcelableArray) {
                    this.f12664c.add((Fragment.SavedState) parcelable2);
                }
            }
            for (String str : bundle.keySet()) {
                if (str.startsWith("f")) {
                    int parseInt = Integer.parseInt(str.substring(1));
                    Fragment fragment = this.f12662a.getFragments() != null ? this.f12662a.getFragment(bundle, str) : null;
                    if (fragment != null) {
                        while (this.f12665d.size() <= parseInt) {
                            this.f12665d.add(null);
                        }
                        fragment.setMenuVisibility(false);
                        this.f12665d.set(parseInt, fragment);
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
        if (this.f12664c.size() > 0) {
            bundle = new Bundle();
            Fragment.SavedState[] savedStateArr = new Fragment.SavedState[this.f12664c.size()];
            this.f12664c.toArray(savedStateArr);
            bundle.putParcelableArray("states", savedStateArr);
        } else {
            bundle = null;
        }
        for (int i2 = 0; i2 < this.f12665d.size(); i2++) {
            Fragment fragment = this.f12665d.get(i2);
            if (fragment != null) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                this.f12662a.putFragment(bundle, "f" + i2, fragment);
            }
        }
        return bundle;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i2, Object obj) {
        Fragment fragment = (Fragment) obj;
        Fragment fragment2 = this.f12666e;
        if (fragment != fragment2) {
            if (fragment2 != null) {
                fragment2.setMenuVisibility(false);
                this.f12666e.setUserVisibleHint(false);
            }
            if (fragment != null) {
                fragment.setMenuVisibility(true);
                fragment.setUserVisibleHint(true);
            }
            this.f12666e = fragment;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void startUpdate(ViewGroup viewGroup) {
    }
}
