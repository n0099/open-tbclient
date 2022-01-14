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
    public final /* synthetic */ l f30266e;

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
        this.f30266e = lVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Info info;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f30266e.f30367j = true;
                this.f30266e.k = System.currentTimeMillis();
                this.f30266e.l = motionEvent.getX();
                this.f30266e.m = motionEvent.getY();
                this.f30266e.n = (int) motionEvent.getRawX();
                this.f30266e.o = (int) motionEvent.getRawY();
                this.f30266e.p = (int) motionEvent.getX();
                this.f30266e.q = (int) motionEvent.getY();
                this.f30266e.v = System.currentTimeMillis();
                l.e(this.f30266e, view);
            } else if (action == 1) {
                this.f30266e.w = (int) motionEvent.getRawX();
                this.f30266e.x = (int) motionEvent.getRawY();
                this.f30266e.r = (int) motionEvent.getX();
                this.f30266e.s = (int) motionEvent.getY();
                this.f30266e.y = System.currentTimeMillis();
                Math.abs(motionEvent.getX() - this.f30266e.l);
                Math.abs(motionEvent.getY() - this.f30266e.m);
                if (System.currentTimeMillis() - this.f30266e.k < 2000) {
                    l lVar = this.f30266e;
                    if (lVar.f30367j && (info = lVar.f30360c) != null && a2.d(info, lVar.f30365h)) {
                        this.f30266e.f30365h = System.currentTimeMillis();
                        l lVar2 = this.f30266e;
                        Context context = lVar2.a;
                        String open = lVar2.f30360c.getOpen();
                        l lVar3 = this.f30266e;
                        a2.a(context, open, lVar3.f30360c, lVar3.f30364g, lVar3.i().toString());
                        y2 a = c3.a(this.f30266e.a);
                        a.h(new g3(this.f30266e.f30360c), null);
                        a.l("desc", this.f30266e.i().toString());
                        a.m();
                        l lVar4 = this.f30266e;
                        r0.p(lVar4.f30360c, lVar4.i().toString());
                        PBNativeListener pBNativeListener = this.f30266e.f30363f;
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
