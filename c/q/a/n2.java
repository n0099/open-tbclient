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
    public final /* synthetic */ u2 f31366e;

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
        this.f31366e = u2Var;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Info info;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f31366e.f31479j = true;
                this.f31366e.f31480k = System.currentTimeMillis();
                this.f31366e.l = motionEvent.getX();
                this.f31366e.m = motionEvent.getY();
                this.f31366e.n = (int) motionEvent.getRawX();
                this.f31366e.o = (int) motionEvent.getRawY();
                this.f31366e.v = System.currentTimeMillis();
                this.f31366e.p = (int) motionEvent.getX();
                this.f31366e.q = (int) motionEvent.getY();
                u2.c(this.f31366e, view);
            } else if (action == 1) {
                this.f31366e.w = (int) motionEvent.getRawX();
                this.f31366e.x = (int) motionEvent.getRawY();
                this.f31366e.r = (int) motionEvent.getX();
                this.f31366e.s = (int) motionEvent.getY();
                this.f31366e.y = System.currentTimeMillis();
                Math.abs(motionEvent.getX() - this.f31366e.l);
                Math.abs(motionEvent.getY() - this.f31366e.m);
                if (System.currentTimeMillis() - this.f31366e.f31480k < 2000) {
                    u2 u2Var = this.f31366e;
                    if (u2Var.f31479j && (info = u2Var.f31472c) != null && a2.d(info, u2Var.f31477h)) {
                        this.f31366e.f31477h = System.currentTimeMillis();
                        u2 u2Var2 = this.f31366e;
                        Context context = u2Var2.a;
                        String open = u2Var2.f31472c.getOpen();
                        u2 u2Var3 = this.f31366e;
                        a2.a(context, open, u2Var3.f31472c, u2Var3.f31476g, u2Var3.g().toString());
                        y2 a = c3.a(this.f31366e.a);
                        a.h(new g3(this.f31366e.f31472c), null);
                        a.l("desc", this.f31366e.g().toString());
                        a.m();
                        u2 u2Var4 = this.f31366e;
                        r0.p(u2Var4.f31472c, u2Var4.g().toString());
                        i3 i3Var = this.f31366e.f31475f;
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
