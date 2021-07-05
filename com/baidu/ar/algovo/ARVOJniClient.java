package com.baidu.ar.algovo;

import com.baidu.ar.algo.ARAlgoJniClient;
import com.baidu.ar.algo.FrameType;
import com.baidu.ar.slam.TrackModel;
import com.baidu.ar.slam.TrackParams;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ARVOJniClient {
    public static /* synthetic */ Interceptable $ic;
    public static List<String> sModelIds;
    public static int sTrackerId;
    public transient /* synthetic */ FieldHolder $fh;

    public ARVOJniClient() {
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

    public static int calModelPosition(float[] fArr, float f2, float[] fArr2, float[] fArr3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{fArr, Float.valueOf(f2), fArr2, fArr3})) == null) ? ARAlgoJniClient.calModelPosition(fArr, f2, fArr2, fArr3) : invokeCommon.intValue;
    }

    public static synchronized ArrayList<TrackModel> fetchModelPose() {
        InterceptResult invokeV;
        ArrayList<TrackModel> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (ARVOJniClient.class) {
                arrayList = new ArrayList<>();
                if (sModelIds != null) {
                    for (String str : sModelIds) {
                        float[] fArr = new float[16];
                        if (ARAlgoJniClient.getAlgoInstance().getModelPose(sTrackerId, str, fArr) == 0) {
                            TrackModel trackModel = new TrackModel();
                            trackModel.setId(str);
                            trackModel.setPose(fArr);
                            arrayList.add(trackModel);
                        }
                    }
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public static synchronized int insertModel(String str, int i2, int i3, float[] fArr, float f2) {
        InterceptResult invokeCommon;
        int insertModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), fArr, Float.valueOf(f2)})) == null) {
            synchronized (ARVOJniClient.class) {
                insertModel = ARAlgoJniClient.getAlgoInstance().insertModel(sTrackerId, i2, i3, str, f2, fArr);
                if (insertModel == 0) {
                    if (sModelIds == null) {
                        sModelIds = new ArrayList();
                    }
                    sModelIds.add(str);
                }
            }
            return insertModel;
        }
        return invokeCommon.intValue;
    }

    public static synchronized int removeAllModel() {
        InterceptResult invokeV;
        int removeAllModels;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65540, null)) == null) {
            synchronized (ARVOJniClient.class) {
                removeAllModels = ARAlgoJniClient.getAlgoInstance().removeAllModels(sTrackerId);
                if (removeAllModels == 0 && sModelIds != null) {
                    sModelIds.clear();
                }
            }
            return removeAllModels;
        }
        return invokeV.intValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002e, code lost:
        com.baidu.ar.algovo.ARVOJniClient.sModelIds.remove(r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized int removeModel(String str) {
        InterceptResult invokeL;
        int removeModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
            synchronized (ARVOJniClient.class) {
                removeModel = ARAlgoJniClient.getAlgoInstance().removeModel(sTrackerId, str);
                if (removeModel == 0 && sModelIds != null) {
                    int i2 = 0;
                    int size = sModelIds.size();
                    while (true) {
                        if (i2 >= size) {
                            break;
                        } else if (sModelIds.get(i2).equals(str)) {
                            break;
                        } else {
                            i2++;
                        }
                    }
                }
            }
            return removeModel;
        }
        return invokeL.intValue;
    }

    public static synchronized void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null) == null) {
            synchronized (ARVOJniClient.class) {
                if (sTrackerId >= 0) {
                    ARAlgoJniClient.getAlgoInstance().removeAllModels(sTrackerId);
                }
            }
        }
    }

    public static synchronized boolean start(int i2, int i3, float[] fArr, float[] fArr2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), fArr, fArr2})) == null) {
            synchronized (ARVOJniClient.class) {
                if (ARAlgoJniClient.getAlgoInstance().createTrackingSystem(i2, i3, fArr, fArr2) == 0) {
                    int addTrackerVO = ARAlgoJniClient.getAlgoInstance().addTrackerVO("");
                    sTrackerId = addTrackerVO;
                    return addTrackerVO >= 0;
                }
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }

    public static synchronized void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            synchronized (ARVOJniClient.class) {
                ARAlgoJniClient.getAlgoInstance().release();
                sModelIds = null;
            }
        }
    }

    public static synchronized TrackParams track(ByteBuffer byteBuffer, float[] fArr) {
        InterceptResult invokeLL;
        TrackParams trackParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, byteBuffer, fArr)) == null) {
            synchronized (ARVOJniClient.class) {
                long currentTimeMillis = System.currentTimeMillis();
                int trackFrame = ARAlgoJniClient.getAlgoInstance().trackFrame(byteBuffer, ((float) currentTimeMillis) * 1.0f, fArr, FrameType.TYPE_YUV);
                trackParams = new TrackParams();
                trackParams.processTime = (float) (System.currentTimeMillis() - currentTimeMillis);
                trackParams.trackQuality = trackFrame;
            }
            return trackParams;
        }
        return (TrackParams) invokeLL.objValue;
    }
}
