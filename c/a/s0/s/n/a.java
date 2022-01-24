package c.a.s0.s.n;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.GetBigday.BigdayInfo;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f13431b;

    /* renamed from: c  reason: collision with root package name */
    public int f13432c;

    /* renamed from: d  reason: collision with root package name */
    public long f13433d;

    /* renamed from: e  reason: collision with root package name */
    public int f13434e;

    /* renamed from: f  reason: collision with root package name */
    public long f13435f;

    /* renamed from: g  reason: collision with root package name */
    public long f13436g;

    public a() {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (StringUtils.isNULL(this.a) || this.f13433d <= 0) {
                return false;
            }
            int i2 = this.f13434e;
            if (i2 == 1 || i2 == 3) {
                long j2 = this.f13435f;
                if (j2 > 0) {
                    long j3 = this.f13436g;
                    return j3 > 0 && j3 > j2;
                }
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void b(BigdayInfo bigdayInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bigdayInfo) == null) || bigdayInfo == null || StringUtils.isNULL(bigdayInfo.img_url) || bigdayInfo.id.longValue() <= 0) {
            return;
        }
        if ((bigdayInfo.position.intValue() == 1 || bigdayInfo.position.intValue() == 3) && bigdayInfo.start_time.longValue() > 0 && bigdayInfo.end_time.longValue() > 0 && bigdayInfo.end_time.longValue() > bigdayInfo.start_time.longValue()) {
            this.a = bigdayInfo.img_url;
            this.f13431b = bigdayInfo.jump_url;
            this.f13432c = bigdayInfo.img_colour.intValue();
            this.f13433d = bigdayInfo.id.longValue();
            this.f13434e = bigdayInfo.position.intValue();
            this.f13435f = bigdayInfo.start_time.longValue();
            this.f13436g = bigdayInfo.end_time.longValue();
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                return aVar.a() && a() && this.f13433d == aVar.f13433d && StringHelper.equals(this.a, aVar.a) && ((this.f13431b == null && aVar.f13431b == null) || StringHelper.equals(this.f13431b, aVar.f13431b)) && this.f13432c == aVar.f13432c && this.f13434e == aVar.f13434e && this.f13435f == aVar.f13435f && this.f13436g == aVar.f13436g;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
