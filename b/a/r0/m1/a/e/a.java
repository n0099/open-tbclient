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
    public static class C1092a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f22138a;

        /* renamed from: b  reason: collision with root package name */
        public String f22139b;

        /* renamed from: c  reason: collision with root package name */
        public String f22140c;

        /* renamed from: d  reason: collision with root package name */
        public String f22141d;

        /* renamed from: e  reason: collision with root package name */
        public String f22142e;

        /* renamed from: f  reason: collision with root package name */
        public String f22143f;

        /* renamed from: g  reason: collision with root package name */
        public String f22144g;

        /* renamed from: h  reason: collision with root package name */
        public int f22145h;

        public C1092a() {
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

    public static C1092a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            C1092a c1092a = new C1092a();
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() > 0) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(0);
                    optJSONObject.optString("title");
                    c1092a.f22139b = optJSONObject.optString("content");
                    c1092a.f22140c = optJSONObject.optString("quote_content");
                    c1092a.f22141d = optJSONObject.optString("fname");
                    c1092a.f22142e = optJSONObject.optString("thread_id");
                    c1092a.f22143f = optJSONObject.optString("post_id");
                    c1092a.f22145h = optJSONObject.optInt("type");
                    c1092a.f22144g = optJSONObject.optString("title");
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
                        c1092a.f22138a = optJSONObject3.optInt("gender");
                    }
                }
                return c1092a;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (C1092a) invokeL.objValue;
    }
}
