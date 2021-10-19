package c.a.r0.l1.f.k;

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
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.r0.l1.f.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1002a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f21501a;

        /* renamed from: b  reason: collision with root package name */
        public String f21502b;

        /* renamed from: c  reason: collision with root package name */
        public String f21503c;

        /* renamed from: d  reason: collision with root package name */
        public long f21504d;

        /* renamed from: e  reason: collision with root package name */
        public String f21505e;

        /* renamed from: f  reason: collision with root package name */
        public long f21506f;

        /* renamed from: g  reason: collision with root package name */
        public String f21507g;

        /* renamed from: h  reason: collision with root package name */
        public long f21508h;

        /* renamed from: i  reason: collision with root package name */
        public int f21509i;

        /* renamed from: j  reason: collision with root package name */
        public int f21510j;

        public C1002a() {
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
            this.f21501a = null;
            this.f21502b = null;
            this.f21503c = null;
            this.f21506f = 0L;
            this.f21507g = null;
            this.f21508h = 0L;
            this.f21509i = 0;
            this.f21510j = 0;
        }
    }

    public static C1002a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            C1002a c1002a = new C1002a();
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() > 0) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(0);
                    c1002a.f21501a = optJSONObject.optString(TableDefine.UserInfoColumns.COLUMN_HEAD_URL);
                    c1002a.f21502b = optJSONObject.optString("user_id");
                    c1002a.f21503c = optJSONObject.optString("nick_name");
                    c1002a.f21504d = optJSONObject.optLong("caller_time");
                    c1002a.f21505e = optJSONObject.optString("caller_content");
                    c1002a.f21506f = optJSONObject.optLong("thread_id");
                    c1002a.f21507g = optJSONObject.optString(MissonDetailsActivityConfig.THREAD_TITLE);
                    optJSONObject.optString("forum_name");
                    c1002a.f21508h = optJSONObject.optLong("post_id");
                    c1002a.f21509i = optJSONObject.optInt("msg_type");
                    c1002a.f21510j = optJSONObject.optInt("remind_count");
                }
                return c1002a;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (C1002a) invokeL.objValue;
    }
}
