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
import com.win.opensdk.PBInterstitialListener;
import com.win.opensdk.core.Info;
/* loaded from: classes3.dex */
public class j1 implements o0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public Context f23470b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f23471c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f23472d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f23473e;

    /* renamed from: f  reason: collision with root package name */
    public Info f23474f;

    /* renamed from: g  reason: collision with root package name */
    public e3 f23475g;

    /* renamed from: h  reason: collision with root package name */
    public PBInterstitialListener f23476h;
    public v4 i;
    public long j;
    public Handler k;

    public j1(Context context, String str) {
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
        this.k = new v0(this, Looper.getMainLooper());
        this.f23470b = context;
        this.a = str;
    }

    @Override // c.m.a.o0
    public void a(String str, String str2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, obj) == null) {
            if (TextUtils.equals(str, this.f23474f.getId() + this.a)) {
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
                    this.f23476h.onClicked();
                } else if (c2 == 1) {
                    this.f23476h.onInterstitialDismissed();
                } else if (c2 != 2) {
                } else {
                    this.f23476h.onInterstitialDisplayed();
                }
            }
        }
    }

    public final void b(Info info) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, info) == null) {
            boolean z = false;
            this.f23473e = false;
            this.f23474f = info;
            this.j = System.currentTimeMillis();
            if (e() && this.f23474f.getType() == 21) {
                z = true;
            }
            if (z) {
                if (c()) {
                    this.f23476h.onLoaded();
                    return;
                }
                e3 e3Var = new e3(this.f23470b);
                this.f23475g = e3Var;
                e3Var.a = new h1(this);
                this.f23475g.a(this.f23474f.getLoad(), this.f23474f);
                this.k.sendEmptyMessageDelayed(11, this.f23474f.getWt() * 1000);
                return;
            }
            this.f23476h.onFail(PBError.PID_TYPE_ERROR);
        }
    }

    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f23471c && !this.f23473e && e() && !this.f23474f.isShown() && this.f23474f.isEffective() : invokeV.booleanValue;
    }

    public final boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f23474f != null : invokeV.booleanValue;
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? e() && this.f23474f.getType() == 21 : invokeV.booleanValue;
    }
}
