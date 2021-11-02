package b.a.r0.p2.c;

import android.view.View;
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
public class o {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public f f22167a;

    /* renamed from: b  reason: collision with root package name */
    public l f22168b;

    /* renamed from: c  reason: collision with root package name */
    public g f22169c;

    /* renamed from: d  reason: collision with root package name */
    public b.a.r0.m2.g.a f22170d;

    /* renamed from: e  reason: collision with root package name */
    public List<b.a.e.l.e.a> f22171e;

    public o(TbPageContext tbPageContext, HTypeListView hTypeListView) {
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
        this.f22171e = new ArrayList();
        this.f22167a = new f(tbPageContext, b.a.r0.p2.e.o.f22326g);
        this.f22168b = new l(tbPageContext);
        this.f22169c = new g(tbPageContext, b.a.r0.p2.e.h.f22303g);
        this.f22170d = new b.a.r0.m2.g.a(tbPageContext.getPageActivity(), b.a.r0.m2.d.f21161h);
        this.f22171e.add(this.f22167a);
        this.f22171e.add(this.f22168b);
        this.f22171e.add(this.f22169c);
        this.f22171e.add(this.f22170d);
        hTypeListView.addAdapters(this.f22171e);
    }

    public void a(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
            this.f22167a.i0(onClickListener);
        }
    }

    public void b(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onClickListener) == null) {
            this.f22169c.i0(onClickListener);
        }
    }
}
