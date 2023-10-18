package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import com.baidu.mobads.sdk.api.CpuChannelListManager;
import com.baidu.mobads.sdk.api.CpuChannelResponse;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class n implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ IOAdEvent a;
    public final /* synthetic */ m b;

    public n(m mVar, IOAdEvent iOAdEvent) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mVar, iOAdEvent};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = mVar;
        this.a = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        IOAdEvent iOAdEvent;
        String str;
        CpuChannelListManager.CpuChannelListListener cpuChannelListListener;
        CpuChannelListManager.CpuChannelListListener cpuChannelListListener2;
        CpuChannelListManager.CpuChannelListListener cpuChannelListListener3;
        CpuChannelListManager.CpuChannelListListener cpuChannelListListener4;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (iOAdEvent = this.a) != null && !TextUtils.isEmpty(iOAdEvent.getType())) {
            String type = this.a.getType();
            if (w.ap.equals(type)) {
                List<CpuChannelResponse> a = k.a((JSONArray) this.a.getData().get("cpuChannelList"));
                cpuChannelListListener3 = this.b.a.q;
                if (cpuChannelListListener3 != null) {
                    cpuChannelListListener4 = this.b.a.q;
                    cpuChannelListListener4.onChannelListLoaded(a);
                }
            } else if (w.aq.equals(type)) {
                Map<String, Object> data = this.a.getData();
                int i = 0;
                if (data != null) {
                    str = (String) data.get("error_message");
                    int i2 = data.get("error_code");
                    if (i2 == null) {
                        i2 = 0;
                    }
                    i = ((Integer) i2).intValue();
                } else {
                    str = "";
                }
                cpuChannelListListener = this.b.a.q;
                if (cpuChannelListListener != null) {
                    cpuChannelListListener2 = this.b.a.q;
                    cpuChannelListListener2.onChannelListError(str, i);
                }
            }
        }
    }
}
