package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes.dex */
public abstract class FragmentStatePagerAdapter extends PagerAdapter {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT = 1;
    @Deprecated
    public static final int BEHAVIOR_SET_USER_VISIBLE_HINT = 0;
    public static final boolean DEBUG = false;
    public static final String TAG = "FragmentStatePagerAdapt";
    public transient /* synthetic */ FieldHolder $fh;
    public final int mBehavior;
    public FragmentTransaction mCurTransaction;
    public Fragment mCurrentPrimaryItem;
    public boolean mExecutingFinishUpdate;
    public final FragmentManager mFragmentManager;
    public ArrayList<Fragment> mFragments;
    public ArrayList<Fragment.SavedState> mSavedState;

    @NonNull
    public abstract Fragment getItem(int i);

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated
    public FragmentStatePagerAdapter(@NonNull FragmentManager fragmentManager) {
        this(fragmentManager, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fragmentManager};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((FragmentManager) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void startUpdate(@NonNull ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup) != null) || viewGroup.getId() != -1) {
            return;
        }
        throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
    }

    public FragmentStatePagerAdapter(@NonNull FragmentManager fragmentManager, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fragmentManager, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mCurTransaction = null;
        this.mSavedState = new ArrayList<>();
        this.mFragments = new ArrayList<>();
        this.mCurrentPrimaryItem = null;
        this.mFragmentManager = fragmentManager;
        this.mBehavior = i;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
        Fragment.SavedState savedState;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, viewGroup, i, obj) == null) {
            Fragment fragment = (Fragment) obj;
            if (this.mCurTransaction == null) {
                this.mCurTransaction = this.mFragmentManager.beginTransaction();
            }
            while (this.mSavedState.size() <= i) {
                this.mSavedState.add(null);
            }
            ArrayList<Fragment.SavedState> arrayList = this.mSavedState;
            if (fragment.isAdded()) {
                savedState = this.mFragmentManager.saveFragmentInstanceState(fragment);
            } else {
                savedState = null;
            }
            arrayList.set(i, savedState);
            this.mFragments.set(i, null);
            this.mCurTransaction.remove(fragment);
            if (fragment.equals(this.mCurrentPrimaryItem)) {
                this.mCurrentPrimaryItem = null;
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
        Fragment fragment;
        Fragment fragment2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(1048583, this, viewGroup, i, obj) == null) && (fragment = (Fragment) obj) != (fragment2 = this.mCurrentPrimaryItem)) {
            if (fragment2 != null) {
                fragment2.setMenuVisibility(false);
                if (this.mBehavior == 1) {
                    if (this.mCurTransaction == null) {
                        this.mCurTransaction = this.mFragmentManager.beginTransaction();
                    }
                    this.mCurTransaction.setMaxLifecycle(this.mCurrentPrimaryItem, Lifecycle.State.STARTED);
                } else {
                    this.mCurrentPrimaryItem.setUserVisibleHint(false);
                }
            }
            fragment.setMenuVisibility(true);
            if (this.mBehavior == 1) {
                if (this.mCurTransaction == null) {
                    this.mCurTransaction = this.mFragmentManager.beginTransaction();
                }
                this.mCurTransaction.setMaxLifecycle(fragment, Lifecycle.State.RESUMED);
            } else {
                fragment.setUserVisibleHint(true);
            }
            this.mCurrentPrimaryItem = fragment;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void finishUpdate(@NonNull ViewGroup viewGroup) {
        FragmentTransaction fragmentTransaction;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup) == null) && (fragmentTransaction = this.mCurTransaction) != null) {
            if (!this.mExecutingFinishUpdate) {
                try {
                    this.mExecutingFinishUpdate = true;
                    fragmentTransaction.commitNowAllowingStateLoss();
                } finally {
                    this.mExecutingFinishUpdate = false;
                }
            }
            this.mCurTransaction = null;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @NonNull
    public Object instantiateItem(@NonNull ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Fragment.SavedState savedState;
        Fragment fragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, viewGroup, i)) == null) {
            if (this.mFragments.size() > i && (fragment = this.mFragments.get(i)) != null) {
                return fragment;
            }
            if (this.mCurTransaction == null) {
                this.mCurTransaction = this.mFragmentManager.beginTransaction();
            }
            Fragment item = getItem(i);
            if (this.mSavedState.size() > i && (savedState = this.mSavedState.get(i)) != null) {
                item.setInitialSavedState(savedState);
            }
            while (this.mFragments.size() <= i) {
                this.mFragments.add(null);
            }
            item.setMenuVisibility(false);
            if (this.mBehavior == 0) {
                item.setUserVisibleHint(false);
            }
            this.mFragments.set(i, item);
            this.mCurTransaction.add(viewGroup.getId(), item);
            if (this.mBehavior == 1) {
                this.mCurTransaction.setMaxLifecycle(item, Lifecycle.State.STARTED);
            }
            return item;
        }
        return invokeLI.objValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void restoreState(@Nullable Parcelable parcelable, @Nullable ClassLoader classLoader) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048581, this, parcelable, classLoader) == null) && parcelable != null) {
            Bundle bundle = (Bundle) parcelable;
            bundle.setClassLoader(classLoader);
            Parcelable[] parcelableArray = bundle.getParcelableArray("states");
            this.mSavedState.clear();
            this.mFragments.clear();
            if (parcelableArray != null) {
                for (Parcelable parcelable2 : parcelableArray) {
                    this.mSavedState.add((Fragment.SavedState) parcelable2);
                }
            }
            for (String str : bundle.keySet()) {
                if (str.startsWith("f")) {
                    int parseInt = Integer.parseInt(str.substring(1));
                    Fragment fragment = this.mFragmentManager.getFragment(bundle, str);
                    if (fragment != null) {
                        while (this.mFragments.size() <= parseInt) {
                            this.mFragments.add(null);
                        }
                        fragment.setMenuVisibility(false);
                        this.mFragments.set(parseInt, fragment);
                    } else {
                        Log.w(TAG, "Bad fragment at key " + str);
                    }
                }
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@NonNull View view2, @NonNull Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, view2, obj)) == null) {
            if (((Fragment) obj).getView() == view2) {
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @Nullable
    public Parcelable saveState() {
        InterceptResult invokeV;
        Bundle bundle;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.mSavedState.size() > 0) {
                bundle = new Bundle();
                Fragment.SavedState[] savedStateArr = new Fragment.SavedState[this.mSavedState.size()];
                this.mSavedState.toArray(savedStateArr);
                bundle.putParcelableArray("states", savedStateArr);
            } else {
                bundle = null;
            }
            for (int i = 0; i < this.mFragments.size(); i++) {
                Fragment fragment = this.mFragments.get(i);
                if (fragment != null && fragment.isAdded()) {
                    if (bundle == null) {
                        bundle = new Bundle();
                    }
                    this.mFragmentManager.putFragment(bundle, "f" + i, fragment);
                }
            }
            return bundle;
        }
        return (Parcelable) invokeV.objValue;
    }
}
