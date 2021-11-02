package b.a.r0.l3.s0;

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
    public long f20840a;

    /* renamed from: b  reason: collision with root package name */
    public long f20841b;

    /* renamed from: c  reason: collision with root package name */
    public String f20842c;

    /* renamed from: d  reason: collision with root package name */
    public int f20843d;

    /* renamed from: e  reason: collision with root package name */
    public String f20844e;

    /* renamed from: f  reason: collision with root package name */
    public String f20845f;

    /* renamed from: g  reason: collision with root package name */
    public long f20846g;

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
        this.f20840a = System.currentTimeMillis();
        this.f20842c = str;
    }

    public JSONObject a() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("startTime", this.f20840a);
            jSONObject.put("endTime", this.f20841b);
            jSONObject.put("errorCode", this.f20843d);
            jSONObject.put("errorMessage", this.f20844e);
            jSONObject.put(PackageTable.MD5, this.f20845f);
            jSONObject.put("id", this.f20842c);
            jSONObject.put("size", this.f20846g);
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
