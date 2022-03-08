package c.a.p0.a.q.a.j;

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
    public Stack<b> f7045e;

    /* renamed from: f  reason: collision with root package name */
    public Paint f7046f;

    /* renamed from: g  reason: collision with root package name */
    public Paint f7047g;

    /* renamed from: h  reason: collision with root package name */
    public Paint f7048h;

    /* renamed from: i  reason: collision with root package name */
    public TextPaint f7049i;

    /* renamed from: j  reason: collision with root package name */
    public Path f7050j;
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
        this.f7045e = new Stack<>();
        this.f7046f = new Paint();
        this.f7047g = new Paint();
        this.f7048h = new Paint();
        this.f7049i = new TextPaint();
        this.f7050j = new Path();
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
        if (this.l != null && (k0Var = this.m) != null && (iVar = k0Var.f7086h) != null && !iVar.c()) {
            k0 k0Var2 = this.m;
            paint.setShadowLayer(k0Var2.f7085g, k0Var2.f7083e, k0Var2.f7084f, k0Var2.f7086h.a());
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
            this.f7047g.setStyle(Paint.Style.STROKE);
            this.f7046f.setColor(-16777216);
            this.f7047g.setColor(-16777216);
            this.f7048h.setColor(-16777216);
            this.f7049i.setColor(-16777216);
            this.f7047g.setStrokeWidth(c.a.p0.a.p2.n0.g(1.0f));
            this.f7047g.setAntiAlias(true);
            this.f7049i.setAntiAlias(true);
            this.f7048h.setAntiAlias(true);
            this.f7050j.reset();
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f7045e.empty()) {
            return;
        }
        b pop = this.f7045e.pop();
        this.f7046f = pop.f7046f;
        this.f7047g = pop.f7047g;
        this.f7048h = pop.f7048h;
        this.f7049i = pop.f7049i;
        this.f7050j = pop.f7050j;
        this.k = pop.k;
        this.f7045e = pop.f7045e;
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
            bVar.f7046f = new Paint(this.f7046f);
            bVar.f7047g = new Paint(this.f7047g);
            bVar.f7048h = new Paint(this.f7048h);
            bVar.f7049i = new TextPaint(this.f7049i);
            bVar.f7050j = new Path(this.f7050j);
            bVar.o = this.o;
            bVar.p = this.p;
            bVar.q = this.q;
            this.f7045e.push(bVar);
        }
    }
}
