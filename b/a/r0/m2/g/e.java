package b.a.r0.m2.g;

import android.view.View;
import b.a.e.m.e.n;
import b.a.q0.u.o;
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
/* loaded from: classes5.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<b.a.e.m.e.a> f22333a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f22334b;

    /* renamed from: c  reason: collision with root package name */
    public HTypeListView f22335c;

    /* renamed from: d  reason: collision with root package name */
    public c f22336d;

    /* renamed from: e  reason: collision with root package name */
    public b f22337e;

    /* renamed from: f  reason: collision with root package name */
    public a f22338f;

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
        this.f22333a = new ArrayList();
        this.f22334b = tbPageContext;
        this.f22335c = hTypeListView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f22336d = new c(this.f22334b, o.f14929h);
            this.f22337e = new b(this.f22334b, b.a.r0.m2.h.c.f22347f);
            this.f22338f = new a(this.f22334b.getPageActivity(), b.a.r0.m2.d.f22316h);
            this.f22333a.add(this.f22336d);
            this.f22333a.add(this.f22337e);
            this.f22333a.add(this.f22338f);
            this.f22335c.addAdapters(this.f22333a);
        }
    }

    public void b() {
        HTypeListView hTypeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (hTypeListView = this.f22335c) != null && (hTypeListView.getAdapter() instanceof TypeAdapter)) {
            ((TypeAdapter) this.f22335c.getAdapter()).notifyDataSetChanged();
        }
    }

    public void c(List<n> list) {
        HTypeListView hTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || (hTypeListView = this.f22335c) == null) {
            return;
        }
        hTypeListView.setData(list);
    }

    public void d(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.f22336d.i0(onClickListener);
            this.f22337e.i0(onClickListener);
        }
    }
}
