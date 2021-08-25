package c.a.q0.n2.c;

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
/* loaded from: classes3.dex */
public class o {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public f f22487a;

    /* renamed from: b  reason: collision with root package name */
    public l f22488b;

    /* renamed from: c  reason: collision with root package name */
    public g f22489c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.q0.k2.g.a f22490d;

    /* renamed from: e  reason: collision with root package name */
    public List<c.a.e.l.e.a> f22491e;

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
        this.f22491e = new ArrayList();
        this.f22487a = new f(tbPageContext, c.a.q0.n2.e.o.f22656g);
        this.f22488b = new l(tbPageContext);
        this.f22489c = new g(tbPageContext, c.a.q0.n2.e.h.f22633g);
        this.f22490d = new c.a.q0.k2.g.a(tbPageContext.getPageActivity(), c.a.q0.k2.d.f21480h);
        this.f22491e.add(this.f22487a);
        this.f22491e.add(this.f22488b);
        this.f22491e.add(this.f22489c);
        this.f22491e.add(this.f22490d);
        hTypeListView.addAdapters(this.f22491e);
    }

    public void a(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
            this.f22487a.j0(onClickListener);
        }
    }

    public void b(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onClickListener) == null) {
            this.f22489c.j0(onClickListener);
        }
    }
}
