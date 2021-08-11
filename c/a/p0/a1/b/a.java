package c.a.p0.a1.b;

import c.a.e.k.e.e;
import c.a.p0.a0.e0.d;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.godSquare.adapter.GodSquareHotGodAdapter;
import com.baidu.tieba.godSquare.adapter.GodSquareRecGodAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d f15103a;

    /* renamed from: b  reason: collision with root package name */
    public GodSquareRecGodAdapter f15104b;

    /* renamed from: c  reason: collision with root package name */
    public GodSquareHotGodAdapter f15105c;

    /* renamed from: d  reason: collision with root package name */
    public List<c.a.e.k.e.a> f15106d;

    /* renamed from: e  reason: collision with root package name */
    public BdTypeListView f15107e;

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeListView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f15106d = new ArrayList();
        this.f15107e = bdTypeListView;
        this.f15103a = new d(tbPageContext);
        this.f15104b = new GodSquareRecGodAdapter(tbPageContext);
        this.f15105c = new GodSquareHotGodAdapter(tbPageContext);
        this.f15106d.add(this.f15103a);
        this.f15106d.add(this.f15104b);
        this.f15106d.add(this.f15105c);
    }

    public List<c.a.e.k.e.a> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f15106d : (List) invokeV.objValue;
    }

    public void b() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (bdTypeListView = this.f15107e) != null && (bdTypeListView.getAdapter2() instanceof e)) {
            this.f15107e.getAdapter2().notifyDataSetChanged();
        }
    }
}
