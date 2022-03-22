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
import com.win.opensdk.L;
import com.win.opensdk.PBError;
import com.win.opensdk.core.Info;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONStringer;
/* loaded from: classes3.dex */
public class v4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public String f23596b;

    /* renamed from: c  reason: collision with root package name */
    public x3 f23597c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f23598d;

    /* renamed from: e  reason: collision with root package name */
    public L f23599e;

    /* renamed from: f  reason: collision with root package name */
    public int f23600f;

    /* renamed from: g  reason: collision with root package name */
    public z4 f23601g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f23602h;
    public o5 i;
    public Handler j;

    public v4(Context context, String str, L l) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, l};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f23598d = false;
        this.f23600f = 5;
        this.j = new b4(this, Looper.getMainLooper());
        this.a = context;
        this.f23596b = str;
        this.f23599e = l;
        this.f23597c = new x3();
        this.f23600f = h2.L(context);
    }

    public static /* synthetic */ int h() {
        return 100101;
    }

    public final PBError a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) ? (i == 100 || i == 101) ? PBError.SERVER_ERROR : (i == 406 || i == 2003) ? PBError.PID_INVALID : PBError.UNKNOWN : (PBError) invokeI.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            try {
                if (this.i != null) {
                    this.i.f23525d = null;
                }
                if (this.j != null) {
                    this.j.removeCallbacksAndMessages(null);
                }
                if (this.f23597c != null) {
                    this.f23597c.a();
                }
                if (this.f23601g != null) {
                    this.f23601g = null;
                }
            } catch (Exception unused) {
            }
        }
    }

    public final void c(j0 j0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, j0Var) == null) || j0Var == null) {
            return;
        }
        try {
            List list = j0Var.a;
            if (list == null || list.size() <= 0) {
                return;
            }
            this.f23597c.b(j0Var.a);
        } catch (Exception unused) {
        }
    }

    public final void d(PBError pBError) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, pBError) == null) || this.f23602h) {
            return;
        }
        this.f23602h = true;
        r2.a.post(new j4(this, pBError));
    }

    public final void e(Info info) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, info) == null) || this.f23602h) {
            return;
        }
        this.f23602h = true;
        r2.a.post(new n4(this, info));
    }

    public void g() {
        JSONStringer object;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            r2.a.post(new r4(this));
            boolean z = false;
            this.f23602h = false;
            Context context = this.a;
            String str = this.f23596b;
            String F = h2.F(context);
            if (!TextUtils.isEmpty(F)) {
                try {
                    JSONArray jSONArray = new JSONArray(F);
                    if (jSONArray.length() > 0) {
                        int i = 0;
                        while (true) {
                            if (i >= jSONArray.length()) {
                                break;
                            }
                            String optString = jSONArray.optString(i);
                            if (!TextUtils.isEmpty(optString) && optString.equals(str)) {
                                z = true;
                                break;
                            }
                            i++;
                        }
                    }
                } catch (Exception unused) {
                }
            }
            if (!z) {
                t2 a = x2.a(this.a);
                String str2 = this.f23596b;
                try {
                    object = new JSONStringer().object();
                    a.f23575b = object;
                    a.l("e", "Ld");
                    a.l("pid", str2);
                    a.l("timeis", x2.e());
                } catch (JSONException unused2) {
                }
                a.m();
                d(PBError.PID_INVALID);
                return;
            }
            Info c2 = this.f23597c.c();
            if (c2 == null) {
                if (this.f23598d) {
                    d(PBError.LOAD_TOO_FREQUENTLY);
                    return;
                }
                this.f23598d = true;
                o5 o5Var = new o5(this.a);
                o5Var.f23523b = this.f23596b;
                o5Var.a(new f4(this));
                this.i = o5Var;
                L l = this.f23599e;
                if (l == L.a) {
                    o5Var.c();
                    return;
                } else if (l == L.f43985b) {
                    o5Var.e();
                    return;
                } else if (l == L.f43986c) {
                    o5Var.f();
                    return;
                } else if (l == L.f43987d) {
                    o5Var.h();
                    return;
                } else if (l == L.f43988e) {
                    o5Var.g();
                    return;
                } else if (l == L.f43989f) {
                    o5Var.d();
                    return;
                } else {
                    return;
                }
            }
            e(c2);
        }
    }
}
