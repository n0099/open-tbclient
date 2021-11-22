package b.a.p0.a.k1.e;

import android.text.TextUtils;
import com.baidu.searchbox.aperf.bosuploader.ContentUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f6899a;

    /* renamed from: b  reason: collision with root package name */
    public String f6900b;

    /* renamed from: c  reason: collision with root package name */
    public String f6901c;

    /* renamed from: d  reason: collision with root package name */
    public String f6902d;

    /* renamed from: e  reason: collision with root package name */
    public String f6903e;

    /* renamed from: f  reason: collision with root package name */
    public String f6904f;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static a a(JSONObject jSONObject, String str) {
        InterceptResult invokeLL;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, jSONObject, str)) == null) {
            if (jSONObject == null) {
                return null;
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("data");
            String optString = jSONObject.optString("error");
            if (optJSONObject2 == null || !TextUtils.equals(optString, "0")) {
                return null;
            }
            a aVar = new a();
            aVar.f6899a = optJSONObject2.optString(ContentUtil.RESULT_KEY_AK);
            aVar.f6900b = optJSONObject2.optString(ContentUtil.RESULT_KEY_SK);
            aVar.f6901c = optJSONObject2.optString("token");
            aVar.f6902d = optJSONObject2.optString(ContentUtil.RESULT_KEY_BUCKET);
            JSONObject optJSONObject3 = optJSONObject2.optJSONObject("oname_list");
            if (optJSONObject3 != null && (optJSONObject = optJSONObject3.optJSONObject(str)) != null) {
                aVar.f6904f = optJSONObject.optString("bosobject");
                aVar.f6903e = optJSONObject.optString("bosurl");
            }
            return aVar;
        }
        return (a) invokeLL.objValue;
    }
}
