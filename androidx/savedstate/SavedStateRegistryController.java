package androidx.savedstate;

import android.os.Bundle;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class SavedStateRegistryController {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final SavedStateRegistryOwner mOwner;
    public final SavedStateRegistry mRegistry;

    public SavedStateRegistryController(SavedStateRegistryOwner savedStateRegistryOwner) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {savedStateRegistryOwner};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mOwner = savedStateRegistryOwner;
        this.mRegistry = new SavedStateRegistry();
    }

    @NonNull
    public static SavedStateRegistryController create(@NonNull SavedStateRegistryOwner savedStateRegistryOwner) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, savedStateRegistryOwner)) == null) ? new SavedStateRegistryController(savedStateRegistryOwner) : (SavedStateRegistryController) invokeL.objValue;
    }

    @NonNull
    public SavedStateRegistry getSavedStateRegistry() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mRegistry : (SavedStateRegistry) invokeV.objValue;
    }

    @MainThread
    public void performRestore(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            Lifecycle lifecycle = this.mOwner.getLifecycle();
            if (lifecycle.getCurrentState() == Lifecycle.State.INITIALIZED) {
                lifecycle.addObserver(new Recreator(this.mOwner));
                this.mRegistry.performRestore(lifecycle, bundle);
                return;
            }
            throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
        }
    }

    @MainThread
    public void performSave(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            this.mRegistry.performSave(bundle);
        }
    }
}
