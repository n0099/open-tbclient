package androidx.appcompat.content.res;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ColorStateListInflaterCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.WeakHashMap;
@SuppressLint({"RestrictedAPI"})
/* loaded from: classes.dex */
public final class AppCompatResources {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String LOG_TAG = "AppCompatResources";
    public static final ThreadLocal<TypedValue> TL_TYPED_VALUE;
    public static final Object sColorStateCacheLock;
    public static final WeakHashMap<Context, SparseArray<ColorStateListCacheEntry>> sColorStateCaches;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class ColorStateListCacheEntry {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Configuration configuration;
        public final ColorStateList value;

        public ColorStateListCacheEntry(@NonNull ColorStateList colorStateList, @NonNull Configuration configuration) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {colorStateList, configuration};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.value = colorStateList;
            this.configuration = configuration;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-155708946, "Landroidx/appcompat/content/res/AppCompatResources;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-155708946, "Landroidx/appcompat/content/res/AppCompatResources;");
                return;
            }
        }
        TL_TYPED_VALUE = new ThreadLocal<>();
        sColorStateCaches = new WeakHashMap<>(0);
        sColorStateCacheLock = new Object();
    }

    public AppCompatResources() {
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

    public static void addColorStateListToCache(@NonNull Context context, @ColorRes int i2, @NonNull ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65538, null, context, i2, colorStateList) == null) {
            synchronized (sColorStateCacheLock) {
                SparseArray<ColorStateListCacheEntry> sparseArray = sColorStateCaches.get(context);
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                    sColorStateCaches.put(context, sparseArray);
                }
                sparseArray.append(i2, new ColorStateListCacheEntry(colorStateList, context.getResources().getConfiguration()));
            }
        }
    }

    @Nullable
    public static ColorStateList getCachedColorStateList(@NonNull Context context, @ColorRes int i2) {
        InterceptResult invokeLI;
        ColorStateListCacheEntry colorStateListCacheEntry;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, context, i2)) == null) {
            synchronized (sColorStateCacheLock) {
                SparseArray<ColorStateListCacheEntry> sparseArray = sColorStateCaches.get(context);
                if (sparseArray != null && sparseArray.size() > 0 && (colorStateListCacheEntry = sparseArray.get(i2)) != null) {
                    if (colorStateListCacheEntry.configuration.equals(context.getResources().getConfiguration())) {
                        return colorStateListCacheEntry.value;
                    }
                    sparseArray.remove(i2);
                }
                return null;
            }
        }
        return (ColorStateList) invokeLI.objValue;
    }

    public static ColorStateList getColorStateList(@NonNull Context context, @ColorRes int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, context, i2)) == null) {
            if (Build.VERSION.SDK_INT >= 23) {
                return context.getColorStateList(i2);
            }
            ColorStateList cachedColorStateList = getCachedColorStateList(context, i2);
            if (cachedColorStateList != null) {
                return cachedColorStateList;
            }
            ColorStateList inflateColorStateList = inflateColorStateList(context, i2);
            if (inflateColorStateList != null) {
                addColorStateListToCache(context, i2, inflateColorStateList);
                return inflateColorStateList;
            }
            return ContextCompat.getColorStateList(context, i2);
        }
        return (ColorStateList) invokeLI.objValue;
    }

    @Nullable
    public static Drawable getDrawable(@NonNull Context context, @DrawableRes int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(AdIconUtil.AD_TEXT_ID, null, context, i2)) == null) ? ResourceManagerInternal.get().getDrawable(context, i2) : (Drawable) invokeLI.objValue;
    }

    @NonNull
    public static TypedValue getTypedValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
            TypedValue typedValue = TL_TYPED_VALUE.get();
            if (typedValue == null) {
                TypedValue typedValue2 = new TypedValue();
                TL_TYPED_VALUE.set(typedValue2);
                return typedValue2;
            }
            return typedValue;
        }
        return (TypedValue) invokeV.objValue;
    }

    @Nullable
    public static ColorStateList inflateColorStateList(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65543, null, context, i2)) == null) {
            if (isColorInt(context, i2)) {
                return null;
            }
            Resources resources = context.getResources();
            try {
                return ColorStateListInflaterCompat.createFromXml(resources, resources.getXml(i2), context.getTheme());
            } catch (Exception e2) {
                Log.e(LOG_TAG, "Failed to inflate ColorStateList, leaving it to the framework", e2);
                return null;
            }
        }
        return (ColorStateList) invokeLI.objValue;
    }

    public static boolean isColorInt(@NonNull Context context, @ColorRes int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65544, null, context, i2)) == null) {
            Resources resources = context.getResources();
            TypedValue typedValue = getTypedValue();
            resources.getValue(i2, typedValue, true);
            int i3 = typedValue.type;
            return i3 >= 28 && i3 <= 31;
        }
        return invokeLI.booleanValue;
    }
}
