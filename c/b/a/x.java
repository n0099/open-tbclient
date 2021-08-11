package c.b.a;

import android.content.ContentValues;
import android.database.Cursor;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.embedapplog.AppLog;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class x extends p {
    public static /* synthetic */ Interceptable $ic = null;
    public static String s = "succEvent";
    public transient /* synthetic */ FieldHolder $fh;
    public String m;
    public int n;
    public int o;
    public String p;
    public int q;
    public long r;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1868020682, "Lc/b/a/x;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1868020682, "Lc/b/a/x;");
        }
    }

    public x() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
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
            this.n = cursor.getInt(5);
            this.o = cursor.getInt(6);
            this.p = cursor.getString(7);
            this.q = cursor.getInt(8);
            this.r = cursor.getLong(9);
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
            contentValues.put("event_name", this.m);
            contentValues.put("is_monitor", Integer.valueOf(this.n));
            contentValues.put("bav_monitor_rate", Integer.valueOf(this.o));
            contentValues.put("monitor_status", this.p);
            contentValues.put("monitor_num", Integer.valueOf(this.q));
            contentValues.put("date", Long.valueOf(this.r));
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
            jSONObject.put("event_name", this.m);
            jSONObject.put("is_monitor", this.n);
            jSONObject.put("bav_monitor_rate", this.o);
            jSONObject.put("monitor_status", this.p);
            jSONObject.put("monitor_num", this.q);
            jSONObject.put("date", this.r);
        }
    }

    @Override // c.b.a.p
    public String[] g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new String[]{"local_time_ms", "integer", "tea_event_index", "integer", "session_id", "varchar", "user_unique_id", "varchar", "event_name", "varchar", "is_monitor", "integer", "bav_monitor_rate", "integer", "monitor_status", "varchar", "monitor_num", "integer", "date", "integer"} : (String[]) invokeV.objValue;
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
            this.m = jSONObject.optString("event_name", null);
            this.n = jSONObject.optInt("is_monitor", 0);
            this.o = jSONObject.optInt("bav_monitor_rate", 0);
            this.p = jSONObject.optString("monitor_status", null);
            this.q = jSONObject.optInt("monitor_num", 0);
            this.r = jSONObject.optLong("date", 0L);
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
            jSONObject.put("event_name", this.m);
            jSONObject.put("is_monitor", this.n);
            jSONObject.put("bav_monitor_rate", this.o);
            jSONObject.put("monitor_status", this.p);
            jSONObject.put("monitor_num", this.q);
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    @Override // c.b.a.p
    @NonNull
    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? s : (String) invokeV.objValue;
    }

    public x(String str, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.n = 1;
        this.o = AppLog.getSuccRate();
        this.m = str;
        this.p = str2;
        this.q = i2;
        this.r = g0.a();
    }
}
