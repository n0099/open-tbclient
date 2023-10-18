package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.mobads.sdk.api.ExpressAdData;
import com.baidu.mobads.sdk.api.ExpressResponse;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class bo implements ExpressResponse {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public int b;
    public ExpressResponse.ExpressInteractionListener c;
    public ExpressResponse.ExpressAdDownloadWindowListener d;
    public ExpressResponse.ExpressDislikeListener e;
    public ExpressResponse.ExpressCloseListener f;
    public final di g;
    public final a h;
    public ViewGroup i;
    public ExpressAdData j;

    public bo(Context context, di diVar, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, diVar, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = 1;
        this.a = context;
        this.g = diVar;
        this.h = aVar;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            a aVar = this.h;
            if (aVar != null) {
                return aVar.H();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public void b() {
        ExpressResponse.ExpressInteractionListener expressInteractionListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (expressInteractionListener = this.c) != null) {
            expressInteractionListener.onAdClick();
        }
    }

    public void c() {
        ExpressResponse.ExpressInteractionListener expressInteractionListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (expressInteractionListener = this.c) != null) {
            expressInteractionListener.onAdExposed();
        }
    }

    public void d() {
        ExpressResponse.ExpressDislikeListener expressDislikeListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && (expressDislikeListener = this.e) != null) {
            expressDislikeListener.onDislikeWindowShow();
        }
    }

    public void e() {
        ExpressResponse.ExpressDislikeListener expressDislikeListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && (expressDislikeListener = this.e) != null) {
            expressDislikeListener.onDislikeWindowClose();
        }
    }

    public void f() {
        ExpressResponse.ExpressInteractionListener expressInteractionListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && (expressInteractionListener = this.c) != null) {
            expressInteractionListener.onAdUnionClick();
        }
    }

    public void g() {
        ExpressResponse.ExpressAdDownloadWindowListener expressAdDownloadWindowListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && (expressAdDownloadWindowListener = this.d) != null) {
            expressAdDownloadWindowListener.onADPrivacyClick();
        }
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public int getAdActionType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.b;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public ExpressAdData getAdData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.j;
        }
        return (ExpressAdData) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public String getECPMLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            a aVar = this.h;
            if (aVar != null) {
                return aVar.z();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public View getExpressAdView() {
        InterceptResult invokeV;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (this.i == null && (aVar = this.h) != null) {
                this.i = this.g.a(aVar);
            }
            return this.i;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public int getStyleType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            a aVar = this.h;
            if (aVar != null) {
                return aVar.v();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public void h() {
        ExpressResponse.ExpressAdDownloadWindowListener expressAdDownloadWindowListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && (expressAdDownloadWindowListener = this.d) != null) {
            expressAdDownloadWindowListener.onADFunctionClick();
        }
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public boolean isAdAvailable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            if (this.h == null || System.currentTimeMillis() - this.h.y() > this.h.F()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void render() {
        di diVar;
        a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && (diVar = this.g) != null && (aVar = this.h) != null) {
            if (this.i == null) {
                this.i = diVar.a(aVar);
            }
            this.g.a(this.i, this.h);
        }
    }

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.b = i;
        }
    }

    public void b(boolean z) {
        ExpressResponse.ExpressAdDownloadWindowListener expressAdDownloadWindowListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) && (expressAdDownloadWindowListener = this.d) != null) {
            if (z) {
                expressAdDownloadWindowListener.adDownloadWindowShow();
            } else {
                expressAdDownloadWindowListener.adDownloadWindowClose();
            }
        }
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void biddingFail(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            biddingFail(str, null);
        }
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void biddingSuccess(String str) {
        a aVar;
        di diVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, str) == null) && (aVar = this.h) != null && (diVar = this.g) != null) {
            diVar.a(aVar.H(), true, str);
        }
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void bindInteractionActivity(Activity activity) {
        di diVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, activity) == null) && (diVar = this.g) != null) {
            diVar.b(activity);
        }
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public Object getAdDataForKey(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, str)) == null) {
            if (this.h != null) {
                if (HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID.equals(str)) {
                    return this.h.U();
                }
                return this.h.a(str);
            }
            return null;
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void setAdCloseListener(ExpressResponse.ExpressCloseListener expressCloseListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, expressCloseListener) == null) {
            this.f = expressCloseListener;
        }
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void setAdDislikeListener(ExpressResponse.ExpressDislikeListener expressDislikeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, expressDislikeListener) == null) {
            this.e = expressDislikeListener;
        }
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void setAdPrivacyListener(ExpressResponse.ExpressAdDownloadWindowListener expressAdDownloadWindowListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, expressAdDownloadWindowListener) == null) {
            this.d = expressAdDownloadWindowListener;
        }
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void setInteractionListener(ExpressResponse.ExpressInteractionListener expressInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, expressInteractionListener) == null) {
            this.c = expressInteractionListener;
        }
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public boolean switchTheme(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048607, this, i)) == null) {
            di diVar = this.g;
            if (diVar != null) {
                return diVar.a(this.i, this.h, i);
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public void a(View view2, int i, int i2) {
        ExpressResponse.ExpressInteractionListener expressInteractionListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, view2, i, i2) == null) && (expressInteractionListener = this.c) != null) {
            expressInteractionListener.onAdRenderSuccess(view2, i, i2);
        }
    }

    public void a(View view2, String str, int i) {
        ExpressResponse.ExpressInteractionListener expressInteractionListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(1048579, this, view2, str, i) == null) && (expressInteractionListener = this.c) != null) {
            expressInteractionListener.onAdRenderFail(view2, str, i);
        }
    }

    public void a(ExpressResponse expressResponse) {
        ExpressResponse.ExpressCloseListener expressCloseListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, expressResponse) == null) && (expressCloseListener = this.f) != null) {
            expressCloseListener.onAdClose(expressResponse);
        }
    }

    public void a(String str) {
        di diVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            a aVar = this.h;
            if (aVar != null && (diVar = this.g) != null) {
                this.j = new ExpressAdData(aVar, diVar.h());
            }
            ExpressResponse.ExpressDislikeListener expressDislikeListener = this.e;
            if (expressDislikeListener != null) {
                expressDislikeListener.onDislikeItemClick(str);
            }
        }
    }

    public void a(boolean z) {
        ExpressResponse.ExpressAdDownloadWindowListener expressAdDownloadWindowListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048582, this, z) == null) && (expressAdDownloadWindowListener = this.d) != null) {
            if (z) {
                expressAdDownloadWindowListener.onADPermissionShow();
            } else {
                expressAdDownloadWindowListener.onADPermissionClose();
            }
        }
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void biddingFail(String str, HashMap<String, Object> hashMap) {
        a aVar;
        di diVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048586, this, str, hashMap) == null) && (aVar = this.h) != null && (diVar = this.g) != null) {
            diVar.a(aVar.H(), false, str, hashMap);
        }
    }
}
