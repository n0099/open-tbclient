package androidx.fragment.app;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public final class FragmentManagerViewModel extends ViewModel {
    public static /* synthetic */ Interceptable $ic = null;
    public static final ViewModelProvider.Factory FACTORY;
    public static final String TAG = "FragmentManager";
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<String, FragmentManagerViewModel> mChildNonConfigs;
    public boolean mHasBeenCleared;
    public boolean mHasSavedSnapshot;
    public final HashMap<String, Fragment> mRetainedFragments;
    public final boolean mStateAutomaticallySaved;
    public final HashMap<String, ViewModelStore> mViewModelStores;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-597232287, "Landroidx/fragment/app/FragmentManagerViewModel;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-597232287, "Landroidx/fragment/app/FragmentManagerViewModel;");
                return;
            }
        }
        FACTORY = new ViewModelProvider.Factory() { // from class: androidx.fragment.app.FragmentManagerViewModel.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // androidx.lifecycle.ViewModelProvider.Factory
            @NonNull
            public <T extends ViewModel> T create(@NonNull Class<T> cls) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, cls)) == null) ? new FragmentManagerViewModel(true) : (T) invokeL.objValue;
            }
        };
    }

    public FragmentManagerViewModel(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mRetainedFragments = new HashMap<>();
        this.mChildNonConfigs = new HashMap<>();
        this.mViewModelStores = new HashMap<>();
        this.mHasBeenCleared = false;
        this.mHasSavedSnapshot = false;
        this.mStateAutomaticallySaved = z;
    }

    @NonNull
    public static FragmentManagerViewModel getInstance(ViewModelStore viewModelStore) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, viewModelStore)) == null) ? (FragmentManagerViewModel) new ViewModelProvider(viewModelStore, FACTORY).get(FragmentManagerViewModel.class) : (FragmentManagerViewModel) invokeL.objValue;
    }

    public boolean addRetainedFragment(@NonNull Fragment fragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fragment)) == null) {
            if (this.mRetainedFragments.containsKey(fragment.mWho)) {
                return false;
            }
            this.mRetainedFragments.put(fragment.mWho, fragment);
            return true;
        }
        return invokeL.booleanValue;
    }

    public void clearNonConfigState(@NonNull Fragment fragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fragment) == null) {
            if (FragmentManager.isLoggingEnabled(3)) {
                String str = "Clearing non-config state for " + fragment;
            }
            FragmentManagerViewModel fragmentManagerViewModel = this.mChildNonConfigs.get(fragment.mWho);
            if (fragmentManagerViewModel != null) {
                fragmentManagerViewModel.onCleared();
                this.mChildNonConfigs.remove(fragment.mWho);
            }
            ViewModelStore viewModelStore = this.mViewModelStores.get(fragment.mWho);
            if (viewModelStore != null) {
                viewModelStore.clear();
                this.mViewModelStores.remove(fragment.mWho);
            }
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj == null || FragmentManagerViewModel.class != obj.getClass()) {
                return false;
            }
            FragmentManagerViewModel fragmentManagerViewModel = (FragmentManagerViewModel) obj;
            return this.mRetainedFragments.equals(fragmentManagerViewModel.mRetainedFragments) && this.mChildNonConfigs.equals(fragmentManagerViewModel.mChildNonConfigs) && this.mViewModelStores.equals(fragmentManagerViewModel.mViewModelStores);
        }
        return invokeL.booleanValue;
    }

    @Nullable
    public Fragment findRetainedFragmentByWho(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? this.mRetainedFragments.get(str) : (Fragment) invokeL.objValue;
    }

    @NonNull
    public FragmentManagerViewModel getChildNonConfig(@NonNull Fragment fragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, fragment)) == null) {
            FragmentManagerViewModel fragmentManagerViewModel = this.mChildNonConfigs.get(fragment.mWho);
            if (fragmentManagerViewModel == null) {
                FragmentManagerViewModel fragmentManagerViewModel2 = new FragmentManagerViewModel(this.mStateAutomaticallySaved);
                this.mChildNonConfigs.put(fragment.mWho, fragmentManagerViewModel2);
                return fragmentManagerViewModel2;
            }
            return fragmentManagerViewModel;
        }
        return (FragmentManagerViewModel) invokeL.objValue;
    }

    @NonNull
    public Collection<Fragment> getRetainedFragments() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mRetainedFragments.values() : (Collection) invokeV.objValue;
    }

    @Nullable
    @Deprecated
    public FragmentManagerNonConfig getSnapshot() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.mRetainedFragments.isEmpty() && this.mChildNonConfigs.isEmpty() && this.mViewModelStores.isEmpty()) {
                return null;
            }
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, FragmentManagerViewModel> entry : this.mChildNonConfigs.entrySet()) {
                FragmentManagerNonConfig snapshot = entry.getValue().getSnapshot();
                if (snapshot != null) {
                    hashMap.put(entry.getKey(), snapshot);
                }
            }
            this.mHasSavedSnapshot = true;
            if (this.mRetainedFragments.isEmpty() && hashMap.isEmpty() && this.mViewModelStores.isEmpty()) {
                return null;
            }
            return new FragmentManagerNonConfig(new ArrayList(this.mRetainedFragments.values()), hashMap, new HashMap(this.mViewModelStores));
        }
        return (FragmentManagerNonConfig) invokeV.objValue;
    }

    @NonNull
    public ViewModelStore getViewModelStore(@NonNull Fragment fragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, fragment)) == null) {
            ViewModelStore viewModelStore = this.mViewModelStores.get(fragment.mWho);
            if (viewModelStore == null) {
                ViewModelStore viewModelStore2 = new ViewModelStore();
                this.mViewModelStores.put(fragment.mWho, viewModelStore2);
                return viewModelStore2;
            }
            return viewModelStore;
        }
        return (ViewModelStore) invokeL.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? (((this.mRetainedFragments.hashCode() * 31) + this.mChildNonConfigs.hashCode()) * 31) + this.mViewModelStores.hashCode() : invokeV.intValue;
    }

    public boolean isCleared() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mHasBeenCleared : invokeV.booleanValue;
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (FragmentManager.isLoggingEnabled(3)) {
                String str = "onCleared called for " + this;
            }
            this.mHasBeenCleared = true;
        }
    }

    public boolean removeRetainedFragment(@NonNull Fragment fragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, fragment)) == null) ? this.mRetainedFragments.remove(fragment.mWho) != null : invokeL.booleanValue;
    }

    @Deprecated
    public void restoreFromSnapshot(@Nullable FragmentManagerNonConfig fragmentManagerNonConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, fragmentManagerNonConfig) == null) {
            this.mRetainedFragments.clear();
            this.mChildNonConfigs.clear();
            this.mViewModelStores.clear();
            if (fragmentManagerNonConfig != null) {
                Collection<Fragment> fragments = fragmentManagerNonConfig.getFragments();
                if (fragments != null) {
                    for (Fragment fragment : fragments) {
                        if (fragment != null) {
                            this.mRetainedFragments.put(fragment.mWho, fragment);
                        }
                    }
                }
                Map<String, FragmentManagerNonConfig> childNonConfigs = fragmentManagerNonConfig.getChildNonConfigs();
                if (childNonConfigs != null) {
                    for (Map.Entry<String, FragmentManagerNonConfig> entry : childNonConfigs.entrySet()) {
                        FragmentManagerViewModel fragmentManagerViewModel = new FragmentManagerViewModel(this.mStateAutomaticallySaved);
                        fragmentManagerViewModel.restoreFromSnapshot(entry.getValue());
                        this.mChildNonConfigs.put(entry.getKey(), fragmentManagerViewModel);
                    }
                }
                Map<String, ViewModelStore> viewModelStores = fragmentManagerNonConfig.getViewModelStores();
                if (viewModelStores != null) {
                    this.mViewModelStores.putAll(viewModelStores);
                }
            }
            this.mHasSavedSnapshot = false;
        }
    }

    public boolean shouldDestroy(@NonNull Fragment fragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, fragment)) == null) {
            if (this.mRetainedFragments.containsKey(fragment.mWho)) {
                if (this.mStateAutomaticallySaved) {
                    return this.mHasBeenCleared;
                }
                return !this.mHasSavedSnapshot;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @NonNull
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append("} Fragments (");
            Iterator<Fragment> it = this.mRetainedFragments.values().iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                if (it.hasNext()) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
            }
            sb.append(") Child Non Config (");
            Iterator<String> it2 = this.mChildNonConfigs.keySet().iterator();
            while (it2.hasNext()) {
                sb.append(it2.next());
                if (it2.hasNext()) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
            }
            sb.append(") ViewModelStores (");
            Iterator<String> it3 = this.mViewModelStores.keySet().iterator();
            while (it3.hasNext()) {
                sb.append(it3.next());
                if (it3.hasNext()) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
            }
            sb.append(')');
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
