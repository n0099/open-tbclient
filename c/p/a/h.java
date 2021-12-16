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
import com.win.opensdk.PBNativeListener;
import com.win.opensdk.core.Info;
import java.util.HashMap;
/* loaded from: classes9.dex */
public class h implements View.OnClickListener, View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f31163e;

    /* renamed from: f  reason: collision with root package name */
    public int f31164f;

    /* renamed from: g  reason: collision with root package name */
    public long f31165g;

    /* renamed from: h  reason: collision with root package name */
    public int f31166h;

    /* renamed from: i  reason: collision with root package name */
    public int f31167i;

    /* renamed from: j  reason: collision with root package name */
    public long f31168j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ l f31169k;

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
        this.f31169k = lVar;
    }

    public HashMap a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("dx", Integer.valueOf(this.f31163e));
            hashMap.put("dy", Integer.valueOf(this.f31164f));
            hashMap.put("dts", Long.valueOf(this.f31165g));
            hashMap.put("ux", Integer.valueOf(this.f31166h));
            hashMap.put("uy", Integer.valueOf(this.f31167i));
            hashMap.put("uts", Long.valueOf(this.f31168j));
            l lVar = this.f31169k;
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
                this.f31163e = (int) motionEvent.getRawX();
                this.f31164f = (int) motionEvent.getRawY();
                this.f31165g = System.currentTimeMillis();
                this.f31169k.p = (int) motionEvent.getX();
                this.f31169k.q = (int) motionEvent.getY();
                l.e(this.f31169k, view);
                return false;
            } else if (action != 1) {
                return false;
            } else {
                this.f31166h = (int) motionEvent.getRawX();
                this.f31167i = (int) motionEvent.getRawY();
                this.f31168j = System.currentTimeMillis();
                this.f31169k.r = (int) motionEvent.getX();
                this.f31169k.s = (int) motionEvent.getY();
                l lVar = this.f31169k;
                Info info = lVar.f31197c;
                if (info == null || !a2.d(info, lVar.f31202h)) {
                    return false;
                }
                this.f31169k.f31202h = System.currentTimeMillis();
                l lVar2 = this.f31169k;
                Context context = lVar2.a;
                String open = lVar2.f31197c.getOpen();
                l lVar3 = this.f31169k;
                a2.a(context, open, lVar3.f31197c, lVar3.f31201g, a().toString());
                y2 a = c3.a(this.f31169k.a);
                a.h(new g3(this.f31169k.f31197c), null);
                a.l("desc", a().toString());
                a.m();
                r0.p(this.f31169k.f31197c, a().toString());
                PBNativeListener pBNativeListener = this.f31169k.f31200f;
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
