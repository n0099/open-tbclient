package c.a.p0.n2.c;

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
    public f f22157a;

    /* renamed from: b  reason: collision with root package name */
    public l f22158b;

    /* renamed from: c  reason: collision with root package name */
    public g f22159c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.p0.k2.g.a f22160d;

    /* renamed from: e  reason: collision with root package name */
    public List<c.a.e.k.e.a> f22161e;

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
        this.f22161e = new ArrayList();
        this.f22157a = new f(tbPageContext, c.a.p0.n2.e.o.f22326g);
        this.f22158b = new l(tbPageContext);
        this.f22159c = new g(tbPageContext, c.a.p0.n2.e.h.f22303g);
        this.f22160d = new c.a.p0.k2.g.a(tbPageContext.getPageActivity(), c.a.p0.k2.d.f21150h);
        this.f22161e.add(this.f22157a);
        this.f22161e.add(this.f22158b);
        this.f22161e.add(this.f22159c);
        this.f22161e.add(this.f22160d);
        hTypeListView.addAdapters(this.f22161e);
    }

    public void a(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
            this.f22157a.j0(onClickListener);
        }
    }

    public void b(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onClickListener) == null) {
            this.f22159c.j0(onClickListener);
        }
    }
}
