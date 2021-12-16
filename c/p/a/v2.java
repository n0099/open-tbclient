package c.p.a;

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
/* loaded from: classes9.dex */
public class v2 implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ boolean f31343e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ String f31344f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ y2 f31345g;

    public v2(y2 y2Var, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {y2Var, Boolean.valueOf(z), str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f31345g = y2Var;
        this.f31343e = z;
        this.f31344f = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        String x;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            String str = this.f31343e ? x5.f31365b : x5.f31366c;
            HashMap b2 = h5.b(this.f31345g.a);
            try {
                str = str + h5.a(b2);
            } catch (UnsupportedEncodingException unused) {
            }
            String str2 = this.f31344f;
            try {
                t1 t1Var = new t1(str, "POST", r0.k(null));
                t1Var.f31297b = r0.L(str2);
                w1 a = t1Var.a();
                byte[] bArr = a.f31351b;
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
