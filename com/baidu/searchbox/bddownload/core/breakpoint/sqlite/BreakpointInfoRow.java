package com.baidu.searchbox.bddownload.core.breakpoint.sqlite;

import android.database.Cursor;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bddownload.core.breakpoint.BreakpointInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes2.dex */
public class BreakpointInfoRow {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean chunked;
    public final String etag;
    public final String filename;
    public final int id;
    public String mimeType;
    public final String parentPath;
    public final boolean taskOnlyProvidedParentPath;
    public final String url;

    public BreakpointInfoRow(Cursor cursor) {
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
        this.id = cursor.getInt(cursor.getColumnIndex("id"));
        this.url = cursor.getString(cursor.getColumnIndex("url"));
        this.etag = cursor.getString(cursor.getColumnIndex("etag"));
        this.parentPath = cursor.getString(cursor.getColumnIndex(BreakpointSQLiteKey.PARENT_PATH));
        this.filename = cursor.getString(cursor.getColumnIndex(BreakpointSQLiteKey.FILENAME));
        this.taskOnlyProvidedParentPath = cursor.getInt(cursor.getColumnIndex(BreakpointSQLiteKey.TASK_ONLY_PARENT_PATH)) == 1;
        this.chunked = cursor.getInt(cursor.getColumnIndex("chunked")) == 1;
        this.mimeType = cursor.getString(cursor.getColumnIndex(BreakpointSQLiteKey.MIME_TYPE));
    }

    public String getEtag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.etag : (String) invokeV.objValue;
    }

    public String getFilename() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.filename : (String) invokeV.objValue;
    }

    public int getId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.id : invokeV.intValue;
    }

    public String getParentPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.parentPath : (String) invokeV.objValue;
    }

    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.url : (String) invokeV.objValue;
    }

    public boolean isChunked() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.chunked : invokeV.booleanValue;
    }

    public boolean isTaskOnlyProvidedParentPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.taskOnlyProvidedParentPath : invokeV.booleanValue;
    }

    public BreakpointInfo toInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            BreakpointInfo breakpointInfo = new BreakpointInfo(this.id, this.url, new File(this.parentPath), this.filename, this.taskOnlyProvidedParentPath);
            breakpointInfo.setEtag(this.etag);
            breakpointInfo.setChunked(this.chunked);
            breakpointInfo.setMimeType(this.mimeType);
            return breakpointInfo;
        }
        return (BreakpointInfo) invokeV.objValue;
    }
}
