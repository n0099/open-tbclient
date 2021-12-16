package c.p.a;

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
public class m3 implements View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final b3 f31213e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f31214f;

    /* renamed from: g  reason: collision with root package name */
    public long f31215g;

    /* renamed from: h  reason: collision with root package name */
    public float f31216h;

    /* renamed from: i  reason: collision with root package name */
    public float f31217i;

    /* renamed from: j  reason: collision with root package name */
    public int f31218j;

    /* renamed from: k  reason: collision with root package name */
    public int f31219k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public long r;
    public int s;
    public int t;
    public long u;

    public m3(Info info, b3 b3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {info, b3Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f31214f = false;
        this.f31215g = 0L;
        this.f31213e = b3Var;
    }

    public HashMap a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("dx", Integer.valueOf(this.f31218j));
            hashMap.put("dy", Integer.valueOf(this.f31219k));
            hashMap.put("dts", Long.valueOf(this.r));
            hashMap.put("ux", Integer.valueOf(this.s));
            hashMap.put("uy", Integer.valueOf(this.t));
            hashMap.put("uts", Long.valueOf(this.u));
            r0.j(hashMap, this.l, this.m, this.n, this.o, this.p, this.q);
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
                this.f31214f = true;
                this.f31215g = System.currentTimeMillis();
                this.f31216h = motionEvent.getX();
                this.f31217i = motionEvent.getY();
                this.l = (int) motionEvent.getX();
                this.m = (int) motionEvent.getY();
                this.f31218j = (int) motionEvent.getRawX();
                this.f31219k = (int) motionEvent.getRawY();
                if (this.p <= 0 || this.q <= 0) {
                    this.q = view.getHeight();
                    this.p = view.getWidth();
                }
                this.r = System.currentTimeMillis();
            } else if (action == 1) {
                this.s = (int) motionEvent.getRawX();
                this.t = (int) motionEvent.getRawY();
                this.n = (int) motionEvent.getX();
                this.o = (int) motionEvent.getY();
                this.u = System.currentTimeMillis();
                boolean z = Math.abs(motionEvent.getX() - this.f31216h) < 51.0f;
                boolean z2 = Math.abs(motionEvent.getY() - this.f31217i) < 51.0f;
                boolean z3 = System.currentTimeMillis() - this.f31215g < 2000;
                if (z && z2 && z3 && this.f31214f) {
                    String str = null;
                    try {
                        str = a().toString();
                        r rVar = this.f31213e.a.f31179b;
                        if (rVar != null) {
                            rVar.a(str);
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    b3 b3Var = this.f31213e;
                    b3Var.a.f31181d = true;
                    b3Var.a.f31182e = str;
                    return false;
                } else if (this.f31213e != null) {
                    try {
                        String hashMap = a().toString();
                        r rVar2 = this.f31213e.a.f31179b;
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
