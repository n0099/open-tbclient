package c.a.p0.e3;

import c.a.p0.e3.b;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c extends b.AbstractC1046b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public final int f13814d;

    /* renamed from: e  reason: collision with root package name */
    public final String f13815e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(int i, String str, int i2, String str2) {
        super(i, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), str, Integer.valueOf(i2), str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f13814d = i2;
        this.f13815e = str2;
    }

    @Override // c.a.p0.e3.b.AbstractC1046b, c.a.p0.e3.b
    public JSONObject a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject a = super.a();
            try {
                JSONObject jSONObject = new JSONObject();
                if (this.f13814d != -4399) {
                    jSONObject.put("code", this.f13814d);
                }
                if (!StringUtils.isNull(this.f13815e)) {
                    jSONObject.put("msg", this.f13815e);
                }
                a.put("ext", jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return a;
        }
        return (JSONObject) invokeV.objValue;
    }
}
