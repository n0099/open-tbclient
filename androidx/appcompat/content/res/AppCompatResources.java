package androidx.appcompat.content.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ColorStateListInflaterCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.WeakHashMap;
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

        public ColorStateListCacheEntry(ColorStateList colorStateList, Configuration configuration) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {colorStateList, configuration};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static TypedValue getTypedValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
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

    public static void addColorStateListToCache(Context context, int i, ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65538, null, context, i, colorStateList) == null) {
            synchronized (sColorStateCacheLock) {
                SparseArray<ColorStateListCacheEntry> sparseArray = sColorStateCaches.get(context);
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                    sColorStateCaches.put(context, sparseArray);
                }
                sparseArray.append(i, new ColorStateListCacheEntry(colorStateList, context.getResources().getConfiguration()));
            }
        }
    }

    public static ColorStateList getCachedColorStateList(Context context, int i) {
        InterceptResult invokeLI;
        ColorStateListCacheEntry colorStateListCacheEntry;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, context, i)) == null) {
            synchronized (sColorStateCacheLock) {
                SparseArray<ColorStateListCacheEntry> sparseArray = sColorStateCaches.get(context);
                if (sparseArray != null && sparseArray.size() > 0 && (colorStateListCacheEntry = sparseArray.get(i)) != null) {
                    if (colorStateListCacheEntry.configuration.equals(context.getResources().getConfiguration())) {
                        return colorStateListCacheEntry.value;
                    }
                    sparseArray.remove(i);
                }
                return null;
            }
        }
        return (ColorStateList) invokeLI.objValue;
    }

    public static ColorStateList getColorStateList(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, context, i)) == null) {
            if (Build.VERSION.SDK_INT >= 23) {
                return context.getColorStateList(i);
            }
            ColorStateList cachedColorStateList = getCachedColorStateList(context, i);
            if (cachedColorStateList != null) {
                return cachedColorStateList;
            }
            ColorStateList inflateColorStateList = inflateColorStateList(context, i);
            if (inflateColorStateList != null) {
                addColorStateListToCache(context, i, inflateColorStateList);
                return inflateColorStateList;
            }
            return ContextCompat.getColorStateList(context, i);
        }
        return (ColorStateList) invokeLI.objValue;
    }

    public static ColorStateList inflateColorStateList(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65543, null, context, i)) == null) {
            if (isColorInt(context, i)) {
                return null;
            }
            Resources resources = context.getResources();
            try {
                return ColorStateListInflaterCompat.createFromXml(resources, resources.getXml(i), context.getTheme());
            } catch (Exception e) {
                Log.e(LOG_TAG, "Failed to inflate ColorStateList, leaving it to the framework", e);
                return null;
            }
        }
        return (ColorStateList) invokeLI.objValue;
    }

    public static Drawable getDrawable(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65541, null, context, i)) == null) {
            return ResourceManagerInternal.get().getDrawable(context, i);
        }
        return (Drawable) invokeLI.objValue;
    }

    public static boolean isColorInt(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65544, null, context, i)) == null) {
            Resources resources = context.getResources();
            TypedValue typedValue = getTypedValue();
            resources.getValue(i, typedValue, true);
            int i2 = typedValue.type;
            if (i2 >= 28 && i2 <= 31) {
                return true;
            }
            return false;
        }
        return invokeLI.booleanValue;
    }
}
