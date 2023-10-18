package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.api.CPUAggregationManager;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.NativeCPUAggregationData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class aj extends bf {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CPUAggregationManager.CPUAggregationListener a;
    public String q;
    public int r;
    public int s;
    public int t;
    public int[] u;
    public HashMap<String, Object> v;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aj(Context context, String str) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.u = new int[]{1098};
        this.q = str;
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.k == null) {
                this.l = false;
                return;
            }
            this.l = true;
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(IAdInterListener.AdReqParam.PROD, "cpu_hot");
                this.k.createProdHandler(jSONObject3);
                n();
                jSONObject.put(IAdInterListener.AdReqParam.PROD, "cpu_hot");
                jSONObject.put("appsid", this.q);
                jSONObject.put("pageIndex", this.s);
                jSONObject.put("pageSize", this.r);
                jSONObject.put("channels", this.u);
                if (!TextUtils.isEmpty(this.q)) {
                    jSONObject.put("appid", this.q);
                }
                jSONObject2.put("timeout", this.t);
                jSONObject2 = j.a(this.v);
                jSONObject2.put("listScene", 503);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            this.k.loadAd(jSONObject, jSONObject2);
        }
    }

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.t = i;
        }
    }

    public void a(int i, int i2, HashMap<String, Object> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, hashMap) == null) {
            this.s = i;
            this.r = i2;
            this.v = hashMap;
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void a(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) {
            super.a(i, str);
            CPUAggregationManager.CPUAggregationListener cPUAggregationListener = this.a;
            if (cPUAggregationListener != null) {
                cPUAggregationListener.onHotContentError(str, i);
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void b(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, str, i) == null) {
            super.b(str, i);
            CPUAggregationManager.CPUAggregationListener cPUAggregationListener = this.a;
            if (cPUAggregationListener != null) {
                cPUAggregationListener.onHotContentError(str, i);
            }
        }
    }

    public void a(CPUAggregationManager.CPUAggregationListener cPUAggregationListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cPUAggregationListener) == null) {
            this.a = cPUAggregationListener;
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void a(IOAdEvent iOAdEvent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, iOAdEvent) == null) && this.a != null) {
            try {
                ArrayList arrayList = new ArrayList();
                for (Object obj : (List) iOAdEvent.getData().get("cpuHotList")) {
                    arrayList.add(new NativeCPUAggregationData(this.h, obj, this.v));
                }
                this.a.onHotContentLoaded(arrayList);
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void d() {
        CPUAggregationManager.CPUAggregationListener cPUAggregationListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (cPUAggregationListener = this.a) != null) {
            cPUAggregationListener.onExitLp();
        }
    }
}
