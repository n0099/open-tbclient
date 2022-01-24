package c.a.t0.r1.m;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import c.a.d.f.p.n;
import c.a.t0.e1.s;
import c.a.t0.e1.t;
import c.a.t0.r1.e;
import c.a.t0.r1.h;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final b a;

    /* renamed from: b  reason: collision with root package name */
    public View f21902b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f21903c;

    /* renamed from: d  reason: collision with root package name */
    public PbListView f21904d;

    /* loaded from: classes8.dex */
    public interface a {
    }

    public d(a aVar, View view, TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, view, tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f21902b = view;
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) view.findViewById(e.frs_hottopic_lv_thread);
        this.f21903c = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(bdTypeRecyclerView.getContext()));
        this.f21903c.setFadingEdgeLength(0);
        this.f21903c.setOverScrollMode(2);
        PbListView pbListView = new PbListView(tbPageContext.getPageActivity());
        this.f21904d = pbListView;
        pbListView.a();
        this.f21904d.p(c.a.t0.r1.b.CAM_X0205);
        this.f21904d.t(n.f(tbPageContext.getPageActivity(), c.a.t0.r1.c.tbds182));
        this.f21904d.y();
        this.f21904d.H(c.a.t0.r1.c.tbfontsize33);
        this.f21904d.B(c.a.t0.r1.b.CAM_X0110);
        this.f21903c.setNextPage(this.f21904d);
        this.f21904d.M(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.f21904d.f();
        this.f21904d.D(tbPageContext.getResources().getString(h.list_no_more));
        c();
        this.a = new b(tbPageContext, this.f21903c);
    }

    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f21902b : (View) invokeV.objValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f21903c;
            if (bdTypeRecyclerView == null) {
                return false;
            }
            return !ListUtils.isEmpty(bdTypeRecyclerView.getData());
        }
        return invokeV.booleanValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            PbListView pbListView = this.f21904d;
            if (pbListView != null) {
                pbListView.F(SkinManager.getColor(c.a.t0.r1.b.CAM_X0107));
                this.f21904d.d(skinType);
            }
            BdTypeRecyclerView bdTypeRecyclerView = this.f21903c;
            if (bdTypeRecyclerView == null || bdTypeRecyclerView.getAdapter() == null) {
                return;
            }
            this.f21903c.getAdapter().notifyDataSetChanged();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f21903c.scrollToPosition(0);
        }
    }

    public void e(List<c.a.d.n.e.n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.f21903c.setData(list);
    }

    public void f(TbPageTag tbPageTag) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, tbPageTag) == null) {
            this.a.a(tbPageTag);
        }
    }

    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            if (z) {
                this.f21903c.setVisibility(0);
            } else {
                this.f21903c.setVisibility(8);
            }
        }
    }

    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            t tVar = new t();
            tVar.a = 401;
            tVar.f16908b = z;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new s());
            this.f21903c.setData(arrayList);
        }
    }
}
