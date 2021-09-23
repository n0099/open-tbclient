package c.a.r0.l2.g;

import android.view.View;
import c.a.e.l.e.n;
import c.a.q0.u.m;
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
/* loaded from: classes3.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<c.a.e.l.e.a> f22091a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f22092b;

    /* renamed from: c  reason: collision with root package name */
    public HTypeListView f22093c;

    /* renamed from: d  reason: collision with root package name */
    public c f22094d;

    /* renamed from: e  reason: collision with root package name */
    public b f22095e;

    /* renamed from: f  reason: collision with root package name */
    public a f22096f;

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
        this.f22091a = new ArrayList();
        this.f22092b = tbPageContext;
        this.f22093c = hTypeListView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f22094d = new c(this.f22092b, m.f15052h);
            this.f22095e = new b(this.f22092b, c.a.r0.l2.h.c.f22105f);
            this.f22096f = new a(this.f22092b.getPageActivity(), c.a.r0.l2.d.f22074h);
            this.f22091a.add(this.f22094d);
            this.f22091a.add(this.f22095e);
            this.f22091a.add(this.f22096f);
            this.f22093c.addAdapters(this.f22091a);
        }
    }

    public void b() {
        HTypeListView hTypeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (hTypeListView = this.f22093c) != null && (hTypeListView.getAdapter() instanceof TypeAdapter)) {
            ((TypeAdapter) this.f22093c.getAdapter()).notifyDataSetChanged();
        }
    }

    public void c(List<n> list) {
        HTypeListView hTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || (hTypeListView = this.f22093c) == null) {
            return;
        }
        hTypeListView.setData(list);
    }

    public void d(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.f22094d.j0(onClickListener);
            this.f22095e.j0(onClickListener);
        }
    }
}
