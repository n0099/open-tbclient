package c.a.n0.a.c0.a.c;

import android.graphics.Color;
import androidx.annotation.NonNull;
import c.a.n0.a.e0.d;
import c.a.n0.a.v2.n0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c extends c.a.n0.a.c0.a.d.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public double A;
    public int B;
    public String C;
    public String D;
    public String E;
    public String F;
    public String x;
    public int y;
    public boolean z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(String str, @NonNull String str2) {
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
        this.x = "";
        this.z = false;
        this.C = "";
        this.D = "";
        this.E = "";
        this.F = "";
    }

    private void k() {
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65537, this) == null) || (jSONObject = this.n) == null) {
            return;
        }
        try {
            this.y = Color.parseColor(jSONObject.optString("color"));
            this.z = true;
        } catch (Exception unused) {
            d.l("Component-Model-TextView", "text color occurs exception");
            this.z = false;
        }
        this.A = this.n.optDouble("fontSize", 0.0d);
        this.B = n0.g((float) this.n.optDouble("lineHeight", 0.0d));
        n0.g((float) this.n.optDouble("lineSpace", 0.0d));
        this.C = this.n.optString("textAlign");
        this.D = this.n.optString("fontWeight");
        this.E = this.n.optString("whiteSpace");
        this.F = this.n.optString("lineBreak");
    }

    @Override // c.a.n0.a.c0.a.d.b, c.a.n0.a.c0.b.b, c.a.n0.a.l1.a
    public void a(JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        super.a(jSONObject);
        this.x = jSONObject.optString("text");
        k();
    }

    @Override // c.a.n0.a.c0.a.d.b, c.a.n0.a.c0.b.b
    public void i(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
            super.i(jSONObject);
            this.x = jSONObject.optString("text", this.x);
            k();
        }
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.x = str;
        }
    }
}
