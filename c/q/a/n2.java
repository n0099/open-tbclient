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
    public final /* synthetic */ u2 f30412e;

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
        this.f30412e = u2Var;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Info info;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f30412e.f30518j = true;
                this.f30412e.k = System.currentTimeMillis();
                this.f30412e.l = motionEvent.getX();
                this.f30412e.m = motionEvent.getY();
                this.f30412e.n = (int) motionEvent.getRawX();
                this.f30412e.o = (int) motionEvent.getRawY();
                this.f30412e.v = System.currentTimeMillis();
                this.f30412e.p = (int) motionEvent.getX();
                this.f30412e.q = (int) motionEvent.getY();
                u2.c(this.f30412e, view);
            } else if (action == 1) {
                this.f30412e.w = (int) motionEvent.getRawX();
                this.f30412e.x = (int) motionEvent.getRawY();
                this.f30412e.r = (int) motionEvent.getX();
                this.f30412e.s = (int) motionEvent.getY();
                this.f30412e.y = System.currentTimeMillis();
                Math.abs(motionEvent.getX() - this.f30412e.l);
                Math.abs(motionEvent.getY() - this.f30412e.m);
                if (System.currentTimeMillis() - this.f30412e.k < 2000) {
                    u2 u2Var = this.f30412e;
                    if (u2Var.f30518j && (info = u2Var.f30511c) != null && a2.d(info, u2Var.f30516h)) {
                        this.f30412e.f30516h = System.currentTimeMillis();
                        u2 u2Var2 = this.f30412e;
                        Context context = u2Var2.a;
                        String open = u2Var2.f30511c.getOpen();
                        u2 u2Var3 = this.f30412e;
                        a2.a(context, open, u2Var3.f30511c, u2Var3.f30515g, u2Var3.g().toString());
                        y2 a = c3.a(this.f30412e.a);
                        a.h(new g3(this.f30412e.f30511c), null);
                        a.l("desc", this.f30412e.g().toString());
                        a.m();
                        u2 u2Var4 = this.f30412e;
                        r0.p(u2Var4.f30511c, u2Var4.g().toString());
                        i3 i3Var = this.f30412e.f30514f;
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
