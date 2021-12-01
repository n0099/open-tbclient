package androidx.core.view;

import android.annotation.SuppressLint;
import android.app.UiModeManager;
import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.text.TextUtils;
import android.view.Display;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.util.Preconditions;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class DisplayCompat {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DISPLAY_SIZE_4K_HEIGHT = 2160;
    public static final int DISPLAY_SIZE_4K_WIDTH = 3840;
    public transient /* synthetic */ FieldHolder $fh;

    public DisplayCompat() {
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

    public static Point getPhysicalDisplaySize(@NonNull Context context, @NonNull Display display) {
        InterceptResult invokeLL;
        Point parsePhysicalDisplaySizeFromSystemProperties;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, display)) == null) {
            if (Build.VERSION.SDK_INT < 28) {
                parsePhysicalDisplaySizeFromSystemProperties = parsePhysicalDisplaySizeFromSystemProperties("sys.display-size", display);
            } else {
                parsePhysicalDisplaySizeFromSystemProperties = parsePhysicalDisplaySizeFromSystemProperties("vendor.display-size", display);
            }
            if (parsePhysicalDisplaySizeFromSystemProperties != null) {
                return parsePhysicalDisplaySizeFromSystemProperties;
            }
            if (isSonyBravia4kTv(context)) {
                return new Point(3840, DISPLAY_SIZE_4K_HEIGHT);
            }
            Point point = new Point();
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 23) {
                Display.Mode mode = display.getMode();
                point.x = mode.getPhysicalWidth();
                point.y = mode.getPhysicalHeight();
            } else if (i2 >= 17) {
                display.getRealSize(point);
            } else {
                display.getSize(point);
            }
            return point;
        }
        return (Point) invokeLL.objValue;
    }

    @NonNull
    @SuppressLint({"ArrayReturn"})
    public static ModeCompat[] getSupportedModes(@NonNull Context context, @NonNull Display display) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, display)) == null) {
            Point physicalDisplaySize = getPhysicalDisplaySize(context, display);
            if (Build.VERSION.SDK_INT >= 23) {
                Display.Mode[] supportedModes = display.getSupportedModes();
                ArrayList arrayList = new ArrayList(supportedModes.length);
                boolean z = false;
                for (int i2 = 0; i2 < supportedModes.length; i2++) {
                    if (physicalSizeEquals(supportedModes[i2], physicalDisplaySize)) {
                        arrayList.add(i2, new ModeCompat(supportedModes[i2], true));
                        z = true;
                    } else {
                        arrayList.add(i2, new ModeCompat(supportedModes[i2], false));
                    }
                }
                if (!z) {
                    arrayList.add(new ModeCompat(physicalDisplaySize));
                }
                return (ModeCompat[]) arrayList.toArray(new ModeCompat[0]);
            }
            return new ModeCompat[]{new ModeCompat(physicalDisplaySize)};
        }
        return (ModeCompat[]) invokeLL.objValue;
    }

    @Nullable
    public static String getSystemProperty(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                return (String) cls.getMethod("get", String.class).invoke(cls, str);
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static boolean isSonyBravia4kTv(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) ? isTv(context) && "Sony".equals(Build.MANUFACTURER) && Build.MODEL.startsWith("BRAVIA") && context.getPackageManager().hasSystemFeature("com.sony.dtv.hardware.panel.qfhd") : invokeL.booleanValue;
    }

    public static boolean isTv(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            UiModeManager uiModeManager = (UiModeManager) context.getSystemService("uimode");
            return uiModeManager != null && uiModeManager.getCurrentModeType() == 4;
        }
        return invokeL.booleanValue;
    }

    public static Point parseDisplaySize(@NonNull String str) throws NumberFormatException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            String[] split = str.trim().split("x", -1);
            if (split.length == 2) {
                int parseInt = Integer.parseInt(split[0]);
                int parseInt2 = Integer.parseInt(split[1]);
                if (parseInt > 0 && parseInt2 > 0) {
                    return new Point(parseInt, parseInt2);
                }
            }
            throw new NumberFormatException();
        }
        return (Point) invokeL.objValue;
    }

    @Nullable
    public static Point parsePhysicalDisplaySizeFromSystemProperties(@NonNull String str, @NonNull Display display) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, str, display)) == null) {
            if (display.getDisplayId() == 0) {
                String systemProperty = getSystemProperty(str);
                if (TextUtils.isEmpty(systemProperty)) {
                    return null;
                }
                try {
                    return parseDisplaySize(systemProperty);
                } catch (NumberFormatException unused) {
                    return null;
                }
            }
            return null;
        }
        return (Point) invokeLL.objValue;
    }

    @RequiresApi(23)
    public static boolean physicalSizeEquals(Display.Mode mode, Point point) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, mode, point)) == null) ? (mode.getPhysicalWidth() == point.x && mode.getPhysicalHeight() == point.y) || (mode.getPhysicalWidth() == point.y && mode.getPhysicalHeight() == point.x) : invokeLL.booleanValue;
    }

    /* loaded from: classes.dex */
    public static final class ModeCompat {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final boolean mIsNative;
        public final Display.Mode mMode;
        public final Point mPhysicalDisplaySize;

        public ModeCompat(@NonNull Point point) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {point};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Preconditions.checkNotNull(point, "physicalDisplaySize == null");
            this.mIsNative = true;
            this.mPhysicalDisplaySize = point;
            this.mMode = null;
        }

        public int getPhysicalHeight() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mPhysicalDisplaySize.y : invokeV.intValue;
        }

        public int getPhysicalWidth() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mPhysicalDisplaySize.x : invokeV.intValue;
        }

        public boolean isNative() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mIsNative : invokeV.booleanValue;
        }

        @Nullable
        @RequiresApi(23)
        public Display.Mode toMode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mMode : (Display.Mode) invokeV.objValue;
        }

        @RequiresApi(23)
        public ModeCompat(@NonNull Display.Mode mode, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mode, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            Preconditions.checkNotNull(mode, "Display.Mode == null, can't wrap a null reference");
            this.mIsNative = z;
            this.mPhysicalDisplaySize = new Point(mode.getPhysicalWidth(), mode.getPhysicalHeight());
            this.mMode = mode;
        }
    }
}
