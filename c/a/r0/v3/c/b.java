package c.a.r0.v3.c;

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
    public long f24298b;

    /* renamed from: c  reason: collision with root package name */
    public String f24299c;

    /* renamed from: d  reason: collision with root package name */
    public String f24300d;

    /* renamed from: e  reason: collision with root package name */
    public int f24301e;

    /* renamed from: f  reason: collision with root package name */
    public int f24302f;

    /* renamed from: g  reason: collision with root package name */
    public int f24303g;

    /* renamed from: h  reason: collision with root package name */
    public C1494b f24304h;

    /* renamed from: i  reason: collision with root package name */
    public String f24305i;

    /* loaded from: classes3.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f24306b;

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
                aVar.f24306b = jSONObject.optString("pic");
                return aVar;
            }
            return (a) invokeL.objValue;
        }
    }

    /* renamed from: c.a.r0.v3.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1494b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public a a;

        /* renamed from: b  reason: collision with root package name */
        public a f24307b;

        /* renamed from: c  reason: collision with root package name */
        public a f24308c;

        public C1494b() {
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

        public static C1494b a(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
                if (jSONObject == null) {
                    return null;
                }
                C1494b c1494b = new C1494b();
                c1494b.a = a.a(jSONObject.optJSONObject("follow_icon"));
                c1494b.f24307b = a.a(jSONObject.optJSONObject("like_icon"));
                c1494b.f24308c = a.a(jSONObject.optJSONObject("reply_icon"));
                return c1494b;
            }
            return (C1494b) invokeL.objValue;
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
            bVar.f24298b = jSONObject.optLong("invalid_time", 0L);
            bVar.f24301e = jSONObject.optInt(StampMissionHttpRequestMessage.TASK_FOLLOW, 0);
            bVar.f24302f = jSONObject.optInt(StampMissionHttpRequestMessage.TASK_LIKE, 0);
            bVar.f24303g = jSONObject.optInt(StampMissionHttpRequestMessage.TASK_REPLY, 0);
            bVar.f24299c = jSONObject.optString("type");
            bVar.f24300d = jSONObject.optString(StampMissionHttpRequestMessage.KEY_TASK_TYPE);
            bVar.f24304h = C1494b.a(jSONObject.optJSONObject("icon_info"));
            bVar.f24305i = jSONObject.toString();
            return bVar;
        }
        return (b) invokeL.objValue;
    }
}
