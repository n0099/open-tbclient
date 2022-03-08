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
/* loaded from: classes3.dex */
public class a implements View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ l f28904e;

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
        this.f28904e = lVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Info info;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f28904e.f29016j = true;
                this.f28904e.k = System.currentTimeMillis();
                this.f28904e.l = motionEvent.getX();
                this.f28904e.m = motionEvent.getY();
                this.f28904e.n = (int) motionEvent.getRawX();
                this.f28904e.o = (int) motionEvent.getRawY();
                this.f28904e.p = (int) motionEvent.getX();
                this.f28904e.q = (int) motionEvent.getY();
                this.f28904e.v = System.currentTimeMillis();
                l.e(this.f28904e, view);
            } else if (action == 1) {
                this.f28904e.w = (int) motionEvent.getRawX();
                this.f28904e.x = (int) motionEvent.getRawY();
                this.f28904e.r = (int) motionEvent.getX();
                this.f28904e.s = (int) motionEvent.getY();
                this.f28904e.y = System.currentTimeMillis();
                Math.abs(motionEvent.getX() - this.f28904e.l);
                Math.abs(motionEvent.getY() - this.f28904e.m);
                if (System.currentTimeMillis() - this.f28904e.k < 2000) {
                    l lVar = this.f28904e;
                    if (lVar.f29016j && (info = lVar.f29009c) != null && v1.d(info, lVar.f29014h)) {
                        this.f28904e.f29014h = System.currentTimeMillis();
                        l lVar2 = this.f28904e;
                        Context context = lVar2.a;
                        String open = lVar2.f29009c.getOpen();
                        l lVar3 = this.f28904e;
                        v1.a(context, open, lVar3.f29009c, lVar3.f29013g, lVar3.i().toString());
                        t2 a = x2.a(this.f28904e.a);
                        a.h(new b3(this.f28904e.f29009c), null);
                        a.l("desc", this.f28904e.i().toString());
                        a.m();
                        l lVar4 = this.f28904e;
                        r0.p(lVar4.f29009c, lVar4.i().toString());
                        PBNativeListener pBNativeListener = this.f28904e.f29012f;
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
