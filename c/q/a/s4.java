package c.q.a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.PBError;
import com.win.opensdk.core.Info;
/* loaded from: classes3.dex */
public class s4 implements o0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e */
    public String f29106e;

    /* renamed from: f */
    public Context f29107f;

    /* renamed from: g */
    public boolean f29108g;

    /* renamed from: h */
    public boolean f29109h;

    /* renamed from: i */
    public boolean f29110i;

    /* renamed from: j */
    public Info f29111j;
    public e3 k;
    public g1 l;
    public v4 m;
    public long n;
    public Handler o;

    public s4(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = new g4(this, Looper.getMainLooper());
        this.f29107f = context;
        this.f29106e = str;
    }

    /* JADX DEBUG: Method not inlined, still used in: [c.q.a.k4.a(java.lang.Object):void] */
    public static /* synthetic */ void b(s4 s4Var, Info info) {
        s4Var.a(info);
    }

    public final void a(Info info) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, info) == null) {
            boolean z = false;
            this.f29110i = false;
            this.f29111j = info;
            this.n = System.currentTimeMillis();
            if (e() && this.f29111j.getType() == 41) {
                z = true;
            }
            if (z) {
                if (c()) {
                    this.l.onLoaded();
                    return;
                }
                e3 e3Var = new e3(this.f29107f);
                this.k = e3Var;
                e3Var.a = new o4(this);
                this.k.a(this.f29111j.getLoad(), this.f29111j);
                this.o.sendEmptyMessageDelayed(11, this.f29111j.getWt() * 1000);
                return;
            }
            this.l.onFail(PBError.PID_TYPE_ERROR);
        }
    }

    @Override // c.q.a.o0
    public void a(String str, String str2, Object obj) {
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, obj) == null) {
            if (TextUtils.equals(str, this.f29111j.getId() + this.f29106e)) {
                char c2 = 65535;
                switch (str2.hashCode()) {
                    case -1398725913:
                        if (str2.equals("VIDEO_USER_EARNED_REWARD")) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case -1122984843:
                        if (str2.equals("is_dismiss")) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case -1122893139:
                        if (str2.equals("is_display")) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case -707154884:
                        if (str2.equals("VIDEO_SHOW_FAIL")) {
                            c2 = 4;
                            break;
                        }
                        break;
                    case 109719091:
                        if (str2.equals("is_click")) {
                            c2 = 0;
                            break;
                        }
                        break;
                }
                if (c2 == 0) {
                    this.l.onClicked();
                } else if (c2 == 1) {
                    this.l.f();
                } else if (c2 == 2) {
                    this.l.g();
                } else if (c2 != 3) {
                } else {
                    if (!r0.H(this.f29107f) || obj == null) {
                        this.l.c(false, 0L);
                        return;
                    }
                    try {
                        j2 = ((Long) obj).longValue();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        j2 = 0;
                    }
                    if (j2 <= 0) {
                        this.l.c(false, j2);
                    } else {
                        this.l.c(true, j2);
                    }
                }
            }
        }
    }

    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f29108g && !this.f29110i && e() && !this.f29111j.isShown() && this.f29111j.isEffective() : invokeV.booleanValue;
    }

    public final boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f29111j != null : invokeV.booleanValue;
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? e() && this.f29111j.getType() == 41 : invokeV.booleanValue;
    }
}
