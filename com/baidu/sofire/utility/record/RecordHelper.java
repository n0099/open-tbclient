package com.baidu.sofire.utility.record;

import android.content.Context;
import android.hardware.Camera;
import android.view.Display;
import android.view.WindowManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.sofire.utility.CommonMethods;
import com.baidu.sofire.utility.camera.CameraPreviewUtils;
import com.baidu.sofire.utility.record.MediaRecordManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class RecordHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_PREVIEW_HEIGHT = 480;
    public static final int DEFAULT_PREVIEW_WIDTH = 640;
    public transient /* synthetic */ FieldHolder $fh;

    public RecordHelper() {
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

    public static MediaRecordManager.CameraSize getBestVideoSizeMatchPreviewSize(Camera.Parameters parameters, MediaRecordManager.CameraSize cameraSize) {
        InterceptResult invokeLL;
        List<Camera.Size> list;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, parameters, cameraSize)) == null) {
            List<Camera.Size> supportedVideoSizes = parameters.getSupportedVideoSizes();
            List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
            if (supportedVideoSizes == null || supportedVideoSizes.size() == 0 || supportedPreviewSizes == null || supportedPreviewSizes.size() == 0) {
                return cameraSize;
            }
            float f = cameraSize.height / cameraSize.width;
            MediaRecordManager.CameraSize cameraSize2 = new MediaRecordManager.CameraSize(0, 0);
            MediaRecordManager.CameraSize cameraSize3 = new MediaRecordManager.CameraSize(0, 0);
            MediaRecordManager.CameraSize cameraSize4 = new MediaRecordManager.CameraSize(0, 0);
            MediaRecordManager.CameraSize cameraSize5 = new MediaRecordManager.CameraSize(0, 0);
            MediaRecordManager.CameraSize cameraSize6 = new MediaRecordManager.CameraSize(0, 0);
            MediaRecordManager.CameraSize cameraSize7 = new MediaRecordManager.CameraSize(0, 0);
            int i3 = 0;
            while (i3 < supportedVideoSizes.size()) {
                Camera.Size size = supportedVideoSizes.get(i3);
                int i4 = size.width;
                cameraSize3.width = i4;
                int i5 = size.height;
                cameraSize3.height = i5;
                if (i4 == cameraSize.width && i5 == cameraSize.height) {
                    cameraSize2.width = i4;
                    cameraSize2.height = i5;
                    return cameraSize2;
                }
                float f2 = 0.01f;
                if (Math.abs((size.height / size.width) - f) < 0.01f && (i = cameraSize3.width) >= cameraSize2.width && (i2 = cameraSize3.height) >= cameraSize2.height && i * i2 <= 921600) {
                    cameraSize2.width = i;
                    cameraSize2.height = i2;
                }
                int i6 = 0;
                while (i6 < supportedPreviewSizes.size()) {
                    Camera.Size size2 = supportedPreviewSizes.get(i6);
                    int i7 = size2.width;
                    cameraSize4.width = i7;
                    int i8 = size2.height;
                    cameraSize4.height = i8;
                    if (!(cameraSize3.width == i7 && cameraSize3.height == i8) && Math.abs((cameraSize4.height / cameraSize4.width) - (cameraSize3.height / cameraSize3.width)) >= f2) {
                        list = supportedVideoSizes;
                    } else {
                        int i9 = cameraSize3.width;
                        int i10 = cameraSize3.height;
                        list = supportedVideoSizes;
                        if (i9 * i10 >= cameraSize5.width * cameraSize5.height && i9 * i10 <= 921600) {
                            cameraSize5.width = i9;
                            cameraSize5.height = i10;
                            cameraSize6.height = cameraSize4.height;
                            cameraSize6.width = cameraSize4.width;
                        }
                    }
                    i6++;
                    supportedVideoSizes = list;
                    f2 = 0.01f;
                }
                List<Camera.Size> list2 = supportedVideoSizes;
                int i11 = cameraSize3.width;
                int i12 = cameraSize3.height;
                if (i11 * i12 >= cameraSize7.width * cameraSize7.height && i11 * i12 <= 921600) {
                    cameraSize7.width = i11;
                    cameraSize7.height = i12;
                }
                i3++;
                supportedVideoSizes = list2;
            }
            return cameraSize2.width > 0 ? cameraSize2 : cameraSize5.width > 0 ? cameraSize5 : cameraSize7;
        }
        return (MediaRecordManager.CameraSize) invokeLL.objValue;
    }

    public static MediaRecordManager.CameraSize getMinMatchPreviewSize(Context context, Camera.Parameters parameters) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, parameters)) == null) {
            List<MediaRecordManager.CameraSize> supportedPreviewSizes = getSupportedPreviewSizes(context, parameters);
            MediaRecordManager.CameraSize cameraSize = new MediaRecordManager.CameraSize(640, 480);
            if (supportedPreviewSizes != null && supportedPreviewSizes.size() != 0) {
                Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
                MediaRecordManager.CameraSize cameraSize2 = new MediaRecordManager.CameraSize(defaultDisplay.getWidth(), defaultDisplay.getHeight());
                float f = cameraSize2.height / cameraSize2.width;
                float f2 = cameraSize.width / cameraSize.height;
                for (int i = 0; i < supportedPreviewSizes.size(); i++) {
                    MediaRecordManager.CameraSize cameraSize3 = supportedPreviewSizes.get(i);
                    float abs = Math.abs((cameraSize3.width / cameraSize3.height) - f);
                    if (abs < f2) {
                        cameraSize = cameraSize3;
                        f2 = abs;
                    }
                }
            }
            return cameraSize;
        }
        return (MediaRecordManager.CameraSize) invokeLL.objValue;
    }

    public static File getOutputMediaFile(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, str)) == null) {
            File file = new File(str, ".records");
            if (file.exists() || file.mkdirs()) {
                String valueOf = String.valueOf(System.currentTimeMillis());
                return new File(file.getPath() + File.separator + "bdv_" + valueOf + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION);
            }
            return null;
        }
        return (File) invokeLL.objValue;
    }

    public static List<MediaRecordManager.CameraSize> getSupportedPreviewSizes(Context context, Camera.Parameters parameters) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, parameters)) == null) {
            List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
            if (supportedPreviewSizes == null || supportedPreviewSizes.size() == 0) {
                return null;
            }
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            MediaRecordManager.CameraSize cameraSize = new MediaRecordManager.CameraSize(defaultDisplay.getWidth(), defaultDisplay.getHeight());
            int i = 153600;
            int i2 = cameraSize.width;
            int i3 = cameraSize.height;
            int i4 = 921600;
            if ((i2 * i3) / 4 > 921600) {
                i4 = CameraPreviewUtils.MAX_PREVIEW_PIXELS;
                i = (i2 * i3) / 8;
            }
            ArrayList arrayList = new ArrayList();
            for (int i5 = 0; i5 < supportedPreviewSizes.size(); i5++) {
                Camera.Size size = supportedPreviewSizes.get(i5);
                int i6 = size.width;
                int i7 = size.height;
                if (i6 * i7 >= i && i6 * i7 <= i4) {
                    arrayList.add(new MediaRecordManager.CameraSize(i6, i7));
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static boolean hasEnoughSpace(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
            return file.getFreeSpace() >= 100;
        }
        return invokeL.booleanValue;
    }

    public static byte[] toByteArray(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65542, null, file)) != null) {
            return (byte[]) invokeL.objValue;
        }
        BufferedInputStream bufferedInputStream = null;
        if (!file.exists()) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((int) file.length());
        try {
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = bufferedInputStream2.read(bArr, 0, 1024);
                    if (-1 == read) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                try {
                    bufferedInputStream2.close();
                } catch (IOException e) {
                    CommonMethods.handleNuLException(e);
                }
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e2) {
                    CommonMethods.handleNuLException(e2);
                }
                return byteArray;
            } catch (Throwable th) {
                th = th;
                bufferedInputStream = bufferedInputStream2;
                try {
                    CommonMethods.handleNuLException(th);
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e3) {
                            CommonMethods.handleNuLException(e3);
                        }
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e4) {
                        CommonMethods.handleNuLException(e4);
                    }
                    return new byte[0];
                } catch (Throwable th2) {
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e5) {
                            CommonMethods.handleNuLException(e5);
                        }
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e6) {
                        CommonMethods.handleNuLException(e6);
                    }
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
