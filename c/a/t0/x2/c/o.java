package c.a.t0.x2.c;

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
/* loaded from: classes8.dex */
public class o {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public f a;

    /* renamed from: b  reason: collision with root package name */
    public l f25315b;

    /* renamed from: c  reason: collision with root package name */
    public g f25316c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.t0.u2.g.a f25317d;

    /* renamed from: e  reason: collision with root package name */
    public List<c.a.d.n.e.a> f25318e;

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
        this.f25318e = new ArrayList();
        this.a = new f(tbPageContext, c.a.t0.x2.e.o.f25454g);
        this.f25315b = new l(tbPageContext);
        this.f25316c = new g(tbPageContext, c.a.t0.x2.e.h.f25432g);
        this.f25317d = new c.a.t0.u2.g.a(tbPageContext.getPageActivity(), c.a.t0.u2.d.f24408h);
        this.f25318e.add(this.a);
        this.f25318e.add(this.f25315b);
        this.f25318e.add(this.f25316c);
        this.f25318e.add(this.f25317d);
        hTypeListView.addAdapters(this.f25318e);
    }

    public void a(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
            this.a.b0(onClickListener);
        }
    }

    public void b(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onClickListener) == null) {
            this.f25316c.b0(onClickListener);
        }
    }
}
