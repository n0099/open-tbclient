package com.baidu.pass.face.platform;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
/* loaded from: classes7.dex */
public class FaceConfig implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public static final String TAG;
    public transient /* synthetic */ FieldHolder $fh;
    public float blurnessValue;
    public float brightnessMaxValue;
    public float brightnessValue;
    public int cacheImageNum;
    public int cropHeight;
    public int cropWidth;
    public float enlargeRatio;
    public float eyeClosedValue;
    public float faceClosedRatio;
    public float faceFarRatio;
    public int headPitchValue;
    public int headRollValue;
    public int headYawValue;
    public boolean isLivenessRandom;
    public boolean isOpenMask;
    public boolean isOpenOnline;
    public boolean isSound;
    public int livenessRandomCount;
    public List<LivenessTypeEnum> livenessTypeList;
    public float maskValue;
    public int minFaceSize;
    public boolean noBlackCropImage;
    public float notFaceValue;
    public float occlusionChinValue;
    public float occlusionLeftContourValue;
    public float occlusionLeftEyeValue;
    public float occlusionMouthValue;
    public float occlusionNoseValue;
    public float occlusionRightContourValue;
    public float occlusionRightEyeValue;
    public float occlusionValue;
    public int outputImageType;
    public int qualityLevel;
    public float scale;
    public int secType;
    public long timeDetectModule;
    public long timeLivenessCourse;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1748644126, "Lcom/baidu/pass/face/platform/FaceConfig;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1748644126, "Lcom/baidu/pass/face/platform/FaceConfig;");
                return;
            }
        }
        TAG = FaceConfig.class.getSimpleName();
    }

    public FaceConfig() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.minFaceSize = 200;
        this.notFaceValue = 0.6f;
        this.brightnessValue = 82.0f;
        this.brightnessMaxValue = 200.0f;
        this.blurnessValue = 0.7f;
        this.occlusionValue = 0.5f;
        this.occlusionLeftEyeValue = 0.5f;
        this.occlusionRightEyeValue = 0.5f;
        this.occlusionNoseValue = 0.5f;
        this.occlusionMouthValue = 0.5f;
        this.occlusionLeftContourValue = 0.5f;
        this.occlusionRightContourValue = 0.5f;
        this.occlusionChinValue = 0.5f;
        this.headPitchValue = 8;
        this.headYawValue = 8;
        this.headRollValue = 8;
        this.eyeClosedValue = 0.7f;
        this.isSound = true;
        this.isLivenessRandom = false;
        this.cacheImageNum = 3;
        this.livenessRandomCount = 3;
        this.livenessTypeList = FaceEnvironment.livenessTypeDefaultList;
        this.isOpenOnline = true;
        this.outputImageType = 1;
        this.cropHeight = 640;
        this.cropWidth = 480;
        this.enlargeRatio = 1.5f;
        this.scale = 1.0f;
        this.secType = 1;
        this.maskValue = 0.7f;
        this.isOpenMask = true;
        this.timeDetectModule = 15000L;
        this.timeLivenessCourse = 5000L;
        this.qualityLevel = 0;
        this.faceFarRatio = 0.4f;
        this.faceClosedRatio = 1.0f;
        this.noBlackCropImage = true;
    }

    public static List<LivenessTypeEnum> getRandomList(List<LivenessTypeEnum> list, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, list, i2)) == null) {
            if (list.size() < i2) {
                return list;
            }
            Random random = new Random();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int i3 = 0;
            while (i3 < i2) {
                int nextInt = random.nextInt(list.size());
                if (arrayList.contains(Integer.valueOf(nextInt))) {
                    i3--;
                } else {
                    arrayList.add(Integer.valueOf(nextInt));
                    arrayList2.add(list.get(nextInt));
                }
                i3++;
            }
            return arrayList2;
        }
        return (List) invokeLI.objValue;
    }

    public float getBlurnessValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.blurnessValue : invokeV.floatValue;
    }

    public float getBrightnessMaxValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.brightnessMaxValue : invokeV.floatValue;
    }

    public float getBrightnessValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.brightnessValue : invokeV.floatValue;
    }

    public int getCacheImageNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.cacheImageNum : invokeV.intValue;
    }

    public int getCropHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.cropHeight : invokeV.intValue;
    }

    public int getCropWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.cropWidth : invokeV.intValue;
    }

    public float getEnlargeRatio() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.enlargeRatio : invokeV.floatValue;
    }

    public float getEyeClosedValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.eyeClosedValue : invokeV.floatValue;
    }

    public float getFaceClosedRatio() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.faceClosedRatio : invokeV.floatValue;
    }

    public float getFaceFarRatio() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.faceFarRatio : invokeV.floatValue;
    }

    public int getHeadPitchValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.headPitchValue : invokeV.intValue;
    }

    public int getHeadRollValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.headRollValue : invokeV.intValue;
    }

    public int getHeadYawValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.headYawValue : invokeV.intValue;
    }

    public int getLivenessRandomCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.livenessRandomCount : invokeV.intValue;
    }

    public List<LivenessTypeEnum> getLivenessTypeList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            List<LivenessTypeEnum> list = this.livenessTypeList;
            if (list != null && list.size() != 0) {
                if (this.isLivenessRandom) {
                    List<LivenessTypeEnum> list2 = this.livenessTypeList;
                    return getRandomList(list2, list2.size());
                }
            } else {
                ArrayList arrayList = new ArrayList();
                this.livenessTypeList = arrayList;
                arrayList.addAll(FaceEnvironment.livenessTypeDefaultList);
                Collections.shuffle(this.livenessTypeList);
                this.livenessTypeList = this.livenessTypeList.subList(0, getLivenessRandomCount());
            }
            return this.livenessTypeList;
        }
        return (List) invokeV.objValue;
    }

    public float getMaskValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.maskValue : invokeV.floatValue;
    }

    public int getMinFaceSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.minFaceSize : invokeV.intValue;
    }

    public float getNotFaceValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.notFaceValue : invokeV.floatValue;
    }

    public float getOcclusionChinValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.occlusionChinValue : invokeV.floatValue;
    }

    public float getOcclusionLeftContourValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.occlusionLeftContourValue : invokeV.floatValue;
    }

    public float getOcclusionLeftEyeValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.occlusionLeftEyeValue : invokeV.floatValue;
    }

    public float getOcclusionMouthValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.occlusionMouthValue : invokeV.floatValue;
    }

    public float getOcclusionNoseValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.occlusionNoseValue : invokeV.floatValue;
    }

    public float getOcclusionRightContourValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.occlusionRightContourValue : invokeV.floatValue;
    }

    public float getOcclusionRightEyeValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.occlusionRightEyeValue : invokeV.floatValue;
    }

    public float getOcclusionValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.occlusionValue : invokeV.floatValue;
    }

    public int getOutputImageType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.outputImageType : invokeV.intValue;
    }

    public int getQualityLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.qualityLevel : invokeV.intValue;
    }

    public float getScale() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.scale : invokeV.floatValue;
    }

    public int getSecType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.secType : invokeV.intValue;
    }

    public long getTimeDetectModule() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.timeDetectModule : invokeV.longValue;
    }

    public long getTimeLivenessCourse() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.timeLivenessCourse : invokeV.longValue;
    }

    public boolean isLivenessRandom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.isLivenessRandom : invokeV.booleanValue;
    }

    public boolean isNoBlackCropImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.noBlackCropImage : invokeV.booleanValue;
    }

    public boolean isOpenMask() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.isOpenMask : invokeV.booleanValue;
    }

    public boolean isOpenOnline() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.isOpenOnline : invokeV.booleanValue;
    }

    public boolean isSound() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.isSound : invokeV.booleanValue;
    }

    public void setBlurnessValue(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048613, this, f2) == null) {
            this.blurnessValue = f2;
        }
    }

    public void setBrightnessMaxValue(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048614, this, f2) == null) {
            this.brightnessMaxValue = f2;
        }
    }

    public void setBrightnessValue(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048615, this, f2) == null) {
            this.brightnessValue = f2;
        }
    }

    public void setCacheImageNum(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048616, this, i2) == null) {
            this.cacheImageNum = i2;
        }
    }

    public void setCropHeight(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048617, this, i2) == null) {
            this.cropHeight = i2;
        }
    }

    public void setCropWidth(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048618, this, i2) == null) {
            this.cropWidth = i2;
        }
    }

    public void setEnlargeRatio(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048619, this, f2) == null) {
            this.enlargeRatio = f2;
        }
    }

    public void setEyeClosedValue(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048620, this, f2) == null) {
            this.eyeClosedValue = f2;
        }
    }

    public void setFaceClosedRatio(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048621, this, f2) == null) {
            this.faceClosedRatio = f2;
        }
    }

    public void setFaceFarRatio(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048622, this, f2) == null) {
            this.faceFarRatio = f2;
        }
    }

    public void setHeadPitchValue(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048623, this, i2) == null) {
            this.headPitchValue = i2;
        }
    }

    public void setHeadRollValue(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048624, this, i2) == null) {
            this.headRollValue = i2;
        }
    }

    public void setHeadYawValue(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048625, this, i2) == null) {
            this.headYawValue = i2;
        }
    }

    public void setLivenessRandom(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048626, this, z) == null) {
            this.isLivenessRandom = z;
        }
    }

    public void setLivenessRandomCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048627, this, i2) == null) {
            int size = FaceEnvironment.livenessTypeDefaultList.size();
            if (i2 > size) {
                i2 = size;
            }
            this.livenessRandomCount = i2;
        }
    }

    public void setLivenessTypeList(List<LivenessTypeEnum> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, list) == null) {
            this.livenessTypeList = list;
        }
    }

    public void setMaskValue(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048629, this, f2) == null) {
            this.maskValue = f2;
        }
    }

    public void setMinFaceSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048630, this, i2) == null) {
            this.minFaceSize = i2;
        }
    }

    public void setNoBlackCropImage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048631, this, z) == null) {
            this.noBlackCropImage = z;
        }
    }

    public void setNotFaceValue(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048632, this, f2) == null) {
            this.notFaceValue = f2;
        }
    }

    public void setOcclusionChinValue(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048633, this, f2) == null) {
            this.occlusionChinValue = f2;
        }
    }

    public void setOcclusionLeftContourValue(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048634, this, f2) == null) {
            this.occlusionLeftContourValue = f2;
        }
    }

    public void setOcclusionLeftEyeValue(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048635, this, f2) == null) {
            this.occlusionLeftEyeValue = f2;
        }
    }

    public void setOcclusionMouthValue(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048636, this, f2) == null) {
            this.occlusionMouthValue = f2;
        }
    }

    public void setOcclusionNoseValue(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048637, this, f2) == null) {
            this.occlusionNoseValue = f2;
        }
    }

    public void setOcclusionRightContourValue(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048638, this, f2) == null) {
            this.occlusionRightContourValue = f2;
        }
    }

    public void setOcclusionRightEyeValue(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048639, this, f2) == null) {
            this.occlusionRightEyeValue = f2;
        }
    }

    public void setOcclusionValue(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048640, this, f2) == null) {
            this.occlusionValue = f2;
        }
    }

    public void setOpenMask(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048641, this, z) == null) {
            this.isOpenMask = z;
        }
    }

    public void setOpenOnline(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048642, this, z) == null) {
            this.isOpenOnline = z;
        }
    }

    public void setOutputImageType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048643, this, i2) == null) {
            this.outputImageType = i2;
        }
    }

    public void setQualityLevel(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048644, this, i2) == null) {
            this.qualityLevel = i2;
        }
    }

    public void setScale(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048645, this, f2) == null) {
            this.scale = f2;
        }
    }

    public void setSecType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048646, this, i2) == null) {
            this.secType = i2;
        }
    }

    public void setSound(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048647, this, z) == null) {
            this.isSound = z;
        }
    }

    public void setTimeDetectModule(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048648, this, j) == null) {
            this.timeDetectModule = j;
        }
    }

    public void setTimeLivenessCourse(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048649, this, j) == null) {
            this.timeLivenessCourse = j;
        }
    }
}
