package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.internal.aj;
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
/* loaded from: classes3.dex */
public class CPUAggregationManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "CPUAggregationManager";
    public transient /* synthetic */ FieldHolder $fh;
    public CPUAggregationListener mCPUListener;
    public Context mContext;
    public aj mNativeCpuAggregation;
    public int mPageSize;
    public HashMap<String, Object> mParams;

    /* loaded from: classes3.dex */
    public interface CPUAggregationListener {
        void onExitLp();

        void onHotContentError(String str, int i);

        void onHotContentLoaded(List<IBasicCPUAggregation> list);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1900440835, "Lcom/baidu/mobads/sdk/api/CPUAggregationManager;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1900440835, "Lcom/baidu/mobads/sdk/api/CPUAggregationManager;");
        }
    }

    public CPUAggregationManager(Context context, String str, CPUAggregationListener cPUAggregationListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, cPUAggregationListener};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mPageSize = 3;
        this.mNativeCpuAggregation = null;
        this.mParams = new HashMap<>();
        if (context != null && !TextUtils.isEmpty(str)) {
            this.mCPUListener = cPUAggregationListener;
            this.mContext = context;
            aj ajVar = new aj(context, str);
            this.mNativeCpuAggregation = ajVar;
            ajVar.a(cPUAggregationListener);
            return;
        }
        br.a().c(TAG, "Init params error!");
        if (cPUAggregationListener != null) {
            cPUAggregationListener.onHotContentError("Input params error.", bn.a.b());
        }
    }

    public void loadAd(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            if (i > 0) {
                aj ajVar = this.mNativeCpuAggregation;
                if (ajVar != null) {
                    ajVar.a(i, this.mPageSize, this.mParams);
                    this.mNativeCpuAggregation.a();
                    return;
                }
                return;
            }
            br.a().c(TAG, "Load with terrible params!");
        }
    }

    public void setPageSize(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            if (i > 0 && i <= 10) {
                this.mPageSize = i;
            } else {
                br.a().c(TAG, "Input page size is wrong which should be in (0,10]!");
            }
        }
    }

    public void setRequestParameter(CPUAggregationRequest cPUAggregationRequest) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cPUAggregationRequest) == null) && cPUAggregationRequest != null && cPUAggregationRequest.getExtras() != null) {
            this.mParams = cPUAggregationRequest.getExtras();
        }
    }

    public void setRequestTimeoutMillis(int i) {
        aj ajVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048579, this, i) == null) && (ajVar = this.mNativeCpuAggregation) != null) {
            ajVar.a(i);
        }
    }
}
