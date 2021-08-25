package c.a.p0.s.n;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.GetBigday.BigdayInfo;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f14073a;

    /* renamed from: b  reason: collision with root package name */
    public String f14074b;

    /* renamed from: c  reason: collision with root package name */
    public int f14075c;

    /* renamed from: d  reason: collision with root package name */
    public long f14076d;

    /* renamed from: e  reason: collision with root package name */
    public int f14077e;

    /* renamed from: f  reason: collision with root package name */
    public long f14078f;

    /* renamed from: g  reason: collision with root package name */
    public long f14079g;

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
            if (StringUtils.isNULL(this.f14073a) || this.f14076d <= 0) {
                return false;
            }
            int i2 = this.f14077e;
            if (i2 == 1 || i2 == 3) {
                long j2 = this.f14078f;
                if (j2 > 0) {
                    long j3 = this.f14079g;
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
            this.f14073a = bigdayInfo.img_url;
            this.f14074b = bigdayInfo.jump_url;
            this.f14075c = bigdayInfo.img_colour.intValue();
            this.f14076d = bigdayInfo.id.longValue();
            this.f14077e = bigdayInfo.position.intValue();
            this.f14078f = bigdayInfo.start_time.longValue();
            this.f14079g = bigdayInfo.end_time.longValue();
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                return aVar.a() && a() && this.f14076d == aVar.f14076d && StringHelper.equals(this.f14073a, aVar.f14073a) && ((this.f14074b == null && aVar.f14074b == null) || StringHelper.equals(this.f14074b, aVar.f14074b)) && this.f14075c == aVar.f14075c && this.f14077e == aVar.f14077e && this.f14078f == aVar.f14078f && this.f14079g == aVar.f14079g;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
