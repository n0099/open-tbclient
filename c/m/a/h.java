package c.m.a;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.PBNativeListener;
import com.win.opensdk.core.Info;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class h implements View.OnClickListener, View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f23445b;

    /* renamed from: c  reason: collision with root package name */
    public long f23446c;

    /* renamed from: d  reason: collision with root package name */
    public int f23447d;

    /* renamed from: e  reason: collision with root package name */
    public int f23448e;

    /* renamed from: f  reason: collision with root package name */
    public long f23449f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ l f23450g;

    public h(l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f23450g = lVar;
    }

    public HashMap a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("dx", Integer.valueOf(this.a));
            hashMap.put("dy", Integer.valueOf(this.f23445b));
            hashMap.put("dts", Long.valueOf(this.f23446c));
            hashMap.put("ux", Integer.valueOf(this.f23447d));
            hashMap.put("uy", Integer.valueOf(this.f23448e));
            hashMap.put("uts", Long.valueOf(this.f23449f));
            l lVar = this.f23450g;
            r0.j(hashMap, lVar.p, lVar.q, lVar.r, lVar.s, lVar.t, lVar.u);
            return hashMap;
        }
        return (HashMap) invokeV.objValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.a = (int) motionEvent.getRawX();
                this.f23445b = (int) motionEvent.getRawY();
                this.f23446c = System.currentTimeMillis();
                this.f23450g.p = (int) motionEvent.getX();
                this.f23450g.q = (int) motionEvent.getY();
                l.e(this.f23450g, view);
                return false;
            } else if (action != 1) {
                return false;
            } else {
                this.f23447d = (int) motionEvent.getRawX();
                this.f23448e = (int) motionEvent.getRawY();
                this.f23449f = System.currentTimeMillis();
                this.f23450g.r = (int) motionEvent.getX();
                this.f23450g.s = (int) motionEvent.getY();
                l lVar = this.f23450g;
                Info info = lVar.f23481c;
                if (info == null || !v1.d(info, lVar.f23486h)) {
                    return false;
                }
                this.f23450g.f23486h = System.currentTimeMillis();
                l lVar2 = this.f23450g;
                Context context = lVar2.a;
                String open = lVar2.f23481c.getOpen();
                l lVar3 = this.f23450g;
                v1.a(context, open, lVar3.f23481c, lVar3.f23485g, a().toString());
                t2 a = x2.a(this.f23450g.a);
                a.h(new b3(this.f23450g.f23481c), null);
                a.l("desc", a().toString());
                a.m();
                r0.p(this.f23450g.f23481c, a().toString());
                PBNativeListener pBNativeListener = this.f23450g.f23484f;
                if (pBNativeListener != null) {
                    pBNativeListener.onClicked();
                    return false;
                }
                return false;
            }
        }
        return invokeLL.booleanValue;
    }
}
