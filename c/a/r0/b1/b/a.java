package c.a.r0.b1.b;

import c.a.e.l.e.e;
import c.a.r0.a0.e0.d;
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
    public d f15921a;

    /* renamed from: b  reason: collision with root package name */
    public GodSquareRecGodAdapter f15922b;

    /* renamed from: c  reason: collision with root package name */
    public GodSquareHotGodAdapter f15923c;

    /* renamed from: d  reason: collision with root package name */
    public List<c.a.e.l.e.a> f15924d;

    /* renamed from: e  reason: collision with root package name */
    public BdTypeListView f15925e;

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
        this.f15924d = new ArrayList();
        this.f15925e = bdTypeListView;
        this.f15921a = new d(tbPageContext);
        this.f15922b = new GodSquareRecGodAdapter(tbPageContext);
        this.f15923c = new GodSquareHotGodAdapter(tbPageContext);
        this.f15924d.add(this.f15921a);
        this.f15924d.add(this.f15922b);
        this.f15924d.add(this.f15923c);
    }

    public List<c.a.e.l.e.a> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f15924d : (List) invokeV.objValue;
    }

    public void b() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (bdTypeListView = this.f15925e) != null && (bdTypeListView.getAdapter2() instanceof e)) {
            this.f15925e.getAdapter2().notifyDataSetChanged();
        }
    }
}
