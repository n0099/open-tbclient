package c.a.r0.j3.r0;

import androidx.annotation.NonNull;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f21083a;

    /* renamed from: b  reason: collision with root package name */
    public long f21084b;

    /* renamed from: c  reason: collision with root package name */
    public String f21085c;

    /* renamed from: d  reason: collision with root package name */
    public int f21086d;

    /* renamed from: e  reason: collision with root package name */
    public String f21087e;

    /* renamed from: f  reason: collision with root package name */
    public String f21088f;

    /* renamed from: g  reason: collision with root package name */
    public long f21089g;

    public f(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f21083a = System.currentTimeMillis();
        this.f21085c = str;
    }

    public JSONObject a() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("startTime", this.f21083a);
            jSONObject.put("endTime", this.f21084b);
            jSONObject.put("errorCode", this.f21086d);
            jSONObject.put("errorMessage", this.f21087e);
            jSONObject.put(PackageTable.MD5, this.f21088f);
            jSONObject.put("id", this.f21085c);
            jSONObject.put("size", this.f21089g);
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
