package c.a.r0.v2.c;

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
/* loaded from: classes7.dex */
public class o {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public f a;

    /* renamed from: b  reason: collision with root package name */
    public l f24674b;

    /* renamed from: c  reason: collision with root package name */
    public g f24675c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.r0.s2.g.a f24676d;

    /* renamed from: e  reason: collision with root package name */
    public List<c.a.d.m.e.a> f24677e;

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
        this.f24677e = new ArrayList();
        this.a = new f(tbPageContext, c.a.r0.v2.e.o.f24822g);
        this.f24674b = new l(tbPageContext);
        this.f24675c = new g(tbPageContext, c.a.r0.v2.e.h.f24800g);
        this.f24676d = new c.a.r0.s2.g.a(tbPageContext.getPageActivity(), c.a.r0.s2.d.f23468h);
        this.f24677e.add(this.a);
        this.f24677e.add(this.f24674b);
        this.f24677e.add(this.f24675c);
        this.f24677e.add(this.f24676d);
        hTypeListView.addAdapters(this.f24677e);
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
            this.f24675c.i0(onClickListener);
        }
    }
}
