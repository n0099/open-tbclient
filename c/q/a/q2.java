package c.q.a;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.comm.constants.Constants;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class q2 implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ boolean f29088e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ String f29089f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ t2 f29090g;

    public q2(t2 t2Var, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t2Var, Boolean.valueOf(z), str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f29090g = t2Var;
        this.f29088e = z;
        this.f29089f = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        String x;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            String str = this.f29088e ? s5.f29112b : s5.f29113c;
            HashMap b2 = c5.b(this.f29090g.a);
            try {
                str = str + c5.a(b2);
            } catch (UnsupportedEncodingException unused) {
            }
            String str2 = this.f29089f;
            try {
                o1 o1Var = new o1(str, "POST", r0.k(null));
                o1Var.f29051b = r0.L(str2);
                r1 a = o1Var.a();
                byte[] bArr = a.f29096b;
                if (a.a == 200) {
                    JSONObject jSONObject = new JSONObject(new String(bArr, "UTF-8"));
                    jSONObject.optInt(Constants.KEYS.RET);
                    jSONObject.optString("msg");
                    try {
                        x = r0.x(jSONObject.optString("data"));
                    } catch (Exception unused2) {
                    }
                    if (TextUtils.isEmpty(x)) {
                        new JSONObject();
                    } else {
                        new JSONObject(x);
                    }
                }
            } catch (JSONException e2) {
                e2.getMessage();
            } catch (Exception e3) {
                e3.getMessage();
            }
        }
    }
}
