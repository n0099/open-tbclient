package c.q.a;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.core.Info;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class m2 implements View.OnClickListener, View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f29024e;

    /* renamed from: f  reason: collision with root package name */
    public int f29025f;

    /* renamed from: g  reason: collision with root package name */
    public long f29026g;

    /* renamed from: h  reason: collision with root package name */
    public int f29027h;

    /* renamed from: i  reason: collision with root package name */
    public int f29028i;

    /* renamed from: j  reason: collision with root package name */
    public long f29029j;
    public final /* synthetic */ p2 k;

    public m2(p2 p2Var) {
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
        this.k = p2Var;
    }

    public HashMap a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("dx", Integer.valueOf(this.f29024e));
            hashMap.put("dy", Integer.valueOf(this.f29025f));
            hashMap.put("dts", Long.valueOf(this.f29026g));
            hashMap.put("ux", Integer.valueOf(this.f29027h));
            hashMap.put("uy", Integer.valueOf(this.f29028i));
            hashMap.put("uts", Long.valueOf(this.f29029j));
            p2 p2Var = this.k;
            r0.j(hashMap, p2Var.p, p2Var.q, p2Var.r, p2Var.s, p2Var.t, p2Var.u);
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
                this.f29024e = (int) motionEvent.getRawX();
                this.f29025f = (int) motionEvent.getRawY();
                this.f29026g = System.currentTimeMillis();
                this.k.p = (int) motionEvent.getX();
                this.k.q = (int) motionEvent.getY();
                p2.c(this.k, view);
                return false;
            } else if (action != 1) {
                return false;
            } else {
                this.f29027h = (int) motionEvent.getRawX();
                this.f29028i = (int) motionEvent.getRawY();
                this.f29029j = System.currentTimeMillis();
                this.k.r = (int) motionEvent.getX();
                this.k.s = (int) motionEvent.getY();
                p2 p2Var = this.k;
                Info info = p2Var.f29070c;
                if (info == null || !v1.d(info, p2Var.f29075h)) {
                    return false;
                }
                this.k.f29075h = System.currentTimeMillis();
                p2 p2Var2 = this.k;
                Context context = p2Var2.a;
                String open = p2Var2.f29070c.getOpen();
                p2 p2Var3 = this.k;
                v1.a(context, open, p2Var3.f29070c, p2Var3.f29074g, a().toString());
                t2 a = x2.a(this.k.a);
                a.h(new b3(this.k.f29070c), null);
                a.l("desc", a().toString());
                a.m();
                r0.p(this.k.f29070c, a().toString());
                d3 d3Var = this.k.f29073f;
                if (d3Var != null) {
                    d3Var.onClicked();
                    return false;
                }
                return false;
            }
        }
        return invokeLL.booleanValue;
    }
}
