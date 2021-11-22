package b.a.r0.l1.f.k;

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
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b.a.r0.l1.f.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1064a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f21614a;

        /* renamed from: b  reason: collision with root package name */
        public String f21615b;

        /* renamed from: c  reason: collision with root package name */
        public String f21616c;

        /* renamed from: d  reason: collision with root package name */
        public long f21617d;

        /* renamed from: e  reason: collision with root package name */
        public String f21618e;

        /* renamed from: f  reason: collision with root package name */
        public long f21619f;

        /* renamed from: g  reason: collision with root package name */
        public String f21620g;

        /* renamed from: h  reason: collision with root package name */
        public long f21621h;

        /* renamed from: i  reason: collision with root package name */
        public int f21622i;
        public int j;

        public C1064a() {
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
            this.f21614a = null;
            this.f21615b = null;
            this.f21616c = null;
            this.f21619f = 0L;
            this.f21620g = null;
            this.f21621h = 0L;
            this.f21622i = 0;
            this.j = 0;
        }
    }

    public static C1064a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            C1064a c1064a = new C1064a();
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() > 0) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(0);
                    c1064a.f21614a = optJSONObject.optString(TableDefine.UserInfoColumns.COLUMN_HEAD_URL);
                    c1064a.f21615b = optJSONObject.optString("user_id");
                    c1064a.f21616c = optJSONObject.optString("nick_name");
                    c1064a.f21617d = optJSONObject.optLong("caller_time");
                    c1064a.f21618e = optJSONObject.optString("caller_content");
                    c1064a.f21619f = optJSONObject.optLong("thread_id");
                    c1064a.f21620g = optJSONObject.optString(MissonDetailsActivityConfig.THREAD_TITLE);
                    optJSONObject.optString("forum_name");
                    c1064a.f21621h = optJSONObject.optLong("post_id");
                    c1064a.f21622i = optJSONObject.optInt("msg_type");
                    c1064a.j = optJSONObject.optInt("remind_count");
                }
                return c1064a;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (C1064a) invokeL.objValue;
    }
}
