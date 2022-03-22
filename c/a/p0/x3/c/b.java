package c.a.p0.x3.c;

import android.text.TextUtils;
import com.baidu.tieba.stampmission.message.StampMissionHttpRequestMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public long f20704b;

    /* renamed from: c  reason: collision with root package name */
    public String f20705c;

    /* renamed from: d  reason: collision with root package name */
    public String f20706d;

    /* renamed from: e  reason: collision with root package name */
    public int f20707e;

    /* renamed from: f  reason: collision with root package name */
    public int f20708f;

    /* renamed from: g  reason: collision with root package name */
    public int f20709g;

    /* renamed from: h  reason: collision with root package name */
    public C1548b f20710h;
    public String i;

    /* loaded from: classes3.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f20711b;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static a a(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
                if (jSONObject == null) {
                    return null;
                }
                a aVar = new a();
                aVar.a = jSONObject.optString("name");
                jSONObject.optString("title");
                aVar.f20711b = jSONObject.optString("pic");
                return aVar;
            }
            return (a) invokeL.objValue;
        }
    }

    /* renamed from: c.a.p0.x3.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1548b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public a a;

        /* renamed from: b  reason: collision with root package name */
        public a f20712b;

        /* renamed from: c  reason: collision with root package name */
        public a f20713c;

        public C1548b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static C1548b a(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
                if (jSONObject == null) {
                    return null;
                }
                C1548b c1548b = new C1548b();
                c1548b.a = a.a(jSONObject.optJSONObject("follow_icon"));
                c1548b.f20712b = a.a(jSONObject.optJSONObject("like_icon"));
                c1548b.f20713c = a.a(jSONObject.optJSONObject("reply_icon"));
                return c1548b;
            }
            return (C1548b) invokeL.objValue;
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static b a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                return b(new JSONObject(str));
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (b) invokeL.objValue;
    }

    public static b b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            b bVar = new b();
            bVar.a = jSONObject.optLong("effect_time", 0L);
            bVar.f20704b = jSONObject.optLong("invalid_time", 0L);
            bVar.f20707e = jSONObject.optInt(StampMissionHttpRequestMessage.TASK_FOLLOW, 0);
            bVar.f20708f = jSONObject.optInt(StampMissionHttpRequestMessage.TASK_LIKE, 0);
            bVar.f20709g = jSONObject.optInt(StampMissionHttpRequestMessage.TASK_REPLY, 0);
            bVar.f20705c = jSONObject.optString("type");
            bVar.f20706d = jSONObject.optString(StampMissionHttpRequestMessage.KEY_TASK_TYPE);
            bVar.f20710h = C1548b.a(jSONObject.optJSONObject("icon_info"));
            bVar.i = jSONObject.toString();
            return bVar;
        }
        return (b) invokeL.objValue;
    }
}
