package com.baidu.sofire.ac;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class FaceEnum {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class FaceType {
        public static final /* synthetic */ FaceType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final FaceType CERT;
        public static final FaceType IDCARD;
        public static final FaceType INFRARED;
        public static final FaceType LIVE;
        public static final FaceType WATERMARK;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(746130716, "Lcom/baidu/sofire/ac/FaceEnum$FaceType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(746130716, "Lcom/baidu/sofire/ac/FaceEnum$FaceType;");
                    return;
                }
            }
            LIVE = new FaceType("LIVE", 0);
            IDCARD = new FaceType("IDCARD", 1);
            WATERMARK = new FaceType("WATERMARK", 2);
            CERT = new FaceType("CERT", 3);
            FaceType faceType = new FaceType("INFRARED", 4);
            INFRARED = faceType;
            $VALUES = new FaceType[]{LIVE, IDCARD, WATERMARK, CERT, faceType};
        }

        public FaceType(String str, int i2) {
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

        public static FaceType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (FaceType) Enum.valueOf(FaceType.class, str) : (FaceType) invokeL.objValue;
        }

        public static FaceType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (FaceType[]) $VALUES.clone() : (FaceType[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class ImageType {
        public static final /* synthetic */ ImageType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final ImageType BASE64;
        public static final ImageType FACE_TOKEN;
        public static final ImageType URL;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-406749842, "Lcom/baidu/sofire/ac/FaceEnum$ImageType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-406749842, "Lcom/baidu/sofire/ac/FaceEnum$ImageType;");
                    return;
                }
            }
            BASE64 = new ImageType("BASE64", 0);
            URL = new ImageType("URL", 1);
            ImageType imageType = new ImageType("FACE_TOKEN", 2);
            FACE_TOKEN = imageType;
            $VALUES = new ImageType[]{BASE64, URL, imageType};
        }

        public ImageType(String str, int i2) {
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

        public static ImageType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ImageType) Enum.valueOf(ImageType.class, str) : (ImageType) invokeL.objValue;
        }

        public static ImageType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ImageType[]) $VALUES.clone() : (ImageType[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class LivenessControl {
        public static final /* synthetic */ LivenessControl[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final LivenessControl HIGH;
        public static final LivenessControl LOW;
        public static final LivenessControl NONE;
        public static final LivenessControl NORMAL;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1090340009, "Lcom/baidu/sofire/ac/FaceEnum$LivenessControl;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1090340009, "Lcom/baidu/sofire/ac/FaceEnum$LivenessControl;");
                    return;
                }
            }
            NONE = new LivenessControl("NONE", 0);
            LOW = new LivenessControl("LOW", 1);
            NORMAL = new LivenessControl("NORMAL", 2);
            LivenessControl livenessControl = new LivenessControl("HIGH", 3);
            HIGH = livenessControl;
            $VALUES = new LivenessControl[]{NONE, LOW, NORMAL, livenessControl};
        }

        public LivenessControl(String str, int i2) {
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

        public static LivenessControl valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (LivenessControl) Enum.valueOf(LivenessControl.class, str) : (LivenessControl) invokeL.objValue;
        }

        public static LivenessControl[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (LivenessControl[]) $VALUES.clone() : (LivenessControl[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class QualityControl {
        public static final /* synthetic */ QualityControl[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final QualityControl HIGH;
        public static final QualityControl LOW;
        public static final QualityControl NONE;
        public static final QualityControl NORMAL;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-547013675, "Lcom/baidu/sofire/ac/FaceEnum$QualityControl;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-547013675, "Lcom/baidu/sofire/ac/FaceEnum$QualityControl;");
                    return;
                }
            }
            NONE = new QualityControl("NONE", 0);
            LOW = new QualityControl("LOW", 1);
            NORMAL = new QualityControl("NORMAL", 2);
            QualityControl qualityControl = new QualityControl("HIGH", 3);
            HIGH = qualityControl;
            $VALUES = new QualityControl[]{NONE, LOW, NORMAL, qualityControl};
        }

        public QualityControl(String str, int i2) {
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

        public static QualityControl valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (QualityControl) Enum.valueOf(QualityControl.class, str) : (QualityControl) invokeL.objValue;
        }

        public static QualityControl[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (QualityControl[]) $VALUES.clone() : (QualityControl[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class SpoofingControl {
        public static final /* synthetic */ SpoofingControl[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final SpoofingControl HIGH;
        public static final SpoofingControl LOW;
        public static final SpoofingControl NONE;
        public static final SpoofingControl NORMAL;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1651061151, "Lcom/baidu/sofire/ac/FaceEnum$SpoofingControl;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1651061151, "Lcom/baidu/sofire/ac/FaceEnum$SpoofingControl;");
                    return;
                }
            }
            NONE = new SpoofingControl("NONE", 0);
            LOW = new SpoofingControl("LOW", 1);
            NORMAL = new SpoofingControl("NORMAL", 2);
            SpoofingControl spoofingControl = new SpoofingControl("HIGH", 3);
            HIGH = spoofingControl;
            $VALUES = new SpoofingControl[]{NONE, LOW, NORMAL, spoofingControl};
        }

        public SpoofingControl(String str, int i2) {
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

        public static SpoofingControl valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (SpoofingControl) Enum.valueOf(SpoofingControl.class, str) : (SpoofingControl) invokeL.objValue;
        }

        public static SpoofingControl[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (SpoofingControl[]) $VALUES.clone() : (SpoofingControl[]) invokeV.objValue;
        }
    }

    public FaceEnum() {
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
