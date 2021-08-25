package c.a.q0.k1.a.e;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.q0.k1.a.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0994a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f21295a;

        /* renamed from: b  reason: collision with root package name */
        public String f21296b;

        /* renamed from: c  reason: collision with root package name */
        public String f21297c;

        /* renamed from: d  reason: collision with root package name */
        public String f21298d;

        /* renamed from: e  reason: collision with root package name */
        public String f21299e;

        /* renamed from: f  reason: collision with root package name */
        public String f21300f;

        /* renamed from: g  reason: collision with root package name */
        public String f21301g;

        /* renamed from: h  reason: collision with root package name */
        public int f21302h;

        public C0994a() {
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

    public static C0994a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            C0994a c0994a = new C0994a();
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() > 0) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(0);
                    optJSONObject.optString("title");
                    c0994a.f21296b = optJSONObject.optString("content");
                    c0994a.f21297c = optJSONObject.optString("quote_content");
                    c0994a.f21298d = optJSONObject.optString("fname");
                    c0994a.f21299e = optJSONObject.optString("thread_id");
                    c0994a.f21300f = optJSONObject.optString("post_id");
                    c0994a.f21302h = optJSONObject.optInt("type");
                    c0994a.f21301g = optJSONObject.optString("title");
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
                        c0994a.f21295a = optJSONObject3.optInt("gender");
                    }
                }
                return c0994a;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (C0994a) invokeL.objValue;
    }
}
