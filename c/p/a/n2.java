package c.p.a;

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
    public final /* synthetic */ u2 f31223e;

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
        this.f31223e = u2Var;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Info info;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f31223e.f31336j = true;
                this.f31223e.f31337k = System.currentTimeMillis();
                this.f31223e.l = motionEvent.getX();
                this.f31223e.m = motionEvent.getY();
                this.f31223e.n = (int) motionEvent.getRawX();
                this.f31223e.o = (int) motionEvent.getRawY();
                this.f31223e.v = System.currentTimeMillis();
                this.f31223e.p = (int) motionEvent.getX();
                this.f31223e.q = (int) motionEvent.getY();
                u2.c(this.f31223e, view);
            } else if (action == 1) {
                this.f31223e.w = (int) motionEvent.getRawX();
                this.f31223e.x = (int) motionEvent.getRawY();
                this.f31223e.r = (int) motionEvent.getX();
                this.f31223e.s = (int) motionEvent.getY();
                this.f31223e.y = System.currentTimeMillis();
                Math.abs(motionEvent.getX() - this.f31223e.l);
                Math.abs(motionEvent.getY() - this.f31223e.m);
                if (System.currentTimeMillis() - this.f31223e.f31337k < 2000) {
                    u2 u2Var = this.f31223e;
                    if (u2Var.f31336j && (info = u2Var.f31329c) != null && a2.d(info, u2Var.f31334h)) {
                        this.f31223e.f31334h = System.currentTimeMillis();
                        u2 u2Var2 = this.f31223e;
                        Context context = u2Var2.a;
                        String open = u2Var2.f31329c.getOpen();
                        u2 u2Var3 = this.f31223e;
                        a2.a(context, open, u2Var3.f31329c, u2Var3.f31333g, u2Var3.g().toString());
                        y2 a = c3.a(this.f31223e.a);
                        a.h(new g3(this.f31223e.f31329c), null);
                        a.l("desc", this.f31223e.g().toString());
                        a.m();
                        u2 u2Var4 = this.f31223e;
                        r0.p(u2Var4.f31329c, u2Var4.g().toString());
                        i3 i3Var = this.f31223e.f31332f;
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
