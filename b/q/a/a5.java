package b.q.a;

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
/* loaded from: classes6.dex */
public class a5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f33238a;

    /* renamed from: b  reason: collision with root package name */
    public String f33239b;

    /* renamed from: c  reason: collision with root package name */
    public c4 f33240c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f33241d;

    /* renamed from: e  reason: collision with root package name */
    public L f33242e;

    /* renamed from: f  reason: collision with root package name */
    public int f33243f;

    /* renamed from: g  reason: collision with root package name */
    public e5 f33244g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f33245h;

    /* renamed from: i  reason: collision with root package name */
    public t5 f33246i;
    public Handler j;

    public a5(Context context, String str, L l) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, l};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f33241d = false;
        this.f33243f = 5;
        this.j = new g4(this, Looper.getMainLooper());
        this.f33238a = context;
        this.f33239b = str;
        this.f33242e = l;
        this.f33240c = new c4();
        this.f33243f = m2.L(context);
    }

    public static /* synthetic */ int h() {
        return 100101;
    }

    public final PBError a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? (i2 == 100 || i2 == 101) ? PBError.SERVER_ERROR : (i2 == 406 || i2 == 2003) ? PBError.PID_INVALID : PBError.UNKNOWN : (PBError) invokeI.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            try {
                if (this.f33246i != null) {
                    this.f33246i.f33501d = null;
                }
                if (this.j != null) {
                    this.j.removeCallbacksAndMessages(null);
                }
                if (this.f33240c != null) {
                    this.f33240c.a();
                }
                if (this.f33244g != null) {
                    this.f33244g = null;
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
            List list = j0Var.f33349a;
            if (list == null || list.size() <= 0) {
                return;
            }
            this.f33240c.b(j0Var.f33349a);
        } catch (Exception unused) {
        }
    }

    public final void d(PBError pBError) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, pBError) == null) || this.f33245h) {
            return;
        }
        this.f33245h = true;
        w2.f33550a.post(new o4(this, pBError));
    }

    public final void e(Info info) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, info) == null) || this.f33245h) {
            return;
        }
        this.f33245h = true;
        w2.f33550a.post(new s4(this, info));
    }

    public void g() {
        JSONStringer object;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            w2.f33550a.post(new w4(this));
            boolean z = false;
            this.f33245h = false;
            Context context = this.f33238a;
            String str = this.f33239b;
            String F = m2.F(context);
            if (!TextUtils.isEmpty(F)) {
                try {
                    JSONArray jSONArray = new JSONArray(F);
                    if (jSONArray.length() > 0) {
                        int i2 = 0;
                        while (true) {
                            if (i2 >= jSONArray.length()) {
                                break;
                            }
                            String optString = jSONArray.optString(i2);
                            if (!TextUtils.isEmpty(optString) && optString.equals(str)) {
                                z = true;
                                break;
                            }
                            i2++;
                        }
                    }
                } catch (Exception unused) {
                }
            }
            if (!z) {
                y2 a2 = c3.a(this.f33238a);
                String str2 = this.f33239b;
                try {
                    object = new JSONStringer().object();
                    a2.f33579b = object;
                    a2.l("e", "Ld");
                    a2.l("pid", str2);
                    a2.l("timeis", c3.e());
                } catch (JSONException unused2) {
                }
                a2.m();
                d(PBError.PID_INVALID);
                return;
            }
            Info c2 = this.f33240c.c();
            if (c2 == null) {
                if (this.f33241d) {
                    d(PBError.LOAD_TOO_FREQUENTLY);
                    return;
                }
                this.f33241d = true;
                t5 t5Var = new t5(this.f33238a);
                t5Var.f33499b = this.f33239b;
                t5Var.a(new k4(this));
                this.f33246i = t5Var;
                L l = this.f33242e;
                if (l == L.f70452a) {
                    t5Var.c();
                    return;
                } else if (l == L.f70453b) {
                    t5Var.e();
                    return;
                } else if (l == L.f70454c) {
                    t5Var.f();
                    return;
                } else if (l == L.f70455d) {
                    t5Var.h();
                    return;
                } else if (l == L.f70456e) {
                    t5Var.g();
                    return;
                } else if (l == L.f70457f) {
                    t5Var.d();
                    return;
                } else {
                    return;
                }
            }
            e(c2);
        }
    }
}
