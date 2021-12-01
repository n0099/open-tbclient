package c.a.r0.y0.x.b;

import android.widget.BaseAdapter;
import c.a.d.a.f;
import c.a.d.m.e.n;
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
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public f a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f25692b;

    /* renamed from: c  reason: collision with root package name */
    public final List<c.a.d.m.e.a> f25693c;

    /* renamed from: d  reason: collision with root package name */
    public EmotionCategoryAdapter f25694d;

    /* renamed from: e  reason: collision with root package name */
    public EmotionHorizontalAdapter f25695e;

    /* renamed from: f  reason: collision with root package name */
    public List<n> f25696f;

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
        this.f25693c = new ArrayList();
        this.f25696f = new ArrayList();
        this.a = tbPageContext;
        this.f25692b = bdTypeListView;
        b();
    }

    public void a(List<n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (this.f25692b != null) {
            this.f25696f.addAll(list);
            this.f25692b.setData(this.f25696f);
        }
        c();
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f25694d = new EmotionCategoryAdapter((TbPageContext) this.a, c.a.r0.y0.x.c.a.f25697e);
            this.f25695e = new EmotionHorizontalAdapter((TbPageContext) this.a, b.f25698f);
            this.f25693c.add(this.f25694d);
            this.f25693c.add(this.f25695e);
            this.f25692b.addAdapters(this.f25693c);
        }
    }

    public void c() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (bdTypeListView = this.f25692b) == null || bdTypeListView.getAdapter2() == null || !(this.f25692b.getAdapter2() instanceof BaseAdapter)) {
            return;
        }
        this.f25692b.getAdapter2().notifyDataSetChanged();
    }

    public void d(List<n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (!ListUtils.isEmpty(this.f25696f)) {
            this.f25696f.clear();
        }
        BdTypeListView bdTypeListView = this.f25692b;
        if (bdTypeListView != null) {
            bdTypeListView.setData(list);
            this.f25696f.addAll(list);
        }
        c();
    }

    public void e(EmotionPackageData emotionPackageData) {
        b bVar;
        EmotionPackageData emotionPackageData2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, emotionPackageData) == null) || emotionPackageData == null || ListUtils.isEmpty(this.f25696f)) {
            return;
        }
        for (n nVar : this.f25696f) {
            if ((nVar instanceof b) && (bVar = (b) nVar) != null && (emotionPackageData2 = bVar.f25699e) != null && emotionPackageData2.id == emotionPackageData.id) {
                emotionPackageData2.download = emotionPackageData.download;
                emotionPackageData2.share = emotionPackageData.share;
                c();
                return;
            }
        }
    }
}
