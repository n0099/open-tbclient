package c.a.r0.a0.f.c;

import android.content.Context;
import c.a.d.o.e.n;
import c.a.r0.a0.f.c.d.d;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public Context f14244b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f14245c;

    /* renamed from: d  reason: collision with root package name */
    public List<c.a.d.o.e.a> f14246d;

    /* renamed from: e  reason: collision with root package name */
    public d f14247e;

    /* renamed from: f  reason: collision with root package name */
    public d f14248f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.r0.a0.f.c.d.c f14249g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.r0.a0.f.c.d.b f14250h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.r0.a0.f.c.d.a f14251i;

    /* renamed from: j  reason: collision with root package name */
    public int f14252j;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeRecyclerView, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
        this.f14244b = tbPageContext.getPageActivity();
        this.f14245c = bdTypeRecyclerView;
        this.f14252j = i2;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f14246d = new ArrayList();
            this.f14247e = new d(this.a, this.f14252j, false);
            this.f14248f = new d(this.a, this.f14252j, true);
            this.f14249g = new c.a.r0.a0.f.c.d.c(this.a);
            this.f14250h = new c.a.r0.a0.f.c.d.b(this.a);
            this.f14251i = new c.a.r0.a0.f.c.d.a(this.a);
            this.f14246d.add(this.f14247e);
            this.f14246d.add(this.f14248f);
            this.f14246d.add(this.f14249g);
            this.f14246d.add(this.f14250h);
            this.f14246d.add(this.f14251i);
            this.f14245c.addAdapters(this.f14246d);
        }
    }

    public void b() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (bdTypeRecyclerView = this.f14245c) == null) {
            return;
        }
        bdTypeRecyclerView.getListAdapter().notifyDataSetChanged();
    }

    public void c(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.f14245c.setData(list);
        }
    }
}
