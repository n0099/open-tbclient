package c.a.q0.v.d.c.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class e extends BaseCardInfo {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f25082g;

    /* renamed from: h  reason: collision with root package name */
    public static final BdUniqueId f25083h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public c.a.q0.v.d.a.a f25084e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.q0.v.d.a.a f25085f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1377720986, "Lc/a/q0/v/d/c/e/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1377720986, "Lc/a/q0/v/d/c/e/e;");
                return;
            }
        }
        f25082g = BdUniqueId.gen();
        f25083h = BdUniqueId.gen();
    }

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, c.a.e.l.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        SdkLiveInfoData sdkLiveInfoData;
        SdkLiveInfoData.AlaLiveInfo alaLiveInfo;
        SdkLiveInfoData.YYExt yYExt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            c.a.q0.v.d.a.a aVar = this.f25084e;
            if (aVar != null && (sdkLiveInfoData = aVar.f24982e) != null && (alaLiveInfo = sdkLiveInfoData.liveInfo) != null && (yYExt = alaLiveInfo.yyExt) != null && yYExt.isYYGame == 1) {
                return f25083h;
            }
            return f25082g;
        }
        return (BdUniqueId) invokeV.objValue;
    }
}
