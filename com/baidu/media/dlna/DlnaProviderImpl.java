package com.baidu.media.dlna;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.cyberplayer.sdk.dlna.CtrlPointProvider;
import com.baidu.cyberplayer.sdk.dlna.DlnaProvider;
import com.baidu.media.duplayer.Keep;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Keep
/* loaded from: classes5.dex */
public class DlnaProviderImpl extends DlnaProvider {
    public static /* synthetic */ Interceptable $ic = null;
    public static String TAG = "DLNA-DlnaProviderImpl";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f42371a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1046740524, "Lcom/baidu/media/dlna/DlnaProviderImpl;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1046740524, "Lcom/baidu/media/dlna/DlnaProviderImpl;");
        }
    }

    public DlnaProviderImpl() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f42371a = false;
        this.f42371a = CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_ENABLE_DLNA, false);
    }

    public static DlnaProvider create() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new DlnaProviderImpl() : (DlnaProvider) invokeV.objValue;
    }

    @Override // com.baidu.cyberplayer.sdk.dlna.DlnaProvider
    public CtrlPointProvider ctrlPoint(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (this.f42371a) {
                return DlnaApi.ctrlPoint(str);
            }
            CyberLog.d(TAG, "ctrlPoint() DLNA not enable");
            return null;
        }
        return (CtrlPointProvider) invokeL.objValue;
    }

    @Override // com.baidu.cyberplayer.sdk.dlna.DlnaProvider
    public void search(DlnaProvider.DlnaSearchListener dlnaSearchListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dlnaSearchListener) == null) {
            if (this.f42371a) {
                DlnaApi.search(dlnaSearchListener);
            } else {
                CyberLog.d(TAG, "search() DLNA not enable");
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.dlna.DlnaProvider
    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.f42371a) {
                DlnaApi.stop();
            } else {
                CyberLog.d(TAG, "stop() DLNA not enable");
            }
        }
    }
}
