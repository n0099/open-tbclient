package c.q.a;

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
/* loaded from: classes9.dex */
public class a implements View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ l f31242e;

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
        this.f31242e = lVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Info info;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f31242e.f31347j = true;
                this.f31242e.f31348k = System.currentTimeMillis();
                this.f31242e.l = motionEvent.getX();
                this.f31242e.m = motionEvent.getY();
                this.f31242e.n = (int) motionEvent.getRawX();
                this.f31242e.o = (int) motionEvent.getRawY();
                this.f31242e.p = (int) motionEvent.getX();
                this.f31242e.q = (int) motionEvent.getY();
                this.f31242e.v = System.currentTimeMillis();
                l.e(this.f31242e, view);
            } else if (action == 1) {
                this.f31242e.w = (int) motionEvent.getRawX();
                this.f31242e.x = (int) motionEvent.getRawY();
                this.f31242e.r = (int) motionEvent.getX();
                this.f31242e.s = (int) motionEvent.getY();
                this.f31242e.y = System.currentTimeMillis();
                Math.abs(motionEvent.getX() - this.f31242e.l);
                Math.abs(motionEvent.getY() - this.f31242e.m);
                if (System.currentTimeMillis() - this.f31242e.f31348k < 2000) {
                    l lVar = this.f31242e;
                    if (lVar.f31347j && (info = lVar.f31340c) != null && a2.d(info, lVar.f31345h)) {
                        this.f31242e.f31345h = System.currentTimeMillis();
                        l lVar2 = this.f31242e;
                        Context context = lVar2.a;
                        String open = lVar2.f31340c.getOpen();
                        l lVar3 = this.f31242e;
                        a2.a(context, open, lVar3.f31340c, lVar3.f31344g, lVar3.i().toString());
                        y2 a = c3.a(this.f31242e.a);
                        a.h(new g3(this.f31242e.f31340c), null);
                        a.l("desc", this.f31242e.i().toString());
                        a.m();
                        l lVar4 = this.f31242e;
                        r0.p(lVar4.f31340c, lVar4.i().toString());
                        PBNativeListener pBNativeListener = this.f31242e.f31343f;
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
