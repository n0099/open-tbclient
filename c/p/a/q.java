package c.p.a;

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
    public int f31249e;

    /* renamed from: f  reason: collision with root package name */
    public int f31250f;

    /* renamed from: g  reason: collision with root package name */
    public long f31251g;

    /* renamed from: h  reason: collision with root package name */
    public int f31252h;

    /* renamed from: i  reason: collision with root package name */
    public int f31253i;

    /* renamed from: j  reason: collision with root package name */
    public long f31254j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ u f31255k;

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
        this.f31255k = uVar;
    }

    public HashMap a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("dx", Integer.valueOf(this.f31249e));
            hashMap.put("dy", Integer.valueOf(this.f31250f));
            hashMap.put("dts", Long.valueOf(this.f31251g));
            hashMap.put("ux", Integer.valueOf(this.f31252h));
            hashMap.put("uy", Integer.valueOf(this.f31253i));
            hashMap.put("uts", Long.valueOf(this.f31254j));
            u uVar = this.f31255k;
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
                this.f31249e = (int) motionEvent.getRawX();
                this.f31250f = (int) motionEvent.getRawY();
                this.f31251g = System.currentTimeMillis();
                this.f31255k.p = (int) motionEvent.getX();
                this.f31255k.q = (int) motionEvent.getY();
                u.d(this.f31255k, view);
                return false;
            } else if (action != 1) {
                return false;
            } else {
                this.f31252h = (int) motionEvent.getRawX();
                this.f31253i = (int) motionEvent.getRawY();
                this.f31254j = System.currentTimeMillis();
                this.f31255k.r = (int) motionEvent.getX();
                this.f31255k.s = (int) motionEvent.getY();
                u uVar = this.f31255k;
                Info info = uVar.f31314c;
                if (info == null || !a2.d(info, uVar.f31319h)) {
                    return false;
                }
                this.f31255k.f31319h = System.currentTimeMillis();
                u uVar2 = this.f31255k;
                Context context = uVar2.a;
                String open = uVar2.f31314c.getOpen();
                u uVar3 = this.f31255k;
                a2.a(context, open, uVar3.f31314c, uVar3.f31318g, a().toString());
                y2 a = c3.a(this.f31255k.a);
                a.h(new g3(this.f31255k.f31314c), null);
                a.l("desc", a().toString());
                a.m();
                r0.p(this.f31255k.f31314c, a().toString());
                s sVar = this.f31255k.f31317f;
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
