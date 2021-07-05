package androidx.core.os;

import android.os.Build;
import android.os.Environment;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
/* loaded from: classes.dex */
public final class EnvironmentCompat {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String MEDIA_UNKNOWN = "unknown";
    public static final String TAG = "EnvironmentCompat";
    public transient /* synthetic */ FieldHolder $fh;

    public EnvironmentCompat() {
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
    public static String getStorageState(@NonNull File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, file)) == null) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 21) {
                return Environment.getExternalStorageState(file);
            }
            if (i2 >= 19) {
                return Environment.getStorageState(file);
            }
            try {
                return file.getCanonicalPath().startsWith(Environment.getExternalStorageDirectory().getCanonicalPath()) ? Environment.getExternalStorageState() : "unknown";
            } catch (IOException e2) {
                Log.w(TAG, "Failed to resolve canonical path: " + e2);
                return "unknown";
            }
        }
        return (String) invokeL.objValue;
    }
}
