package c.a.s0.v3.s0;

import androidx.annotation.NonNull;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public long f25099b;

    /* renamed from: c  reason: collision with root package name */
    public String f25100c;

    /* renamed from: d  reason: collision with root package name */
    public int f25101d;

    /* renamed from: e  reason: collision with root package name */
    public String f25102e;

    /* renamed from: f  reason: collision with root package name */
    public String f25103f;

    /* renamed from: g  reason: collision with root package name */
    public long f25104g;

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
        this.a = System.currentTimeMillis();
        this.f25100c = str;
    }

    public JSONObject a() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("startTime", this.a);
            jSONObject.put("endTime", this.f25099b);
            jSONObject.put("errorCode", this.f25101d);
            jSONObject.put("errorMessage", this.f25102e);
            jSONObject.put(PackageTable.MD5, this.f25103f);
            jSONObject.put("id", this.f25100c);
            jSONObject.put("size", this.f25104g);
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
