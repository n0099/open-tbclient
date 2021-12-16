package c.a.s0.s1.f.k;

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

    /* renamed from: c.a.s0.s1.f.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C1318a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f22132b;

        /* renamed from: c  reason: collision with root package name */
        public String f22133c;

        /* renamed from: d  reason: collision with root package name */
        public long f22134d;

        /* renamed from: e  reason: collision with root package name */
        public String f22135e;

        /* renamed from: f  reason: collision with root package name */
        public long f22136f;

        /* renamed from: g  reason: collision with root package name */
        public String f22137g;

        /* renamed from: h  reason: collision with root package name */
        public long f22138h;

        /* renamed from: i  reason: collision with root package name */
        public int f22139i;

        /* renamed from: j  reason: collision with root package name */
        public int f22140j;

        public C1318a() {
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
            this.f22132b = null;
            this.f22133c = null;
            this.f22136f = 0L;
            this.f22137g = null;
            this.f22138h = 0L;
            this.f22139i = 0;
            this.f22140j = 0;
        }
    }

    public static C1318a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            C1318a c1318a = new C1318a();
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() > 0) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(0);
                    c1318a.a = optJSONObject.optString(TableDefine.UserInfoColumns.COLUMN_HEAD_URL);
                    c1318a.f22132b = optJSONObject.optString("user_id");
                    c1318a.f22133c = optJSONObject.optString("nick_name");
                    c1318a.f22134d = optJSONObject.optLong("caller_time");
                    c1318a.f22135e = optJSONObject.optString("caller_content");
                    c1318a.f22136f = optJSONObject.optLong("thread_id");
                    c1318a.f22137g = optJSONObject.optString(MissonDetailsActivityConfig.THREAD_TITLE);
                    optJSONObject.optString("forum_name");
                    c1318a.f22138h = optJSONObject.optLong("post_id");
                    c1318a.f22139i = optJSONObject.optInt("msg_type");
                    c1318a.f22140j = optJSONObject.optInt("remind_count");
                }
                return c1318a;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (C1318a) invokeL.objValue;
    }
}
