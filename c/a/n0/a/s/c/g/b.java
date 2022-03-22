package c.a.n0.a.s.c.g;

import c.a.n0.a.p2.n0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tachikoma.core.component.button.StyleHelper;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class b extends c.a.n0.a.s.a.a.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String L;
    public int M;
    public String N;
    public String O;
    public boolean P;
    public boolean Q;
    public boolean R;
    public boolean S;
    public boolean T;
    public int U;
    public int V;
    public boolean W;
    public boolean X;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b() {
        super("textArea", "componentId");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                super((String) objArr[0], (String) objArr[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.L = "";
        this.N = "";
        this.O = "";
    }

    private void i() {
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65537, this) == null) || (jSONObject = this.j) == null) {
            return;
        }
        int g2 = n0.g(c(jSONObject, "minHeight", 0.0f));
        if (g2 < 0) {
            g2 = 0;
        }
        this.U = g2;
        int g3 = n0.g(c(this.j, "maxHeight", 2.1474836E9f));
        if (g3 < 0) {
            g3 = Integer.MAX_VALUE;
        }
        this.V = g3;
    }

    @Override // c.a.n0.a.s.a.a.b, c.a.n0.a.s.a.c.c, c.a.n0.a.s.a.d.b, c.a.n0.a.s.b.b, c.a.n0.a.c1.a
    public void a(JSONObject jSONObject) throws JSONException {
        c.a.n0.a.c1.e.a.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        super.a(jSONObject);
        this.t = jSONObject.optString("value");
        this.L = jSONObject.optString("placeholder");
        o(jSONObject);
        this.P = jSONObject.optBoolean(AddFriendActivityConfig.TYPE_FOCUS, false);
        boolean optBoolean = jSONObject.optBoolean("autoHeight", false);
        this.Q = optBoolean;
        if (optBoolean && (aVar = this.f6102h) != null) {
            aVar.j(-2);
            this.f6102h.k(true);
        }
        boolean optBoolean2 = jSONObject.optBoolean("fixed");
        this.R = optBoolean2;
        c.a.n0.a.c1.e.a.a aVar2 = this.f6102h;
        if (aVar2 != null) {
            aVar2.i(optBoolean2);
        }
        this.S = jSONObject.optBoolean("showConfirmBar", true);
        this.T = jSONObject.optBoolean("adjustPosition", true);
        this.W = jSONObject.optBoolean(StyleHelper.KEY_ONDISABLE, false);
        this.X = jSONObject.optInt("confirmHold") == 1;
        i();
    }

    @Override // c.a.n0.a.s.a.a.b, c.a.n0.a.s.a.c.c, c.a.n0.a.s.a.d.b, c.a.n0.a.s.b.b
    public void g(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
            super.g(jSONObject);
            this.W = jSONObject.optBoolean(StyleHelper.KEY_ONDISABLE, this.W);
            this.L = jSONObject.optString("placeholder", this.L);
            this.t = jSONObject.optString("value", this.t);
            this.P = jSONObject.optBoolean(AddFriendActivityConfig.TYPE_FOCUS, this.P);
            this.S = jSONObject.optBoolean("showConfirmBar", this.S);
            this.T = jSONObject.optBoolean("adjustPosition", this.T);
            n(jSONObject);
            p(jSONObject);
            o(jSONObject);
            i();
        }
    }

    public final void n(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
            boolean optBoolean = jSONObject.optBoolean("autoHeight", this.Q);
            this.Q = optBoolean;
            c.a.n0.a.c1.e.a.a aVar = this.f6102h;
            if (aVar != null) {
                if (optBoolean) {
                    aVar.j(-2);
                    this.f6102h.k(true);
                    return;
                }
                int c2 = aVar.c();
                int i = this.K;
                if (i > 0) {
                    c2 = i;
                }
                this.f6102h.j(c2);
                this.f6102h.k(false);
            }
        }
    }

    public final void o(JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, jSONObject) == null) || (optJSONObject = jSONObject.optJSONObject("placeholderStyle")) == null) {
            return;
        }
        this.M = optJSONObject.optInt(TtmlNode.ATTR_TTS_FONT_SIZE);
        this.N = optJSONObject.optString(TtmlNode.ATTR_TTS_FONT_WEIGHT);
        this.O = optJSONObject.optString("color");
    }

    public final void p(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, jSONObject) == null) {
            boolean optBoolean = jSONObject.optBoolean("fixed", this.R);
            this.R = optBoolean;
            c.a.n0.a.c1.e.a.a aVar = this.f6102h;
            if (aVar != null) {
                aVar.i(optBoolean);
            }
        }
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.P = z;
        }
    }
}
