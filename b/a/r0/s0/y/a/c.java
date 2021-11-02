package b.a.r0.s0.y.a;

import android.widget.BaseAdapter;
import b.a.e.l.e.n;
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
/* loaded from: classes5.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f23469a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f23470b;

    /* renamed from: c  reason: collision with root package name */
    public final List<b.a.e.l.e.a> f23471c;

    /* renamed from: d  reason: collision with root package name */
    public b f23472d;

    /* renamed from: e  reason: collision with root package name */
    public d f23473e;

    /* renamed from: f  reason: collision with root package name */
    public final List<n> f23474f;

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
        this.f23471c = new ArrayList();
        this.f23474f = new ArrayList();
        this.f23469a = tbPageContext;
        this.f23470b = bdTypeListView;
        c(forumEmotionModel);
    }

    public void a(List<n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (this.f23470b != null) {
            this.f23474f.addAll(list);
            this.f23470b.setData(this.f23474f);
        }
        d();
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f23474f.size() : invokeV.intValue;
    }

    public final void c(ForumEmotionModel forumEmotionModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, forumEmotionModel) == null) {
            b bVar = new b(this.f23469a, forumEmotionModel.y(), b.a.r0.s0.y.b.c.f23478f);
            this.f23472d = bVar;
            this.f23471c.add(bVar);
            d dVar = new d(this.f23469a, forumEmotionModel.y(), b.a.r0.s0.y.b.a.f23475e);
            this.f23473e = dVar;
            this.f23471c.add(dVar);
            this.f23470b.addAdapters(this.f23471c);
        }
    }

    public void d() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (bdTypeListView = this.f23470b) == null || bdTypeListView.getAdapter2() == null || !(this.f23470b.getAdapter2() instanceof BaseAdapter)) {
            return;
        }
        this.f23470b.getAdapter2().notifyDataSetChanged();
    }

    public void e(List<n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (!ListUtils.isEmpty(this.f23474f)) {
            this.f23474f.clear();
        }
        BdTypeListView bdTypeListView = this.f23470b;
        if (bdTypeListView != null) {
            bdTypeListView.setData(list);
            this.f23474f.addAll(list);
        }
        d();
    }

    public void f(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            this.f23472d.i0(aVar);
            this.f23473e.i0(aVar);
        }
    }

    public void g(ForumEmotionPackageData forumEmotionPackageData) {
        ForumEmotionPackageData forumEmotionPackageData2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, forumEmotionPackageData) == null) || forumEmotionPackageData == null || ListUtils.isEmpty(this.f23474f)) {
            return;
        }
        for (n nVar : this.f23474f) {
            if (nVar != null && (nVar instanceof b.a.r0.s0.y.b.c) && (forumEmotionPackageData2 = ((b.a.r0.s0.y.b.c) nVar).f23479e) != null && forumEmotionPackageData2.id == forumEmotionPackageData.id) {
                forumEmotionPackageData2.download = forumEmotionPackageData.download;
                forumEmotionPackageData2.share = forumEmotionPackageData.share;
                d();
                return;
            }
        }
    }
}
