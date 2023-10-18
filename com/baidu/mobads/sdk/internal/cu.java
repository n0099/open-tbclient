package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class cu implements IOAdEventListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ cr a;

    public cu(cr crVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {crVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = crVar;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        int i;
        int i2;
        int i3;
        int i4;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, iOAdEvent) == null) && iOAdEvent != null) {
            try {
                if (iOAdEvent.getData() != null) {
                    Object obj = iOAdEvent.getData().get("intervalpages");
                    Object obj2 = iOAdEvent.getData().get("bannerseconds");
                    Object obj3 = iOAdEvent.getData().get("novelrouter");
                    Object obj4 = iOAdEvent.getData().get("entry");
                    Object obj5 = iOAdEvent.getData().get("channelId");
                    Object obj6 = iOAdEvent.getData().get("contentId");
                    if (obj3 != null) {
                        if (obj != null) {
                            i = ((Integer) obj).intValue();
                        } else {
                            i = 6;
                        }
                        if (obj2 != null) {
                            i2 = ((Integer) obj2).intValue();
                        } else {
                            i2 = 10;
                        }
                        if (obj4 != null) {
                            i3 = ((Integer) obj4).intValue();
                        } else {
                            i3 = 0;
                        }
                        if (obj5 != null) {
                            i4 = ((Integer) obj5).intValue();
                        } else {
                            i4 = 1022;
                        }
                        if (obj6 != null) {
                            str = (String) obj6;
                        } else {
                            str = null;
                        }
                        String str2 = str;
                        JSONObject jSONObject = new JSONObject();
                        if (an.f()) {
                            jSONObject.put("status", "0");
                        } else {
                            jSONObject.put("status", "1");
                        }
                        this.a.a(jSONObject);
                        this.a.a(i, i2, (String) obj3, i3, i4, str2);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
