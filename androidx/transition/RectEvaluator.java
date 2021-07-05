package androidx.transition;

import android.animation.TypeEvaluator;
import android.graphics.Rect;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class RectEvaluator implements TypeEvaluator<Rect> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Rect mRect;

    public RectEvaluator() {
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

    public RectEvaluator(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rect};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mRect = rect;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.animation.TypeEvaluator
    public Rect evaluate(float f2, Rect rect, Rect rect2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), rect, rect2})) == null) {
            int i2 = rect.left;
            int i3 = i2 + ((int) ((rect2.left - i2) * f2));
            int i4 = rect.top;
            int i5 = i4 + ((int) ((rect2.top - i4) * f2));
            int i6 = rect.right;
            int i7 = i6 + ((int) ((rect2.right - i6) * f2));
            int i8 = rect.bottom;
            int i9 = i8 + ((int) ((rect2.bottom - i8) * f2));
            Rect rect3 = this.mRect;
            if (rect3 == null) {
                return new Rect(i3, i5, i7, i9);
            }
            rect3.set(i3, i5, i7, i9);
            return this.mRect;
        }
        return (Rect) invokeCommon.objValue;
    }
}
