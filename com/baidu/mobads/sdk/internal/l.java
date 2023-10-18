package com.baidu.mobads.sdk.internal;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.pose.PoseAR;
import com.baidu.mobads.sdk.api.CpuChannelListManager;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class l extends ad {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CpuChannelListManager.CpuChannelListListener q;
    public String r;
    public int s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
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
    }

    @Override // com.baidu.mobads.sdk.internal.ad, com.baidu.mobads.sdk.internal.bf
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.k == null) {
                this.l = false;
                return;
            }
            this.l = true;
            JSONObject jSONObject = new JSONObject();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(IAdInterListener.AdReqParam.PROD, "cpu");
                this.k.createProdHandler(jSONObject2);
                m mVar = new m(this);
                this.k.addEventListener(w.ap, mVar);
                this.k.addEventListener(w.aq, mVar);
                jSONObject.put("appsid", this.r);
                jSONObject.put("subChannelId", this.s);
                jSONObject.put(PoseAR.MDL_START_POSE_FUN_EVENT_TYPE_KEY, "cpu_channelIds");
            } catch (Exception e) {
                e.printStackTrace();
            }
            a(jSONObject);
        }
    }

    public void a(CpuChannelListManager.CpuChannelListListener cpuChannelListListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cpuChannelListListener) == null) {
            this.q = cpuChannelListListener;
        }
    }

    public void a(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i) == null) {
            this.r = str;
            this.s = i;
        }
    }
}
