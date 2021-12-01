package c.a.r0.n1.k.a.b;

import c.a.d.m.e.n;
import c.a.d.m.e.s;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public List<c.a.d.m.e.a> f20644b;

    /* renamed from: c  reason: collision with root package name */
    public s f20645c;

    /* renamed from: d  reason: collision with root package name */
    public c f20646d;

    /* renamed from: e  reason: collision with root package name */
    public a f20647e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.r0.n1.k.b.b.c f20648f;

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
        this.a = tbPageContext;
        this.f20645c = sVar;
        a();
        this.f20645c.addAdapters(this.f20644b);
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f20644b = new ArrayList();
            this.f20646d = new c(this.a);
            this.f20647e = new a(this.a);
            this.f20648f = new c.a.r0.n1.k.b.b.c(this.a);
            this.f20644b.add(this.f20646d);
            this.f20644b.add(this.f20647e);
            this.f20644b.add(this.f20648f);
        }
    }

    public void b() {
        s sVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (sVar = this.f20645c) == null) {
            return;
        }
        sVar.getListAdapter().notifyDataSetChanged();
    }

    public void c(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.f20645c.setData(list);
        }
    }
}
