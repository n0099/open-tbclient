package c.b.a;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompatJellybean;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class r extends p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String m;
    public String n;
    public String o;
    public String p;
    public long q;
    public long r;

    public r(String str, String str2, String str3, long j2, long j3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3, Long.valueOf(j2), Long.valueOf(j3), str4};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.m = str;
        this.n = str2;
        this.o = str3;
        this.q = j2;
        this.r = j3;
        this.p = str4;
    }

    @Override // c.b.a.p
    @NonNull
    public p a(@NonNull Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cursor)) == null) {
            this.f31176e = cursor.getLong(0);
            this.f31177f = cursor.getLong(1);
            this.f31178g = cursor.getString(2);
            this.f31179h = cursor.getString(3);
            this.m = cursor.getString(4);
            this.n = cursor.getString(5);
            this.q = cursor.getInt(6);
            this.r = cursor.getInt(7);
            this.p = cursor.getString(8);
            this.o = cursor.getString(9);
            this.f31180i = cursor.getString(10);
            this.f31181j = cursor.getString(11);
            return this;
        }
        return (p) invokeL.objValue;
    }

    @Override // c.b.a.p
    public void e(@NonNull ContentValues contentValues) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, contentValues) == null) {
            contentValues.put("local_time_ms", Long.valueOf(this.f31176e));
            contentValues.put("tea_event_index", Long.valueOf(this.f31177f));
            contentValues.put("session_id", this.f31178g);
            contentValues.put("user_unique_id", this.f31179h);
            contentValues.put("category", this.m);
            contentValues.put("tag", this.n);
            contentValues.put("value", Long.valueOf(this.q));
            contentValues.put("ext_value", Long.valueOf(this.r));
            contentValues.put("params", this.p);
            contentValues.put(NotificationCompatJellybean.KEY_LABEL, this.o);
            contentValues.put("ab_version", this.f31180i);
            contentValues.put("ab_sdk_version", this.f31181j);
        }
    }

    @Override // c.b.a.p
    public void f(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
            jSONObject.put("local_time_ms", this.f31176e);
            jSONObject.put("tea_event_index", this.f31177f);
            jSONObject.put("session_id", this.f31178g);
            jSONObject.put("user_unique_id", this.f31179h);
            jSONObject.put("category", this.m);
            jSONObject.put("tag", this.n);
            jSONObject.put("value", this.q);
            jSONObject.put("ext_value", this.r);
            jSONObject.put("params", this.p);
            jSONObject.put(NotificationCompatJellybean.KEY_LABEL, this.o);
            jSONObject.put("ab_version", this.f31180i);
            jSONObject.put("ab_sdk_version", this.f31181j);
        }
    }

    @Override // c.b.a.p
    public String[] g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new String[]{"local_time_ms", "integer", "tea_event_index", "integer", "session_id", "varchar", "user_unique_id", "varchar", "category", "varchar", "tag", "varchar", "value", "integer", "ext_value", "integer", "params", "varchar", NotificationCompatJellybean.KEY_LABEL, "varchar", "ab_version", "varchar", "ab_sdk_version", "varchar"} : (String[]) invokeV.objValue;
    }

    @Override // c.b.a.p
    public p i(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, jSONObject)) == null) {
            this.f31176e = jSONObject.optLong("local_time_ms", 0L);
            this.f31177f = jSONObject.optLong("tea_event_index", 0L);
            this.f31178g = jSONObject.optString("session_id", null);
            this.f31179h = jSONObject.optString("user_unique_id", null);
            this.m = jSONObject.optString("category", null);
            this.n = jSONObject.optString("tag", null);
            this.q = jSONObject.optLong("value", 0L);
            this.r = jSONObject.optLong("ext_value", 0L);
            this.p = jSONObject.optString("params", null);
            this.o = jSONObject.optString(NotificationCompatJellybean.KEY_LABEL, null);
            this.f31180i = jSONObject.optString("ab_version", null);
            this.f31181j = jSONObject.optString("ab_sdk_version", null);
            return this;
        }
        return (p) invokeL.objValue;
    }

    @Override // c.b.a.p
    public JSONObject j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            JSONObject jSONObject = !TextUtils.isEmpty(this.p) ? new JSONObject(this.p) : null;
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            jSONObject.put("local_time_ms", this.f31176e);
            jSONObject.put("tea_event_index", this.f31177f);
            jSONObject.put("session_id", this.f31178g);
            if (!TextUtils.isEmpty(this.f31179h)) {
                jSONObject.put("user_unique_id", this.f31179h);
            }
            jSONObject.put("category", this.m);
            jSONObject.put("tag", this.n);
            jSONObject.put("value", this.q);
            jSONObject.put("ext_value", this.r);
            jSONObject.put(NotificationCompatJellybean.KEY_LABEL, this.o);
            jSONObject.put("datetime", this.k);
            if (!TextUtils.isEmpty(this.f31180i)) {
                jSONObject.put("ab_version", this.f31180i);
            }
            if (!TextUtils.isEmpty(this.f31181j)) {
                jSONObject.put("ab_sdk_version", this.f31181j);
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    @Override // c.b.a.p
    @NonNull
    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? "event" : (String) invokeV.objValue;
    }

    @Override // c.b.a.p
    public String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return "" + this.n + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.o;
        }
        return (String) invokeV.objValue;
    }

    public String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.n : (String) invokeV.objValue;
    }

    public String r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.o : (String) invokeV.objValue;
    }

    public r() {
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
}
