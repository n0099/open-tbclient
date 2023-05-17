package com.baidu.mapsdkplatform.comapi.map.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.platform.comapi.map.InnerOverlay;
import com.baidu.platform.comapi.map.j;
import com.baidu.platform.comapi.util.JsonBuilder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends InnerOverlay {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<j> a;
    public boolean d;
    public int e;
    public int f;
    public int g;
    public boolean h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a() {
        super(36);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = false;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.a = new ArrayList();
        this.h = true;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.h = true;
            UpdateOverlay();
        }
    }

    @Override // com.baidu.platform.comapi.map.InnerOverlay
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this.a) {
                this.a.clear();
            }
            super.clear();
        }
    }

    public void a(boolean z, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            this.d = z;
            this.e = i;
            this.f = i2;
            this.g = i3;
        }
    }

    public boolean a(j jVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jVar)) == null) {
            synchronized (this.a) {
                if (this.a.contains(jVar)) {
                    return false;
                }
                boolean add = this.a.add(jVar);
                this.h = add;
                return add;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.platform.comapi.map.InnerOverlay
    public void setData(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            super.setData(str);
            this.h = true;
        }
    }

    @Override // com.baidu.platform.comapi.map.InnerOverlay
    public String getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.h) {
                synchronized (this.a) {
                    if (this.a.size() == 0) {
                        return "";
                    }
                    JsonBuilder jsonBuilder = new JsonBuilder();
                    jsonBuilder.object();
                    jsonBuilder.key("dataset").arrayValue();
                    for (j jVar : this.a) {
                        jsonBuilder.objectValue(jVar.a());
                    }
                    jsonBuilder.endArrayValue();
                    jsonBuilder.key("startValue").value(0);
                    jsonBuilder.key("endValue").value(1);
                    if (this.d) {
                        jsonBuilder.key("isNeedRouteAnimate").value(1);
                        jsonBuilder.key("durationTime").value(this.e);
                        jsonBuilder.key("delayTime").value(this.f);
                        jsonBuilder.key("easingCurve").value(this.g);
                        this.d = false;
                    } else {
                        jsonBuilder.key("isNeedRouteAnimate").value(0);
                        jsonBuilder.key("durationTime").value(0);
                        jsonBuilder.key("delayTime").value(0);
                        jsonBuilder.key("easingCurve").value(0);
                    }
                    jsonBuilder.endObject();
                    setData(jsonBuilder.getJson());
                    this.h = false;
                }
            }
            return super.getData();
        }
        return (String) invokeV.objValue;
    }
}
