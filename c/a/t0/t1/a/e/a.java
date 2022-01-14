package c.a.t0.t1.a.e;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.t0.t1.a.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C1443a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public String f23699b;

        /* renamed from: c  reason: collision with root package name */
        public String f23700c;

        /* renamed from: d  reason: collision with root package name */
        public String f23701d;

        /* renamed from: e  reason: collision with root package name */
        public String f23702e;

        /* renamed from: f  reason: collision with root package name */
        public String f23703f;

        /* renamed from: g  reason: collision with root package name */
        public String f23704g;

        /* renamed from: h  reason: collision with root package name */
        public int f23705h;

        public C1443a() {
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
    }

    public static C1443a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            C1443a c1443a = new C1443a();
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() > 0) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(0);
                    optJSONObject.optString("title");
                    c1443a.f23699b = optJSONObject.optString("content");
                    c1443a.f23700c = optJSONObject.optString("quote_content");
                    c1443a.f23701d = optJSONObject.optString("fname");
                    c1443a.f23702e = optJSONObject.optString("thread_id");
                    c1443a.f23703f = optJSONObject.optString("post_id");
                    c1443a.f23705h = optJSONObject.optInt("type");
                    c1443a.f23704g = optJSONObject.optString("title");
                    optJSONObject.optInt("thread_type");
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject("quote_user");
                    if (optJSONObject2 != null) {
                        optJSONObject2.optString("id");
                        optJSONObject2.optString("portrait");
                        optJSONObject2.optInt("gender");
                    }
                    JSONObject optJSONObject3 = optJSONObject.optJSONObject("replyer");
                    if (optJSONObject3 != null) {
                        optJSONObject3.optString("id");
                        c1443a.a = optJSONObject3.optInt("gender");
                    }
                }
                return c1443a;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (C1443a) invokeL.objValue;
    }
}
