package c.a.s0.u2.g;

import android.view.View;
import c.a.r0.u.n;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<c.a.d.m.e.a> a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f24603b;

    /* renamed from: c  reason: collision with root package name */
    public HTypeListView f24604c;

    /* renamed from: d  reason: collision with root package name */
    public c f24605d;

    /* renamed from: e  reason: collision with root package name */
    public b f24606e;

    /* renamed from: f  reason: collision with root package name */
    public a f24607f;

    public e(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, hTypeListView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ArrayList();
        this.f24603b = tbPageContext;
        this.f24604c = hTypeListView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f24605d = new c(this.f24603b, n.f13995h);
            this.f24606e = new b(this.f24603b, c.a.s0.u2.h.c.f24615f);
            this.f24607f = new a(this.f24603b.getPageActivity(), c.a.s0.u2.d.f24589h);
            this.a.add(this.f24605d);
            this.a.add(this.f24606e);
            this.a.add(this.f24607f);
            this.f24604c.addAdapters(this.a);
        }
    }

    public void b() {
        HTypeListView hTypeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (hTypeListView = this.f24604c) != null && (hTypeListView.getAdapter() instanceof TypeAdapter)) {
            ((TypeAdapter) this.f24604c.getAdapter()).notifyDataSetChanged();
        }
    }

    public void c(List<c.a.d.m.e.n> list) {
        HTypeListView hTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || (hTypeListView = this.f24604c) == null) {
            return;
        }
        hTypeListView.setData(list);
    }

    public void d(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.f24605d.i0(onClickListener);
            this.f24606e.i0(onClickListener);
        }
    }
}
