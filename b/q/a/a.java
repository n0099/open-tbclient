package b.q.a;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.PBNativeListener;
import com.win.opensdk.core.Info;
/* loaded from: classes6.dex */
public class a implements View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ l f33230e;

    public a(l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f33230e = lVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Info info;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f33230e.j = true;
                this.f33230e.k = System.currentTimeMillis();
                this.f33230e.l = motionEvent.getX();
                this.f33230e.m = motionEvent.getY();
                this.f33230e.n = (int) motionEvent.getRawX();
                this.f33230e.o = (int) motionEvent.getRawY();
                this.f33230e.p = (int) motionEvent.getX();
                this.f33230e.q = (int) motionEvent.getY();
                this.f33230e.v = System.currentTimeMillis();
                l.e(this.f33230e, view);
            } else if (action == 1) {
                this.f33230e.w = (int) motionEvent.getRawX();
                this.f33230e.x = (int) motionEvent.getRawY();
                this.f33230e.r = (int) motionEvent.getX();
                this.f33230e.s = (int) motionEvent.getY();
                this.f33230e.y = System.currentTimeMillis();
                Math.abs(motionEvent.getX() - this.f33230e.l);
                Math.abs(motionEvent.getY() - this.f33230e.m);
                if (System.currentTimeMillis() - this.f33230e.k < 2000) {
                    l lVar = this.f33230e;
                    if (lVar.j && (info = lVar.f33377c) != null && a2.d(info, lVar.f33382h)) {
                        this.f33230e.f33382h = System.currentTimeMillis();
                        l lVar2 = this.f33230e;
                        Context context = lVar2.f33375a;
                        String open = lVar2.f33377c.getOpen();
                        l lVar3 = this.f33230e;
                        a2.a(context, open, lVar3.f33377c, lVar3.f33381g, lVar3.i().toString());
                        y2 a2 = c3.a(this.f33230e.f33375a);
                        a2.h(new g3(this.f33230e.f33377c), null);
                        a2.l("desc", this.f33230e.i().toString());
                        a2.m();
                        l lVar4 = this.f33230e;
                        r0.p(lVar4.f33377c, lVar4.i().toString());
                        PBNativeListener pBNativeListener = this.f33230e.f33380f;
                        if (pBNativeListener != null) {
                            pBNativeListener.onClicked();
                        }
                    }
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
