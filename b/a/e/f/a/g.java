package b.a.e.f.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.widget.ImageView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class g extends j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Paint v;
    public final Paint w;
    public final Rect x;
    public final Rect y;

    public g() {
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
        this.v = new Paint();
        this.w = new Paint();
        this.x = new Rect(0, 0, 0, 0);
        this.y = new Rect(0, 0, 0, 0);
        this.v.setColor(-16777216);
        this.v.setStyle(Paint.Style.FILL);
        this.v.setAntiAlias(true);
        this.w.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    @Override // b.a.e.f.a.c, b.a.e.f.a.a
    public void h(Canvas canvas, d dVar, ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, canvas, dVar, imageView) == null) {
            Matrix matrix = this.f2175e;
            if (matrix != null) {
                canvas.concat(matrix);
            }
            if (dVar.e()) {
                Bitmap bitmap = dVar.f2184a.getBitmap();
                if (this.u) {
                    v(canvas, bitmap);
                    return;
                }
                this.y.set(0, 0, dVar.b(), dVar.a());
                dVar.f2185b.g(canvas, this.y, this.f2176f, this.f2172b);
            } else if (dVar.d()) {
                if (this.u) {
                    v(canvas, dVar.f2185b.p());
                    return;
                }
                this.y.set(0, 0, dVar.b(), dVar.a());
                dVar.f2185b.g(canvas, this.y, this.f2176f, this.f2172b);
            } else {
                this.y.set(0, 0, dVar.b(), dVar.a());
                dVar.f2185b.g(canvas, this.y, this.f2176f, this.f2172b);
            }
        }
    }

    public void v(Canvas canvas, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas, bitmap) == null) {
            this.y.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            this.x.set(0, 0, (int) this.f2176f.width(), (int) this.f2176f.height());
            canvas.save();
            canvas.drawARGB(0, 0, 0, 0);
            canvas.drawPath(this.r, this.v);
            canvas.drawBitmap(bitmap, this.y, this.f2176f, this.w);
            canvas.restore();
        }
    }
}
