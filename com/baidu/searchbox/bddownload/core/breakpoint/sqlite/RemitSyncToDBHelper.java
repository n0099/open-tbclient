package com.baidu.searchbox.bddownload.core.breakpoint.sqlite;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.RemitSyncExecutor;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class RemitSyncToDBHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long delayMillis;
    public final RemitSyncExecutor executor;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RemitSyncToDBHelper(@NonNull RemitSyncExecutor.RemitAgent remitAgent) {
        this(new RemitSyncExecutor(remitAgent));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {remitAgent};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((RemitSyncExecutor) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void discard(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.executor.removePostWithId(i2);
            this.executor.postRemoveInfo(i2);
        }
    }

    public void endAndEnsureToDB(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.executor.removePostWithId(i2);
            try {
                if (this.executor.isFreeToDatabase(i2)) {
                    return;
                }
                this.executor.postSync(i2);
            } finally {
                this.executor.postRemoveFreeId(i2);
            }
        }
    }

    public boolean isNotFreeToDatabase(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? !this.executor.isFreeToDatabase(i2) : invokeI.booleanValue;
    }

    public void onTaskStart(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.executor.removePostWithId(i2);
            this.executor.postSyncInfoDelay(i2, this.delayMillis);
        }
    }

    public void shutdown() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.executor.shutdown();
        }
    }

    public RemitSyncToDBHelper(@NonNull RemitSyncExecutor remitSyncExecutor) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {remitSyncExecutor};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.executor = remitSyncExecutor;
        this.delayMillis = 1500L;
    }
}
