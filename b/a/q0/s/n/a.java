package b.a.q0.s.n;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.GetBigday.BigdayInfo;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f13942a;

    /* renamed from: b  reason: collision with root package name */
    public String f13943b;

    /* renamed from: c  reason: collision with root package name */
    public int f13944c;

    /* renamed from: d  reason: collision with root package name */
    public long f13945d;

    /* renamed from: e  reason: collision with root package name */
    public int f13946e;

    /* renamed from: f  reason: collision with root package name */
    public long f13947f;

    /* renamed from: g  reason: collision with root package name */
    public long f13948g;

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
            if (StringUtils.isNULL(this.f13942a) || this.f13945d <= 0) {
                return false;
            }
            int i2 = this.f13946e;
            if (i2 == 1 || i2 == 3) {
                long j = this.f13947f;
                if (j > 0) {
                    long j2 = this.f13948g;
                    return j2 > 0 && j2 > j;
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
            this.f13942a = bigdayInfo.img_url;
            this.f13943b = bigdayInfo.jump_url;
            this.f13944c = bigdayInfo.img_colour.intValue();
            this.f13945d = bigdayInfo.id.longValue();
            this.f13946e = bigdayInfo.position.intValue();
            this.f13947f = bigdayInfo.start_time.longValue();
            this.f13948g = bigdayInfo.end_time.longValue();
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                return aVar.a() && a() && this.f13945d == aVar.f13945d && StringHelper.equals(this.f13942a, aVar.f13942a) && ((this.f13943b == null && aVar.f13943b == null) || StringHelper.equals(this.f13943b, aVar.f13943b)) && this.f13944c == aVar.f13944c && this.f13946e == aVar.f13946e && this.f13947f == aVar.f13947f && this.f13948g == aVar.f13948g;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
