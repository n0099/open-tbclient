package b.q.a;

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
/* loaded from: classes6.dex */
public class v2 implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ boolean f33536e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ String f33537f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ y2 f33538g;

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
        this.f33538g = y2Var;
        this.f33536e = z;
        this.f33537f = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        String x;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            String str = this.f33536e ? x5.f33565b : x5.f33566c;
            HashMap b2 = h5.b(this.f33538g.f33578a);
            try {
                str = str + h5.a(b2);
            } catch (UnsupportedEncodingException unused) {
            }
            String str2 = this.f33537f;
            try {
                t1 t1Var = new t1(str, "POST", r0.k(null));
                t1Var.f33484b = r0.L(str2);
                w1 a2 = t1Var.a();
                byte[] bArr = a2.f33549b;
                if (a2.f33548a == 200) {
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
