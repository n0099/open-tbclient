package com.baidu.ar.face.algo;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class FaceFrame {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FACE_ANIMATION_POINTS_COUNT = 95;
    public static final int FACE_LANDMARKS_COUNT = 190;
    public static final int FACE_MAX_COUNT = 4;
    public transient /* synthetic */ FieldHolder $fh;
    public float[] animatePointsArray;
    public List<FAUPoint2D[]> animatePointsList;
    public List<float[]> animationValuesList;
    public List<FAUFaceBox> faceBoxes;
    public float[] faceBoxesArray;
    public int[] faceIDList;
    public List<float[]> headPoses;
    public int mProcessResult;
    public float[] trackedPointsArray;
    public List<FAUPoint2D[]> trackedPointsList;
    public List<String[]> triggersList;

    public FaceFrame() {
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

    public List<FAUPoint2D[]> getAnimatePointsList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.animatePointsArray != null) {
                this.animatePointsList = new ArrayList();
                int length = this.animatePointsArray.length / 190;
                for (int i2 = 0; i2 < length; i2++) {
                    int i3 = i2 * 95 * 2;
                    FAUPoint2D[] fAUPoint2DArr = new FAUPoint2D[95];
                    for (int i4 = 0; i4 < 95; i4++) {
                        FAUPoint2D fAUPoint2D = new FAUPoint2D();
                        FAUPoint2D fAUPoint2D2 = fAUPoint2DArr[i4];
                        float[] fArr = this.animatePointsArray;
                        int i5 = (i4 * 2) + i3;
                        fAUPoint2D2.x = fArr[i5];
                        fAUPoint2DArr[i4].y = fArr[i5 + 1];
                        fAUPoint2DArr[i4] = fAUPoint2D;
                    }
                    this.animatePointsList.add(fAUPoint2DArr);
                }
                this.animatePointsArray = null;
            }
            return this.animatePointsList;
        }
        return (List) invokeV.objValue;
    }

    public List<float[]> getAnimationValuesList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.animationValuesList : (List) invokeV.objValue;
    }

    public List<FAUFaceBox> getFaceBoxes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.faceBoxesArray != null) {
                this.faceBoxes = new ArrayList();
                int length = this.faceBoxesArray.length / 5;
                for (int i2 = 0; i2 < length; i2++) {
                    float[] fArr = this.faceBoxesArray;
                    int i3 = i2 * 5;
                    this.faceBoxes.add(new FAUFaceBox(fArr[i3], fArr[i3 + 1], fArr[i3 + 2], fArr[i3 + 3], fArr[i3 + 4]));
                }
                this.faceBoxesArray = null;
            }
            return this.faceBoxes;
        }
        return (List) invokeV.objValue;
    }

    public int[] getFaceIDList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.faceIDList : (int[]) invokeV.objValue;
    }

    public List<float[]> getHeadPoses() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.headPoses : (List) invokeV.objValue;
    }

    public int getProcessResult() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mProcessResult : invokeV.intValue;
    }

    public List<FAUPoint2D[]> getTrackedPointsList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.trackedPointsArray != null) {
                this.trackedPointsList = new ArrayList();
                int length = this.trackedPointsArray.length / 380;
                for (int i2 = 0; i2 < length; i2++) {
                    int i3 = i2 * 190 * 2;
                    FAUPoint2D[] fAUPoint2DArr = new FAUPoint2D[190];
                    for (int i4 = 0; i4 < 190; i4++) {
                        FAUPoint2D fAUPoint2D = new FAUPoint2D();
                        float[] fArr = this.trackedPointsArray;
                        int i5 = (i4 * 2) + i3;
                        fAUPoint2D.x = fArr[i5];
                        fAUPoint2D.y = fArr[i5 + 1];
                        fAUPoint2DArr[i4] = fAUPoint2D;
                    }
                    this.trackedPointsList.add(fAUPoint2DArr);
                }
                this.trackedPointsArray = null;
            }
            return this.trackedPointsList;
        }
        return (List) invokeV.objValue;
    }

    public List<String[]> getTriggersList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.triggersList : (List) invokeV.objValue;
    }
}
