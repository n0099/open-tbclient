package c.a.n0.k.r;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.baidu.swan.menu.viewpager.PointPageIndicator;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class a extends PointPageIndicator {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public a b(Drawable drawable, Drawable drawable2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, drawable, drawable2)) == null) {
            this.mNormalDrawable = drawable;
            this.mSelectDrawable = drawable2;
            this.mNormalPointRect.set(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            this.mSelectPointRect.set(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
            return this;
        }
        return (a) invokeLL.objValue;
    }

    @Override // com.baidu.swan.menu.viewpager.PointPageIndicator
    public /* bridge */ /* synthetic */ PointPageIndicator setPointDrawable(Drawable drawable, Drawable drawable2) {
        b(drawable, drawable2);
        return this;
    }
}
