package c.a.r0.c1.b;

import c.a.e.l.e.e;
import c.a.r0.b0.f0.d;
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
    public d f16093a;

    /* renamed from: b  reason: collision with root package name */
    public GodSquareRecGodAdapter f16094b;

    /* renamed from: c  reason: collision with root package name */
    public GodSquareHotGodAdapter f16095c;

    /* renamed from: d  reason: collision with root package name */
    public List<c.a.e.l.e.a> f16096d;

    /* renamed from: e  reason: collision with root package name */
    public BdTypeListView f16097e;

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
        this.f16096d = new ArrayList();
        this.f16097e = bdTypeListView;
        this.f16093a = new d(tbPageContext);
        this.f16094b = new GodSquareRecGodAdapter(tbPageContext);
        this.f16095c = new GodSquareHotGodAdapter(tbPageContext);
        this.f16096d.add(this.f16093a);
        this.f16096d.add(this.f16094b);
        this.f16096d.add(this.f16095c);
    }

    public List<c.a.e.l.e.a> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f16096d : (List) invokeV.objValue;
    }

    public void b() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (bdTypeListView = this.f16097e) != null && (bdTypeListView.getAdapter2() instanceof e)) {
            this.f16097e.getAdapter2().notifyDataSetChanged();
        }
    }
}
