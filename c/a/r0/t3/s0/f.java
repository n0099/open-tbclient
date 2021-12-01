package c.a.r0.t3.s0;

import androidx.annotation.NonNull;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public long f24014b;

    /* renamed from: c  reason: collision with root package name */
    public String f24015c;

    /* renamed from: d  reason: collision with root package name */
    public int f24016d;

    /* renamed from: e  reason: collision with root package name */
    public String f24017e;

    /* renamed from: f  reason: collision with root package name */
    public String f24018f;

    /* renamed from: g  reason: collision with root package name */
    public long f24019g;

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
        this.f24015c = str;
    }

    public JSONObject a() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("startTime", this.a);
            jSONObject.put("endTime", this.f24014b);
            jSONObject.put("errorCode", this.f24016d);
            jSONObject.put("errorMessage", this.f24017e);
            jSONObject.put(PackageTable.MD5, this.f24018f);
            jSONObject.put("id", this.f24015c);
            jSONObject.put("size", this.f24019g);
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
