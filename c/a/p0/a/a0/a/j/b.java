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
    public Stack<b> f4134e;

    /* renamed from: f  reason: collision with root package name */
    public Paint f4135f;

    /* renamed from: g  reason: collision with root package name */
    public Paint f4136g;

    /* renamed from: h  reason: collision with root package name */
    public Paint f4137h;

    /* renamed from: i  reason: collision with root package name */
    public TextPaint f4138i;

    /* renamed from: j  reason: collision with root package name */
    public Path f4139j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f4140k;
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
        this.f4134e = new Stack<>();
        this.f4135f = new Paint();
        this.f4136g = new Paint();
        this.f4137h = new Paint();
        this.f4138i = new TextPaint();
        this.f4139j = new Path();
        this.f4140k = false;
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
        if (this.l != null && (k0Var = this.m) != null && (iVar = k0Var.f4176h) != null && !iVar.c()) {
            k0 k0Var2 = this.m;
            paint.setShadowLayer(k0Var2.f4175g, k0Var2.f4173e, k0Var2.f4174f, k0Var2.f4176h.a());
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
            this.f4136g.setStyle(Paint.Style.STROKE);
            this.f4135f.setColor(-16777216);
            this.f4136g.setColor(-16777216);
            this.f4137h.setColor(-16777216);
            this.f4138i.setColor(-16777216);
            this.f4136g.setStrokeWidth(c.a.p0.a.z2.n0.g(1.0f));
            this.f4136g.setAntiAlias(true);
            this.f4138i.setAntiAlias(true);
            this.f4137h.setAntiAlias(true);
            this.f4139j.reset();
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f4134e.empty()) {
            return;
        }
        b pop = this.f4134e.pop();
        this.f4135f = pop.f4135f;
        this.f4136g = pop.f4136g;
        this.f4137h = pop.f4137h;
        this.f4138i = pop.f4138i;
        this.f4139j = pop.f4139j;
        this.f4140k = pop.f4140k;
        this.f4134e = pop.f4134e;
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
            bVar.f4135f = new Paint(this.f4135f);
            bVar.f4136g = new Paint(this.f4136g);
            bVar.f4137h = new Paint(this.f4137h);
            bVar.f4138i = new TextPaint(this.f4138i);
            bVar.f4139j = new Path(this.f4139j);
            bVar.o = this.o;
            bVar.p = this.p;
            bVar.q = this.q;
            this.f4134e.push(bVar);
        }
    }
}
