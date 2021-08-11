package c.a.p0.q0.x.b;

import android.widget.BaseAdapter;
import c.a.e.a.f;
import c.a.e.k.e.n;
import c.a.p0.q0.x.c.b;
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
    public f f23496a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f23497b;

    /* renamed from: c  reason: collision with root package name */
    public final List<c.a.e.k.e.a> f23498c;

    /* renamed from: d  reason: collision with root package name */
    public EmotionCategoryAdapter f23499d;

    /* renamed from: e  reason: collision with root package name */
    public EmotionHorizontalAdapter f23500e;

    /* renamed from: f  reason: collision with root package name */
    public List<n> f23501f;

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
        this.f23498c = new ArrayList();
        this.f23501f = new ArrayList();
        this.f23496a = tbPageContext;
        this.f23497b = bdTypeListView;
        b();
    }

    public void a(List<n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (this.f23497b != null) {
            this.f23501f.addAll(list);
            this.f23497b.setData(this.f23501f);
        }
        c();
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f23499d = new EmotionCategoryAdapter((TbPageContext) this.f23496a, c.a.p0.q0.x.c.a.f23502e);
            this.f23500e = new EmotionHorizontalAdapter((TbPageContext) this.f23496a, b.f23503f);
            this.f23498c.add(this.f23499d);
            this.f23498c.add(this.f23500e);
            this.f23497b.addAdapters(this.f23498c);
        }
    }

    public void c() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (bdTypeListView = this.f23497b) == null || bdTypeListView.getAdapter2() == null || !(this.f23497b.getAdapter2() instanceof BaseAdapter)) {
            return;
        }
        this.f23497b.getAdapter2().notifyDataSetChanged();
    }

    public void d(List<n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (!ListUtils.isEmpty(this.f23501f)) {
            this.f23501f.clear();
        }
        BdTypeListView bdTypeListView = this.f23497b;
        if (bdTypeListView != null) {
            bdTypeListView.setData(list);
            this.f23501f.addAll(list);
        }
        c();
    }

    public void e(EmotionPackageData emotionPackageData) {
        b bVar;
        EmotionPackageData emotionPackageData2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, emotionPackageData) == null) || emotionPackageData == null || ListUtils.isEmpty(this.f23501f)) {
            return;
        }
        for (n nVar : this.f23501f) {
            if ((nVar instanceof b) && (bVar = (b) nVar) != null && (emotionPackageData2 = bVar.f23504e) != null && emotionPackageData2.id == emotionPackageData.id) {
                emotionPackageData2.download = emotionPackageData.download;
                emotionPackageData2.share = emotionPackageData.share;
                c();
                return;
            }
        }
    }
}
