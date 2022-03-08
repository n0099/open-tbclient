package c.a.r0.s1.f.k;

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
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.r0.s1.f.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1356a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f21771b;

        /* renamed from: c  reason: collision with root package name */
        public String f21772c;

        /* renamed from: d  reason: collision with root package name */
        public long f21773d;

        /* renamed from: e  reason: collision with root package name */
        public String f21774e;

        /* renamed from: f  reason: collision with root package name */
        public long f21775f;

        /* renamed from: g  reason: collision with root package name */
        public String f21776g;

        /* renamed from: h  reason: collision with root package name */
        public long f21777h;

        /* renamed from: i  reason: collision with root package name */
        public int f21778i;

        /* renamed from: j  reason: collision with root package name */
        public int f21779j;

        public C1356a() {
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
            this.f21771b = null;
            this.f21772c = null;
            this.f21775f = 0L;
            this.f21776g = null;
            this.f21777h = 0L;
            this.f21778i = 0;
            this.f21779j = 0;
        }
    }

    public static C1356a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            C1356a c1356a = new C1356a();
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() > 0) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(0);
                    c1356a.a = optJSONObject.optString(TableDefine.UserInfoColumns.COLUMN_HEAD_URL);
                    c1356a.f21771b = optJSONObject.optString("user_id");
                    c1356a.f21772c = optJSONObject.optString("nick_name");
                    c1356a.f21773d = optJSONObject.optLong("caller_time");
                    c1356a.f21774e = optJSONObject.optString("caller_content");
                    c1356a.f21775f = optJSONObject.optLong("thread_id");
                    c1356a.f21776g = optJSONObject.optString(MissonDetailsActivityConfig.THREAD_TITLE);
                    optJSONObject.optString("forum_name");
                    c1356a.f21777h = optJSONObject.optLong("post_id");
                    c1356a.f21778i = optJSONObject.optInt("msg_type");
                    c1356a.f21779j = optJSONObject.optInt("remind_count");
                }
                return c1356a;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (C1356a) invokeL.objValue;
    }
}
