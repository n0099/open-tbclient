package androidx.core.content.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import androidx.annotation.AnyRes;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.FontRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes.dex */
public final class ResourcesCompat {
    public static /* synthetic */ Interceptable $ic = null;
    @AnyRes
    public static final int ID_NULL = 0;
    public static final String TAG = "ResourcesCompat";
    public static final Object sColorStateCacheLock;
    public static final WeakHashMap<ColorStateListCacheKey, SparseArray<ColorStateListCacheEntry>> sColorStateCaches;
    public static final ThreadLocal<TypedValue> sTempTypedValue;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static final class ThemeCompat {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @RequiresApi(23)
        /* loaded from: classes.dex */
        public static class ImplApi23 {
            public static /* synthetic */ Interceptable $ic;
            public static Method sRebaseMethod;
            public static boolean sRebaseMethodFetched;
            public static final Object sRebaseMethodLock;
            public transient /* synthetic */ FieldHolder $fh;

            static {
                InterceptResult invokeClinit;
                ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
                if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1763466097, "Landroidx/core/content/res/ResourcesCompat$ThemeCompat$ImplApi23;")) != null) {
                    Interceptable interceptable = invokeClinit.interceptor;
                    if (interceptable != null) {
                        $ic = interceptable;
                    }
                    if ((invokeClinit.flags & 1) != 0) {
                        classClinitInterceptable.invokePostClinit(1763466097, "Landroidx/core/content/res/ResourcesCompat$ThemeCompat$ImplApi23;");
                        return;
                    }
                }
                sRebaseMethodLock = new Object();
            }

            public ImplApi23() {
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

            public static void rebase(@NonNull Resources.Theme theme) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(65538, null, theme) == null) {
                    synchronized (sRebaseMethodLock) {
                        if (!sRebaseMethodFetched) {
                            try {
                                Method declaredMethod = Resources.Theme.class.getDeclaredMethod("rebase", new Class[0]);
                                sRebaseMethod = declaredMethod;
                                declaredMethod.setAccessible(true);
                            } catch (NoSuchMethodException e) {
                                Log.i(ResourcesCompat.TAG, "Failed to retrieve rebase() method", e);
                            }
                            sRebaseMethodFetched = true;
                        }
                        if (sRebaseMethod != null) {
                            try {
                                sRebaseMethod.invoke(theme, new Object[0]);
                            } catch (IllegalAccessException | InvocationTargetException e2) {
                                Log.i(ResourcesCompat.TAG, "Failed to invoke rebase() method via reflection", e2);
                                sRebaseMethod = null;
                            }
                        }
                    }
                }
            }
        }

        @RequiresApi(29)
        /* loaded from: classes.dex */
        public static class ImplApi29 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public ImplApi29() {
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

            public static void rebase(@NonNull Resources.Theme theme) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(65537, null, theme) == null) {
                    theme.rebase();
                }
            }
        }

        public ThemeCompat() {
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

        public static void rebase(@NonNull Resources.Theme theme) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65537, null, theme) == null) {
                int i = Build.VERSION.SDK_INT;
                if (i >= 29) {
                    ImplApi29.rebase(theme);
                } else if (i >= 23) {
                    ImplApi23.rebase(theme);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class ColorStateListCacheEntry {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Configuration mConfiguration;
        public final ColorStateList mValue;

        public ColorStateListCacheEntry(@NonNull ColorStateList colorStateList, @NonNull Configuration configuration) {
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
            this.mValue = colorStateList;
            this.mConfiguration = configuration;
        }
    }

    /* loaded from: classes.dex */
    public static final class ColorStateListCacheKey {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Resources mResources;
        @Nullable
        public final Resources.Theme mTheme;

        public ColorStateListCacheKey(@NonNull Resources resources, @Nullable Resources.Theme theme) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {resources, theme};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mResources = resources;
            this.mTheme = theme;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || ColorStateListCacheKey.class != obj.getClass()) {
                    return false;
                }
                ColorStateListCacheKey colorStateListCacheKey = (ColorStateListCacheKey) obj;
                if (this.mResources.equals(colorStateListCacheKey.mResources) && ObjectsCompat.equals(this.mTheme, colorStateListCacheKey.mTheme)) {
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return ObjectsCompat.hash(this.mResources, this.mTheme);
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class FontCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public abstract void onFontRetrievalFailed(int i);

        public abstract void onFontRetrieved(@NonNull Typeface typeface);

        public FontCallback() {
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
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public static Handler getHandler(@Nullable Handler handler) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, handler)) == null) {
                if (handler == null) {
                    return new Handler(Looper.getMainLooper());
                }
                return handler;
            }
            return (Handler) invokeL.objValue;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public final void callbackFailAsync(int i, @Nullable Handler handler) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, handler) == null) {
                getHandler(handler).post(new Runnable(this, i) { // from class: androidx.core.content.res.ResourcesCompat.FontCallback.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ FontCallback this$0;
                    public final /* synthetic */ int val$reason;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Integer.valueOf(i)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$reason = i;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.this$0.onFontRetrievalFailed(this.val$reason);
                        }
                    }
                });
            }
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public final void callbackSuccessAsync(Typeface typeface, @Nullable Handler handler) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, typeface, handler) == null) {
                getHandler(handler).post(new Runnable(this, typeface) { // from class: androidx.core.content.res.ResourcesCompat.FontCallback.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ FontCallback this$0;
                    public final /* synthetic */ Typeface val$typeface;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, typeface};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$typeface = typeface;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.this$0.onFontRetrieved(this.val$typeface);
                        }
                    }
                });
            }
        }
    }

    @RequiresApi(29)
    /* loaded from: classes.dex */
    public static class ImplApi29 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public ImplApi29() {
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

        public static float getFloat(@NonNull Resources resources, @DimenRes int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, resources, i)) == null) {
                return resources.getFloat(i);
            }
            return invokeLI.floatValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(425559471, "Landroidx/core/content/res/ResourcesCompat;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(425559471, "Landroidx/core/content/res/ResourcesCompat;");
                return;
            }
        }
        sTempTypedValue = new ThreadLocal<>();
        sColorStateCaches = new WeakHashMap<>(0);
        sColorStateCacheLock = new Object();
    }

    public ResourcesCompat() {
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

    @NonNull
    public static TypedValue getTypedValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            TypedValue typedValue = sTempTypedValue.get();
            if (typedValue == null) {
                TypedValue typedValue2 = new TypedValue();
                sTempTypedValue.set(typedValue2);
                return typedValue2;
            }
            return typedValue;
        }
        return (TypedValue) invokeV.objValue;
    }

    public static void addColorStateListToCache(@NonNull ColorStateListCacheKey colorStateListCacheKey, @ColorRes int i, @NonNull ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65538, null, colorStateListCacheKey, i, colorStateList) == null) {
            synchronized (sColorStateCacheLock) {
                SparseArray<ColorStateListCacheEntry> sparseArray = sColorStateCaches.get(colorStateListCacheKey);
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                    sColorStateCaches.put(colorStateListCacheKey, sparseArray);
                }
                sparseArray.append(i, new ColorStateListCacheEntry(colorStateList, colorStateListCacheKey.mResources.getConfiguration()));
            }
        }
    }

    @Nullable
    public static ColorStateList getColorStateList(@NonNull Resources resources, @ColorRes int i, @Nullable Resources.Theme theme) throws Resources.NotFoundException {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65542, null, resources, i, theme)) == null) {
            if (Build.VERSION.SDK_INT >= 23) {
                return resources.getColorStateList(i, theme);
            }
            ColorStateListCacheKey colorStateListCacheKey = new ColorStateListCacheKey(resources, theme);
            ColorStateList cachedColorStateList = getCachedColorStateList(colorStateListCacheKey, i);
            if (cachedColorStateList != null) {
                return cachedColorStateList;
            }
            ColorStateList inflateColorStateList = inflateColorStateList(resources, i, theme);
            if (inflateColorStateList != null) {
                addColorStateListToCache(colorStateListCacheKey, i, inflateColorStateList);
                return inflateColorStateList;
            }
            return resources.getColorStateList(i);
        }
        return (ColorStateList) invokeLIL.objValue;
    }

    @Nullable
    public static ColorStateList getCachedColorStateList(@NonNull ColorStateListCacheKey colorStateListCacheKey, @ColorRes int i) {
        InterceptResult invokeLI;
        ColorStateListCacheEntry colorStateListCacheEntry;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, colorStateListCacheKey, i)) == null) {
            synchronized (sColorStateCacheLock) {
                SparseArray<ColorStateListCacheEntry> sparseArray = sColorStateCaches.get(colorStateListCacheKey);
                if (sparseArray != null && sparseArray.size() > 0 && (colorStateListCacheEntry = sparseArray.get(i)) != null) {
                    if (colorStateListCacheEntry.mConfiguration.equals(colorStateListCacheKey.mResources.getConfiguration())) {
                        return colorStateListCacheEntry.mValue;
                    }
                    sparseArray.remove(i);
                }
                return null;
            }
        }
        return (ColorStateList) invokeLI.objValue;
    }

    public static float getFloat(@NonNull Resources resources, @DimenRes int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65545, null, resources, i)) == null) {
            if (Build.VERSION.SDK_INT >= 29) {
                return ImplApi29.getFloat(resources, i);
            }
            TypedValue typedValue = getTypedValue();
            resources.getValue(i, typedValue, true);
            if (typedValue.type == 4) {
                return typedValue.getFloat();
            }
            throw new Resources.NotFoundException("Resource ID #0x" + Integer.toHexString(i) + " type #0x" + Integer.toHexString(typedValue.type) + " is not valid");
        }
        return invokeLI.floatValue;
    }

    @Nullable
    public static Typeface getCachedFont(@NonNull Context context, @FontRes int i) throws Resources.NotFoundException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, context, i)) == null) {
            if (context.isRestricted()) {
                return null;
            }
            return loadFont(context, i, new TypedValue(), 0, null, null, false, true);
        }
        return (Typeface) invokeLI.objValue;
    }

    @Nullable
    public static Typeface getFont(@NonNull Context context, @FontRes int i) throws Resources.NotFoundException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65546, null, context, i)) == null) {
            if (context.isRestricted()) {
                return null;
            }
            return loadFont(context, i, new TypedValue(), 0, null, null, false, false);
        }
        return (Typeface) invokeLI.objValue;
    }

    public static boolean isColorInt(@NonNull Resources resources, @ColorRes int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65551, null, resources, i)) == null) {
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

    @ColorInt
    public static int getColor(@NonNull Resources resources, @ColorRes int i, @Nullable Resources.Theme theme) throws Resources.NotFoundException {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65541, null, resources, i, theme)) == null) {
            if (Build.VERSION.SDK_INT >= 23) {
                return resources.getColor(i, theme);
            }
            return resources.getColor(i);
        }
        return invokeLIL.intValue;
    }

    @Nullable
    public static Drawable getDrawable(@NonNull Resources resources, @DrawableRes int i, @Nullable Resources.Theme theme) throws Resources.NotFoundException {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65543, null, resources, i, theme)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                return resources.getDrawable(i, theme);
            }
            return resources.getDrawable(i);
        }
        return (Drawable) invokeLIL.objValue;
    }

    @Nullable
    public static ColorStateList inflateColorStateList(Resources resources, int i, @Nullable Resources.Theme theme) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65550, null, resources, i, theme)) == null) {
            if (isColorInt(resources, i)) {
                return null;
            }
            try {
                return ColorStateListInflaterCompat.createFromXml(resources, resources.getXml(i), theme);
            } catch (Exception e) {
                Log.e(TAG, "Failed to inflate ColorStateList, leaving it to the framework", e);
                return null;
            }
        }
        return (ColorStateList) invokeLIL.objValue;
    }

    @Nullable
    public static Drawable getDrawableForDensity(@NonNull Resources resources, @DrawableRes int i, int i2, @Nullable Resources.Theme theme) throws Resources.NotFoundException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{resources, Integer.valueOf(i), Integer.valueOf(i2), theme})) == null) {
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 21) {
                return resources.getDrawableForDensity(i, i2, theme);
            }
            if (i3 >= 15) {
                return resources.getDrawableForDensity(i, i2);
            }
            return resources.getDrawable(i);
        }
        return (Drawable) invokeCommon.objValue;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static Typeface getFont(@NonNull Context context, @FontRes int i, TypedValue typedValue, int i2, @Nullable FontCallback fontCallback) throws Resources.NotFoundException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, null, new Object[]{context, Integer.valueOf(i), typedValue, Integer.valueOf(i2), fontCallback})) == null) {
            if (context.isRestricted()) {
                return null;
            }
            return loadFont(context, i, typedValue, i2, fontCallback, null, true, false);
        }
        return (Typeface) invokeCommon.objValue;
    }

    public static void getFont(@NonNull Context context, @FontRes int i, @NonNull FontCallback fontCallback, @Nullable Handler handler) throws Resources.NotFoundException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65548, null, context, i, fontCallback, handler) == null) {
            Preconditions.checkNotNull(fontCallback);
            if (context.isRestricted()) {
                fontCallback.callbackFailAsync(-4, handler);
            } else {
                loadFont(context, i, new TypedValue(), 0, fontCallback, handler, false, false);
            }
        }
    }

    public static Typeface loadFont(@NonNull Context context, int i, TypedValue typedValue, int i2, @Nullable FontCallback fontCallback, @Nullable Handler handler, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65552, null, new Object[]{context, Integer.valueOf(i), typedValue, Integer.valueOf(i2), fontCallback, handler, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            Resources resources = context.getResources();
            resources.getValue(i, typedValue, true);
            Typeface loadFont = loadFont(context, resources, typedValue, i, i2, fontCallback, handler, z, z2);
            if (loadFont == null && fontCallback == null && !z2) {
                throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(i) + " could not be retrieved.");
            }
            return loadFont;
        }
        return (Typeface) invokeCommon.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00aa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Typeface loadFont(@NonNull Context context, Resources resources, TypedValue typedValue, int i, int i2, @Nullable FontCallback fontCallback, @Nullable Handler handler, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65553, null, new Object[]{context, resources, typedValue, Integer.valueOf(i), Integer.valueOf(i2), fontCallback, handler, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            CharSequence charSequence = typedValue.string;
            if (charSequence != null) {
                String charSequence2 = charSequence.toString();
                if (!charSequence2.startsWith("res/")) {
                    if (fontCallback != null) {
                        fontCallback.callbackFailAsync(-3, handler);
                    }
                    return null;
                }
                Typeface findFromCache = TypefaceCompat.findFromCache(resources, i, i2);
                if (findFromCache != null) {
                    if (fontCallback != null) {
                        fontCallback.callbackSuccessAsync(findFromCache, handler);
                    }
                    return findFromCache;
                } else if (z2) {
                    return null;
                } else {
                    try {
                        if (charSequence2.toLowerCase().endsWith(ActivityChooserModel.HISTORY_FILE_EXTENSION)) {
                            FontResourcesParserCompat.FamilyResourceEntry parse = FontResourcesParserCompat.parse(resources.getXml(i), resources);
                            if (parse == null) {
                                Log.e(TAG, "Failed to find font-family tag");
                                if (fontCallback != null) {
                                    fontCallback.callbackFailAsync(-3, handler);
                                }
                                return null;
                            }
                            return TypefaceCompat.createFromResourcesFamilyXml(context, parse, resources, i, i2, fontCallback, handler, z);
                        }
                        Typeface createFromResourcesFontFile = TypefaceCompat.createFromResourcesFontFile(context, resources, i, charSequence2, i2);
                        if (fontCallback != null) {
                            if (createFromResourcesFontFile != null) {
                                fontCallback.callbackSuccessAsync(createFromResourcesFontFile, handler);
                            } else {
                                fontCallback.callbackFailAsync(-3, handler);
                            }
                        }
                        return createFromResourcesFontFile;
                    } catch (IOException e) {
                        Log.e(TAG, "Failed to read xml resource " + charSequence2, e);
                        if (fontCallback != null) {
                            fontCallback.callbackFailAsync(-3, handler);
                        }
                        return null;
                    } catch (XmlPullParserException e2) {
                        Log.e(TAG, "Failed to parse xml resource " + charSequence2, e2);
                        if (fontCallback != null) {
                        }
                        return null;
                    }
                }
            }
            throw new Resources.NotFoundException("Resource \"" + resources.getResourceName(i) + "\" (" + Integer.toHexString(i) + ") is not a Font: " + typedValue);
        }
        return (Typeface) invokeCommon.objValue;
    }
}
