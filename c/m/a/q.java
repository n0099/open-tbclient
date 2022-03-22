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
public class q implements View.OnClickListener, View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f23538b;

    /* renamed from: c  reason: collision with root package name */
    public long f23539c;

    /* renamed from: d  reason: collision with root package name */
    public int f23540d;

    /* renamed from: e  reason: collision with root package name */
    public int f23541e;

    /* renamed from: f  reason: collision with root package name */
    public long f23542f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ u f23543g;

    public q(u uVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f23543g = uVar;
    }

    public HashMap a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("dx", Integer.valueOf(this.a));
            hashMap.put("dy", Integer.valueOf(this.f23538b));
            hashMap.put("dts", Long.valueOf(this.f23539c));
            hashMap.put("ux", Integer.valueOf(this.f23540d));
            hashMap.put("uy", Integer.valueOf(this.f23541e));
            hashMap.put("uts", Long.valueOf(this.f23542f));
            u uVar = this.f23543g;
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
                this.a = (int) motionEvent.getRawX();
                this.f23538b = (int) motionEvent.getRawY();
                this.f23539c = System.currentTimeMillis();
                this.f23543g.p = (int) motionEvent.getX();
                this.f23543g.q = (int) motionEvent.getY();
                u.d(this.f23543g, view);
                return false;
            } else if (action != 1) {
                return false;
            } else {
                this.f23540d = (int) motionEvent.getRawX();
                this.f23541e = (int) motionEvent.getRawY();
                this.f23542f = System.currentTimeMillis();
                this.f23543g.r = (int) motionEvent.getX();
                this.f23543g.s = (int) motionEvent.getY();
                u uVar = this.f23543g;
                Info info = uVar.f23582c;
                if (info == null || !v1.d(info, uVar.f23587h)) {
                    return false;
                }
                this.f23543g.f23587h = System.currentTimeMillis();
                u uVar2 = this.f23543g;
                Context context = uVar2.a;
                String open = uVar2.f23582c.getOpen();
                u uVar3 = this.f23543g;
                v1.a(context, open, uVar3.f23582c, uVar3.f23586g, a().toString());
                t2 a = x2.a(this.f23543g.a);
                a.h(new b3(this.f23543g.f23582c), null);
                a.l("desc", a().toString());
                a.m();
                r0.p(this.f23543g.f23582c, a().toString());
                s sVar = this.f23543g.f23585f;
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
