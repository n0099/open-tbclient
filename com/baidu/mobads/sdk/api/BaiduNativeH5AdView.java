package com.baidu.mobads.sdk.api;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.internal.ar;
import com.baidu.mobads.sdk.internal.dh;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class BaiduNativeH5AdView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaiduNativeAdPlacement mAdPlacement;
    public dh mAdProd;
    public BaiduNativeH5EventListner mAdViewListener;
    public RequestParameters mRequestParameters;

    /* loaded from: classes3.dex */
    public interface BaiduNativeH5EventListner {
        void onAdClick();

        void onAdDataLoaded();

        void onAdFail(String str);

        void onAdShow();
    }

    private void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaiduNativeH5AdView(Context context, int i) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mAdViewListener = null;
        initView(context, i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaiduNativeH5AdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mAdViewListener = null;
        initView(context, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaiduNativeH5AdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mAdViewListener = null;
        initView(context, 0);
    }

    @SuppressLint({"NewApi"})
    private void initView(Context context, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, this, context, i) == null) && i != 0) {
            setBackgroundResource(i);
        }
    }

    private void onDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            cancel();
            dh dhVar = this.mAdProd;
            if (dhVar != null) {
                dhVar.e();
            }
        }
    }

    public BaiduNativeAdPlacement getAdPlacement() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mAdPlacement;
        }
        return (BaiduNativeAdPlacement) invokeV.objValue;
    }

    public boolean isAdDataLoaded() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            dh dhVar = this.mAdProd;
            if (dhVar != null) {
                return dhVar.g();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void recordImpression() {
        BaiduNativeAdPlacement baiduNativeAdPlacement;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (baiduNativeAdPlacement = this.mAdPlacement) != null && baiduNativeAdPlacement.getResponse() != null && !this.mAdPlacement.isWinSended()) {
            this.mAdProd.a(this, this.mAdPlacement.getResponse().T());
        }
    }

    public void makeRequest(RequestParameters requestParameters) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, requestParameters) == null) {
            if (requestParameters == null) {
                requestParameters = new RequestParameters.Builder().build();
            }
            this.mRequestParameters = requestParameters;
            if (this.mAdProd != null) {
                onDetach();
            }
            dh dhVar = new dh(getContext(), "feed", this);
            this.mAdProd = dhVar;
            dhVar.a(requestParameters);
            this.mAdProd.a(this.mAdPlacement);
            this.mAdProd.a(this.mAdPlacement.getSessionId());
            this.mAdProd.c(this.mAdPlacement.getPosistionId());
            this.mAdProd.d(this.mAdPlacement.getSequenceId());
            BaiduNativeH5EventListner baiduNativeH5EventListner = this.mAdViewListener;
            if (baiduNativeH5EventListner != null) {
                this.mAdProd.a(baiduNativeH5EventListner);
            }
            BaiduNativeAdPlacement baiduNativeAdPlacement = this.mAdPlacement;
            if (baiduNativeAdPlacement != null) {
                if (baiduNativeAdPlacement.hasValidResponse()) {
                    if (this.mAdProd.f()) {
                        return;
                    }
                } else {
                    this.mAdProd.c(false);
                    if (this.mAdPlacement.getRequestStarted()) {
                        return;
                    }
                    this.mAdPlacement.setRequestStarted(true);
                }
            }
            this.mAdProd.a();
        }
    }

    public void setAdPlacement(BaiduNativeAdPlacement baiduNativeAdPlacement) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, baiduNativeAdPlacement) == null) {
            this.mAdPlacement = baiduNativeAdPlacement;
        }
    }

    public void setEventListener(BaiduNativeH5EventListner baiduNativeH5EventListner) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, baiduNativeH5EventListner) == null) {
            this.mAdViewListener = baiduNativeH5EventListner;
        }
    }

    public void setAdPlacementData(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, obj) == null) {
            BaiduNativeAdPlacement baiduNativeAdPlacement = new BaiduNativeAdPlacement();
            baiduNativeAdPlacement.setApId((String) ar.a(obj, "getApId", new Class[0], new Object[0]));
            String str = (String) ar.a(obj, "getAppSid", new Class[0], new Object[0]);
            this.mAdPlacement = baiduNativeAdPlacement;
        }
    }
}
