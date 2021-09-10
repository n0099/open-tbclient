package c.b.a;

import android.text.TextUtils;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class x0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f31442a;

    /* renamed from: b  reason: collision with root package name */
    public final String f31443b;

    /* renamed from: c  reason: collision with root package name */
    public final Boolean f31444c;

    /* renamed from: d  reason: collision with root package name */
    public final Long f31445d;

    /* renamed from: e  reason: collision with root package name */
    public final Long f31446e;

    /* renamed from: f  reason: collision with root package name */
    public final Integer f31447f;

    /* renamed from: g  reason: collision with root package name */
    public final Long f31448g;

    public x0(String str, String str2, Boolean bool, Long l, Long l2, Integer num, Long l3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, bool, l, l2, num, l3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f31442a = str;
        this.f31443b = str2;
        this.f31444c = bool;
        this.f31445d = l;
        this.f31446e = l2;
        this.f31447f = num;
        this.f31448g = l3;
    }

    @Nullable
    @AnyThread
    public static x0 a(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                return new x0(jSONObject.optString("id", null), jSONObject.optString(IAdRequestParam.REQ_ID, null), jSONObject.has("is_track_limited") ? Boolean.valueOf(jSONObject.optBoolean("is_track_limited")) : null, jSONObject.has("take_ms") ? Long.valueOf(jSONObject.optLong("take_ms", -1L)) : null, jSONObject.has("time") ? Long.valueOf(jSONObject.optLong("time", -1L)) : null, jSONObject.has("query_times") ? Integer.valueOf(jSONObject.optInt("query_times", -1)) : null, jSONObject.has("hw_id_version_code") ? Long.valueOf(jSONObject.optLong("hw_id_version_code", -1L)) : null);
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (x0) invokeL.objValue;
    }

    @NonNull
    public Map<String, String> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            HashMap hashMap = new HashMap();
            u0.h(hashMap, "id", this.f31442a);
            u0.h(hashMap, IAdRequestParam.REQ_ID, this.f31443b);
            u0.h(hashMap, "is_track_limited", String.valueOf(this.f31444c));
            u0.h(hashMap, "take_ms", String.valueOf(this.f31445d));
            u0.h(hashMap, "time", String.valueOf(this.f31446e));
            u0.h(hashMap, "query_times", String.valueOf(this.f31447f));
            u0.h(hashMap, "hw_id_version_code", String.valueOf(this.f31448g));
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }

    @NonNull
    public JSONObject c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            u0.i(jSONObject, "id", this.f31442a);
            u0.i(jSONObject, IAdRequestParam.REQ_ID, this.f31443b);
            u0.i(jSONObject, "is_track_limited", this.f31444c);
            u0.i(jSONObject, "take_ms", this.f31445d);
            u0.i(jSONObject, "time", this.f31446e);
            u0.i(jSONObject, "query_times", this.f31447f);
            u0.i(jSONObject, "hw_id_version_code", this.f31448g);
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? c().toString() : (String) invokeV.objValue;
    }
}
