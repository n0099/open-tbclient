package c.a.q0.t.c;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.aperf.bosuploader.ContentUtil;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.coreExtra.data.VcodeExtra;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class l0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f14715a;

    /* renamed from: b  reason: collision with root package name */
    public String f14716b;

    /* renamed from: c  reason: collision with root package name */
    public String f14717c;

    /* renamed from: d  reason: collision with root package name */
    public VcodeExtra f14718d;

    public l0() {
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
        this.f14715a = null;
        this.f14716b = null;
        this.f14717c = null;
    }

    public VcodeExtra a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f14718d : (VcodeExtra) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f14715a : (String) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f14716b : (String) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f14717c : (String) invokeV.objValue;
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                JSONObject optJSONObject = jSONObject.optJSONObject("info");
                if (optJSONObject == null) {
                    optJSONObject = jSONObject.optJSONObject(SubPbActivityConfig.KEY_ANTI);
                }
                f(optJSONObject);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public void f(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        try {
            this.f14715a = jSONObject.optString("vcode_md5");
            this.f14716b = jSONObject.optString("vcode_pic_url");
            this.f14717c = jSONObject.optString("vcode_type");
            JSONObject jSONObject2 = jSONObject.getJSONObject("vcode_extra");
            VcodeExtra vcodeExtra = new VcodeExtra();
            this.f14718d = vcodeExtra;
            vcodeExtra.textImg = jSONObject2.optString("textimg");
            this.f14718d.slideImg = jSONObject2.optString("slideimg");
            this.f14718d.endPoint = jSONObject2.optString(ContentUtil.RESULT_KEY_ENDPOINT);
            this.f14718d.successImg = jSONObject2.optString("successimg");
            this.f14718d.slideEndPoint = jSONObject2.optString("slideendpoint");
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }
}
