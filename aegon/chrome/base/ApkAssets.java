package aegon.chrome.base;

import aegon.chrome.base.annotations.CalledByNative;
import android.content.res.AssetFileDescriptor;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
/* loaded from: classes.dex */
public class ApkAssets {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ApkAssets() {
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

    @CalledByNative
    public static long[] open(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            AssetFileDescriptor assetFileDescriptor = null;
            try {
                try {
                    assetFileDescriptor = ContextUtils.sApplicationContext.getAssets().openNonAssetFd(str);
                    long[] jArr = {assetFileDescriptor.getParcelFileDescriptor().detachFd(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength()};
                    try {
                        assetFileDescriptor.close();
                    } catch (IOException e2) {
                        android.util.Log.e("ApkAssets", "Unable to close AssetFileDescriptor", e2);
                    }
                    return jArr;
                } catch (Throwable th) {
                    if (assetFileDescriptor != null) {
                        try {
                            assetFileDescriptor.close();
                        } catch (IOException e3) {
                            android.util.Log.e("ApkAssets", "Unable to close AssetFileDescriptor", e3);
                        }
                    }
                    throw th;
                }
            } catch (IOException e4) {
                if (!e4.getMessage().equals("") && !e4.getMessage().equals(str)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Error while loading asset ");
                    sb.append(str);
                    sb.append(": ");
                    sb.append(e4);
                    android.util.Log.e("ApkAssets", sb.toString());
                }
                long[] jArr2 = {-1, -1, -1};
                if (assetFileDescriptor != null) {
                    try {
                        assetFileDescriptor.close();
                    } catch (IOException e5) {
                        android.util.Log.e("ApkAssets", "Unable to close AssetFileDescriptor", e5);
                    }
                }
                return jArr2;
            }
        }
        return (long[]) invokeL.objValue;
    }
}
