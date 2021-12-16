package c.a.s0.x2.c;

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
    public l f25597b;

    /* renamed from: c  reason: collision with root package name */
    public g f25598c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.s0.u2.g.a f25599d;

    /* renamed from: e  reason: collision with root package name */
    public List<c.a.d.m.e.a> f25600e;

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
        this.f25600e = new ArrayList();
        this.a = new f(tbPageContext, c.a.s0.x2.e.o.f25745g);
        this.f25597b = new l(tbPageContext);
        this.f25598c = new g(tbPageContext, c.a.s0.x2.e.h.f25723g);
        this.f25599d = new c.a.s0.u2.g.a(tbPageContext.getPageActivity(), c.a.s0.u2.d.f24589h);
        this.f25600e.add(this.a);
        this.f25600e.add(this.f25597b);
        this.f25600e.add(this.f25598c);
        this.f25600e.add(this.f25599d);
        hTypeListView.addAdapters(this.f25600e);
    }

    public void a(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
            this.a.i0(onClickListener);
        }
    }

    public void b(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onClickListener) == null) {
            this.f25598c.i0(onClickListener);
        }
    }
}
