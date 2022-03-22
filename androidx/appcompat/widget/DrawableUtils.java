package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.graphics.Insets;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.graphics.drawable.DrawableWrapper;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.graphics.drawable.WrappedDrawable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.config.item.TipsConfigItem;
import com.tachikoma.core.component.anim.AnimationProperty;
import java.lang.reflect.Field;
@SuppressLint({"RestrictedAPI"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class DrawableUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int[] CHECKED_STATE_SET;
    public static final int[] EMPTY_STATE_SET;
    public static final Rect INSETS_NONE;
    public static final String TAG = "DrawableUtils";
    public static final String VECTOR_DRAWABLE_CLAZZ_NAME = "android.graphics.drawable.VectorDrawable";
    public static Class<?> sInsetsClazz;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-814165715, "Landroidx/appcompat/widget/DrawableUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-814165715, "Landroidx/appcompat/widget/DrawableUtils;");
                return;
            }
        }
        CHECKED_STATE_SET = new int[]{16842912};
        EMPTY_STATE_SET = new int[0];
        INSETS_NONE = new Rect();
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                sInsetsClazz = Class.forName("android.graphics.Insets");
            } catch (ClassNotFoundException unused) {
            }
        }
    }

    public DrawableUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static boolean canSafelyMutateDrawable(@NonNull Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, drawable)) == null) {
            if (Build.VERSION.SDK_INT >= 15 || !(drawable instanceof InsetDrawable)) {
                if (Build.VERSION.SDK_INT >= 15 || !(drawable instanceof GradientDrawable)) {
                    if (Build.VERSION.SDK_INT >= 17 || !(drawable instanceof LayerDrawable)) {
                        if (drawable instanceof DrawableContainer) {
                            Drawable.ConstantState constantState = drawable.getConstantState();
                            if (constantState instanceof DrawableContainer.DrawableContainerState) {
                                for (Drawable drawable2 : ((DrawableContainer.DrawableContainerState) constantState).getChildren()) {
                                    if (!canSafelyMutateDrawable(drawable2)) {
                                        return false;
                                    }
                                }
                                return true;
                            }
                            return true;
                        } else if (drawable instanceof WrappedDrawable) {
                            return canSafelyMutateDrawable(((WrappedDrawable) drawable).getWrappedDrawable());
                        } else {
                            if (drawable instanceof DrawableWrapper) {
                                return canSafelyMutateDrawable(((DrawableWrapper) drawable).getWrappedDrawable());
                            }
                            if (drawable instanceof ScaleDrawable) {
                                return canSafelyMutateDrawable(((ScaleDrawable) drawable).getDrawable());
                            }
                            return true;
                        }
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void fixDrawable(@NonNull Drawable drawable) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, drawable) == null) && Build.VERSION.SDK_INT == 21 && "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName())) {
            fixVectorDrawableTinting(drawable);
        }
    }

    public static void fixVectorDrawableTinting(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, drawable) == null) {
            int[] state = drawable.getState();
            if (state != null && state.length != 0) {
                drawable.setState(EMPTY_STATE_SET);
            } else {
                drawable.setState(CHECKED_STATE_SET);
            }
            drawable.setState(state);
        }
    }

    public static Rect getOpticalBounds(Drawable drawable) {
        InterceptResult invokeL;
        Field[] fields;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, drawable)) == null) {
            if (Build.VERSION.SDK_INT >= 29) {
                Insets opticalInsets = drawable.getOpticalInsets();
                Rect rect = new Rect();
                rect.left = opticalInsets.left;
                rect.right = opticalInsets.right;
                rect.top = opticalInsets.top;
                rect.bottom = opticalInsets.bottom;
                return rect;
            }
            if (sInsetsClazz != null) {
                try {
                    Drawable unwrap = DrawableCompat.unwrap(drawable);
                    Object invoke = unwrap.getClass().getMethod("getOpticalInsets", new Class[0]).invoke(unwrap, new Object[0]);
                    if (invoke != null) {
                        Rect rect2 = new Rect();
                        for (Field field : sInsetsClazz.getFields()) {
                            String name = field.getName();
                            char c2 = 65535;
                            switch (name.hashCode()) {
                                case -1383228885:
                                    if (name.equals(TipsConfigItem.TipConfigData.BOTTOM)) {
                                        c2 = 3;
                                        break;
                                    }
                                    break;
                                case 115029:
                                    if (name.equals(AnimationProperty.TOP)) {
                                        c2 = 1;
                                        break;
                                    }
                                    break;
                                case 3317767:
                                    if (name.equals("left")) {
                                        c2 = 0;
                                        break;
                                    }
                                    break;
                                case 108511772:
                                    if (name.equals("right")) {
                                        c2 = 2;
                                        break;
                                    }
                                    break;
                            }
                            if (c2 == 0) {
                                rect2.left = field.getInt(invoke);
                            } else if (c2 == 1) {
                                rect2.top = field.getInt(invoke);
                            } else if (c2 == 2) {
                                rect2.right = field.getInt(invoke);
                            } else if (c2 == 3) {
                                rect2.bottom = field.getInt(invoke);
                            }
                        }
                        return rect2;
                    }
                } catch (Exception unused) {
                    Log.e(TAG, "Couldn't obtain the optical insets. Ignoring.");
                }
            }
            return INSETS_NONE;
        }
        return (Rect) invokeL.objValue;
    }

    public static PorterDuff.Mode parseTintMode(int i, PorterDuff.Mode mode) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65542, null, i, mode)) == null) {
            if (i != 3) {
                if (i != 5) {
                    if (i != 9) {
                        switch (i) {
                            case 14:
                                return PorterDuff.Mode.MULTIPLY;
                            case 15:
                                return PorterDuff.Mode.SCREEN;
                            case 16:
                                return PorterDuff.Mode.ADD;
                            default:
                                return mode;
                        }
                    }
                    return PorterDuff.Mode.SRC_ATOP;
                }
                return PorterDuff.Mode.SRC_IN;
            }
            return PorterDuff.Mode.SRC_OVER;
        }
        return (PorterDuff.Mode) invokeIL.objValue;
    }
}
