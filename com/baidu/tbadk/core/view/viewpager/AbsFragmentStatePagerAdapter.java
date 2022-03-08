package com.baidu.tbadk.core.view.viewpager;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public abstract class AbsFragmentStatePagerAdapter extends PagerAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final FragmentManager a;

    /* renamed from: b  reason: collision with root package name */
    public FragmentTransaction f39363b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<Fragment.SavedState> f39364c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<Fragment> f39365d;

    /* renamed from: e  reason: collision with root package name */
    public Fragment f39366e;

    public AbsFragmentStatePagerAdapter(FragmentManager fragmentManager) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fragmentManager};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f39363b = null;
        this.f39364c = new ArrayList<>();
        this.f39365d = new ArrayList<>();
        this.f39366e = null;
        this.a = fragmentManager;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, viewGroup, i2, obj) == null) {
            Fragment fragment = (Fragment) obj;
            if (this.f39363b == null) {
                this.f39363b = this.a.beginTransaction();
            }
            while (this.f39364c.size() <= i2) {
                this.f39364c.add(null);
            }
            this.f39364c.set(i2, this.a.saveFragmentInstanceState(fragment));
            this.f39365d.set(i2, null);
            this.f39363b.remove(fragment);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void finishUpdate(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup) == null) || this.f39363b == null || this.a.isDestroyed()) {
            return;
        }
        this.f39363b.commitAllowingStateLoss();
        this.f39363b = null;
        this.a.executePendingTransactions();
    }

    public final ArrayList<Fragment> getAllFragments() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f39365d : (ArrayList) invokeV.objValue;
    }

    public abstract Fragment getItem(int i2);

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Fragment.SavedState savedState;
        Fragment fragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, viewGroup, i2)) == null) {
            if (this.f39365d.size() <= i2 || (fragment = this.f39365d.get(i2)) == null) {
                if (this.f39363b == null) {
                    this.f39363b = this.a.beginTransaction();
                }
                Fragment item = getItem(i2);
                if (item == null) {
                    return null;
                }
                if (this.f39364c.size() > i2 && (savedState = this.f39364c.get(i2)) != null && !item.isAdded()) {
                    item.setInitialSavedState(savedState);
                }
                while (this.f39365d.size() <= i2) {
                    this.f39365d.add(null);
                }
                item.setMenuVisibility(false);
                item.setUserVisibleHint(false);
                this.f39365d.set(i2, item);
                this.f39363b.add(viewGroup.getId(), item);
                return item;
            }
            return fragment;
        }
        return invokeLI.objValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, view, obj)) == null) ? ((Fragment) obj).getView() == view : invokeLL.booleanValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, parcelable, classLoader) == null) || parcelable == null) {
            return;
        }
        Bundle bundle = (Bundle) parcelable;
        bundle.setClassLoader(classLoader);
        Parcelable[] parcelableArray = bundle.getParcelableArray("states");
        this.f39364c.clear();
        this.f39365d.clear();
        if (parcelableArray != null) {
            for (Parcelable parcelable2 : parcelableArray) {
                this.f39364c.add((Fragment.SavedState) parcelable2);
            }
        }
        for (String str : bundle.keySet()) {
            if (str.startsWith("f")) {
                int parseInt = Integer.parseInt(str.substring(1));
                Fragment fragment = this.a.getFragments() != null ? this.a.getFragment(bundle, str) : null;
                if (fragment != null) {
                    while (this.f39365d.size() <= parseInt) {
                        this.f39365d.add(null);
                    }
                    fragment.setMenuVisibility(false);
                    this.f39365d.set(parseInt, fragment);
                } else {
                    String str2 = "Badfragment key " + str;
                }
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Parcelable saveState() {
        InterceptResult invokeV;
        Bundle bundle;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.f39364c.size() > 0) {
                bundle = new Bundle();
                Fragment.SavedState[] savedStateArr = new Fragment.SavedState[this.f39364c.size()];
                this.f39364c.toArray(savedStateArr);
                bundle.putParcelableArray("states", savedStateArr);
            } else {
                bundle = null;
            }
            for (int i2 = 0; i2 < this.f39365d.size(); i2++) {
                Fragment fragment = this.f39365d.get(i2);
                if (fragment != null && fragment.isAdded()) {
                    if (bundle == null) {
                        bundle = new Bundle();
                    }
                    this.a.putFragment(bundle, "f" + i2, fragment);
                }
            }
            return bundle;
        }
        return (Parcelable) invokeV.objValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i2, Object obj) {
        Fragment fragment;
        Fragment fragment2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup, i2, obj) == null) || (fragment = (Fragment) obj) == (fragment2 = this.f39366e)) {
            return;
        }
        if (fragment2 != null) {
            fragment2.setMenuVisibility(false);
            this.f39366e.setUserVisibleHint(false);
        }
        if (fragment != null) {
            fragment.setMenuVisibility(true);
            fragment.setUserVisibleHint(true);
        }
        this.f39366e = fragment;
    }

    public void showOrHideFragment(boolean z, Fragment fragment) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048585, this, z, fragment) == null) || fragment == null) {
            return;
        }
        FragmentTransaction beginTransaction = this.a.beginTransaction();
        if (z) {
            beginTransaction.show(fragment);
        } else {
            beginTransaction.hide(fragment);
        }
        beginTransaction.commitAllowingStateLoss();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void startUpdate(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, viewGroup) == null) {
        }
    }
}
