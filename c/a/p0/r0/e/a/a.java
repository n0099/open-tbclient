package c.a.p0.r0.e.a;

import c.a.p0.r0.a.b;
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
    public BdTypeRecyclerView f17931b;

    /* renamed from: c  reason: collision with root package name */
    public ItemCardViewWrapperAdapter f17932c;

    /* renamed from: d  reason: collision with root package name */
    public List<c.a.d.o.e.a> f17933d;

    /* renamed from: e  reason: collision with root package name */
    public int f17934e;

    /* renamed from: f  reason: collision with root package name */
    public int f17935f;

    public a(BaseFragment baseFragment, BdTypeRecyclerView bdTypeRecyclerView, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragment, bdTypeRecyclerView, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f17933d = new ArrayList();
        this.a = baseFragment;
        this.f17931b = bdTypeRecyclerView;
        this.f17934e = i;
        this.f17935f = i2;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ItemCardViewWrapperAdapter itemCardViewWrapperAdapter = new ItemCardViewWrapperAdapter(this.a.getContext(), b.f17905e, this.f17934e, this.f17931b, this.f17935f);
            this.f17932c = itemCardViewWrapperAdapter;
            this.f17933d.add(itemCardViewWrapperAdapter);
            this.f17931b.a(this.f17933d);
        }
    }
}
