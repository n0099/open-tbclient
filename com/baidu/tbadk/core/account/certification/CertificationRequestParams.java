package com.baidu.tbadk.core.account.certification;

import androidx.annotation.Keep;
import com.baidu.sapi2.dto.FaceBaseDTO;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Keep
/* loaded from: classes4.dex */
public class CertificationRequestParams {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ICertificationCallback callback;
    public final String customRealNameUrl;
    public final boolean needCbKey;
    public final int realNameLevel;
    public final String scene;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CertificationRequestParams(ICertificationCallback iCertificationCallback) {
        this(FaceBaseDTO.BUSINESS_SENCE_REALNAME_FACE, false, 0, null, iCertificationCallback);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iCertificationCallback};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], ((Boolean) objArr2[1]).booleanValue(), ((Integer) objArr2[2]).intValue(), (String) objArr2[3], (ICertificationCallback) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public CertificationRequestParams(String str, boolean z, int i, String str2, ICertificationCallback iCertificationCallback) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Boolean.valueOf(z), Integer.valueOf(i), str2, iCertificationCallback};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.scene = str;
        this.needCbKey = z;
        this.realNameLevel = i;
        this.customRealNameUrl = str2;
        this.callback = iCertificationCallback;
    }
}
