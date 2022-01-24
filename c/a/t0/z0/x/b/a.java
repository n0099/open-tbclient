package c.a.t0.z0.x.b;

import android.widget.BaseAdapter;
import c.a.d.a.f;
import c.a.d.n.e.n;
import c.a.t0.z0.x.c.b;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.tieba.faceshop.emotioncenter.adapter.EmotionCategoryAdapter;
import com.baidu.tieba.faceshop.emotioncenter.adapter.EmotionHorizontalAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public f a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f26080b;

    /* renamed from: c  reason: collision with root package name */
    public final List<c.a.d.n.e.a> f26081c;

    /* renamed from: d  reason: collision with root package name */
    public EmotionCategoryAdapter f26082d;

    /* renamed from: e  reason: collision with root package name */
    public EmotionHorizontalAdapter f26083e;

    /* renamed from: f  reason: collision with root package name */
    public List<n> f26084f;

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
        this.f26081c = new ArrayList();
        this.f26084f = new ArrayList();
        this.a = tbPageContext;
        this.f26080b = bdTypeListView;
        b();
    }

    public void a(List<n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (this.f26080b != null) {
            this.f26084f.addAll(list);
            this.f26080b.setData(this.f26084f);
        }
        c();
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f26082d = new EmotionCategoryAdapter((TbPageContext) this.a, c.a.t0.z0.x.c.a.f26085e);
            this.f26083e = new EmotionHorizontalAdapter((TbPageContext) this.a, b.f26086f);
            this.f26081c.add(this.f26082d);
            this.f26081c.add(this.f26083e);
            this.f26080b.addAdapters(this.f26081c);
        }
    }

    public void c() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (bdTypeListView = this.f26080b) == null || bdTypeListView.getAdapter2() == null || !(this.f26080b.getAdapter2() instanceof BaseAdapter)) {
            return;
        }
        this.f26080b.getAdapter2().notifyDataSetChanged();
    }

    public void d(List<n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (!ListUtils.isEmpty(this.f26084f)) {
            this.f26084f.clear();
        }
        BdTypeListView bdTypeListView = this.f26080b;
        if (bdTypeListView != null) {
            bdTypeListView.setData(list);
            this.f26084f.addAll(list);
        }
        c();
    }

    public void e(EmotionPackageData emotionPackageData) {
        b bVar;
        EmotionPackageData emotionPackageData2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, emotionPackageData) == null) || emotionPackageData == null || ListUtils.isEmpty(this.f26084f)) {
            return;
        }
        for (n nVar : this.f26084f) {
            if ((nVar instanceof b) && (bVar = (b) nVar) != null && (emotionPackageData2 = bVar.f26087e) != null && emotionPackageData2.id == emotionPackageData.id) {
                emotionPackageData2.download = emotionPackageData.download;
                emotionPackageData2.share = emotionPackageData.share;
                c();
                return;
            }
        }
    }
}
