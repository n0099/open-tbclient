package c.a.t0.j1.b;

import c.a.d.n.e.e;
import c.a.t0.g0.g0.d;
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
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d a;

    /* renamed from: b  reason: collision with root package name */
    public GodSquareRecGodAdapter f18499b;

    /* renamed from: c  reason: collision with root package name */
    public GodSquareHotGodAdapter f18500c;

    /* renamed from: d  reason: collision with root package name */
    public List<c.a.d.n.e.a> f18501d;

    /* renamed from: e  reason: collision with root package name */
    public BdTypeListView f18502e;

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
        this.f18501d = new ArrayList();
        this.f18502e = bdTypeListView;
        this.a = new d(tbPageContext);
        this.f18499b = new GodSquareRecGodAdapter(tbPageContext);
        this.f18500c = new GodSquareHotGodAdapter(tbPageContext);
        this.f18501d.add(this.a);
        this.f18501d.add(this.f18499b);
        this.f18501d.add(this.f18500c);
    }

    public List<c.a.d.n.e.a> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f18501d : (List) invokeV.objValue;
    }

    public void b() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (bdTypeListView = this.f18502e) != null && (bdTypeListView.getAdapter2() instanceof e)) {
            this.f18502e.getAdapter2().notifyDataSetChanged();
        }
    }
}
