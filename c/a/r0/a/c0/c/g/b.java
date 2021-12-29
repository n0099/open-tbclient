package c.a.r0.a.c0.c.g;

import c.a.r0.a.z2.n0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.component.button.StyleHelper;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class b extends c.a.r0.a.c0.a.a.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String P;
    public int Q;
    public String R;
    public String S;
    public boolean T;
    public boolean U;
    public boolean V;
    public boolean W;
    public boolean X;
    public int Y;
    public int Z;
    public boolean a0;
    public boolean b0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b() {
        super("textArea", "componentId");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                super((String) objArr[0], (String) objArr[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.P = "";
        this.R = "";
        this.S = "";
    }

    private void j() {
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65537, this) == null) || (jSONObject = this.n) == null) {
            return;
        }
        int g2 = n0.g(c(jSONObject, "minHeight", 0.0f));
        if (g2 < 0) {
            g2 = 0;
        }
        this.Y = g2;
        int g3 = n0.g(c(this.n, "maxHeight", 2.1474836E9f));
        if (g3 < 0) {
            g3 = Integer.MAX_VALUE;
        }
        this.Z = g3;
    }

    @Override // c.a.r0.a.c0.a.a.b, c.a.r0.a.c0.a.c.c, c.a.r0.a.c0.a.d.b, c.a.r0.a.c0.b.b, c.a.r0.a.m1.a
    public void a(JSONObject jSONObject) throws JSONException {
        c.a.r0.a.m1.e.a.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        super.a(jSONObject);
        this.x = jSONObject.optString("value");
        this.P = jSONObject.optString("placeholder");
        p(jSONObject);
        this.T = jSONObject.optBoolean(AddFriendActivityConfig.TYPE_FOCUS, false);
        boolean optBoolean = jSONObject.optBoolean("autoHeight", false);
        this.U = optBoolean;
        if (optBoolean && (aVar = this.l) != null) {
            aVar.k(-2);
            this.l.l(true);
        }
        boolean optBoolean2 = jSONObject.optBoolean("fixed");
        this.V = optBoolean2;
        c.a.r0.a.m1.e.a.a aVar2 = this.l;
        if (aVar2 != null) {
            aVar2.j(optBoolean2);
        }
        this.W = jSONObject.optBoolean("showConfirmBar", true);
        this.X = jSONObject.optBoolean("adjustPosition", true);
        this.a0 = jSONObject.optBoolean(StyleHelper.KEY_ONDISABLE, false);
        this.b0 = jSONObject.optInt("confirmHold") == 1;
        j();
    }

    @Override // c.a.r0.a.c0.a.a.b, c.a.r0.a.c0.a.c.c, c.a.r0.a.c0.a.d.b, c.a.r0.a.c0.b.b
    public void h(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
            super.h(jSONObject);
            this.a0 = jSONObject.optBoolean(StyleHelper.KEY_ONDISABLE, this.a0);
            this.P = jSONObject.optString("placeholder", this.P);
            this.x = jSONObject.optString("value", this.x);
            this.T = jSONObject.optBoolean(AddFriendActivityConfig.TYPE_FOCUS, this.T);
            this.W = jSONObject.optBoolean("showConfirmBar", this.W);
            this.X = jSONObject.optBoolean("adjustPosition", this.X);
            o(jSONObject);
            q(jSONObject);
            p(jSONObject);
            j();
        }
    }

    public final void o(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
            boolean optBoolean = jSONObject.optBoolean("autoHeight", this.U);
            this.U = optBoolean;
            c.a.r0.a.m1.e.a.a aVar = this.l;
            if (aVar != null) {
                if (optBoolean) {
                    aVar.k(-2);
                    this.l.l(true);
                    return;
                }
                int c2 = aVar.c();
                int i2 = this.O;
                if (i2 > 0) {
                    c2 = i2;
                }
                this.l.k(c2);
                this.l.l(false);
            }
        }
    }

    public final void p(JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, jSONObject) == null) || (optJSONObject = jSONObject.optJSONObject("placeholderStyle")) == null) {
            return;
        }
        this.Q = optJSONObject.optInt("fontSize");
        this.R = optJSONObject.optString("fontWeight");
        this.S = optJSONObject.optString("color");
    }

    public final void q(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, jSONObject) == null) {
            boolean optBoolean = jSONObject.optBoolean("fixed", this.V);
            this.V = optBoolean;
            c.a.r0.a.m1.e.a.a aVar = this.l;
            if (aVar != null) {
                aVar.j(optBoolean);
            }
        }
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.T = z;
        }
    }
}
