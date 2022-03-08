package c.a.r0.t1.a.e;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.r0.t1.a.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1392a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public String f22214b;

        /* renamed from: c  reason: collision with root package name */
        public String f22215c;

        /* renamed from: d  reason: collision with root package name */
        public String f22216d;

        /* renamed from: e  reason: collision with root package name */
        public String f22217e;

        /* renamed from: f  reason: collision with root package name */
        public String f22218f;

        /* renamed from: g  reason: collision with root package name */
        public String f22219g;

        /* renamed from: h  reason: collision with root package name */
        public int f22220h;

        public C1392a() {
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

    public static C1392a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            C1392a c1392a = new C1392a();
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() > 0) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(0);
                    optJSONObject.optString("title");
                    c1392a.f22214b = optJSONObject.optString("content");
                    c1392a.f22215c = optJSONObject.optString("quote_content");
                    c1392a.f22216d = optJSONObject.optString("fname");
                    c1392a.f22217e = optJSONObject.optString("thread_id");
                    c1392a.f22218f = optJSONObject.optString("post_id");
                    c1392a.f22220h = optJSONObject.optInt("type");
                    c1392a.f22219g = optJSONObject.optString("title");
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
                        c1392a.a = optJSONObject3.optInt("gender");
                    }
                }
                return c1392a;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (C1392a) invokeL.objValue;
    }
}
