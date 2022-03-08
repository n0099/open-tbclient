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
/* loaded from: classes3.dex */
public class i implements View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ u f28981e;

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
        this.f28981e = uVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Info info;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f28981e.f29140j = true;
                this.f28981e.k = System.currentTimeMillis();
                this.f28981e.l = motionEvent.getX();
                this.f28981e.m = motionEvent.getY();
                this.f28981e.n = (int) motionEvent.getRawX();
                this.f28981e.o = (int) motionEvent.getRawY();
                this.f28981e.v = System.currentTimeMillis();
                this.f28981e.p = (int) motionEvent.getX();
                this.f28981e.q = (int) motionEvent.getY();
                u.d(this.f28981e, view);
            } else if (action == 1) {
                this.f28981e.w = (int) motionEvent.getRawX();
                this.f28981e.x = (int) motionEvent.getRawY();
                this.f28981e.r = (int) motionEvent.getX();
                this.f28981e.s = (int) motionEvent.getY();
                this.f28981e.y = System.currentTimeMillis();
                Math.abs(motionEvent.getX() - this.f28981e.l);
                Math.abs(motionEvent.getY() - this.f28981e.m);
                if (System.currentTimeMillis() - this.f28981e.k < 2000) {
                    u uVar = this.f28981e;
                    if (uVar.f29140j && (info = uVar.f29133c) != null && v1.d(info, uVar.f29138h)) {
                        this.f28981e.f29138h = System.currentTimeMillis();
                        u uVar2 = this.f28981e;
                        Context context = uVar2.a;
                        String open = uVar2.f29133c.getOpen();
                        u uVar3 = this.f28981e;
                        v1.a(context, open, uVar3.f29133c, uVar3.f29137g, uVar3.h().toString());
                        t2 a = x2.a(this.f28981e.a);
                        a.h(new b3(this.f28981e.f29133c), null);
                        a.l("desc", this.f28981e.h().toString());
                        a.m();
                        u uVar4 = this.f28981e;
                        r0.p(uVar4.f29133c, uVar4.h().toString());
                        s sVar = this.f28981e.f29136f;
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
