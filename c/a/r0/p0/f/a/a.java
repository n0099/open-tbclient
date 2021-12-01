package c.a.r0.p0.f.a;

import c.a.r0.p0.b.b;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.downloadmanager.ui.adapter.ItemCardViewWrapperAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseFragment a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f21033b;

    /* renamed from: c  reason: collision with root package name */
    public ItemCardViewWrapperAdapter f21034c;

    /* renamed from: d  reason: collision with root package name */
    public List<c.a.d.m.e.a> f21035d;

    /* renamed from: e  reason: collision with root package name */
    public int f21036e;

    /* renamed from: f  reason: collision with root package name */
    public int f21037f;

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
        this.f21035d = new ArrayList();
        this.a = baseFragment;
        this.f21033b = bdTypeRecyclerView;
        this.f21036e = i2;
        this.f21037f = i3;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ItemCardViewWrapperAdapter itemCardViewWrapperAdapter = new ItemCardViewWrapperAdapter(this.a.getContext(), b.f21005i, this.f21036e, this.f21033b, this.f21037f);
            this.f21034c = itemCardViewWrapperAdapter;
            this.f21035d.add(itemCardViewWrapperAdapter);
            this.f21033b.addAdapters(this.f21035d);
        }
    }
}
