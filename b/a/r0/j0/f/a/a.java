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
    public BaseFragment f18322a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f18323b;

    /* renamed from: c  reason: collision with root package name */
    public ItemCardViewWrapperAdapter f18324c;

    /* renamed from: d  reason: collision with root package name */
    public List<b.a.e.l.e.a> f18325d;

    /* renamed from: e  reason: collision with root package name */
    public int f18326e;

    /* renamed from: f  reason: collision with root package name */
    public int f18327f;

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
        this.f18325d = new ArrayList();
        this.f18322a = baseFragment;
        this.f18323b = bdTypeRecyclerView;
        this.f18326e = i2;
        this.f18327f = i3;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ItemCardViewWrapperAdapter itemCardViewWrapperAdapter = new ItemCardViewWrapperAdapter(this.f18322a.getContext(), b.f18295i, this.f18326e, this.f18323b, this.f18327f);
            this.f18324c = itemCardViewWrapperAdapter;
            this.f18325d.add(itemCardViewWrapperAdapter);
            this.f18323b.addAdapters(this.f18325d);
        }
    }
}
