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
public class i implements View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ u f31174e;

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
        this.f31174e = uVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Info info;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f31174e.f31321j = true;
                this.f31174e.f31322k = System.currentTimeMillis();
                this.f31174e.l = motionEvent.getX();
                this.f31174e.m = motionEvent.getY();
                this.f31174e.n = (int) motionEvent.getRawX();
                this.f31174e.o = (int) motionEvent.getRawY();
                this.f31174e.v = System.currentTimeMillis();
                this.f31174e.p = (int) motionEvent.getX();
                this.f31174e.q = (int) motionEvent.getY();
                u.d(this.f31174e, view);
            } else if (action == 1) {
                this.f31174e.w = (int) motionEvent.getRawX();
                this.f31174e.x = (int) motionEvent.getRawY();
                this.f31174e.r = (int) motionEvent.getX();
                this.f31174e.s = (int) motionEvent.getY();
                this.f31174e.y = System.currentTimeMillis();
                Math.abs(motionEvent.getX() - this.f31174e.l);
                Math.abs(motionEvent.getY() - this.f31174e.m);
                if (System.currentTimeMillis() - this.f31174e.f31322k < 2000) {
                    u uVar = this.f31174e;
                    if (uVar.f31321j && (info = uVar.f31314c) != null && a2.d(info, uVar.f31319h)) {
                        this.f31174e.f31319h = System.currentTimeMillis();
                        u uVar2 = this.f31174e;
                        Context context = uVar2.a;
                        String open = uVar2.f31314c.getOpen();
                        u uVar3 = this.f31174e;
                        a2.a(context, open, uVar3.f31314c, uVar3.f31318g, uVar3.h().toString());
                        y2 a = c3.a(this.f31174e.a);
                        a.h(new g3(this.f31174e.f31314c), null);
                        a.l("desc", this.f31174e.h().toString());
                        a.m();
                        u uVar4 = this.f31174e;
                        r0.p(uVar4.f31314c, uVar4.h().toString());
                        s sVar = this.f31174e.f31317f;
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
