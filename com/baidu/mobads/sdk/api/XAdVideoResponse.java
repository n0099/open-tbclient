package com.baidu.mobads.sdk.api;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class XAdVideoResponse implements PrerollVideoResponse {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public XAdNativeResponse adNativeResponse;

    /* renamed from: com.baidu.mobads.sdk.api.XAdVideoResponse$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$mobads$sdk$api$NativeResponse$MaterialType;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1439653906, "Lcom/baidu/mobads/sdk/api/XAdVideoResponse$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1439653906, "Lcom/baidu/mobads/sdk/api/XAdVideoResponse$1;");
                    return;
                }
            }
            int[] iArr = new int[NativeResponse.MaterialType.values().length];
            $SwitchMap$com$baidu$mobads$sdk$api$NativeResponse$MaterialType = iArr;
            try {
                iArr[NativeResponse.MaterialType.VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$mobads$sdk$api$NativeResponse$MaterialType[NativeResponse.MaterialType.NORMAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public XAdVideoResponse(NativeResponse nativeResponse) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {nativeResponse};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.adNativeResponse = (XAdNativeResponse) nativeResponse;
    }

    @Override // com.baidu.mobads.sdk.api.PrerollVideoResponse
    public void handleClick(View view2) {
        XAdNativeResponse xAdNativeResponse;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2) == null) && (xAdNativeResponse = this.adNativeResponse) != null) {
            xAdNativeResponse.handleClick(view2);
        }
    }

    @Override // com.baidu.mobads.sdk.api.PrerollVideoResponse
    public void recordImpression(View view2) {
        XAdNativeResponse xAdNativeResponse;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, view2) == null) && (xAdNativeResponse = this.adNativeResponse) != null) {
            xAdNativeResponse.recordImpression(view2);
        }
    }

    @Override // com.baidu.mobads.sdk.api.PrerollVideoResponse
    public String getAdLogoUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            XAdNativeResponse xAdNativeResponse = this.adNativeResponse;
            if (xAdNativeResponse != null) {
                return xAdNativeResponse.getAdLogoUrl();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.PrerollVideoResponse
    public String getBaiduLogoUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            XAdNativeResponse xAdNativeResponse = this.adNativeResponse;
            if (xAdNativeResponse != null) {
                return xAdNativeResponse.getBaiduLogoUrl();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.PrerollVideoResponse
    public String getDesc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            XAdNativeResponse xAdNativeResponse = this.adNativeResponse;
            if (xAdNativeResponse != null) {
                return xAdNativeResponse.getDesc();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.PrerollVideoResponse
    public String getIconUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            XAdNativeResponse xAdNativeResponse = this.adNativeResponse;
            if (xAdNativeResponse != null) {
                return xAdNativeResponse.getIconUrl();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.PrerollVideoResponse
    public String getImageUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            XAdNativeResponse xAdNativeResponse = this.adNativeResponse;
            if (xAdNativeResponse != null) {
                return xAdNativeResponse.getImageUrl();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.PrerollVideoResponse
    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            XAdNativeResponse xAdNativeResponse = this.adNativeResponse;
            if (xAdNativeResponse != null) {
                return xAdNativeResponse.getTitle();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.PrerollVideoResponse
    public String getVideoUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            XAdNativeResponse xAdNativeResponse = this.adNativeResponse;
            if (xAdNativeResponse != null) {
                return xAdNativeResponse.getVideoUrl();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.PrerollVideoResponse
    public String getMaterialType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            XAdNativeResponse xAdNativeResponse = this.adNativeResponse;
            if (xAdNativeResponse != null) {
                int i = AnonymousClass1.$SwitchMap$com$baidu$mobads$sdk$api$NativeResponse$MaterialType[xAdNativeResponse.getMaterialType().ordinal()];
                if (i != 1) {
                    if (i == 2 && this.adNativeResponse.getImageUrl().contains(".gif")) {
                        return "gif";
                    }
                } else {
                    return "video";
                }
            }
            return "normal";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.PrerollVideoResponse
    public void handleClick(View view2, int i) {
        XAdNativeResponse xAdNativeResponse;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048585, this, view2, i) == null) && (xAdNativeResponse = this.adNativeResponse) != null) {
            xAdNativeResponse.handleClick(view2, i);
        }
    }
}
