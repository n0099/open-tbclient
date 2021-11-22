package b.a.r0.s0.x.b;

import android.widget.BaseAdapter;
import b.a.e.a.f;
import b.a.e.m.e.n;
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
    public f f24777a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f24778b;

    /* renamed from: c  reason: collision with root package name */
    public final List<b.a.e.m.e.a> f24779c;

    /* renamed from: d  reason: collision with root package name */
    public EmotionCategoryAdapter f24780d;

    /* renamed from: e  reason: collision with root package name */
    public EmotionHorizontalAdapter f24781e;

    /* renamed from: f  reason: collision with root package name */
    public List<n> f24782f;

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
        this.f24779c = new ArrayList();
        this.f24782f = new ArrayList();
        this.f24777a = tbPageContext;
        this.f24778b = bdTypeListView;
        b();
    }

    public void a(List<n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (this.f24778b != null) {
            this.f24782f.addAll(list);
            this.f24778b.setData(this.f24782f);
        }
        c();
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f24780d = new EmotionCategoryAdapter((TbPageContext) this.f24777a, b.a.r0.s0.x.c.a.f24783e);
            this.f24781e = new EmotionHorizontalAdapter((TbPageContext) this.f24777a, b.f24784f);
            this.f24779c.add(this.f24780d);
            this.f24779c.add(this.f24781e);
            this.f24778b.addAdapters(this.f24779c);
        }
    }

    public void c() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (bdTypeListView = this.f24778b) == null || bdTypeListView.getAdapter2() == null || !(this.f24778b.getAdapter2() instanceof BaseAdapter)) {
            return;
        }
        this.f24778b.getAdapter2().notifyDataSetChanged();
    }

    public void d(List<n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (!ListUtils.isEmpty(this.f24782f)) {
            this.f24782f.clear();
        }
        BdTypeListView bdTypeListView = this.f24778b;
        if (bdTypeListView != null) {
            bdTypeListView.setData(list);
            this.f24782f.addAll(list);
        }
        c();
    }

    public void e(EmotionPackageData emotionPackageData) {
        b bVar;
        EmotionPackageData emotionPackageData2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, emotionPackageData) == null) || emotionPackageData == null || ListUtils.isEmpty(this.f24782f)) {
            return;
        }
        for (n nVar : this.f24782f) {
            if ((nVar instanceof b) && (bVar = (b) nVar) != null && (emotionPackageData2 = bVar.f24785e) != null && emotionPackageData2.id == emotionPackageData.id) {
                emotionPackageData2.download = emotionPackageData.download;
                emotionPackageData2.share = emotionPackageData.share;
                c();
                return;
            }
        }
    }
}
