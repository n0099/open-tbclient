package c.a.p0.v1.a.e;

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

    /* renamed from: c.a.p0.v1.a.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1445a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public String f19088b;

        /* renamed from: c  reason: collision with root package name */
        public String f19089c;

        /* renamed from: d  reason: collision with root package name */
        public String f19090d;

        /* renamed from: e  reason: collision with root package name */
        public String f19091e;

        /* renamed from: f  reason: collision with root package name */
        public String f19092f;

        /* renamed from: g  reason: collision with root package name */
        public String f19093g;

        /* renamed from: h  reason: collision with root package name */
        public int f19094h;

        public C1445a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public static C1445a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            C1445a c1445a = new C1445a();
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() > 0) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(0);
                    optJSONObject.optString("title");
                    c1445a.f19088b = optJSONObject.optString("content");
                    c1445a.f19089c = optJSONObject.optString("quote_content");
                    c1445a.f19090d = optJSONObject.optString("fname");
                    c1445a.f19091e = optJSONObject.optString("thread_id");
                    c1445a.f19092f = optJSONObject.optString("post_id");
                    c1445a.f19094h = optJSONObject.optInt("type");
                    c1445a.f19093g = optJSONObject.optString("title");
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
                        c1445a.a = optJSONObject3.optInt("gender");
                    }
                }
                return c1445a;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (C1445a) invokeL.objValue;
    }
}
