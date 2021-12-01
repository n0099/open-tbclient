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
public class i implements View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ u f30804e;

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
        this.f30804e = uVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Info info;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f30804e.f30951j = true;
                this.f30804e.f30952k = System.currentTimeMillis();
                this.f30804e.l = motionEvent.getX();
                this.f30804e.m = motionEvent.getY();
                this.f30804e.n = (int) motionEvent.getRawX();
                this.f30804e.o = (int) motionEvent.getRawY();
                this.f30804e.v = System.currentTimeMillis();
                this.f30804e.p = (int) motionEvent.getX();
                this.f30804e.q = (int) motionEvent.getY();
                u.d(this.f30804e, view);
            } else if (action == 1) {
                this.f30804e.w = (int) motionEvent.getRawX();
                this.f30804e.x = (int) motionEvent.getRawY();
                this.f30804e.r = (int) motionEvent.getX();
                this.f30804e.s = (int) motionEvent.getY();
                this.f30804e.y = System.currentTimeMillis();
                Math.abs(motionEvent.getX() - this.f30804e.l);
                Math.abs(motionEvent.getY() - this.f30804e.m);
                if (System.currentTimeMillis() - this.f30804e.f30952k < 2000) {
                    u uVar = this.f30804e;
                    if (uVar.f30951j && (info = uVar.f30944c) != null && a2.d(info, uVar.f30949h)) {
                        this.f30804e.f30949h = System.currentTimeMillis();
                        u uVar2 = this.f30804e;
                        Context context = uVar2.a;
                        String open = uVar2.f30944c.getOpen();
                        u uVar3 = this.f30804e;
                        a2.a(context, open, uVar3.f30944c, uVar3.f30948g, uVar3.h().toString());
                        y2 a = c3.a(this.f30804e.a);
                        a.h(new g3(this.f30804e.f30944c), null);
                        a.l("desc", this.f30804e.h().toString());
                        a.m();
                        u uVar4 = this.f30804e;
                        r0.p(uVar4.f30944c, uVar4.h().toString());
                        s sVar = this.f30804e.f30947f;
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
