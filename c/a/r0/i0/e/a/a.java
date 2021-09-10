package c.a.r0.i0.e.a;

import c.a.r0.i0.a.b;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.downloadmanager.ui.adapter.ItemCardViewWrapperAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BaseFragment f19151a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f19152b;

    /* renamed from: c  reason: collision with root package name */
    public ItemCardViewWrapperAdapter f19153c;

    /* renamed from: d  reason: collision with root package name */
    public List<c.a.e.l.e.a> f19154d;

    /* renamed from: e  reason: collision with root package name */
    public int f19155e;

    public a(BaseFragment baseFragment, BdTypeRecyclerView bdTypeRecyclerView, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragment, bdTypeRecyclerView, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f19154d = new ArrayList();
        this.f19151a = baseFragment;
        this.f19152b = bdTypeRecyclerView;
        this.f19155e = i2;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ItemCardViewWrapperAdapter itemCardViewWrapperAdapter = new ItemCardViewWrapperAdapter(this.f19151a.getContext(), b.f19126g, this.f19155e);
            this.f19153c = itemCardViewWrapperAdapter;
            this.f19154d.add(itemCardViewWrapperAdapter);
            this.f19152b.addAdapters(this.f19154d);
        }
    }
}
