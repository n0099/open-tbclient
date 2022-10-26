package com.baidu.rtc.utils;

import android.database.Cursor;
import android.media.MediaMetadataRetriever;
import android.util.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Closeable;
/* loaded from: classes2.dex */
public class CloseHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "CloseHelper";
    public transient /* synthetic */ FieldHolder $fh;

    public CloseHelper() {
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

    public static void close(Cursor cursor) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, cursor) == null) && cursor != null) {
            try {
                cursor.close();
            } catch (Exception e) {
                Log.e(TAG, e.getMessage());
            }
        }
    }

    public static void close(MediaMetadataRetriever mediaMetadataRetriever) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, mediaMetadataRetriever) == null) && mediaMetadataRetriever != null) {
            try {
                mediaMetadataRetriever.release();
            } catch (Exception e) {
                Log.e(TAG, e.getMessage());
            }
        }
    }

    public static void close(Closeable closeable) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, closeable) == null) && closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
                Log.e(TAG, th.getMessage());
            }
        }
    }
}
