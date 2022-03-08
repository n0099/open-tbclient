package c.a.p0.a.s.a.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.a.p0.a.p2.n0;
import c.a.p0.a.s.a.c.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.component.input.InputType;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int H;
    public int I;
    public int J;
    public int K;
    public int L;
    public String M;
    public boolean N;
    public int O;

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
        this.M = "";
    }

    private void j() {
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65537, this) == null) || (jSONObject = this.n) == null) {
            return;
        }
        this.y = SwanAppConfigData.t(jSONObject.optString("color"));
        this.z = true;
    }

    @Override // c.a.p0.a.s.a.c.c, c.a.p0.a.s.a.d.b, c.a.p0.a.s.b.b, c.a.p0.a.c1.a
    public void a(JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        super.a(jSONObject);
        this.H = jSONObject.optInt("maxLength");
        this.I = l(jSONObject);
        this.J = jSONObject.optInt(Constants.EXTRA_CONFIG_CURSOR);
        this.K = jSONObject.optInt("selectionStart");
        this.L = jSONObject.optInt("selectionEnd");
        this.M = jSONObject.optString("confirmType");
        this.N = jSONObject.optInt(InputType.PASSWORD) == 1;
        j();
    }

    @Override // c.a.p0.a.s.a.c.c, c.a.p0.a.s.a.d.b, c.a.p0.a.s.b.b
    public void h(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
            super.h(jSONObject);
            if (!TextUtils.isEmpty(jSONObject.optString("cursorSpacing"))) {
                this.I = l(jSONObject);
            }
            this.H = jSONObject.optInt("maxLength", this.H);
            this.J = jSONObject.optInt(Constants.EXTRA_CONFIG_CURSOR, this.J);
            this.K = jSONObject.optInt("selectionStart", this.K);
            this.L = jSONObject.optInt("selectionEnd", this.L);
            this.M = jSONObject.optString("confirmType", this.M);
            this.N = jSONObject.optInt(InputType.PASSWORD, this.N ? 1 : 0) == 1;
            this.x = jSONObject.optString("value", this.x);
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
            this.K = i2;
            this.L = i3;
        }
    }

    public void n(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.O = i2;
        }
    }
}
