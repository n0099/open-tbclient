package c.a.q0.j1.f.k;

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

    /* renamed from: c.a.q0.j1.f.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0962a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f20737a;

        /* renamed from: b  reason: collision with root package name */
        public String f20738b;

        /* renamed from: c  reason: collision with root package name */
        public String f20739c;

        /* renamed from: d  reason: collision with root package name */
        public long f20740d;

        /* renamed from: e  reason: collision with root package name */
        public String f20741e;

        /* renamed from: f  reason: collision with root package name */
        public long f20742f;

        /* renamed from: g  reason: collision with root package name */
        public String f20743g;

        /* renamed from: h  reason: collision with root package name */
        public long f20744h;

        /* renamed from: i  reason: collision with root package name */
        public int f20745i;

        /* renamed from: j  reason: collision with root package name */
        public int f20746j;

        public C0962a() {
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
            this.f20737a = null;
            this.f20738b = null;
            this.f20739c = null;
            this.f20742f = 0L;
            this.f20743g = null;
            this.f20744h = 0L;
            this.f20745i = 0;
            this.f20746j = 0;
        }
    }

    public static C0962a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            C0962a c0962a = new C0962a();
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() > 0) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(0);
                    c0962a.f20737a = optJSONObject.optString(TableDefine.UserInfoColumns.COLUMN_HEAD_URL);
                    c0962a.f20738b = optJSONObject.optString("user_id");
                    c0962a.f20739c = optJSONObject.optString("nick_name");
                    c0962a.f20740d = optJSONObject.optLong("caller_time");
                    c0962a.f20741e = optJSONObject.optString("caller_content");
                    c0962a.f20742f = optJSONObject.optLong("thread_id");
                    c0962a.f20743g = optJSONObject.optString(MissonDetailsActivityConfig.THREAD_TITLE);
                    optJSONObject.optString("forum_name");
                    c0962a.f20744h = optJSONObject.optLong("post_id");
                    c0962a.f20745i = optJSONObject.optInt("msg_type");
                    c0962a.f20746j = optJSONObject.optInt("remind_count");
                }
                return c0962a;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (C0962a) invokeL.objValue;
    }
}
