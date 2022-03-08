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
    public String f29153b;

    /* renamed from: c  reason: collision with root package name */
    public x3 f29154c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f29155d;

    /* renamed from: e  reason: collision with root package name */
    public L f29156e;

    /* renamed from: f  reason: collision with root package name */
    public int f29157f;

    /* renamed from: g  reason: collision with root package name */
    public z4 f29158g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f29159h;

    /* renamed from: i  reason: collision with root package name */
    public o5 f29160i;

    /* renamed from: j  reason: collision with root package name */
    public Handler f29161j;

    public v4(Context context, String str, L l) {
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
        this.f29155d = false;
        this.f29157f = 5;
        this.f29161j = new b4(this, Looper.getMainLooper());
        this.a = context;
        this.f29153b = str;
        this.f29156e = l;
        this.f29154c = new x3();
        this.f29157f = h2.L(context);
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
                if (this.f29160i != null) {
                    this.f29160i.f29066d = null;
                }
                if (this.f29161j != null) {
                    this.f29161j.removeCallbacksAndMessages(null);
                }
                if (this.f29154c != null) {
                    this.f29154c.a();
                }
                if (this.f29158g != null) {
                    this.f29158g = null;
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
            this.f29154c.b(j0Var.a);
        } catch (Exception unused) {
        }
    }

    public final void d(PBError pBError) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, pBError) == null) || this.f29159h) {
            return;
        }
        this.f29159h = true;
        r2.a.post(new j4(this, pBError));
    }

    public final void e(Info info) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, info) == null) || this.f29159h) {
            return;
        }
        this.f29159h = true;
        r2.a.post(new n4(this, info));
    }

    public void g() {
        JSONStringer object;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            r2.a.post(new r4(this));
            boolean z = false;
            this.f29159h = false;
            Context context = this.a;
            String str = this.f29153b;
            String F = h2.F(context);
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
                t2 a = x2.a(this.a);
                String str2 = this.f29153b;
                try {
                    object = new JSONStringer().object();
                    a.f29126b = object;
                    a.l("e", "Ld");
                    a.l("pid", str2);
                    a.l("timeis", x2.e());
                } catch (JSONException unused2) {
                }
                a.m();
                d(PBError.PID_INVALID);
                return;
            }
            Info c2 = this.f29154c.c();
            if (c2 == null) {
                if (this.f29155d) {
                    d(PBError.LOAD_TOO_FREQUENTLY);
                    return;
                }
                this.f29155d = true;
                o5 o5Var = new o5(this.a);
                o5Var.f29064b = this.f29153b;
                o5Var.a(new f4(this));
                this.f29160i = o5Var;
                L l = this.f29156e;
                if (l == L.a) {
                    o5Var.c();
                    return;
                } else if (l == L.f59357b) {
                    o5Var.e();
                    return;
                } else if (l == L.f59358c) {
                    o5Var.f();
                    return;
                } else if (l == L.f59359d) {
                    o5Var.h();
                    return;
                } else if (l == L.f59360e) {
                    o5Var.g();
                    return;
                } else if (l == L.f59361f) {
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
