package androidx.constraintlayout.motion.widget;

import android.graphics.RectF;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
/* loaded from: classes.dex */
public abstract class KeyPositionBase extends Key {
    public static /* synthetic */ Interceptable $ic = null;
    public static final float SELECTION_SLOPE = 20.0f;
    public transient /* synthetic */ FieldHolder $fh;
    public int mCurveFit;

    public KeyPositionBase() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mCurveFit = Key.UNSET;
    }

    public abstract void calcPosition(int i, int i2, float f, float f2, float f3, float f4);

    @Override // androidx.constraintlayout.motion.widget.Key
    public void getAttributeNames(HashSet<String> hashSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hashSet) == null) {
        }
    }

    public abstract float getPositionX();

    public abstract float getPositionY();

    public abstract boolean intersects(int i, int i2, RectF rectF, RectF rectF2, float f, float f2);

    public abstract void positionAttributes(View view2, RectF rectF, RectF rectF2, float f, float f2, String[] strArr, float[] fArr);
}
