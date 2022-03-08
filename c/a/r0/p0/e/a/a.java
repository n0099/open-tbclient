package c.a.r0.p0.e.a;

import c.a.r0.p0.a.b;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.downloadmanager.ui.adapter.ItemCardViewWrapperAdapter;
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
    public BaseFragment a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f20706b;

    /* renamed from: c  reason: collision with root package name */
    public ItemCardViewWrapperAdapter f20707c;

    /* renamed from: d  reason: collision with root package name */
    public List<c.a.d.o.e.a> f20708d;

    /* renamed from: e  reason: collision with root package name */
    public int f20709e;

    /* renamed from: f  reason: collision with root package name */
    public int f20710f;

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
        this.f20708d = new ArrayList();
        this.a = baseFragment;
        this.f20706b = bdTypeRecyclerView;
        this.f20709e = i2;
        this.f20710f = i3;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ItemCardViewWrapperAdapter itemCardViewWrapperAdapter = new ItemCardViewWrapperAdapter(this.a.getContext(), b.f20680i, this.f20709e, this.f20706b, this.f20710f);
            this.f20707c = itemCardViewWrapperAdapter;
            this.f20708d.add(itemCardViewWrapperAdapter);
            this.f20706b.addAdapters(this.f20708d);
        }
    }
}
