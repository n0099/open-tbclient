package com.baidu.ar.filter;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public interface FilterParam {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class FaceFilter implements FilterParam {
        public static final /* synthetic */ FaceFilter[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final FaceFilter babyFace;
        public static final FaceFilter beautyDebugDrawMode;
        public static final FaceFilter beautyJsonPath;
        public static final FaceFilter beautyJsonStr;
        public static final FaceFilter beautyReset;
        public static final FaceFilter cheekboneWidth;
        public static final FaceFilter chinHeight;
        public static final FaceFilter chinWidth;
        public static final FaceFilter customLandmarkIndex;
        public static final FaceFilter downCount;
        public static final FaceFilter eye;
        public static final FaceFilter eyeAngle;
        public static final FaceFilter eyeDistance;
        public static final FaceFilter eyebrowDistance;
        public static final FaceFilter faceThinC;
        public static final FaceFilter faceThinCCloseRadius;
        public static final FaceFilter faceThinCRadius;
        public static final FaceFilter faceThinCUpRadius;
        public static final FaceFilter faceThinLR;
        public static final FaceFilter faceThinLRC;
        public static final FaceFilter faceThinLRCU;
        public static final FaceFilter faceThinLRRadius;
        public static final FaceFilter faceWidth;
        public static final FaceFilter faceWidth1Radius;
        public static final FaceFilter faceWidth1Ratio;
        public static final FaceFilter faceWidth2Radius;
        public static final FaceFilter faceWidth2Ratio;
        public static final FaceFilter faceWidthCRadius;
        public static final FaceFilter faceWidthCRatio;
        public static final FaceFilter faceWidthCURadius;
        public static final FaceFilter faceWidthCURatio;
        public static final FaceFilter faceWidthRadius;
        public static final FaceFilter faceWidthRatio;
        public static final FaceFilter globalScaleValue;
        public static final FaceFilter jawAngleWidth;
        public static final FaceFilter middleCount;
        public static final FaceFilter mouthWidth;
        public static final FaceFilter normalFace;
        public static final FaceFilter noseBridgeWidth;
        public static final FaceFilter noseLength;
        public static final FaceFilter noseWidth;
        public static final FaceFilter noseWingWidth;
        public static final FaceFilter thinFace;
        public static final FaceFilter threeCounts;
        public static final FaceFilter upCount;
        public static final FaceFilter webCelebrityFace;
        public transient /* synthetic */ FieldHolder $fh;
        public String mParamName;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(158128880, "Lcom/baidu/ar/filter/FilterParam$FaceFilter;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(158128880, "Lcom/baidu/ar/filter/FilterParam$FaceFilter;");
                    return;
                }
            }
            babyFace = new FaceFilter("babyFace", 0, "babyFace");
            webCelebrityFace = new FaceFilter("webCelebrityFace", 1, "cyberstarFace");
            normalFace = new FaceFilter("normalFace", 2, "naturalFace");
            eye = new FaceFilter(com.baidu.pass.biometrics.face.liveness.b.a.a0, 3, "eyeScale");
            thinFace = new FaceFilter("thinFace", 4, "faceThin");
            chinHeight = new FaceFilter("chinHeight", 5, "chinHeight");
            chinWidth = new FaceFilter("chinWidth", 6, "chinWidth");
            faceWidth = new FaceFilter("faceWidth", 7, "faceWidth");
            jawAngleWidth = new FaceFilter("jawAngleWidth", 8, "jawEdgeWidth");
            eyeDistance = new FaceFilter("eyeDistance", 9, "eyeDistance");
            eyeAngle = new FaceFilter("eyeAngle", 10, "eyeAngle");
            eyebrowDistance = new FaceFilter("eyebrowDistance", 11, "eyebrowDistance");
            mouthWidth = new FaceFilter("mouthWidth", 12, "mouthWidth");
            threeCounts = new FaceFilter("threeCounts", 13, "faceLength");
            upCount = new FaceFilter("upCount", 14, "upperCountHeight");
            middleCount = new FaceFilter("middleCount", 15, "middleCountHeight");
            downCount = new FaceFilter("downCount", 16, "lowerCountHeight");
            noseWingWidth = new FaceFilter("noseWingWidth", 17, "noseWingWidth");
            noseBridgeWidth = new FaceFilter("noseBridgeWidth", 18, "noseBridgeWidth");
            noseWidth = new FaceFilter("noseWidth", 19, "noseWidth");
            noseLength = new FaceFilter("noseLength", 20, "noseLength");
            cheekboneWidth = new FaceFilter("cheekboneWidth", 21, "cheekboneWidth");
            beautyJsonPath = new FaceFilter("beautyJsonPath", 22, "json_path");
            beautyJsonStr = new FaceFilter("beautyJsonStr", 23, "json_str");
            beautyDebugDrawMode = new FaceFilter("beautyDebugDrawMode", 24, "face_beauty_filter/debug_draw_mode");
            beautyReset = new FaceFilter("beautyReset", 25, "reset");
            faceThinLR = new FaceFilter("faceThinLR", 26, "faceThinLR");
            faceThinC = new FaceFilter("faceThinC", 27, "faceThinC");
            faceThinLRC = new FaceFilter("faceThinLRC", 28, "faceThinLRC");
            faceThinLRCU = new FaceFilter("faceThinLRCU", 29, "faceThinLRCU");
            faceThinCRadius = new FaceFilter("faceThinCRadius", 30, "faceThinCRadius");
            faceThinLRRadius = new FaceFilter("faceThinLRRadius", 31, "faceThinLRRadius");
            faceThinCCloseRadius = new FaceFilter("faceThinCCloseRadius", 32, "faceThinCCloseRadius");
            faceThinCUpRadius = new FaceFilter("faceThinCUpRadius", 33, "faceThinCUpRadius");
            faceWidthRatio = new FaceFilter("faceWidthRatio", 34, "faceWidthRatio");
            faceWidth1Ratio = new FaceFilter("faceWidth1Ratio", 35, "faceWidth1Ratio");
            faceWidth2Ratio = new FaceFilter("faceWidth2Ratio", 36, "faceWidth2Ratio");
            faceWidthCURatio = new FaceFilter("faceWidthCURatio", 37, "faceWidthCURatio");
            faceWidthCRatio = new FaceFilter("faceWidthCRatio", 38, "faceWidthCRatio");
            faceWidthRadius = new FaceFilter("faceWidthRadius", 39, "faceWidthRadius");
            faceWidth1Radius = new FaceFilter("faceWidth1Radius", 40, "faceWidth1Radius");
            faceWidth2Radius = new FaceFilter("faceWidth2Radius", 41, "faceWidth2Radius");
            faceWidthCURadius = new FaceFilter("faceWidthCURadius", 42, "faceWidthCURadius");
            faceWidthCRadius = new FaceFilter("faceWidthCRadius", 43, "faceWidthCRadius");
            customLandmarkIndex = new FaceFilter("customLandmarkIndex", 44, "customLandmarkIndex");
            FaceFilter faceFilter = new FaceFilter("globalScaleValue", 45, "globalScaleValue");
            globalScaleValue = faceFilter;
            $VALUES = new FaceFilter[]{babyFace, webCelebrityFace, normalFace, eye, thinFace, chinHeight, chinWidth, faceWidth, jawAngleWidth, eyeDistance, eyeAngle, eyebrowDistance, mouthWidth, threeCounts, upCount, middleCount, downCount, noseWingWidth, noseBridgeWidth, noseWidth, noseLength, cheekboneWidth, beautyJsonPath, beautyJsonStr, beautyDebugDrawMode, beautyReset, faceThinLR, faceThinC, faceThinLRC, faceThinLRCU, faceThinCRadius, faceThinLRRadius, faceThinCCloseRadius, faceThinCUpRadius, faceWidthRatio, faceWidth1Ratio, faceWidth2Ratio, faceWidthCURatio, faceWidthCRatio, faceWidthRadius, faceWidth1Radius, faceWidth2Radius, faceWidthCURadius, faceWidthCRadius, customLandmarkIndex, faceFilter};
        }

        public FaceFilter(String str, int i2, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), str2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str3 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mParamName = str2;
        }

        public static FaceFilter valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (FaceFilter) Enum.valueOf(FaceFilter.class, str) : (FaceFilter) invokeL.objValue;
        }

        public static FaceFilter[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (FaceFilter[]) $VALUES.clone() : (FaceFilter[]) invokeV.objValue;
        }

        @Override // com.baidu.ar.filter.FilterParam
        public FilterNode getFilterNode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? FilterNode.faceFilter : (FilterNode) invokeV.objValue;
        }

        @Override // com.baidu.ar.filter.FilterParam
        public String getParamName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mParamName : (String) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class LutFilter implements FilterParam {
        public static final /* synthetic */ LutFilter[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final LutFilter lutFile;
        public static final LutFilter lutIntensity;
        public transient /* synthetic */ FieldHolder $fh;
        public String mParamName;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1542319022, "Lcom/baidu/ar/filter/FilterParam$LutFilter;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1542319022, "Lcom/baidu/ar/filter/FilterParam$LutFilter;");
                    return;
                }
            }
            lutFile = new LutFilter("lutFile", 0, "global_path");
            LutFilter lutFilter = new LutFilter("lutIntensity", 1, "global_intensity");
            lutIntensity = lutFilter;
            $VALUES = new LutFilter[]{lutFile, lutFilter};
        }

        public LutFilter(String str, int i2, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), str2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str3 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mParamName = str2;
        }

        public static LutFilter valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (LutFilter) Enum.valueOf(LutFilter.class, str) : (LutFilter) invokeL.objValue;
        }

        public static LutFilter[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (LutFilter[]) $VALUES.clone() : (LutFilter[]) invokeV.objValue;
        }

        @Override // com.baidu.ar.filter.FilterParam
        public FilterNode getFilterNode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? FilterNode.lutFilter : (FilterNode) invokeV.objValue;
        }

        @Override // com.baidu.ar.filter.FilterParam
        public String getParamName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mParamName : (String) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class MakeupFilter implements FilterParam {
        public static final /* synthetic */ MakeupFilter[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final MakeupFilter allMakeups;
        public static final MakeupFilter beautyMakeupFilter;
        public static final MakeupFilter cheeks;
        public static final MakeupFilter eyeball;
        public static final MakeupFilter eyebrow;
        public static final MakeupFilter eyelash;
        public static final MakeupFilter eyeliner;
        public static final MakeupFilter eyeshadow;
        public static final MakeupFilter highlight;
        public static final MakeupFilter lips;
        public static final MakeupFilter lipsMask;
        public transient /* synthetic */ FieldHolder $fh;
        public String mParamName;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1316529084, "Lcom/baidu/ar/filter/FilterParam$MakeupFilter;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1316529084, "Lcom/baidu/ar/filter/FilterParam$MakeupFilter;");
                    return;
                }
            }
            lipsMask = new MakeupFilter("lipsMask", 0, "lips_mask");
            cheeks = new MakeupFilter("cheeks", 1, "cheeks");
            eyebrow = new MakeupFilter("eyebrow", 2, "eyebrow");
            eyelash = new MakeupFilter("eyelash", 3, "eyelash");
            eyeliner = new MakeupFilter("eyeliner", 4, "eyeliner");
            eyeshadow = new MakeupFilter("eyeshadow", 5, "eyeshadow");
            highlight = new MakeupFilter("highlight", 6, "highlight");
            eyeball = new MakeupFilter("eyeball", 7, "eyeball");
            lips = new MakeupFilter("lips", 8, "lips");
            allMakeups = new MakeupFilter("allMakeups", 9, "all_makeups");
            MakeupFilter makeupFilter = new MakeupFilter("beautyMakeupFilter", 10, "beauty_makeup_filter");
            beautyMakeupFilter = makeupFilter;
            $VALUES = new MakeupFilter[]{lipsMask, cheeks, eyebrow, eyelash, eyeliner, eyeshadow, highlight, eyeball, lips, allMakeups, makeupFilter};
        }

        public MakeupFilter(String str, int i2, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), str2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str3 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mParamName = str2;
        }

        public static MakeupFilter valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (MakeupFilter) Enum.valueOf(MakeupFilter.class, str) : (MakeupFilter) invokeL.objValue;
        }

        public static MakeupFilter[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (MakeupFilter[]) $VALUES.clone() : (MakeupFilter[]) invokeV.objValue;
        }

        @Override // com.baidu.ar.filter.FilterParam
        public FilterNode getFilterNode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? FilterNode.makeupFilter : (FilterNode) invokeV.objValue;
        }

        @Override // com.baidu.ar.filter.FilterParam
        public String getParamName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mParamName : (String) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class SkinFilter implements FilterParam {
        public static final /* synthetic */ SkinFilter[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final SkinFilter blackEyeCircle;
        public static final SkinFilter enableFaceSmooth;
        public static final SkinFilter enableFaceWhiten;
        public static final SkinFilter laughLine;
        public static final SkinFilter smooth;
        public static final SkinFilter whiten;
        public static final SkinFilter whitenFile;
        public transient /* synthetic */ FieldHolder $fh;
        public String mParamName;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1148028880, "Lcom/baidu/ar/filter/FilterParam$SkinFilter;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1148028880, "Lcom/baidu/ar/filter/FilterParam$SkinFilter;");
                    return;
                }
            }
            whitenFile = new SkinFilter("whitenFile", 0, "res_path");
            smooth = new SkinFilter("smooth", 1, "intensity_smooth");
            whiten = new SkinFilter("whiten", 2, "intensity_white");
            enableFaceSmooth = new SkinFilter("enableFaceSmooth", 3, "use_face_mask_to_smooth");
            enableFaceWhiten = new SkinFilter("enableFaceWhiten", 4, "use_face_mask_to_whiten");
            blackEyeCircle = new SkinFilter("blackEyeCircle", 5, "face_cover/intensity_red");
            SkinFilter skinFilter = new SkinFilter("laughLine", 6, "face_cover/intensity_green");
            laughLine = skinFilter;
            $VALUES = new SkinFilter[]{whitenFile, smooth, whiten, enableFaceSmooth, enableFaceWhiten, blackEyeCircle, skinFilter};
        }

        public SkinFilter(String str, int i2, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), str2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str3 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mParamName = str2;
        }

        public static SkinFilter valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (SkinFilter) Enum.valueOf(SkinFilter.class, str) : (SkinFilter) invokeL.objValue;
        }

        public static SkinFilter[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (SkinFilter[]) $VALUES.clone() : (SkinFilter[]) invokeV.objValue;
        }

        @Override // com.baidu.ar.filter.FilterParam
        public FilterNode getFilterNode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? FilterNode.skinFilter : (FilterNode) invokeV.objValue;
        }

        @Override // com.baidu.ar.filter.FilterParam
        public String getParamName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mParamName : (String) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class TuneColorFilter implements FilterParam {
        public static final /* synthetic */ TuneColorFilter[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final TuneColorFilter bluePoints;
        public static final TuneColorFilter brightness;
        public static final TuneColorFilter contrast;
        public static final TuneColorFilter curve;
        public static final TuneColorFilter greenPoints;
        public static final TuneColorFilter hazeAtom;
        public static final TuneColorFilter hazeBlend;
        public static final TuneColorFilter redPoints;
        public static final TuneColorFilter rgbPoints;
        public static final TuneColorFilter saturation;
        public static final TuneColorFilter toneFile;
        public transient /* synthetic */ FieldHolder $fh;
        public String mParamName;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1473127186, "Lcom/baidu/ar/filter/FilterParam$TuneColorFilter;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1473127186, "Lcom/baidu/ar/filter/FilterParam$TuneColorFilter;");
                    return;
                }
            }
            toneFile = new TuneColorFilter("toneFile", 0, "tone_curve_res_path");
            brightness = new TuneColorFilter("brightness", 1, "intensity_brightness");
            contrast = new TuneColorFilter("contrast", 2, "intensity_contrast");
            saturation = new TuneColorFilter("saturation", 3, "intensity_saturation");
            rgbPoints = new TuneColorFilter("rgbPoints", 4, "rgb_curve_composite_points");
            redPoints = new TuneColorFilter("redPoints", 5, "red_curve_points");
            greenPoints = new TuneColorFilter("greenPoints", 6, "green_curve_points");
            bluePoints = new TuneColorFilter("bluePoints", 7, "blue_curve_points");
            curve = new TuneColorFilter("curve", 8, "intensity_curve");
            hazeAtom = new TuneColorFilter("hazeAtom", 9, "haze_atom");
            TuneColorFilter tuneColorFilter = new TuneColorFilter("hazeBlend", 10, "haze_blend");
            hazeBlend = tuneColorFilter;
            $VALUES = new TuneColorFilter[]{toneFile, brightness, contrast, saturation, rgbPoints, redPoints, greenPoints, bluePoints, curve, hazeAtom, tuneColorFilter};
        }

        public TuneColorFilter(String str, int i2, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), str2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str3 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mParamName = str2;
        }

        public static TuneColorFilter valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (TuneColorFilter) Enum.valueOf(TuneColorFilter.class, str) : (TuneColorFilter) invokeL.objValue;
        }

        public static TuneColorFilter[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (TuneColorFilter[]) $VALUES.clone() : (TuneColorFilter[]) invokeV.objValue;
        }

        @Override // com.baidu.ar.filter.FilterParam
        public FilterNode getFilterNode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? FilterNode.tuneColorFilter : (FilterNode) invokeV.objValue;
        }

        @Override // com.baidu.ar.filter.FilterParam
        public String getParamName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mParamName : (String) invokeV.objValue;
        }
    }

    FilterNode getFilterNode();

    String getParamName();
}
