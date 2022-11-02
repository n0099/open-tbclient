package com.baidu.ar.objdetect;

import android.graphics.PointF;
import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.arrender.l;
import com.baidu.ar.c;
import com.baidu.ar.d.b;
import com.baidu.ar.d.e;
import com.baidu.ar.gesture.GestureAR;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class ObjDetectAR extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public e mv;
    public ObjDetectDetector tx;

    public ObjDetectAR() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HashMap k(float[] fArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, fArr)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("event_name", "object_detect");
            int i = (int) fArr[0];
            ArrayList arrayList = new ArrayList();
            l r = r();
            if (r == null) {
                hashMap.put("event_data", arrayList);
                return hashMap;
            }
            for (int i2 = 0; i2 < i; i2++) {
                int i3 = (i2 * 7) + 1;
                HashMap hashMap2 = new HashMap();
                PointF pointF = new PointF(fArr[i3 + 3], fArr[i3 + 4]);
                r.a(pointF, true);
                PointF pointF2 = new PointF(fArr[i3 + 5], fArr[i3 + 6]);
                r.a(pointF2, true);
                hashMap2.put("object_id", Float.valueOf(fArr[i3]));
                hashMap2.put("category", 3);
                hashMap2.put("score", Float.valueOf(fArr[i3 + 2]));
                hashMap2.put(GestureAR.SDK_TO_LUA_GESTURE_RESULT_X1, Float.valueOf(pointF.x));
                hashMap2.put(GestureAR.SDK_TO_LUA_GESTURE_RESULT_Y1, Float.valueOf(pointF.y));
                hashMap2.put(GestureAR.SDK_TO_LUA_GESTURE_RESULT_X2, Float.valueOf(pointF2.x));
                hashMap2.put(GestureAR.SDK_TO_LUA_GESTURE_RESULT_Y2, Float.valueOf(pointF2.y));
                arrayList.add(hashMap2);
            }
            hashMap.put("event_data", arrayList);
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    @Override // com.baidu.ar.c
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ObjDetectDetector objDetectDetector = this.tx;
            if (objDetectDetector != null) {
                objDetectDetector.av();
                a(this.tx);
            }
            super.release();
        }
    }

    @Override // com.baidu.ar.c
    public void setup(HashMap<String, Object> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hashMap) == null) {
            super.setup(hashMap);
            this.tx = new ObjDetectDetector();
            e eVar = new e(this) { // from class: com.baidu.ar.objdetect.ObjDetectAR.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ObjDetectAR ty;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.ty = this;
                }

                @Override // com.baidu.ar.d.e
                public void a(b bVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, bVar) == null) {
                        float[] fn = ((a) bVar).fn();
                        ObjDetectAR objDetectAR = this.ty;
                        objDetectAR.d(objDetectAR.k(fn));
                    }
                }

                @Override // com.baidu.ar.d.e
                public void a(com.baidu.ar.d.l lVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lVar) == null) {
                    }
                }

                @Override // com.baidu.ar.d.e
                public void b(com.baidu.ar.d.l lVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, lVar) == null) {
                    }
                }
            };
            this.mv = eVar;
            a(this.tx, eVar);
            com.baidu.ar.b.a.as().a(getContext(), getMdlConfigs());
            this.tx.b(new Bundle());
        }
    }
}
