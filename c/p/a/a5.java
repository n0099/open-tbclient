package c.p.a;

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
/* loaded from: classes7.dex */
public class a5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public String f30733b;

    /* renamed from: c  reason: collision with root package name */
    public c4 f30734c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f30735d;

    /* renamed from: e  reason: collision with root package name */
    public L f30736e;

    /* renamed from: f  reason: collision with root package name */
    public int f30737f;

    /* renamed from: g  reason: collision with root package name */
    public e5 f30738g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f30739h;

    /* renamed from: i  reason: collision with root package name */
    public t5 f30740i;

    /* renamed from: j  reason: collision with root package name */
    public Handler f30741j;

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
        this.f30735d = false;
        this.f30737f = 5;
        this.f30741j = new g4(this, Looper.getMainLooper());
        this.a = context;
        this.f30733b = str;
        this.f30736e = l;
        this.f30734c = new c4();
        this.f30737f = m2.L(context);
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
                if (this.f30740i != null) {
                    this.f30740i.f30942d = null;
                }
                if (this.f30741j != null) {
                    this.f30741j.removeCallbacksAndMessages(null);
                }
                if (this.f30734c != null) {
                    this.f30734c.a();
                }
                if (this.f30738g != null) {
                    this.f30738g = null;
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
            this.f30734c.b(j0Var.a);
        } catch (Exception unused) {
        }
    }

    public final void d(PBError pBError) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, pBError) == null) || this.f30739h) {
            return;
        }
        this.f30739h = true;
        w2.a.post(new o4(this, pBError));
    }

    public final void e(Info info) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, info) == null) || this.f30739h) {
            return;
        }
        this.f30739h = true;
        w2.a.post(new s4(this, info));
    }

    public void g() {
        JSONStringer object;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            w2.a.post(new w4(this));
            boolean z = false;
            this.f30739h = false;
            Context context = this.a;
            String str = this.f30733b;
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
                y2 a = c3.a(this.a);
                String str2 = this.f30733b;
                try {
                    object = new JSONStringer().object();
                    a.f31007b = object;
                    a.l("e", "Ld");
                    a.l("pid", str2);
                    a.l("timeis", c3.e());
                } catch (JSONException unused2) {
                }
                a.m();
                d(PBError.PID_INVALID);
                return;
            }
            Info c2 = this.f30734c.c();
            if (c2 == null) {
                if (this.f30735d) {
                    d(PBError.LOAD_TOO_FREQUENTLY);
                    return;
                }
                this.f30735d = true;
                t5 t5Var = new t5(this.a);
                t5Var.f30940b = this.f30733b;
                t5Var.a(new k4(this));
                this.f30740i = t5Var;
                L l = this.f30736e;
                if (l == L.a) {
                    t5Var.c();
                    return;
                } else if (l == L.f62598b) {
                    t5Var.e();
                    return;
                } else if (l == L.f62599c) {
                    t5Var.f();
                    return;
                } else if (l == L.f62600d) {
                    t5Var.h();
                    return;
                } else if (l == L.f62601e) {
                    t5Var.g();
                    return;
                } else if (l == L.f62602f) {
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
