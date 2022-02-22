package c.a.t0.s.o;

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
    public String f13715b;

    /* renamed from: c  reason: collision with root package name */
    public int f13716c;

    /* renamed from: d  reason: collision with root package name */
    public long f13717d;

    /* renamed from: e  reason: collision with root package name */
    public int f13718e;

    /* renamed from: f  reason: collision with root package name */
    public long f13719f;

    /* renamed from: g  reason: collision with root package name */
    public long f13720g;

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
            if (StringUtils.isNULL(this.a) || this.f13717d <= 0) {
                return false;
            }
            int i2 = this.f13718e;
            if (i2 == 1 || i2 == 3) {
                long j2 = this.f13719f;
                if (j2 > 0) {
                    long j3 = this.f13720g;
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
            this.f13715b = bigdayInfo.jump_url;
            this.f13716c = bigdayInfo.img_colour.intValue();
            this.f13717d = bigdayInfo.id.longValue();
            this.f13718e = bigdayInfo.position.intValue();
            this.f13719f = bigdayInfo.start_time.longValue();
            this.f13720g = bigdayInfo.end_time.longValue();
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                return aVar.a() && a() && this.f13717d == aVar.f13717d && StringHelper.equals(this.a, aVar.a) && ((this.f13715b == null && aVar.f13715b == null) || StringHelper.equals(this.f13715b, aVar.f13715b)) && this.f13716c == aVar.f13716c && this.f13718e == aVar.f13718e && this.f13719f == aVar.f13719f && this.f13720g == aVar.f13720g;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
