package c.a.q0.q0.x.b;

import android.widget.BaseAdapter;
import c.a.e.a.f;
import c.a.e.l.e.n;
import c.a.q0.q0.x.c.b;
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
    public f f23828a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f23829b;

    /* renamed from: c  reason: collision with root package name */
    public final List<c.a.e.l.e.a> f23830c;

    /* renamed from: d  reason: collision with root package name */
    public EmotionCategoryAdapter f23831d;

    /* renamed from: e  reason: collision with root package name */
    public EmotionHorizontalAdapter f23832e;

    /* renamed from: f  reason: collision with root package name */
    public List<n> f23833f;

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
        this.f23830c = new ArrayList();
        this.f23833f = new ArrayList();
        this.f23828a = tbPageContext;
        this.f23829b = bdTypeListView;
        b();
    }

    public void a(List<n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (this.f23829b != null) {
            this.f23833f.addAll(list);
            this.f23829b.setData(this.f23833f);
        }
        c();
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f23831d = new EmotionCategoryAdapter((TbPageContext) this.f23828a, c.a.q0.q0.x.c.a.f23834e);
            this.f23832e = new EmotionHorizontalAdapter((TbPageContext) this.f23828a, b.f23835f);
            this.f23830c.add(this.f23831d);
            this.f23830c.add(this.f23832e);
            this.f23829b.addAdapters(this.f23830c);
        }
    }

    public void c() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (bdTypeListView = this.f23829b) == null || bdTypeListView.getAdapter2() == null || !(this.f23829b.getAdapter2() instanceof BaseAdapter)) {
            return;
        }
        this.f23829b.getAdapter2().notifyDataSetChanged();
    }

    public void d(List<n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (!ListUtils.isEmpty(this.f23833f)) {
            this.f23833f.clear();
        }
        BdTypeListView bdTypeListView = this.f23829b;
        if (bdTypeListView != null) {
            bdTypeListView.setData(list);
            this.f23833f.addAll(list);
        }
        c();
    }

    public void e(EmotionPackageData emotionPackageData) {
        b bVar;
        EmotionPackageData emotionPackageData2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, emotionPackageData) == null) || emotionPackageData == null || ListUtils.isEmpty(this.f23833f)) {
            return;
        }
        for (n nVar : this.f23833f) {
            if ((nVar instanceof b) && (bVar = (b) nVar) != null && (emotionPackageData2 = bVar.f23836e) != null && emotionPackageData2.id == emotionPackageData.id) {
                emotionPackageData2.download = emotionPackageData.download;
                emotionPackageData2.share = emotionPackageData.share;
                c();
                return;
            }
        }
    }
}
