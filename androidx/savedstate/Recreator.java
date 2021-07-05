package androidx.savedstate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.lifecycle.GenericLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.savedstate.SavedStateRegistry;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
@SuppressLint({"RestrictedApi"})
/* loaded from: classes.dex */
public final class Recreator implements GenericLifecycleObserver {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CLASSES_KEY = "classes_to_restore";
    public static final String COMPONENT_KEY = "androidx.savedstate.Restarter";
    public transient /* synthetic */ FieldHolder $fh;
    public final SavedStateRegistryOwner mOwner;

    /* loaded from: classes.dex */
    public static final class SavedStateProvider implements SavedStateRegistry.SavedStateProvider {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Set<String> mClasses;

        public SavedStateProvider(SavedStateRegistry savedStateRegistry) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {savedStateRegistry};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mClasses = new HashSet();
            savedStateRegistry.registerSavedStateProvider(Recreator.COMPONENT_KEY, this);
        }

        public void add(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.mClasses.add(str);
            }
        }

        @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
        @NonNull
        public Bundle saveState() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                Bundle bundle = new Bundle();
                bundle.putStringArrayList(Recreator.CLASSES_KEY, new ArrayList<>(this.mClasses));
                return bundle;
            }
            return (Bundle) invokeV.objValue;
        }
    }

    public Recreator(SavedStateRegistryOwner savedStateRegistryOwner) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {savedStateRegistryOwner};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mOwner = savedStateRegistryOwner;
    }

    private void reflectiveNew(String str) {
        Class cls;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, str) == null) {
            try {
                try {
                    Constructor declaredConstructor = Class.forName(str, false, Recreator.class.getClassLoader()).asSubclass(SavedStateRegistry.AutoRecreated.class).getDeclaredConstructor(new Class[0]);
                    declaredConstructor.setAccessible(true);
                    try {
                        ((SavedStateRegistry.AutoRecreated) declaredConstructor.newInstance(new Object[0])).onRecreated(this.mOwner);
                    } catch (Exception e2) {
                        throw new RuntimeException("Failed to instantiate " + str, e2);
                    }
                } catch (NoSuchMethodException e3) {
                    throw new IllegalStateException("Class" + cls.getSimpleName() + " must have default constructor in order to be automatically recreated", e3);
                }
            } catch (ClassNotFoundException e4) {
                throw new RuntimeException("Class " + str + " wasn't found", e4);
            }
        }
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, lifecycleOwner, event) == null) {
            if (event == Lifecycle.Event.ON_CREATE) {
                lifecycleOwner.getLifecycle().removeObserver(this);
                Bundle consumeRestoredStateForKey = this.mOwner.getSavedStateRegistry().consumeRestoredStateForKey(COMPONENT_KEY);
                if (consumeRestoredStateForKey == null) {
                    return;
                }
                ArrayList<String> stringArrayList = consumeRestoredStateForKey.getStringArrayList(CLASSES_KEY);
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        reflectiveNew(it.next());
                    }
                    return;
                }
                throw new IllegalStateException("Bundle with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
            }
            throw new AssertionError("Next event must be ON_CREATE");
        }
    }
}
