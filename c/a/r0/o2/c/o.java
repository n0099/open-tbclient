package c.a.r0.o2.c;

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
    public f f23084a;

    /* renamed from: b  reason: collision with root package name */
    public l f23085b;

    /* renamed from: c  reason: collision with root package name */
    public g f23086c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.r0.l2.g.a f23087d;

    /* renamed from: e  reason: collision with root package name */
    public List<c.a.e.l.e.a> f23088e;

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
        this.f23088e = new ArrayList();
        this.f23084a = new f(tbPageContext, c.a.r0.o2.e.o.f23253g);
        this.f23085b = new l(tbPageContext);
        this.f23086c = new g(tbPageContext, c.a.r0.o2.e.h.f23230g);
        this.f23087d = new c.a.r0.l2.g.a(tbPageContext.getPageActivity(), c.a.r0.l2.d.f22074h);
        this.f23088e.add(this.f23084a);
        this.f23088e.add(this.f23085b);
        this.f23088e.add(this.f23086c);
        this.f23088e.add(this.f23087d);
        hTypeListView.addAdapters(this.f23088e);
    }

    public void a(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
            this.f23084a.j0(onClickListener);
        }
    }

    public void b(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onClickListener) == null) {
            this.f23086c.j0(onClickListener);
        }
    }
}
