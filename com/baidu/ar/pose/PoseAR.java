package com.baidu.ar.pose;

import android.graphics.PointF;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.arplay.representation.Vector3f;
import com.baidu.ar.arrender.l;
import com.baidu.ar.c;
import com.baidu.ar.d.b;
import com.baidu.ar.d.e;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes9.dex */
public class PoseAR extends c {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String MDL_MAGIC_FILTER_CUTOFFSLOPE = "cutoffSlope";
    public static final String MDL_MAGIC_FILTER_MIN_CUTOFFFREQ = "min_cutofffreq";
    public static final String MDL_START_POSE_FUN_EVENT_TYPE_KEY = "event_type";
    public transient /* synthetic */ FieldHolder $fh;
    public e mv;
    public int nO;
    public int nP;
    public PoseDetector tM;

    public PoseAR() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.nO = MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP;
        this.nP = 180;
    }

    private void b(Bundle bundle, HashMap<String, Object> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, this, bundle, hashMap) == null) {
            bundle.putString(MDL_START_POSE_FUN_EVENT_TYPE_KEY, (String) hashMap.get(MDL_START_POSE_FUN_EVENT_TYPE_KEY));
            HashMap hashMap2 = (HashMap) hashMap.get("algo_map");
            float[] fArr = null;
            if (hashMap2 != null) {
                r3 = hashMap2.containsKey(MDL_MAGIC_FILTER_CUTOFFSLOPE) ? ((Float) hashMap2.get(MDL_MAGIC_FILTER_CUTOFFSLOPE)).floatValue() : 1.0f;
                if (hashMap2.containsKey(MDL_MAGIC_FILTER_MIN_CUTOFFFREQ)) {
                    String[] split = ((String) hashMap2.get(MDL_MAGIC_FILTER_MIN_CUTOFFFREQ)).split(",");
                    fArr = new float[split.length];
                    for (int i2 = 0; i2 < split.length; i2++) {
                        fArr[i2] = Float.parseFloat(split[i2]);
                    }
                }
            }
            bundle.putFloat(MDL_MAGIC_FILTER_CUTOFFSLOPE, r3);
            bundle.putFloatArray(MDL_MAGIC_FILTER_MIN_CUTOFFFREQ, fArr);
        }
    }

    private void dn() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            int i3 = this.mInputWidth;
            int i4 = this.mInputHeight;
            float f2 = i3;
            float f3 = i4;
            int i5 = 180;
            if (Float.compare((1.0f * f2) / f3, 1.7777778f) == 0) {
                i2 = 180;
                i5 = MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP;
            } else if (i3 > i4) {
                i5 = (int) (f2 * (180.0f / f3));
                i2 = 180;
            } else {
                i2 = (int) (f3 * (180.0f / f2));
            }
            this.nO = i5;
            this.nP = i2;
        }
    }

    private float dq() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            if (this.mInputWidth == 0 || (i2 = this.mInputHeight) == 0) {
                return 56.144978f;
            }
            int i3 = this.S;
            if (i3 == 90 || i3 == 270) {
                i2 = this.mInputWidth;
            }
            return (float) (((Math.atan2(i2 * 0.5f, Math.max(this.mInputWidth, this.mInputHeight) * 0.94375f) * 2.0d) * 180.0d) / 3.141592653589793d);
        }
        return invokeV.floatValue;
    }

    private void fq() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            String str = Build.HARDWARE;
            if (!TextUtils.isEmpty(str) && str.matches("qcom")) {
                try {
                    com.baidu.ar.libloader.a.require("SNPE_G");
                    com.baidu.ar.libloader.a.require("snpe_engine");
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HashMap l(float[] fArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, fArr)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("event_name", "body_tracking_data");
            l r = r();
            if (r == null) {
                return hashMap;
            }
            boolean z = this.T;
            if (fArr != null && fArr.length > 0) {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                for (int i2 = 0; i2 < 18; i2++) {
                    int i3 = i2 * 3;
                    PointF pointF = new PointF(fArr[i3], fArr[i3 + 1]);
                    r.a(pointF, z);
                    arrayList2.add(this.T ? new Vector3f(pointF.x, pointF.y, fArr[i3 + 2]) : new Vector3f(pointF.y, pointF.x, fArr[i3 + 2]));
                }
                arrayList.add(arrayList2);
                hashMap.put("event_data", arrayList);
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    @Override // com.baidu.ar.c, com.baidu.ar.arrender.c.a
    public void onInputSizeChange(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
            super.onInputSizeChange(i2, i3);
        }
    }

    @Override // com.baidu.ar.c
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            PoseDetector poseDetector = this.tM;
            if (poseDetector != null) {
                poseDetector.av();
                a(this.tM);
            }
            super.release();
        }
    }

    @Override // com.baidu.ar.c
    public void setup(HashMap<String, Object> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hashMap) == null) {
            super.setup(hashMap);
            fq();
            this.tM = new PoseDetector();
            dn();
            this.tM.i(this.nO, this.nP);
            this.tM.I(this.T);
            e eVar = new e(this) { // from class: com.baidu.ar.pose.PoseAR.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ PoseAR tN;

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
                    this.tN = this;
                }

                @Override // com.baidu.ar.d.e
                public void a(b bVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, bVar) == null) {
                        PoseAR poseAR = this.tN;
                        poseAR.d(poseAR.l(((a) bVar).fr()));
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
            a(this.tM, eVar);
            com.baidu.ar.b.a.as().a(getContext(), getMdlConfigs());
            com.baidu.ar.b.a.as().c(getContext());
            Bundle bundle = new Bundle();
            b(bundle, hashMap);
            this.tM.b(bundle);
            l r = r();
            if (r != null) {
                r.l(true);
                r.setFieldOfView(dq());
            }
        }
    }
}
