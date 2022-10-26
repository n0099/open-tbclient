package com.baidu.ar.gesture;

import android.graphics.PointF;
import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.arrender.l;
import com.baidu.ar.c;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.ar.d.b;
import com.baidu.ar.d.e;
import com.baidu.ar.statistic.StatisticApi;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.tbadk.core.atomData.WriteVoteActivityConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class GestureAR extends c {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MDL_GESTURE_STATUS_DETECTED = 5002;
    public static final String SDK_TO_LUA_GESTURE_RESULT_BODY = "gesture_result";
    public static final String SDK_TO_LUA_GESTURE_RESULT_COUNT = "gesture_count";
    public static final String SDK_TO_LUA_GESTURE_RESULT_FTX = "ftx";
    public static final String SDK_TO_LUA_GESTURE_RESULT_FTY = "fty";
    public static final String SDK_TO_LUA_GESTURE_RESULT_JNTX = "jntx";
    public static final String SDK_TO_LUA_GESTURE_RESULT_JNTY = "jnty";
    public static final String SDK_TO_LUA_GESTURE_RESULT_RESERVED = "reserved";
    public static final String SDK_TO_LUA_GESTURE_RESULT_SCORE = "score";
    public static final String SDK_TO_LUA_GESTURE_RESULT_TJNTX = "tjntx";
    public static final String SDK_TO_LUA_GESTURE_RESULT_TJNTY = "tjnty";
    public static final String SDK_TO_LUA_GESTURE_RESULT_TYPE = "type";
    public static final String SDK_TO_LUA_GESTURE_RESULT_X1 = "x1";
    public static final String SDK_TO_LUA_GESTURE_RESULT_X2 = "x2";
    public static final String SDK_TO_LUA_GESTURE_RESULT_Y1 = "y1";
    public static final String SDK_TO_LUA_GESTURE_RESULT_Y2 = "y2";
    public static final String TAG = "GestureAR";
    public transient /* synthetic */ FieldHolder $fh;
    public e mv;
    public GestureDetector qp;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1470789321, "Lcom/baidu/ar/gesture/GestureAR;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1470789321, "Lcom/baidu/ar/gesture/GestureAR;");
        }
    }

    public GestureAR() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    private void a(Bundle bundle, HashMap hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, this, bundle, hashMap) == null) {
            bundle.putString(HttpConstants.FUNCTION_TYPE, com.baidu.ar.arplay.c.c.a(hashMap.get(HttpConstants.FUNCTION_TYPE), "gesture"));
            Map map = (Map) hashMap.get(WriteVoteActivityConfig.EXTRA_DATA_KEY);
            if (map == null || map.isEmpty()) {
                return;
            }
            if (map.containsKey("force_ft_pose_flag")) {
                bundle.putInt("force_ft_pose_flag", com.baidu.ar.arplay.c.c.a(map.get("force_ft_pose_flag"), 0));
            }
            if (map.containsKey("det_thresh")) {
                bundle.putFloat("det_thresh", com.baidu.ar.arplay.c.c.a(map.get("det_thresh"), 0.25f));
            }
            if (map.containsKey("first_cls_thresh")) {
                bundle.putFloat("first_cls_thresh", com.baidu.ar.arplay.c.c.a(map.get("first_cls_thresh"), 0.75f));
            }
            if (map.containsKey("second_cls_thresh")) {
                bundle.putFloat("second_cls_thresh", com.baidu.ar.arplay.c.c.a(map.get("second_cls_thresh"), 0.5f));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HashMap f(float[] fArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, fArr)) == null) {
            HashMap hashMap = new HashMap();
            int length = fArr.length / 13;
            hashMap.put("id", 5002);
            l r = r();
            int i = 0;
            if (r == null) {
                hashMap.put(SDK_TO_LUA_GESTURE_RESULT_COUNT, 0);
                return hashMap;
            }
            hashMap.put(SDK_TO_LUA_GESTURE_RESULT_COUNT, Integer.valueOf(length));
            while (i < length) {
                StringBuilder sb = new StringBuilder();
                sb.append("");
                int i2 = i + 1;
                sb.append(i2);
                String concat = SDK_TO_LUA_GESTURE_RESULT_BODY.concat(sb.toString());
                int i3 = i * 13;
                PointF pointF = new PointF(fArr[i3 + 3], fArr[i3 + 4]);
                r.a(pointF, true);
                PointF pointF2 = new PointF(fArr[i3 + 5], fArr[i3 + 6]);
                r.a(pointF2, true);
                PointF pointF3 = new PointF(fArr[i3 + 7], fArr[i3 + 8]);
                r.a(pointF3, true);
                PointF pointF4 = new PointF(fArr[i3 + 9], fArr[i3 + 10]);
                r.a(pointF4, true);
                PointF pointF5 = new PointF(fArr[i3 + 11], fArr[i3 + 12]);
                r.a(pointF5, true);
                HashMap hashMap2 = new HashMap();
                hashMap2.put(SDK_TO_LUA_GESTURE_RESULT_RESERVED, Float.valueOf(fArr[i3]));
                hashMap2.put("type", Float.valueOf(fArr[i3 + 1]));
                hashMap2.put("score", Float.valueOf(fArr[i3 + 2]));
                hashMap2.put(SDK_TO_LUA_GESTURE_RESULT_X1, Float.valueOf(pointF.x));
                hashMap2.put(SDK_TO_LUA_GESTURE_RESULT_Y1, Float.valueOf(pointF.y));
                hashMap2.put(SDK_TO_LUA_GESTURE_RESULT_X2, Float.valueOf(pointF2.x));
                hashMap2.put(SDK_TO_LUA_GESTURE_RESULT_Y2, Float.valueOf(pointF2.y));
                hashMap2.put(SDK_TO_LUA_GESTURE_RESULT_FTX, Float.valueOf(pointF3.x));
                hashMap2.put(SDK_TO_LUA_GESTURE_RESULT_FTY, Float.valueOf(pointF3.y));
                hashMap2.put(SDK_TO_LUA_GESTURE_RESULT_JNTX, Float.valueOf(pointF4.x));
                hashMap2.put(SDK_TO_LUA_GESTURE_RESULT_JNTY, Float.valueOf(pointF4.y));
                hashMap2.put(SDK_TO_LUA_GESTURE_RESULT_TJNTX, Float.valueOf(pointF5.x));
                hashMap2.put(SDK_TO_LUA_GESTURE_RESULT_TJNTY, Float.valueOf(pointF5.y));
                hashMap.put(concat, hashMap2);
                i = i2;
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    @Override // com.baidu.ar.c
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            GestureDetector gestureDetector = this.qp;
            if (gestureDetector != null) {
                gestureDetector.av();
                a(this.qp);
            }
            super.release();
        }
    }

    @Override // com.baidu.ar.c
    public void setup(HashMap hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hashMap) == null) {
            super.setup(hashMap);
            this.qp = new GestureDetector();
            e eVar = new e(this) { // from class: com.baidu.ar.gesture.GestureAR.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ GestureAR qq;

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
                    this.qq = this;
                }

                @Override // com.baidu.ar.d.e
                public void a(b bVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, bVar) == null) {
                        float[] eG = ((a) bVar).eG();
                        GestureAR gestureAR = this.qq;
                        gestureAR.d(gestureAR.f(eG));
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
            a(this.qp, eVar);
            com.baidu.ar.b.a.as().a(getContext(), getMdlConfigs());
            Bundle bundle = new Bundle();
            a(bundle, hashMap);
            this.qp.b(bundle);
            StatisticApi.onEvent(StatisticConstants.MDL_GESTURE_OPEN);
        }
    }
}
