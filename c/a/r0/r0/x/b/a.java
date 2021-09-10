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
    public f f24402a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f24403b;

    /* renamed from: c  reason: collision with root package name */
    public final List<c.a.e.l.e.a> f24404c;

    /* renamed from: d  reason: collision with root package name */
    public EmotionCategoryAdapter f24405d;

    /* renamed from: e  reason: collision with root package name */
    public EmotionHorizontalAdapter f24406e;

    /* renamed from: f  reason: collision with root package name */
    public List<n> f24407f;

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
        this.f24404c = new ArrayList();
        this.f24407f = new ArrayList();
        this.f24402a = tbPageContext;
        this.f24403b = bdTypeListView;
        b();
    }

    public void a(List<n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (this.f24403b != null) {
            this.f24407f.addAll(list);
            this.f24403b.setData(this.f24407f);
        }
        c();
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f24405d = new EmotionCategoryAdapter((TbPageContext) this.f24402a, c.a.r0.r0.x.c.a.f24408e);
            this.f24406e = new EmotionHorizontalAdapter((TbPageContext) this.f24402a, b.f24409f);
            this.f24404c.add(this.f24405d);
            this.f24404c.add(this.f24406e);
            this.f24403b.addAdapters(this.f24404c);
        }
    }

    public void c() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (bdTypeListView = this.f24403b) == null || bdTypeListView.getAdapter2() == null || !(this.f24403b.getAdapter2() instanceof BaseAdapter)) {
            return;
        }
        this.f24403b.getAdapter2().notifyDataSetChanged();
    }

    public void d(List<n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (!ListUtils.isEmpty(this.f24407f)) {
            this.f24407f.clear();
        }
        BdTypeListView bdTypeListView = this.f24403b;
        if (bdTypeListView != null) {
            bdTypeListView.setData(list);
            this.f24407f.addAll(list);
        }
        c();
    }

    public void e(EmotionPackageData emotionPackageData) {
        b bVar;
        EmotionPackageData emotionPackageData2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, emotionPackageData) == null) || emotionPackageData == null || ListUtils.isEmpty(this.f24407f)) {
            return;
        }
        for (n nVar : this.f24407f) {
            if ((nVar instanceof b) && (bVar = (b) nVar) != null && (emotionPackageData2 = bVar.f24410e) != null && emotionPackageData2.id == emotionPackageData.id) {
                emotionPackageData2.download = emotionPackageData.download;
                emotionPackageData2.share = emotionPackageData.share;
                c();
                return;
            }
        }
    }
}
