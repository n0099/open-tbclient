package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.util.AttributeSet;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes.dex */
public final class DrawableCompat {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "DrawableCompat";
    public static Method sGetLayoutDirectionMethod;
    public static boolean sGetLayoutDirectionMethodFetched;
    public static Method sSetLayoutDirectionMethod;
    public static boolean sSetLayoutDirectionMethodFetched;
    public transient /* synthetic */ FieldHolder $fh;

    public DrawableCompat() {
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

    public static void applyTheme(@NonNull Drawable drawable, @NonNull Resources.Theme theme) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, drawable, theme) == null) || Build.VERSION.SDK_INT < 21) {
            return;
        }
        drawable.applyTheme(theme);
    }

    public static boolean canApplyTheme(@NonNull Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, drawable)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                return drawable.canApplyTheme();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void clearColorFilter(@NonNull Drawable drawable) {
        DrawableContainer.DrawableContainerState drawableContainerState;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, drawable) == null) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 23) {
                drawable.clearColorFilter();
            } else if (i2 >= 21) {
                drawable.clearColorFilter();
                if (drawable instanceof InsetDrawable) {
                    clearColorFilter(((InsetDrawable) drawable).getDrawable());
                } else if (drawable instanceof WrappedDrawable) {
                    clearColorFilter(((WrappedDrawable) drawable).getWrappedDrawable());
                } else if ((drawable instanceof DrawableContainer) && (drawableContainerState = (DrawableContainer.DrawableContainerState) ((DrawableContainer) drawable).getConstantState()) != null) {
                    int childCount = drawableContainerState.getChildCount();
                    for (int i3 = 0; i3 < childCount; i3++) {
                        Drawable child = drawableContainerState.getChild(i3);
                        if (child != null) {
                            clearColorFilter(child);
                        }
                    }
                }
            } else {
                drawable.clearColorFilter();
            }
        }
    }

    public static int getAlpha(@NonNull Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, drawable)) == null) {
            if (Build.VERSION.SDK_INT >= 19) {
                return drawable.getAlpha();
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static ColorFilter getColorFilter(@NonNull Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, drawable)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                return drawable.getColorFilter();
            }
            return null;
        }
        return (ColorFilter) invokeL.objValue;
    }

    public static int getLayoutDirection(@NonNull Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, drawable)) == null) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 23) {
                return drawable.getLayoutDirection();
            }
            if (i2 >= 17) {
                if (!sGetLayoutDirectionMethodFetched) {
                    try {
                        Method declaredMethod = Drawable.class.getDeclaredMethod("getLayoutDirection", new Class[0]);
                        sGetLayoutDirectionMethod = declaredMethod;
                        declaredMethod.setAccessible(true);
                    } catch (NoSuchMethodException unused) {
                    }
                    sGetLayoutDirectionMethodFetched = true;
                }
                Method method = sGetLayoutDirectionMethod;
                if (method != null) {
                    try {
                        return ((Integer) method.invoke(drawable, new Object[0])).intValue();
                    } catch (Exception unused2) {
                        sGetLayoutDirectionMethod = null;
                    }
                }
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static void inflate(@NonNull Drawable drawable, @NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) throws XmlPullParserException, IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65543, null, drawable, resources, xmlPullParser, attributeSet, theme) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                drawable.inflate(resources, xmlPullParser, attributeSet, theme);
            } else {
                drawable.inflate(resources, xmlPullParser, attributeSet);
            }
        }
    }

    public static boolean isAutoMirrored(@NonNull Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, drawable)) == null) {
            if (Build.VERSION.SDK_INT >= 19) {
                return drawable.isAutoMirrored();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Deprecated
    public static void jumpToCurrentState(@NonNull Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, drawable) == null) {
            drawable.jumpToCurrentState();
        }
    }

    public static void setAutoMirrored(@NonNull Drawable drawable, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65546, null, drawable, z) == null) || Build.VERSION.SDK_INT < 19) {
            return;
        }
        drawable.setAutoMirrored(z);
    }

    public static void setHotspot(@NonNull Drawable drawable, float f2, float f3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65547, null, new Object[]{drawable, Float.valueOf(f2), Float.valueOf(f3)}) == null) || Build.VERSION.SDK_INT < 21) {
            return;
        }
        drawable.setHotspot(f2, f3);
    }

    public static void setHotspotBounds(@NonNull Drawable drawable, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65548, null, new Object[]{drawable, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) || Build.VERSION.SDK_INT < 21) {
            return;
        }
        drawable.setHotspotBounds(i2, i3, i4, i5);
    }

    public static boolean setLayoutDirection(@NonNull Drawable drawable, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65549, null, drawable, i2)) == null) {
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 23) {
                return drawable.setLayoutDirection(i2);
            }
            if (i3 >= 17) {
                if (!sSetLayoutDirectionMethodFetched) {
                    try {
                        Method declaredMethod = Drawable.class.getDeclaredMethod("setLayoutDirection", Integer.TYPE);
                        sSetLayoutDirectionMethod = declaredMethod;
                        declaredMethod.setAccessible(true);
                    } catch (NoSuchMethodException unused) {
                    }
                    sSetLayoutDirectionMethodFetched = true;
                }
                Method method = sSetLayoutDirectionMethod;
                if (method != null) {
                    try {
                        method.invoke(drawable, Integer.valueOf(i2));
                        return true;
                    } catch (Exception unused2) {
                        sSetLayoutDirectionMethod = null;
                    }
                }
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    public static void setTint(@NonNull Drawable drawable, @ColorInt int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65550, null, drawable, i2) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                drawable.setTint(i2);
            } else if (drawable instanceof TintAwareDrawable) {
                ((TintAwareDrawable) drawable).setTint(i2);
            }
        }
    }

    public static void setTintList(@NonNull Drawable drawable, @Nullable ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65551, null, drawable, colorStateList) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                drawable.setTintList(colorStateList);
            } else if (drawable instanceof TintAwareDrawable) {
                ((TintAwareDrawable) drawable).setTintList(colorStateList);
            }
        }
    }

    public static void setTintMode(@NonNull Drawable drawable, @NonNull PorterDuff.Mode mode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65552, null, drawable, mode) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                drawable.setTintMode(mode);
            } else if (drawable instanceof TintAwareDrawable) {
                ((TintAwareDrawable) drawable).setTintMode(mode);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: android.graphics.drawable.Drawable */
    /* JADX WARN: Multi-variable type inference failed */
    public static <T extends Drawable> T unwrap(@NonNull Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65553, null, drawable)) == null) ? drawable instanceof WrappedDrawable ? (T) ((WrappedDrawable) drawable).getWrappedDrawable() : drawable : (T) invokeL.objValue;
    }

    public static Drawable wrap(@NonNull Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, drawable)) == null) {
            int i2 = Build.VERSION.SDK_INT;
            return i2 >= 23 ? drawable : i2 >= 21 ? !(drawable instanceof TintAwareDrawable) ? new WrappedDrawableApi21(drawable) : drawable : !(drawable instanceof TintAwareDrawable) ? new WrappedDrawableApi14(drawable) : drawable;
        }
        return (Drawable) invokeL.objValue;
    }
}
