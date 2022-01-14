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
public class i implements View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ u f30338e;

    public i(u uVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f30338e = uVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Info info;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f30338e.f30476j = true;
                this.f30338e.k = System.currentTimeMillis();
                this.f30338e.l = motionEvent.getX();
                this.f30338e.m = motionEvent.getY();
                this.f30338e.n = (int) motionEvent.getRawX();
                this.f30338e.o = (int) motionEvent.getRawY();
                this.f30338e.v = System.currentTimeMillis();
                this.f30338e.p = (int) motionEvent.getX();
                this.f30338e.q = (int) motionEvent.getY();
                u.d(this.f30338e, view);
            } else if (action == 1) {
                this.f30338e.w = (int) motionEvent.getRawX();
                this.f30338e.x = (int) motionEvent.getRawY();
                this.f30338e.r = (int) motionEvent.getX();
                this.f30338e.s = (int) motionEvent.getY();
                this.f30338e.y = System.currentTimeMillis();
                Math.abs(motionEvent.getX() - this.f30338e.l);
                Math.abs(motionEvent.getY() - this.f30338e.m);
                if (System.currentTimeMillis() - this.f30338e.k < 2000) {
                    u uVar = this.f30338e;
                    if (uVar.f30476j && (info = uVar.f30469c) != null && a2.d(info, uVar.f30474h)) {
                        this.f30338e.f30474h = System.currentTimeMillis();
                        u uVar2 = this.f30338e;
                        Context context = uVar2.a;
                        String open = uVar2.f30469c.getOpen();
                        u uVar3 = this.f30338e;
                        a2.a(context, open, uVar3.f30469c, uVar3.f30473g, uVar3.h().toString());
                        y2 a = c3.a(this.f30338e.a);
                        a.h(new g3(this.f30338e.f30469c), null);
                        a.l("desc", this.f30338e.h().toString());
                        a.m();
                        u uVar4 = this.f30338e;
                        r0.p(uVar4.f30469c, uVar4.h().toString());
                        s sVar = this.f30338e.f30472f;
                        if (sVar != null) {
                            sVar.onClicked();
                        }
                    }
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
