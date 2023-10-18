package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import com.baidu.mobads.sdk.api.CPUDramaListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class cz implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ IOAdEvent a;
    public final /* synthetic */ cy b;

    public cz(cy cyVar, IOAdEvent iOAdEvent) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cyVar, iOAdEvent};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = cyVar;
        this.a = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        IOAdEvent iOAdEvent;
        CPUDramaListener cPUDramaListener;
        String str;
        CPUDramaListener cPUDramaListener2;
        CPUDramaListener cPUDramaListener3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (iOAdEvent = this.a) != null && !TextUtils.isEmpty(iOAdEvent.getType())) {
            String type = this.a.getType();
            cPUDramaListener = this.b.a.s;
            if (cPUDramaListener == null) {
                return;
            }
            if (!"onContentLoaded".equals(type)) {
                if ("onContentFailed".equals(type)) {
                    HashMap hashMap = (HashMap) this.a.getData();
                    int i = 0;
                    if (hashMap != null) {
                        str = (String) hashMap.get("error_message");
                        int i2 = hashMap.get("error_code");
                        if (i2 == null) {
                            i2 = 0;
                        }
                        i = ((Integer) i2).intValue();
                    } else {
                        str = "";
                    }
                    cPUDramaListener2 = this.b.a.s;
                    cPUDramaListener2.onContentFailed(i, str);
                    return;
                } else if (!w.ar.equals(type)) {
                    if (!w.as.equals(type)) {
                        return;
                    }
                    this.b.a.m(this.a);
                    return;
                } else {
                    this.b.a.l(this.a);
                    return;
                }
            }
            cPUDramaListener3 = this.b.a.s;
            cPUDramaListener3.onContentLoaded();
        }
    }
}
