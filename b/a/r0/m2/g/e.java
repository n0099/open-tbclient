package b.a.r0.m2.g;

import android.view.View;
import b.a.e.l.e.n;
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
    public List<b.a.e.l.e.a> f21178a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f21179b;

    /* renamed from: c  reason: collision with root package name */
    public HTypeListView f21180c;

    /* renamed from: d  reason: collision with root package name */
    public c f21181d;

    /* renamed from: e  reason: collision with root package name */
    public b f21182e;

    /* renamed from: f  reason: collision with root package name */
    public a f21183f;

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
        this.f21178a = new ArrayList();
        this.f21179b = tbPageContext;
        this.f21180c = hTypeListView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f21181d = new c(this.f21179b, o.f14162h);
            this.f21182e = new b(this.f21179b, b.a.r0.m2.h.c.f21192f);
            this.f21183f = new a(this.f21179b.getPageActivity(), b.a.r0.m2.d.f21161h);
            this.f21178a.add(this.f21181d);
            this.f21178a.add(this.f21182e);
            this.f21178a.add(this.f21183f);
            this.f21180c.addAdapters(this.f21178a);
        }
    }

    public void b() {
        HTypeListView hTypeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (hTypeListView = this.f21180c) != null && (hTypeListView.getAdapter() instanceof TypeAdapter)) {
            ((TypeAdapter) this.f21180c.getAdapter()).notifyDataSetChanged();
        }
    }

    public void c(List<n> list) {
        HTypeListView hTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || (hTypeListView = this.f21180c) == null) {
            return;
        }
        hTypeListView.setData(list);
    }

    public void d(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.f21181d.i0(onClickListener);
            this.f21182e.i0(onClickListener);
        }
    }
}
