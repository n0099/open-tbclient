package android.support.v13.app;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Parcelable;
import android.support.v4.view.k;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public abstract class FragmentPagerAdapter extends k {
    private static final boolean DEBUG = false;
    private static final String TAG = "FragmentPagerAdapter";
    private FragmentTransaction mCurTransaction = null;
    private Fragment mCurrentPrimaryItem = null;
    private final FragmentManager mFragmentManager;

    public abstract Fragment getItem(int i);

    public FragmentPagerAdapter(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
    }

    @Override // android.support.v4.view.k
    public void startUpdate(ViewGroup viewGroup) {
    }

    @Override // android.support.v4.view.k
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.mCurTransaction == null) {
            this.mCurTransaction = this.mFragmentManager.beginTransaction();
        }
        Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(makeFragmentName(viewGroup.getId(), i));
        if (findFragmentByTag != null) {
            this.mCurTransaction.attach(findFragmentByTag);
        } else {
            findFragmentByTag = getItem(i);
            this.mCurTransaction.add(viewGroup.getId(), findFragmentByTag, makeFragmentName(viewGroup.getId(), i));
        }
        if (findFragmentByTag != this.mCurrentPrimaryItem) {
            FragmentCompat.setMenuVisibility(findFragmentByTag, false);
            FragmentCompat.setUserVisibleHint(findFragmentByTag, false);
        }
        return findFragmentByTag;
    }

    @Override // android.support.v4.view.k
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        if (this.mCurTransaction == null) {
            this.mCurTransaction = this.mFragmentManager.beginTransaction();
        }
        this.mCurTransaction.detach((Fragment) obj);
    }

    @Override // android.support.v4.view.k
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (fragment != this.mCurrentPrimaryItem) {
            if (this.mCurrentPrimaryItem != null) {
                FragmentCompat.setMenuVisibility(this.mCurrentPrimaryItem, false);
                FragmentCompat.setUserVisibleHint(this.mCurrentPrimaryItem, false);
            }
            if (fragment != null) {
                FragmentCompat.setMenuVisibility(fragment, true);
                FragmentCompat.setUserVisibleHint(fragment, true);
            }
            this.mCurrentPrimaryItem = fragment;
        }
    }

    @Override // android.support.v4.view.k
    public void finishUpdate(ViewGroup viewGroup) {
        if (this.mCurTransaction != null) {
            this.mCurTransaction.commitAllowingStateLoss();
            this.mCurTransaction = null;
            this.mFragmentManager.executePendingTransactions();
        }
    }

    @Override // android.support.v4.view.k
    public boolean isViewFromObject(View view, Object obj) {
        return ((Fragment) obj).getView() == view;
    }

    @Override // android.support.v4.view.k
    public Parcelable saveState() {
        return null;
    }

    @Override // android.support.v4.view.k
    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
    }

    private static String makeFragmentName(int i, int i2) {
        return "android:switcher:" + i + ":" + i2;
    }
}
