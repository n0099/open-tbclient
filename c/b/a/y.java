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
public class y extends p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long m;
    public long n;

    public y() {
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
            h0.b(null);
            return this;
        }
        return (p) invokeL.objValue;
    }

    @Override // c.b.a.p
    public void e(@NonNull ContentValues contentValues) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, contentValues) == null) {
            h0.b(null);
        }
    }

    @Override // c.b.a.p
    public void f(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
            h0.b(null);
        }
    }

    @Override // c.b.a.p
    public String[] g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (String[]) invokeV.objValue;
    }

    @Override // c.b.a.p
    public p i(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, jSONObject)) == null) {
            h0.b(null);
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
            jSONObject.put("local_time_ms", this.f31416e);
            jSONObject.put("tea_event_index", this.f31417f);
            jSONObject.put("session_id", this.f31418g);
            jSONObject.put("stop_timestamp", this.n);
            jSONObject.put("duration", this.m / 1000);
            jSONObject.put("datetime", this.k);
            if (!TextUtils.isEmpty(this.f31420i)) {
                jSONObject.put("ab_version", this.f31420i);
            }
            if (!TextUtils.isEmpty(this.f31421j)) {
                jSONObject.put("ab_sdk_version", this.f31421j);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? "terminate" : (String) invokeV.objValue;
    }

    @Override // c.b.a.p
    public String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return super.p() + " duration:" + this.m;
        }
        return (String) invokeV.objValue;
    }
}
