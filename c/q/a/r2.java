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
    public int f31404e;

    /* renamed from: f  reason: collision with root package name */
    public int f31405f;

    /* renamed from: g  reason: collision with root package name */
    public long f31406g;

    /* renamed from: h  reason: collision with root package name */
    public int f31407h;

    /* renamed from: i  reason: collision with root package name */
    public int f31408i;

    /* renamed from: j  reason: collision with root package name */
    public long f31409j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ u2 f31410k;

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
        this.f31410k = u2Var;
    }

    public HashMap a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("dx", Integer.valueOf(this.f31404e));
            hashMap.put("dy", Integer.valueOf(this.f31405f));
            hashMap.put("dts", Long.valueOf(this.f31406g));
            hashMap.put("ux", Integer.valueOf(this.f31407h));
            hashMap.put("uy", Integer.valueOf(this.f31408i));
            hashMap.put("uts", Long.valueOf(this.f31409j));
            u2 u2Var = this.f31410k;
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
                this.f31404e = (int) motionEvent.getRawX();
                this.f31405f = (int) motionEvent.getRawY();
                this.f31406g = System.currentTimeMillis();
                this.f31410k.p = (int) motionEvent.getX();
                this.f31410k.q = (int) motionEvent.getY();
                u2.c(this.f31410k, view);
                return false;
            } else if (action != 1) {
                return false;
            } else {
                this.f31407h = (int) motionEvent.getRawX();
                this.f31408i = (int) motionEvent.getRawY();
                this.f31409j = System.currentTimeMillis();
                this.f31410k.r = (int) motionEvent.getX();
                this.f31410k.s = (int) motionEvent.getY();
                u2 u2Var = this.f31410k;
                Info info = u2Var.f31472c;
                if (info == null || !a2.d(info, u2Var.f31477h)) {
                    return false;
                }
                this.f31410k.f31477h = System.currentTimeMillis();
                u2 u2Var2 = this.f31410k;
                Context context = u2Var2.a;
                String open = u2Var2.f31472c.getOpen();
                u2 u2Var3 = this.f31410k;
                a2.a(context, open, u2Var3.f31472c, u2Var3.f31476g, a().toString());
                y2 a = c3.a(this.f31410k.a);
                a.h(new g3(this.f31410k.f31472c), null);
                a.l("desc", a().toString());
                a.m();
                r0.p(this.f31410k.f31472c, a().toString());
                i3 i3Var = this.f31410k.f31475f;
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
