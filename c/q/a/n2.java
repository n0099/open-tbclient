package c.q.a;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.core.Info;
/* loaded from: classes9.dex */
public class n2 implements View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ u2 f30384e;

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
        this.f30384e = u2Var;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Info info;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f30384e.f30490j = true;
                this.f30384e.k = System.currentTimeMillis();
                this.f30384e.l = motionEvent.getX();
                this.f30384e.m = motionEvent.getY();
                this.f30384e.n = (int) motionEvent.getRawX();
                this.f30384e.o = (int) motionEvent.getRawY();
                this.f30384e.v = System.currentTimeMillis();
                this.f30384e.p = (int) motionEvent.getX();
                this.f30384e.q = (int) motionEvent.getY();
                u2.c(this.f30384e, view);
            } else if (action == 1) {
                this.f30384e.w = (int) motionEvent.getRawX();
                this.f30384e.x = (int) motionEvent.getRawY();
                this.f30384e.r = (int) motionEvent.getX();
                this.f30384e.s = (int) motionEvent.getY();
                this.f30384e.y = System.currentTimeMillis();
                Math.abs(motionEvent.getX() - this.f30384e.l);
                Math.abs(motionEvent.getY() - this.f30384e.m);
                if (System.currentTimeMillis() - this.f30384e.k < 2000) {
                    u2 u2Var = this.f30384e;
                    if (u2Var.f30490j && (info = u2Var.f30483c) != null && a2.d(info, u2Var.f30488h)) {
                        this.f30384e.f30488h = System.currentTimeMillis();
                        u2 u2Var2 = this.f30384e;
                        Context context = u2Var2.a;
                        String open = u2Var2.f30483c.getOpen();
                        u2 u2Var3 = this.f30384e;
                        a2.a(context, open, u2Var3.f30483c, u2Var3.f30487g, u2Var3.g().toString());
                        y2 a = c3.a(this.f30384e.a);
                        a.h(new g3(this.f30384e.f30483c), null);
                        a.l("desc", this.f30384e.g().toString());
                        a.m();
                        u2 u2Var4 = this.f30384e;
                        r0.p(u2Var4.f30483c, u2Var4.g().toString());
                        i3 i3Var = this.f30384e.f30486f;
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
