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
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class s extends p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public String m;
    @NonNull
    public String n;

    public s(@NonNull String str, @NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, jSONObject};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = str;
        this.m = jSONObject.toString();
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
            contentValues.put("params", this.m);
            contentValues.put("log_type", this.n);
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
            jSONObject.put("params", this.m);
            jSONObject.put("log_type", this.n);
        }
    }

    @Override // c.b.a.p
    public String[] g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new String[]{"local_time_ms", "integer", "tea_event_index", "integer", "session_id", "varchar", "user_unique_id", "varchar", "params", "varchar", "log_type", "varchar"} : (String[]) invokeV.objValue;
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
            this.m = jSONObject.optString("params", null);
            this.n = jSONObject.optString("log_type", null);
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
            jSONObject.put("local_time_ms", this.f31176e);
            jSONObject.put("tea_event_index", this.f31177f);
            jSONObject.put("session_id", this.f31178g);
            if (!TextUtils.isEmpty(this.f31179h)) {
                jSONObject.put("user_unique_id", this.f31179h);
            }
            jSONObject.put("log_type", this.n);
            try {
                JSONObject jSONObject2 = new JSONObject(this.m);
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    Object obj = jSONObject2.get(next);
                    if (jSONObject.opt(next) != null) {
                        h0.c("misc事件存在重复的key", null);
                    }
                    jSONObject.put(next, obj);
                }
            } catch (Exception e2) {
                h0.d("解析 event misc 失败", e2);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? "event_misc" : (String) invokeV.objValue;
    }

    @Override // c.b.a.p
    public String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return "param:" + this.m + " logType:" + this.n;
        }
        return (String) invokeV.objValue;
    }
}
