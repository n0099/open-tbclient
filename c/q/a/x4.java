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
/* loaded from: classes9.dex */
public class x4 implements o0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e */
    public String f30745e;

    /* renamed from: f */
    public Context f30746f;

    /* renamed from: g */
    public boolean f30747g;

    /* renamed from: h */
    public boolean f30748h;

    /* renamed from: i */
    public boolean f30749i;

    /* renamed from: j */
    public Info f30750j;
    public j3 k;
    public g1 l;
    public a5 m;
    public long n;
    public Handler o;

    public x4(Context context, String str) {
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
        this.o = new l4(this, Looper.getMainLooper());
        this.f30746f = context;
        this.f30745e = str;
    }

    /* JADX DEBUG: Method not inlined, still used in: [c.q.a.p4.a(java.lang.Object):void] */
    public static /* synthetic */ void b(x4 x4Var, Info info) {
        x4Var.a(info);
    }

    public final void a(Info info) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, info) == null) {
            boolean z = false;
            this.f30749i = false;
            this.f30750j = info;
            this.n = System.currentTimeMillis();
            if (e() && this.f30750j.getType() == 41) {
                z = true;
            }
            if (z) {
                if (c()) {
                    this.l.onLoaded();
                    return;
                }
                j3 j3Var = new j3(this.f30746f);
                this.k = j3Var;
                j3Var.a = new t4(this);
                this.k.a(this.f30750j.getLoad(), this.f30750j);
                this.o.sendEmptyMessageDelayed(11, this.f30750j.getWt() * 1000);
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
            if (TextUtils.equals(str, this.f30750j.getId() + this.f30745e)) {
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
                    if (!r0.H(this.f30746f) || obj == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f30747g && !this.f30749i && e() && !this.f30750j.isShown() && this.f30750j.isEffective() : invokeV.booleanValue;
    }

    public final boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f30750j != null : invokeV.booleanValue;
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? e() && this.f30750j.getType() == 41 : invokeV.booleanValue;
    }
}
