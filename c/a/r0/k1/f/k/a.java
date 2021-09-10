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
    public static class C0995a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f21307a;

        /* renamed from: b  reason: collision with root package name */
        public String f21308b;

        /* renamed from: c  reason: collision with root package name */
        public String f21309c;

        /* renamed from: d  reason: collision with root package name */
        public long f21310d;

        /* renamed from: e  reason: collision with root package name */
        public String f21311e;

        /* renamed from: f  reason: collision with root package name */
        public long f21312f;

        /* renamed from: g  reason: collision with root package name */
        public String f21313g;

        /* renamed from: h  reason: collision with root package name */
        public long f21314h;

        /* renamed from: i  reason: collision with root package name */
        public int f21315i;

        /* renamed from: j  reason: collision with root package name */
        public int f21316j;

        public C0995a() {
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
            this.f21307a = null;
            this.f21308b = null;
            this.f21309c = null;
            this.f21312f = 0L;
            this.f21313g = null;
            this.f21314h = 0L;
            this.f21315i = 0;
            this.f21316j = 0;
        }
    }

    public static C0995a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            C0995a c0995a = new C0995a();
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() > 0) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(0);
                    c0995a.f21307a = optJSONObject.optString(TableDefine.UserInfoColumns.COLUMN_HEAD_URL);
                    c0995a.f21308b = optJSONObject.optString("user_id");
                    c0995a.f21309c = optJSONObject.optString("nick_name");
                    c0995a.f21310d = optJSONObject.optLong("caller_time");
                    c0995a.f21311e = optJSONObject.optString("caller_content");
                    c0995a.f21312f = optJSONObject.optLong("thread_id");
                    c0995a.f21313g = optJSONObject.optString(MissonDetailsActivityConfig.THREAD_TITLE);
                    optJSONObject.optString("forum_name");
                    c0995a.f21314h = optJSONObject.optLong("post_id");
                    c0995a.f21315i = optJSONObject.optInt("msg_type");
                    c0995a.f21316j = optJSONObject.optInt("remind_count");
                }
                return c0995a;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (C0995a) invokeL.objValue;
    }
}
