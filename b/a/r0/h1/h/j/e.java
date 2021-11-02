package b.a.r0.h1.h.j;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.UnreadTip.DataRes;
/* loaded from: classes4.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f17451a;

    /* renamed from: b  reason: collision with root package name */
    public List<String> f17452b;

    /* renamed from: c  reason: collision with root package name */
    public long f17453c;

    /* renamed from: d  reason: collision with root package name */
    public String f17454d;

    /* renamed from: e  reason: collision with root package name */
    public int f17455e;

    public e() {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f17451a > 0 : invokeV.booleanValue;
    }

    public void b(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dataRes) == null) || dataRes == null) {
            return;
        }
        this.f17451a = dataRes.user_count.intValue();
        this.f17452b = dataRes.portrait_list;
        this.f17453c = dataRes.hide_unix.longValue() * 1000;
        this.f17454d = dataRes.show_tip;
        this.f17455e = dataRes.thread_count.intValue();
    }
}
