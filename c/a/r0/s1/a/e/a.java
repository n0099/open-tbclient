package c.a.r0.s1.a.e;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.r0.s1.a.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C1346a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public String f23315b;

        /* renamed from: c  reason: collision with root package name */
        public String f23316c;

        /* renamed from: d  reason: collision with root package name */
        public String f23317d;

        /* renamed from: e  reason: collision with root package name */
        public String f23318e;

        /* renamed from: f  reason: collision with root package name */
        public String f23319f;

        /* renamed from: g  reason: collision with root package name */
        public String f23320g;

        /* renamed from: h  reason: collision with root package name */
        public int f23321h;

        public C1346a() {
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

    public static C1346a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            C1346a c1346a = new C1346a();
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() > 0) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(0);
                    optJSONObject.optString("title");
                    c1346a.f23315b = optJSONObject.optString("content");
                    c1346a.f23316c = optJSONObject.optString("quote_content");
                    c1346a.f23317d = optJSONObject.optString("fname");
                    c1346a.f23318e = optJSONObject.optString("thread_id");
                    c1346a.f23319f = optJSONObject.optString("post_id");
                    c1346a.f23321h = optJSONObject.optInt("type");
                    c1346a.f23320g = optJSONObject.optString("title");
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
                        c1346a.a = optJSONObject3.optInt("gender");
                    }
                }
                return c1346a;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (C1346a) invokeL.objValue;
    }
}
