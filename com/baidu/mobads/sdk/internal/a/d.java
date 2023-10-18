package com.baidu.mobads.sdk.internal.a;

import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes3.dex */
public class d implements IOAdEventListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ a a;
    public final /* synthetic */ c b;

    public d(c cVar, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = cVar;
        this.a = aVar;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        Map<String, Object> data;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, iOAdEvent) == null) && iOAdEvent != null && c.h.equals(iOAdEvent.getType()) && (data = iOAdEvent.getData()) != null && !data.isEmpty()) {
            Object obj = data.get(c.k);
            Object obj2 = data.get(c.l);
            Object obj3 = data.get(c.m);
            if ((obj instanceof String) && (obj2 instanceof String)) {
                Object[] objArr = null;
                if (obj3 instanceof Object[]) {
                    objArr = (Object[]) obj3;
                }
                data.put(c.n, this.a.handleEvent((String) obj, (String) obj2, objArr));
            }
        }
    }
}
