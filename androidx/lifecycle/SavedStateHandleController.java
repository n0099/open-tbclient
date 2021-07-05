package androidx.lifecycle;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class SavedStateHandleController implements LifecycleEventObserver {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG_SAVED_STATE_HANDLE_CONTROLLER = "androidx.lifecycle.savedstate.vm.tag";
    public transient /* synthetic */ FieldHolder $fh;
    public final SavedStateHandle mHandle;
    public boolean mIsAttached;
    public final String mKey;

    /* loaded from: classes.dex */
    public static final class OnRecreation implements SavedStateRegistry.AutoRecreated {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public OnRecreation() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // androidx.savedstate.SavedStateRegistry.AutoRecreated
        public void onRecreated(@NonNull SavedStateRegistryOwner savedStateRegistryOwner) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, savedStateRegistryOwner) == null) {
                if (savedStateRegistryOwner instanceof ViewModelStoreOwner) {
                    ViewModelStore viewModelStore = ((ViewModelStoreOwner) savedStateRegistryOwner).getViewModelStore();
                    SavedStateRegistry savedStateRegistry = savedStateRegistryOwner.getSavedStateRegistry();
                    for (String str : viewModelStore.keys()) {
                        SavedStateHandleController.attachHandleIfNeeded(viewModelStore.get(str), savedStateRegistry, savedStateRegistryOwner.getLifecycle());
                    }
                    if (viewModelStore.keys().isEmpty()) {
                        return;
                    }
                    savedStateRegistry.runOnNextRecreation(OnRecreation.class);
                    return;
                }
                throw new IllegalStateException("Internal error: OnRecreation should be registered only on componentsthat implement ViewModelStoreOwner");
            }
        }
    }

    public SavedStateHandleController(String str, SavedStateHandle savedStateHandle) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, savedStateHandle};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mIsAttached = false;
        this.mKey = str;
        this.mHandle = savedStateHandle;
    }

    public static void attachHandleIfNeeded(ViewModel viewModel, SavedStateRegistry savedStateRegistry, Lifecycle lifecycle) {
        SavedStateHandleController savedStateHandleController;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65537, null, viewModel, savedStateRegistry, lifecycle) == null) || (savedStateHandleController = (SavedStateHandleController) viewModel.getTag("androidx.lifecycle.savedstate.vm.tag")) == null || savedStateHandleController.isAttached()) {
            return;
        }
        savedStateHandleController.attachToLifecycle(savedStateRegistry, lifecycle);
        tryToAddRecreator(savedStateRegistry, lifecycle);
    }

    public static SavedStateHandleController create(SavedStateRegistry savedStateRegistry, Lifecycle lifecycle, String str, Bundle bundle) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, savedStateRegistry, lifecycle, str, bundle)) == null) {
            SavedStateHandleController savedStateHandleController = new SavedStateHandleController(str, SavedStateHandle.createHandle(savedStateRegistry.consumeRestoredStateForKey(str), bundle));
            savedStateHandleController.attachToLifecycle(savedStateRegistry, lifecycle);
            tryToAddRecreator(savedStateRegistry, lifecycle);
            return savedStateHandleController;
        }
        return (SavedStateHandleController) invokeLLLL.objValue;
    }

    public static void tryToAddRecreator(SavedStateRegistry savedStateRegistry, Lifecycle lifecycle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, savedStateRegistry, lifecycle) == null) {
            Lifecycle.State currentState = lifecycle.getCurrentState();
            if (currentState != Lifecycle.State.INITIALIZED && !currentState.isAtLeast(Lifecycle.State.STARTED)) {
                lifecycle.addObserver(new LifecycleEventObserver(lifecycle, savedStateRegistry) { // from class: androidx.lifecycle.SavedStateHandleController.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Lifecycle val$lifecycle;
                    public final /* synthetic */ SavedStateRegistry val$registry;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {lifecycle, savedStateRegistry};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$lifecycle = lifecycle;
                        this.val$registry = savedStateRegistry;
                    }

                    @Override // androidx.lifecycle.LifecycleEventObserver
                    public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeLL(1048576, this, lifecycleOwner, event) == null) && event == Lifecycle.Event.ON_START) {
                            this.val$lifecycle.removeObserver(this);
                            this.val$registry.runOnNextRecreation(OnRecreation.class);
                        }
                    }
                });
            } else {
                savedStateRegistry.runOnNextRecreation(OnRecreation.class);
            }
        }
    }

    public void attachToLifecycle(SavedStateRegistry savedStateRegistry, Lifecycle lifecycle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, savedStateRegistry, lifecycle) == null) {
            if (!this.mIsAttached) {
                this.mIsAttached = true;
                lifecycle.addObserver(this);
                savedStateRegistry.registerSavedStateProvider(this.mKey, this.mHandle.savedStateProvider());
                return;
            }
            throw new IllegalStateException("Already attached to lifecycleOwner");
        }
    }

    public SavedStateHandle getHandle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mHandle : (SavedStateHandle) invokeV.objValue;
    }

    public boolean isAttached() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mIsAttached : invokeV.booleanValue;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, lifecycleOwner, event) == null) && event == Lifecycle.Event.ON_DESTROY) {
            this.mIsAttached = false;
            lifecycleOwner.getLifecycle().removeObserver(this);
        }
    }
}
