package c.a.r0.k3;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsPage.NavTabInfo;
import tbclient.FrsTabInfo;
/* loaded from: classes3.dex */
public class o {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<FrsTabInfo> f21174a;

    /* renamed from: b  reason: collision with root package name */
    public List<FrsTabInfo> f21175b;

    /* renamed from: c  reason: collision with root package name */
    public List<FrsTabInfo> f21176c;

    public o() {
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
        this.f21174a = new ArrayList();
        this.f21175b = new ArrayList();
        this.f21176c = new ArrayList();
    }

    public void a(NavTabInfo navTabInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, navTabInfo) == null) || navTabInfo == null) {
            return;
        }
        this.f21174a = new ArrayList(navTabInfo.tab);
        this.f21175b = new ArrayList(navTabInfo.menu);
        this.f21176c = new ArrayList(navTabInfo.head);
    }
}
