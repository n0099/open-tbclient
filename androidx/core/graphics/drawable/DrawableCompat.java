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
import android.util.Log;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void applyTheme(Drawable drawable, Resources.Theme theme) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65537, null, drawable, theme) == null) && Build.VERSION.SDK_INT >= 21) {
            drawable.applyTheme(theme);
        }
    }

    public static void setAutoMirrored(Drawable drawable, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(65546, null, drawable, z) == null) && Build.VERSION.SDK_INT >= 19) {
            drawable.setAutoMirrored(z);
        }
    }

    public static void setTint(Drawable drawable, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65550, null, drawable, i) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                drawable.setTint(i);
            } else if (drawable instanceof TintAwareDrawable) {
                ((TintAwareDrawable) drawable).setTint(i);
            }
        }
    }

    public static void setTintList(Drawable drawable, ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65551, null, drawable, colorStateList) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                drawable.setTintList(colorStateList);
            } else if (drawable instanceof TintAwareDrawable) {
                ((TintAwareDrawable) drawable).setTintList(colorStateList);
            }
        }
    }

    public static void setTintMode(Drawable drawable, PorterDuff.Mode mode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65552, null, drawable, mode) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                drawable.setTintMode(mode);
            } else if (drawable instanceof TintAwareDrawable) {
                ((TintAwareDrawable) drawable).setTintMode(mode);
            }
        }
    }

    public static boolean canApplyTheme(Drawable drawable) {
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

    public static int getAlpha(Drawable drawable) {
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

    public static ColorFilter getColorFilter(Drawable drawable) {
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

    public static boolean isAutoMirrored(Drawable drawable) {
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
    public static void jumpToCurrentState(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, drawable) == null) {
            drawable.jumpToCurrentState();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: android.graphics.drawable.Drawable */
    /* JADX WARN: Multi-variable type inference failed */
    public static <T extends Drawable> T unwrap(Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, drawable)) == null) {
            if (drawable instanceof WrappedDrawable) {
                return (T) ((WrappedDrawable) drawable).getWrappedDrawable();
            }
            return drawable;
        }
        return (T) invokeL.objValue;
    }

    public static void clearColorFilter(Drawable drawable) {
        DrawableContainer.DrawableContainerState drawableContainerState;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, drawable) == null) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 23) {
                drawable.clearColorFilter();
            } else if (i >= 21) {
                drawable.clearColorFilter();
                if (drawable instanceof InsetDrawable) {
                    clearColorFilter(((InsetDrawable) drawable).getDrawable());
                } else if (drawable instanceof WrappedDrawable) {
                    clearColorFilter(((WrappedDrawable) drawable).getWrappedDrawable());
                } else if ((drawable instanceof DrawableContainer) && (drawableContainerState = (DrawableContainer.DrawableContainerState) ((DrawableContainer) drawable).getConstantState()) != null) {
                    int childCount = drawableContainerState.getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        Drawable child = drawableContainerState.getChild(i2);
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

    public static int getLayoutDirection(Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, drawable)) == null) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 23) {
                return drawable.getLayoutDirection();
            }
            if (i >= 17) {
                if (!sGetLayoutDirectionMethodFetched) {
                    try {
                        Method declaredMethod = Drawable.class.getDeclaredMethod("getLayoutDirection", new Class[0]);
                        sGetLayoutDirectionMethod = declaredMethod;
                        declaredMethod.setAccessible(true);
                    } catch (NoSuchMethodException e) {
                        Log.i(TAG, "Failed to retrieve getLayoutDirection() method", e);
                    }
                    sGetLayoutDirectionMethodFetched = true;
                }
                Method method = sGetLayoutDirectionMethod;
                if (method != null) {
                    try {
                        return ((Integer) method.invoke(drawable, new Object[0])).intValue();
                    } catch (Exception e2) {
                        Log.i(TAG, "Failed to invoke getLayoutDirection() via reflection", e2);
                        sGetLayoutDirectionMethod = null;
                    }
                }
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static void inflate(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65543, null, drawable, resources, xmlPullParser, attributeSet, theme) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                drawable.inflate(resources, xmlPullParser, attributeSet, theme);
            } else {
                drawable.inflate(resources, xmlPullParser, attributeSet);
            }
        }
    }

    public static void setHotspot(Drawable drawable, float f, float f2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65547, null, new Object[]{drawable, Float.valueOf(f), Float.valueOf(f2)}) == null) && Build.VERSION.SDK_INT >= 21) {
            drawable.setHotspot(f, f2);
        }
    }

    public static void setHotspotBounds(Drawable drawable, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65548, null, new Object[]{drawable, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) && Build.VERSION.SDK_INT >= 21) {
            drawable.setHotspotBounds(i, i2, i3, i4);
        }
    }

    public static boolean setLayoutDirection(Drawable drawable, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65549, null, drawable, i)) == null) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 23) {
                return drawable.setLayoutDirection(i);
            }
            if (i2 >= 17) {
                if (!sSetLayoutDirectionMethodFetched) {
                    try {
                        Method declaredMethod = Drawable.class.getDeclaredMethod("setLayoutDirection", Integer.TYPE);
                        sSetLayoutDirectionMethod = declaredMethod;
                        declaredMethod.setAccessible(true);
                    } catch (NoSuchMethodException e) {
                        Log.i(TAG, "Failed to retrieve setLayoutDirection(int) method", e);
                    }
                    sSetLayoutDirectionMethodFetched = true;
                }
                Method method = sSetLayoutDirectionMethod;
                if (method != null) {
                    try {
                        method.invoke(drawable, Integer.valueOf(i));
                        return true;
                    } catch (Exception e2) {
                        Log.i(TAG, "Failed to invoke setLayoutDirection(int) via reflection", e2);
                        sSetLayoutDirectionMethod = null;
                    }
                }
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    public static Drawable wrap(Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, drawable)) == null) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 23) {
                return drawable;
            }
            if (i >= 21) {
                if (!(drawable instanceof TintAwareDrawable)) {
                    return new WrappedDrawableApi21(drawable);
                }
                return drawable;
            } else if (!(drawable instanceof TintAwareDrawable)) {
                return new WrappedDrawableApi14(drawable);
            } else {
                return drawable;
            }
        }
        return (Drawable) invokeL.objValue;
    }
}
