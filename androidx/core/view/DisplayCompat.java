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
/* loaded from: classes.dex */
public final class DisplayCompat {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DISPLAY_SIZE_4K_HEIGHT = 2160;
    public static final int DISPLAY_SIZE_4K_WIDTH = 3840;
    public transient /* synthetic */ FieldHolder $fh;

    @RequiresApi(17)
    /* loaded from: classes.dex */
    public static class Api17Impl {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Api17Impl() {
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

        public static void getRealSize(Display display, Point point) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, null, display, point) == null) {
                display.getRealSize(point);
            }
        }
    }

    @RequiresApi(23)
    /* loaded from: classes.dex */
    public static class Api23Impl {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Api23Impl() {
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

        @NonNull
        public static ModeCompat getMode(@NonNull Context context, @NonNull Display display) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, display)) == null) {
                Display.Mode mode = display.getMode();
                Point currentDisplaySizeFromWorkarounds = DisplayCompat.getCurrentDisplaySizeFromWorkarounds(context, display);
                if (currentDisplaySizeFromWorkarounds != null && !physicalSizeEquals(mode, currentDisplaySizeFromWorkarounds)) {
                    return new ModeCompat(mode, currentDisplaySizeFromWorkarounds);
                }
                return new ModeCompat(mode, true);
            }
            return (ModeCompat) invokeLL.objValue;
        }

        public static boolean physicalSizeEquals(Display.Mode mode, Point point) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, mode, point)) == null) {
                if ((mode.getPhysicalWidth() == point.x && mode.getPhysicalHeight() == point.y) || (mode.getPhysicalWidth() == point.y && mode.getPhysicalHeight() == point.x)) {
                    return true;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }

        @NonNull
        @SuppressLint({"ArrayReturn"})
        public static ModeCompat[] getSupportedModes(@NonNull Context context, @NonNull Display display) {
            InterceptResult invokeLL;
            ModeCompat modeCompat;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, display)) == null) {
                Display.Mode[] supportedModes = display.getSupportedModes();
                ModeCompat[] modeCompatArr = new ModeCompat[supportedModes.length];
                Display.Mode mode = display.getMode();
                Point currentDisplaySizeFromWorkarounds = DisplayCompat.getCurrentDisplaySizeFromWorkarounds(context, display);
                if (currentDisplaySizeFromWorkarounds != null && !physicalSizeEquals(mode, currentDisplaySizeFromWorkarounds)) {
                    for (int i = 0; i < supportedModes.length; i++) {
                        if (physicalSizeEquals(supportedModes[i], mode)) {
                            modeCompat = new ModeCompat(supportedModes[i], currentDisplaySizeFromWorkarounds);
                        } else {
                            modeCompat = new ModeCompat(supportedModes[i], false);
                        }
                        modeCompatArr[i] = modeCompat;
                    }
                } else {
                    for (int i2 = 0; i2 < supportedModes.length; i2++) {
                        modeCompatArr[i2] = new ModeCompat(supportedModes[i2], physicalSizeEquals(supportedModes[i2], mode));
                    }
                }
                return modeCompatArr;
            }
            return (ModeCompat[]) invokeLL.objValue;
        }

        public static boolean isCurrentModeTheLargestMode(@NonNull Display display) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, display)) == null) {
                Display.Mode mode = display.getMode();
                Display.Mode[] supportedModes = display.getSupportedModes();
                for (int i = 0; i < supportedModes.length; i++) {
                    if (mode.getPhysicalHeight() < supportedModes[i].getPhysicalHeight() || mode.getPhysicalWidth() < supportedModes[i].getPhysicalWidth()) {
                        return false;
                    }
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        public static boolean physicalSizeEquals(Display.Mode mode, Display.Mode mode2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, mode, mode2)) == null) {
                if (mode.getPhysicalWidth() == mode2.getPhysicalWidth() && mode.getPhysicalHeight() == mode2.getPhysicalHeight()) {
                    return true;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public static final class ModeCompat {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final boolean mIsNative;
        public final Display.Mode mMode;
        public final Point mPhysicalSize;

        public ModeCompat(@NonNull Point point) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {point};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Preconditions.checkNotNull(point, "physicalSize == null");
            this.mPhysicalSize = point;
            this.mMode = null;
            this.mIsNative = true;
        }

        @RequiresApi(23)
        public ModeCompat(@NonNull Display.Mode mode, @NonNull Point point) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mode, point};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            Preconditions.checkNotNull(mode, "mode == null, can't wrap a null reference");
            Preconditions.checkNotNull(point, "physicalSize == null");
            this.mPhysicalSize = point;
            this.mMode = mode;
            this.mIsNative = true;
        }

        @RequiresApi(23)
        public ModeCompat(@NonNull Display.Mode mode, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mode, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65538, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            Preconditions.checkNotNull(mode, "mode == null, can't wrap a null reference");
            this.mPhysicalSize = new Point(mode.getPhysicalWidth(), mode.getPhysicalHeight());
            this.mMode = mode;
            this.mIsNative = z;
        }

        public int getPhysicalHeight() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.mPhysicalSize.y;
            }
            return invokeV.intValue;
        }

        public int getPhysicalWidth() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.mPhysicalSize.x;
            }
            return invokeV.intValue;
        }

        @Deprecated
        public boolean isNative() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.mIsNative;
            }
            return invokeV.booleanValue;
        }

        @Nullable
        @RequiresApi(23)
        public Display.Mode toMode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.mMode;
            }
            return (Display.Mode) invokeV.objValue;
        }
    }

    public DisplayCompat() {
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

    public static Point getCurrentDisplaySizeFromWorkarounds(@NonNull Context context, @NonNull Display display) {
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
            if (!isSonyBravia4kTv(context) || !isCurrentModeTheLargestMode(display)) {
                return null;
            }
            return new Point(3840, DISPLAY_SIZE_4K_HEIGHT);
        }
        return (Point) invokeLL.objValue;
    }

    @NonNull
    public static Point getDisplaySize(@NonNull Context context, @NonNull Display display) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, display)) == null) {
            Point currentDisplaySizeFromWorkarounds = getCurrentDisplaySizeFromWorkarounds(context, display);
            if (currentDisplaySizeFromWorkarounds != null) {
                return currentDisplaySizeFromWorkarounds;
            }
            Point point = new Point();
            if (Build.VERSION.SDK_INT >= 17) {
                Api17Impl.getRealSize(display, point);
            } else {
                display.getSize(point);
            }
            return point;
        }
        return (Point) invokeLL.objValue;
    }

    @NonNull
    public static ModeCompat getMode(@NonNull Context context, @NonNull Display display) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, display)) == null) {
            if (Build.VERSION.SDK_INT >= 23) {
                return Api23Impl.getMode(context, display);
            }
            return new ModeCompat(getDisplaySize(context, display));
        }
        return (ModeCompat) invokeLL.objValue;
    }

    @NonNull
    @SuppressLint({"ArrayReturn"})
    public static ModeCompat[] getSupportedModes(@NonNull Context context, @NonNull Display display) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, display)) == null) {
            return Build.VERSION.SDK_INT >= 23 ? Api23Impl.getSupportedModes(context, display) : new ModeCompat[]{getMode(context, display)};
        }
        return (ModeCompat[]) invokeLL.objValue;
    }

    @Nullable
    public static Point parsePhysicalDisplaySizeFromSystemProperties(@NonNull String str, @NonNull Display display) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, str, display)) == null) {
            if (display.getDisplayId() != 0) {
                return null;
            }
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
        return (Point) invokeLL.objValue;
    }

    @Nullable
    public static String getSystemProperty(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            if (isTv(context) && "Sony".equals(Build.MANUFACTURER) && Build.MODEL.startsWith("BRAVIA") && context.getPackageManager().hasSystemFeature("com.sony.dtv.hardware.panel.qfhd")) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static Point parseDisplaySize(@NonNull String str) throws NumberFormatException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
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

    public static boolean isCurrentModeTheLargestMode(@NonNull Display display) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, display)) == null) {
            if (Build.VERSION.SDK_INT >= 23) {
                return Api23Impl.isCurrentModeTheLargestMode(display);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean isTv(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            UiModeManager uiModeManager = (UiModeManager) context.getSystemService("uimode");
            if (uiModeManager != null && uiModeManager.getCurrentModeType() == 4) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
