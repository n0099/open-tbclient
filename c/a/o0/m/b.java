package c.a.o0.m;

import android.os.Build;
import c.a.e.e.p.j;
import c.a.o0.s.y.l;
import c.a.o0.s.y.n;
import c.a.o0.s.y.o;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(l lVar) {
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

    @o(isAsync = false, value = "showDeviceInfo")
    private JSONObject showDeviceInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            String cuid = TbadkCoreApplication.getInst().getCuid();
            String str = Build.VERSION.RELEASE;
            String str2 = Build.MODEL;
            int k = c.a.e.e.p.l.k(b());
            int i2 = c.a.e.e.p.l.i(b());
            String str3 = String.valueOf(k) + "," + String.valueOf(i2);
            String versionName = TbadkCoreApplication.getInst().getVersionName();
            try {
                jSONObject.put("systemName", "android");
                jSONObject.put("systemVersion", str);
                jSONObject.put("model", str2);
                jSONObject.put("cuid", cuid);
                jSONObject.put("resolution", str3);
                jSONObject.put("appVersion", versionName);
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    @o(isAsync = false, value = "showNetStatus")
    private JSONObject showNetStatus() {
        InterceptResult invokeV;
        int i2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (j.H()) {
                i2 = 1;
                str = CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING;
            } else if (j.t()) {
                i2 = 3;
                str = "2G";
            } else if (j.u()) {
                i2 = 4;
                str = "3G";
            } else if (j.v()) {
                i2 = 5;
                str = "4G";
            } else {
                i2 = 0;
                str = "NotReachable";
            }
            try {
                jSONObject.put("netStatus", i2);
                jSONObject.put("netDesc", str);
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    @o(isAsync = false, value = "showToast")
    private void showToast(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        BdToast.c(b(), jSONObject.optString("message")).q();
    }

    @Override // c.a.o0.s.y.n
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "TBHY_COMMON_Utils" : (String) invokeV.objValue;
    }
}
