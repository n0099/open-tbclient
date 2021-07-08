package androidx.core.content.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
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
import androidx.core.util.Preconditions;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes.dex */
public final class ResourcesCompat {
    public static /* synthetic */ Interceptable $ic = null;
    @AnyRes
    public static final int ID_NULL = 0;
    public static final String TAG = "ResourcesCompat";
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static abstract class FontCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public FontCallback() {
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

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public final void callbackFailAsync(int i2, @Nullable Handler handler) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, handler) == null) {
                if (handler == null) {
                    handler = new Handler(Looper.getMainLooper());
                }
                handler.post(new Runnable(this, i2) { // from class: androidx.core.content.res.ResourcesCompat.FontCallback.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ FontCallback this$0;
                    public final /* synthetic */ int val$reason;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Integer.valueOf(i2)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$reason = i2;
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
                if (handler == null) {
                    handler = new Handler(Looper.getMainLooper());
                }
                handler.post(new Runnable(this, typeface) { // from class: androidx.core.content.res.ResourcesCompat.FontCallback.1
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
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
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

        public abstract void onFontRetrievalFailed(int i2);

        public abstract void onFontRetrieved(@NonNull Typeface typeface);
    }

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
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
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
                            } catch (NoSuchMethodException e2) {
                                Log.i(ResourcesCompat.TAG, "Failed to retrieve rebase() method", e2);
                            }
                            sRebaseMethodFetched = true;
                        }
                        if (sRebaseMethod != null) {
                            try {
                                sRebaseMethod.invoke(theme, new Object[0]);
                            } catch (IllegalAccessException | InvocationTargetException e3) {
                                Log.i(ResourcesCompat.TAG, "Failed to invoke rebase() method via reflection", e3);
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
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static void rebase(@NonNull Resources.Theme theme) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65537, null, theme) == null) {
                int i2 = Build.VERSION.SDK_INT;
                if (i2 >= 29) {
                    ImplApi29.rebase(theme);
                } else if (i2 >= 23) {
                    ImplApi23.rebase(theme);
                }
            }
        }
    }

    public ResourcesCompat() {
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

    @ColorInt
    public static int getColor(@NonNull Resources resources, @ColorRes int i2, @Nullable Resources.Theme theme) throws Resources.NotFoundException {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65537, null, resources, i2, theme)) == null) {
            if (Build.VERSION.SDK_INT >= 23) {
                return resources.getColor(i2, theme);
            }
            return resources.getColor(i2);
        }
        return invokeLIL.intValue;
    }

    @Nullable
    public static ColorStateList getColorStateList(@NonNull Resources resources, @ColorRes int i2, @Nullable Resources.Theme theme) throws Resources.NotFoundException {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65538, null, resources, i2, theme)) == null) {
            if (Build.VERSION.SDK_INT >= 23) {
                return resources.getColorStateList(i2, theme);
            }
            return resources.getColorStateList(i2);
        }
        return (ColorStateList) invokeLIL.objValue;
    }

    @Nullable
    public static Drawable getDrawable(@NonNull Resources resources, @DrawableRes int i2, @Nullable Resources.Theme theme) throws Resources.NotFoundException {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65539, null, resources, i2, theme)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                return resources.getDrawable(i2, theme);
            }
            return resources.getDrawable(i2);
        }
        return (Drawable) invokeLIL.objValue;
    }

    @Nullable
    public static Drawable getDrawableForDensity(@NonNull Resources resources, @DrawableRes int i2, int i3, @Nullable Resources.Theme theme) throws Resources.NotFoundException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{resources, Integer.valueOf(i2), Integer.valueOf(i3), theme})) == null) {
            int i4 = Build.VERSION.SDK_INT;
            if (i4 >= 21) {
                return resources.getDrawableForDensity(i2, i3, theme);
            }
            if (i4 >= 15) {
                return resources.getDrawableForDensity(i2, i3);
            }
            return resources.getDrawable(i2);
        }
        return (Drawable) invokeCommon.objValue;
    }

    public static float getFloat(@NonNull Resources resources, @DimenRes int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(AdIconUtil.AD_TEXT_ID, null, resources, i2)) == null) {
            TypedValue typedValue = new TypedValue();
            resources.getValue(i2, typedValue, true);
            if (typedValue.type == 4) {
                return typedValue.getFloat();
            }
            throw new Resources.NotFoundException("Resource ID #0x" + Integer.toHexString(i2) + " type #0x" + Integer.toHexString(typedValue.type) + " is not valid");
        }
        return invokeLI.floatValue;
    }

    @Nullable
    public static Typeface getFont(@NonNull Context context, @FontRes int i2) throws Resources.NotFoundException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(AdIconUtil.BAIDU_LOGO_ID, null, context, i2)) == null) {
            if (context.isRestricted()) {
                return null;
            }
            return loadFont(context, i2, new TypedValue(), 0, null, null, false);
        }
        return (Typeface) invokeLI.objValue;
    }

    public static Typeface loadFont(@NonNull Context context, int i2, TypedValue typedValue, int i3, @Nullable FontCallback fontCallback, @Nullable Handler handler, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{context, Integer.valueOf(i2), typedValue, Integer.valueOf(i3), fontCallback, handler, Boolean.valueOf(z)})) == null) {
            Resources resources = context.getResources();
            resources.getValue(i2, typedValue, true);
            Typeface loadFont = loadFont(context, resources, typedValue, i2, i3, fontCallback, handler, z);
            if (loadFont == null && fontCallback == null) {
                throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(i2) + " could not be retrieved.");
            }
            return loadFont;
        }
        return (Typeface) invokeCommon.objValue;
    }

    public static void getFont(@NonNull Context context, @FontRes int i2, @NonNull FontCallback fontCallback, @Nullable Handler handler) throws Resources.NotFoundException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65544, null, context, i2, fontCallback, handler) == null) {
            Preconditions.checkNotNull(fontCallback);
            if (context.isRestricted()) {
                fontCallback.callbackFailAsync(-4, handler);
            } else {
                loadFont(context, i2, new TypedValue(), 0, fontCallback, handler, false);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00a7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Typeface loadFont(@NonNull Context context, Resources resources, TypedValue typedValue, int i2, int i3, @Nullable FontCallback fontCallback, @Nullable Handler handler, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, null, new Object[]{context, resources, typedValue, Integer.valueOf(i2), Integer.valueOf(i3), fontCallback, handler, Boolean.valueOf(z)})) == null) {
            CharSequence charSequence = typedValue.string;
            if (charSequence != null) {
                String charSequence2 = charSequence.toString();
                if (!charSequence2.startsWith("res/")) {
                    if (fontCallback != null) {
                        fontCallback.callbackFailAsync(-3, handler);
                    }
                    return null;
                }
                Typeface findFromCache = TypefaceCompat.findFromCache(resources, i2, i3);
                if (findFromCache != null) {
                    if (fontCallback != null) {
                        fontCallback.callbackSuccessAsync(findFromCache, handler);
                    }
                    return findFromCache;
                }
                try {
                    if (charSequence2.toLowerCase().endsWith(ActivityChooserModel.HISTORY_FILE_EXTENSION)) {
                        FontResourcesParserCompat.FamilyResourceEntry parse = FontResourcesParserCompat.parse(resources.getXml(i2), resources);
                        if (parse == null) {
                            Log.e(TAG, "Failed to find font-family tag");
                            if (fontCallback != null) {
                                fontCallback.callbackFailAsync(-3, handler);
                            }
                            return null;
                        }
                        return TypefaceCompat.createFromResourcesFamilyXml(context, parse, resources, i2, i3, fontCallback, handler, z);
                    }
                    Typeface createFromResourcesFontFile = TypefaceCompat.createFromResourcesFontFile(context, resources, i2, charSequence2, i3);
                    if (fontCallback != null) {
                        if (createFromResourcesFontFile != null) {
                            fontCallback.callbackSuccessAsync(createFromResourcesFontFile, handler);
                        } else {
                            fontCallback.callbackFailAsync(-3, handler);
                        }
                    }
                    return createFromResourcesFontFile;
                } catch (IOException e2) {
                    Log.e(TAG, "Failed to read xml resource " + charSequence2, e2);
                    if (fontCallback != null) {
                        fontCallback.callbackFailAsync(-3, handler);
                    }
                    return null;
                } catch (XmlPullParserException e3) {
                    Log.e(TAG, "Failed to parse xml resource " + charSequence2, e3);
                    if (fontCallback != null) {
                    }
                    return null;
                }
            }
            throw new Resources.NotFoundException("Resource \"" + resources.getResourceName(i2) + "\" (" + Integer.toHexString(i2) + ") is not a Font: " + typedValue);
        }
        return (Typeface) invokeCommon.objValue;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static Typeface getFont(@NonNull Context context, @FontRes int i2, TypedValue typedValue, int i3, @Nullable FontCallback fontCallback) throws Resources.NotFoundException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{context, Integer.valueOf(i2), typedValue, Integer.valueOf(i3), fontCallback})) == null) {
            if (context.isRestricted()) {
                return null;
            }
            return loadFont(context, i2, typedValue, i3, fontCallback, null, true);
        }
        return (Typeface) invokeCommon.objValue;
    }
}
