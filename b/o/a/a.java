package b.o.a;

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
    public final /* synthetic */ l f34064e;

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
        this.f34064e = lVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Info info;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f34064e.j = true;
                this.f34064e.k = System.currentTimeMillis();
                this.f34064e.l = motionEvent.getX();
                this.f34064e.m = motionEvent.getY();
                this.f34064e.n = (int) motionEvent.getRawX();
                this.f34064e.o = (int) motionEvent.getRawY();
                this.f34064e.p = (int) motionEvent.getX();
                this.f34064e.q = (int) motionEvent.getY();
                this.f34064e.v = System.currentTimeMillis();
                l.e(this.f34064e, view);
            } else if (action == 1) {
                this.f34064e.w = (int) motionEvent.getRawX();
                this.f34064e.x = (int) motionEvent.getRawY();
                this.f34064e.r = (int) motionEvent.getX();
                this.f34064e.s = (int) motionEvent.getY();
                this.f34064e.y = System.currentTimeMillis();
                Math.abs(motionEvent.getX() - this.f34064e.l);
                Math.abs(motionEvent.getY() - this.f34064e.m);
                if (System.currentTimeMillis() - this.f34064e.k < 2000) {
                    l lVar = this.f34064e;
                    if (lVar.j && (info = lVar.f34211c) != null && a2.d(info, lVar.f34216h)) {
                        this.f34064e.f34216h = System.currentTimeMillis();
                        l lVar2 = this.f34064e;
                        Context context = lVar2.f34209a;
                        String open = lVar2.f34211c.getOpen();
                        l lVar3 = this.f34064e;
                        a2.a(context, open, lVar3.f34211c, lVar3.f34215g, lVar3.i().toString());
                        y2 a2 = c3.a(this.f34064e.f34209a);
                        a2.h(new g3(this.f34064e.f34211c), null);
                        a2.l("desc", this.f34064e.i().toString());
                        a2.m();
                        l lVar4 = this.f34064e;
                        r0.p(lVar4.f34211c, lVar4.i().toString());
                        PBNativeListener pBNativeListener = this.f34064e.f34214f;
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
