package c.a.n0.a.q.a.j;

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
    public Stack<b> a;

    /* renamed from: b  reason: collision with root package name */
    public Paint f5896b;

    /* renamed from: c  reason: collision with root package name */
    public Paint f5897c;

    /* renamed from: d  reason: collision with root package name */
    public Paint f5898d;

    /* renamed from: e  reason: collision with root package name */
    public TextPaint f5899e;

    /* renamed from: f  reason: collision with root package name */
    public Path f5900f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f5901g;

    /* renamed from: h  reason: collision with root package name */
    public CanvasView f5902h;
    public k0 i;
    public int j;
    public int k;
    public int l;
    public int m;

    public b(CanvasView canvasView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {canvasView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new Stack<>();
        this.f5896b = new Paint();
        this.f5897c = new Paint();
        this.f5898d = new Paint();
        this.f5899e = new TextPaint();
        this.f5900f = new Path();
        this.f5901g = false;
        this.j = -1;
        this.k = 0;
        this.l = 0;
        this.m = -16777216;
        this.f5902h = canvasView;
        d();
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.l : invokeV.intValue;
    }

    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.l = i;
        }
    }

    public void c(Paint paint) {
        k0 k0Var;
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, paint) == null) || paint == null) {
            return;
        }
        if (this.f5902h != null && (k0Var = this.i) != null && (iVar = k0Var.f5935d) != null && !iVar.c()) {
            k0 k0Var2 = this.i;
            paint.setShadowLayer(k0Var2.f5934c, k0Var2.a, k0Var2.f5933b, k0Var2.f5935d.a());
        }
        int i = this.j;
        if (i < 0 || i > 255) {
            return;
        }
        paint.setAlpha(Math.min((paint.getAlpha() * this.j) >> 8, 255));
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.m = -16777216;
            this.f5897c.setStyle(Paint.Style.STROKE);
            this.f5896b.setColor(-16777216);
            this.f5897c.setColor(-16777216);
            this.f5898d.setColor(-16777216);
            this.f5899e.setColor(-16777216);
            this.f5897c.setStrokeWidth(c.a.n0.a.p2.n0.g(1.0f));
            this.f5897c.setAntiAlias(true);
            this.f5899e.setAntiAlias(true);
            this.f5898d.setAntiAlias(true);
            this.f5900f.reset();
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.a.empty()) {
            return;
        }
        b pop = this.a.pop();
        this.f5896b = pop.f5896b;
        this.f5897c = pop.f5897c;
        this.f5898d = pop.f5898d;
        this.f5899e = pop.f5899e;
        this.f5900f = pop.f5900f;
        this.f5901g = pop.f5901g;
        this.a = pop.a;
        this.i = pop.i;
        this.j = pop.j;
        this.k = pop.k;
        this.l = pop.l;
        this.m = pop.m;
    }

    public void f() throws CloneNotSupportedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            b bVar = (b) super.clone();
            bVar.f5896b = new Paint(this.f5896b);
            bVar.f5897c = new Paint(this.f5897c);
            bVar.f5898d = new Paint(this.f5898d);
            bVar.f5899e = new TextPaint(this.f5899e);
            bVar.f5900f = new Path(this.f5900f);
            bVar.k = this.k;
            bVar.l = this.l;
            bVar.m = this.m;
            this.a.push(bVar);
        }
    }
}
