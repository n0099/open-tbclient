package aegon.chrome.net.impl;

import aegon.chrome.net.CronetException;
import aegon.chrome.net.RequestFinishedInfo;
import aegon.chrome.net.UrlResponseInfo;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collection;
/* loaded from: classes.dex */
public class RequestFinishedInfoImpl extends RequestFinishedInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public final CronetException mException;
    public final RequestFinishedInfo.Metrics mMetrics;

    public RequestFinishedInfoImpl(String str, Collection<Object> collection, RequestFinishedInfo.Metrics metrics, int i2, @Nullable UrlResponseInfo urlResponseInfo, @Nullable CronetException cronetException) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, collection, metrics, Integer.valueOf(i2), urlResponseInfo, cronetException};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mMetrics = metrics;
        this.mException = cronetException;
    }
}
