package com.baidu.ar.face.attributes;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.arrender.l;
import com.baidu.ar.face.FaceResultData;
import com.baidu.ar.face.algo.FAUFaceBox;
import com.baidu.ar.face.algo.FaceAlgoData;
import com.baidu.ar.face.algo.FaceFrame;
import com.baidu.ar.face.detector.m;
import com.baidu.ar.h.b;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<Integer, float[]> nY;
    public boolean nZ;
    public l oa;

    public a(l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.nY = new HashMap<>();
        this.nZ = false;
        this.oa = lVar;
    }

    private boolean Z(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, str)) == null) {
            if (new File(str).exists()) {
                return true;
            }
            b.b("FaceAttributesManager", "open model path error:" + str);
            return false;
        }
        return invokeL.booleanValue;
    }

    public static float[] a(ByteBuffer byteBuffer, FAUFaceBox fAUFaceBox, int i2, int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65538, null, byteBuffer, fAUFaceBox, i2, i3)) == null) {
            float[] fArr = new float[2];
            if (FaceAttributesJni.predictGenderDetect(byteBuffer, i2, i3, new float[]{fAUFaceBox.getX(), fAUFaceBox.getY(), fAUFaceBox.getWidth(), fAUFaceBox.getHeight(), fAUFaceBox.getAngle()}, fArr) == 0) {
                return fArr;
            }
            return null;
        }
        return (float[]) invokeLLII.objValue;
    }

    private boolean c(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, context, str)) == null) {
            try {
                context.getAssets().open(str).close();
                return true;
            } catch (Exception unused) {
                b.b("FaceAttributesManager", "open asset model path error:" + str);
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    private boolean d(m mVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, this, mVar)) == null) {
            if (this.nZ) {
                if (mVar.isTracked()) {
                    return true;
                }
                b.c("FaceAttributesManager", "faceResult.isTracked == false.");
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void a(m mVar, FaceResultData faceResultData, int i2, int i3) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLII(1048576, this, mVar, faceResultData, i2, i3) == null) && d(mVar)) {
            FaceAlgoData eC = mVar.eC();
            FaceFrame faceFrame = eC == null ? null : eC.getFaceFrame();
            if (faceFrame == null) {
                str = "faceFrame == null.";
            } else {
                List<FAUFaceBox> faceBoxes = faceFrame.getFaceBoxes();
                int[] faceIDList = faceFrame.getFaceIDList();
                if (faceBoxes != null && faceBoxes.size() != 0 && faceIDList != null && faceIDList.length != 0) {
                    faceResultData.setFaceIds(faceIDList);
                    int i4 = faceIDList[0];
                    float[] fArr = this.nY.get(Integer.valueOf(i4));
                    if (fArr != null) {
                        faceResultData.setGenders(fArr);
                        return;
                    }
                    float[] a2 = a(mVar.eB(), faceBoxes.get(0), i2, i3);
                    if (a2 == null || !this.nZ) {
                        return;
                    }
                    this.nY.put(Integer.valueOf(i4), a2);
                    faceResultData.setGenders(a2);
                    l lVar = this.oa;
                    if (lVar != null) {
                        lVar.a("face_gender_predict", Float.valueOf(a2[0]));
                        return;
                    }
                    return;
                }
                str = "fauFaceBoxes is empty.";
            }
            b.c("FaceAttributesManager", str);
        }
    }

    public int b(Context context, String str) {
        InterceptResult invokeLL;
        int initGenderDetect;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                b.b("FaceAttributesManager", "gender model path is empty.");
                return -1;
            }
            if (this.nZ) {
                return 0;
            }
            if (FaceAttributesJni.nX) {
                if (str.startsWith("file:///android_asset/")) {
                    String replace = str.replace("file:///android_asset/", "");
                    if (!c(context, replace)) {
                        return -1;
                    }
                    FaceAttributesJni.setAssetManager(context.getAssets());
                    initGenderDetect = FaceAttributesJni.initGenderDetectFromAssets(replace);
                } else if (!Z(str)) {
                    return -1;
                } else {
                    initGenderDetect = FaceAttributesJni.initGenderDetect(str);
                }
                this.nZ = initGenderDetect == 0;
                return initGenderDetect;
            }
            return -1;
        }
        return invokeLL.intValue;
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.oa = null;
            if (this.nZ) {
                this.nZ = false;
                FaceAttributesJni.releaseGenderDetect();
            }
        }
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.nY.clear();
        }
    }
}
