package b.a.r0.h1.k.b.b;

import b.a.e.m.e.n;
import b.a.e.m.e.s;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f19103a;

    /* renamed from: b  reason: collision with root package name */
    public List<b.a.e.m.e.a> f19104b;

    /* renamed from: c  reason: collision with root package name */
    public s f19105c;

    /* renamed from: d  reason: collision with root package name */
    public a f19106d;

    /* renamed from: e  reason: collision with root package name */
    public c f19107e;

    public b(TbPageContext tbPageContext, s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, sVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f19103a = tbPageContext;
        this.f19105c = sVar;
        a();
        this.f19105c.addAdapters(this.f19104b);
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f19104b = new ArrayList();
            this.f19106d = new a(this.f19103a);
            this.f19107e = new c(this.f19103a);
            this.f19104b.add(this.f19106d);
            this.f19104b.add(this.f19107e);
        }
    }

    public void b() {
        s sVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (sVar = this.f19105c) == null) {
            return;
        }
        sVar.getListAdapter().notifyDataSetChanged();
    }

    public void c(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.f19105c.setData(list);
        }
    }

    public void d(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bdUniqueId) == null) {
            for (b.a.e.m.e.a aVar : this.f19104b) {
                aVar.e0(bdUniqueId);
            }
        }
    }
}
