package c.a.r0.r0.x.b;

import android.widget.BaseAdapter;
import c.a.e.a.f;
import c.a.e.l.e.n;
import c.a.r0.r0.x.c.b;
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
    public f f24418a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f24419b;

    /* renamed from: c  reason: collision with root package name */
    public final List<c.a.e.l.e.a> f24420c;

    /* renamed from: d  reason: collision with root package name */
    public EmotionCategoryAdapter f24421d;

    /* renamed from: e  reason: collision with root package name */
    public EmotionHorizontalAdapter f24422e;

    /* renamed from: f  reason: collision with root package name */
    public List<n> f24423f;

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
        this.f24420c = new ArrayList();
        this.f24423f = new ArrayList();
        this.f24418a = tbPageContext;
        this.f24419b = bdTypeListView;
        b();
    }

    public void a(List<n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (this.f24419b != null) {
            this.f24423f.addAll(list);
            this.f24419b.setData(this.f24423f);
        }
        c();
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f24421d = new EmotionCategoryAdapter((TbPageContext) this.f24418a, c.a.r0.r0.x.c.a.f24424e);
            this.f24422e = new EmotionHorizontalAdapter((TbPageContext) this.f24418a, b.f24425f);
            this.f24420c.add(this.f24421d);
            this.f24420c.add(this.f24422e);
            this.f24419b.addAdapters(this.f24420c);
        }
    }

    public void c() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (bdTypeListView = this.f24419b) == null || bdTypeListView.getAdapter2() == null || !(this.f24419b.getAdapter2() instanceof BaseAdapter)) {
            return;
        }
        this.f24419b.getAdapter2().notifyDataSetChanged();
    }

    public void d(List<n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (!ListUtils.isEmpty(this.f24423f)) {
            this.f24423f.clear();
        }
        BdTypeListView bdTypeListView = this.f24419b;
        if (bdTypeListView != null) {
            bdTypeListView.setData(list);
            this.f24423f.addAll(list);
        }
        c();
    }

    public void e(EmotionPackageData emotionPackageData) {
        b bVar;
        EmotionPackageData emotionPackageData2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, emotionPackageData) == null) || emotionPackageData == null || ListUtils.isEmpty(this.f24423f)) {
            return;
        }
        for (n nVar : this.f24423f) {
            if ((nVar instanceof b) && (bVar = (b) nVar) != null && (emotionPackageData2 = bVar.f24426e) != null && emotionPackageData2.id == emotionPackageData.id) {
                emotionPackageData2.download = emotionPackageData.download;
                emotionPackageData2.share = emotionPackageData.share;
                c();
                return;
            }
        }
    }
}
