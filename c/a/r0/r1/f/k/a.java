package c.a.r0.r1.f.k;

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
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.r0.r1.f.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C1319a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f22904b;

        /* renamed from: c  reason: collision with root package name */
        public String f22905c;

        /* renamed from: d  reason: collision with root package name */
        public long f22906d;

        /* renamed from: e  reason: collision with root package name */
        public String f22907e;

        /* renamed from: f  reason: collision with root package name */
        public long f22908f;

        /* renamed from: g  reason: collision with root package name */
        public String f22909g;

        /* renamed from: h  reason: collision with root package name */
        public long f22910h;

        /* renamed from: i  reason: collision with root package name */
        public int f22911i;

        /* renamed from: j  reason: collision with root package name */
        public int f22912j;

        public C1319a() {
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
            this.f22904b = null;
            this.f22905c = null;
            this.f22908f = 0L;
            this.f22909g = null;
            this.f22910h = 0L;
            this.f22911i = 0;
            this.f22912j = 0;
        }
    }

    public static C1319a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            C1319a c1319a = new C1319a();
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() > 0) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(0);
                    c1319a.a = optJSONObject.optString(TableDefine.UserInfoColumns.COLUMN_HEAD_URL);
                    c1319a.f22904b = optJSONObject.optString("user_id");
                    c1319a.f22905c = optJSONObject.optString("nick_name");
                    c1319a.f22906d = optJSONObject.optLong("caller_time");
                    c1319a.f22907e = optJSONObject.optString("caller_content");
                    c1319a.f22908f = optJSONObject.optLong("thread_id");
                    c1319a.f22909g = optJSONObject.optString(MissonDetailsActivityConfig.THREAD_TITLE);
                    optJSONObject.optString("forum_name");
                    c1319a.f22910h = optJSONObject.optLong("post_id");
                    c1319a.f22911i = optJSONObject.optInt("msg_type");
                    c1319a.f22912j = optJSONObject.optInt("remind_count");
                }
                return c1319a;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (C1319a) invokeL.objValue;
    }
}
