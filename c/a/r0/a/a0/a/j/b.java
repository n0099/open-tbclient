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
    public Stack<b> f5178e;

    /* renamed from: f  reason: collision with root package name */
    public Paint f5179f;

    /* renamed from: g  reason: collision with root package name */
    public Paint f5180g;

    /* renamed from: h  reason: collision with root package name */
    public Paint f5181h;

    /* renamed from: i  reason: collision with root package name */
    public TextPaint f5182i;

    /* renamed from: j  reason: collision with root package name */
    public Path f5183j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f5184k;
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
        this.f5178e = new Stack<>();
        this.f5179f = new Paint();
        this.f5180g = new Paint();
        this.f5181h = new Paint();
        this.f5182i = new TextPaint();
        this.f5183j = new Path();
        this.f5184k = false;
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
        if (this.l != null && (k0Var = this.m) != null && (iVar = k0Var.f5220h) != null && !iVar.c()) {
            k0 k0Var2 = this.m;
            paint.setShadowLayer(k0Var2.f5219g, k0Var2.f5217e, k0Var2.f5218f, k0Var2.f5220h.a());
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
            this.f5180g.setStyle(Paint.Style.STROKE);
            this.f5179f.setColor(-16777216);
            this.f5180g.setColor(-16777216);
            this.f5181h.setColor(-16777216);
            this.f5182i.setColor(-16777216);
            this.f5180g.setStrokeWidth(c.a.r0.a.z2.n0.g(1.0f));
            this.f5180g.setAntiAlias(true);
            this.f5182i.setAntiAlias(true);
            this.f5181h.setAntiAlias(true);
            this.f5183j.reset();
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f5178e.empty()) {
            return;
        }
        b pop = this.f5178e.pop();
        this.f5179f = pop.f5179f;
        this.f5180g = pop.f5180g;
        this.f5181h = pop.f5181h;
        this.f5182i = pop.f5182i;
        this.f5183j = pop.f5183j;
        this.f5184k = pop.f5184k;
        this.f5178e = pop.f5178e;
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
            bVar.f5179f = new Paint(this.f5179f);
            bVar.f5180g = new Paint(this.f5180g);
            bVar.f5181h = new Paint(this.f5181h);
            bVar.f5182i = new TextPaint(this.f5182i);
            bVar.f5183j = new Path(this.f5183j);
            bVar.o = this.o;
            bVar.p = this.p;
            bVar.q = this.q;
            this.f5178e.push(bVar);
        }
    }
}
