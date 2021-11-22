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
/* loaded from: classes8.dex */
public abstract class AbsFragmentStatePagerAdapter extends PagerAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final FragmentManager f46467a;

    /* renamed from: b  reason: collision with root package name */
    public FragmentTransaction f46468b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<Fragment.SavedState> f46469c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<Fragment> f46470d;

    /* renamed from: e  reason: collision with root package name */
    public Fragment f46471e;

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
        this.f46468b = null;
        this.f46469c = new ArrayList<>();
        this.f46470d = new ArrayList<>();
        this.f46471e = null;
        this.f46467a = fragmentManager;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, viewGroup, i2, obj) == null) {
            Fragment fragment = (Fragment) obj;
            if (this.f46468b == null) {
                this.f46468b = this.f46467a.beginTransaction();
            }
            while (this.f46469c.size() <= i2) {
                this.f46469c.add(null);
            }
            this.f46469c.set(i2, this.f46467a.saveFragmentInstanceState(fragment));
            this.f46470d.set(i2, null);
            this.f46468b.remove(fragment);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void finishUpdate(ViewGroup viewGroup) {
        FragmentTransaction fragmentTransaction;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup) == null) || (fragmentTransaction = this.f46468b) == null) {
            return;
        }
        fragmentTransaction.commitAllowingStateLoss();
        this.f46468b = null;
        this.f46467a.executePendingTransactions();
    }

    public final ArrayList<Fragment> getAllFragments() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f46470d : (ArrayList) invokeV.objValue;
    }

    public abstract Fragment getItem(int i2);

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Fragment.SavedState savedState;
        Fragment fragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, viewGroup, i2)) == null) {
            if (this.f46470d.size() <= i2 || (fragment = this.f46470d.get(i2)) == null) {
                if (this.f46468b == null) {
                    this.f46468b = this.f46467a.beginTransaction();
                }
                Fragment item = getItem(i2);
                if (item == null) {
                    return null;
                }
                if (this.f46469c.size() > i2 && (savedState = this.f46469c.get(i2)) != null && !item.isAdded()) {
                    item.setInitialSavedState(savedState);
                }
                while (this.f46470d.size() <= i2) {
                    this.f46470d.add(null);
                }
                item.setMenuVisibility(false);
                item.setUserVisibleHint(false);
                this.f46470d.set(i2, item);
                this.f46468b.add(viewGroup.getId(), item);
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
        this.f46469c.clear();
        this.f46470d.clear();
        if (parcelableArray != null) {
            for (Parcelable parcelable2 : parcelableArray) {
                this.f46469c.add((Fragment.SavedState) parcelable2);
            }
        }
        for (String str : bundle.keySet()) {
            if (str.startsWith("f")) {
                int parseInt = Integer.parseInt(str.substring(1));
                Fragment fragment = this.f46467a.getFragments() != null ? this.f46467a.getFragment(bundle, str) : null;
                if (fragment != null) {
                    while (this.f46470d.size() <= parseInt) {
                        this.f46470d.add(null);
                    }
                    fragment.setMenuVisibility(false);
                    this.f46470d.set(parseInt, fragment);
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
            if (this.f46469c.size() > 0) {
                bundle = new Bundle();
                Fragment.SavedState[] savedStateArr = new Fragment.SavedState[this.f46469c.size()];
                this.f46469c.toArray(savedStateArr);
                bundle.putParcelableArray("states", savedStateArr);
            } else {
                bundle = null;
            }
            for (int i2 = 0; i2 < this.f46470d.size(); i2++) {
                Fragment fragment = this.f46470d.get(i2);
                if (fragment != null) {
                    if (bundle == null) {
                        bundle = new Bundle();
                    }
                    this.f46467a.putFragment(bundle, "f" + i2, fragment);
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
        if (!(interceptable == null || interceptable.invokeLIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup, i2, obj) == null) || (fragment = (Fragment) obj) == (fragment2 = this.f46471e)) {
            return;
        }
        if (fragment2 != null) {
            fragment2.setMenuVisibility(false);
            this.f46471e.setUserVisibleHint(false);
        }
        if (fragment != null) {
            fragment.setMenuVisibility(true);
            fragment.setUserVisibleHint(true);
        }
        this.f46471e = fragment;
    }

    public void showOrHideFragment(boolean z, Fragment fragment) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048585, this, z, fragment) == null) || fragment == null) {
            return;
        }
        FragmentTransaction beginTransaction = this.f46467a.beginTransaction();
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
