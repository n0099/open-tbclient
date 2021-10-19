package c.a.q0.s.q;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class s0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public UserData f14330a;

    /* renamed from: b  reason: collision with root package name */
    public AntiData f14331b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<String> f14332c;

    public s0() {
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
        this.f14332c = null;
        this.f14330a = new UserData();
        this.f14331b = new AntiData();
        this.f14332c = new ArrayList<>();
        e(0);
    }

    public AntiData a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f14331b : (AntiData) invokeV.objValue;
    }

    public UserData b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f14330a : (UserData) invokeV.objValue;
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            try {
                d(new JSONObject(str));
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public void d(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, jSONObject) == null) {
            try {
                this.f14330a.parserJson(jSONObject.optJSONObject("user"));
                this.f14331b.parserJson(jSONObject.optJSONObject(SubPbActivityConfig.KEY_ANTI));
                JSONArray optJSONArray = jSONObject.optJSONArray("suggnames");
                if (optJSONArray != null) {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        this.f14332c.add(optJSONArray.optString(i2, null));
                    }
                }
                e(jSONObject.optInt("retrytime"));
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
        }
    }
}
