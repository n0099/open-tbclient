package androidx.savedstate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.lifecycle.GenericLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.savedstate.Recreator;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
@SuppressLint({"RestrictedApi"})
/* loaded from: classes.dex */
public final class SavedStateRegistry {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String SAVED_COMPONENTS_KEY = "androidx.lifecycle.BundlableSavedStateRegistry.key";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mAllowingSavingState;
    public SafeIterableMap<String, SavedStateProvider> mComponents;
    public Recreator.SavedStateProvider mRecreatorProvider;
    public boolean mRestored;
    @Nullable
    public Bundle mRestoredState;

    /* loaded from: classes.dex */
    public interface AutoRecreated {
        void onRecreated(@NonNull SavedStateRegistryOwner savedStateRegistryOwner);
    }

    /* loaded from: classes.dex */
    public interface SavedStateProvider {
        @NonNull
        Bundle saveState();
    }

    public SavedStateRegistry() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mComponents = new SafeIterableMap<>();
        this.mAllowingSavingState = true;
    }

    @Nullable
    @MainThread
    public Bundle consumeRestoredStateForKey(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (this.mRestored) {
                Bundle bundle = this.mRestoredState;
                if (bundle != null) {
                    Bundle bundle2 = bundle.getBundle(str);
                    this.mRestoredState.remove(str);
                    if (this.mRestoredState.isEmpty()) {
                        this.mRestoredState = null;
                    }
                    return bundle2;
                }
                return null;
            }
            throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
        }
        return (Bundle) invokeL.objValue;
    }

    @MainThread
    public boolean isRestored() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mRestored : invokeV.booleanValue;
    }

    @MainThread
    public void performRestore(@NonNull Lifecycle lifecycle, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, lifecycle, bundle) == null) {
            if (!this.mRestored) {
                if (bundle != null) {
                    this.mRestoredState = bundle.getBundle(SAVED_COMPONENTS_KEY);
                }
                lifecycle.addObserver(new GenericLifecycleObserver(this) { // from class: androidx.savedstate.SavedStateRegistry.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ SavedStateRegistry this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // androidx.lifecycle.LifecycleEventObserver
                    public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(1048576, this, lifecycleOwner, event) == null) {
                            if (event == Lifecycle.Event.ON_START) {
                                this.this$0.mAllowingSavingState = true;
                            } else if (event == Lifecycle.Event.ON_STOP) {
                                this.this$0.mAllowingSavingState = false;
                            }
                        }
                    }
                });
                this.mRestored = true;
                return;
            }
            throw new IllegalStateException("SavedStateRegistry was already restored.");
        }
    }

    @MainThread
    public void performSave(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            Bundle bundle2 = new Bundle();
            Bundle bundle3 = this.mRestoredState;
            if (bundle3 != null) {
                bundle2.putAll(bundle3);
            }
            SafeIterableMap<String, SavedStateProvider>.IteratorWithAdditions iteratorWithAdditions = this.mComponents.iteratorWithAdditions();
            while (iteratorWithAdditions.hasNext()) {
                Map.Entry next = iteratorWithAdditions.next();
                bundle2.putBundle((String) next.getKey(), ((SavedStateProvider) next.getValue()).saveState());
            }
            bundle.putBundle(SAVED_COMPONENTS_KEY, bundle2);
        }
    }

    @MainThread
    public void registerSavedStateProvider(@NonNull String str, @NonNull SavedStateProvider savedStateProvider) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, str, savedStateProvider) == null) && this.mComponents.putIfAbsent(str, savedStateProvider) != null) {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
        }
    }

    @MainThread
    public void runOnNextRecreation(@NonNull Class<? extends AutoRecreated> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cls) == null) {
            if (this.mAllowingSavingState) {
                if (this.mRecreatorProvider == null) {
                    this.mRecreatorProvider = new Recreator.SavedStateProvider(this);
                }
                try {
                    cls.getDeclaredConstructor(new Class[0]);
                    this.mRecreatorProvider.add(cls.getName());
                    return;
                } catch (NoSuchMethodException e) {
                    throw new IllegalArgumentException("Class" + cls.getSimpleName() + " must have default constructor in order to be automatically recreated", e);
                }
            }
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    @MainThread
    public void unregisterSavedStateProvider(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.mComponents.remove(str);
        }
    }
}
