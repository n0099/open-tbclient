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
    public final FragmentManager f12518a;

    /* renamed from: b  reason: collision with root package name */
    public FragmentTransaction f12519b = null;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<Fragment.SavedState> f12520c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<Fragment> f12521d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    public Fragment f12522e = null;

    public AbsFragmentStatePagerAdapter(FragmentManager fragmentManager) {
        this.f12518a = fragmentManager;
    }

    public final ArrayList<Fragment> b() {
        return this.f12521d;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (this.f12519b == null) {
            this.f12519b = this.f12518a.beginTransaction();
        }
        while (this.f12520c.size() <= i2) {
            this.f12520c.add(null);
        }
        this.f12520c.set(i2, this.f12518a.saveFragmentInstanceState(fragment));
        this.f12521d.set(i2, null);
        this.f12519b.remove(fragment);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void finishUpdate(ViewGroup viewGroup) {
        FragmentTransaction fragmentTransaction = this.f12519b;
        if (fragmentTransaction != null) {
            fragmentTransaction.commitAllowingStateLoss();
            this.f12519b = null;
            this.f12518a.executePendingTransactions();
        }
    }

    public abstract Fragment getItem(int i2);

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        Fragment.SavedState savedState;
        Fragment fragment;
        if (this.f12521d.size() <= i2 || (fragment = this.f12521d.get(i2)) == null) {
            if (this.f12519b == null) {
                this.f12519b = this.f12518a.beginTransaction();
            }
            Fragment item = getItem(i2);
            if (item == null) {
                return null;
            }
            if (this.f12520c.size() > i2 && (savedState = this.f12520c.get(i2)) != null && !item.isAdded()) {
                item.setInitialSavedState(savedState);
            }
            while (this.f12521d.size() <= i2) {
                this.f12521d.add(null);
            }
            item.setMenuVisibility(false);
            item.setUserVisibleHint(false);
            this.f12521d.set(i2, item);
            this.f12519b.add(viewGroup.getId(), item);
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
            this.f12520c.clear();
            this.f12521d.clear();
            if (parcelableArray != null) {
                for (Parcelable parcelable2 : parcelableArray) {
                    this.f12520c.add((Fragment.SavedState) parcelable2);
                }
            }
            for (String str : bundle.keySet()) {
                if (str.startsWith("f")) {
                    int parseInt = Integer.parseInt(str.substring(1));
                    Fragment fragment = this.f12518a.getFragments() != null ? this.f12518a.getFragment(bundle, str) : null;
                    if (fragment != null) {
                        while (this.f12521d.size() <= parseInt) {
                            this.f12521d.add(null);
                        }
                        fragment.setMenuVisibility(false);
                        this.f12521d.set(parseInt, fragment);
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
        if (this.f12520c.size() > 0) {
            bundle = new Bundle();
            Fragment.SavedState[] savedStateArr = new Fragment.SavedState[this.f12520c.size()];
            this.f12520c.toArray(savedStateArr);
            bundle.putParcelableArray("states", savedStateArr);
        } else {
            bundle = null;
        }
        for (int i2 = 0; i2 < this.f12521d.size(); i2++) {
            Fragment fragment = this.f12521d.get(i2);
            if (fragment != null) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                this.f12518a.putFragment(bundle, "f" + i2, fragment);
            }
        }
        return bundle;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i2, Object obj) {
        Fragment fragment = (Fragment) obj;
        Fragment fragment2 = this.f12522e;
        if (fragment != fragment2) {
            if (fragment2 != null) {
                fragment2.setMenuVisibility(false);
                this.f12522e.setUserVisibleHint(false);
            }
            if (fragment != null) {
                fragment.setMenuVisibility(true);
                fragment.setUserVisibleHint(true);
            }
            this.f12522e = fragment;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void startUpdate(ViewGroup viewGroup) {
    }
}
