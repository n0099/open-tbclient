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
/* loaded from: classes9.dex */
public class r2 implements View.OnClickListener, View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f30447e;

    /* renamed from: f  reason: collision with root package name */
    public int f30448f;

    /* renamed from: g  reason: collision with root package name */
    public long f30449g;

    /* renamed from: h  reason: collision with root package name */
    public int f30450h;

    /* renamed from: i  reason: collision with root package name */
    public int f30451i;

    /* renamed from: j  reason: collision with root package name */
    public long f30452j;
    public final /* synthetic */ u2 k;

    public r2(u2 u2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {u2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = u2Var;
    }

    public HashMap a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("dx", Integer.valueOf(this.f30447e));
            hashMap.put("dy", Integer.valueOf(this.f30448f));
            hashMap.put("dts", Long.valueOf(this.f30449g));
            hashMap.put("ux", Integer.valueOf(this.f30450h));
            hashMap.put("uy", Integer.valueOf(this.f30451i));
            hashMap.put("uts", Long.valueOf(this.f30452j));
            u2 u2Var = this.k;
            r0.j(hashMap, u2Var.p, u2Var.q, u2Var.r, u2Var.s, u2Var.t, u2Var.u);
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
                this.f30447e = (int) motionEvent.getRawX();
                this.f30448f = (int) motionEvent.getRawY();
                this.f30449g = System.currentTimeMillis();
                this.k.p = (int) motionEvent.getX();
                this.k.q = (int) motionEvent.getY();
                u2.c(this.k, view);
                return false;
            } else if (action != 1) {
                return false;
            } else {
                this.f30450h = (int) motionEvent.getRawX();
                this.f30451i = (int) motionEvent.getRawY();
                this.f30452j = System.currentTimeMillis();
                this.k.r = (int) motionEvent.getX();
                this.k.s = (int) motionEvent.getY();
                u2 u2Var = this.k;
                Info info = u2Var.f30511c;
                if (info == null || !a2.d(info, u2Var.f30516h)) {
                    return false;
                }
                this.k.f30516h = System.currentTimeMillis();
                u2 u2Var2 = this.k;
                Context context = u2Var2.a;
                String open = u2Var2.f30511c.getOpen();
                u2 u2Var3 = this.k;
                a2.a(context, open, u2Var3.f30511c, u2Var3.f30515g, a().toString());
                y2 a = c3.a(this.k.a);
                a.h(new g3(this.k.f30511c), null);
                a.l("desc", a().toString());
                a.m();
                r0.p(this.k.f30511c, a().toString());
                i3 i3Var = this.k.f30514f;
                if (i3Var != null) {
                    i3Var.onClicked();
                    return false;
                }
                return false;
            }
        }
        return invokeLL.booleanValue;
    }
}
