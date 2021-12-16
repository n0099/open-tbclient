package com.baidu.searchbox.logsystem.logsys;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.common.others.java.Supplier;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes10.dex */
public class LogDiskStoreConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEFAULT_LOG_STORE_ROOT_DIR = "log_store";
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public Supplier<File> mLogStoreRootDirSupplier;

    /* loaded from: classes10.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @NonNull
        public Context mContext;
        @Nullable
        public Supplier<File> mLogStoreRootDirSupplier;

        public Builder(@NonNull Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mContext = context;
        }

        @NonNull
        private Builder setLogStoreRootDirSupplier(@Nullable Supplier<File> supplier) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, supplier)) == null) {
                this.mLogStoreRootDirSupplier = supplier;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @NonNull
        public LogDiskStoreConfig build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new LogDiskStoreConfig(this) : (LogDiskStoreConfig) invokeV.objValue;
        }
    }

    public static void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
        }
    }

    @NonNull
    public Supplier<File> getLogStoreRootDirSupplier() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mLogStoreRootDirSupplier : (Supplier) invokeV.objValue;
    }

    public LogDiskStoreConfig(@NonNull Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {builder};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mLogStoreRootDirSupplier = builder.mLogStoreRootDirSupplier == null ? new Supplier<File>(this, builder) { // from class: com.baidu.searchbox.logsystem.logsys.LogDiskStoreConfig.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ LogDiskStoreConfig this$0;
            public final /* synthetic */ Builder val$builder;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this, builder};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
                this.val$builder = builder;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.android.common.others.java.Supplier
            public File get() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    Context applicationContext = this.val$builder.mContext.getApplicationContext();
                    if (applicationContext == null) {
                        applicationContext = this.val$builder.mContext;
                    }
                    return new File(applicationContext.getFilesDir(), LogDiskStoreConfig.DEFAULT_LOG_STORE_ROOT_DIR);
                }
                return (File) invokeV.objValue;
            }
        } : builder.mLogStoreRootDirSupplier;
    }
}
