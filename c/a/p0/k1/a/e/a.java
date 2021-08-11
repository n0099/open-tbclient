package c.a.p0.k1.a.e;

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

    /* renamed from: c.a.p0.k1.a.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0983a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f20965a;

        /* renamed from: b  reason: collision with root package name */
        public String f20966b;

        /* renamed from: c  reason: collision with root package name */
        public String f20967c;

        /* renamed from: d  reason: collision with root package name */
        public String f20968d;

        /* renamed from: e  reason: collision with root package name */
        public String f20969e;

        /* renamed from: f  reason: collision with root package name */
        public String f20970f;

        /* renamed from: g  reason: collision with root package name */
        public String f20971g;

        /* renamed from: h  reason: collision with root package name */
        public int f20972h;

        public C0983a() {
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

    public static C0983a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            C0983a c0983a = new C0983a();
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() > 0) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(0);
                    optJSONObject.optString("title");
                    c0983a.f20966b = optJSONObject.optString("content");
                    c0983a.f20967c = optJSONObject.optString("quote_content");
                    c0983a.f20968d = optJSONObject.optString("fname");
                    c0983a.f20969e = optJSONObject.optString("thread_id");
                    c0983a.f20970f = optJSONObject.optString("post_id");
                    c0983a.f20972h = optJSONObject.optInt("type");
                    c0983a.f20971g = optJSONObject.optString("title");
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
                        c0983a.f20965a = optJSONObject3.optInt("gender");
                    }
                }
                return c0983a;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (C0983a) invokeL.objValue;
    }
}
