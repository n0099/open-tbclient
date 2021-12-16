package c.a.s0.t1.a.e;

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

    /* renamed from: c.a.s0.t1.a.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C1400a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public String f23870b;

        /* renamed from: c  reason: collision with root package name */
        public String f23871c;

        /* renamed from: d  reason: collision with root package name */
        public String f23872d;

        /* renamed from: e  reason: collision with root package name */
        public String f23873e;

        /* renamed from: f  reason: collision with root package name */
        public String f23874f;

        /* renamed from: g  reason: collision with root package name */
        public String f23875g;

        /* renamed from: h  reason: collision with root package name */
        public int f23876h;

        public C1400a() {
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

    public static C1400a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            C1400a c1400a = new C1400a();
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() > 0) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(0);
                    optJSONObject.optString("title");
                    c1400a.f23870b = optJSONObject.optString("content");
                    c1400a.f23871c = optJSONObject.optString("quote_content");
                    c1400a.f23872d = optJSONObject.optString("fname");
                    c1400a.f23873e = optJSONObject.optString("thread_id");
                    c1400a.f23874f = optJSONObject.optString("post_id");
                    c1400a.f23876h = optJSONObject.optInt("type");
                    c1400a.f23875g = optJSONObject.optString("title");
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
                        c1400a.a = optJSONObject3.optInt("gender");
                    }
                }
                return c1400a;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (C1400a) invokeL.objValue;
    }
}
