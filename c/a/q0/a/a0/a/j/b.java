package c.a.q0.a.a0.a.j;

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
    public Stack<b> f4443e;

    /* renamed from: f  reason: collision with root package name */
    public Paint f4444f;

    /* renamed from: g  reason: collision with root package name */
    public Paint f4445g;

    /* renamed from: h  reason: collision with root package name */
    public Paint f4446h;

    /* renamed from: i  reason: collision with root package name */
    public TextPaint f4447i;

    /* renamed from: j  reason: collision with root package name */
    public Path f4448j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f4449k;
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
        this.f4443e = new Stack<>();
        this.f4444f = new Paint();
        this.f4445g = new Paint();
        this.f4446h = new Paint();
        this.f4447i = new TextPaint();
        this.f4448j = new Path();
        this.f4449k = false;
        this.n = -1;
        this.o = 0;
        this.p = 0;
        this.q = -16777216;
        this.l = canvasView;
        e();
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.p : invokeV.intValue;
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.p = i2;
        }
    }

    public void c(Paint paint) {
        k0 k0Var;
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, paint) == null) || paint == null) {
            return;
        }
        if (this.l != null && (k0Var = this.m) != null && (iVar = k0Var.f4485h) != null && !iVar.c()) {
            k0 k0Var2 = this.m;
            paint.setShadowLayer(k0Var2.f4484g, k0Var2.f4482e, k0Var2.f4483f, k0Var2.f4485h.a());
        }
        int i2 = this.n;
        if (i2 < 0 || i2 > 255) {
            return;
        }
        paint.setAlpha(Math.min((paint.getAlpha() * this.n) >> 8, 255));
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.q = -16777216;
            this.f4445g.setStyle(Paint.Style.STROKE);
            this.f4444f.setColor(-16777216);
            this.f4445g.setColor(-16777216);
            this.f4446h.setColor(-16777216);
            this.f4447i.setColor(-16777216);
            this.f4445g.setStrokeWidth(c.a.q0.a.z2.n0.g(1.0f));
            this.f4445g.setAntiAlias(true);
            this.f4447i.setAntiAlias(true);
            this.f4446h.setAntiAlias(true);
            this.f4448j.reset();
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f4443e.empty()) {
            return;
        }
        b pop = this.f4443e.pop();
        this.f4444f = pop.f4444f;
        this.f4445g = pop.f4445g;
        this.f4446h = pop.f4446h;
        this.f4447i = pop.f4447i;
        this.f4448j = pop.f4448j;
        this.f4449k = pop.f4449k;
        this.f4443e = pop.f4443e;
        this.m = pop.m;
        this.n = pop.n;
        this.o = pop.o;
        this.p = pop.p;
        this.q = pop.q;
    }

    public void g() throws CloneNotSupportedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            b bVar = (b) super.clone();
            bVar.f4444f = new Paint(this.f4444f);
            bVar.f4445g = new Paint(this.f4445g);
            bVar.f4446h = new Paint(this.f4446h);
            bVar.f4447i = new TextPaint(this.f4447i);
            bVar.f4448j = new Path(this.f4448j);
            bVar.o = this.o;
            bVar.p = this.p;
            bVar.q = this.q;
            this.f4443e.push(bVar);
        }
    }
}
