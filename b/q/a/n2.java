package b.q.a;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.core.Info;
/* loaded from: classes6.dex */
public class n2 implements View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ u2 f33405e;

    public n2(u2 u2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {u2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f33405e = u2Var;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Info info;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f33405e.j = true;
                this.f33405e.k = System.currentTimeMillis();
                this.f33405e.l = motionEvent.getX();
                this.f33405e.m = motionEvent.getY();
                this.f33405e.n = (int) motionEvent.getRawX();
                this.f33405e.o = (int) motionEvent.getRawY();
                this.f33405e.v = System.currentTimeMillis();
                this.f33405e.p = (int) motionEvent.getX();
                this.f33405e.q = (int) motionEvent.getY();
                u2.c(this.f33405e, view);
            } else if (action == 1) {
                this.f33405e.w = (int) motionEvent.getRawX();
                this.f33405e.x = (int) motionEvent.getRawY();
                this.f33405e.r = (int) motionEvent.getX();
                this.f33405e.s = (int) motionEvent.getY();
                this.f33405e.y = System.currentTimeMillis();
                Math.abs(motionEvent.getX() - this.f33405e.l);
                Math.abs(motionEvent.getY() - this.f33405e.m);
                if (System.currentTimeMillis() - this.f33405e.k < 2000) {
                    u2 u2Var = this.f33405e;
                    if (u2Var.j && (info = u2Var.f33520c) != null && a2.d(info, u2Var.f33525h)) {
                        this.f33405e.f33525h = System.currentTimeMillis();
                        u2 u2Var2 = this.f33405e;
                        Context context = u2Var2.f33518a;
                        String open = u2Var2.f33520c.getOpen();
                        u2 u2Var3 = this.f33405e;
                        a2.a(context, open, u2Var3.f33520c, u2Var3.f33524g, u2Var3.g().toString());
                        y2 a2 = c3.a(this.f33405e.f33518a);
                        a2.h(new g3(this.f33405e.f33520c), null);
                        a2.l("desc", this.f33405e.g().toString());
                        a2.m();
                        u2 u2Var4 = this.f33405e;
                        r0.p(u2Var4.f33520c, u2Var4.g().toString());
                        i3 i3Var = this.f33405e.f33523f;
                        if (i3Var != null) {
                            i3Var.onClicked();
                        }
                    }
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
