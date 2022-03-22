package c.m.a;

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
    public String a;

    /* renamed from: b */
    public Context f23557b;

    /* renamed from: c */
    public boolean f23558c;

    /* renamed from: d */
    public boolean f23559d;

    /* renamed from: e */
    public boolean f23560e;

    /* renamed from: f */
    public Info f23561f;

    /* renamed from: g */
    public e3 f23562g;

    /* renamed from: h */
    public g1 f23563h;
    public v4 i;
    public long j;
    public Handler k;

    public s4(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = new g4(this, Looper.getMainLooper());
        this.f23557b = context;
        this.a = str;
    }

    /* JADX DEBUG: Method not inlined, still used in: [c.m.a.k4.a(java.lang.Object):void] */
    public static /* synthetic */ void b(s4 s4Var, Info info) {
        s4Var.a(info);
    }

    public final void a(Info info) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, info) == null) {
            boolean z = false;
            this.f23560e = false;
            this.f23561f = info;
            this.j = System.currentTimeMillis();
            if (e() && this.f23561f.getType() == 41) {
                z = true;
            }
            if (z) {
                if (c()) {
                    this.f23563h.onLoaded();
                    return;
                }
                e3 e3Var = new e3(this.f23557b);
                this.f23562g = e3Var;
                e3Var.a = new o4(this);
                this.f23562g.a(this.f23561f.getLoad(), this.f23561f);
                this.k.sendEmptyMessageDelayed(11, this.f23561f.getWt() * 1000);
                return;
            }
            this.f23563h.onFail(PBError.PID_TYPE_ERROR);
        }
    }

    @Override // c.m.a.o0
    public void a(String str, String str2, Object obj) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, obj) == null) {
            if (TextUtils.equals(str, this.f23561f.getId() + this.a)) {
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
                    this.f23563h.onClicked();
                } else if (c2 == 1) {
                    this.f23563h.f();
                } else if (c2 == 2) {
                    this.f23563h.g();
                } else if (c2 != 3) {
                } else {
                    if (!r0.H(this.f23557b) || obj == null) {
                        this.f23563h.c(false, 0L);
                        return;
                    }
                    try {
                        j = ((Long) obj).longValue();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        j = 0;
                    }
                    if (j <= 0) {
                        this.f23563h.c(false, j);
                    } else {
                        this.f23563h.c(true, j);
                    }
                }
            }
        }
    }

    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f23558c && !this.f23560e && e() && !this.f23561f.isShown() && this.f23561f.isEffective() : invokeV.booleanValue;
    }

    public final boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f23561f != null : invokeV.booleanValue;
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? e() && this.f23561f.getType() == 41 : invokeV.booleanValue;
    }
}
