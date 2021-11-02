package b.q.a;

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
/* loaded from: classes6.dex */
public class q implements View.OnClickListener, View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f33437e;

    /* renamed from: f  reason: collision with root package name */
    public int f33438f;

    /* renamed from: g  reason: collision with root package name */
    public long f33439g;

    /* renamed from: h  reason: collision with root package name */
    public int f33440h;

    /* renamed from: i  reason: collision with root package name */
    public int f33441i;
    public long j;
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
            hashMap.put("dx", Integer.valueOf(this.f33437e));
            hashMap.put("dy", Integer.valueOf(this.f33438f));
            hashMap.put("dts", Long.valueOf(this.f33439g));
            hashMap.put("ux", Integer.valueOf(this.f33440h));
            hashMap.put("uy", Integer.valueOf(this.f33441i));
            hashMap.put("uts", Long.valueOf(this.j));
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
                this.f33437e = (int) motionEvent.getRawX();
                this.f33438f = (int) motionEvent.getRawY();
                this.f33439g = System.currentTimeMillis();
                this.k.p = (int) motionEvent.getX();
                this.k.q = (int) motionEvent.getY();
                u.d(this.k, view);
                return false;
            } else if (action != 1) {
                return false;
            } else {
                this.f33440h = (int) motionEvent.getRawX();
                this.f33441i = (int) motionEvent.getRawY();
                this.j = System.currentTimeMillis();
                this.k.r = (int) motionEvent.getX();
                this.k.s = (int) motionEvent.getY();
                u uVar = this.k;
                Info info = uVar.f33504c;
                if (info == null || !a2.d(info, uVar.f33509h)) {
                    return false;
                }
                this.k.f33509h = System.currentTimeMillis();
                u uVar2 = this.k;
                Context context = uVar2.f33502a;
                String open = uVar2.f33504c.getOpen();
                u uVar3 = this.k;
                a2.a(context, open, uVar3.f33504c, uVar3.f33508g, a().toString());
                y2 a2 = c3.a(this.k.f33502a);
                a2.h(new g3(this.k.f33504c), null);
                a2.l("desc", a().toString());
                a2.m();
                r0.p(this.k.f33504c, a().toString());
                s sVar = this.k.f33507f;
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
