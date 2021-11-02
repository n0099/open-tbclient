package b.a.p0.a.c0.a.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import b.a.p0.a.c0.a.c.c;
import b.a.p0.a.v2.n0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int G;
    public int H;
    public int I;
    public int J;
    public int K;
    public String L;
    public boolean M;
    public int N;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(String str, @NonNull String str2) {
        super(str, str2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.L = "";
    }

    private void j() {
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65537, this) == null) || (jSONObject = this.n) == null) {
            return;
        }
        this.y = SwanAppConfigData.s(jSONObject.optString("color"));
        this.z = true;
    }

    @Override // b.a.p0.a.c0.a.c.c, b.a.p0.a.c0.a.d.b, b.a.p0.a.c0.b.b, b.a.p0.a.l1.a
    public void a(JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        super.a(jSONObject);
        this.G = jSONObject.optInt("maxLength");
        this.H = l(jSONObject);
        this.I = jSONObject.optInt(Constants.EXTRA_CONFIG_CURSOR);
        this.J = jSONObject.optInt("selectionStart");
        this.K = jSONObject.optInt("selectionEnd");
        this.L = jSONObject.optString("confirmType");
        this.M = jSONObject.optInt("password") == 1;
        j();
    }

    @Override // b.a.p0.a.c0.a.c.c, b.a.p0.a.c0.a.d.b, b.a.p0.a.c0.b.b
    public void h(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
            super.h(jSONObject);
            if (!TextUtils.isEmpty(jSONObject.optString("cursorSpacing"))) {
                this.H = l(jSONObject);
            }
            this.G = jSONObject.optInt("maxLength", this.G);
            this.I = jSONObject.optInt(Constants.EXTRA_CONFIG_CURSOR, this.I);
            this.J = jSONObject.optInt("selectionStart", this.J);
            this.K = jSONObject.optInt("selectionEnd", this.K);
            this.L = jSONObject.optString("confirmType", this.L);
            this.M = jSONObject.optInt("password", this.M ? 1 : 0) == 1;
            j();
        }
    }

    public final int l(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject)) == null) {
            String optString = jSONObject.optString("cursorSpacing");
            if (TextUtils.isEmpty(optString)) {
                return 0;
            }
            if (optString.endsWith("rpx")) {
                try {
                    return n0.g(Integer.parseInt(optString.replace("rpx", "")));
                } catch (NumberFormatException unused) {
                    return 0;
                }
            }
            try {
                return Integer.parseInt(optString.replace("px", ""));
            } catch (NumberFormatException unused2) {
                return 0;
            }
        }
        return invokeL.intValue;
    }

    public void m(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
            this.J = i2;
            this.K = i3;
        }
    }

    public void n(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.N = i2;
        }
    }
}
