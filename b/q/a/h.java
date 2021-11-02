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
import com.win.opensdk.PBNativeListener;
import com.win.opensdk.core.Info;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class h implements View.OnClickListener, View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f33328e;

    /* renamed from: f  reason: collision with root package name */
    public int f33329f;

    /* renamed from: g  reason: collision with root package name */
    public long f33330g;

    /* renamed from: h  reason: collision with root package name */
    public int f33331h;

    /* renamed from: i  reason: collision with root package name */
    public int f33332i;
    public long j;
    public final /* synthetic */ l k;

    public h(l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = lVar;
    }

    public HashMap a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("dx", Integer.valueOf(this.f33328e));
            hashMap.put("dy", Integer.valueOf(this.f33329f));
            hashMap.put("dts", Long.valueOf(this.f33330g));
            hashMap.put("ux", Integer.valueOf(this.f33331h));
            hashMap.put("uy", Integer.valueOf(this.f33332i));
            hashMap.put("uts", Long.valueOf(this.j));
            l lVar = this.k;
            r0.j(hashMap, lVar.p, lVar.q, lVar.r, lVar.s, lVar.t, lVar.u);
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
                this.f33328e = (int) motionEvent.getRawX();
                this.f33329f = (int) motionEvent.getRawY();
                this.f33330g = System.currentTimeMillis();
                this.k.p = (int) motionEvent.getX();
                this.k.q = (int) motionEvent.getY();
                l.e(this.k, view);
                return false;
            } else if (action != 1) {
                return false;
            } else {
                this.f33331h = (int) motionEvent.getRawX();
                this.f33332i = (int) motionEvent.getRawY();
                this.j = System.currentTimeMillis();
                this.k.r = (int) motionEvent.getX();
                this.k.s = (int) motionEvent.getY();
                l lVar = this.k;
                Info info = lVar.f33377c;
                if (info == null || !a2.d(info, lVar.f33382h)) {
                    return false;
                }
                this.k.f33382h = System.currentTimeMillis();
                l lVar2 = this.k;
                Context context = lVar2.f33375a;
                String open = lVar2.f33377c.getOpen();
                l lVar3 = this.k;
                a2.a(context, open, lVar3.f33377c, lVar3.f33381g, a().toString());
                y2 a2 = c3.a(this.k.f33375a);
                a2.h(new g3(this.k.f33377c), null);
                a2.l("desc", a().toString());
                a2.m();
                r0.p(this.k.f33377c, a().toString());
                PBNativeListener pBNativeListener = this.k.f33380f;
                if (pBNativeListener != null) {
                    pBNativeListener.onClicked();
                    return false;
                }
                return false;
            }
        }
        return invokeLL.booleanValue;
    }
}
