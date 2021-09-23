package c.a.r0.l1.a.e;

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

    /* renamed from: c.a.r0.l1.a.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1025a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f21889a;

        /* renamed from: b  reason: collision with root package name */
        public String f21890b;

        /* renamed from: c  reason: collision with root package name */
        public String f21891c;

        /* renamed from: d  reason: collision with root package name */
        public String f21892d;

        /* renamed from: e  reason: collision with root package name */
        public String f21893e;

        /* renamed from: f  reason: collision with root package name */
        public String f21894f;

        /* renamed from: g  reason: collision with root package name */
        public String f21895g;

        /* renamed from: h  reason: collision with root package name */
        public int f21896h;

        public C1025a() {
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

    public static C1025a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            C1025a c1025a = new C1025a();
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() > 0) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(0);
                    optJSONObject.optString("title");
                    c1025a.f21890b = optJSONObject.optString("content");
                    c1025a.f21891c = optJSONObject.optString("quote_content");
                    c1025a.f21892d = optJSONObject.optString("fname");
                    c1025a.f21893e = optJSONObject.optString("thread_id");
                    c1025a.f21894f = optJSONObject.optString("post_id");
                    c1025a.f21896h = optJSONObject.optInt("type");
                    c1025a.f21895g = optJSONObject.optString("title");
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
                        c1025a.f21889a = optJSONObject3.optInt("gender");
                    }
                }
                return c1025a;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (C1025a) invokeL.objValue;
    }
}
