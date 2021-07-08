package com.baidu.pass.main.facesdk.model;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class BDFaceSDKCommon {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class AlignType {
        public static final /* synthetic */ AlignType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final AlignType BDFACE_ALIGN_TYPE_NIR_ACCURATE;
        public static final AlignType BDFACE_ALIGN_TYPE_RGB_ACCURATE;
        public static final AlignType BDFACE_ALIGN_TYPE_RGB_FAST;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1849684824, "Lcom/baidu/pass/main/facesdk/model/BDFaceSDKCommon$AlignType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1849684824, "Lcom/baidu/pass/main/facesdk/model/BDFaceSDKCommon$AlignType;");
                    return;
                }
            }
            BDFACE_ALIGN_TYPE_RGB_ACCURATE = new AlignType("BDFACE_ALIGN_TYPE_RGB_ACCURATE", 0);
            BDFACE_ALIGN_TYPE_RGB_FAST = new AlignType("BDFACE_ALIGN_TYPE_RGB_FAST", 1);
            AlignType alignType = new AlignType("BDFACE_ALIGN_TYPE_NIR_ACCURATE", 2);
            BDFACE_ALIGN_TYPE_NIR_ACCURATE = alignType;
            $VALUES = new AlignType[]{BDFACE_ALIGN_TYPE_RGB_ACCURATE, BDFACE_ALIGN_TYPE_RGB_FAST, alignType};
        }

        public AlignType(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static AlignType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (AlignType) Enum.valueOf(AlignType.class, str) : (AlignType) invokeL.objValue;
        }

        public static AlignType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (AlignType[]) $VALUES.clone() : (AlignType[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class BDFaceActionLiveType {
        public static final /* synthetic */ BDFaceActionLiveType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final BDFaceActionLiveType BDFACE_ACTION_LIVE_LOOK_UP;
        public static final BDFaceActionLiveType BDFACE_ACTION_LIVE_NOD;
        public static final BDFaceActionLiveType BDFACE_ACTION_LIVE_OPEN_MOUTH;
        public static final BDFaceActionLiveType BDFACE_ACTION_LIVE_SHAKE_HEAD;
        public static final BDFaceActionLiveType BDFACE_ACTION_LIVE_TURN_LEFT;
        public static final BDFaceActionLiveType BDFACE_ACTION_LIVE_TURN_RIGHT;
        public static final BDFaceActionLiveType BDFace_ACTION_LIVE_BLINK;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-478983964, "Lcom/baidu/pass/main/facesdk/model/BDFaceSDKCommon$BDFaceActionLiveType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-478983964, "Lcom/baidu/pass/main/facesdk/model/BDFaceSDKCommon$BDFaceActionLiveType;");
                    return;
                }
            }
            BDFace_ACTION_LIVE_BLINK = new BDFaceActionLiveType("BDFace_ACTION_LIVE_BLINK", 0);
            BDFACE_ACTION_LIVE_OPEN_MOUTH = new BDFaceActionLiveType("BDFACE_ACTION_LIVE_OPEN_MOUTH", 1);
            BDFACE_ACTION_LIVE_NOD = new BDFaceActionLiveType("BDFACE_ACTION_LIVE_NOD", 2);
            BDFACE_ACTION_LIVE_SHAKE_HEAD = new BDFaceActionLiveType("BDFACE_ACTION_LIVE_SHAKE_HEAD", 3);
            BDFACE_ACTION_LIVE_LOOK_UP = new BDFaceActionLiveType("BDFACE_ACTION_LIVE_LOOK_UP", 4);
            BDFACE_ACTION_LIVE_TURN_LEFT = new BDFaceActionLiveType("BDFACE_ACTION_LIVE_TURN_LEFT", 5);
            BDFaceActionLiveType bDFaceActionLiveType = new BDFaceActionLiveType("BDFACE_ACTION_LIVE_TURN_RIGHT", 6);
            BDFACE_ACTION_LIVE_TURN_RIGHT = bDFaceActionLiveType;
            $VALUES = new BDFaceActionLiveType[]{BDFace_ACTION_LIVE_BLINK, BDFACE_ACTION_LIVE_OPEN_MOUTH, BDFACE_ACTION_LIVE_NOD, BDFACE_ACTION_LIVE_SHAKE_HEAD, BDFACE_ACTION_LIVE_LOOK_UP, BDFACE_ACTION_LIVE_TURN_LEFT, bDFaceActionLiveType};
        }

        public BDFaceActionLiveType(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static BDFaceActionLiveType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (BDFaceActionLiveType) Enum.valueOf(BDFaceActionLiveType.class, str) : (BDFaceActionLiveType) invokeL.objValue;
        }

        public static BDFaceActionLiveType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (BDFaceActionLiveType[]) $VALUES.clone() : (BDFaceActionLiveType[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class BDFaceCoreRunMode {
        public static final /* synthetic */ BDFaceCoreRunMode[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final BDFaceCoreRunMode BDFACE_LITE_POWER_FULL;
        public static final BDFaceCoreRunMode BDFACE_LITE_POWER_HIGH;
        public static final BDFaceCoreRunMode BDFACE_LITE_POWER_LOW;
        public static final BDFaceCoreRunMode BDFACE_LITE_POWER_NO_BIND;
        public static final BDFaceCoreRunMode BDFACE_LITE_POWER_RAND_HIGH;
        public static final BDFaceCoreRunMode BDFACE_LITE_POWER_RAND_LOW;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1068027321, "Lcom/baidu/pass/main/facesdk/model/BDFaceSDKCommon$BDFaceCoreRunMode;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1068027321, "Lcom/baidu/pass/main/facesdk/model/BDFaceSDKCommon$BDFaceCoreRunMode;");
                    return;
                }
            }
            BDFACE_LITE_POWER_HIGH = new BDFaceCoreRunMode("BDFACE_LITE_POWER_HIGH", 0);
            BDFACE_LITE_POWER_LOW = new BDFaceCoreRunMode("BDFACE_LITE_POWER_LOW", 1);
            BDFACE_LITE_POWER_FULL = new BDFaceCoreRunMode("BDFACE_LITE_POWER_FULL", 2);
            BDFACE_LITE_POWER_NO_BIND = new BDFaceCoreRunMode("BDFACE_LITE_POWER_NO_BIND", 3);
            BDFACE_LITE_POWER_RAND_HIGH = new BDFaceCoreRunMode("BDFACE_LITE_POWER_RAND_HIGH", 4);
            BDFaceCoreRunMode bDFaceCoreRunMode = new BDFaceCoreRunMode("BDFACE_LITE_POWER_RAND_LOW", 5);
            BDFACE_LITE_POWER_RAND_LOW = bDFaceCoreRunMode;
            $VALUES = new BDFaceCoreRunMode[]{BDFACE_LITE_POWER_HIGH, BDFACE_LITE_POWER_LOW, BDFACE_LITE_POWER_FULL, BDFACE_LITE_POWER_NO_BIND, BDFACE_LITE_POWER_RAND_HIGH, bDFaceCoreRunMode};
        }

        public BDFaceCoreRunMode(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static BDFaceCoreRunMode valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (BDFaceCoreRunMode) Enum.valueOf(BDFaceCoreRunMode.class, str) : (BDFaceCoreRunMode) invokeL.objValue;
        }

        public static BDFaceCoreRunMode[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (BDFaceCoreRunMode[]) $VALUES.clone() : (BDFaceCoreRunMode[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class BDFaceEmotion {
        public static final /* synthetic */ BDFaceEmotion[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final BDFaceEmotion BDFACE_EMOTION_CALM;
        public static final BDFaceEmotion BDFACE_EMOTION_FROWN;
        public static final BDFaceEmotion BDFACE_EMOTION_SMILE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1677610779, "Lcom/baidu/pass/main/facesdk/model/BDFaceSDKCommon$BDFaceEmotion;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1677610779, "Lcom/baidu/pass/main/facesdk/model/BDFaceSDKCommon$BDFaceEmotion;");
                    return;
                }
            }
            BDFACE_EMOTION_FROWN = new BDFaceEmotion("BDFACE_EMOTION_FROWN", 0);
            BDFACE_EMOTION_SMILE = new BDFaceEmotion("BDFACE_EMOTION_SMILE", 1);
            BDFaceEmotion bDFaceEmotion = new BDFaceEmotion("BDFACE_EMOTION_CALM", 2);
            BDFACE_EMOTION_CALM = bDFaceEmotion;
            $VALUES = new BDFaceEmotion[]{BDFACE_EMOTION_FROWN, BDFACE_EMOTION_SMILE, bDFaceEmotion};
        }

        public BDFaceEmotion(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static BDFaceEmotion valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (BDFaceEmotion) Enum.valueOf(BDFaceEmotion.class, str) : (BDFaceEmotion) invokeL.objValue;
        }

        public static BDFaceEmotion[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (BDFaceEmotion[]) $VALUES.clone() : (BDFaceEmotion[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class BDFaceEmotionEnum {
        public static final /* synthetic */ BDFaceEmotionEnum[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final BDFaceEmotionEnum BDFACE_EMOTIONS_ANGRY;
        public static final BDFaceEmotionEnum BDFACE_EMOTIONS_DISGUST;
        public static final BDFaceEmotionEnum BDFACE_EMOTIONS_FEAR;
        public static final BDFaceEmotionEnum BDFACE_EMOTIONS_HAPPY;
        public static final BDFaceEmotionEnum BDFACE_EMOTIONS_NEUTRAL;
        public static final BDFaceEmotionEnum BDFACE_EMOTIONS_SAD;
        public static final BDFaceEmotionEnum BDFACE_EMOTIONS_SURPRISE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1870923238, "Lcom/baidu/pass/main/facesdk/model/BDFaceSDKCommon$BDFaceEmotionEnum;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1870923238, "Lcom/baidu/pass/main/facesdk/model/BDFaceSDKCommon$BDFaceEmotionEnum;");
                    return;
                }
            }
            BDFACE_EMOTIONS_ANGRY = new BDFaceEmotionEnum("BDFACE_EMOTIONS_ANGRY", 0);
            BDFACE_EMOTIONS_DISGUST = new BDFaceEmotionEnum("BDFACE_EMOTIONS_DISGUST", 1);
            BDFACE_EMOTIONS_FEAR = new BDFaceEmotionEnum("BDFACE_EMOTIONS_FEAR", 2);
            BDFACE_EMOTIONS_HAPPY = new BDFaceEmotionEnum("BDFACE_EMOTIONS_HAPPY", 3);
            BDFACE_EMOTIONS_SAD = new BDFaceEmotionEnum("BDFACE_EMOTIONS_SAD", 4);
            BDFACE_EMOTIONS_SURPRISE = new BDFaceEmotionEnum("BDFACE_EMOTIONS_SURPRISE", 5);
            BDFaceEmotionEnum bDFaceEmotionEnum = new BDFaceEmotionEnum("BDFACE_EMOTIONS_NEUTRAL", 6);
            BDFACE_EMOTIONS_NEUTRAL = bDFaceEmotionEnum;
            $VALUES = new BDFaceEmotionEnum[]{BDFACE_EMOTIONS_ANGRY, BDFACE_EMOTIONS_DISGUST, BDFACE_EMOTIONS_FEAR, BDFACE_EMOTIONS_HAPPY, BDFACE_EMOTIONS_SAD, BDFACE_EMOTIONS_SURPRISE, bDFaceEmotionEnum};
        }

        public BDFaceEmotionEnum(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static BDFaceEmotionEnum valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (BDFaceEmotionEnum) Enum.valueOf(BDFaceEmotionEnum.class, str) : (BDFaceEmotionEnum) invokeL.objValue;
        }

        public static BDFaceEmotionEnum[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (BDFaceEmotionEnum[]) $VALUES.clone() : (BDFaceEmotionEnum[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class BDFaceGazeDirection {
        public static final /* synthetic */ BDFaceGazeDirection[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final BDFaceGazeDirection BDFACE_GACE_DIRECTION_DOWN;
        public static final BDFaceGazeDirection BDFACE_GACE_DIRECTION_EYE_CLOSE;
        public static final BDFaceGazeDirection BDFACE_GACE_DIRECTION_FRONT;
        public static final BDFaceGazeDirection BDFACE_GACE_DIRECTION_LEFT;
        public static final BDFaceGazeDirection BDFACE_GACE_DIRECTION_RIGHT;
        public static final BDFaceGazeDirection BDFACE_GACE_DIRECTION_UP;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-210205796, "Lcom/baidu/pass/main/facesdk/model/BDFaceSDKCommon$BDFaceGazeDirection;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-210205796, "Lcom/baidu/pass/main/facesdk/model/BDFaceSDKCommon$BDFaceGazeDirection;");
                    return;
                }
            }
            BDFACE_GACE_DIRECTION_UP = new BDFaceGazeDirection("BDFACE_GACE_DIRECTION_UP", 0);
            BDFACE_GACE_DIRECTION_DOWN = new BDFaceGazeDirection("BDFACE_GACE_DIRECTION_DOWN", 1);
            BDFACE_GACE_DIRECTION_RIGHT = new BDFaceGazeDirection("BDFACE_GACE_DIRECTION_RIGHT", 2);
            BDFACE_GACE_DIRECTION_LEFT = new BDFaceGazeDirection("BDFACE_GACE_DIRECTION_LEFT", 3);
            BDFACE_GACE_DIRECTION_FRONT = new BDFaceGazeDirection("BDFACE_GACE_DIRECTION_FRONT", 4);
            BDFaceGazeDirection bDFaceGazeDirection = new BDFaceGazeDirection("BDFACE_GACE_DIRECTION_EYE_CLOSE", 5);
            BDFACE_GACE_DIRECTION_EYE_CLOSE = bDFaceGazeDirection;
            $VALUES = new BDFaceGazeDirection[]{BDFACE_GACE_DIRECTION_UP, BDFACE_GACE_DIRECTION_DOWN, BDFACE_GACE_DIRECTION_RIGHT, BDFACE_GACE_DIRECTION_LEFT, BDFACE_GACE_DIRECTION_FRONT, bDFaceGazeDirection};
        }

        public BDFaceGazeDirection(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static BDFaceGazeDirection valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (BDFaceGazeDirection) Enum.valueOf(BDFaceGazeDirection.class, str) : (BDFaceGazeDirection) invokeL.objValue;
        }

        public static BDFaceGazeDirection[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (BDFaceGazeDirection[]) $VALUES.clone() : (BDFaceGazeDirection[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class BDFaceGender {
        public static final /* synthetic */ BDFaceGender[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final BDFaceGender BDFACE_GENDER_FEMALE;
        public static final BDFaceGender BDFACE_GENDER_MALE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1449354657, "Lcom/baidu/pass/main/facesdk/model/BDFaceSDKCommon$BDFaceGender;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1449354657, "Lcom/baidu/pass/main/facesdk/model/BDFaceSDKCommon$BDFaceGender;");
                    return;
                }
            }
            BDFACE_GENDER_FEMALE = new BDFaceGender("BDFACE_GENDER_FEMALE", 0);
            BDFaceGender bDFaceGender = new BDFaceGender("BDFACE_GENDER_MALE", 1);
            BDFACE_GENDER_MALE = bDFaceGender;
            $VALUES = new BDFaceGender[]{BDFACE_GENDER_FEMALE, bDFaceGender};
        }

        public BDFaceGender(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static BDFaceGender valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (BDFaceGender) Enum.valueOf(BDFaceGender.class, str) : (BDFaceGender) invokeL.objValue;
        }

        public static BDFaceGender[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (BDFaceGender[]) $VALUES.clone() : (BDFaceGender[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class BDFaceGlasses {
        public static final /* synthetic */ BDFaceGlasses[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final BDFaceGlasses BDFACE_GLASSES;
        public static final BDFaceGlasses BDFACE_NO_GLASSES;
        public static final BDFaceGlasses BDFACE_SUN_GLASSES;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-420682708, "Lcom/baidu/pass/main/facesdk/model/BDFaceSDKCommon$BDFaceGlasses;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-420682708, "Lcom/baidu/pass/main/facesdk/model/BDFaceSDKCommon$BDFaceGlasses;");
                    return;
                }
            }
            BDFACE_NO_GLASSES = new BDFaceGlasses("BDFACE_NO_GLASSES", 0);
            BDFACE_GLASSES = new BDFaceGlasses("BDFACE_GLASSES", 1);
            BDFaceGlasses bDFaceGlasses = new BDFaceGlasses("BDFACE_SUN_GLASSES", 2);
            BDFACE_SUN_GLASSES = bDFaceGlasses;
            $VALUES = new BDFaceGlasses[]{BDFACE_NO_GLASSES, BDFACE_GLASSES, bDFaceGlasses};
        }

        public BDFaceGlasses(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static BDFaceGlasses valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (BDFaceGlasses) Enum.valueOf(BDFaceGlasses.class, str) : (BDFaceGlasses) invokeL.objValue;
        }

        public static BDFaceGlasses[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (BDFaceGlasses[]) $VALUES.clone() : (BDFaceGlasses[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class BDFaceImageType {
        public static final /* synthetic */ BDFaceImageType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final BDFaceImageType BDFACE_IMAGE_TYPE_BGR;
        public static final BDFaceImageType BDFACE_IMAGE_TYPE_BGRA;
        public static final BDFaceImageType BDFACE_IMAGE_TYPE_DEPTH;
        public static final BDFaceImageType BDFACE_IMAGE_TYPE_GRAY;
        public static final BDFaceImageType BDFACE_IMAGE_TYPE_RGB;
        public static final BDFaceImageType BDFACE_IMAGE_TYPE_RGBA;
        public static final BDFaceImageType BDFACE_IMAGE_TYPE_YUV_NV12;
        public static final BDFaceImageType BDFACE_IMAGE_TYPE_YUV_NV21;
        public static final BDFaceImageType BDFACE_IMAGE_TYPE_YUV_YV12;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-931055423, "Lcom/baidu/pass/main/facesdk/model/BDFaceSDKCommon$BDFaceImageType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-931055423, "Lcom/baidu/pass/main/facesdk/model/BDFaceSDKCommon$BDFaceImageType;");
                    return;
                }
            }
            BDFACE_IMAGE_TYPE_RGB = new BDFaceImageType("BDFACE_IMAGE_TYPE_RGB", 0);
            BDFACE_IMAGE_TYPE_BGR = new BDFaceImageType("BDFACE_IMAGE_TYPE_BGR", 1);
            BDFACE_IMAGE_TYPE_RGBA = new BDFaceImageType("BDFACE_IMAGE_TYPE_RGBA", 2);
            BDFACE_IMAGE_TYPE_BGRA = new BDFaceImageType("BDFACE_IMAGE_TYPE_BGRA", 3);
            BDFACE_IMAGE_TYPE_GRAY = new BDFaceImageType("BDFACE_IMAGE_TYPE_GRAY", 4);
            BDFACE_IMAGE_TYPE_DEPTH = new BDFaceImageType("BDFACE_IMAGE_TYPE_DEPTH", 5);
            BDFACE_IMAGE_TYPE_YUV_NV21 = new BDFaceImageType("BDFACE_IMAGE_TYPE_YUV_NV21", 6);
            BDFACE_IMAGE_TYPE_YUV_NV12 = new BDFaceImageType("BDFACE_IMAGE_TYPE_YUV_NV12", 7);
            BDFaceImageType bDFaceImageType = new BDFaceImageType("BDFACE_IMAGE_TYPE_YUV_YV12", 8);
            BDFACE_IMAGE_TYPE_YUV_YV12 = bDFaceImageType;
            $VALUES = new BDFaceImageType[]{BDFACE_IMAGE_TYPE_RGB, BDFACE_IMAGE_TYPE_BGR, BDFACE_IMAGE_TYPE_RGBA, BDFACE_IMAGE_TYPE_BGRA, BDFACE_IMAGE_TYPE_GRAY, BDFACE_IMAGE_TYPE_DEPTH, BDFACE_IMAGE_TYPE_YUV_NV21, BDFACE_IMAGE_TYPE_YUV_NV12, bDFaceImageType};
        }

        public BDFaceImageType(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static BDFaceImageType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (BDFaceImageType) Enum.valueOf(BDFaceImageType.class, str) : (BDFaceImageType) invokeL.objValue;
        }

        public static BDFaceImageType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (BDFaceImageType[]) $VALUES.clone() : (BDFaceImageType[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class BDFaceLogInfo {
        public static final /* synthetic */ BDFaceLogInfo[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final BDFaceLogInfo BDFACE_LOG_ERROR_MESSAGE;
        public static final BDFaceLogInfo BDFACE_LOG_TYPE_ALL;
        public static final BDFaceLogInfo BDFACE_LOG_TYPE_DEBUG;
        public static final BDFaceLogInfo BDFACE_LOG_TYPE_PERF;
        public static final BDFaceLogInfo BDFACE_LOG_VALUE_MESSAGE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1796182972, "Lcom/baidu/pass/main/facesdk/model/BDFaceSDKCommon$BDFaceLogInfo;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1796182972, "Lcom/baidu/pass/main/facesdk/model/BDFaceSDKCommon$BDFaceLogInfo;");
                    return;
                }
            }
            BDFACE_LOG_ERROR_MESSAGE = new BDFaceLogInfo("BDFACE_LOG_ERROR_MESSAGE", 0);
            BDFACE_LOG_VALUE_MESSAGE = new BDFaceLogInfo("BDFACE_LOG_VALUE_MESSAGE", 1);
            BDFACE_LOG_TYPE_PERF = new BDFaceLogInfo("BDFACE_LOG_TYPE_PERF", 2);
            BDFACE_LOG_TYPE_ALL = new BDFaceLogInfo("BDFACE_LOG_TYPE_ALL", 3);
            BDFaceLogInfo bDFaceLogInfo = new BDFaceLogInfo("BDFACE_LOG_TYPE_DEBUG", 4);
            BDFACE_LOG_TYPE_DEBUG = bDFaceLogInfo;
            $VALUES = new BDFaceLogInfo[]{BDFACE_LOG_ERROR_MESSAGE, BDFACE_LOG_VALUE_MESSAGE, BDFACE_LOG_TYPE_PERF, BDFACE_LOG_TYPE_ALL, bDFaceLogInfo};
        }

        public BDFaceLogInfo(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static BDFaceLogInfo valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (BDFaceLogInfo) Enum.valueOf(BDFaceLogInfo.class, str) : (BDFaceLogInfo) invokeL.objValue;
        }

        public static BDFaceLogInfo[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (BDFaceLogInfo[]) $VALUES.clone() : (BDFaceLogInfo[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class BDFaceRace {
        public static final /* synthetic */ BDFaceRace[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final BDFaceRace BDFACE_RACE_BLACK;
        public static final BDFaceRace BDFACE_RACE_INDIAN;
        public static final BDFaceRace BDFACE_RACE_WHITE;
        public static final BDFaceRace BDFACE_RACE_YELLOW;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-478629489, "Lcom/baidu/pass/main/facesdk/model/BDFaceSDKCommon$BDFaceRace;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-478629489, "Lcom/baidu/pass/main/facesdk/model/BDFaceSDKCommon$BDFaceRace;");
                    return;
                }
            }
            BDFACE_RACE_YELLOW = new BDFaceRace("BDFACE_RACE_YELLOW", 0);
            BDFACE_RACE_WHITE = new BDFaceRace("BDFACE_RACE_WHITE", 1);
            BDFACE_RACE_BLACK = new BDFaceRace("BDFACE_RACE_BLACK", 2);
            BDFaceRace bDFaceRace = new BDFaceRace("BDFACE_RACE_INDIAN", 3);
            BDFACE_RACE_INDIAN = bDFaceRace;
            $VALUES = new BDFaceRace[]{BDFACE_RACE_YELLOW, BDFACE_RACE_WHITE, BDFACE_RACE_BLACK, bDFaceRace};
        }

        public BDFaceRace(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static BDFaceRace valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (BDFaceRace) Enum.valueOf(BDFaceRace.class, str) : (BDFaceRace) invokeL.objValue;
        }

        public static BDFaceRace[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (BDFaceRace[]) $VALUES.clone() : (BDFaceRace[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class DetectType {
        public static final /* synthetic */ DetectType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final DetectType DETECT_NIR;
        public static final DetectType DETECT_VIS;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-397784126, "Lcom/baidu/pass/main/facesdk/model/BDFaceSDKCommon$DetectType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-397784126, "Lcom/baidu/pass/main/facesdk/model/BDFaceSDKCommon$DetectType;");
                    return;
                }
            }
            DETECT_VIS = new DetectType("DETECT_VIS", 0);
            DetectType detectType = new DetectType("DETECT_NIR", 1);
            DETECT_NIR = detectType;
            $VALUES = new DetectType[]{DETECT_VIS, detectType};
        }

        public DetectType(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static DetectType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (DetectType) Enum.valueOf(DetectType.class, str) : (DetectType) invokeL.objValue;
        }

        public static DetectType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (DetectType[]) $VALUES.clone() : (DetectType[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class FaceQualityType {
        public static final /* synthetic */ FaceQualityType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final FaceQualityType BLUR;
        public static final FaceQualityType ILLUMINATION;
        public static final FaceQualityType OCCLUSION;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-199837797, "Lcom/baidu/pass/main/facesdk/model/BDFaceSDKCommon$FaceQualityType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-199837797, "Lcom/baidu/pass/main/facesdk/model/BDFaceSDKCommon$FaceQualityType;");
                    return;
                }
            }
            BLUR = new FaceQualityType("BLUR", 0);
            OCCLUSION = new FaceQualityType("OCCLUSION", 1);
            FaceQualityType faceQualityType = new FaceQualityType("ILLUMINATION", 2);
            ILLUMINATION = faceQualityType;
            $VALUES = new FaceQualityType[]{BLUR, OCCLUSION, faceQualityType};
        }

        public FaceQualityType(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static FaceQualityType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (FaceQualityType) Enum.valueOf(FaceQualityType.class, str) : (FaceQualityType) invokeL.objValue;
        }

        public static FaceQualityType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (FaceQualityType[]) $VALUES.clone() : (FaceQualityType[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class FeatureType {
        public static final /* synthetic */ FeatureType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final FeatureType BDFACE_FEATURE_TYPE_ID_PHOTO;
        public static final FeatureType BDFACE_FEATURE_TYPE_LIVE_PHOTO;
        public static final FeatureType BDFACE_FEATURE_TYPE_NIR;
        public static final FeatureType BDFACE_FEATURE_TYPE_RGBD;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1107851513, "Lcom/baidu/pass/main/facesdk/model/BDFaceSDKCommon$FeatureType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1107851513, "Lcom/baidu/pass/main/facesdk/model/BDFaceSDKCommon$FeatureType;");
                    return;
                }
            }
            BDFACE_FEATURE_TYPE_LIVE_PHOTO = new FeatureType("BDFACE_FEATURE_TYPE_LIVE_PHOTO", 0);
            BDFACE_FEATURE_TYPE_ID_PHOTO = new FeatureType("BDFACE_FEATURE_TYPE_ID_PHOTO", 1);
            BDFACE_FEATURE_TYPE_NIR = new FeatureType("BDFACE_FEATURE_TYPE_NIR", 2);
            FeatureType featureType = new FeatureType("BDFACE_FEATURE_TYPE_RGBD", 3);
            BDFACE_FEATURE_TYPE_RGBD = featureType;
            $VALUES = new FeatureType[]{BDFACE_FEATURE_TYPE_LIVE_PHOTO, BDFACE_FEATURE_TYPE_ID_PHOTO, BDFACE_FEATURE_TYPE_NIR, featureType};
        }

        public FeatureType(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static FeatureType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (FeatureType) Enum.valueOf(FeatureType.class, str) : (FeatureType) invokeL.objValue;
        }

        public static FeatureType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (FeatureType[]) $VALUES.clone() : (FeatureType[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class LiveType {
        public static final /* synthetic */ LiveType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final LiveType BDFACE_SILENT_LIVE_TYPE_DEPTH;
        public static final LiveType BDFACE_SILENT_LIVE_TYPE_NIR;
        public static final LiveType BDFACE_SILENT_LIVE_TYPE_RGB;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-154300391, "Lcom/baidu/pass/main/facesdk/model/BDFaceSDKCommon$LiveType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-154300391, "Lcom/baidu/pass/main/facesdk/model/BDFaceSDKCommon$LiveType;");
                    return;
                }
            }
            BDFACE_SILENT_LIVE_TYPE_RGB = new LiveType("BDFACE_SILENT_LIVE_TYPE_RGB", 0);
            BDFACE_SILENT_LIVE_TYPE_NIR = new LiveType("BDFACE_SILENT_LIVE_TYPE_NIR", 1);
            LiveType liveType = new LiveType("BDFACE_SILENT_LIVE_TYPE_DEPTH", 2);
            BDFACE_SILENT_LIVE_TYPE_DEPTH = liveType;
            $VALUES = new LiveType[]{BDFACE_SILENT_LIVE_TYPE_RGB, BDFACE_SILENT_LIVE_TYPE_NIR, liveType};
        }

        public LiveType(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static LiveType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (LiveType) Enum.valueOf(LiveType.class, str) : (LiveType) invokeL.objValue;
        }

        public static LiveType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (LiveType[]) $VALUES.clone() : (LiveType[]) invokeV.objValue;
        }
    }

    public BDFaceSDKCommon() {
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
}
