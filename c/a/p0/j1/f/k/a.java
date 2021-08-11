package c.a.p0.j1.f.k;

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

    /* renamed from: c.a.p0.j1.f.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0951a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f20407a;

        /* renamed from: b  reason: collision with root package name */
        public String f20408b;

        /* renamed from: c  reason: collision with root package name */
        public String f20409c;

        /* renamed from: d  reason: collision with root package name */
        public long f20410d;

        /* renamed from: e  reason: collision with root package name */
        public String f20411e;

        /* renamed from: f  reason: collision with root package name */
        public long f20412f;

        /* renamed from: g  reason: collision with root package name */
        public String f20413g;

        /* renamed from: h  reason: collision with root package name */
        public long f20414h;

        /* renamed from: i  reason: collision with root package name */
        public int f20415i;

        /* renamed from: j  reason: collision with root package name */
        public int f20416j;

        public C0951a() {
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
            this.f20407a = null;
            this.f20408b = null;
            this.f20409c = null;
            this.f20412f = 0L;
            this.f20413g = null;
            this.f20414h = 0L;
            this.f20415i = 0;
            this.f20416j = 0;
        }
    }

    public static C0951a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            C0951a c0951a = new C0951a();
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() > 0) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(0);
                    c0951a.f20407a = optJSONObject.optString(TableDefine.UserInfoColumns.COLUMN_HEAD_URL);
                    c0951a.f20408b = optJSONObject.optString("user_id");
                    c0951a.f20409c = optJSONObject.optString("nick_name");
                    c0951a.f20410d = optJSONObject.optLong("caller_time");
                    c0951a.f20411e = optJSONObject.optString("caller_content");
                    c0951a.f20412f = optJSONObject.optLong("thread_id");
                    c0951a.f20413g = optJSONObject.optString(MissonDetailsActivityConfig.THREAD_TITLE);
                    optJSONObject.optString("forum_name");
                    c0951a.f20414h = optJSONObject.optLong("post_id");
                    c0951a.f20415i = optJSONObject.optInt("msg_type");
                    c0951a.f20416j = optJSONObject.optInt("remind_count");
                }
                return c0951a;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (C0951a) invokeL.objValue;
    }
}
