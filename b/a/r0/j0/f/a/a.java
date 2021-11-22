package b.a.r0.j0.f.a;

import b.a.r0.j0.b.b;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.downloadmanager.ui.adapter.ItemCardViewWrapperAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BaseFragment f19656a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f19657b;

    /* renamed from: c  reason: collision with root package name */
    public ItemCardViewWrapperAdapter f19658c;

    /* renamed from: d  reason: collision with root package name */
    public List<b.a.e.m.e.a> f19659d;

    /* renamed from: e  reason: collision with root package name */
    public int f19660e;

    /* renamed from: f  reason: collision with root package name */
    public int f19661f;

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
        this.f19659d = new ArrayList();
        this.f19656a = baseFragment;
        this.f19657b = bdTypeRecyclerView;
        this.f19660e = i2;
        this.f19661f = i3;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ItemCardViewWrapperAdapter itemCardViewWrapperAdapter = new ItemCardViewWrapperAdapter(this.f19656a.getContext(), b.f19629i, this.f19660e, this.f19657b, this.f19661f);
            this.f19658c = itemCardViewWrapperAdapter;
            this.f19659d.add(itemCardViewWrapperAdapter);
            this.f19657b.addAdapters(this.f19659d);
        }
    }
}
