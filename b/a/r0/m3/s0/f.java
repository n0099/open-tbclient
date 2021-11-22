package b.a.r0.m3.s0;

import androidx.annotation.NonNull;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f22690a;

    /* renamed from: b  reason: collision with root package name */
    public long f22691b;

    /* renamed from: c  reason: collision with root package name */
    public String f22692c;

    /* renamed from: d  reason: collision with root package name */
    public int f22693d;

    /* renamed from: e  reason: collision with root package name */
    public String f22694e;

    /* renamed from: f  reason: collision with root package name */
    public String f22695f;

    /* renamed from: g  reason: collision with root package name */
    public long f22696g;

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
        this.f22690a = System.currentTimeMillis();
        this.f22692c = str;
    }

    public JSONObject a() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("startTime", this.f22690a);
            jSONObject.put("endTime", this.f22691b);
            jSONObject.put("errorCode", this.f22693d);
            jSONObject.put("errorMessage", this.f22694e);
            jSONObject.put(PackageTable.MD5, this.f22695f);
            jSONObject.put("id", this.f22692c);
            jSONObject.put("size", this.f22696g);
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
