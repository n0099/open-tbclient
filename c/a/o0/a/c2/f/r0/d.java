package c.a.o0.a.c2.f.r0;

import android.text.TextUtils;
import c.a.o0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebView;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class d extends c.a.o0.a.c0.b.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String n;
    public String o;
    public String p;
    public boolean q;
    public List<String> r;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1571263179, "Lc/a/o0/a/c2/f/r0/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1571263179, "Lc/a/o0/a/c2/f/r0/d;");
                return;
            }
        }
        boolean z = k.f7049a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d() {
        super("webView", "viewId");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                super((String) objArr[0], (String) objArr[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.q = true;
    }

    public static d j(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, unitedSchemeEntity)) == null) {
            if (unitedSchemeEntity == null) {
                return null;
            }
            String str = unitedSchemeEntity.getParams().get("params");
            d dVar = new d();
            try {
                dVar.a(new JSONObject(str));
                return dVar;
            } catch (JSONException e2) {
                c.a.o0.a.e0.d.c(WebView.LOGTAG, "parsing params occurs exception", e2);
                return null;
            }
        }
        return (d) invokeL.objValue;
    }

    @Override // c.a.o0.a.c0.b.b, c.a.o0.a.l1.a
    public void a(JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        super.a(jSONObject);
        this.n = jSONObject.optString("src");
        this.o = jSONObject.optString("userAgent");
        this.p = jSONObject.optString("type");
        JSONArray optJSONArray = jSONObject.optJSONArray("targetUrls");
        if (optJSONArray == null || optJSONArray.length() == 0) {
            return;
        }
        this.r = new ArrayList();
        int length = optJSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            this.r.add(optJSONArray.optString(i2));
        }
    }

    @Override // c.a.o0.a.c0.b.b, c.a.o0.a.l1.a
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? !TextUtils.isEmpty(this.f4630g) : invokeV.booleanValue;
    }
}
