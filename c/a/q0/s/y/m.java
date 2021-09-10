package c.a.q0.s.y;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sina.weibo.sdk.constant.WBConstants;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class m {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final AtomicLong f14551i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f14552a;

    /* renamed from: b  reason: collision with root package name */
    public final String f14553b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, Object> f14554c;

    /* renamed from: d  reason: collision with root package name */
    public final Map<String, Object> f14555d;

    /* renamed from: e  reason: collision with root package name */
    public final int f14556e;

    /* renamed from: f  reason: collision with root package name */
    public final String f14557f;

    /* renamed from: g  reason: collision with root package name */
    public final long f14558g;

    /* renamed from: h  reason: collision with root package name */
    public final long f14559h;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes3.dex */
    public static final class b extends m {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: j  reason: collision with root package name */
        public final k f14560j;

        public /* synthetic */ b(int i2, String str, String str2, Map map, Map map2, String str3, k kVar, long j2, a aVar) {
            this(i2, str, str2, map, map2, str3, kVar, j2);
        }

        @Override // c.a.q0.s.y.m
        public void g(int i2, Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, th) == null) {
                this.f14560j.b(i2, th);
            }
        }

        @Override // c.a.q0.s.y.m
        public void h(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
                this.f14560j.a(this, jSONObject);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(int i2, String str, String str2, Map<String, Object> map, Map<String, Object> map2, String str3, k kVar, long j2) {
            super(i2, str, str2, map, map2, str3, j2, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), str, str2, map, map2, str3, kVar, Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), (String) objArr2[1], (String) objArr2[2], (Map) objArr2[3], (Map) objArr2[4], (String) objArr2[5], ((Long) objArr2[6]).longValue(), (a) objArr2[7]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14560j = kVar;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1644291178, "Lc/a/q0/s/y/m;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1644291178, "Lc/a/q0/s/y/m;");
                return;
            }
        }
        f14551i = new AtomicLong((System.currentTimeMillis() / 1000) * 1000);
    }

    public /* synthetic */ m(int i2, String str, String str2, Map map, Map map2, String str3, long j2, a aVar) {
        this(i2, str, str2, map, map2, str3, j2);
    }

    public static m a(int i2, String str, String str2, Map<String, Object> map, long j2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i2), str, str2, map, Long.valueOf(j2), Boolean.valueOf(z)})) == null) {
            return new m(i2, str, str2, map, null, z ? d() : null, j2);
        }
        return (m) invokeCommon.objValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            long andIncrement = f14551i.getAndIncrement();
            return "TBCWebViewJsBridge_callback_ID_" + andIncrement;
        }
        return (String) invokeV.objValue;
    }

    public static m i(Map<String, Object> map, long j2, k kVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{map, Long.valueOf(j2), kVar})) == null) ? new b(1, null, null, map, null, d(), kVar, j2, null) : (m) invokeCommon.objValue;
    }

    public static m j(String str, String str2, Map<String, Object> map, long j2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{str, str2, map, Long.valueOf(j2), Boolean.valueOf(z)})) == null) ? a(2, str, str2, map, j2, z) : (m) invokeCommon.objValue;
    }

    public static m k(String str, Map<String, Object> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, str, map)) == null) ? new m(3, null, null, null, map, str, -1L) : (m) invokeLL.objValue;
    }

    public String b() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(this.f14552a)) {
                jSONObject.put("cmd", this.f14552a);
            }
            if (!TextUtils.isEmpty(this.f14553b)) {
                jSONObject.put("method", this.f14553b);
            }
            Map<String, Object> map = this.f14554c;
            if (map != null && !map.isEmpty()) {
                JSONObject jSONObject2 = new JSONObject();
                e(this.f14554c, jSONObject2);
                jSONObject.put("inputData", jSONObject2);
            }
            Map<String, Object> map2 = this.f14555d;
            if (map2 != null && !map2.isEmpty()) {
                JSONObject jSONObject3 = new JSONObject();
                e(this.f14555d, jSONObject3);
                jSONObject.put("outputData", jSONObject3);
            }
            jSONObject.put("messageType", f());
            if (!TextUtils.isEmpty(this.f14557f)) {
                jSONObject.put(WBConstants.SHARE_CALLBACK_ID, this.f14557f);
            }
            return c(jSONObject.toString());
        }
        return (String) invokeV.objValue;
    }

    public final String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            String replace = str.replace(IStringUtil.WINDOWS_FOLDER_SEPARATOR, "\\\\").replace("\"", "\\\"").replace("'", "\\'").replace(StringUtils.LF, "\\n").replace(StringUtils.CR, "\\r").replace("\f", "\\f").replace("\u2028", "\\u2028").replace("\u2029", "\\u2029");
            return "javascript:__tb_js_bridge.send('" + replace + "');";
        }
        return (String) invokeL.objValue;
    }

    public final void e(Map<String, Object> map, JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, map, jSONObject) == null) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
        }
    }

    public final String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int i2 = this.f14556e;
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 == 3) {
                        return "response";
                    }
                    throw new IllegalArgumentException("Unsupported request type");
                }
                return "request";
            }
            return "ping";
        }
        return (String) invokeV.objValue;
    }

    public void g(int i2, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048580, this, i2, th) == null) {
        }
    }

    public void h(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jSONObject) == null) {
        }
    }

    public m(int i2, String str, String str2, Map<String, Object> map, Map<String, Object> map2, String str3, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), str, str2, map, map2, str3, Long.valueOf(j2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f14552a = str;
        this.f14553b = str2;
        this.f14554c = map;
        this.f14555d = map2;
        this.f14556e = i2;
        this.f14557f = str3;
        this.f14558g = j2;
        this.f14559h = System.currentTimeMillis();
    }
}
