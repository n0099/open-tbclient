package c.m.a;

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
public class h3 implements View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final w2 a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f23451b;

    /* renamed from: c  reason: collision with root package name */
    public long f23452c;

    /* renamed from: d  reason: collision with root package name */
    public float f23453d;

    /* renamed from: e  reason: collision with root package name */
    public float f23454e;

    /* renamed from: f  reason: collision with root package name */
    public int f23455f;

    /* renamed from: g  reason: collision with root package name */
    public int f23456g;

    /* renamed from: h  reason: collision with root package name */
    public int f23457h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public long n;
    public int o;
    public int p;
    public long q;

    public h3(Info info, w2 w2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {info, w2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f23451b = false;
        this.f23452c = 0L;
        this.a = w2Var;
    }

    public HashMap a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("dx", Integer.valueOf(this.f23455f));
            hashMap.put("dy", Integer.valueOf(this.f23456g));
            hashMap.put("dts", Long.valueOf(this.n));
            hashMap.put("ux", Integer.valueOf(this.o));
            hashMap.put("uy", Integer.valueOf(this.p));
            hashMap.put("uts", Long.valueOf(this.q));
            r0.j(hashMap, this.f23457h, this.i, this.j, this.k, this.l, this.m);
            return hashMap;
        }
        return (HashMap) invokeV.objValue;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f23451b = true;
                this.f23452c = System.currentTimeMillis();
                this.f23453d = motionEvent.getX();
                this.f23454e = motionEvent.getY();
                this.f23457h = (int) motionEvent.getX();
                this.i = (int) motionEvent.getY();
                this.f23455f = (int) motionEvent.getRawX();
                this.f23456g = (int) motionEvent.getRawY();
                if (this.l <= 0 || this.m <= 0) {
                    this.m = view.getHeight();
                    this.l = view.getWidth();
                }
                this.n = System.currentTimeMillis();
            } else if (action == 1) {
                this.o = (int) motionEvent.getRawX();
                this.p = (int) motionEvent.getRawY();
                this.j = (int) motionEvent.getX();
                this.k = (int) motionEvent.getY();
                this.q = System.currentTimeMillis();
                boolean z = Math.abs(motionEvent.getX() - this.f23453d) < 51.0f;
                boolean z2 = Math.abs(motionEvent.getY() - this.f23454e) < 51.0f;
                boolean z3 = System.currentTimeMillis() - this.f23452c < 2000;
                if (z && z2 && z3 && this.f23451b) {
                    String str = null;
                    try {
                        str = a().toString();
                        r rVar = this.a.a.f23427b;
                        if (rVar != null) {
                            rVar.a(str);
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    w2 w2Var = this.a;
                    w2Var.a.f23429d = true;
                    w2Var.a.f23430e = str;
                    return false;
                } else if (this.a != null) {
                    try {
                        String hashMap = a().toString();
                        r rVar2 = this.a.a.f23427b;
                        if (rVar2 != null) {
                            rVar2.a(hashMap);
                        }
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
