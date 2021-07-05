package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.DisplayMetrics;
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
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class VectorEnabledTintResources extends Resources {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MAX_SDK_WHERE_REQUIRED = 20;
    public static boolean sCompatVectorFromResourcesEnabled;
    public transient /* synthetic */ FieldHolder $fh;
    public final WeakReference<Context> mContextRef;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1317823734, "Landroidx/appcompat/widget/VectorEnabledTintResources;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1317823734, "Landroidx/appcompat/widget/VectorEnabledTintResources;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VectorEnabledTintResources(@NonNull Context context, @NonNull Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, resources};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((AssetManager) objArr2[0], (DisplayMetrics) objArr2[1], (Configuration) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mContextRef = new WeakReference<>(context);
    }

    public static boolean isCompatVectorFromResourcesEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? sCompatVectorFromResourcesEnabled : invokeV.booleanValue;
    }

    public static void setCompatVectorFromResourcesEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65539, null, z) == null) {
            sCompatVectorFromResourcesEnabled = z;
        }
    }

    public static boolean shouldBeUsed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65540, null)) == null) ? isCompatVectorFromResourcesEnabled() && Build.VERSION.SDK_INT <= 20 : invokeV.booleanValue;
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i2) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            Context context = this.mContextRef.get();
            if (context != null) {
                return ResourceManagerInternal.get().onDrawableLoadedFromResources(context, this, i2);
            }
            return super.getDrawable(i2);
        }
        return (Drawable) invokeI.objValue;
    }

    public final Drawable superGetDrawable(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? super.getDrawable(i2) : (Drawable) invokeI.objValue;
    }
}
