package com.baidu.android.util.io;

import android.database.Cursor;
import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Closeable;
import java.io.IOException;
/* loaded from: classes.dex */
public final class Closeables {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "Closeables";
    public transient /* synthetic */ FieldHolder $fh;

    public Closeables() {
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

    public static void close(@Nullable Closeable closeable, boolean z) throws IOException {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(65537, null, closeable, z) != null) || closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException e) {
            if (z) {
                Log.d(TAG, "IOException thrown while closing Closeable.", e);
                return;
            }
            throw e;
        }
    }

    public static void closeSafely(Cursor cursor) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, cursor) == null) && cursor != null) {
            try {
                if (!cursor.isClosed()) {
                    cursor.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeSafely(@Nullable Closeable closeable) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, closeable) == null) && closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
