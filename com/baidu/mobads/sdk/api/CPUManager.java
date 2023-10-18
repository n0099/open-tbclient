package com.baidu.mobads.sdk.api;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.internal.cw;
import com.baidu.mobads.sdk.internal.cx;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class CPUManager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context mContext;
    public CPUDramaListener mDramaListener;

    public CPUManager(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mContext = context;
    }

    public CPUComponent loadDramaContent(CPUDramaRequestParams cPUDramaRequestParams, CPUDramaListener cPUDramaListener) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, cPUDramaRequestParams, cPUDramaListener)) == null) {
            if (cPUDramaRequestParams == null) {
                if (cPUDramaListener != null) {
                    cPUDramaListener.onContentFailed(-2, "请求失败，请检查请求参数是否为空");
                    return null;
                }
                return null;
            }
            cx cxVar = new cx(this.mContext, cPUDramaRequestParams, cPUDramaListener);
            cxVar.a();
            return new cw(cxVar);
        }
        return (CPUComponent) invokeLL.objValue;
    }

    public void showDramaDetailActivity(CPUDramaRequestParams cPUDramaRequestParams, CPUDramaResponse cPUDramaResponse, CPUDramaListener cPUDramaListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cPUDramaRequestParams, cPUDramaResponse, cPUDramaListener) == null) {
            if (cPUDramaRequestParams == null) {
                if (cPUDramaListener != null) {
                    cPUDramaListener.onContentFailed(-2, "请求失败，请检查请求参数是否为空");
                    return;
                }
                return;
            }
            new cx(this.mContext, cPUDramaRequestParams, cPUDramaResponse, cPUDramaListener).a();
        }
    }
}
