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
    public static class C0996a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f20092a;

        /* renamed from: b  reason: collision with root package name */
        public String f20093b;

        /* renamed from: c  reason: collision with root package name */
        public String f20094c;

        /* renamed from: d  reason: collision with root package name */
        public long f20095d;

        /* renamed from: e  reason: collision with root package name */
        public String f20096e;

        /* renamed from: f  reason: collision with root package name */
        public long f20097f;

        /* renamed from: g  reason: collision with root package name */
        public String f20098g;

        /* renamed from: h  reason: collision with root package name */
        public long f20099h;

        /* renamed from: i  reason: collision with root package name */
        public int f20100i;
        public int j;

        public C0996a() {
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
            this.f20092a = null;
            this.f20093b = null;
            this.f20094c = null;
            this.f20097f = 0L;
            this.f20098g = null;
            this.f20099h = 0L;
            this.f20100i = 0;
            this.j = 0;
        }
    }

    public static C0996a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            C0996a c0996a = new C0996a();
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() > 0) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(0);
                    c0996a.f20092a = optJSONObject.optString(TableDefine.UserInfoColumns.COLUMN_HEAD_URL);
                    c0996a.f20093b = optJSONObject.optString("user_id");
                    c0996a.f20094c = optJSONObject.optString("nick_name");
                    c0996a.f20095d = optJSONObject.optLong("caller_time");
                    c0996a.f20096e = optJSONObject.optString("caller_content");
                    c0996a.f20097f = optJSONObject.optLong("thread_id");
                    c0996a.f20098g = optJSONObject.optString(MissonDetailsActivityConfig.THREAD_TITLE);
                    optJSONObject.optString("forum_name");
                    c0996a.f20099h = optJSONObject.optLong("post_id");
                    c0996a.f20100i = optJSONObject.optInt("msg_type");
                    c0996a.j = optJSONObject.optInt("remind_count");
                }
                return c0996a;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (C0996a) invokeL.objValue;
    }
}
