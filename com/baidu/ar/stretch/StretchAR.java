package com.baidu.ar.stretch;

import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.arplay.representation.Vector3f;
import com.baidu.ar.c;
import com.baidu.ar.d.b;
import com.baidu.ar.d.e;
import com.baidu.ar.d.l;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class StretchAR extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public e mv;
    public StretchDetector xO;

    public StretchAR() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HashMap l(float[] fArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, fArr)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("event_name", "body_tracking_data");
            if (fArr != null && fArr.length > 0) {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                for (int i2 = 0; i2 < 18; i2++) {
                    int i3 = i2 * 3;
                    arrayList2.add(new Vector3f(fArr[i3], fArr[i3 + 1], fArr[i3 + 2]));
                }
                arrayList.add(arrayList2);
                hashMap.put("event_data", arrayList);
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    @Override // com.baidu.ar.c
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            StretchDetector stretchDetector = this.xO;
            if (stretchDetector != null) {
                stretchDetector.av();
                a(this.xO);
            }
            super.release();
        }
    }

    @Override // com.baidu.ar.c
    public void setup(HashMap<String, Object> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hashMap) == null) {
            super.setup(hashMap);
            this.xO = new StretchDetector();
            e eVar = new e(this) { // from class: com.baidu.ar.stretch.StretchAR.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ StretchAR xP;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.xP = this;
                }

                @Override // com.baidu.ar.d.e
                public void a(b bVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, bVar) == null) {
                        StretchAR stretchAR = this.xP;
                        stretchAR.d(stretchAR.l(((a) bVar).fr()));
                    }
                }

                @Override // com.baidu.ar.d.e
                public void a(l lVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lVar) == null) {
                    }
                }

                @Override // com.baidu.ar.d.e
                public void b(l lVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, lVar) == null) {
                    }
                }
            };
            this.mv = eVar;
            a(this.xO, eVar);
            com.baidu.ar.b.a.as().a(getContext(), getMdlConfigs());
            this.xO.b((Bundle) null);
        }
    }
}
