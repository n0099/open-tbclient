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
/* loaded from: classes7.dex */
public class n2 implements View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ u2 f30853e;

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
        this.f30853e = u2Var;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Info info;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f30853e.f30966j = true;
                this.f30853e.f30967k = System.currentTimeMillis();
                this.f30853e.l = motionEvent.getX();
                this.f30853e.m = motionEvent.getY();
                this.f30853e.n = (int) motionEvent.getRawX();
                this.f30853e.o = (int) motionEvent.getRawY();
                this.f30853e.v = System.currentTimeMillis();
                this.f30853e.p = (int) motionEvent.getX();
                this.f30853e.q = (int) motionEvent.getY();
                u2.c(this.f30853e, view);
            } else if (action == 1) {
                this.f30853e.w = (int) motionEvent.getRawX();
                this.f30853e.x = (int) motionEvent.getRawY();
                this.f30853e.r = (int) motionEvent.getX();
                this.f30853e.s = (int) motionEvent.getY();
                this.f30853e.y = System.currentTimeMillis();
                Math.abs(motionEvent.getX() - this.f30853e.l);
                Math.abs(motionEvent.getY() - this.f30853e.m);
                if (System.currentTimeMillis() - this.f30853e.f30967k < 2000) {
                    u2 u2Var = this.f30853e;
                    if (u2Var.f30966j && (info = u2Var.f30959c) != null && a2.d(info, u2Var.f30964h)) {
                        this.f30853e.f30964h = System.currentTimeMillis();
                        u2 u2Var2 = this.f30853e;
                        Context context = u2Var2.a;
                        String open = u2Var2.f30959c.getOpen();
                        u2 u2Var3 = this.f30853e;
                        a2.a(context, open, u2Var3.f30959c, u2Var3.f30963g, u2Var3.g().toString());
                        y2 a = c3.a(this.f30853e.a);
                        a.h(new g3(this.f30853e.f30959c), null);
                        a.l("desc", this.f30853e.g().toString());
                        a.m();
                        u2 u2Var4 = this.f30853e;
                        r0.p(u2Var4.f30959c, u2Var4.g().toString());
                        i3 i3Var = this.f30853e.f30962f;
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
