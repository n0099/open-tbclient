package com.baidu.sapi2.touchid;

import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.utils.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class FingerprintUtil {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public FingerprintUtil() {
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

    public static int getFingerPrintState(SapiConfiguration sapiConfiguration) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, sapiConfiguration)) == null) {
            if (Build.VERSION.SDK_INT < 23) {
                return 101;
            }
            if (sapiConfiguration.isSupportTouchLogin()) {
                FingerprintManager fingerprintManager = null;
                try {
                    fingerprintManager = (FingerprintManager) sapiConfiguration.context.getSystemService(FingerprintManager.class);
                } catch (Exception e2) {
                    Log.e(e2);
                }
                return (fingerprintManager != null && fingerprintManager.isHardwareDetected() && fingerprintManager.hasEnrolledFingerprints()) ? 0 : 104;
            }
            return 102;
        }
        return invokeL.intValue;
    }
}
