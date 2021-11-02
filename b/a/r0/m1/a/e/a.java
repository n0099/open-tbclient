package b.a.r0.m1.a.e;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b.a.r0.m1.a.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1030a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f20983a;

        /* renamed from: b  reason: collision with root package name */
        public String f20984b;

        /* renamed from: c  reason: collision with root package name */
        public String f20985c;

        /* renamed from: d  reason: collision with root package name */
        public String f20986d;

        /* renamed from: e  reason: collision with root package name */
        public String f20987e;

        /* renamed from: f  reason: collision with root package name */
        public String f20988f;

        /* renamed from: g  reason: collision with root package name */
        public String f20989g;

        /* renamed from: h  reason: collision with root package name */
        public int f20990h;

        public C1030a() {
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

    public static C1030a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            C1030a c1030a = new C1030a();
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() > 0) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(0);
                    optJSONObject.optString("title");
                    c1030a.f20984b = optJSONObject.optString("content");
                    c1030a.f20985c = optJSONObject.optString("quote_content");
                    c1030a.f20986d = optJSONObject.optString("fname");
                    c1030a.f20987e = optJSONObject.optString("thread_id");
                    c1030a.f20988f = optJSONObject.optString("post_id");
                    c1030a.f20990h = optJSONObject.optInt("type");
                    c1030a.f20989g = optJSONObject.optString("title");
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
                        c1030a.f20983a = optJSONObject3.optInt("gender");
                    }
                }
                return c1030a;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (C1030a) invokeL.objValue;
    }
}
