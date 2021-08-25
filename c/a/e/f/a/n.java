package c.a.e.f.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.widget.ImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class n extends k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Rect v;

    public n() {
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
        this.v = new Rect();
    }

    @Override // c.a.e.f.a.c, c.a.e.f.a.a
    public void h(Canvas canvas, d dVar, ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, canvas, dVar, imageView) == null) {
            Matrix matrix = this.f2708e;
            if (matrix != null) {
                canvas.concat(matrix);
            }
            canvas.save();
            if (this.u) {
                try {
                    canvas.clipPath(this.r);
                } catch (Error unused) {
                }
            }
            if (dVar.e()) {
                Bitmap bitmap = dVar.f2717a.getBitmap();
                this.v.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
                canvas.drawBitmap(bitmap, this.v, this.f2709f, this.f2705b);
            } else {
                this.v.set(0, 0, dVar.b(), dVar.a());
                dVar.f2718b.g(canvas, this.v, this.f2709f, this.f2705b);
            }
            canvas.restore();
        }
    }
}
