package com.baidu.minivideo.arface.bean;

import androidx.core.view.InputDeviceCompat;
import com.baidu.ar.filter.FilterParam;
import com.baidu.pass.biometrics.face.liveness.b.a;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes4.dex */
public final class BeautyType {
    public static final /* synthetic */ BeautyType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final BeautyType beautyDebugDraw;
    public static final BeautyType beautyJsonPath;
    public static final BeautyType beautyJsonStr;
    public static final BeautyType blackEyeCircle;
    public static final BeautyType cheekboneWidth;
    public static final BeautyType cheeks;
    public static final BeautyType chinHeight;
    public static final BeautyType downCount;
    public static final BeautyType eye;
    public static final BeautyType eyeAngle;
    public static final BeautyType eyeDistance;
    public static final BeautyType eyeball;
    public static final BeautyType eyebrow;
    public static final BeautyType eyebrowDistance;
    public static final BeautyType eyelash;
    public static final BeautyType eyeliner;
    public static final BeautyType eyeshadow;
    public static final BeautyType faceWidth;
    public static final BeautyType globalScaleValue;
    public static final BeautyType hazeAtom;
    public static final BeautyType hazeBlend;
    public static final BeautyType highlight;
    public static final BeautyType jawAngleWidth;
    public static final BeautyType laughLine;
    public static final BeautyType lips;
    public static final BeautyType lipsMask;
    public static final BeautyType lutFile;
    public static final BeautyType lutIntensity;
    public static final BeautyType makeupClose;
    public static final BeautyType middleCount;
    public static final BeautyType mouthWidth;
    public static final BeautyType noseLength;
    public static final BeautyType noseWidth;
    public static final BeautyType smooth;
    public static final BeautyType thinFace;
    public static final BeautyType threeCounts;
    public static final BeautyType upCount;
    public static final BeautyType whiten;
    public static final BeautyType whitenFile;
    public transient /* synthetic */ FieldHolder $fh;
    public String icon;
    public String path;
    public FilterParam type;
    public float value;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1981847762, "Lcom/baidu/minivideo/arface/bean/BeautyType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1981847762, "Lcom/baidu/minivideo/arface/bean/BeautyType;");
                return;
            }
        }
        lutFile = new BeautyType("lutFile", 0, FilterParam.LutFilter.lutFile);
        lutIntensity = new BeautyType("lutIntensity", 1, FilterParam.LutFilter.lutIntensity);
        whitenFile = new BeautyType("whitenFile", 2, FilterParam.SkinFilter.whitenFile);
        blackEyeCircle = new BeautyType("blackEyeCircle", 3, FilterParam.SkinFilter.blackEyeCircle);
        laughLine = new BeautyType("laughLine", 4, FilterParam.SkinFilter.laughLine);
        lipsMask = new BeautyType("lipsMask", 5, FilterParam.MakeupFilter.lipsMask);
        lips = new BeautyType("lips", 6, FilterParam.MakeupFilter.lips);
        cheeks = new BeautyType("cheeks", 7, FilterParam.MakeupFilter.cheeks);
        highlight = new BeautyType("highlight", 8, FilterParam.MakeupFilter.highlight);
        eyeliner = new BeautyType("eyeliner", 9, FilterParam.MakeupFilter.eyeliner);
        eyeshadow = new BeautyType("eyeshadow", 10, FilterParam.MakeupFilter.eyeshadow);
        eyeball = new BeautyType("eyeball", 11, FilterParam.MakeupFilter.eyeball);
        eyelash = new BeautyType("eyelash", 12, FilterParam.MakeupFilter.eyelash);
        eyebrow = new BeautyType("eyebrow", 13, FilterParam.MakeupFilter.eyebrow);
        makeupClose = new BeautyType("makeupClose", 14, FilterParam.MakeupFilter.lipsMask);
        whiten = new BeautyType("whiten", 15, 0.0f, FilterParam.SkinFilter.whiten);
        smooth = new BeautyType("smooth", 16, 0.0f, FilterParam.SkinFilter.smooth);
        eye = new BeautyType(a.a0, 17, 0.0f, FilterParam.FaceFilter.eye);
        thinFace = new BeautyType("thinFace", 18, 0.0f, FilterParam.FaceFilter.thinFace);
        threeCounts = new BeautyType("threeCounts", 19, 0.5f, FilterParam.FaceFilter.threeCounts);
        chinHeight = new BeautyType("chinHeight", 20, 0.5f, FilterParam.FaceFilter.chinHeight);
        noseWidth = new BeautyType("noseWidth", 21, 0.0f, FilterParam.FaceFilter.noseWidth);
        noseLength = new BeautyType("noseLength", 22, 0.5f, FilterParam.FaceFilter.noseLength);
        eyeDistance = new BeautyType("eyeDistance", 23, 0.5f, FilterParam.FaceFilter.eyeDistance);
        mouthWidth = new BeautyType("mouthWidth", 24, 0.5f, FilterParam.FaceFilter.mouthWidth);
        eyebrowDistance = new BeautyType("eyebrowDistance", 25, 0.5f, FilterParam.FaceFilter.eyebrowDistance);
        upCount = new BeautyType("upCount", 26, 0.5f, FilterParam.FaceFilter.upCount);
        middleCount = new BeautyType("middleCount", 27, 0.5f, FilterParam.FaceFilter.middleCount);
        downCount = new BeautyType("downCount", 28, 0.5f, FilterParam.FaceFilter.downCount);
        faceWidth = new BeautyType("faceWidth", 29, 0.0f, FilterParam.FaceFilter.faceWidth);
        jawAngleWidth = new BeautyType("jawAngleWidth", 30, 0.0f, FilterParam.FaceFilter.jawAngleWidth);
        eyeAngle = new BeautyType("eyeAngle", 31, 0.5f, FilterParam.FaceFilter.eyeAngle);
        cheekboneWidth = new BeautyType("cheekboneWidth", 32, 0.0f, FilterParam.FaceFilter.cheekboneWidth);
        beautyDebugDraw = new BeautyType("beautyDebugDraw", 33, -1.0f, FilterParam.FaceFilter.beautyDebugDrawMode);
        beautyJsonPath = new BeautyType("beautyJsonPath", 34, "", FilterParam.FaceFilter.beautyJsonPath);
        beautyJsonStr = new BeautyType("beautyJsonStr", 35, "", FilterParam.FaceFilter.beautyJsonStr);
        globalScaleValue = new BeautyType("globalScaleValue", 36, FilterParam.FaceFilter.globalScaleValue);
        hazeAtom = new BeautyType("hazeAtom", 37, FilterParam.TuneColorFilter.hazeAtom);
        BeautyType beautyType = new BeautyType("hazeBlend", 38, 0.3f, FilterParam.TuneColorFilter.hazeBlend);
        hazeBlend = beautyType;
        $VALUES = new BeautyType[]{lutFile, lutIntensity, whitenFile, blackEyeCircle, laughLine, lipsMask, lips, cheeks, highlight, eyeliner, eyeshadow, eyeball, eyelash, eyebrow, makeupClose, whiten, smooth, eye, thinFace, threeCounts, chinHeight, noseWidth, noseLength, eyeDistance, mouthWidth, eyebrowDistance, upCount, middleCount, downCount, faceWidth, jawAngleWidth, eyeAngle, cheekboneWidth, beautyDebugDraw, beautyJsonPath, beautyJsonStr, globalScaleValue, hazeAtom, beautyType};
    }

    public BeautyType(String str, int i, float f2, FilterParam filterParam) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), Float.valueOf(f2), filterParam};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.value = f2;
        this.type = filterParam;
    }

    public static BeautyType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? (BeautyType) Enum.valueOf(BeautyType.class, str) : (BeautyType) invokeL.objValue;
    }

    public static BeautyType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? (BeautyType[]) $VALUES.clone() : (BeautyType[]) invokeV.objValue;
    }

    public String getTypeValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.type.getParamName() : (String) invokeV.objValue;
    }

    public BeautyType(String str, int i, String str2, FilterParam filterParam) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), str2, filterParam};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str3 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.path = str2;
        this.type = filterParam;
    }

    public BeautyType(String str, int i, FilterParam filterParam) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), filterParam};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.type = filterParam;
    }
}
