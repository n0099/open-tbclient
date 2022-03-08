package c.a.r0.y0.x.b;

import android.widget.BaseAdapter;
import c.a.d.a.f;
import c.a.d.o.e.n;
import c.a.r0.y0.x.c.b;
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
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public f a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f24846b;

    /* renamed from: c  reason: collision with root package name */
    public final List<c.a.d.o.e.a> f24847c;

    /* renamed from: d  reason: collision with root package name */
    public EmotionCategoryAdapter f24848d;

    /* renamed from: e  reason: collision with root package name */
    public EmotionHorizontalAdapter f24849e;

    /* renamed from: f  reason: collision with root package name */
    public List<n> f24850f;

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
        this.f24847c = new ArrayList();
        this.f24850f = new ArrayList();
        this.a = tbPageContext;
        this.f24846b = bdTypeListView;
        b();
    }

    public void a(List<n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (this.f24846b != null) {
            this.f24850f.addAll(list);
            this.f24846b.setData(this.f24850f);
        }
        c();
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f24848d = new EmotionCategoryAdapter((TbPageContext) this.a, c.a.r0.y0.x.c.a.f24851e);
            this.f24849e = new EmotionHorizontalAdapter((TbPageContext) this.a, b.f24852f);
            this.f24847c.add(this.f24848d);
            this.f24847c.add(this.f24849e);
            this.f24846b.addAdapters(this.f24847c);
        }
    }

    public void c() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (bdTypeListView = this.f24846b) == null || bdTypeListView.getAdapter2() == null || !(this.f24846b.getAdapter2() instanceof BaseAdapter)) {
            return;
        }
        this.f24846b.getAdapter2().notifyDataSetChanged();
    }

    public void d(List<n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (!ListUtils.isEmpty(this.f24850f)) {
            this.f24850f.clear();
        }
        BdTypeListView bdTypeListView = this.f24846b;
        if (bdTypeListView != null) {
            bdTypeListView.setData(list);
            this.f24850f.addAll(list);
        }
        c();
    }

    public void e(EmotionPackageData emotionPackageData) {
        b bVar;
        EmotionPackageData emotionPackageData2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, emotionPackageData) == null) || emotionPackageData == null || ListUtils.isEmpty(this.f24850f)) {
            return;
        }
        for (n nVar : this.f24850f) {
            if ((nVar instanceof b) && (bVar = (b) nVar) != null && (emotionPackageData2 = bVar.f24853e) != null && emotionPackageData2.id == emotionPackageData.id) {
                emotionPackageData2.download = emotionPackageData.download;
                emotionPackageData2.share = emotionPackageData.share;
                c();
                return;
            }
        }
    }
}
