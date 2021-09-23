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
    public long f21095a;

    /* renamed from: b  reason: collision with root package name */
    public long f21096b;

    /* renamed from: c  reason: collision with root package name */
    public String f21097c;

    /* renamed from: d  reason: collision with root package name */
    public int f21098d;

    /* renamed from: e  reason: collision with root package name */
    public String f21099e;

    /* renamed from: f  reason: collision with root package name */
    public String f21100f;

    /* renamed from: g  reason: collision with root package name */
    public long f21101g;

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
        this.f21095a = System.currentTimeMillis();
        this.f21097c = str;
    }

    public JSONObject a() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("startTime", this.f21095a);
            jSONObject.put("endTime", this.f21096b);
            jSONObject.put("errorCode", this.f21098d);
            jSONObject.put("errorMessage", this.f21099e);
            jSONObject.put(PackageTable.MD5, this.f21100f);
            jSONObject.put("id", this.f21097c);
            jSONObject.put("size", this.f21101g);
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
