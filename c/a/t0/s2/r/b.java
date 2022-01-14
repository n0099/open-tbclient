package c.a.t0.s2.r;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.CardBoxMemberPayActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
import tbclient.SendCardInfo;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public String f22391b;

    /* renamed from: c  reason: collision with root package name */
    public String f22392c;

    /* renamed from: d  reason: collision with root package name */
    public String f22393d;

    /* renamed from: e  reason: collision with root package name */
    public int f22394e;

    /* renamed from: f  reason: collision with root package name */
    public String f22395f;

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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f22394e == 3 : invokeV.booleanValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f22394e == 1 : invokeV.booleanValue;
    }

    public void c(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.f22391b = jSONObject.optString("card_logo");
        this.f22392c = jSONObject.optString("card_name");
        this.f22393d = jSONObject.optString("card_pro");
        this.f22394e = jSONObject.optInt("card_get_status");
        this.a = jSONObject.optLong(CardBoxMemberPayActivityConfig.PACKET_ID);
        this.f22395f = jSONObject.optString("card_num");
    }

    public void d(SendCardInfo sendCardInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, sendCardInfo) == null) || sendCardInfo == null) {
            return;
        }
        this.f22391b = sendCardInfo.card_logo;
        this.f22392c = sendCardInfo.card_name;
        this.f22393d = sendCardInfo.card_pro;
        this.f22394e = sendCardInfo.card_get_status.intValue();
        this.a = sendCardInfo.packet_id.longValue();
    }
}
