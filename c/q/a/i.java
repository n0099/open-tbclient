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
    public final /* synthetic */ u f30366e;

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
        this.f30366e = uVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Info info;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f30366e.f30504j = true;
                this.f30366e.k = System.currentTimeMillis();
                this.f30366e.l = motionEvent.getX();
                this.f30366e.m = motionEvent.getY();
                this.f30366e.n = (int) motionEvent.getRawX();
                this.f30366e.o = (int) motionEvent.getRawY();
                this.f30366e.v = System.currentTimeMillis();
                this.f30366e.p = (int) motionEvent.getX();
                this.f30366e.q = (int) motionEvent.getY();
                u.d(this.f30366e, view);
            } else if (action == 1) {
                this.f30366e.w = (int) motionEvent.getRawX();
                this.f30366e.x = (int) motionEvent.getRawY();
                this.f30366e.r = (int) motionEvent.getX();
                this.f30366e.s = (int) motionEvent.getY();
                this.f30366e.y = System.currentTimeMillis();
                Math.abs(motionEvent.getX() - this.f30366e.l);
                Math.abs(motionEvent.getY() - this.f30366e.m);
                if (System.currentTimeMillis() - this.f30366e.k < 2000) {
                    u uVar = this.f30366e;
                    if (uVar.f30504j && (info = uVar.f30497c) != null && a2.d(info, uVar.f30502h)) {
                        this.f30366e.f30502h = System.currentTimeMillis();
                        u uVar2 = this.f30366e;
                        Context context = uVar2.a;
                        String open = uVar2.f30497c.getOpen();
                        u uVar3 = this.f30366e;
                        a2.a(context, open, uVar3.f30497c, uVar3.f30501g, uVar3.h().toString());
                        y2 a = c3.a(this.f30366e.a);
                        a.h(new g3(this.f30366e.f30497c), null);
                        a.l("desc", this.f30366e.h().toString());
                        a.m();
                        u uVar4 = this.f30366e;
                        r0.p(uVar4.f30497c, uVar4.h().toString());
                        s sVar = this.f30366e.f30500f;
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
