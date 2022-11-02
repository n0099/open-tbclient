package com.baidu.searchbox.bddownload.core.breakpoint;

import androidx.annotation.IntRange;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public class BlockInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @IntRange(from = 0)
    public final long contentLength;
    public final AtomicLong currentOffset;
    @IntRange(from = 0)
    public final long startOffset;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BlockInfo(long j, long j2) {
        this(j, j2, 0L);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r9;
            Object[] objArr = {Long.valueOf(j), Long.valueOf(j2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Long) objArr2[0]).longValue(), ((Long) objArr2[1]).longValue(), ((Long) objArr2[2]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public BlockInfo(long j, long j2, @IntRange(from = 0) long j3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (j >= 0 && ((j2 >= 0 || j2 == -1) && j3 >= 0)) {
            this.startOffset = j;
            this.contentLength = j2;
            this.currentOffset = new AtomicLong(j3);
            return;
        }
        throw new IllegalArgumentException();
    }

    public BlockInfo copy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new BlockInfo(this.startOffset, this.contentLength, this.currentOffset.get());
        }
        return (BlockInfo) invokeV.objValue;
    }

    public long getContentLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.contentLength;
        }
        return invokeV.longValue;
    }

    public long getCurrentOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.currentOffset.get();
        }
        return invokeV.longValue;
    }

    public long getRangeLeft() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.startOffset + this.currentOffset.get();
        }
        return invokeV.longValue;
    }

    public long getRangeRight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return (this.startOffset + this.contentLength) - 1;
        }
        return invokeV.longValue;
    }

    public long getStartOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.startOffset;
        }
        return invokeV.longValue;
    }

    public void resetBlock() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.currentOffset.set(0L);
        }
    }

    public void increaseCurrentOffset(@IntRange(from = 1) long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j) == null) {
            this.currentOffset.addAndGet(j);
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return PreferencesUtil.LEFT_MOUNT + this.startOffset + StringUtil.ARRAY_ELEMENT_SEPARATOR + getRangeRight() + ")-current:" + this.currentOffset;
        }
        return (String) invokeV.objValue;
    }
}
