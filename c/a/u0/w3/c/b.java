package c.a.u0.w3.c;

import android.text.TextUtils;
import com.baidu.tieba.stampmission.message.StampMissionHttpRequestMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public long f25020b;

    /* renamed from: c  reason: collision with root package name */
    public String f25021c;

    /* renamed from: d  reason: collision with root package name */
    public String f25022d;

    /* renamed from: e  reason: collision with root package name */
    public int f25023e;

    /* renamed from: f  reason: collision with root package name */
    public int f25024f;

    /* renamed from: g  reason: collision with root package name */
    public int f25025g;

    /* renamed from: h  reason: collision with root package name */
    public C1512b f25026h;

    /* renamed from: i  reason: collision with root package name */
    public String f25027i;

    /* loaded from: classes9.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f25028b;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                aVar.f25028b = jSONObject.optString("pic");
                return aVar;
            }
            return (a) invokeL.objValue;
        }
    }

    /* renamed from: c.a.u0.w3.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C1512b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public a a;

        /* renamed from: b  reason: collision with root package name */
        public a f25029b;

        /* renamed from: c  reason: collision with root package name */
        public a f25030c;

        public C1512b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static C1512b a(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
                if (jSONObject == null) {
                    return null;
                }
                C1512b c1512b = new C1512b();
                c1512b.a = a.a(jSONObject.optJSONObject("follow_icon"));
                c1512b.f25029b = a.a(jSONObject.optJSONObject("like_icon"));
                c1512b.f25030c = a.a(jSONObject.optJSONObject("reply_icon"));
                return c1512b;
            }
            return (C1512b) invokeL.objValue;
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            bVar.f25020b = jSONObject.optLong("invalid_time", 0L);
            bVar.f25023e = jSONObject.optInt(StampMissionHttpRequestMessage.TASK_FOLLOW, 0);
            bVar.f25024f = jSONObject.optInt(StampMissionHttpRequestMessage.TASK_LIKE, 0);
            bVar.f25025g = jSONObject.optInt(StampMissionHttpRequestMessage.TASK_REPLY, 0);
            bVar.f25021c = jSONObject.optString("type");
            bVar.f25022d = jSONObject.optString(StampMissionHttpRequestMessage.KEY_TASK_TYPE);
            bVar.f25026h = C1512b.a(jSONObject.optJSONObject("icon_info"));
            bVar.f25027i = jSONObject.toString();
            return bVar;
        }
        return (b) invokeL.objValue;
    }
}
