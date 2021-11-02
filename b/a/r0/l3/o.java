package b.a.r0.l3;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsPage.NavTabInfo;
import tbclient.FrsTabInfo;
/* loaded from: classes5.dex */
public class o {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<FrsTabInfo> f20737a;

    /* renamed from: b  reason: collision with root package name */
    public List<FrsTabInfo> f20738b;

    /* renamed from: c  reason: collision with root package name */
    public List<FrsTabInfo> f20739c;

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
        this.f20737a = new ArrayList();
        this.f20738b = new ArrayList();
        this.f20739c = new ArrayList();
    }

    public void a(NavTabInfo navTabInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, navTabInfo) == null) || navTabInfo == null) {
            return;
        }
        this.f20737a = new ArrayList(navTabInfo.tab);
        this.f20738b = new ArrayList(navTabInfo.menu);
        this.f20739c = new ArrayList(navTabInfo.head);
    }
}
