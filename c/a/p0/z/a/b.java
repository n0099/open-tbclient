package c.a.p0.z.a;

import android.content.Context;
import android.webkit.WebResourceResponse;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import androidx.webkit.WebViewAssetLoader;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
/* loaded from: classes5.dex */
public final class b implements WebViewAssetLoader.PathHandler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final File a;

    public b(@NonNull Context context, @NonNull File file) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, file};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        try {
            this.a = new File(a.a(file));
        } catch (IOException e2) {
            throw new IllegalArgumentException("Failed to resolve the canonical path for the given directory: " + file.getPath(), e2);
        }
    }

    @Override // androidx.webkit.WebViewAssetLoader.PathHandler
    @NonNull
    @WorkerThread
    public WebResourceResponse handle(@NonNull String str) {
        InterceptResult invokeL;
        File b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            try {
                b2 = a.b(this.a, str);
            } catch (IOException unused) {
                String str2 = "Error opening the requested path: " + str;
            }
            if (b2 != null) {
                return new WebResourceResponse(a.c(str), null, a.e(b2));
            }
            String.format("The requested file: %s is outside the mounted directory: %s", str, this.a);
            return new WebResourceResponse(null, null, null);
        }
        return (WebResourceResponse) invokeL.objValue;
    }
}
