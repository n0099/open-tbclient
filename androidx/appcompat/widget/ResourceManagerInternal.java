package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat;
import androidx.appcompat.resources.R;
import androidx.collection.LongSparseArray;
import androidx.collection.LruCache;
import androidx.collection.SimpleArrayMap;
import androidx.collection.SparseArrayCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public final class ResourceManagerInternal {
    public static /* synthetic */ Interceptable $ic = null;
    public static final ColorFilterLruCache COLOR_FILTER_CACHE;
    public static final boolean DEBUG = false;
    public static final PorterDuff.Mode DEFAULT_MODE;
    public static ResourceManagerInternal INSTANCE = null;
    public static final String PLATFORM_VD_CLAZZ = "android.graphics.drawable.VectorDrawable";
    public static final String SKIP_DRAWABLE_TAG = "appcompat_skip_skip";
    public static final String TAG = "ResourceManagerInternal";
    public transient /* synthetic */ FieldHolder $fh;
    public SimpleArrayMap<String, InflateDelegate> mDelegates;
    public final WeakHashMap<Context, LongSparseArray<WeakReference<Drawable.ConstantState>>> mDrawableCaches;
    public boolean mHasCheckedVectorDrawableSetup;
    public ResourceManagerHooks mHooks;
    public SparseArrayCompat<String> mKnownDrawableIdTags;
    public WeakHashMap<Context, SparseArrayCompat<ColorStateList>> mTintLists;
    public TypedValue mTypedValue;

    @RequiresApi(11)
    /* loaded from: classes.dex */
    public static class AsldcInflateDelegate implements InflateDelegate {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public AsldcInflateDelegate() {
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

        @Override // androidx.appcompat.widget.ResourceManagerInternal.InflateDelegate
        public Drawable createFromXmlInner(@NonNull Context context, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, xmlPullParser, attributeSet, theme)) == null) {
                try {
                    return AnimatedStateListDrawableCompat.createFromXmlInner(context, context.getResources(), xmlPullParser, attributeSet, theme);
                } catch (Exception e2) {
                    Log.e("AsldcInflateDelegate", "Exception while inflating <animated-selector>", e2);
                    return null;
                }
            }
            return (Drawable) invokeLLLL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static class AvdcInflateDelegate implements InflateDelegate {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public AvdcInflateDelegate() {
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

        @Override // androidx.appcompat.widget.ResourceManagerInternal.InflateDelegate
        public Drawable createFromXmlInner(@NonNull Context context, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, xmlPullParser, attributeSet, theme)) == null) {
                try {
                    return AnimatedVectorDrawableCompat.createFromXmlInner(context, context.getResources(), xmlPullParser, attributeSet, theme);
                } catch (Exception e2) {
                    Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e2);
                    return null;
                }
            }
            return (Drawable) invokeLLLL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static class ColorFilterLruCache extends LruCache<Integer, PorterDuffColorFilter> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ColorFilterLruCache(int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public static int generateCacheKey(int i2, PorterDuff.Mode mode) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeIL = interceptable.invokeIL(65537, null, i2, mode)) == null) ? ((i2 + 31) * 31) + mode.hashCode() : invokeIL.intValue;
        }

        public PorterDuffColorFilter get(int i2, PorterDuff.Mode mode) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i2, mode)) == null) ? get(Integer.valueOf(generateCacheKey(i2, mode))) : (PorterDuffColorFilter) invokeIL.objValue;
        }

        public PorterDuffColorFilter put(int i2, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            InterceptResult invokeILL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeILL = interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, mode, porterDuffColorFilter)) == null) ? put(Integer.valueOf(generateCacheKey(i2, mode)), porterDuffColorFilter) : (PorterDuffColorFilter) invokeILL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public interface InflateDelegate {
        Drawable createFromXmlInner(@NonNull Context context, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public interface ResourceManagerHooks {
        Drawable createDrawableFor(@NonNull ResourceManagerInternal resourceManagerInternal, @NonNull Context context, @DrawableRes int i2);

        ColorStateList getTintListForDrawableRes(@NonNull Context context, @DrawableRes int i2);

        PorterDuff.Mode getTintModeForDrawableRes(int i2);

        boolean tintDrawable(@NonNull Context context, @DrawableRes int i2, @NonNull Drawable drawable);

        boolean tintDrawableUsingColorFilter(@NonNull Context context, @DrawableRes int i2, @NonNull Drawable drawable);
    }

    /* loaded from: classes.dex */
    public static class VdcInflateDelegate implements InflateDelegate {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public VdcInflateDelegate() {
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

        @Override // androidx.appcompat.widget.ResourceManagerInternal.InflateDelegate
        public Drawable createFromXmlInner(@NonNull Context context, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, xmlPullParser, attributeSet, theme)) == null) {
                try {
                    return VectorDrawableCompat.createFromXmlInner(context.getResources(), xmlPullParser, attributeSet, theme);
                } catch (Exception e2) {
                    Log.e("VdcInflateDelegate", "Exception while inflating <vector>", e2);
                    return null;
                }
            }
            return (Drawable) invokeLLLL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1155376348, "Landroidx/appcompat/widget/ResourceManagerInternal;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1155376348, "Landroidx/appcompat/widget/ResourceManagerInternal;");
                return;
            }
        }
        DEFAULT_MODE = PorterDuff.Mode.SRC_IN;
        COLOR_FILTER_CACHE = new ColorFilterLruCache(6);
    }

    public ResourceManagerInternal() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mDrawableCaches = new WeakHashMap<>(0);
    }

    private void addDelegate(@NonNull String str, @NonNull InflateDelegate inflateDelegate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, this, str, inflateDelegate) == null) {
            if (this.mDelegates == null) {
                this.mDelegates = new SimpleArrayMap<>();
            }
            this.mDelegates.put(str, inflateDelegate);
        }
    }

    private synchronized boolean addDrawableToCache(@NonNull Context context, long j, @NonNull Drawable drawable) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, this, new Object[]{context, Long.valueOf(j), drawable})) == null) {
            synchronized (this) {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    LongSparseArray<WeakReference<Drawable.ConstantState>> longSparseArray = this.mDrawableCaches.get(context);
                    if (longSparseArray == null) {
                        longSparseArray = new LongSparseArray<>();
                        this.mDrawableCaches.put(context, longSparseArray);
                    }
                    longSparseArray.put(j, new WeakReference<>(constantState));
                    return true;
                }
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }

    private void addTintListToCache(@NonNull Context context, @DrawableRes int i2, @NonNull ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(InputDeviceCompat.SOURCE_TRACKBALL, this, context, i2, colorStateList) == null) {
            if (this.mTintLists == null) {
                this.mTintLists = new WeakHashMap<>();
            }
            SparseArrayCompat<ColorStateList> sparseArrayCompat = this.mTintLists.get(context);
            if (sparseArrayCompat == null) {
                sparseArrayCompat = new SparseArrayCompat<>();
                this.mTintLists.put(context, sparseArrayCompat);
            }
            sparseArrayCompat.append(i2, colorStateList);
        }
    }

    private void checkVectorDrawableSetup(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, context) == null) || this.mHasCheckedVectorDrawableSetup) {
            return;
        }
        this.mHasCheckedVectorDrawableSetup = true;
        Drawable drawable = getDrawable(context, R.drawable.abc_vector_test);
        if (drawable == null || !isVectorDrawable(drawable)) {
            this.mHasCheckedVectorDrawableSetup = false;
            throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
        }
    }

    public static long createCacheKey(TypedValue typedValue) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, typedValue)) == null) ? (typedValue.assetCookie << 32) | typedValue.data : invokeL.longValue;
    }

    private Drawable createDrawableIfNeeded(@NonNull Context context, @DrawableRes int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65543, this, context, i2)) == null) {
            if (this.mTypedValue == null) {
                this.mTypedValue = new TypedValue();
            }
            TypedValue typedValue = this.mTypedValue;
            context.getResources().getValue(i2, typedValue, true);
            long createCacheKey = createCacheKey(typedValue);
            Drawable cachedDrawable = getCachedDrawable(context, createCacheKey);
            if (cachedDrawable != null) {
                return cachedDrawable;
            }
            ResourceManagerHooks resourceManagerHooks = this.mHooks;
            Drawable createDrawableFor = resourceManagerHooks == null ? null : resourceManagerHooks.createDrawableFor(this, context, i2);
            if (createDrawableFor != null) {
                createDrawableFor.setChangingConfigurations(typedValue.changingConfigurations);
                addDrawableToCache(context, createCacheKey, createDrawableFor);
            }
            return createDrawableFor;
        }
        return (Drawable) invokeLI.objValue;
    }

    public static PorterDuffColorFilter createTintFilter(ColorStateList colorStateList, PorterDuff.Mode mode, int[] iArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65544, null, colorStateList, mode, iArr)) == null) {
            if (colorStateList == null || mode == null) {
                return null;
            }
            return getPorterDuffColorFilter(colorStateList.getColorForState(iArr, 0), mode);
        }
        return (PorterDuffColorFilter) invokeLLL.objValue;
    }

    public static synchronized ResourceManagerInternal get() {
        InterceptResult invokeV;
        ResourceManagerInternal resourceManagerInternal;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            synchronized (ResourceManagerInternal.class) {
                if (INSTANCE == null) {
                    ResourceManagerInternal resourceManagerInternal2 = new ResourceManagerInternal();
                    INSTANCE = resourceManagerInternal2;
                    installDefaultInflateDelegates(resourceManagerInternal2);
                }
                resourceManagerInternal = INSTANCE;
            }
            return resourceManagerInternal;
        }
        return (ResourceManagerInternal) invokeV.objValue;
    }

    private synchronized Drawable getCachedDrawable(@NonNull Context context, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65546, this, context, j)) == null) {
            synchronized (this) {
                LongSparseArray<WeakReference<Drawable.ConstantState>> longSparseArray = this.mDrawableCaches.get(context);
                if (longSparseArray == null) {
                    return null;
                }
                WeakReference<Drawable.ConstantState> weakReference = longSparseArray.get(j);
                if (weakReference != null) {
                    Drawable.ConstantState constantState = weakReference.get();
                    if (constantState != null) {
                        return constantState.newDrawable(context.getResources());
                    }
                    longSparseArray.remove(j);
                }
                return null;
            }
        }
        return (Drawable) invokeLJ.objValue;
    }

    public static synchronized PorterDuffColorFilter getPorterDuffColorFilter(int i2, PorterDuff.Mode mode) {
        InterceptResult invokeIL;
        PorterDuffColorFilter porterDuffColorFilter;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65547, null, i2, mode)) == null) {
            synchronized (ResourceManagerInternal.class) {
                porterDuffColorFilter = COLOR_FILTER_CACHE.get(i2, mode);
                if (porterDuffColorFilter == null) {
                    porterDuffColorFilter = new PorterDuffColorFilter(i2, mode);
                    COLOR_FILTER_CACHE.put(i2, mode, porterDuffColorFilter);
                }
            }
            return porterDuffColorFilter;
        }
        return (PorterDuffColorFilter) invokeIL.objValue;
    }

    private ColorStateList getTintListFromCache(@NonNull Context context, @DrawableRes int i2) {
        InterceptResult invokeLI;
        SparseArrayCompat<ColorStateList> sparseArrayCompat;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65548, this, context, i2)) == null) {
            WeakHashMap<Context, SparseArrayCompat<ColorStateList>> weakHashMap = this.mTintLists;
            if (weakHashMap == null || (sparseArrayCompat = weakHashMap.get(context)) == null) {
                return null;
            }
            return sparseArrayCompat.get(i2);
        }
        return (ColorStateList) invokeLI.objValue;
    }

    public static void installDefaultInflateDelegates(@NonNull ResourceManagerInternal resourceManagerInternal) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65549, null, resourceManagerInternal) == null) || Build.VERSION.SDK_INT >= 24) {
            return;
        }
        resourceManagerInternal.addDelegate(VectorDrawableCompat.SHAPE_VECTOR, new VdcInflateDelegate());
        resourceManagerInternal.addDelegate(AnimatedVectorDrawableCompat.ANIMATED_VECTOR, new AvdcInflateDelegate());
        resourceManagerInternal.addDelegate("animated-selector", new AsldcInflateDelegate());
    }

    public static boolean isVectorDrawable(@NonNull Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65550, null, drawable)) == null) ? (drawable instanceof VectorDrawableCompat) || "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName()) : invokeL.booleanValue;
    }

    private Drawable loadDrawableFromDelegates(@NonNull Context context, @DrawableRes int i2) {
        InterceptResult invokeLI;
        int next;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65551, this, context, i2)) == null) {
            SimpleArrayMap<String, InflateDelegate> simpleArrayMap = this.mDelegates;
            if (simpleArrayMap == null || simpleArrayMap.isEmpty()) {
                return null;
            }
            SparseArrayCompat<String> sparseArrayCompat = this.mKnownDrawableIdTags;
            if (sparseArrayCompat != null) {
                String str = sparseArrayCompat.get(i2);
                if (SKIP_DRAWABLE_TAG.equals(str) || (str != null && this.mDelegates.get(str) == null)) {
                    return null;
                }
            } else {
                this.mKnownDrawableIdTags = new SparseArrayCompat<>();
            }
            if (this.mTypedValue == null) {
                this.mTypedValue = new TypedValue();
            }
            TypedValue typedValue = this.mTypedValue;
            Resources resources = context.getResources();
            resources.getValue(i2, typedValue, true);
            long createCacheKey = createCacheKey(typedValue);
            Drawable cachedDrawable = getCachedDrawable(context, createCacheKey);
            if (cachedDrawable != null) {
                return cachedDrawable;
            }
            CharSequence charSequence = typedValue.string;
            if (charSequence != null && charSequence.toString().endsWith(ActivityChooserModel.HISTORY_FILE_EXTENSION)) {
                try {
                    XmlResourceParser xml = resources.getXml(i2);
                    AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
                    while (true) {
                        next = xml.next();
                        if (next == 2 || next == 1) {
                            break;
                        }
                    }
                    if (next == 2) {
                        String name = xml.getName();
                        this.mKnownDrawableIdTags.append(i2, name);
                        InflateDelegate inflateDelegate = this.mDelegates.get(name);
                        if (inflateDelegate != null) {
                            cachedDrawable = inflateDelegate.createFromXmlInner(context, xml, asAttributeSet, context.getTheme());
                        }
                        if (cachedDrawable != null) {
                            cachedDrawable.setChangingConfigurations(typedValue.changingConfigurations);
                            addDrawableToCache(context, createCacheKey, cachedDrawable);
                        }
                    } else {
                        throw new XmlPullParserException("No start tag found");
                    }
                } catch (Exception e2) {
                    Log.e(TAG, "Exception while inflating drawable", e2);
                }
            }
            if (cachedDrawable == null) {
                this.mKnownDrawableIdTags.append(i2, SKIP_DRAWABLE_TAG);
            }
            return cachedDrawable;
        }
        return (Drawable) invokeLI.objValue;
    }

    private Drawable tintDrawable(@NonNull Context context, @DrawableRes int i2, boolean z, @NonNull Drawable drawable) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65552, this, new Object[]{context, Integer.valueOf(i2), Boolean.valueOf(z), drawable})) == null) {
            ColorStateList tintList = getTintList(context, i2);
            if (tintList != null) {
                if (DrawableUtils.canSafelyMutateDrawable(drawable)) {
                    drawable = drawable.mutate();
                }
                Drawable wrap = DrawableCompat.wrap(drawable);
                DrawableCompat.setTintList(wrap, tintList);
                PorterDuff.Mode tintMode = getTintMode(i2);
                if (tintMode != null) {
                    DrawableCompat.setTintMode(wrap, tintMode);
                    return wrap;
                }
                return wrap;
            }
            ResourceManagerHooks resourceManagerHooks = this.mHooks;
            if ((resourceManagerHooks == null || !resourceManagerHooks.tintDrawable(context, i2, drawable)) && !tintDrawableUsingColorFilter(context, i2, drawable) && z) {
                return null;
            }
            return drawable;
        }
        return (Drawable) invokeCommon.objValue;
    }

    public synchronized Drawable getDrawable(@NonNull Context context, @DrawableRes int i2) {
        InterceptResult invokeLI;
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, context, i2)) == null) {
            synchronized (this) {
                drawable = getDrawable(context, i2, false);
            }
            return drawable;
        }
        return (Drawable) invokeLI.objValue;
    }

    public synchronized ColorStateList getTintList(@NonNull Context context, @DrawableRes int i2) {
        InterceptResult invokeLI;
        ColorStateList tintListFromCache;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, context, i2)) == null) {
            synchronized (this) {
                tintListFromCache = getTintListFromCache(context, i2);
                if (tintListFromCache == null) {
                    tintListFromCache = this.mHooks == null ? null : this.mHooks.getTintListForDrawableRes(context, i2);
                    if (tintListFromCache != null) {
                        addTintListToCache(context, i2, tintListFromCache);
                    }
                }
            }
            return tintListFromCache;
        }
        return (ColorStateList) invokeLI.objValue;
    }

    public PorterDuff.Mode getTintMode(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            ResourceManagerHooks resourceManagerHooks = this.mHooks;
            if (resourceManagerHooks == null) {
                return null;
            }
            return resourceManagerHooks.getTintModeForDrawableRes(i2);
        }
        return (PorterDuff.Mode) invokeI.objValue;
    }

    public synchronized void onConfigurationChanged(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            synchronized (this) {
                LongSparseArray<WeakReference<Drawable.ConstantState>> longSparseArray = this.mDrawableCaches.get(context);
                if (longSparseArray != null) {
                    longSparseArray.clear();
                }
            }
        }
    }

    public synchronized Drawable onDrawableLoadedFromResources(@NonNull Context context, @NonNull VectorEnabledTintResources vectorEnabledTintResources, @DrawableRes int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048581, this, context, vectorEnabledTintResources, i2)) == null) {
            synchronized (this) {
                Drawable loadDrawableFromDelegates = loadDrawableFromDelegates(context, i2);
                if (loadDrawableFromDelegates == null) {
                    loadDrawableFromDelegates = vectorEnabledTintResources.superGetDrawable(i2);
                }
                if (loadDrawableFromDelegates != null) {
                    return tintDrawable(context, i2, false, loadDrawableFromDelegates);
                }
                return null;
            }
        }
        return (Drawable) invokeLLI.objValue;
    }

    public synchronized void setHooks(ResourceManagerHooks resourceManagerHooks) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, resourceManagerHooks) == null) {
            synchronized (this) {
                this.mHooks = resourceManagerHooks;
            }
        }
    }

    public boolean tintDrawableUsingColorFilter(@NonNull Context context, @DrawableRes int i2, @NonNull Drawable drawable) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048583, this, context, i2, drawable)) == null) {
            ResourceManagerHooks resourceManagerHooks = this.mHooks;
            return resourceManagerHooks != null && resourceManagerHooks.tintDrawableUsingColorFilter(context, i2, drawable);
        }
        return invokeLIL.booleanValue;
    }

    public synchronized Drawable getDrawable(@NonNull Context context, @DrawableRes int i2, boolean z) {
        InterceptResult invokeCommon;
        Drawable loadDrawableFromDelegates;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            synchronized (this) {
                checkVectorDrawableSetup(context);
                loadDrawableFromDelegates = loadDrawableFromDelegates(context, i2);
                if (loadDrawableFromDelegates == null) {
                    loadDrawableFromDelegates = createDrawableIfNeeded(context, i2);
                }
                if (loadDrawableFromDelegates == null) {
                    loadDrawableFromDelegates = ContextCompat.getDrawable(context, i2);
                }
                if (loadDrawableFromDelegates != null) {
                    loadDrawableFromDelegates = tintDrawable(context, i2, z, loadDrawableFromDelegates);
                }
                if (loadDrawableFromDelegates != null) {
                    DrawableUtils.fixDrawable(loadDrawableFromDelegates);
                }
            }
            return loadDrawableFromDelegates;
        }
        return (Drawable) invokeCommon.objValue;
    }

    public static void tintDrawable(Drawable drawable, TintInfo tintInfo, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65553, null, drawable, tintInfo, iArr) == null) {
            if (DrawableUtils.canSafelyMutateDrawable(drawable) && drawable.mutate() != drawable) {
                Log.d(TAG, "Mutated drawable is not the same instance as the input.");
                return;
            }
            if (!tintInfo.mHasTintList && !tintInfo.mHasTintMode) {
                drawable.clearColorFilter();
            } else {
                drawable.setColorFilter(createTintFilter(tintInfo.mHasTintList ? tintInfo.mTintList : null, tintInfo.mHasTintMode ? tintInfo.mTintMode : DEFAULT_MODE, iArr));
            }
            if (Build.VERSION.SDK_INT <= 23) {
                drawable.invalidateSelf();
            }
        }
    }
}
