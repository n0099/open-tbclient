package c.a.r0.s0.y.a;

import android.widget.BaseAdapter;
import c.a.e.l.e.n;
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
    public TbPageContext f24618a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f24619b;

    /* renamed from: c  reason: collision with root package name */
    public final List<c.a.e.l.e.a> f24620c;

    /* renamed from: d  reason: collision with root package name */
    public b f24621d;

    /* renamed from: e  reason: collision with root package name */
    public d f24622e;

    /* renamed from: f  reason: collision with root package name */
    public final List<n> f24623f;

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
        this.f24620c = new ArrayList();
        this.f24623f = new ArrayList();
        this.f24618a = tbPageContext;
        this.f24619b = bdTypeListView;
        c(forumEmotionModel);
    }

    public void a(List<n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (this.f24619b != null) {
            this.f24623f.addAll(list);
            this.f24619b.setData(this.f24623f);
        }
        d();
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f24623f.size() : invokeV.intValue;
    }

    public final void c(ForumEmotionModel forumEmotionModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, forumEmotionModel) == null) {
            b bVar = new b(this.f24618a, forumEmotionModel.y(), c.a.r0.s0.y.b.c.f24627f);
            this.f24621d = bVar;
            this.f24620c.add(bVar);
            d dVar = new d(this.f24618a, forumEmotionModel.y(), c.a.r0.s0.y.b.a.f24624e);
            this.f24622e = dVar;
            this.f24620c.add(dVar);
            this.f24619b.addAdapters(this.f24620c);
        }
    }

    public void d() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (bdTypeListView = this.f24619b) == null || bdTypeListView.getAdapter2() == null || !(this.f24619b.getAdapter2() instanceof BaseAdapter)) {
            return;
        }
        this.f24619b.getAdapter2().notifyDataSetChanged();
    }

    public void e(List<n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (!ListUtils.isEmpty(this.f24623f)) {
            this.f24623f.clear();
        }
        BdTypeListView bdTypeListView = this.f24619b;
        if (bdTypeListView != null) {
            bdTypeListView.setData(list);
            this.f24623f.addAll(list);
        }
        d();
    }

    public void f(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            this.f24621d.j0(aVar);
            this.f24622e.j0(aVar);
        }
    }

    public void g(ForumEmotionPackageData forumEmotionPackageData) {
        ForumEmotionPackageData forumEmotionPackageData2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, forumEmotionPackageData) == null) || forumEmotionPackageData == null || ListUtils.isEmpty(this.f24623f)) {
            return;
        }
        for (n nVar : this.f24623f) {
            if (nVar != null && (nVar instanceof c.a.r0.s0.y.b.c) && (forumEmotionPackageData2 = ((c.a.r0.s0.y.b.c) nVar).f24628e) != null && forumEmotionPackageData2.id == forumEmotionPackageData.id) {
                forumEmotionPackageData2.download = forumEmotionPackageData.download;
                forumEmotionPackageData2.share = forumEmotionPackageData.share;
                d();
                return;
            }
        }
    }
}
