package c.a.d.f.n.m;

import android.text.TextUtils;
import c.a.d.f.a.f.d;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public String f2279b;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 0L;
        this.f2279b = null;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            d dVar = new d("statisticConfig", "switchsConfig", DiskFileOperate.Action.READ);
            dVar.setSdCard(false);
            dVar.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
            c.a.d.f.a.d.f().call(dVar);
            String a = dVar.isSuccess() ? dVar.a() : null;
            if (TextUtils.isEmpty(a)) {
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(a);
                this.a = jSONObject.getLong("time");
                this.f2279b = jSONObject.getString("data");
                return true;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("time", currentTimeMillis);
            jSONObject.put("data", str);
            d dVar = new d("statisticConfig", "switchsConfig", DiskFileOperate.Action.WRITE_FORCE);
            dVar.setSdCard(false);
            dVar.b(jSONObject.toString());
            dVar.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
            c.a.d.f.a.d.f().call(dVar);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
