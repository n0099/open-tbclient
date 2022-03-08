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
public class i2 implements View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ p2 f28982e;

    public i2(p2 p2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {p2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f28982e = p2Var;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Info info;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f28982e.f29077j = true;
                this.f28982e.k = System.currentTimeMillis();
                this.f28982e.l = motionEvent.getX();
                this.f28982e.m = motionEvent.getY();
                this.f28982e.n = (int) motionEvent.getRawX();
                this.f28982e.o = (int) motionEvent.getRawY();
                this.f28982e.v = System.currentTimeMillis();
                this.f28982e.p = (int) motionEvent.getX();
                this.f28982e.q = (int) motionEvent.getY();
                p2.c(this.f28982e, view);
            } else if (action == 1) {
                this.f28982e.w = (int) motionEvent.getRawX();
                this.f28982e.x = (int) motionEvent.getRawY();
                this.f28982e.r = (int) motionEvent.getX();
                this.f28982e.s = (int) motionEvent.getY();
                this.f28982e.y = System.currentTimeMillis();
                Math.abs(motionEvent.getX() - this.f28982e.l);
                Math.abs(motionEvent.getY() - this.f28982e.m);
                if (System.currentTimeMillis() - this.f28982e.k < 2000) {
                    p2 p2Var = this.f28982e;
                    if (p2Var.f29077j && (info = p2Var.f29070c) != null && v1.d(info, p2Var.f29075h)) {
                        this.f28982e.f29075h = System.currentTimeMillis();
                        p2 p2Var2 = this.f28982e;
                        Context context = p2Var2.a;
                        String open = p2Var2.f29070c.getOpen();
                        p2 p2Var3 = this.f28982e;
                        v1.a(context, open, p2Var3.f29070c, p2Var3.f29074g, p2Var3.g().toString());
                        t2 a = x2.a(this.f28982e.a);
                        a.h(new b3(this.f28982e.f29070c), null);
                        a.l("desc", this.f28982e.g().toString());
                        a.m();
                        p2 p2Var4 = this.f28982e;
                        r0.p(p2Var4.f29070c, p2Var4.g().toString());
                        d3 d3Var = this.f28982e.f29073f;
                        if (d3Var != null) {
                            d3Var.onClicked();
                        }
                    }
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
