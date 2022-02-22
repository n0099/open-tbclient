package c.a.u0.t1.f.k;

import android.text.TextUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.tbadk.core.atomData.MissonDetailsActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.u0.t1.f.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C1379a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f22515b;

        /* renamed from: c  reason: collision with root package name */
        public String f22516c;

        /* renamed from: d  reason: collision with root package name */
        public long f22517d;

        /* renamed from: e  reason: collision with root package name */
        public String f22518e;

        /* renamed from: f  reason: collision with root package name */
        public long f22519f;

        /* renamed from: g  reason: collision with root package name */
        public String f22520g;

        /* renamed from: h  reason: collision with root package name */
        public long f22521h;

        /* renamed from: i  reason: collision with root package name */
        public int f22522i;

        /* renamed from: j  reason: collision with root package name */
        public int f22523j;

        public C1379a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = null;
            this.f22515b = null;
            this.f22516c = null;
            this.f22519f = 0L;
            this.f22520g = null;
            this.f22521h = 0L;
            this.f22522i = 0;
            this.f22523j = 0;
        }
    }

    public static C1379a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            C1379a c1379a = new C1379a();
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() > 0) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(0);
                    c1379a.a = optJSONObject.optString(TableDefine.UserInfoColumns.COLUMN_HEAD_URL);
                    c1379a.f22515b = optJSONObject.optString("user_id");
                    c1379a.f22516c = optJSONObject.optString("nick_name");
                    c1379a.f22517d = optJSONObject.optLong("caller_time");
                    c1379a.f22518e = optJSONObject.optString("caller_content");
                    c1379a.f22519f = optJSONObject.optLong("thread_id");
                    c1379a.f22520g = optJSONObject.optString(MissonDetailsActivityConfig.THREAD_TITLE);
                    optJSONObject.optString("forum_name");
                    c1379a.f22521h = optJSONObject.optLong("post_id");
                    c1379a.f22522i = optJSONObject.optInt("msg_type");
                    c1379a.f22523j = optJSONObject.optInt("remind_count");
                }
                return c1379a;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (C1379a) invokeL.objValue;
    }
}
