package c.a.s0.d1.j2;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import c.a.r0.s.a0.l;
import c.a.r0.s.a0.n;
import c.a.r0.s.a0.o;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class e extends n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(l lVar) {
        super(lVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((l) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @o(isAsync = false, value = "isGameInstall")
    private JSONObject isGameInstall(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            JSONObject jSONObject2 = new JSONObject();
            String optString = jSONObject.optString("packagename");
            try {
                PackageInfo packageInfo = getContext().getPackageManager().getPackageInfo(optString, 0);
                if (packageInfo != null && packageInfo.packageName.equals(optString)) {
                    jSONObject2.put("isInstall", true);
                } else {
                    jSONObject2.put("isInstall", false);
                }
            } catch (PackageManager.NameNotFoundException e2) {
                try {
                    jSONObject2.put("isInstall", false);
                } catch (JSONException unused) {
                    BdLog.e(e2.getMessage());
                }
            } catch (JSONException e3) {
                BdLog.e(e3.getMessage());
            }
            return jSONObject2;
        }
        return (JSONObject) invokeL.objValue;
    }

    @Override // c.a.r0.s.a0.n
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "TBHY_COMMON_IS_GAME_INSTALL" : (String) invokeV.objValue;
    }
}
