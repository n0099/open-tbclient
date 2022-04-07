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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mRect = rect;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.animation.TypeEvaluator
    public Rect evaluate(float f, Rect rect, Rect rect2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f), rect, rect2})) == null) {
            int i = rect.left;
            int i2 = i + ((int) ((rect2.left - i) * f));
            int i3 = rect.top;
            int i4 = i3 + ((int) ((rect2.top - i3) * f));
            int i5 = rect.right;
            int i6 = i5 + ((int) ((rect2.right - i5) * f));
            int i7 = rect.bottom;
            int i8 = i7 + ((int) ((rect2.bottom - i7) * f));
            Rect rect3 = this.mRect;
            if (rect3 == null) {
                return new Rect(i2, i4, i6, i8);
            }
            rect3.set(i2, i4, i6, i8);
            return this.mRect;
        }
        return (Rect) invokeCommon.objValue;
    }
}
