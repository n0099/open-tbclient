package c.a.u0.q0.e.a;

import c.a.u0.q0.a.b;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.downloadmanager.ui.adapter.ItemCardViewWrapperAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseFragment a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f21306b;

    /* renamed from: c  reason: collision with root package name */
    public ItemCardViewWrapperAdapter f21307c;

    /* renamed from: d  reason: collision with root package name */
    public List<c.a.d.o.e.a> f21308d;

    /* renamed from: e  reason: collision with root package name */
    public int f21309e;

    /* renamed from: f  reason: collision with root package name */
    public int f21310f;

    public a(BaseFragment baseFragment, BdTypeRecyclerView bdTypeRecyclerView, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragment, bdTypeRecyclerView, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f21308d = new ArrayList();
        this.a = baseFragment;
        this.f21306b = bdTypeRecyclerView;
        this.f21309e = i2;
        this.f21310f = i3;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ItemCardViewWrapperAdapter itemCardViewWrapperAdapter = new ItemCardViewWrapperAdapter(this.a.getContext(), b.f21280i, this.f21309e, this.f21306b, this.f21310f);
            this.f21307c = itemCardViewWrapperAdapter;
            this.f21308d.add(itemCardViewWrapperAdapter);
            this.f21306b.addAdapters(this.f21308d);
        }
    }
}
