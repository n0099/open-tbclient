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
    public final /* synthetic */ u2 f30618e;

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
        this.f30618e = u2Var;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Info info;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f30618e.f30724j = true;
                this.f30618e.k = System.currentTimeMillis();
                this.f30618e.l = motionEvent.getX();
                this.f30618e.m = motionEvent.getY();
                this.f30618e.n = (int) motionEvent.getRawX();
                this.f30618e.o = (int) motionEvent.getRawY();
                this.f30618e.v = System.currentTimeMillis();
                this.f30618e.p = (int) motionEvent.getX();
                this.f30618e.q = (int) motionEvent.getY();
                u2.c(this.f30618e, view);
            } else if (action == 1) {
                this.f30618e.w = (int) motionEvent.getRawX();
                this.f30618e.x = (int) motionEvent.getRawY();
                this.f30618e.r = (int) motionEvent.getX();
                this.f30618e.s = (int) motionEvent.getY();
                this.f30618e.y = System.currentTimeMillis();
                Math.abs(motionEvent.getX() - this.f30618e.l);
                Math.abs(motionEvent.getY() - this.f30618e.m);
                if (System.currentTimeMillis() - this.f30618e.k < 2000) {
                    u2 u2Var = this.f30618e;
                    if (u2Var.f30724j && (info = u2Var.f30717c) != null && a2.d(info, u2Var.f30722h)) {
                        this.f30618e.f30722h = System.currentTimeMillis();
                        u2 u2Var2 = this.f30618e;
                        Context context = u2Var2.a;
                        String open = u2Var2.f30717c.getOpen();
                        u2 u2Var3 = this.f30618e;
                        a2.a(context, open, u2Var3.f30717c, u2Var3.f30721g, u2Var3.g().toString());
                        y2 a = c3.a(this.f30618e.a);
                        a.h(new g3(this.f30618e.f30717c), null);
                        a.l("desc", this.f30618e.g().toString());
                        a.m();
                        u2 u2Var4 = this.f30618e;
                        r0.p(u2Var4.f30717c, u2Var4.g().toString());
                        i3 i3Var = this.f30618e.f30720f;
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
