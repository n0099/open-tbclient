package androidx.fragment.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.collection.SimpleArrayMap;
import androidx.core.util.Preconditions;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.loader.app.LoaderManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class FragmentController {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final FragmentHostCallback<?> mHost;

    @Deprecated
    public void dispatchReallyStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
        }
    }

    @Deprecated
    public void doLoaderDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
        }
    }

    @Deprecated
    public void doLoaderRetain() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
        }
    }

    @Deprecated
    public void doLoaderStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
        }
    }

    @Deprecated
    public void doLoaderStop(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
        }
    }

    @Deprecated
    public void dumpLoaders(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048599, this, str, fileDescriptor, printWriter, strArr) == null) {
        }
    }

    @Deprecated
    public void reportLoaderStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
        }
    }

    @Deprecated
    public void restoreLoaderNonConfig(SimpleArrayMap<String, LoaderManager> simpleArrayMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, simpleArrayMap) == null) {
        }
    }

    @Deprecated
    public SimpleArrayMap<String, LoaderManager> retainLoaderNonConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return null;
        }
        return (SimpleArrayMap) invokeV.objValue;
    }

    public FragmentController(FragmentHostCallback<?> fragmentHostCallback) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fragmentHostCallback};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mHost = fragmentHostCallback;
    }

    public static FragmentController createController(FragmentHostCallback<?> fragmentHostCallback) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, fragmentHostCallback)) == null) {
            return new FragmentController((FragmentHostCallback) Preconditions.checkNotNull(fragmentHostCallback, "callbacks == null"));
        }
        return (FragmentController) invokeL.objValue;
    }

    public void attachHost(Fragment fragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, fragment) == null) {
            FragmentHostCallback<?> fragmentHostCallback = this.mHost;
            fragmentHostCallback.mFragmentManager.attachController(fragmentHostCallback, fragmentHostCallback, fragment);
        }
    }

    public void dispatchConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, configuration) == null) {
            this.mHost.mFragmentManager.dispatchConfigurationChanged(configuration);
        }
    }

    public boolean dispatchContextItemSelected(MenuItem menuItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, menuItem)) == null) {
            return this.mHost.mFragmentManager.dispatchContextItemSelected(menuItem);
        }
        return invokeL.booleanValue;
    }

    public void dispatchMultiWindowModeChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.mHost.mFragmentManager.dispatchMultiWindowModeChanged(z);
        }
    }

    public boolean dispatchOptionsItemSelected(MenuItem menuItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, menuItem)) == null) {
            return this.mHost.mFragmentManager.dispatchOptionsItemSelected(menuItem);
        }
        return invokeL.booleanValue;
    }

    public void dispatchOptionsMenuClosed(Menu menu) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, menu) == null) {
            this.mHost.mFragmentManager.dispatchOptionsMenuClosed(menu);
        }
    }

    public void dispatchPictureInPictureModeChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.mHost.mFragmentManager.dispatchPictureInPictureModeChanged(z);
        }
    }

    public boolean dispatchPrepareOptionsMenu(Menu menu) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, menu)) == null) {
            return this.mHost.mFragmentManager.dispatchPrepareOptionsMenu(menu);
        }
        return invokeL.booleanValue;
    }

    public Fragment findFragmentByWho(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, str)) == null) {
            return this.mHost.mFragmentManager.findFragmentByWho(str);
        }
        return (Fragment) invokeL.objValue;
    }

    public List<Fragment> getActiveFragments(List<Fragment> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, list)) == null) {
            return this.mHost.mFragmentManager.getActiveFragments();
        }
        return (List) invokeL.objValue;
    }

    public void restoreSaveState(Parcelable parcelable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, parcelable) == null) {
            FragmentHostCallback<?> fragmentHostCallback = this.mHost;
            if (fragmentHostCallback instanceof ViewModelStoreOwner) {
                fragmentHostCallback.mFragmentManager.restoreSaveState(parcelable);
                return;
            }
            throw new IllegalStateException("Your FragmentHostCallback must implement ViewModelStoreOwner to call restoreSaveState(). Call restoreAllState()  if you're still using retainNestedNonConfig().");
        }
    }

    public void dispatchActivityCreated() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.mHost.mFragmentManager.dispatchActivityCreated();
        }
    }

    public void dispatchCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.mHost.mFragmentManager.dispatchCreate();
        }
    }

    public void dispatchDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.mHost.mFragmentManager.dispatchDestroy();
        }
    }

    public void dispatchDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.mHost.mFragmentManager.dispatchDestroyView();
        }
    }

    public void dispatchLowMemory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.mHost.mFragmentManager.dispatchLowMemory();
        }
    }

    public void dispatchPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.mHost.mFragmentManager.dispatchPause();
        }
    }

    public void dispatchResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.mHost.mFragmentManager.dispatchResume();
        }
    }

    public void dispatchStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.mHost.mFragmentManager.dispatchStart();
        }
    }

    public void dispatchStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.mHost.mFragmentManager.dispatchStop();
        }
    }

    public boolean execPendingActions() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.mHost.mFragmentManager.execPendingActions(true);
        }
        return invokeV.booleanValue;
    }

    public int getActiveFragmentsCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.mHost.mFragmentManager.getActiveFragmentCount();
        }
        return invokeV.intValue;
    }

    public FragmentManager getSupportFragmentManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.mHost.mFragmentManager;
        }
        return (FragmentManager) invokeV.objValue;
    }

    @Deprecated
    public LoaderManager getSupportLoaderManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            throw new UnsupportedOperationException("Loaders are managed separately from FragmentController, use LoaderManager.getInstance() to obtain a LoaderManager.");
        }
        return (LoaderManager) invokeV.objValue;
    }

    public void noteStateNotSaved() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            this.mHost.mFragmentManager.noteStateNotSaved();
        }
    }

    @Deprecated
    public FragmentManagerNonConfig retainNestedNonConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return this.mHost.mFragmentManager.retainNonConfig();
        }
        return (FragmentManagerNonConfig) invokeV.objValue;
    }

    @Deprecated
    public List<Fragment> retainNonConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            FragmentManagerNonConfig retainNonConfig = this.mHost.mFragmentManager.retainNonConfig();
            if (retainNonConfig != null && retainNonConfig.getFragments() != null) {
                return new ArrayList(retainNonConfig.getFragments());
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    public Parcelable saveAllState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return this.mHost.mFragmentManager.saveAllState();
        }
        return (Parcelable) invokeV.objValue;
    }

    public boolean dispatchCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, menu, menuInflater)) == null) {
            return this.mHost.mFragmentManager.dispatchCreateOptionsMenu(menu, menuInflater);
        }
        return invokeLL.booleanValue;
    }

    @Deprecated
    public void restoreAllState(Parcelable parcelable, FragmentManagerNonConfig fragmentManagerNonConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048609, this, parcelable, fragmentManagerNonConfig) == null) {
            this.mHost.mFragmentManager.restoreAllState(parcelable, fragmentManagerNonConfig);
        }
    }

    public View onCreateView(View view2, String str, Context context, AttributeSet attributeSet) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048607, this, view2, str, context, attributeSet)) == null) {
            return this.mHost.mFragmentManager.getLayoutInflaterFactory().onCreateView(view2, str, context, attributeSet);
        }
        return (View) invokeLLLL.objValue;
    }

    @Deprecated
    public void restoreAllState(Parcelable parcelable, List<Fragment> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048610, this, parcelable, list) == null) {
            this.mHost.mFragmentManager.restoreAllState(parcelable, new FragmentManagerNonConfig(list, null, null));
        }
    }
}
