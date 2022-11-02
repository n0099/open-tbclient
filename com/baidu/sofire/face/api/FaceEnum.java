package com.baidu.sofire.face.api;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
/* loaded from: classes2.dex */
public class FaceEnum {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(319348566, "Lcom/baidu/sofire/face/api/FaceEnum$FaceType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(319348566, "Lcom/baidu/sofire/face/api/FaceEnum$FaceType;");
                    return;
                }
            }
            FaceType faceType = new FaceType("LIVE", 0);
            LIVE = faceType;
            FaceType faceType2 = new FaceType("IDCARD", 1);
            IDCARD = faceType2;
            FaceType faceType3 = new FaceType("WATERMARK", 2);
            WATERMARK = faceType3;
            FaceType faceType4 = new FaceType("CERT", 3);
            CERT = faceType4;
            FaceType faceType5 = new FaceType("INFRARED", 4);
            INFRARED = faceType5;
            $VALUES = new FaceType[]{faceType, faceType2, faceType3, faceType4, faceType5};
        }

        public FaceType(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (FaceType) Enum.valueOf(FaceType.class, str);
            }
            return (FaceType) invokeL.objValue;
        }

        public static FaceType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (FaceType[]) $VALUES.clone();
            }
            return (FaceType[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-752094604, "Lcom/baidu/sofire/face/api/FaceEnum$ImageType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-752094604, "Lcom/baidu/sofire/face/api/FaceEnum$ImageType;");
                    return;
                }
            }
            ImageType imageType = new ImageType("BASE64", 0);
            BASE64 = imageType;
            ImageType imageType2 = new ImageType("URL", 1);
            URL = imageType2;
            ImageType imageType3 = new ImageType("FACE_TOKEN", 2);
            FACE_TOKEN = imageType3;
            $VALUES = new ImageType[]{imageType, imageType2, imageType3};
        }

        public ImageType(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (ImageType) Enum.valueOf(ImageType.class, str);
            }
            return (ImageType) invokeL.objValue;
        }

        public static ImageType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (ImageType[]) $VALUES.clone();
            }
            return (ImageType[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-345940689, "Lcom/baidu/sofire/face/api/FaceEnum$LivenessControl;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-345940689, "Lcom/baidu/sofire/face/api/FaceEnum$LivenessControl;");
                    return;
                }
            }
            LivenessControl livenessControl = new LivenessControl(HlsPlaylistParser.METHOD_NONE, 0);
            NONE = livenessControl;
            LivenessControl livenessControl2 = new LivenessControl("LOW", 1);
            LOW = livenessControl2;
            LivenessControl livenessControl3 = new LivenessControl("NORMAL", 2);
            NORMAL = livenessControl3;
            LivenessControl livenessControl4 = new LivenessControl("HIGH", 3);
            HIGH = livenessControl4;
            $VALUES = new LivenessControl[]{livenessControl, livenessControl2, livenessControl3, livenessControl4};
        }

        public LivenessControl(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (LivenessControl) Enum.valueOf(LivenessControl.class, str);
            }
            return (LivenessControl) invokeL.objValue;
        }

        public static LivenessControl[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (LivenessControl[]) $VALUES.clone();
            }
            return (LivenessControl[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(930675343, "Lcom/baidu/sofire/face/api/FaceEnum$QualityControl;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(930675343, "Lcom/baidu/sofire/face/api/FaceEnum$QualityControl;");
                    return;
                }
            }
            QualityControl qualityControl = new QualityControl(HlsPlaylistParser.METHOD_NONE, 0);
            NONE = qualityControl;
            QualityControl qualityControl2 = new QualityControl("LOW", 1);
            LOW = qualityControl2;
            QualityControl qualityControl3 = new QualityControl("NORMAL", 2);
            NORMAL = qualityControl3;
            QualityControl qualityControl4 = new QualityControl("HIGH", 3);
            HIGH = qualityControl4;
            $VALUES = new QualityControl[]{qualityControl, qualityControl2, qualityControl3, qualityControl4};
        }

        public QualityControl(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (QualityControl) Enum.valueOf(QualityControl.class, str);
            }
            return (QualityControl) invokeL.objValue;
        }

        public static QualityControl[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (QualityControl[]) $VALUES.clone();
            }
            return (QualityControl[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(214780453, "Lcom/baidu/sofire/face/api/FaceEnum$SpoofingControl;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(214780453, "Lcom/baidu/sofire/face/api/FaceEnum$SpoofingControl;");
                    return;
                }
            }
            SpoofingControl spoofingControl = new SpoofingControl(HlsPlaylistParser.METHOD_NONE, 0);
            NONE = spoofingControl;
            SpoofingControl spoofingControl2 = new SpoofingControl("LOW", 1);
            LOW = spoofingControl2;
            SpoofingControl spoofingControl3 = new SpoofingControl("NORMAL", 2);
            NORMAL = spoofingControl3;
            SpoofingControl spoofingControl4 = new SpoofingControl("HIGH", 3);
            HIGH = spoofingControl4;
            $VALUES = new SpoofingControl[]{spoofingControl, spoofingControl2, spoofingControl3, spoofingControl4};
        }

        public SpoofingControl(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (SpoofingControl) Enum.valueOf(SpoofingControl.class, str);
            }
            return (SpoofingControl) invokeL.objValue;
        }

        public static SpoofingControl[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (SpoofingControl[]) $VALUES.clone();
            }
            return (SpoofingControl[]) invokeV.objValue;
        }
    }

    public FaceEnum() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
