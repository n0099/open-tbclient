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
    public int f30436e;

    /* renamed from: f  reason: collision with root package name */
    public int f30437f;

    /* renamed from: g  reason: collision with root package name */
    public long f30438g;

    /* renamed from: h  reason: collision with root package name */
    public int f30439h;

    /* renamed from: i  reason: collision with root package name */
    public int f30440i;

    /* renamed from: j  reason: collision with root package name */
    public long f30441j;
    public final /* synthetic */ u k;

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
        this.k = uVar;
    }

    public HashMap a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("dx", Integer.valueOf(this.f30436e));
            hashMap.put("dy", Integer.valueOf(this.f30437f));
            hashMap.put("dts", Long.valueOf(this.f30438g));
            hashMap.put("ux", Integer.valueOf(this.f30439h));
            hashMap.put("uy", Integer.valueOf(this.f30440i));
            hashMap.put("uts", Long.valueOf(this.f30441j));
            u uVar = this.k;
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
                this.f30436e = (int) motionEvent.getRawX();
                this.f30437f = (int) motionEvent.getRawY();
                this.f30438g = System.currentTimeMillis();
                this.k.p = (int) motionEvent.getX();
                this.k.q = (int) motionEvent.getY();
                u.d(this.k, view);
                return false;
            } else if (action != 1) {
                return false;
            } else {
                this.f30439h = (int) motionEvent.getRawX();
                this.f30440i = (int) motionEvent.getRawY();
                this.f30441j = System.currentTimeMillis();
                this.k.r = (int) motionEvent.getX();
                this.k.s = (int) motionEvent.getY();
                u uVar = this.k;
                Info info = uVar.f30497c;
                if (info == null || !a2.d(info, uVar.f30502h)) {
                    return false;
                }
                this.k.f30502h = System.currentTimeMillis();
                u uVar2 = this.k;
                Context context = uVar2.a;
                String open = uVar2.f30497c.getOpen();
                u uVar3 = this.k;
                a2.a(context, open, uVar3.f30497c, uVar3.f30501g, a().toString());
                y2 a = c3.a(this.k.a);
                a.h(new g3(this.k.f30497c), null);
                a.l("desc", a().toString());
                a.m();
                r0.p(this.k.f30497c, a().toString());
                s sVar = this.k.f30500f;
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
