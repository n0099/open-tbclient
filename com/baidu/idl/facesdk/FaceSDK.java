package com.baidu.idl.facesdk;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.os.Environment;
import com.baidu.idl.authority.AlgorithmOnMainThreadException;
import com.baidu.idl.authority.IDLAuthorityException;
import com.baidu.idl.license.License;
import com.baidu.idl.statistics.Statistics;
import com.baidu.idl.util.UIThread;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.executor.RuntimeCompat;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class FaceSDK {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "FaceSDK";
    public static final String VERSION = "3.0.3.0";
    public static String cdnn_alignmean_path = "";
    public static String cdnn_alignmodel_path = "align_model.binary";
    public static String cdnn_parsingmodel_path1 = "3_class_model";
    public static String cdnn_parsingmodel_path2 = "7_class_model";
    public static String cdnn_parsingparam_path1 = "";
    public static String cdnn_parsingparam_path2 = "";
    public static String mApiKey = null;
    public static int mAuthorityStatus = 256;
    public static FaceSDK mInstance = null;
    public static String sdm_15pts_model_path = "15pts.bin";
    public static String sdm_7pts_model_path = "7pts.bin";
    public static String sdm_alignmodel_path = "facialLandmarksModel2.bin";
    public static final String tag = "FaceSDK";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class AlignMethodType {
        public static final /* synthetic */ AlignMethodType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final AlignMethodType CDNN;
        public static final AlignMethodType SDM;
        public static final AlignMethodType SDM_15PTS;
        public static final AlignMethodType SDM_7PTS;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(938685888, "Lcom/baidu/idl/facesdk/FaceSDK$AlignMethodType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(938685888, "Lcom/baidu/idl/facesdk/FaceSDK$AlignMethodType;");
                    return;
                }
            }
            SDM = new AlignMethodType("SDM", 0);
            CDNN = new AlignMethodType("CDNN", 1);
            SDM_7PTS = new AlignMethodType("SDM_7PTS", 2);
            AlignMethodType alignMethodType = new AlignMethodType("SDM_15PTS", 3);
            SDM_15PTS = alignMethodType;
            $VALUES = new AlignMethodType[]{SDM, CDNN, SDM_7PTS, alignMethodType};
        }

        public AlignMethodType(String str, int i2) {
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

        public static AlignMethodType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (AlignMethodType) Enum.valueOf(AlignMethodType.class, str) : (AlignMethodType) invokeL.objValue;
        }

        public static AlignMethodType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (AlignMethodType[]) $VALUES.clone() : (AlignMethodType[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class DetectMethodType {
        public static final /* synthetic */ DetectMethodType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final DetectMethodType BOOST;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-938442824, "Lcom/baidu/idl/facesdk/FaceSDK$DetectMethodType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-938442824, "Lcom/baidu/idl/facesdk/FaceSDK$DetectMethodType;");
                    return;
                }
            }
            DetectMethodType detectMethodType = new DetectMethodType("BOOST", 0);
            BOOST = detectMethodType;
            $VALUES = new DetectMethodType[]{detectMethodType};
        }

        public DetectMethodType(String str, int i2) {
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

        public static DetectMethodType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (DetectMethodType) Enum.valueOf(DetectMethodType.class, str) : (DetectMethodType) invokeL.objValue;
        }

        public static DetectMethodType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (DetectMethodType[]) $VALUES.clone() : (DetectMethodType[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class ImgType {
        public static final /* synthetic */ ImgType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final ImgType ARGB;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-929729181, "Lcom/baidu/idl/facesdk/FaceSDK$ImgType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-929729181, "Lcom/baidu/idl/facesdk/FaceSDK$ImgType;");
                    return;
                }
            }
            ImgType imgType = new ImgType("ARGB", 0);
            ARGB = imgType;
            $VALUES = new ImgType[]{imgType};
        }

        public ImgType(String str, int i2) {
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

        public static ImgType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ImgType) Enum.valueOf(ImgType.class, str) : (ImgType) invokeL.objValue;
        }

        public static ImgType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ImgType[]) $VALUES.clone() : (ImgType[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class LivenessAction {
        public static final /* synthetic */ LivenessAction[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final LivenessAction ADD_ONE_FRAME;
        public static final LivenessAction RESET;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2079519549, "Lcom/baidu/idl/facesdk/FaceSDK$LivenessAction;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2079519549, "Lcom/baidu/idl/facesdk/FaceSDK$LivenessAction;");
                    return;
                }
            }
            RESET = new LivenessAction("RESET", 0);
            LivenessAction livenessAction = new LivenessAction("ADD_ONE_FRAME", 1);
            ADD_ONE_FRAME = livenessAction;
            $VALUES = new LivenessAction[]{RESET, livenessAction};
        }

        public LivenessAction(String str, int i2) {
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

        public static LivenessAction valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (LivenessAction) Enum.valueOf(LivenessAction.class, str) : (LivenessAction) invokeL.objValue;
        }

        public static LivenessAction[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (LivenessAction[]) $VALUES.clone() : (LivenessAction[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class LivenessMethodType {
        public static final /* synthetic */ LivenessMethodType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final LivenessMethodType ALL;
        public static final LivenessMethodType EYE_BLINK;
        public static final LivenessMethodType HEAD_POSE;
        public static final LivenessMethodType MOUTH_MOTION;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(42969688, "Lcom/baidu/idl/facesdk/FaceSDK$LivenessMethodType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(42969688, "Lcom/baidu/idl/facesdk/FaceSDK$LivenessMethodType;");
                    return;
                }
            }
            EYE_BLINK = new LivenessMethodType("EYE_BLINK", 0);
            MOUTH_MOTION = new LivenessMethodType("MOUTH_MOTION", 1);
            HEAD_POSE = new LivenessMethodType("HEAD_POSE", 2);
            LivenessMethodType livenessMethodType = new LivenessMethodType("ALL", 3);
            ALL = livenessMethodType;
            $VALUES = new LivenessMethodType[]{EYE_BLINK, MOUTH_MOTION, HEAD_POSE, livenessMethodType};
        }

        public LivenessMethodType(String str, int i2) {
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

        public static LivenessMethodType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (LivenessMethodType) Enum.valueOf(LivenessMethodType.class, str) : (LivenessMethodType) invokeL.objValue;
        }

        public static LivenessMethodType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (LivenessMethodType[]) $VALUES.clone() : (LivenessMethodType[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class ParsMethodType {
        public static final /* synthetic */ ParsMethodType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final ParsMethodType CLASS_NUM_10;
        public static final ParsMethodType CLASS_NUM_3;
        public static final ParsMethodType CLASS_NUM_7;
        public static final ParsMethodType NOT_USE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-208564791, "Lcom/baidu/idl/facesdk/FaceSDK$ParsMethodType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-208564791, "Lcom/baidu/idl/facesdk/FaceSDK$ParsMethodType;");
                    return;
                }
            }
            NOT_USE = new ParsMethodType("NOT_USE", 0);
            CLASS_NUM_3 = new ParsMethodType("CLASS_NUM_3", 1);
            CLASS_NUM_7 = new ParsMethodType("CLASS_NUM_7", 2);
            ParsMethodType parsMethodType = new ParsMethodType("CLASS_NUM_10", 3);
            CLASS_NUM_10 = parsMethodType;
            $VALUES = new ParsMethodType[]{NOT_USE, CLASS_NUM_3, CLASS_NUM_7, parsMethodType};
        }

        public ParsMethodType(String str, int i2) {
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

        public static ParsMethodType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ParsMethodType) Enum.valueOf(ParsMethodType.class, str) : (ParsMethodType) invokeL.objValue;
        }

        public static ParsMethodType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ParsMethodType[]) $VALUES.clone() : (ParsMethodType[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-447040484, "Lcom/baidu/idl/facesdk/FaceSDK;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-447040484, "Lcom/baidu/idl/facesdk/FaceSDK;");
        }
    }

    public FaceSDK() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static native int AlignModelInit(AssetManager assetManager, String str, String str2, int i2);

    public static native int CropFaceImg(int[] iArr, int i2, int i3, int i4, int[] iArr2, int i5, int i6, int i7, int[] iArr3, int[] iArr4);

    @Deprecated
    public static boolean copyFileFromAssets(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLL = interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, null, context, str, str2)) != null) {
            return invokeLLL.booleanValue;
        }
        try {
            InputStream open = context.getAssets().open(str);
            File file = new File(str2);
            file.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = open.read(bArr);
                if (read > 0) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileOutputStream.close();
                    open.close();
                    return true;
                }
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static native int getARGBFromYUV420img(byte[] bArr, int[] iArr, int i2, int i3);

    public static native int getARGBFromYUVimg(byte[] bArr, int[] iArr, int i2, int i3, int i4, int i5);

    public static synchronized void getInstance(AssetManager assetManager, Context context, String str, String str2, String str3, AlignMethodType alignMethodType, ParsMethodType parsMethodType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{assetManager, context, str, str2, str3, alignMethodType, parsMethodType}) == null) {
            synchronized (FaceSDK.class) {
                if (mAuthorityStatus > 48) {
                    new Thread(new Runnable(str2, context, str, str3) { // from class: com.baidu.idl.facesdk.FaceSDK.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ String val$apiKey;
                        public final /* synthetic */ Context val$context;
                        public final /* synthetic */ String val$licenseFileName;
                        public final /* synthetic */ String val$token;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {str2, context, str, str3};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.val$token = str2;
                            this.val$context = context;
                            this.val$apiKey = str;
                            this.val$licenseFileName = str3;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                try {
                                    if (this.val$token == null || this.val$token.length() <= 0) {
                                        FaceSDK.initLicense(this.val$context, this.val$apiKey, this.val$licenseFileName);
                                    } else {
                                        FaceSDK.init(this.val$context, this.val$apiKey, this.val$token);
                                    }
                                } catch (AlgorithmOnMainThreadException e2) {
                                    e2.printStackTrace();
                                } catch (IDLAuthorityException e3) {
                                    e3.printStackTrace();
                                }
                            }
                        }
                    }).start();
                }
                if (mInstance == null) {
                    mInstance = new FaceSDK();
                }
                if (alignMethodType == AlignMethodType.SDM) {
                    AlignModelInit(assetManager, sdm_alignmodel_path, "", AlignMethodType.SDM.ordinal());
                } else if (alignMethodType == AlignMethodType.CDNN) {
                    AlignModelInit(assetManager, cdnn_alignmodel_path, cdnn_alignmean_path, AlignMethodType.CDNN.ordinal());
                } else if (alignMethodType == AlignMethodType.SDM_7PTS) {
                    AlignModelInit(assetManager, sdm_7pts_model_path, "", AlignMethodType.SDM_7PTS.ordinal());
                } else if (alignMethodType == AlignMethodType.SDM_15PTS) {
                    AlignModelInit(assetManager, sdm_15pts_model_path, "", AlignMethodType.SDM_15PTS.ordinal());
                }
                int numCores = getNumCores();
                setNumberOfThreads(numCores > 1 ? numCores / 2 : 1);
            }
        }
    }

    @Deprecated
    public static int getNumCores() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            try {
                return new File("/sys/devices/system/cpu/").listFiles(new FileFilter() { // from class: com.baidu.idl.facesdk.FaceSDK.1CpuFilter
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                            }
                        }
                    }

                    @Override // java.io.FileFilter
                    public boolean accept(File file) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, file)) == null) ? Pattern.matches(RuntimeCompat.CPU_NAME_REGEX, file.getName()) : invokeL.booleanValue;
                    }
                }).length;
            } catch (Exception unused) {
                return 1;
            }
        }
        return invokeV.intValue;
    }

    public static String getVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? VERSION : (String) invokeV.objValue;
    }

    @Deprecated
    public static synchronized int init(Context context, String str) throws AlgorithmOnMainThreadException, IDLAuthorityException {
        InterceptResult invokeLL;
        int init;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, context, str)) == null) {
            synchronized (FaceSDK.class) {
                if (!UIThread.isUITread()) {
                    mApiKey = str;
                    Statistics.getInstance().init(context.getApplicationContext(), str);
                    init = License.getInstance().init(context, mApiKey);
                    mAuthorityStatus = init;
                } else {
                    throw new AlgorithmOnMainThreadException();
                }
            }
            return init;
        }
        return invokeLL.intValue;
    }

    public static synchronized int initLicense(Context context, String str, String str2) throws AlgorithmOnMainThreadException, IDLAuthorityException {
        InterceptResult invokeLLL;
        int init;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65549, null, context, str, str2)) == null) {
            synchronized (FaceSDK.class) {
                if (!UIThread.isUITread()) {
                    mApiKey = str;
                    init = License.getInstance().init(context, mApiKey, str2);
                    mAuthorityStatus = init;
                } else {
                    throw new AlgorithmOnMainThreadException();
                }
            }
            return init;
        }
        return invokeLLL.intValue;
    }

    public static boolean isAuthoritySucceeded() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? mAuthorityStatus < 48 : invokeV.booleanValue;
    }

    @Deprecated
    public static void savePic(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, null, bitmap) == null) {
            try {
                File externalStorageDirectory = Environment.getExternalStorageDirectory();
                File file = new File(externalStorageDirectory.getAbsolutePath() + "/awe/");
                file.mkdirs();
                File file2 = new File(file, String.format("%d.png", Long.valueOf(System.currentTimeMillis())));
                if (file2.exists()) {
                    file2.delete();
                }
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        }
    }

    public static native int setBaseInfoValueLogFlag(int i2);

    public static native int setLivenessValueLogFlag(int i2);

    public static native int setNumberOfThreads(int i2);

    public static native int setPerfLogFlag(int i2);

    public static native int setQualityValueLogFlag(int i2);

    public static native int setValueLogFlag(int i2);

    @Deprecated
    public static synchronized int init(Context context, String str, String str2) throws AlgorithmOnMainThreadException, IDLAuthorityException {
        InterceptResult invokeLLL;
        int init;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65548, null, context, str, str2)) == null) {
            synchronized (FaceSDK.class) {
                if (!UIThread.isUITread()) {
                    mApiKey = str;
                    Statistics.getInstance().init(context.getApplicationContext(), str);
                    init = License.getInstance().init(str2);
                    mAuthorityStatus = init;
                } else {
                    throw new AlgorithmOnMainThreadException();
                }
            }
            return init;
        }
        return invokeLLL.intValue;
    }
}
