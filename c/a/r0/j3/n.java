package c.a.r0.j3;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes3.dex */
public class n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f20987a;

    /* renamed from: b  reason: collision with root package name */
    public long f20988b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f20989c;

    /* renamed from: d  reason: collision with root package name */
    public String f20990d;

    public n() {
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
        this.f20987a = 0;
        this.f20988b = 0L;
        this.f20989c = false;
        this.f20990d = null;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f20990d : (String) invokeV.objValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f20987a : invokeV.intValue;
    }

    public void c(StarInfo starInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, starInfo) == null) || starInfo == null) {
            return;
        }
        int intValue = starInfo.has_frs_star.intValue();
        this.f20987a = intValue;
        if (intValue == 1) {
            String str = starInfo.top;
            String str2 = starInfo.head;
            Fans fans = starInfo.fans;
            if (fans != null) {
                fans.is_get.intValue();
                fans.num.intValue();
                fans.open.intValue();
                this.f20988b = fans.left_time.intValue();
            }
            Size size = starInfo.top_size;
            if (size != null) {
                size.width.intValue();
                size.height.intValue();
            }
            Size size2 = starInfo.head_size;
            if (size2 != null) {
                size2.width.intValue();
                size2.height.intValue();
            }
        }
        boolean z = starInfo.trade != null;
        this.f20989c = z;
        if (z) {
            Integer num = starInfo.trade.time;
            if (num != null) {
                num.intValue();
            }
            String str3 = starInfo.trade.url;
        }
        this.f20990d = starInfo.star_forum_headimg;
    }
}
