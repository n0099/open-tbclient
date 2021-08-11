package com.baidu.ar.face.detector;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class d extends com.baidu.ar.c.a {
    public static /* synthetic */ Interceptable $ic;
    public static final String TAG;
    public transient /* synthetic */ FieldHolder $fh;
    public String oj;
    public a oo;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1258542370, "Lcom/baidu/ar/face/detector/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1258542370, "Lcom/baidu/ar/face/detector/d;");
                return;
            }
        }
        TAG = d.class.getSimpleName();
    }

    public d(n nVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {nVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.oj = "face_animate";
        this.oo = nVar;
        setPriority(10);
    }

    public void aa(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.oj = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.ar.c.a
    /* renamed from: dM */
    public c ay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            c cVar = new c();
            cVar.a(this.oo.ob);
            cVar.g(this.oo.mf);
            a aVar = this.oo;
            cVar.oh = aVar.oh;
            cVar.a(aVar.oc);
            a aVar2 = this.oo;
            cVar.timestamp = aVar2.timestamp;
            cVar.oi = aVar2.oi;
            cVar.oe = aVar2.oe;
            cVar.oj = this.oj;
            cVar.dJ();
            cVar.dH();
            cVar.oc.dX().E(cVar.dL());
            if (cVar.ob != null) {
                return cVar;
            }
            return null;
        }
        return (c) invokeV.objValue;
    }

    @Override // com.baidu.ar.c.a
    public String getTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.oj : (String) invokeV.objValue;
    }
}
