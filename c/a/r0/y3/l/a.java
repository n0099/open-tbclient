package c.a.r0.y3.l;

import android.app.Activity;
import android.content.pm.FeatureInfo;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.r0.y3.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class C1368a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public static class b implements Comparator<Camera.Size> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(Camera.Size size, Camera.Size size2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, size, size2)) == null) {
                int i2 = size.width;
                int i3 = size2.width;
                return i2 != i3 ? i2 - i3 : size.height - size2.height;
            }
            return invokeLL.intValue;
        }

        public /* synthetic */ b(C1368a c1368a) {
            this();
        }
    }

    public static int a(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIII = interceptable.invokeIII(65536, null, i2, i3, i4)) == null) ? i2 > i4 ? i4 : i2 < i3 ? i3 : i2 : invokeIII.intValue;
    }

    public static int b(Activity activity, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, activity, i2)) == null) {
            if (Build.VERSION.SDK_INT > 8) {
                Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                Camera.getCameraInfo(i2, cameraInfo);
                int e2 = e(activity);
                if (cameraInfo.facing == 1) {
                    return (360 - ((cameraInfo.orientation + e2) % 360)) % 360;
                }
                return ((cameraInfo.orientation - e2) + 360) % 360;
            }
            return 0;
        }
        return invokeLI.intValue;
    }

    public static int c(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65538, null, z)) == null) {
            int numberOfCameras = Camera.getNumberOfCameras();
            Camera.CameraInfo[] cameraInfoArr = new Camera.CameraInfo[numberOfCameras];
            for (int i2 = 0; i2 < numberOfCameras; i2++) {
                cameraInfoArr[i2] = new Camera.CameraInfo();
                Camera.getCameraInfo(i2, cameraInfoArr[i2]);
            }
            int i3 = -1;
            int i4 = -1;
            for (int i5 = 0; i5 < numberOfCameras; i5++) {
                if (i4 == -1 && cameraInfoArr[i5].facing == 0) {
                    i4 = i5;
                } else if (i3 == -1 && cameraInfoArr[i5].facing == 1) {
                    i3 = i5;
                }
            }
            if (i3 == -1 || !z) {
                if (i4 == -1 || z) {
                    if (z && i3 == -1) {
                        return i4;
                    }
                    if (i3 != -1) {
                        return i3;
                    }
                    if (i4 != -1) {
                        return i4;
                    }
                    return -1;
                }
                return i4;
            }
            return i3;
        }
        return invokeZ.intValue;
    }

    public static Camera.Size d(Camera camera, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65539, null, camera, i2, i3)) == null) {
            List<Camera.Size> supportedPreviewSizes = camera.getParameters().getSupportedPreviewSizes();
            Camera.Size size = null;
            Collections.sort(supportedPreviewSizes, new b(null));
            if (supportedPreviewSizes != null && supportedPreviewSizes.size() > 0) {
                boolean z = false;
                Iterator<Camera.Size> it = supportedPreviewSizes.iterator();
                int i4 = -1;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Camera.Size next = it.next();
                    i4++;
                    if (next != null && next.width >= i3 && next.height >= i2) {
                        size = next;
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    i4 = supportedPreviewSizes.size() - 1;
                    size = supportedPreviewSizes.get(i4);
                }
                int i5 = ((int) (1080 * ((i3 * 1.0f) / i2))) * 1080;
                while (size.width * size.height > i5 && i4 > 0) {
                    i4--;
                    size = supportedPreviewSizes.get(i4);
                }
            }
            return size;
        }
        return (Camera.Size) invokeLII.objValue;
    }

    public static int e(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, activity)) == null) {
            int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
            if (rotation != 0) {
                if (rotation != 1) {
                    if (rotation != 2) {
                        return rotation != 3 ? 0 : 270;
                    }
                    return 180;
                }
                return 90;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static boolean f(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(AdIconUtil.AD_TEXT_ID, null, z)) == null) {
            int numberOfCameras = Camera.getNumberOfCameras();
            Camera.CameraInfo[] cameraInfoArr = new Camera.CameraInfo[numberOfCameras];
            for (int i2 = 0; i2 < numberOfCameras; i2++) {
                cameraInfoArr[i2] = new Camera.CameraInfo();
                Camera.getCameraInfo(i2, cameraInfoArr[i2]);
            }
            int i3 = -1;
            int i4 = -1;
            for (int i5 = 0; i5 < numberOfCameras; i5++) {
                if (i4 == -1 && cameraInfoArr[i5].facing == 0) {
                    i4 = i5;
                } else if (i3 == -1 && cameraInfoArr[i5].facing == 1) {
                    i3 = i5;
                }
            }
            if (i3 == -1 || !z) {
                return (i4 == -1 || z) ? false : true;
            }
            return true;
        }
        return invokeZ.booleanValue;
    }

    public static boolean g(PackageManager packageManager) {
        InterceptResult invokeL;
        FeatureInfo[] systemAvailableFeatures;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, packageManager)) == null) {
            if (packageManager != null && (systemAvailableFeatures = packageManager.getSystemAvailableFeatures()) != null) {
                for (FeatureInfo featureInfo : systemAvailableFeatures) {
                    if (featureInfo != null && "android.hardware.camera.flash".equals(featureInfo.name)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
