package c.b.a;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class t extends p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String m;
    public boolean n;
    public String o;

    public t(String str, boolean z, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Boolean.valueOf(z), str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = str;
        this.n = z;
        this.m = str2;
    }

    @Override // c.b.a.p
    @NonNull
    public p a(@NonNull Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cursor)) == null) {
            this.f31412e = cursor.getLong(0);
            this.f31413f = cursor.getLong(1);
            this.f31414g = cursor.getString(2);
            this.f31415h = cursor.getString(3);
            this.o = cursor.getString(4);
            this.m = cursor.getString(5);
            this.n = cursor.getInt(6) == 1;
            this.f31416i = cursor.getString(7);
            this.f31417j = cursor.getString(8);
            return this;
        }
        return (p) invokeL.objValue;
    }

    @Override // c.b.a.p
    public void e(@NonNull ContentValues contentValues) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, contentValues) == null) {
            contentValues.put("local_time_ms", Long.valueOf(this.f31412e));
            contentValues.put("tea_event_index", Long.valueOf(this.f31413f));
            contentValues.put("session_id", this.f31414g);
            contentValues.put("user_unique_id", this.f31415h);
            contentValues.put("event", this.o);
            if (this.n && this.m == null) {
                try {
                    q();
                } catch (JSONException e2) {
                    h0.b(e2);
                }
            }
            contentValues.put("params", this.m);
            contentValues.put("is_bav", Integer.valueOf(this.n ? 1 : 0));
            contentValues.put("ab_version", this.f31416i);
            contentValues.put("ab_sdk_version", this.f31417j);
        }
    }

    @Override // c.b.a.p
    public void f(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
            jSONObject.put("local_time_ms", this.f31412e);
            jSONObject.put("tea_event_index", this.f31413f);
            jSONObject.put("session_id", this.f31414g);
            jSONObject.put("user_unique_id", this.f31415h);
            jSONObject.put("event", this.o);
            if (this.n && this.m == null) {
                q();
            }
            jSONObject.put("params", this.m);
            jSONObject.put("is_bav", this.n);
            jSONObject.put("ab_version", this.f31416i);
            jSONObject.put("ab_sdk_version", this.f31417j);
        }
    }

    @Override // c.b.a.p
    public String[] g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new String[]{"local_time_ms", "integer", "tea_event_index", "integer", "session_id", "varchar", "user_unique_id", "varchar", "event", "varchar", "params", "varchar", "is_bav", "integer", "ab_version", "varchar", "ab_sdk_version", "varchar"} : (String[]) invokeV.objValue;
    }

    @Override // c.b.a.p
    public p i(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, jSONObject)) == null) {
            this.f31412e = jSONObject.optLong("local_time_ms", 0L);
            this.f31413f = jSONObject.optLong("tea_event_index", 0L);
            this.f31414g = jSONObject.optString("session_id", null);
            this.f31415h = jSONObject.optString("user_unique_id", null);
            this.o = jSONObject.optString("event", null);
            this.m = jSONObject.optString("params", null);
            this.n = jSONObject.optBoolean("is_bav", false);
            this.f31416i = jSONObject.optString("ab_version", null);
            this.f31417j = jSONObject.optString("ab_sdk_version", null);
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
            jSONObject.put("local_time_ms", this.f31412e);
            jSONObject.put("tea_event_index", this.f31413f);
            jSONObject.put("session_id", this.f31414g);
            if (!TextUtils.isEmpty(this.f31415h)) {
                jSONObject.put("user_unique_id", this.f31415h);
            }
            jSONObject.put("event", this.o);
            if (this.n) {
                jSONObject.put("is_bav", 1);
            }
            if (!TextUtils.isEmpty(this.m)) {
                jSONObject.put("params", new JSONObject(this.m));
            }
            jSONObject.put("datetime", this.k);
            if (!TextUtils.isEmpty(this.f31416i)) {
                jSONObject.put("ab_version", this.f31416i);
            }
            if (!TextUtils.isEmpty(this.f31417j)) {
                jSONObject.put("ab_sdk_version", this.f31417j);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? "eventv3" : (String) invokeV.objValue;
    }

    @Override // c.b.a.p
    public String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.o : (String) invokeV.objValue;
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    public String r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.o : (String) invokeV.objValue;
    }
}
