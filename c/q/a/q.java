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
public class q implements View.OnClickListener, View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f31392e;

    /* renamed from: f  reason: collision with root package name */
    public int f31393f;

    /* renamed from: g  reason: collision with root package name */
    public long f31394g;

    /* renamed from: h  reason: collision with root package name */
    public int f31395h;

    /* renamed from: i  reason: collision with root package name */
    public int f31396i;

    /* renamed from: j  reason: collision with root package name */
    public long f31397j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ u f31398k;

    public q(u uVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f31398k = uVar;
    }

    public HashMap a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("dx", Integer.valueOf(this.f31392e));
            hashMap.put("dy", Integer.valueOf(this.f31393f));
            hashMap.put("dts", Long.valueOf(this.f31394g));
            hashMap.put("ux", Integer.valueOf(this.f31395h));
            hashMap.put("uy", Integer.valueOf(this.f31396i));
            hashMap.put("uts", Long.valueOf(this.f31397j));
            u uVar = this.f31398k;
            r0.j(hashMap, uVar.p, uVar.q, uVar.r, uVar.s, uVar.t, uVar.u);
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
                this.f31392e = (int) motionEvent.getRawX();
                this.f31393f = (int) motionEvent.getRawY();
                this.f31394g = System.currentTimeMillis();
                this.f31398k.p = (int) motionEvent.getX();
                this.f31398k.q = (int) motionEvent.getY();
                u.d(this.f31398k, view);
                return false;
            } else if (action != 1) {
                return false;
            } else {
                this.f31395h = (int) motionEvent.getRawX();
                this.f31396i = (int) motionEvent.getRawY();
                this.f31397j = System.currentTimeMillis();
                this.f31398k.r = (int) motionEvent.getX();
                this.f31398k.s = (int) motionEvent.getY();
                u uVar = this.f31398k;
                Info info = uVar.f31457c;
                if (info == null || !a2.d(info, uVar.f31462h)) {
                    return false;
                }
                this.f31398k.f31462h = System.currentTimeMillis();
                u uVar2 = this.f31398k;
                Context context = uVar2.a;
                String open = uVar2.f31457c.getOpen();
                u uVar3 = this.f31398k;
                a2.a(context, open, uVar3.f31457c, uVar3.f31461g, a().toString());
                y2 a = c3.a(this.f31398k.a);
                a.h(new g3(this.f31398k.f31457c), null);
                a.l("desc", a().toString());
                a.m();
                r0.p(this.f31398k.f31457c, a().toString());
                s sVar = this.f31398k.f31460f;
                if (sVar != null) {
                    sVar.onClicked();
                    return false;
                }
                return false;
            }
        }
        return invokeLL.booleanValue;
    }
}
