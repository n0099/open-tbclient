package com.baidu.mobads.cid.cesium.b;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public a f42651a;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, com.baidu.mobads.cid.cesium.b.a> f42652b;

    /* loaded from: classes5.dex */
    public interface a {
        List<com.baidu.mobads.cid.cesium.b.a> a();
    }

    public b(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f42652b = new HashMap();
        this.f42651a = aVar;
        for (com.baidu.mobads.cid.cesium.b.a aVar2 : aVar.a()) {
            this.f42652b.put(aVar2.a(), aVar2);
        }
    }

    public List<com.baidu.mobads.cid.cesium.b.a> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new ArrayList(this.f42652b.values()) : (List) invokeV.objValue;
    }
}
