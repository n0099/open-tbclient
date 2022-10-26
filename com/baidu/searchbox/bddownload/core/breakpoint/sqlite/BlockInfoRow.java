package com.baidu.searchbox.bddownload.core.breakpoint.sqlite;

import android.database.Cursor;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bddownload.core.breakpoint.BlockInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class BlockInfoRow {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int breakpointId;
    public final long contentLength;
    public final long currentOffset;
    public final long startOffset;

    public BlockInfoRow(Cursor cursor) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cursor};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.breakpointId = cursor.getInt(cursor.getColumnIndex(BreakpointSQLiteKey.HOST_ID));
        this.startOffset = cursor.getInt(cursor.getColumnIndex(BreakpointSQLiteKey.START_OFFSET));
        this.contentLength = cursor.getInt(cursor.getColumnIndex(BreakpointSQLiteKey.CONTENT_LENGTH));
        this.currentOffset = cursor.getInt(cursor.getColumnIndex(BreakpointSQLiteKey.CURRENT_OFFSET));
    }

    public int getBreakpointId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.breakpointId;
        }
        return invokeV.intValue;
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
            return this.currentOffset;
        }
        return invokeV.longValue;
    }

    public long getStartOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.startOffset;
        }
        return invokeV.longValue;
    }

    public BlockInfo toInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return new BlockInfo(this.startOffset, this.contentLength, this.currentOffset);
        }
        return (BlockInfo) invokeV.objValue;
    }
}
