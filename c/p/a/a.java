package c.p.a;

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
    public final /* synthetic */ l f31099e;

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
        this.f31099e = lVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Info info;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f31099e.f31204j = true;
                this.f31099e.f31205k = System.currentTimeMillis();
                this.f31099e.l = motionEvent.getX();
                this.f31099e.m = motionEvent.getY();
                this.f31099e.n = (int) motionEvent.getRawX();
                this.f31099e.o = (int) motionEvent.getRawY();
                this.f31099e.p = (int) motionEvent.getX();
                this.f31099e.q = (int) motionEvent.getY();
                this.f31099e.v = System.currentTimeMillis();
                l.e(this.f31099e, view);
            } else if (action == 1) {
                this.f31099e.w = (int) motionEvent.getRawX();
                this.f31099e.x = (int) motionEvent.getRawY();
                this.f31099e.r = (int) motionEvent.getX();
                this.f31099e.s = (int) motionEvent.getY();
                this.f31099e.y = System.currentTimeMillis();
                Math.abs(motionEvent.getX() - this.f31099e.l);
                Math.abs(motionEvent.getY() - this.f31099e.m);
                if (System.currentTimeMillis() - this.f31099e.f31205k < 2000) {
                    l lVar = this.f31099e;
                    if (lVar.f31204j && (info = lVar.f31197c) != null && a2.d(info, lVar.f31202h)) {
                        this.f31099e.f31202h = System.currentTimeMillis();
                        l lVar2 = this.f31099e;
                        Context context = lVar2.a;
                        String open = lVar2.f31197c.getOpen();
                        l lVar3 = this.f31099e;
                        a2.a(context, open, lVar3.f31197c, lVar3.f31201g, lVar3.i().toString());
                        y2 a = c3.a(this.f31099e.a);
                        a.h(new g3(this.f31099e.f31197c), null);
                        a.l("desc", this.f31099e.i().toString());
                        a.m();
                        l lVar4 = this.f31099e;
                        r0.p(lVar4.f31197c, lVar4.i().toString());
                        PBNativeListener pBNativeListener = this.f31099e.f31200f;
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
