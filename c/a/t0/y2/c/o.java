package c.a.t0.y2.c;

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
/* loaded from: classes9.dex */
public class o {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public f a;

    /* renamed from: b  reason: collision with root package name */
    public l f25596b;

    /* renamed from: c  reason: collision with root package name */
    public g f25597c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.t0.v2.g.a f25598d;

    /* renamed from: e  reason: collision with root package name */
    public List<c.a.d.n.e.a> f25599e;

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
        this.f25599e = new ArrayList();
        this.a = new f(tbPageContext, c.a.t0.y2.e.o.f25735g);
        this.f25596b = new l(tbPageContext);
        this.f25597c = new g(tbPageContext, c.a.t0.y2.e.h.f25713g);
        this.f25598d = new c.a.t0.v2.g.a(tbPageContext.getPageActivity(), c.a.t0.v2.d.f24697h);
        this.f25599e.add(this.a);
        this.f25599e.add(this.f25596b);
        this.f25599e.add(this.f25597c);
        this.f25599e.add(this.f25598d);
        hTypeListView.addAdapters(this.f25599e);
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
            this.f25597c.b0(onClickListener);
        }
    }
}
