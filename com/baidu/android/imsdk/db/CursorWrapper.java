package com.baidu.android.imsdk.db;

import android.database.Cursor;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class CursorWrapper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "CursorWrapper";
    public transient /* synthetic */ FieldHolder $fh;

    public CursorWrapper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static int getInt(Cursor cursor, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, cursor, str)) == null) {
            if (cursor == null) {
                return 0;
            }
            try {
                int columnIndex = cursor.getColumnIndex(str);
                if (columnIndex == -1) {
                    return 0;
                }
                return cursor.getInt(columnIndex);
            } catch (Exception unused) {
                LogUtils.e(TAG, "error column: " + str);
                return 0;
            }
        }
        return invokeLL.intValue;
    }

    public static long getLong(Cursor cursor, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, cursor, str)) == null) {
            if (cursor == null) {
                return 0L;
            }
            try {
                int columnIndex = cursor.getColumnIndex(str);
                if (columnIndex == -1) {
                    return 0L;
                }
                return cursor.getLong(columnIndex);
            } catch (Exception unused) {
                LogUtils.e(TAG, "error column: " + str);
                return 0L;
            }
        }
        return invokeLL.longValue;
    }

    public static String getString(Cursor cursor, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, cursor, str)) == null) {
            if (cursor == null) {
                return "";
            }
            try {
                int columnIndex = cursor.getColumnIndex(str);
                if (columnIndex == -1) {
                    return "";
                }
                return cursor.getString(columnIndex);
            } catch (Exception unused) {
                LogUtils.e(TAG, "error column: " + str);
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }
}
