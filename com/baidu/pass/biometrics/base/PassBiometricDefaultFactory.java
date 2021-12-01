package com.baidu.pass.biometrics.base;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.biometrics.base.callback.PassBiometricCallback;
import com.baidu.pass.biometrics.base.debug.Log;
import com.baidu.pass.biometrics.base.dto.PassBiometricDto;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class PassBiometricDefaultFactory extends PassBiometricFactory {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int VERSION_CODE = 8;
    public static final String VERSION_NAME = "1.5.7";
    public static PassBiometricDefaultFactory a;
    public transient /* synthetic */ FieldHolder $fh;

    public PassBiometricDefaultFactory() {
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

    private PassBiometric a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) ? new PassBiometric(this) { // from class: com.baidu.pass.biometrics.base.PassBiometricDefaultFactory.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PassBiometricDefaultFactory a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.baidu.pass.biometrics.base.PassBiometric
            public void config(PassBiometricConfiguration passBiometricConfiguration) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, passBiometricConfiguration) == null) {
                    Log.e(PassBiometricFactory.class.getSimpleName(), "ERROR with implement Biometric!");
                }
            }

            @Override // com.baidu.pass.biometrics.base.PassBiometric
            public void execute(PassBiometricOperation passBiometricOperation, PassBiometricCallback passBiometricCallback, PassBiometricDto passBiometricDto, Context context) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, passBiometricOperation, passBiometricCallback, passBiometricDto, context) == null) {
                    Log.e(PassBiometricFactory.class.getSimpleName(), "ERROR with implement Biometric!");
                }
            }

            @Override // com.baidu.pass.biometrics.base.PassBiometric
            public void setAgreeDangerousProtocol(boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                    Log.e(PassBiometricFactory.class.getSimpleName(), "setAgreeDangerousProtocol");
                }
            }
        } : (PassBiometric) invokeV.objValue;
    }

    public static PassBiometricDefaultFactory getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (a == null) {
                synchronized (PassBiometricDefaultFactory.class) {
                    if (a == null) {
                        a = new PassBiometricDefaultFactory();
                    }
                }
            }
            return a;
        }
        return (PassBiometricDefaultFactory) invokeV.objValue;
    }

    @Override // com.baidu.pass.biometrics.base.PassBiometricFactory
    public PassBiometric getBiometric(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            try {
                return (PassBiometric) Class.forName(BiometricType.a(i2)).getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            } catch (Exception e2) {
                Log.e(e2);
                return a();
            }
        }
        return (PassBiometric) invokeI.objValue;
    }
}
