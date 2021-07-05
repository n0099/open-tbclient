package androidx.lifecycle;

import android.app.Application;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Deprecated
/* loaded from: classes.dex */
public class ViewModelProviders {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Deprecated
    /* loaded from: classes.dex */
    public static class DefaultFactory extends ViewModelProvider.AndroidViewModelFactory {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        @Deprecated
        public DefaultFactory(@NonNull Application application) {
            super(application);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {application};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Application) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    @Deprecated
    public ViewModelProviders() {
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

    @NonNull
    @MainThread
    @Deprecated
    public static ViewModelProvider of(@NonNull Fragment fragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, fragment)) == null) ? new ViewModelProvider(fragment) : (ViewModelProvider) invokeL.objValue;
    }

    @NonNull
    @MainThread
    @Deprecated
    public static ViewModelProvider of(@NonNull FragmentActivity fragmentActivity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, fragmentActivity)) == null) ? new ViewModelProvider(fragmentActivity) : (ViewModelProvider) invokeL.objValue;
    }

    @NonNull
    @MainThread
    @Deprecated
    public static ViewModelProvider of(@NonNull Fragment fragment, @Nullable ViewModelProvider.Factory factory) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, fragment, factory)) == null) {
            if (factory == null) {
                factory = fragment.getDefaultViewModelProviderFactory();
            }
            return new ViewModelProvider(fragment.getViewModelStore(), factory);
        }
        return (ViewModelProvider) invokeLL.objValue;
    }

    @NonNull
    @MainThread
    @Deprecated
    public static ViewModelProvider of(@NonNull FragmentActivity fragmentActivity, @Nullable ViewModelProvider.Factory factory) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65540, null, fragmentActivity, factory)) == null) {
            if (factory == null) {
                factory = fragmentActivity.getDefaultViewModelProviderFactory();
            }
            return new ViewModelProvider(fragmentActivity.getViewModelStore(), factory);
        }
        return (ViewModelProvider) invokeLL.objValue;
    }
}
