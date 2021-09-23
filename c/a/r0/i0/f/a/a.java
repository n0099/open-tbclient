package c.a.r0.i0.f.a;

import c.a.r0.i0.b.b;
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
    public BaseFragment f19166a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f19167b;

    /* renamed from: c  reason: collision with root package name */
    public ItemCardViewWrapperAdapter f19168c;

    /* renamed from: d  reason: collision with root package name */
    public List<c.a.e.l.e.a> f19169d;

    /* renamed from: e  reason: collision with root package name */
    public int f19170e;

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
        this.f19169d = new ArrayList();
        this.f19166a = baseFragment;
        this.f19167b = bdTypeRecyclerView;
        this.f19170e = i2;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ItemCardViewWrapperAdapter itemCardViewWrapperAdapter = new ItemCardViewWrapperAdapter(this.f19166a.getContext(), b.f19137i, this.f19170e, this.f19167b);
            this.f19168c = itemCardViewWrapperAdapter;
            this.f19169d.add(itemCardViewWrapperAdapter);
            this.f19167b.addAdapters(this.f19169d);
        }
    }
}
