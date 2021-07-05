package androidx.appcompat.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class TintContextWrapper extends ContextWrapper {
    public static /* synthetic */ Interceptable $ic;
    public static final Object CACHE_LOCK;
    public static ArrayList<WeakReference<TintContextWrapper>> sCache;
    public transient /* synthetic */ FieldHolder $fh;
    public final Resources mResources;
    public final Resources.Theme mTheme;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1093603785, "Landroidx/appcompat/widget/TintContextWrapper;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1093603785, "Landroidx/appcompat/widget/TintContextWrapper;");
                return;
            }
        }
        CACHE_LOCK = new Object();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TintContextWrapper(@NonNull Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (VectorEnabledTintResources.shouldBeUsed()) {
            VectorEnabledTintResources vectorEnabledTintResources = new VectorEnabledTintResources(this, context.getResources());
            this.mResources = vectorEnabledTintResources;
            Resources.Theme newTheme = vectorEnabledTintResources.newTheme();
            this.mTheme = newTheme;
            newTheme.setTo(context.getTheme());
            return;
        }
        this.mResources = new TintResources(this, context.getResources());
        this.mTheme = null;
    }

    public static boolean shouldWrap(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if ((context instanceof TintContextWrapper) || (context.getResources() instanceof TintResources) || (context.getResources() instanceof VectorEnabledTintResources)) {
                return false;
            }
            return Build.VERSION.SDK_INT < 21 || VectorEnabledTintResources.shouldBeUsed();
        }
        return invokeL.booleanValue;
    }

    public static Context wrap(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (shouldWrap(context)) {
                synchronized (CACHE_LOCK) {
                    if (sCache == null) {
                        sCache = new ArrayList<>();
                    } else {
                        for (int size = sCache.size() - 1; size >= 0; size--) {
                            WeakReference<TintContextWrapper> weakReference = sCache.get(size);
                            if (weakReference == null || weakReference.get() == null) {
                                sCache.remove(size);
                            }
                        }
                        for (int size2 = sCache.size() - 1; size2 >= 0; size2--) {
                            WeakReference<TintContextWrapper> weakReference2 = sCache.get(size2);
                            TintContextWrapper tintContextWrapper = weakReference2 != null ? weakReference2.get() : null;
                            if (tintContextWrapper != null && tintContextWrapper.getBaseContext() == context) {
                                return tintContextWrapper;
                            }
                        }
                    }
                    TintContextWrapper tintContextWrapper2 = new TintContextWrapper(context);
                    sCache.add(new WeakReference<>(tintContextWrapper2));
                    return tintContextWrapper2;
                }
            }
            return context;
        }
        return (Context) invokeL.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mResources.getAssets() : (AssetManager) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mResources : (Resources) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Resources.Theme theme = this.mTheme;
            return theme == null ? super.getTheme() : theme;
        }
        return (Resources.Theme) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            Resources.Theme theme = this.mTheme;
            if (theme == null) {
                super.setTheme(i2);
            } else {
                theme.applyStyle(i2, true);
            }
        }
    }
}
