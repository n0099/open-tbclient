package com.baidu.platform.comapi.map;

import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public final class af implements com.baidu.platform.comjni.map.basemap.a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "com.baidu.platform.comapi.map.af";
    public transient /* synthetic */ FieldHolder $fh;
    public Map<Long, InnerOverlay> b;
    public AppBaseMap c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-626011973, "Lcom/baidu/platform/comapi/map/af;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-626011973, "Lcom/baidu/platform/comapi/map/af;");
        }
    }

    public af(AppBaseMap appBaseMap) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {appBaseMap};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = new ConcurrentHashMap();
        this.c = null;
        this.c = appBaseMap;
    }

    @Override // com.baidu.platform.comjni.map.basemap.a
    public int a(Bundle bundle, long j, int i) {
        InterceptResult invokeCommon;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{bundle, Long.valueOf(j), Integer.valueOf(i)})) == null) {
            if (z.a) {
                j2 = System.currentTimeMillis();
            } else {
                j2 = 0;
            }
            InnerOverlay innerOverlay = this.b.get(Long.valueOf(j));
            if (innerOverlay != null) {
                String data = innerOverlay.getData();
                if (this.c.LayersIsShow(j)) {
                    bundle.putString("jsondata", data);
                    Bundle param = innerOverlay.getParam();
                    if (param != null) {
                        bundle.putBundle("param", param);
                    }
                } else {
                    bundle.putString("jsondata", null);
                }
                if (z.a) {
                    String str = a;
                    z.a(str, "MapLayerDataReq:" + j + " tag:" + innerOverlay.getLayerTag() + " [" + (System.currentTimeMillis() - j2) + "ms] LayerData:" + data);
                }
                return innerOverlay.getType();
            }
            return 0;
        }
        return invokeCommon.intValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.c != null) {
                for (Long l : this.b.keySet()) {
                    if (l.longValue() > 0) {
                        this.c.ClearLayer(l.longValue());
                        this.c.RemoveLayer(l.longValue());
                    }
                }
            }
            this.b.clear();
        }
    }

    public void a(InnerOverlay innerOverlay) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, innerOverlay) == null) {
            this.b.put(Long.valueOf(innerOverlay.mLayerID), innerOverlay);
            innerOverlay.SetMapParam(innerOverlay.mLayerID, this.c);
        }
    }

    public void a(Overlay overlay) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, overlay) == null) {
            this.b.remove(Long.valueOf(overlay.mLayerID));
        }
    }

    @Override // com.baidu.platform.comjni.map.basemap.a
    public boolean a(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048580, this, j)) == null) {
            return this.b.containsKey(Long.valueOf(j));
        }
        return invokeJ.booleanValue;
    }
}
