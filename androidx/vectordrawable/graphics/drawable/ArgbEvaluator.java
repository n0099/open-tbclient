package androidx.vectordrawable.graphics.drawable;

import android.animation.TypeEvaluator;
import androidx.annotation.RestrictTo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class ArgbEvaluator implements TypeEvaluator {
    public static /* synthetic */ Interceptable $ic;
    public static final ArgbEvaluator sInstance;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(657197465, "Landroidx/vectordrawable/graphics/drawable/ArgbEvaluator;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(657197465, "Landroidx/vectordrawable/graphics/drawable/ArgbEvaluator;");
                return;
            }
        }
        sInstance = new ArgbEvaluator();
    }

    public ArgbEvaluator() {
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

    public static ArgbEvaluator getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? sInstance : (ArgbEvaluator) invokeV.objValue;
    }

    @Override // android.animation.TypeEvaluator
    public Object evaluate(float f, Object obj, Object obj2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f), obj, obj2})) == null) {
            int intValue = ((Integer) obj).intValue();
            float f2 = ((intValue >> 24) & 255) / 255.0f;
            int intValue2 = ((Integer) obj2).intValue();
            float pow = (float) Math.pow(((intValue >> 16) & 255) / 255.0f, 2.2d);
            float pow2 = (float) Math.pow(((intValue >> 8) & 255) / 255.0f, 2.2d);
            float pow3 = (float) Math.pow((intValue & 255) / 255.0f, 2.2d);
            return Integer.valueOf((Math.round(((float) Math.pow(pow + ((((float) Math.pow(((intValue2 >> 16) & 255) / 255.0f, 2.2d)) - pow) * f), 0.45454545454545453d)) * 255.0f) << 16) | (Math.round((f2 + (((((intValue2 >> 24) & 255) / 255.0f) - f2) * f)) * 255.0f) << 24) | (Math.round(((float) Math.pow(pow2 + ((((float) Math.pow(((intValue2 >> 8) & 255) / 255.0f, 2.2d)) - pow2) * f), 0.45454545454545453d)) * 255.0f) << 8) | Math.round(((float) Math.pow(pow3 + (f * (((float) Math.pow((intValue2 & 255) / 255.0f, 2.2d)) - pow3)), 0.45454545454545453d)) * 255.0f));
        }
        return invokeCommon.objValue;
    }
}
