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
import com.win.opensdk.core.Info;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class m2 implements View.OnClickListener, View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f23492b;

    /* renamed from: c  reason: collision with root package name */
    public long f23493c;

    /* renamed from: d  reason: collision with root package name */
    public int f23494d;

    /* renamed from: e  reason: collision with root package name */
    public int f23495e;

    /* renamed from: f  reason: collision with root package name */
    public long f23496f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ p2 f23497g;

    public m2(p2 p2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {p2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f23497g = p2Var;
    }

    public HashMap a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("dx", Integer.valueOf(this.a));
            hashMap.put("dy", Integer.valueOf(this.f23492b));
            hashMap.put("dts", Long.valueOf(this.f23493c));
            hashMap.put("ux", Integer.valueOf(this.f23494d));
            hashMap.put("uy", Integer.valueOf(this.f23495e));
            hashMap.put("uts", Long.valueOf(this.f23496f));
            p2 p2Var = this.f23497g;
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
                this.a = (int) motionEvent.getRawX();
                this.f23492b = (int) motionEvent.getRawY();
                this.f23493c = System.currentTimeMillis();
                this.f23497g.p = (int) motionEvent.getX();
                this.f23497g.q = (int) motionEvent.getY();
                p2.c(this.f23497g, view);
                return false;
            } else if (action != 1) {
                return false;
            } else {
                this.f23494d = (int) motionEvent.getRawX();
                this.f23495e = (int) motionEvent.getRawY();
                this.f23496f = System.currentTimeMillis();
                this.f23497g.r = (int) motionEvent.getX();
                this.f23497g.s = (int) motionEvent.getY();
                p2 p2Var = this.f23497g;
                Info info = p2Var.f23529c;
                if (info == null || !v1.d(info, p2Var.f23534h)) {
                    return false;
                }
                this.f23497g.f23534h = System.currentTimeMillis();
                p2 p2Var2 = this.f23497g;
                Context context = p2Var2.a;
                String open = p2Var2.f23529c.getOpen();
                p2 p2Var3 = this.f23497g;
                v1.a(context, open, p2Var3.f23529c, p2Var3.f23533g, a().toString());
                t2 a = x2.a(this.f23497g.a);
                a.h(new b3(this.f23497g.f23529c), null);
                a.l("desc", a().toString());
                a.m();
                r0.p(this.f23497g.f23529c, a().toString());
                d3 d3Var = this.f23497g.f23532f;
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
