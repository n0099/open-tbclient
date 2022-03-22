package c.a.p0.k1.b;

import c.a.d.o.e.e;
import c.a.p0.h0.f0.d;
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
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d a;

    /* renamed from: b  reason: collision with root package name */
    public GodSquareRecGodAdapter f15941b;

    /* renamed from: c  reason: collision with root package name */
    public GodSquareHotGodAdapter f15942c;

    /* renamed from: d  reason: collision with root package name */
    public List<c.a.d.o.e.a> f15943d;

    /* renamed from: e  reason: collision with root package name */
    public BdTypeListView f15944e;

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeListView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f15943d = new ArrayList();
        this.f15944e = bdTypeListView;
        this.a = new d(tbPageContext);
        this.f15941b = new GodSquareRecGodAdapter(tbPageContext);
        this.f15942c = new GodSquareHotGodAdapter(tbPageContext);
        this.f15943d.add(this.a);
        this.f15943d.add(this.f15941b);
        this.f15943d.add(this.f15942c);
    }

    public List<c.a.d.o.e.a> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f15943d : (List) invokeV.objValue;
    }

    public void b() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (bdTypeListView = this.f15944e) != null && (bdTypeListView.getAdapter2() instanceof e)) {
            this.f15944e.getAdapter2().notifyDataSetChanged();
        }
    }
}
