package c.a.p0.u1.f.k;

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

    /* renamed from: c.a.p0.u1.f.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1409a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f18738b;

        /* renamed from: c  reason: collision with root package name */
        public String f18739c;

        /* renamed from: d  reason: collision with root package name */
        public long f18740d;

        /* renamed from: e  reason: collision with root package name */
        public String f18741e;

        /* renamed from: f  reason: collision with root package name */
        public long f18742f;

        /* renamed from: g  reason: collision with root package name */
        public String f18743g;

        /* renamed from: h  reason: collision with root package name */
        public long f18744h;
        public int i;
        public int j;

        public C1409a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = null;
            this.f18738b = null;
            this.f18739c = null;
            this.f18742f = 0L;
            this.f18743g = null;
            this.f18744h = 0L;
            this.i = 0;
            this.j = 0;
        }
    }

    public static C1409a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            C1409a c1409a = new C1409a();
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() > 0) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(0);
                    c1409a.a = optJSONObject.optString(TableDefine.UserInfoColumns.COLUMN_HEAD_URL);
                    c1409a.f18738b = optJSONObject.optString("user_id");
                    c1409a.f18739c = optJSONObject.optString("nick_name");
                    c1409a.f18740d = optJSONObject.optLong("caller_time");
                    c1409a.f18741e = optJSONObject.optString("caller_content");
                    c1409a.f18742f = optJSONObject.optLong("thread_id");
                    c1409a.f18743g = optJSONObject.optString(MissonDetailsActivityConfig.THREAD_TITLE);
                    optJSONObject.optString("forum_name");
                    c1409a.f18744h = optJSONObject.optLong("post_id");
                    c1409a.i = optJSONObject.optInt("msg_type");
                    c1409a.j = optJSONObject.optInt("remind_count");
                }
                return c1409a;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (C1409a) invokeL.objValue;
    }
}
