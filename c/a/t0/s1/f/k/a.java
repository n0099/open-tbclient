package c.a.t0.s1.f.k;

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
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.t0.s1.f.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C1346a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f22644b;

        /* renamed from: c  reason: collision with root package name */
        public String f22645c;

        /* renamed from: d  reason: collision with root package name */
        public long f22646d;

        /* renamed from: e  reason: collision with root package name */
        public String f22647e;

        /* renamed from: f  reason: collision with root package name */
        public long f22648f;

        /* renamed from: g  reason: collision with root package name */
        public String f22649g;

        /* renamed from: h  reason: collision with root package name */
        public long f22650h;

        /* renamed from: i  reason: collision with root package name */
        public int f22651i;

        /* renamed from: j  reason: collision with root package name */
        public int f22652j;

        public C1346a() {
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
            this.f22644b = null;
            this.f22645c = null;
            this.f22648f = 0L;
            this.f22649g = null;
            this.f22650h = 0L;
            this.f22651i = 0;
            this.f22652j = 0;
        }
    }

    public static C1346a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            C1346a c1346a = new C1346a();
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() > 0) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(0);
                    c1346a.a = optJSONObject.optString(TableDefine.UserInfoColumns.COLUMN_HEAD_URL);
                    c1346a.f22644b = optJSONObject.optString("user_id");
                    c1346a.f22645c = optJSONObject.optString("nick_name");
                    c1346a.f22646d = optJSONObject.optLong("caller_time");
                    c1346a.f22647e = optJSONObject.optString("caller_content");
                    c1346a.f22648f = optJSONObject.optLong("thread_id");
                    c1346a.f22649g = optJSONObject.optString(MissonDetailsActivityConfig.THREAD_TITLE);
                    optJSONObject.optString("forum_name");
                    c1346a.f22650h = optJSONObject.optLong("post_id");
                    c1346a.f22651i = optJSONObject.optInt("msg_type");
                    c1346a.f22652j = optJSONObject.optInt("remind_count");
                }
                return c1346a;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (C1346a) invokeL.objValue;
    }
}
