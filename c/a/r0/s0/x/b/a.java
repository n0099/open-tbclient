package c.a.r0.s0.x.b;

import android.widget.BaseAdapter;
import c.a.e.a.f;
import c.a.e.l.e.n;
import c.a.r0.s0.x.c.b;
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

    /* renamed from: a  reason: collision with root package name */
    public f f24593a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f24594b;

    /* renamed from: c  reason: collision with root package name */
    public final List<c.a.e.l.e.a> f24595c;

    /* renamed from: d  reason: collision with root package name */
    public EmotionCategoryAdapter f24596d;

    /* renamed from: e  reason: collision with root package name */
    public EmotionHorizontalAdapter f24597e;

    /* renamed from: f  reason: collision with root package name */
    public List<n> f24598f;

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
        this.f24595c = new ArrayList();
        this.f24598f = new ArrayList();
        this.f24593a = tbPageContext;
        this.f24594b = bdTypeListView;
        b();
    }

    public void a(List<n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (this.f24594b != null) {
            this.f24598f.addAll(list);
            this.f24594b.setData(this.f24598f);
        }
        c();
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f24596d = new EmotionCategoryAdapter((TbPageContext) this.f24593a, c.a.r0.s0.x.c.a.f24599e);
            this.f24597e = new EmotionHorizontalAdapter((TbPageContext) this.f24593a, b.f24600f);
            this.f24595c.add(this.f24596d);
            this.f24595c.add(this.f24597e);
            this.f24594b.addAdapters(this.f24595c);
        }
    }

    public void c() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (bdTypeListView = this.f24594b) == null || bdTypeListView.getAdapter2() == null || !(this.f24594b.getAdapter2() instanceof BaseAdapter)) {
            return;
        }
        this.f24594b.getAdapter2().notifyDataSetChanged();
    }

    public void d(List<n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (!ListUtils.isEmpty(this.f24598f)) {
            this.f24598f.clear();
        }
        BdTypeListView bdTypeListView = this.f24594b;
        if (bdTypeListView != null) {
            bdTypeListView.setData(list);
            this.f24598f.addAll(list);
        }
        c();
    }

    public void e(EmotionPackageData emotionPackageData) {
        b bVar;
        EmotionPackageData emotionPackageData2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, emotionPackageData) == null) || emotionPackageData == null || ListUtils.isEmpty(this.f24598f)) {
            return;
        }
        for (n nVar : this.f24598f) {
            if ((nVar instanceof b) && (bVar = (b) nVar) != null && (emotionPackageData2 = bVar.f24601e) != null && emotionPackageData2.id == emotionPackageData.id) {
                emotionPackageData2.download = emotionPackageData.download;
                emotionPackageData2.share = emotionPackageData.share;
                c();
                return;
            }
        }
    }
}
