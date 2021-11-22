package b.o.a;

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
    public final /* synthetic */ u f34176e;

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
        this.f34176e = uVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Info info;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f34176e.j = true;
                this.f34176e.k = System.currentTimeMillis();
                this.f34176e.l = motionEvent.getX();
                this.f34176e.m = motionEvent.getY();
                this.f34176e.n = (int) motionEvent.getRawX();
                this.f34176e.o = (int) motionEvent.getRawY();
                this.f34176e.v = System.currentTimeMillis();
                this.f34176e.p = (int) motionEvent.getX();
                this.f34176e.q = (int) motionEvent.getY();
                u.d(this.f34176e, view);
            } else if (action == 1) {
                this.f34176e.w = (int) motionEvent.getRawX();
                this.f34176e.x = (int) motionEvent.getRawY();
                this.f34176e.r = (int) motionEvent.getX();
                this.f34176e.s = (int) motionEvent.getY();
                this.f34176e.y = System.currentTimeMillis();
                Math.abs(motionEvent.getX() - this.f34176e.l);
                Math.abs(motionEvent.getY() - this.f34176e.m);
                if (System.currentTimeMillis() - this.f34176e.k < 2000) {
                    u uVar = this.f34176e;
                    if (uVar.j && (info = uVar.f34338c) != null && a2.d(info, uVar.f34343h)) {
                        this.f34176e.f34343h = System.currentTimeMillis();
                        u uVar2 = this.f34176e;
                        Context context = uVar2.f34336a;
                        String open = uVar2.f34338c.getOpen();
                        u uVar3 = this.f34176e;
                        a2.a(context, open, uVar3.f34338c, uVar3.f34342g, uVar3.h().toString());
                        y2 a2 = c3.a(this.f34176e.f34336a);
                        a2.h(new g3(this.f34176e.f34338c), null);
                        a2.l("desc", this.f34176e.h().toString());
                        a2.m();
                        u uVar4 = this.f34176e;
                        r0.p(uVar4.f34338c, uVar4.h().toString());
                        s sVar = this.f34176e.f34341f;
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
