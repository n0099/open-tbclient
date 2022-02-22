package c.a.d.h.a;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class l extends k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Path t;
    public boolean u;
    public Rect v;

    public l() {
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

    @Override // c.a.d.h.a.a
    public void e(Canvas canvas, Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, canvas, drawable) == null) {
            canvas.save();
            r(drawable.getBounds());
            try {
                canvas.clipPath(this.t);
            } catch (Exception unused) {
            }
            drawable.draw(canvas);
            canvas.restore();
        }
    }

    public final void r(Rect rect) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rect) == null) || rect == null) {
            return;
        }
        boolean z = true;
        boolean z2 = this.t == null || this.u != this.k.f31435b;
        Rect rect2 = this.v;
        if (rect2 != null && rect2.contains(rect)) {
            z = z2;
        }
        this.u = this.k.f31435b;
        if (z) {
            this.v = rect;
            Path path = new Path();
            this.t = path;
            if (this.u) {
                this.t.addCircle((rect.right + rect.left) / 2.0f, (rect.top + rect.bottom) / 2.0f, Math.min(rect.width(), rect.height()) / 2.0f, Path.Direction.CCW);
            } else {
                path.addRoundRect(new RectF(rect), this.k.a, Path.Direction.CW);
            }
            this.t.close();
        }
    }
}
