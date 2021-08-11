package c.a.p0.q0.y.a;

import android.widget.BaseAdapter;
import c.a.e.k.e.n;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.faceshop.forumpackage.data.ForumEmotionPackageData;
import com.baidu.tieba.faceshop.forumpackage.model.ForumEmotionModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f23521a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f23522b;

    /* renamed from: c  reason: collision with root package name */
    public final List<c.a.e.k.e.a> f23523c;

    /* renamed from: d  reason: collision with root package name */
    public b f23524d;

    /* renamed from: e  reason: collision with root package name */
    public d f23525e;

    /* renamed from: f  reason: collision with root package name */
    public final List<n> f23526f;

    public c(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, ForumEmotionModel forumEmotionModel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeListView, forumEmotionModel};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f23523c = new ArrayList();
        this.f23526f = new ArrayList();
        this.f23521a = tbPageContext;
        this.f23522b = bdTypeListView;
        c(forumEmotionModel);
    }

    public void a(List<n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (this.f23522b != null) {
            this.f23526f.addAll(list);
            this.f23522b.setData(this.f23526f);
        }
        d();
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f23526f.size() : invokeV.intValue;
    }

    public final void c(ForumEmotionModel forumEmotionModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, forumEmotionModel) == null) {
            b bVar = new b(this.f23521a, forumEmotionModel.y(), c.a.p0.q0.y.b.c.f23530f);
            this.f23524d = bVar;
            this.f23523c.add(bVar);
            d dVar = new d(this.f23521a, forumEmotionModel.y(), c.a.p0.q0.y.b.a.f23527e);
            this.f23525e = dVar;
            this.f23523c.add(dVar);
            this.f23522b.addAdapters(this.f23523c);
        }
    }

    public void d() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (bdTypeListView = this.f23522b) == null || bdTypeListView.getAdapter2() == null || !(this.f23522b.getAdapter2() instanceof BaseAdapter)) {
            return;
        }
        this.f23522b.getAdapter2().notifyDataSetChanged();
    }

    public void e(List<n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (!ListUtils.isEmpty(this.f23526f)) {
            this.f23526f.clear();
        }
        BdTypeListView bdTypeListView = this.f23522b;
        if (bdTypeListView != null) {
            bdTypeListView.setData(list);
            this.f23526f.addAll(list);
        }
        d();
    }

    public void f(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            this.f23524d.j0(aVar);
            this.f23525e.j0(aVar);
        }
    }

    public void g(ForumEmotionPackageData forumEmotionPackageData) {
        ForumEmotionPackageData forumEmotionPackageData2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, forumEmotionPackageData) == null) || forumEmotionPackageData == null || ListUtils.isEmpty(this.f23526f)) {
            return;
        }
        for (n nVar : this.f23526f) {
            if (nVar != null && (nVar instanceof c.a.p0.q0.y.b.c) && (forumEmotionPackageData2 = ((c.a.p0.q0.y.b.c) nVar).f23531e) != null && forumEmotionPackageData2.id == forumEmotionPackageData.id) {
                forumEmotionPackageData2.download = forumEmotionPackageData.download;
                forumEmotionPackageData2.share = forumEmotionPackageData.share;
                d();
                return;
            }
        }
    }
}
