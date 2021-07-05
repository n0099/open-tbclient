package aegon.chrome.net.impl;

import aegon.chrome.net.RequestFinishedInfo;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public final class VersionSafeCallbacks$RequestFinishedInfoListener extends RequestFinishedInfo.Listener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final RequestFinishedInfo.Listener mWrappedListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VersionSafeCallbacks$RequestFinishedInfoListener(RequestFinishedInfo.Listener listener) {
        super(listener.getExecutor());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {listener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Executor) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mWrappedListener = listener;
    }

    @Override // aegon.chrome.net.RequestFinishedInfo.Listener
    public Executor getExecutor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mWrappedListener.getExecutor() : (Executor) invokeV.objValue;
    }

    @Override // aegon.chrome.net.RequestFinishedInfo.Listener
    public void onRequestFinished(RequestFinishedInfo requestFinishedInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, requestFinishedInfo) == null) {
            this.mWrappedListener.onRequestFinished(requestFinishedInfo);
        }
    }
}
