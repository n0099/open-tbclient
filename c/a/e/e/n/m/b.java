package c.a.e.e.n.m;

import android.text.TextUtils;
import c.a.e.e.a.f.d;
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

    /* renamed from: a  reason: collision with root package name */
    public long f2485a;

    /* renamed from: b  reason: collision with root package name */
    public String f2486b;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f2485a = 0L;
        this.f2486b = null;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            d dVar = new d("statisticConfig", "switchsConfig", DiskFileOperate.Action.READ);
            dVar.setSdCard(false);
            dVar.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
            c.a.e.e.a.d.g().d(dVar);
            String a2 = dVar.isSuccess() ? dVar.a() : null;
            if (TextUtils.isEmpty(a2)) {
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(a2);
                this.f2485a = jSONObject.getLong("time");
                this.f2486b = jSONObject.getString("data");
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
            c.a.e.e.a.d.g().d(dVar);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
