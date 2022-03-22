package c.a.o0.r.o;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.GetBigday.BigdayInfo;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f10759b;

    /* renamed from: c  reason: collision with root package name */
    public int f10760c;

    /* renamed from: d  reason: collision with root package name */
    public long f10761d;

    /* renamed from: e  reason: collision with root package name */
    public int f10762e;

    /* renamed from: f  reason: collision with root package name */
    public long f10763f;

    /* renamed from: g  reason: collision with root package name */
    public long f10764g;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (StringUtils.isNULL(this.a) || this.f10761d <= 0) {
                return false;
            }
            int i = this.f10762e;
            if (i == 1 || i == 3) {
                long j = this.f10763f;
                if (j > 0) {
                    long j2 = this.f10764g;
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
            this.a = bigdayInfo.img_url;
            this.f10759b = bigdayInfo.jump_url;
            this.f10760c = bigdayInfo.img_colour.intValue();
            this.f10761d = bigdayInfo.id.longValue();
            this.f10762e = bigdayInfo.position.intValue();
            this.f10763f = bigdayInfo.start_time.longValue();
            this.f10764g = bigdayInfo.end_time.longValue();
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                return aVar.a() && a() && this.f10761d == aVar.f10761d && StringHelper.equals(this.a, aVar.a) && ((this.f10759b == null && aVar.f10759b == null) || StringHelper.equals(this.f10759b, aVar.f10759b)) && this.f10760c == aVar.f10760c && this.f10762e == aVar.f10762e && this.f10763f == aVar.f10763f && this.f10764g == aVar.f10764g;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
