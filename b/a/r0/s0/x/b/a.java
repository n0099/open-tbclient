package b.a.r0.s0.x.b;

import android.widget.BaseAdapter;
import b.a.e.a.f;
import b.a.e.l.e.n;
import b.a.r0.s0.x.c.b;
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
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public f f23446a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f23447b;

    /* renamed from: c  reason: collision with root package name */
    public final List<b.a.e.l.e.a> f23448c;

    /* renamed from: d  reason: collision with root package name */
    public EmotionCategoryAdapter f23449d;

    /* renamed from: e  reason: collision with root package name */
    public EmotionHorizontalAdapter f23450e;

    /* renamed from: f  reason: collision with root package name */
    public List<n> f23451f;

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
        this.f23448c = new ArrayList();
        this.f23451f = new ArrayList();
        this.f23446a = tbPageContext;
        this.f23447b = bdTypeListView;
        b();
    }

    public void a(List<n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (this.f23447b != null) {
            this.f23451f.addAll(list);
            this.f23447b.setData(this.f23451f);
        }
        c();
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f23449d = new EmotionCategoryAdapter((TbPageContext) this.f23446a, b.a.r0.s0.x.c.a.f23452e);
            this.f23450e = new EmotionHorizontalAdapter((TbPageContext) this.f23446a, b.f23453f);
            this.f23448c.add(this.f23449d);
            this.f23448c.add(this.f23450e);
            this.f23447b.addAdapters(this.f23448c);
        }
    }

    public void c() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (bdTypeListView = this.f23447b) == null || bdTypeListView.getAdapter2() == null || !(this.f23447b.getAdapter2() instanceof BaseAdapter)) {
            return;
        }
        this.f23447b.getAdapter2().notifyDataSetChanged();
    }

    public void d(List<n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (!ListUtils.isEmpty(this.f23451f)) {
            this.f23451f.clear();
        }
        BdTypeListView bdTypeListView = this.f23447b;
        if (bdTypeListView != null) {
            bdTypeListView.setData(list);
            this.f23451f.addAll(list);
        }
        c();
    }

    public void e(EmotionPackageData emotionPackageData) {
        b bVar;
        EmotionPackageData emotionPackageData2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, emotionPackageData) == null) || emotionPackageData == null || ListUtils.isEmpty(this.f23451f)) {
            return;
        }
        for (n nVar : this.f23451f) {
            if ((nVar instanceof b) && (bVar = (b) nVar) != null && (emotionPackageData2 = bVar.f23454e) != null && emotionPackageData2.id == emotionPackageData.id) {
                emotionPackageData2.download = emotionPackageData.download;
                emotionPackageData2.share = emotionPackageData.share;
                c();
                return;
            }
        }
    }
}
