package b.q.a;

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
public class i implements View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ u f33342e;

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
        this.f33342e = uVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Info info;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f33342e.j = true;
                this.f33342e.k = System.currentTimeMillis();
                this.f33342e.l = motionEvent.getX();
                this.f33342e.m = motionEvent.getY();
                this.f33342e.n = (int) motionEvent.getRawX();
                this.f33342e.o = (int) motionEvent.getRawY();
                this.f33342e.v = System.currentTimeMillis();
                this.f33342e.p = (int) motionEvent.getX();
                this.f33342e.q = (int) motionEvent.getY();
                u.d(this.f33342e, view);
            } else if (action == 1) {
                this.f33342e.w = (int) motionEvent.getRawX();
                this.f33342e.x = (int) motionEvent.getRawY();
                this.f33342e.r = (int) motionEvent.getX();
                this.f33342e.s = (int) motionEvent.getY();
                this.f33342e.y = System.currentTimeMillis();
                Math.abs(motionEvent.getX() - this.f33342e.l);
                Math.abs(motionEvent.getY() - this.f33342e.m);
                if (System.currentTimeMillis() - this.f33342e.k < 2000) {
                    u uVar = this.f33342e;
                    if (uVar.j && (info = uVar.f33504c) != null && a2.d(info, uVar.f33509h)) {
                        this.f33342e.f33509h = System.currentTimeMillis();
                        u uVar2 = this.f33342e;
                        Context context = uVar2.f33502a;
                        String open = uVar2.f33504c.getOpen();
                        u uVar3 = this.f33342e;
                        a2.a(context, open, uVar3.f33504c, uVar3.f33508g, uVar3.h().toString());
                        y2 a2 = c3.a(this.f33342e.f33502a);
                        a2.h(new g3(this.f33342e.f33504c), null);
                        a2.l("desc", this.f33342e.h().toString());
                        a2.m();
                        u uVar4 = this.f33342e;
                        r0.p(uVar4.f33504c, uVar4.h().toString());
                        s sVar = this.f33342e.f33507f;
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
