package c.a.t0.p4.e0.n.b;

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
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public Bitmap f21423b;

    /* renamed from: c  reason: collision with root package name */
    public Rect f21424c;

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
        this.a = context;
        this.f21424c = new Rect();
    }

    public void a(Canvas canvas, float f2, float f3) {
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{canvas, Float.valueOf(f2), Float.valueOf(f3)}) == null) || (bitmap = this.f21423b) == null) {
            return;
        }
        this.f21424c.left = (int) (f2 - (bitmap.getWidth() / 2));
        this.f21424c.right = (int) (f2 + (this.f21423b.getWidth() / 2));
        this.f21424c.top = (int) (f3 - (this.f21423b.getHeight() / 2));
        this.f21424c.bottom = (int) (f3 + (this.f21423b.getHeight() / 2));
        canvas.drawBitmap(this.f21423b, (Rect) null, this.f21424c, (Paint) null);
    }

    public boolean b(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) {
            if (motionEvent == null) {
                return false;
            }
            Rect rect = this.f21424c;
            return motionEvent.getX(0) >= ((float) rect.left) && motionEvent.getX(0) <= ((float) rect.right) && motionEvent.getY(0) >= ((float) rect.top) && motionEvent.getY(0) <= ((float) rect.bottom);
        }
        return invokeL.booleanValue;
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f21423b = BitmapHelper.getResBitmap(this.a, i2);
        }
    }
}
