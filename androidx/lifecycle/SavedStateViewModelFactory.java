package androidx.lifecycle;

import android.annotation.SuppressLint;
import android.app.Application;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class SavedStateViewModelFactory extends ViewModelProvider.KeyedFactory {
    public static /* synthetic */ Interceptable $ic;
    public static final Class<?>[] ANDROID_VIEWMODEL_SIGNATURE;
    public static final Class<?>[] VIEWMODEL_SIGNATURE;
    public transient /* synthetic */ FieldHolder $fh;
    public final Application mApplication;
    public final Bundle mDefaultArgs;
    public final ViewModelProvider.AndroidViewModelFactory mFactory;
    public final Lifecycle mLifecycle;
    public final SavedStateRegistry mSavedStateRegistry;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1597604020, "Landroidx/lifecycle/SavedStateViewModelFactory;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1597604020, "Landroidx/lifecycle/SavedStateViewModelFactory;");
                return;
            }
        }
        ANDROID_VIEWMODEL_SIGNATURE = new Class[]{Application.class, SavedStateHandle.class};
        VIEWMODEL_SIGNATURE = new Class[]{SavedStateHandle.class};
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SavedStateViewModelFactory(@NonNull Application application, @NonNull SavedStateRegistryOwner savedStateRegistryOwner) {
        this(application, savedStateRegistryOwner, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {application, savedStateRegistryOwner};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Application) objArr2[0], (SavedStateRegistryOwner) objArr2[1], (Bundle) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static <T> Constructor<T> findMatchingConstructor(Class<T> cls, Class<?>[] clsArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, cls, clsArr)) == null) {
            for (Constructor<?> constructor : cls.getConstructors()) {
                Constructor<T> constructor2 = (Constructor<T>) constructor;
                if (Arrays.equals(clsArr, constructor2.getParameterTypes())) {
                    return constructor2;
                }
            }
            return null;
        }
        return (Constructor) invokeLL.objValue;
    }

    @Override // androidx.lifecycle.ViewModelProvider.KeyedFactory
    @NonNull
    public <T extends ViewModel> T create(@NonNull String str, @NonNull Class<T> cls) {
        InterceptResult invokeLL;
        Constructor findMatchingConstructor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, cls)) == null) {
            boolean isAssignableFrom = AndroidViewModel.class.isAssignableFrom(cls);
            if (isAssignableFrom) {
                findMatchingConstructor = findMatchingConstructor(cls, ANDROID_VIEWMODEL_SIGNATURE);
            } else {
                findMatchingConstructor = findMatchingConstructor(cls, VIEWMODEL_SIGNATURE);
            }
            if (findMatchingConstructor == null) {
                return (T) this.mFactory.create(cls);
            }
            SavedStateHandleController create = SavedStateHandleController.create(this.mSavedStateRegistry, this.mLifecycle, str, this.mDefaultArgs);
            try {
                T t = isAssignableFrom ? (T) findMatchingConstructor.newInstance(this.mApplication, create.getHandle()) : (T) findMatchingConstructor.newInstance(create.getHandle());
                t.setTagIfAbsent("androidx.lifecycle.savedstate.vm.tag", create);
                return t;
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("Failed to access " + cls, e2);
            } catch (InstantiationException e3) {
                throw new RuntimeException("A " + cls + " cannot be instantiated.", e3);
            } catch (InvocationTargetException e4) {
                throw new RuntimeException("An exception happened in constructor of " + cls, e4.getCause());
            }
        }
        return (T) invokeLL.objValue;
    }

    @Override // androidx.lifecycle.ViewModelProvider.OnRequeryFactory
    public void onRequery(@NonNull ViewModel viewModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewModel) == null) {
            SavedStateHandleController.attachHandleIfNeeded(viewModel, this.mSavedStateRegistry, this.mLifecycle);
        }
    }

    @SuppressLint({"LambdaLast"})
    public SavedStateViewModelFactory(@NonNull Application application, @NonNull SavedStateRegistryOwner savedStateRegistryOwner, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {application, savedStateRegistryOwner, bundle};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mSavedStateRegistry = savedStateRegistryOwner.getSavedStateRegistry();
        this.mLifecycle = savedStateRegistryOwner.getLifecycle();
        this.mDefaultArgs = bundle;
        this.mApplication = application;
        this.mFactory = ViewModelProvider.AndroidViewModelFactory.getInstance(application);
    }

    @Override // androidx.lifecycle.ViewModelProvider.KeyedFactory, androidx.lifecycle.ViewModelProvider.Factory
    @NonNull
    public <T extends ViewModel> T create(@NonNull Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cls)) == null) {
            String canonicalName = cls.getCanonicalName();
            if (canonicalName != null) {
                return (T) create(canonicalName, cls);
            }
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        return (T) invokeL.objValue;
    }
}
