package c.a.p0.a.a0.a.j;

import android.graphics.Paint;
import android.graphics.Path;
import android.text.TextPaint;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.canvas.view.CanvasView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Stack;
/* loaded from: classes.dex */
public class b implements Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Stack<b> f4391e;

    /* renamed from: f  reason: collision with root package name */
    public Paint f4392f;

    /* renamed from: g  reason: collision with root package name */
    public Paint f4393g;

    /* renamed from: h  reason: collision with root package name */
    public Paint f4394h;

    /* renamed from: i  reason: collision with root package name */
    public TextPaint f4395i;

    /* renamed from: j  reason: collision with root package name */
    public Path f4396j;
    public boolean k;
    public CanvasView l;
    public k0 m;
    public int n;
    public int o;
    public int p;
    public int q;

    public b(CanvasView canvasView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {canvasView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f4391e = new Stack<>();
        this.f4392f = new Paint();
        this.f4393g = new Paint();
        this.f4394h = new Paint();
        this.f4395i = new TextPaint();
        this.f4396j = new Path();
        this.k = false;
        this.n = -1;
        this.o = 0;
        this.p = 0;
        this.q = -16777216;
        this.l = canvasView;
        g();
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.p : invokeV.intValue;
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.p = i2;
        }
    }

    public void f(Paint paint) {
        k0 k0Var;
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, paint) == null) || paint == null) {
            return;
        }
        if (this.l != null && (k0Var = this.m) != null && (iVar = k0Var.f4447h) != null && !iVar.c()) {
            k0 k0Var2 = this.m;
            paint.setShadowLayer(k0Var2.f4446g, k0Var2.f4444e, k0Var2.f4445f, k0Var2.f4447h.a());
        }
        int i2 = this.n;
        if (i2 < 0 || i2 > 255) {
            return;
        }
        paint.setAlpha(Math.min((paint.getAlpha() * this.n) >> 8, 255));
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.q = -16777216;
            this.f4393g.setStyle(Paint.Style.STROKE);
            this.f4392f.setColor(-16777216);
            this.f4393g.setColor(-16777216);
            this.f4394h.setColor(-16777216);
            this.f4395i.setColor(-16777216);
            this.f4393g.setStrokeWidth(c.a.p0.a.v2.n0.g(1.0f));
            this.f4393g.setAntiAlias(true);
            this.f4395i.setAntiAlias(true);
            this.f4394h.setAntiAlias(true);
            this.f4396j.reset();
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f4391e.empty()) {
            return;
        }
        b pop = this.f4391e.pop();
        this.f4392f = pop.f4392f;
        this.f4393g = pop.f4393g;
        this.f4394h = pop.f4394h;
        this.f4395i = pop.f4395i;
        this.f4396j = pop.f4396j;
        this.k = pop.k;
        this.f4391e = pop.f4391e;
        this.m = pop.m;
        this.n = pop.n;
        this.o = pop.o;
        this.p = pop.p;
        this.q = pop.q;
    }

    public void i() throws CloneNotSupportedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            b bVar = (b) super.clone();
            bVar.f4392f = new Paint(this.f4392f);
            bVar.f4393g = new Paint(this.f4393g);
            bVar.f4394h = new Paint(this.f4394h);
            bVar.f4395i = new TextPaint(this.f4395i);
            bVar.f4396j = new Path(this.f4396j);
            bVar.o = this.o;
            bVar.p = this.p;
            bVar.q = this.q;
            this.f4391e.push(bVar);
        }
    }
}
