package aegon.chrome.net.impl;

import aegon.chrome.net.ExperimentalCronetEngine;
import aegon.chrome.net.ExperimentalUrlRequest;
import aegon.chrome.net.RequestFinishedInfo;
import aegon.chrome.net.UrlRequest;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collection;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public abstract class CronetEngineBase extends ExperimentalCronetEngine {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public CronetEngineBase() {
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

    public abstract UrlRequestBase createRequest(String str, UrlRequest.Callback callback, Executor executor, int i2, Collection<Object> collection, boolean z, boolean z2, boolean z3, boolean z4, int i3, boolean z5, int i4, @Nullable RequestFinishedInfo.Listener listener);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // aegon.chrome.net.CronetEngine
    public ExperimentalUrlRequest.Builder newUrlRequestBuilder(String str, UrlRequest.Callback callback, Executor executor) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, callback, executor)) == null) ? new UrlRequestBuilderImpl(str, callback, executor, this) : (ExperimentalUrlRequest.Builder) invokeLLL.objValue;
    }
}
