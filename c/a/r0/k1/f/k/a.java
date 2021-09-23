package c.a.r0.k1.f.k;

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

    /* renamed from: c.a.r0.k1.f.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0993a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f21321a;

        /* renamed from: b  reason: collision with root package name */
        public String f21322b;

        /* renamed from: c  reason: collision with root package name */
        public String f21323c;

        /* renamed from: d  reason: collision with root package name */
        public long f21324d;

        /* renamed from: e  reason: collision with root package name */
        public String f21325e;

        /* renamed from: f  reason: collision with root package name */
        public long f21326f;

        /* renamed from: g  reason: collision with root package name */
        public String f21327g;

        /* renamed from: h  reason: collision with root package name */
        public long f21328h;

        /* renamed from: i  reason: collision with root package name */
        public int f21329i;

        /* renamed from: j  reason: collision with root package name */
        public int f21330j;

        public C0993a() {
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
            this.f21321a = null;
            this.f21322b = null;
            this.f21323c = null;
            this.f21326f = 0L;
            this.f21327g = null;
            this.f21328h = 0L;
            this.f21329i = 0;
            this.f21330j = 0;
        }
    }

    public static C0993a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            C0993a c0993a = new C0993a();
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() > 0) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(0);
                    c0993a.f21321a = optJSONObject.optString(TableDefine.UserInfoColumns.COLUMN_HEAD_URL);
                    c0993a.f21322b = optJSONObject.optString("user_id");
                    c0993a.f21323c = optJSONObject.optString("nick_name");
                    c0993a.f21324d = optJSONObject.optLong("caller_time");
                    c0993a.f21325e = optJSONObject.optString("caller_content");
                    c0993a.f21326f = optJSONObject.optLong("thread_id");
                    c0993a.f21327g = optJSONObject.optString(MissonDetailsActivityConfig.THREAD_TITLE);
                    optJSONObject.optString("forum_name");
                    c0993a.f21328h = optJSONObject.optLong("post_id");
                    c0993a.f21329i = optJSONObject.optInt("msg_type");
                    c0993a.f21330j = optJSONObject.optInt("remind_count");
                }
                return c0993a;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (C0993a) invokeL.objValue;
    }
}
