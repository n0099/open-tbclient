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
    public f f23644a;

    /* renamed from: b  reason: collision with root package name */
    public l f23645b;

    /* renamed from: c  reason: collision with root package name */
    public g f23646c;

    /* renamed from: d  reason: collision with root package name */
    public b.a.r0.m2.g.a f23647d;

    /* renamed from: e  reason: collision with root package name */
    public List<b.a.e.m.e.a> f23648e;

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
        this.f23648e = new ArrayList();
        this.f23644a = new f(tbPageContext, b.a.r0.p2.e.o.f23803g);
        this.f23645b = new l(tbPageContext);
        this.f23646c = new g(tbPageContext, b.a.r0.p2.e.h.f23780g);
        this.f23647d = new b.a.r0.m2.g.a(tbPageContext.getPageActivity(), b.a.r0.m2.d.f22316h);
        this.f23648e.add(this.f23644a);
        this.f23648e.add(this.f23645b);
        this.f23648e.add(this.f23646c);
        this.f23648e.add(this.f23647d);
        hTypeListView.addAdapters(this.f23648e);
    }

    public void a(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
            this.f23644a.i0(onClickListener);
        }
    }

    public void b(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onClickListener) == null) {
            this.f23646c.i0(onClickListener);
        }
    }
}
