package c.a.e.l.e;

import android.view.animation.OvershootInterpolator;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class k extends OvershootInterpolator {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final float f3038a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(float f2) {
        super(f2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Float.valueOf(f2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Float) newInitContext.callArgs[0]).floatValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f3038a = f2;
    }

    @Override // android.view.animation.OvershootInterpolator, android.animation.TimeInterpolator
    public float getInterpolation(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f2)) == null) {
            float f3 = f2 - 1.0f;
            float f4 = this.f3038a;
            return ((-0.5f) * f3 * (((f4 + 1.0f) * f3) + f4)) + 1.0f;
        }
        return invokeF.floatValue;
    }
}
