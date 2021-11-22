package b.o.a;

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
    public final /* synthetic */ u2 f34239e;

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
        this.f34239e = u2Var;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Info info;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f34239e.j = true;
                this.f34239e.k = System.currentTimeMillis();
                this.f34239e.l = motionEvent.getX();
                this.f34239e.m = motionEvent.getY();
                this.f34239e.n = (int) motionEvent.getRawX();
                this.f34239e.o = (int) motionEvent.getRawY();
                this.f34239e.v = System.currentTimeMillis();
                this.f34239e.p = (int) motionEvent.getX();
                this.f34239e.q = (int) motionEvent.getY();
                u2.c(this.f34239e, view);
            } else if (action == 1) {
                this.f34239e.w = (int) motionEvent.getRawX();
                this.f34239e.x = (int) motionEvent.getRawY();
                this.f34239e.r = (int) motionEvent.getX();
                this.f34239e.s = (int) motionEvent.getY();
                this.f34239e.y = System.currentTimeMillis();
                Math.abs(motionEvent.getX() - this.f34239e.l);
                Math.abs(motionEvent.getY() - this.f34239e.m);
                if (System.currentTimeMillis() - this.f34239e.k < 2000) {
                    u2 u2Var = this.f34239e;
                    if (u2Var.j && (info = u2Var.f34354c) != null && a2.d(info, u2Var.f34359h)) {
                        this.f34239e.f34359h = System.currentTimeMillis();
                        u2 u2Var2 = this.f34239e;
                        Context context = u2Var2.f34352a;
                        String open = u2Var2.f34354c.getOpen();
                        u2 u2Var3 = this.f34239e;
                        a2.a(context, open, u2Var3.f34354c, u2Var3.f34358g, u2Var3.g().toString());
                        y2 a2 = c3.a(this.f34239e.f34352a);
                        a2.h(new g3(this.f34239e.f34354c), null);
                        a2.l("desc", this.f34239e.g().toString());
                        a2.m();
                        u2 u2Var4 = this.f34239e;
                        r0.p(u2Var4.f34354c, u2Var4.g().toString());
                        i3 i3Var = this.f34239e.f34357f;
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
