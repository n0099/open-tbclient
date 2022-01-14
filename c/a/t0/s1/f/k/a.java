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
    public static class C1361a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f22023b;

        /* renamed from: c  reason: collision with root package name */
        public String f22024c;

        /* renamed from: d  reason: collision with root package name */
        public long f22025d;

        /* renamed from: e  reason: collision with root package name */
        public String f22026e;

        /* renamed from: f  reason: collision with root package name */
        public long f22027f;

        /* renamed from: g  reason: collision with root package name */
        public String f22028g;

        /* renamed from: h  reason: collision with root package name */
        public long f22029h;

        /* renamed from: i  reason: collision with root package name */
        public int f22030i;

        /* renamed from: j  reason: collision with root package name */
        public int f22031j;

        public C1361a() {
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
            this.f22023b = null;
            this.f22024c = null;
            this.f22027f = 0L;
            this.f22028g = null;
            this.f22029h = 0L;
            this.f22030i = 0;
            this.f22031j = 0;
        }
    }

    public static C1361a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            C1361a c1361a = new C1361a();
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() > 0) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(0);
                    c1361a.a = optJSONObject.optString(TableDefine.UserInfoColumns.COLUMN_HEAD_URL);
                    c1361a.f22023b = optJSONObject.optString("user_id");
                    c1361a.f22024c = optJSONObject.optString("nick_name");
                    c1361a.f22025d = optJSONObject.optLong("caller_time");
                    c1361a.f22026e = optJSONObject.optString("caller_content");
                    c1361a.f22027f = optJSONObject.optLong("thread_id");
                    c1361a.f22028g = optJSONObject.optString(MissonDetailsActivityConfig.THREAD_TITLE);
                    optJSONObject.optString("forum_name");
                    c1361a.f22029h = optJSONObject.optLong("post_id");
                    c1361a.f22030i = optJSONObject.optInt("msg_type");
                    c1361a.f22031j = optJSONObject.optInt("remind_count");
                }
                return c1361a;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (C1361a) invokeL.objValue;
    }
}
