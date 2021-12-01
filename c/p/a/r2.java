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
/* loaded from: classes7.dex */
public class r2 implements View.OnClickListener, View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f30891e;

    /* renamed from: f  reason: collision with root package name */
    public int f30892f;

    /* renamed from: g  reason: collision with root package name */
    public long f30893g;

    /* renamed from: h  reason: collision with root package name */
    public int f30894h;

    /* renamed from: i  reason: collision with root package name */
    public int f30895i;

    /* renamed from: j  reason: collision with root package name */
    public long f30896j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ u2 f30897k;

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
        this.f30897k = u2Var;
    }

    public HashMap a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("dx", Integer.valueOf(this.f30891e));
            hashMap.put("dy", Integer.valueOf(this.f30892f));
            hashMap.put("dts", Long.valueOf(this.f30893g));
            hashMap.put("ux", Integer.valueOf(this.f30894h));
            hashMap.put("uy", Integer.valueOf(this.f30895i));
            hashMap.put("uts", Long.valueOf(this.f30896j));
            u2 u2Var = this.f30897k;
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
                this.f30891e = (int) motionEvent.getRawX();
                this.f30892f = (int) motionEvent.getRawY();
                this.f30893g = System.currentTimeMillis();
                this.f30897k.p = (int) motionEvent.getX();
                this.f30897k.q = (int) motionEvent.getY();
                u2.c(this.f30897k, view);
                return false;
            } else if (action != 1) {
                return false;
            } else {
                this.f30894h = (int) motionEvent.getRawX();
                this.f30895i = (int) motionEvent.getRawY();
                this.f30896j = System.currentTimeMillis();
                this.f30897k.r = (int) motionEvent.getX();
                this.f30897k.s = (int) motionEvent.getY();
                u2 u2Var = this.f30897k;
                Info info = u2Var.f30959c;
                if (info == null || !a2.d(info, u2Var.f30964h)) {
                    return false;
                }
                this.f30897k.f30964h = System.currentTimeMillis();
                u2 u2Var2 = this.f30897k;
                Context context = u2Var2.a;
                String open = u2Var2.f30959c.getOpen();
                u2 u2Var3 = this.f30897k;
                a2.a(context, open, u2Var3.f30959c, u2Var3.f30963g, a().toString());
                y2 a = c3.a(this.f30897k.a);
                a.h(new g3(this.f30897k.f30959c), null);
                a.l("desc", a().toString());
                a.m();
                r0.p(this.f30897k.f30959c, a().toString());
                i3 i3Var = this.f30897k.f30962f;
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
