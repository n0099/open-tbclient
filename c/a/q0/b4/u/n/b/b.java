package c.a.q0.b4.u.n.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f16491a;

    /* renamed from: b  reason: collision with root package name */
    public Bitmap f16492b;

    /* renamed from: c  reason: collision with root package name */
    public Rect f16493c;

    public b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f16491a = context;
        this.f16493c = new Rect();
    }

    public void a(Canvas canvas, float f2, float f3) {
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{canvas, Float.valueOf(f2), Float.valueOf(f3)}) == null) || (bitmap = this.f16492b) == null) {
            return;
        }
        this.f16493c.left = (int) (f2 - (bitmap.getWidth() / 2));
        this.f16493c.right = (int) (f2 + (this.f16492b.getWidth() / 2));
        this.f16493c.top = (int) (f3 - (this.f16492b.getHeight() / 2));
        this.f16493c.bottom = (int) (f3 + (this.f16492b.getHeight() / 2));
        canvas.drawBitmap(this.f16492b, (Rect) null, this.f16493c, (Paint) null);
    }

    public boolean b(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) {
            if (motionEvent == null) {
                return false;
            }
            Rect rect = this.f16493c;
            return motionEvent.getX(0) >= ((float) rect.left) && motionEvent.getX(0) <= ((float) rect.right) && motionEvent.getY(0) >= ((float) rect.top) && motionEvent.getY(0) <= ((float) rect.bottom);
        }
        return invokeL.booleanValue;
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f16492b = BitmapHelper.getResBitmap(this.f16491a, i2);
        }
    }
}
