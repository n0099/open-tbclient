package c.a.p0.a1.y.b;

import android.widget.BaseAdapter;
import c.a.d.a.f;
import c.a.d.o.e.n;
import c.a.p0.a1.y.c.b;
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
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public f a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f12074b;

    /* renamed from: c  reason: collision with root package name */
    public final List<c.a.d.o.e.a> f12075c;

    /* renamed from: d  reason: collision with root package name */
    public EmotionCategoryAdapter f12076d;

    /* renamed from: e  reason: collision with root package name */
    public EmotionHorizontalAdapter f12077e;

    /* renamed from: f  reason: collision with root package name */
    public List<n> f12078f;

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeListView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f12075c = new ArrayList();
        this.f12078f = new ArrayList();
        this.a = tbPageContext;
        this.f12074b = bdTypeListView;
        b();
    }

    public void a(List<n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (this.f12074b != null) {
            this.f12078f.addAll(list);
            this.f12074b.setData(this.f12078f);
        }
        c();
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f12076d = new EmotionCategoryAdapter((TbPageContext) this.a, c.a.p0.a1.y.c.a.a);
            this.f12077e = new EmotionHorizontalAdapter((TbPageContext) this.a, b.f12079b);
            this.f12075c.add(this.f12076d);
            this.f12075c.add(this.f12077e);
            this.f12074b.a(this.f12075c);
        }
    }

    public void c() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (bdTypeListView = this.f12074b) == null || bdTypeListView.getAdapter2() == null || !(this.f12074b.getAdapter2() instanceof BaseAdapter)) {
            return;
        }
        this.f12074b.getAdapter2().notifyDataSetChanged();
    }

    public void d(List<n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (!ListUtils.isEmpty(this.f12078f)) {
            this.f12078f.clear();
        }
        BdTypeListView bdTypeListView = this.f12074b;
        if (bdTypeListView != null) {
            bdTypeListView.setData(list);
            this.f12078f.addAll(list);
        }
        c();
    }

    public void e(EmotionPackageData emotionPackageData) {
        b bVar;
        EmotionPackageData emotionPackageData2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, emotionPackageData) == null) || emotionPackageData == null || ListUtils.isEmpty(this.f12078f)) {
            return;
        }
        for (n nVar : this.f12078f) {
            if ((nVar instanceof b) && (bVar = (b) nVar) != null && (emotionPackageData2 = bVar.a) != null && emotionPackageData2.id == emotionPackageData.id) {
                emotionPackageData2.download = emotionPackageData.download;
                emotionPackageData2.share = emotionPackageData.share;
                c();
                return;
            }
        }
    }
}
