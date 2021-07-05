package androidx.recyclerview.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.recyclerview.widget.DiffUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes.dex */
public final class AsyncDifferConfig<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final Executor mBackgroundThreadExecutor;
    @NonNull
    public final DiffUtil.ItemCallback<T> mDiffCallback;
    @Nullable
    public final Executor mMainThreadExecutor;

    /* loaded from: classes.dex */
    public static final class Builder<T> {
        public static /* synthetic */ Interceptable $ic;
        public static Executor sDiffExecutor;
        public static final Object sExecutorLock;
        public transient /* synthetic */ FieldHolder $fh;
        public Executor mBackgroundThreadExecutor;
        public final DiffUtil.ItemCallback<T> mDiffCallback;
        @Nullable
        public Executor mMainThreadExecutor;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1312132174, "Landroidx/recyclerview/widget/AsyncDifferConfig$Builder;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1312132174, "Landroidx/recyclerview/widget/AsyncDifferConfig$Builder;");
                    return;
                }
            }
            sExecutorLock = new Object();
        }

        public Builder(@NonNull DiffUtil.ItemCallback<T> itemCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {itemCallback};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mDiffCallback = itemCallback;
        }

        @NonNull
        public AsyncDifferConfig<T> build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.mBackgroundThreadExecutor == null) {
                    synchronized (sExecutorLock) {
                        if (sDiffExecutor == null) {
                            sDiffExecutor = Executors.newFixedThreadPool(2);
                        }
                    }
                    this.mBackgroundThreadExecutor = sDiffExecutor;
                }
                return new AsyncDifferConfig<>(this.mMainThreadExecutor, this.mBackgroundThreadExecutor, this.mDiffCallback);
            }
            return (AsyncDifferConfig) invokeV.objValue;
        }

        @NonNull
        public Builder<T> setBackgroundThreadExecutor(Executor executor) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, executor)) == null) {
                this.mBackgroundThreadExecutor = executor;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public Builder<T> setMainThreadExecutor(Executor executor) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, executor)) == null) {
                this.mMainThreadExecutor = executor;
                return this;
            }
            return (Builder) invokeL.objValue;
        }
    }

    public AsyncDifferConfig(@Nullable Executor executor, @NonNull Executor executor2, @NonNull DiffUtil.ItemCallback<T> itemCallback) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {executor, executor2, itemCallback};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mMainThreadExecutor = executor;
        this.mBackgroundThreadExecutor = executor2;
        this.mDiffCallback = itemCallback;
    }

    @NonNull
    public Executor getBackgroundThreadExecutor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mBackgroundThreadExecutor : (Executor) invokeV.objValue;
    }

    @NonNull
    public DiffUtil.ItemCallback<T> getDiffCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mDiffCallback : (DiffUtil.ItemCallback) invokeV.objValue;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Executor getMainThreadExecutor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mMainThreadExecutor : (Executor) invokeV.objValue;
    }
}
