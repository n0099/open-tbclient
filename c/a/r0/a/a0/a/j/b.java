package c.a.r0.a.a0.a.j;

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
    public Stack<b> f5212e;

    /* renamed from: f  reason: collision with root package name */
    public Paint f5213f;

    /* renamed from: g  reason: collision with root package name */
    public Paint f5214g;

    /* renamed from: h  reason: collision with root package name */
    public Paint f5215h;

    /* renamed from: i  reason: collision with root package name */
    public TextPaint f5216i;

    /* renamed from: j  reason: collision with root package name */
    public Path f5217j;
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
        this.f5212e = new Stack<>();
        this.f5213f = new Paint();
        this.f5214g = new Paint();
        this.f5215h = new Paint();
        this.f5216i = new TextPaint();
        this.f5217j = new Path();
        this.k = false;
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
        if (this.l != null && (k0Var = this.m) != null && (iVar = k0Var.f5253h) != null && !iVar.c()) {
            k0 k0Var2 = this.m;
            paint.setShadowLayer(k0Var2.f5252g, k0Var2.f5250e, k0Var2.f5251f, k0Var2.f5253h.a());
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
            this.f5214g.setStyle(Paint.Style.STROKE);
            this.f5213f.setColor(-16777216);
            this.f5214g.setColor(-16777216);
            this.f5215h.setColor(-16777216);
            this.f5216i.setColor(-16777216);
            this.f5214g.setStrokeWidth(c.a.r0.a.z2.n0.g(1.0f));
            this.f5214g.setAntiAlias(true);
            this.f5216i.setAntiAlias(true);
            this.f5215h.setAntiAlias(true);
            this.f5217j.reset();
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f5212e.empty()) {
            return;
        }
        b pop = this.f5212e.pop();
        this.f5213f = pop.f5213f;
        this.f5214g = pop.f5214g;
        this.f5215h = pop.f5215h;
        this.f5216i = pop.f5216i;
        this.f5217j = pop.f5217j;
        this.k = pop.k;
        this.f5212e = pop.f5212e;
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
            bVar.f5213f = new Paint(this.f5213f);
            bVar.f5214g = new Paint(this.f5214g);
            bVar.f5215h = new Paint(this.f5215h);
            bVar.f5216i = new TextPaint(this.f5216i);
            bVar.f5217j = new Path(this.f5217j);
            bVar.o = this.o;
            bVar.p = this.p;
            bVar.q = this.q;
            this.f5212e.push(bVar);
        }
    }
}
