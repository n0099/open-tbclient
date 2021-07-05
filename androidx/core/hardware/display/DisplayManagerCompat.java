package androidx.core.hardware.display;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public final class DisplayManagerCompat {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DISPLAY_CATEGORY_PRESENTATION = "android.hardware.display.category.PRESENTATION";
    public static final WeakHashMap<Context, DisplayManagerCompat> sInstances;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context mContext;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(666053616, "Landroidx/core/hardware/display/DisplayManagerCompat;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(666053616, "Landroidx/core/hardware/display/DisplayManagerCompat;");
                return;
            }
        }
        sInstances = new WeakHashMap<>();
    }

    public DisplayManagerCompat(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mContext = context;
    }

    @NonNull
    public static DisplayManagerCompat getInstance(@NonNull Context context) {
        InterceptResult invokeL;
        DisplayManagerCompat displayManagerCompat;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            synchronized (sInstances) {
                displayManagerCompat = sInstances.get(context);
                if (displayManagerCompat == null) {
                    displayManagerCompat = new DisplayManagerCompat(context);
                    sInstances.put(context, displayManagerCompat);
                }
            }
            return displayManagerCompat;
        }
        return (DisplayManagerCompat) invokeL.objValue;
    }

    @Nullable
    public Display getDisplay(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            if (Build.VERSION.SDK_INT >= 17) {
                return ((DisplayManager) this.mContext.getSystemService("display")).getDisplay(i2);
            }
            Display defaultDisplay = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay();
            if (defaultDisplay.getDisplayId() == i2) {
                return defaultDisplay;
            }
            return null;
        }
        return (Display) invokeI.objValue;
    }

    @NonNull
    public Display[] getDisplays() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? Build.VERSION.SDK_INT >= 17 ? ((DisplayManager) this.mContext.getSystemService("display")).getDisplays() : new Display[]{((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay()} : (Display[]) invokeV.objValue;
    }

    @NonNull
    public Display[] getDisplays(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (Build.VERSION.SDK_INT >= 17) {
                return ((DisplayManager) this.mContext.getSystemService("display")).getDisplays(str);
            }
            return str == null ? new Display[0] : new Display[]{((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay()};
        }
        return (Display[]) invokeL.objValue;
    }
}
