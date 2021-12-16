package c.a.d.g.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.widget.ImageView;
import com.baidu.adp.newwidget.ImageView.DrawerArgs;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class c extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Rect q;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.q = new Rect();
    }

    @Override // c.a.d.g.a.a
    public void a(d dVar, ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, dVar, imageView) == null) {
            DrawerArgs drawerArgs = this.f2718k;
            if (drawerArgs.f32073c) {
                float f2 = drawerArgs.f32074d / 2.0f;
                if (!drawerArgs.f32077g) {
                    this.f2714g.set(f2, f2, imageView.getWidth() - f2, imageView.getHeight() - f2);
                    return;
                }
                int width = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
                int height = (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
                RectF rectF = this.f2713f;
                PointF b2 = b(rectF.left, rectF.top, this.f2712e);
                RectF rectF2 = this.f2713f;
                PointF b3 = b(rectF2.right, rectF2.bottom, this.f2712e);
                this.f2714g.set(Math.max((int) b2.x, 0) + f2, Math.max((int) b2.y, 0) + f2, Math.min((int) b3.x, width) - f2, Math.min((int) b3.y, height) - f2);
            }
        }
    }

    @Override // c.a.d.g.a.a
    public void f(Canvas canvas, ImageView imageView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas, imageView) == null) && this.f2718k.f32073c) {
            canvas.drawRect(this.f2714g, this.f2710c);
        }
    }

    @Override // c.a.d.g.a.a
    public void h(Canvas canvas, d dVar, ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, canvas, dVar, imageView) == null) {
            Matrix matrix = this.f2712e;
            if (matrix != null) {
                canvas.concat(matrix);
            }
            if (dVar.e()) {
                Bitmap bitmap = dVar.a.getBitmap();
                this.q.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
                canvas.drawBitmap(bitmap, this.q, this.f2713f, this.f2709b);
            } else if (dVar.d()) {
                this.q.set(0, 0, dVar.b(), dVar.a());
                dVar.f2721b.g(canvas, this.q, this.f2713f, this.f2709b);
            }
        }
    }

    @Override // c.a.d.g.a.a
    public void i(Canvas canvas, ImageView imageView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, canvas, imageView) == null) || this.f2718k.m == 0) {
            return;
        }
        int scrollX = imageView.getScrollX();
        int scrollY = imageView.getScrollY();
        canvas.translate(scrollX, scrollY);
        this.n.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
        this.f2711d.setColor(this.f2718k.m);
        canvas.drawRect(this.n, this.f2711d);
        canvas.translate(-scrollX, -scrollY);
    }
}
