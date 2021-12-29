package c.a.t0.y0.x.b;

import android.widget.BaseAdapter;
import c.a.d.a.f;
import c.a.d.n.e.n;
import c.a.t0.y0.x.c.b;
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
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public f a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f26585b;

    /* renamed from: c  reason: collision with root package name */
    public final List<c.a.d.n.e.a> f26586c;

    /* renamed from: d  reason: collision with root package name */
    public EmotionCategoryAdapter f26587d;

    /* renamed from: e  reason: collision with root package name */
    public EmotionHorizontalAdapter f26588e;

    /* renamed from: f  reason: collision with root package name */
    public List<n> f26589f;

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
        this.f26586c = new ArrayList();
        this.f26589f = new ArrayList();
        this.a = tbPageContext;
        this.f26585b = bdTypeListView;
        b();
    }

    public void a(List<n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (this.f26585b != null) {
            this.f26589f.addAll(list);
            this.f26585b.setData(this.f26589f);
        }
        c();
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f26587d = new EmotionCategoryAdapter((TbPageContext) this.a, c.a.t0.y0.x.c.a.f26590e);
            this.f26588e = new EmotionHorizontalAdapter((TbPageContext) this.a, b.f26591f);
            this.f26586c.add(this.f26587d);
            this.f26586c.add(this.f26588e);
            this.f26585b.addAdapters(this.f26586c);
        }
    }

    public void c() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (bdTypeListView = this.f26585b) == null || bdTypeListView.getAdapter2() == null || !(this.f26585b.getAdapter2() instanceof BaseAdapter)) {
            return;
        }
        this.f26585b.getAdapter2().notifyDataSetChanged();
    }

    public void d(List<n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (!ListUtils.isEmpty(this.f26589f)) {
            this.f26589f.clear();
        }
        BdTypeListView bdTypeListView = this.f26585b;
        if (bdTypeListView != null) {
            bdTypeListView.setData(list);
            this.f26589f.addAll(list);
        }
        c();
    }

    public void e(EmotionPackageData emotionPackageData) {
        b bVar;
        EmotionPackageData emotionPackageData2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, emotionPackageData) == null) || emotionPackageData == null || ListUtils.isEmpty(this.f26589f)) {
            return;
        }
        for (n nVar : this.f26589f) {
            if ((nVar instanceof b) && (bVar = (b) nVar) != null && (emotionPackageData2 = bVar.f26592e) != null && emotionPackageData2.id == emotionPackageData.id) {
                emotionPackageData2.download = emotionPackageData.download;
                emotionPackageData2.share = emotionPackageData.share;
                c();
                return;
            }
        }
    }
}
