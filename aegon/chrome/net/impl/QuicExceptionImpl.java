package aegon.chrome.net.impl;

import aegon.chrome.net.NetworkException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class QuicExceptionImpl extends NetworkException {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final NetworkExceptionImpl mNetworkException;
    public final int mQuicDetailedErrorCode;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QuicExceptionImpl(String str, int i2, int i3, int i4) {
        super(str, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], (Throwable) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mNetworkException = new NetworkExceptionImpl(str, i2, i3);
        this.mQuicDetailedErrorCode = i4;
    }

    @Override // aegon.chrome.net.NetworkException
    public int getErrorCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mNetworkException.mErrorCode : invokeV.intValue;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mNetworkException.getMessage() + ", QuicDetailedErrorCode=" + this.mQuicDetailedErrorCode;
        }
        return (String) invokeV.objValue;
    }
}
