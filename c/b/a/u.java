package c.b.a;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class u extends p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int m;
    public String n;
    public boolean o;
    public volatile boolean p;

    public u() {
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

    @Override // c.b.a.p
    @NonNull
    public p a(@NonNull Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cursor)) == null) {
            this.f31391e = cursor.getLong(0);
            this.f31392f = cursor.getLong(1);
            this.f31393g = cursor.getString(2);
            this.n = cursor.getString(3);
            this.m = cursor.getInt(4);
            this.f31395i = cursor.getString(5);
            this.f31396j = cursor.getString(6);
            return this;
        }
        return (p) invokeL.objValue;
    }

    @Override // c.b.a.p
    public void e(@NonNull ContentValues contentValues) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, contentValues) == null) {
            contentValues.put("local_time_ms", Long.valueOf(this.f31391e));
            contentValues.put("tea_event_index", Long.valueOf(this.f31392f));
            contentValues.put("session_id", this.f31393g);
            contentValues.put("ver_name", this.n);
            contentValues.put("ver_code", Integer.valueOf(this.m));
            contentValues.put("ab_version", this.f31395i);
            contentValues.put("ab_sdk_version", this.f31396j);
        }
    }

    @Override // c.b.a.p
    public void f(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
            jSONObject.put("local_time_ms", this.f31391e);
            jSONObject.put("tea_event_index", this.f31392f);
            jSONObject.put("session_id", this.f31393g);
            jSONObject.put("ab_version", this.f31395i);
            jSONObject.put("ab_sdk_version", this.f31396j);
        }
    }

    @Override // c.b.a.p
    public String[] g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new String[]{"local_time_ms", "integer", "tea_event_index", "integer", "session_id", "varchar", "ver_name", "varchar", "ver_code", "integer", "ab_version", "varchar", "ab_sdk_version", "varchar"} : (String[]) invokeV.objValue;
    }

    @Override // c.b.a.p
    public p i(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, jSONObject)) == null) {
            this.f31391e = jSONObject.optLong("local_time_ms", 0L);
            this.f31392f = jSONObject.optLong("tea_event_index", 0L);
            this.f31393g = jSONObject.optString("session_id", null);
            this.f31395i = jSONObject.optString("ab_version", null);
            this.f31396j = jSONObject.optString("ab_sdk_version", null);
            return this;
        }
        return (p) invokeL.objValue;
    }

    @Override // c.b.a.p
    public JSONObject j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("local_time_ms", this.f31391e);
            jSONObject.put("tea_event_index", this.f31392f);
            jSONObject.put("session_id", this.f31393g);
            boolean z = this.o;
            if (z) {
                jSONObject.put("is_background", z);
            }
            jSONObject.put("datetime", this.k);
            if (!TextUtils.isEmpty(this.f31395i)) {
                jSONObject.put("ab_version", this.f31395i);
            }
            if (!TextUtils.isEmpty(this.f31396j)) {
                jSONObject.put("ab_sdk_version", this.f31396j);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? "launch" : (String) invokeV.objValue;
    }
}
