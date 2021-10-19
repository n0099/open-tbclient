package c.a.r0.m1.a.e;

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

    /* renamed from: c.a.r0.m1.a.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1034a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f22069a;

        /* renamed from: b  reason: collision with root package name */
        public String f22070b;

        /* renamed from: c  reason: collision with root package name */
        public String f22071c;

        /* renamed from: d  reason: collision with root package name */
        public String f22072d;

        /* renamed from: e  reason: collision with root package name */
        public String f22073e;

        /* renamed from: f  reason: collision with root package name */
        public String f22074f;

        /* renamed from: g  reason: collision with root package name */
        public String f22075g;

        /* renamed from: h  reason: collision with root package name */
        public int f22076h;

        public C1034a() {
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

    public static C1034a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            C1034a c1034a = new C1034a();
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() > 0) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(0);
                    optJSONObject.optString("title");
                    c1034a.f22070b = optJSONObject.optString("content");
                    c1034a.f22071c = optJSONObject.optString("quote_content");
                    c1034a.f22072d = optJSONObject.optString("fname");
                    c1034a.f22073e = optJSONObject.optString("thread_id");
                    c1034a.f22074f = optJSONObject.optString("post_id");
                    c1034a.f22076h = optJSONObject.optInt("type");
                    c1034a.f22075g = optJSONObject.optString("title");
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
                        c1034a.f22069a = optJSONObject3.optInt("gender");
                    }
                }
                return c1034a;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (C1034a) invokeL.objValue;
    }
}
