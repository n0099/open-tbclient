package c.a.r0.k3.r0;

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
    public long f21274a;

    /* renamed from: b  reason: collision with root package name */
    public long f21275b;

    /* renamed from: c  reason: collision with root package name */
    public String f21276c;

    /* renamed from: d  reason: collision with root package name */
    public int f21277d;

    /* renamed from: e  reason: collision with root package name */
    public String f21278e;

    /* renamed from: f  reason: collision with root package name */
    public String f21279f;

    /* renamed from: g  reason: collision with root package name */
    public long f21280g;

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
        this.f21274a = System.currentTimeMillis();
        this.f21276c = str;
    }

    public JSONObject a() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("startTime", this.f21274a);
            jSONObject.put("endTime", this.f21275b);
            jSONObject.put("errorCode", this.f21277d);
            jSONObject.put("errorMessage", this.f21278e);
            jSONObject.put(PackageTable.MD5, this.f21279f);
            jSONObject.put("id", this.f21276c);
            jSONObject.put("size", this.f21280g);
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
