package b.o.a;

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
import com.win.opensdk.PBInterstitialListener;
import com.win.opensdk.core.Info;
/* loaded from: classes6.dex */
public class o1 implements o0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f34255e;

    /* renamed from: f  reason: collision with root package name */
    public Context f34256f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f34257g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f34258h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f34259i;
    public Info j;
    public j3 k;
    public PBInterstitialListener l;
    public a5 m;
    public long n;
    public Handler o;

    public o1(Context context, String str) {
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
        this.o = new v0(this, Looper.getMainLooper());
        this.f34256f = context;
        this.f34255e = str;
    }

    @Override // b.o.a.o0
    public void a(String str, String str2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, obj) == null) {
            if (TextUtils.equals(str, this.j.getId() + this.f34255e)) {
                char c2 = 65535;
                int hashCode = str2.hashCode();
                if (hashCode != -1122984843) {
                    if (hashCode != -1122893139) {
                        if (hashCode == 109719091 && str2.equals("is_click")) {
                            c2 = 0;
                        }
                    } else if (str2.equals("is_display")) {
                        c2 = 2;
                    }
                } else if (str2.equals("is_dismiss")) {
                    c2 = 1;
                }
                if (c2 == 0) {
                    this.l.onClicked();
                } else if (c2 == 1) {
                    this.l.onInterstitialDismissed();
                } else if (c2 != 2) {
                } else {
                    this.l.onInterstitialDisplayed();
                }
            }
        }
    }

    public final void b(Info info) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, info) == null) {
            boolean z = false;
            this.f34259i = false;
            this.j = info;
            this.n = System.currentTimeMillis();
            if (e() && this.j.getType() == 21) {
                z = true;
            }
            if (z) {
                if (c()) {
                    this.l.onLoaded();
                    return;
                }
                j3 j3Var = new j3(this.f34256f);
                this.k = j3Var;
                j3Var.f34187a = new h1(this);
                this.k.a(this.j.getLoad(), this.j);
                this.o.sendEmptyMessageDelayed(11, this.j.getWt() * 1000);
                return;
            }
            this.l.onFail(PBError.PID_TYPE_ERROR);
        }
    }

    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f34257g && !this.f34259i && e() && !this.j.isShown() && this.j.isEffective() : invokeV.booleanValue;
    }

    public final boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.j != null : invokeV.booleanValue;
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? e() && this.j.getType() == 21 : invokeV.booleanValue;
    }
}
