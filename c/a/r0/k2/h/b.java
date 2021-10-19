package c.a.r0.k2.h;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.CardBoxMemberPayActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
import tbclient.SendCardInfo;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f19791a;

    /* renamed from: b  reason: collision with root package name */
    public String f19792b;

    /* renamed from: c  reason: collision with root package name */
    public String f19793c;

    /* renamed from: d  reason: collision with root package name */
    public String f19794d;

    /* renamed from: e  reason: collision with root package name */
    public int f19795e;

    /* renamed from: f  reason: collision with root package name */
    public String f19796f;

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
            }
        }
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f19795e == 3 : invokeV.booleanValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f19795e == 1 : invokeV.booleanValue;
    }

    public void c(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.f19792b = jSONObject.optString("card_logo");
        this.f19793c = jSONObject.optString("card_name");
        this.f19794d = jSONObject.optString("card_pro");
        this.f19795e = jSONObject.optInt("card_get_status");
        this.f19791a = jSONObject.optLong(CardBoxMemberPayActivityConfig.PACKET_ID);
        this.f19796f = jSONObject.optString("card_num");
    }

    public void d(SendCardInfo sendCardInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, sendCardInfo) == null) || sendCardInfo == null) {
            return;
        }
        this.f19792b = sendCardInfo.card_logo;
        this.f19793c = sendCardInfo.card_name;
        this.f19794d = sendCardInfo.card_pro;
        this.f19795e = sendCardInfo.card_get_status.intValue();
        this.f19791a = sendCardInfo.packet_id.longValue();
    }
}
