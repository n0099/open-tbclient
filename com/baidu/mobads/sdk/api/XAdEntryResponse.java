package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.api.EntryResponse;
import com.baidu.mobads.sdk.internal.a;
import com.baidu.mobads.sdk.internal.co;
import com.baidu.mobads.sdk.internal.di;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class XAdEntryResponse implements EntryResponse {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "XAdEntryResponse";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isDownloadApp;
    public a mAdInfo;
    public EntryResponse.EntryAdInteractionListener mAdInteractionListener;
    public Context mCxt;
    public di mFeedsProd;
    public co mUriUtils;

    public XAdEntryResponse(Context context, di diVar, a aVar) {
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
        this.isDownloadApp = false;
        this.mCxt = context;
        this.mFeedsProd = diVar;
        this.mAdInfo = aVar;
        if (aVar.p() == 2) {
            this.isDownloadApp = true;
        }
        this.mUriUtils = co.a();
    }

    @Override // com.baidu.mobads.sdk.api.EntryResponse
    public String getAdLogoUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            a aVar = this.mAdInfo;
            if (aVar != null) {
                return aVar.h();
            }
            return "https://cpro.baidustatic.com/cpro/logo/sdk/mob-adIcon_2x.png";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.EntryResponse
    public String getBaiduLogoUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            a aVar = this.mAdInfo;
            if (aVar != null) {
                return aVar.i();
            }
            return "https://cpro.baidustatic.com/cpro/logo/sdk/new-bg-logo.png";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.EntryResponse
    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            a aVar = this.mAdInfo;
            if (aVar != null) {
                return aVar.a();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public String getUniqueId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            a aVar = this.mAdInfo;
            if (aVar != null) {
                return aVar.H();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.EntryResponse
    public boolean isAdAvailable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.mAdInfo == null || System.currentTimeMillis() - this.mAdInfo.y() > this.mAdInfo.F()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void onADExposed() {
        EntryResponse.EntryAdInteractionListener entryAdInteractionListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (entryAdInteractionListener = this.mAdInteractionListener) != null) {
            entryAdInteractionListener.onADExposed();
        }
    }

    public void onAdClick() {
        EntryResponse.EntryAdInteractionListener entryAdInteractionListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (entryAdInteractionListener = this.mAdInteractionListener) != null) {
            entryAdInteractionListener.onAdClick();
        }
    }

    public void onAdUnionClick() {
        EntryResponse.EntryAdInteractionListener entryAdInteractionListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (entryAdInteractionListener = this.mAdInteractionListener) != null) {
            entryAdInteractionListener.onAdUnionClick();
        }
    }

    public void onADExposureFailed(int i) {
        EntryResponse.EntryAdInteractionListener entryAdInteractionListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048582, this, i) == null) && (entryAdInteractionListener = this.mAdInteractionListener) != null) {
            entryAdInteractionListener.onADExposureFailed(i);
        }
    }

    @Override // com.baidu.mobads.sdk.api.EntryResponse
    public void registerViewForInteraction(View view2, List<View> list, List<View> list2, EntryResponse.EntryAdInteractionListener entryAdInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048585, this, view2, list, list2, entryAdInteractionListener) == null) {
            this.mAdInteractionListener = entryAdInteractionListener;
            if (this.mFeedsProd != null) {
                try {
                    HashMap hashMap = new HashMap();
                    hashMap.put("adView", view2);
                    hashMap.put("clickViews", list);
                    hashMap.put("creativeViews", list2);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("msg", "registerViewForInteraction");
                    jSONObject.put("uniqueId", getUniqueId());
                    jSONObject.put("isDownloadApp", this.isDownloadApp);
                    this.mFeedsProd.a(jSONObject, hashMap);
                } catch (Throwable unused) {
                }
            }
        }
    }

    @Override // com.baidu.mobads.sdk.api.EntryResponse
    public void unionLogoClick() {
        co coVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && this.mFeedsProd != null && (coVar = this.mUriUtils) != null) {
            String c = coVar.c("http://union.baidu.com/");
            JSONObject T2 = this.mAdInfo.T();
            try {
                T2.put("unionUrl", c);
                T2.put("msg", "unionLogoClick");
            } catch (Throwable unused) {
            }
            this.mFeedsProd.a(T2);
        }
    }
}
