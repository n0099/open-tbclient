package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.internal.ad;
import com.baidu.mobads.sdk.internal.bn;
import com.baidu.mobads.sdk.internal.br;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class NativeCPUManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "NativeCPUManager";
    public transient /* synthetic */ FieldHolder $fh;
    public CPUAdListener mCPUAdListener;
    public ad mCPUAdProd;
    public Context mContext;
    public int mPageSize;
    public HashMap<String, Object> mParams;

    /* loaded from: classes3.dex */
    public interface CPUAdListener {
        void onAdError(String str, int i);

        void onAdLoaded(List<IBasicCPUData> list);

        void onDisLikeAdClick(int i, String str);

        void onExitLp();

        void onLpCustomEventCallBack(HashMap<String, Object> hashMap, DataPostBackListener dataPostBackListener);

        void onVideoDownloadFailed();

        void onVideoDownloadSuccess();
    }

    /* loaded from: classes3.dex */
    public interface DataPostBackListener {
        void postback(JSONObject jSONObject);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1487570460, "Lcom/baidu/mobads/sdk/api/NativeCPUManager;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1487570460, "Lcom/baidu/mobads/sdk/api/NativeCPUManager;");
        }
    }

    public NativeCPUManager(Context context, String str, CPUAdListener cPUAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, cPUAdListener};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mPageSize = 10;
        this.mCPUAdProd = null;
        this.mParams = new HashMap<>();
        if (context != null && !TextUtils.isEmpty(str)) {
            this.mCPUAdListener = cPUAdListener;
            this.mContext = context;
            ad adVar = new ad(context, str, this);
            this.mCPUAdProd = adVar;
            adVar.a(cPUAdListener);
            return;
        }
        br.a().c(TAG, "Init params error!");
        if (cPUAdListener != null) {
            cPUAdListener.onAdError("Input params error.", bn.a.b());
        }
    }

    private void loadAd(int i, int[] iArr, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, this, new Object[]{Integer.valueOf(i), iArr, Boolean.valueOf(z)}) == null) {
            if (i > 0 && iArr != null) {
                ad adVar = this.mCPUAdProd;
                if (adVar != null) {
                    adVar.a(i, this.mPageSize, iArr, z, this.mParams);
                    this.mCPUAdProd.f();
                    this.mCPUAdProd.a();
                    return;
                }
                return;
            }
            br.a().c(TAG, "LoadAd with terrible params!");
        }
    }

    public void loadAd(int i, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            loadAd(i, new int[]{i2}, z);
        }
    }

    public void openAppActivity(String str) {
        ad adVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && (adVar = this.mCPUAdProd) != null) {
            adVar.a(str);
            this.mCPUAdProd.a();
        }
    }

    public void setPageSize(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            if (i > 0 && i <= 20) {
                this.mPageSize = i;
            } else {
                br.a().c(TAG, "Input page size is wrong which should be in (0,20]!");
            }
        }
    }

    public void setRequestParameter(CPUAdRequest cPUAdRequest) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, cPUAdRequest) == null) && cPUAdRequest != null && cPUAdRequest.getExtras() != null) {
            this.mParams = cPUAdRequest.getExtras();
        }
    }

    public void setRequestTimeoutMillis(int i) {
        ad adVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048580, this, i) == null) && (adVar = this.mCPUAdProd) != null) {
            adVar.a(i);
        }
    }
}
