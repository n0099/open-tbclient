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
import androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat;
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
import com.baidu.tieba.R;
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

    /* loaded from: classes.dex */
    public interface InflateDelegate {
        Drawable createFromXmlInner(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme);
    }

    /* loaded from: classes.dex */
    public interface ResourceManagerHooks {
        Drawable createDrawableFor(ResourceManagerInternal resourceManagerInternal, Context context, int i);

        ColorStateList getTintListForDrawableRes(Context context, int i);

        PorterDuff.Mode getTintModeForDrawableRes(int i);

        boolean tintDrawable(Context context, int i, Drawable drawable);

        boolean tintDrawableUsingColorFilter(Context context, int i, Drawable drawable);
    }

    /* loaded from: classes.dex */
    public static class AsldcInflateDelegate implements InflateDelegate {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public AsldcInflateDelegate() {
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

        @Override // androidx.appcompat.widget.ResourceManagerInternal.InflateDelegate
        public Drawable createFromXmlInner(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, xmlPullParser, attributeSet, theme)) == null) {
                try {
                    return AnimatedStateListDrawableCompat.createFromXmlInner(context, context.getResources(), xmlPullParser, attributeSet, theme);
                } catch (Exception e) {
                    Log.e("AsldcInflateDelegate", "Exception while inflating <animated-selector>", e);
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // androidx.appcompat.widget.ResourceManagerInternal.InflateDelegate
        public Drawable createFromXmlInner(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, xmlPullParser, attributeSet, theme)) == null) {
                try {
                    return AnimatedVectorDrawableCompat.createFromXmlInner(context, context.getResources(), xmlPullParser, attributeSet, theme);
                } catch (Exception e) {
                    Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e);
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
        public ColorFilterLruCache(int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public static int generateCacheKey(int i, PorterDuff.Mode mode) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(65537, null, i, mode)) == null) {
                return ((i + 31) * 31) + mode.hashCode();
            }
            return invokeIL.intValue;
        }

        public PorterDuffColorFilter get(int i, PorterDuff.Mode mode) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, mode)) == null) {
                return get(Integer.valueOf(generateCacheKey(i, mode)));
            }
            return (PorterDuffColorFilter) invokeIL.objValue;
        }

        public PorterDuffColorFilter put(int i, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            InterceptResult invokeILL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, mode, porterDuffColorFilter)) == null) {
                return put(Integer.valueOf(generateCacheKey(i, mode)), porterDuffColorFilter);
            }
            return (PorterDuffColorFilter) invokeILL.objValue;
        }
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // androidx.appcompat.widget.ResourceManagerInternal.InflateDelegate
        public Drawable createFromXmlInner(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, xmlPullParser, attributeSet, theme)) == null) {
                try {
                    return VectorDrawableCompat.createFromXmlInner(context.getResources(), xmlPullParser, attributeSet, theme);
                } catch (Exception e) {
                    Log.e("VdcInflateDelegate", "Exception while inflating <vector>", e);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mDrawableCaches = new WeakHashMap<>(0);
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

    private void addDelegate(String str, InflateDelegate inflateDelegate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, this, str, inflateDelegate) == null) {
            if (this.mDelegates == null) {
                this.mDelegates = new SimpleArrayMap<>();
            }
            this.mDelegates.put(str, inflateDelegate);
        }
    }

    public static synchronized PorterDuffColorFilter getPorterDuffColorFilter(int i, PorterDuff.Mode mode) {
        InterceptResult invokeIL;
        PorterDuffColorFilter porterDuffColorFilter;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65547, null, i, mode)) == null) {
            synchronized (ResourceManagerInternal.class) {
                porterDuffColorFilter = COLOR_FILTER_CACHE.get(i, mode);
                if (porterDuffColorFilter == null) {
                    porterDuffColorFilter = new PorterDuffColorFilter(i, mode);
                    COLOR_FILTER_CACHE.put(i, mode, porterDuffColorFilter);
                }
            }
            return porterDuffColorFilter;
        }
        return (PorterDuffColorFilter) invokeIL.objValue;
    }

    private ColorStateList getTintListFromCache(Context context, int i) {
        InterceptResult invokeLI;
        SparseArrayCompat<ColorStateList> sparseArrayCompat;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65548, this, context, i)) == null) {
            WeakHashMap<Context, SparseArrayCompat<ColorStateList>> weakHashMap = this.mTintLists;
            if (weakHashMap == null || (sparseArrayCompat = weakHashMap.get(context)) == null) {
                return null;
            }
            return sparseArrayCompat.get(i);
        }
        return (ColorStateList) invokeLI.objValue;
    }

    public synchronized Drawable getDrawable(Context context, int i) {
        InterceptResult invokeLI;
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, context, i)) == null) {
            synchronized (this) {
                drawable = getDrawable(context, i, false);
            }
            return drawable;
        }
        return (Drawable) invokeLI.objValue;
    }

    public synchronized ColorStateList getTintList(Context context, int i) {
        InterceptResult invokeLI;
        ColorStateList tintListFromCache;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, context, i)) == null) {
            synchronized (this) {
                tintListFromCache = getTintListFromCache(context, i);
                if (tintListFromCache == null) {
                    if (this.mHooks == null) {
                        tintListFromCache = null;
                    } else {
                        tintListFromCache = this.mHooks.getTintListForDrawableRes(context, i);
                    }
                    if (tintListFromCache != null) {
                        addTintListToCache(context, i, tintListFromCache);
                    }
                }
            }
            return tintListFromCache;
        }
        return (ColorStateList) invokeLI.objValue;
    }

    private synchronized boolean addDrawableToCache(Context context, long j, Drawable drawable) {
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

    public static void tintDrawable(Drawable drawable, TintInfo tintInfo, int[] iArr) {
        ColorStateList colorStateList;
        PorterDuff.Mode mode;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65553, null, drawable, tintInfo, iArr) == null) {
            if (DrawableUtils.canSafelyMutateDrawable(drawable) && drawable.mutate() != drawable) {
                Log.d(TAG, "Mutated drawable is not the same instance as the input.");
                return;
            }
            if (!tintInfo.mHasTintList && !tintInfo.mHasTintMode) {
                drawable.clearColorFilter();
            } else {
                if (tintInfo.mHasTintList) {
                    colorStateList = tintInfo.mTintList;
                } else {
                    colorStateList = null;
                }
                if (tintInfo.mHasTintMode) {
                    mode = tintInfo.mTintMode;
                } else {
                    mode = DEFAULT_MODE;
                }
                drawable.setColorFilter(createTintFilter(colorStateList, mode, iArr));
            }
            if (Build.VERSION.SDK_INT <= 23) {
                drawable.invalidateSelf();
            }
        }
    }

    public synchronized Drawable getDrawable(Context context, int i, boolean z) {
        InterceptResult invokeCommon;
        Drawable loadDrawableFromDelegates;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            synchronized (this) {
                checkVectorDrawableSetup(context);
                loadDrawableFromDelegates = loadDrawableFromDelegates(context, i);
                if (loadDrawableFromDelegates == null) {
                    loadDrawableFromDelegates = createDrawableIfNeeded(context, i);
                }
                if (loadDrawableFromDelegates == null) {
                    loadDrawableFromDelegates = ContextCompat.getDrawable(context, i);
                }
                if (loadDrawableFromDelegates != null) {
                    loadDrawableFromDelegates = tintDrawable(context, i, z, loadDrawableFromDelegates);
                }
                if (loadDrawableFromDelegates != null) {
                    DrawableUtils.fixDrawable(loadDrawableFromDelegates);
                }
            }
            return loadDrawableFromDelegates;
        }
        return (Drawable) invokeCommon.objValue;
    }

    private void addTintListToCache(Context context, int i, ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(InputDeviceCompat.SOURCE_TRACKBALL, this, context, i, colorStateList) == null) {
            if (this.mTintLists == null) {
                this.mTintLists = new WeakHashMap<>();
            }
            SparseArrayCompat<ColorStateList> sparseArrayCompat = this.mTintLists.get(context);
            if (sparseArrayCompat == null) {
                sparseArrayCompat = new SparseArrayCompat<>();
                this.mTintLists.put(context, sparseArrayCompat);
            }
            sparseArrayCompat.append(i, colorStateList);
        }
    }

    public static PorterDuffColorFilter createTintFilter(ColorStateList colorStateList, PorterDuff.Mode mode, int[] iArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65544, null, colorStateList, mode, iArr)) == null) {
            if (colorStateList != null && mode != null) {
                return getPorterDuffColorFilter(colorStateList.getColorForState(iArr, 0), mode);
            }
            return null;
        }
        return (PorterDuffColorFilter) invokeLLL.objValue;
    }

    public synchronized Drawable onDrawableLoadedFromResources(Context context, VectorEnabledTintResources vectorEnabledTintResources, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048581, this, context, vectorEnabledTintResources, i)) == null) {
            synchronized (this) {
                Drawable loadDrawableFromDelegates = loadDrawableFromDelegates(context, i);
                if (loadDrawableFromDelegates == null) {
                    loadDrawableFromDelegates = vectorEnabledTintResources.superGetDrawable(i);
                }
                if (loadDrawableFromDelegates != null) {
                    return tintDrawable(context, i, false, loadDrawableFromDelegates);
                }
                return null;
            }
        }
        return (Drawable) invokeLLI.objValue;
    }

    public boolean tintDrawableUsingColorFilter(Context context, int i, Drawable drawable) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048583, this, context, i, drawable)) == null) {
            ResourceManagerHooks resourceManagerHooks = this.mHooks;
            if (resourceManagerHooks != null && resourceManagerHooks.tintDrawableUsingColorFilter(context, i, drawable)) {
                return true;
            }
            return false;
        }
        return invokeLIL.booleanValue;
    }

    private void checkVectorDrawableSetup(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65541, this, context) != null) || this.mHasCheckedVectorDrawableSetup) {
            return;
        }
        this.mHasCheckedVectorDrawableSetup = true;
        Drawable drawable = getDrawable(context, R.drawable.obfuscated_res_0x7f0800b4);
        if (drawable != null && isVectorDrawable(drawable)) {
            return;
        }
        this.mHasCheckedVectorDrawableSetup = false;
        throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
    }

    public static long createCacheKey(TypedValue typedValue) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, typedValue)) == null) {
            return (typedValue.assetCookie << 32) | typedValue.data;
        }
        return invokeL.longValue;
    }

    public static boolean isVectorDrawable(Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, drawable)) == null) {
            if (!(drawable instanceof VectorDrawableCompat) && !"android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName())) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public PorterDuff.Mode getTintMode(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            ResourceManagerHooks resourceManagerHooks = this.mHooks;
            if (resourceManagerHooks == null) {
                return null;
            }
            return resourceManagerHooks.getTintModeForDrawableRes(i);
        }
        return (PorterDuff.Mode) invokeI.objValue;
    }

    public synchronized void onConfigurationChanged(Context context) {
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

    public synchronized void setHooks(ResourceManagerHooks resourceManagerHooks) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, resourceManagerHooks) == null) {
            synchronized (this) {
                this.mHooks = resourceManagerHooks;
            }
        }
    }

    private Drawable createDrawableIfNeeded(Context context, int i) {
        InterceptResult invokeLI;
        Drawable createDrawableFor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65543, this, context, i)) == null) {
            if (this.mTypedValue == null) {
                this.mTypedValue = new TypedValue();
            }
            TypedValue typedValue = this.mTypedValue;
            context.getResources().getValue(i, typedValue, true);
            long createCacheKey = createCacheKey(typedValue);
            Drawable cachedDrawable = getCachedDrawable(context, createCacheKey);
            if (cachedDrawable != null) {
                return cachedDrawable;
            }
            ResourceManagerHooks resourceManagerHooks = this.mHooks;
            if (resourceManagerHooks == null) {
                createDrawableFor = null;
            } else {
                createDrawableFor = resourceManagerHooks.createDrawableFor(this, context, i);
            }
            if (createDrawableFor != null) {
                createDrawableFor.setChangingConfigurations(typedValue.changingConfigurations);
                addDrawableToCache(context, createCacheKey, createDrawableFor);
            }
            return createDrawableFor;
        }
        return (Drawable) invokeLI.objValue;
    }

    private synchronized Drawable getCachedDrawable(Context context, long j) {
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

    public static void installDefaultInflateDelegates(ResourceManagerInternal resourceManagerInternal) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65549, null, resourceManagerInternal) == null) && Build.VERSION.SDK_INT < 24) {
            resourceManagerInternal.addDelegate(VectorDrawableCompat.SHAPE_VECTOR, new VdcInflateDelegate());
            resourceManagerInternal.addDelegate(AnimatedVectorDrawableCompat.ANIMATED_VECTOR, new AvdcInflateDelegate());
            resourceManagerInternal.addDelegate("animated-selector", new AsldcInflateDelegate());
        }
    }

    private Drawable loadDrawableFromDelegates(Context context, int i) {
        InterceptResult invokeLI;
        int next;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65551, this, context, i)) == null) {
            SimpleArrayMap<String, InflateDelegate> simpleArrayMap = this.mDelegates;
            if (simpleArrayMap == null || simpleArrayMap.isEmpty()) {
                return null;
            }
            SparseArrayCompat<String> sparseArrayCompat = this.mKnownDrawableIdTags;
            if (sparseArrayCompat != null) {
                String str = sparseArrayCompat.get(i);
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
            resources.getValue(i, typedValue, true);
            long createCacheKey = createCacheKey(typedValue);
            Drawable cachedDrawable = getCachedDrawable(context, createCacheKey);
            if (cachedDrawable != null) {
                return cachedDrawable;
            }
            CharSequence charSequence = typedValue.string;
            if (charSequence != null && charSequence.toString().endsWith(ActivityChooserModel.HISTORY_FILE_EXTENSION)) {
                try {
                    XmlResourceParser xml = resources.getXml(i);
                    AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
                    while (true) {
                        next = xml.next();
                        if (next == 2 || next == 1) {
                            break;
                        }
                    }
                    if (next == 2) {
                        String name = xml.getName();
                        this.mKnownDrawableIdTags.append(i, name);
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
                } catch (Exception e) {
                    Log.e(TAG, "Exception while inflating drawable", e);
                }
            }
            if (cachedDrawable == null) {
                this.mKnownDrawableIdTags.append(i, SKIP_DRAWABLE_TAG);
            }
            return cachedDrawable;
        }
        return (Drawable) invokeLI.objValue;
    }

    private Drawable tintDrawable(Context context, int i, boolean z, Drawable drawable) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65552, this, new Object[]{context, Integer.valueOf(i), Boolean.valueOf(z), drawable})) == null) {
            ColorStateList tintList = getTintList(context, i);
            if (tintList != null) {
                if (DrawableUtils.canSafelyMutateDrawable(drawable)) {
                    drawable = drawable.mutate();
                }
                Drawable wrap = DrawableCompat.wrap(drawable);
                DrawableCompat.setTintList(wrap, tintList);
                PorterDuff.Mode tintMode = getTintMode(i);
                if (tintMode != null) {
                    DrawableCompat.setTintMode(wrap, tintMode);
                    return wrap;
                }
                return wrap;
            }
            ResourceManagerHooks resourceManagerHooks = this.mHooks;
            if ((resourceManagerHooks == null || !resourceManagerHooks.tintDrawable(context, i, drawable)) && !tintDrawableUsingColorFilter(context, i, drawable) && z) {
                return null;
            }
            return drawable;
        }
        return (Drawable) invokeCommon.objValue;
    }
}
