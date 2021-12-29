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
    public final /* synthetic */ u f31317e;

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
        this.f31317e = uVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Info info;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f31317e.f31464j = true;
                this.f31317e.f31465k = System.currentTimeMillis();
                this.f31317e.l = motionEvent.getX();
                this.f31317e.m = motionEvent.getY();
                this.f31317e.n = (int) motionEvent.getRawX();
                this.f31317e.o = (int) motionEvent.getRawY();
                this.f31317e.v = System.currentTimeMillis();
                this.f31317e.p = (int) motionEvent.getX();
                this.f31317e.q = (int) motionEvent.getY();
                u.d(this.f31317e, view);
            } else if (action == 1) {
                this.f31317e.w = (int) motionEvent.getRawX();
                this.f31317e.x = (int) motionEvent.getRawY();
                this.f31317e.r = (int) motionEvent.getX();
                this.f31317e.s = (int) motionEvent.getY();
                this.f31317e.y = System.currentTimeMillis();
                Math.abs(motionEvent.getX() - this.f31317e.l);
                Math.abs(motionEvent.getY() - this.f31317e.m);
                if (System.currentTimeMillis() - this.f31317e.f31465k < 2000) {
                    u uVar = this.f31317e;
                    if (uVar.f31464j && (info = uVar.f31457c) != null && a2.d(info, uVar.f31462h)) {
                        this.f31317e.f31462h = System.currentTimeMillis();
                        u uVar2 = this.f31317e;
                        Context context = uVar2.a;
                        String open = uVar2.f31457c.getOpen();
                        u uVar3 = this.f31317e;
                        a2.a(context, open, uVar3.f31457c, uVar3.f31461g, uVar3.h().toString());
                        y2 a = c3.a(this.f31317e.a);
                        a.h(new g3(this.f31317e.f31457c), null);
                        a.l("desc", this.f31317e.h().toString());
                        a.m();
                        u uVar4 = this.f31317e;
                        r0.p(uVar4.f31457c, uVar4.h().toString());
                        s sVar = this.f31317e.f31460f;
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
