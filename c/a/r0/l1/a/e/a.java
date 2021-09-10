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
    public static class C1027a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f21875a;

        /* renamed from: b  reason: collision with root package name */
        public String f21876b;

        /* renamed from: c  reason: collision with root package name */
        public String f21877c;

        /* renamed from: d  reason: collision with root package name */
        public String f21878d;

        /* renamed from: e  reason: collision with root package name */
        public String f21879e;

        /* renamed from: f  reason: collision with root package name */
        public String f21880f;

        /* renamed from: g  reason: collision with root package name */
        public String f21881g;

        /* renamed from: h  reason: collision with root package name */
        public int f21882h;

        public C1027a() {
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

    public static C1027a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            C1027a c1027a = new C1027a();
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() > 0) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(0);
                    optJSONObject.optString("title");
                    c1027a.f21876b = optJSONObject.optString("content");
                    c1027a.f21877c = optJSONObject.optString("quote_content");
                    c1027a.f21878d = optJSONObject.optString("fname");
                    c1027a.f21879e = optJSONObject.optString("thread_id");
                    c1027a.f21880f = optJSONObject.optString("post_id");
                    c1027a.f21882h = optJSONObject.optInt("type");
                    c1027a.f21881g = optJSONObject.optString("title");
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
                        c1027a.f21875a = optJSONObject3.optInt("gender");
                    }
                }
                return c1027a;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (C1027a) invokeL.objValue;
    }
}
