package c.a.t0.t1.f.k;

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

    /* renamed from: c.a.t0.t1.f.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C1373a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f22302b;

        /* renamed from: c  reason: collision with root package name */
        public String f22303c;

        /* renamed from: d  reason: collision with root package name */
        public long f22304d;

        /* renamed from: e  reason: collision with root package name */
        public String f22305e;

        /* renamed from: f  reason: collision with root package name */
        public long f22306f;

        /* renamed from: g  reason: collision with root package name */
        public String f22307g;

        /* renamed from: h  reason: collision with root package name */
        public long f22308h;

        /* renamed from: i  reason: collision with root package name */
        public int f22309i;

        /* renamed from: j  reason: collision with root package name */
        public int f22310j;

        public C1373a() {
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
            this.f22302b = null;
            this.f22303c = null;
            this.f22306f = 0L;
            this.f22307g = null;
            this.f22308h = 0L;
            this.f22309i = 0;
            this.f22310j = 0;
        }
    }

    public static C1373a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            C1373a c1373a = new C1373a();
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() > 0) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(0);
                    c1373a.a = optJSONObject.optString(TableDefine.UserInfoColumns.COLUMN_HEAD_URL);
                    c1373a.f22302b = optJSONObject.optString("user_id");
                    c1373a.f22303c = optJSONObject.optString("nick_name");
                    c1373a.f22304d = optJSONObject.optLong("caller_time");
                    c1373a.f22305e = optJSONObject.optString("caller_content");
                    c1373a.f22306f = optJSONObject.optLong("thread_id");
                    c1373a.f22307g = optJSONObject.optString(MissonDetailsActivityConfig.THREAD_TITLE);
                    optJSONObject.optString("forum_name");
                    c1373a.f22308h = optJSONObject.optLong("post_id");
                    c1373a.f22309i = optJSONObject.optInt("msg_type");
                    c1373a.f22310j = optJSONObject.optInt("remind_count");
                }
                return c1373a;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (C1373a) invokeL.objValue;
    }
}
